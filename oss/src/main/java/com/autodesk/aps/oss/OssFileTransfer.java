package com.autodesk.aps.oss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.hc.core5.http.ClassicHttpResponse;

import com.autodesk.aps.oss.api.ObjectsApi;
import com.autodesk.aps.oss.model.Completes3uploadBody;
import com.autodesk.aps.oss.model.DownloadStatus;
import com.autodesk.aps.oss.model.ObjectDetails;
import com.autodesk.aps.oss.model.Signeds3downloadResponse;
import com.autodesk.aps.oss.model.Signeds3uploadResponse;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.IApsLogger;
import com.autodesk.aps.sdkmanager.IAuthenticationProvider;
import com.autodesk.aps.sdkmanager.SdkManager;

class Constants {
    public static final int MaxRetry = 5;
    public static final long ChunkSize = 5L * 1024 * 1024; // 5 MB
    public static final int BatchSize = 25;
    public static final String accessTokenExpiredMessage = "Access token provided is invalid or expired.";
}

public class OssFileTransfer {
    private IApsLogger logger;
    private FileTransferConfigurations configuration;
    private ObjectsApi objectsApi;
    private IAuthenticationProvider authProvider;

    private int maxRetryOnTokenExpiry;
    private int maxChunkCountAllowed;
    private int maxRetryOnUrlExpiry;
    private String accessToken;

    public OssFileTransfer(FileTransferConfigurations configuration,
            SdkManager sdkManager) {
        this(configuration, sdkManager, null);
    }

    public OssFileTransfer(FileTransferConfigurations configuration,
            SdkManager sdkManager,
            IAuthenticationProvider authenticationProvider) {
        this.configuration = configuration;
        this.logger = sdkManager.getLogger();
        this.objectsApi = new ObjectsApi(sdkManager);

        this.maxChunkCountAllowed = configuration.getMaxChunkCountAllowed();
        this.maxRetryOnUrlExpiry = configuration.getMaxRetryOnUrlExpiry();
        this.maxRetryOnTokenExpiry = configuration.getMaxRetryOnTokenExpiry();

        if (authenticationProvider != null) {
            this.authProvider = authenticationProvider;
        }
    }

    public ApiResponse<ObjectDetails> upload(
            String bucketKey,
            String objectKey,
            InputStream sourceToUpload,
            Long inputStreamLength,
            String accessToken,
            String requestIdPrefix,
            ProgressCallback onProgress,
            String xAdsMetaContentType,
            String xAdsMetaContentDisposition,
            String xAdsMetaContentEncoding,
            String xAdsMetaCacheControl)
            throws OssApiException {
        String requestId = handleRequestId(requestIdPrefix, bucketKey, objectKey);
        long fileSize = inputStreamLength != null ? inputStreamLength : calculateInputStreamLength(sourceToUpload);
        this.accessToken = accessToken;
        int retryCount = this.configuration.getRetryCount();

        this.logger.debug(requestId + " Config retry setting was: " + retryCount);

        validateFileSize(requestId, fileSize);

        if (onProgress != null) {
            onProgress.onProgress(1);
        }

        long numberOfChunks = calculateNumberOfChunks(fileSize);
        int chunksUploaded = 0;
        List<String> uploadUrls = new ArrayList<>();
        String uploadKey = null;
        if (fileSize == 0) {
            throw new OssApiException("Input stream/file is empty. Nothing to upload.");
        }
        try (InputStream fis = sourceToUpload) {
            byte[] chunkBuffer = new byte[(int) Constants.ChunkSize];
            int bytesRead;
            while ((bytesRead = readChunk(fis, chunkBuffer)) != -1 && chunksUploaded < numberOfChunks) {
                int attempts = 0;
                int retryUrlExpiryCount = 0;

                while (true) {
                    attempts++;
                    logger.info(requestId + " Uploading part " + chunksUploaded + ", attempt " + attempts);

                    if (uploadUrls.isEmpty()) {
                        retryUrlExpiryCount++;
                        Signeds3uploadResponse uploadUrlsResponse = getUploadUrlsWithRetry(
                                bucketKey, objectKey, numberOfChunks, chunksUploaded, uploadKey, requestId);
                        uploadKey = uploadUrlsResponse.getUploadKey();
                        uploadUrls = uploadUrlsResponse.getUrls();
                    }

                    String currentUrl = uploadUrls.remove(0);
                    logger.info(currentUrl);
                    try {
                        byte[] dataToUpload = (bytesRead < chunkBuffer.length)
                                ? Arrays.copyOf(chunkBuffer, bytesRead)
                                : chunkBuffer;

                        ClassicHttpResponse response = uploadToURL(currentUrl, dataToUpload, requestId);

                        int statusCode = response.getCode();

                        if (statusCode == 403 && retryUrlExpiryCount == maxRetryOnUrlExpiry) {
                            logger.info(requestId + " URL cannot be refreshed.");
                            throw new OssApiException(statusCode + " URL cannot be refreshed");
                        }
                        if (statusCode == 403) {
                            logger.info(requestId + " 403, refreshing urls, attempt: " +
                                    retryUrlExpiryCount);
                            uploadUrls.clear();
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        logger.error(requestId + " Error uploading chunk, attempt " + attempts, e);
                        if (attempts == Constants.MaxRetry) {
                            logger.error(requestId + " Couldn't upload chunk after max retry of " + Constants.MaxRetry);
                            throw new OssApiException(requestId + " " + e.getMessage());
                        }
                    }
                }
                chunksUploaded++;
                if (onProgress != null) {
                    int percentCompleted = (int) (((double) chunksUploaded / numberOfChunks) * 100);
                    onProgress.onProgress(percentCompleted);
                }
                logger.info(requestId + " Number of chunks uploaded: " + chunksUploaded);
            }
        } catch (IOException e) {
            logger.error(requestId + " Error reading file: " + e.getMessage());
            throw new OssApiException(requestId + " " + e.getMessage());
        }
        Completes3uploadBody completes3uploadBody = new Completes3uploadBody();
        completes3uploadBody.setUploadKey(uploadKey);
        ApiResponse<ObjectDetails> completeResponse = objectsApi.completeSignedS3Upload(bucketKey, objectKey,
                "application/json",
                completes3uploadBody, xAdsMetaContentType, xAdsMetaContentDisposition, xAdsMetaContentEncoding,
                xAdsMetaCacheControl, null, this.accessToken);
        if (onProgress != null)
            onProgress.onProgress(100);
        return completeResponse;
    }

    private Signeds3uploadResponse getUploadUrlsWithRetry(
            String bucketKey, String objectKey, long numberOfChunks, int chunksUploaded, String uploadKey,
            String requestId) {
        int attemptCount = 0;
        int firstPart = chunksUploaded + 1;
        while (attemptCount < Constants.MaxRetry) {
            try {
                logger.info(requestId + " Refreshing URL attempt: " + attemptCount);
                return this.objectsApi.signedS3Upload(bucketKey, objectKey, (int) numberOfChunks, firstPart,
                        uploadKey, null, null, this.accessToken).getData();
            } catch (Exception e) {
                if (e.getMessage().contains(Constants.accessTokenExpiredMessage)) {
                    attemptCount++;
                    this.accessToken = this.authProvider.getAccessToken();
                    logger.info(requestId + " Token expired. Trying to refresh.");
                } else {
                    logger.error(requestId + " Error: " + e.getMessage());
                    throw new OssApiException(e.getMessage());
                }
            }
        }
        throw new OssApiException(requestId + " Failed to get upload URLs after maximum retries.");
    }

    private int readChunk(InputStream in, byte[] buffer) throws IOException {
        int totalBytesRead = 0;
        int bytesRead;
        while (totalBytesRead < buffer.length
                && (bytesRead = in.read(buffer, totalBytesRead, buffer.length - totalBytesRead)) != -1) {
            totalBytesRead += bytesRead;
        }
        return totalBytesRead == 0 ? -1 : totalBytesRead;
    }

    private long calculateInputStreamLength(InputStream inputStream) throws OssApiException {

        long totalBytes = 0;
        byte[] buffer = new byte[(int) Constants.ChunkSize];
        int bytesRead;

        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }
            if (inputStream.markSupported()) {
                inputStream.reset();
            } else {
                throw new OssApiException(
                        "InputStream does not support mark/reset. Please provide a stream that supports mark/reset or specify the length parameter.");
            }
        } catch (IOException e) {
            throw new OssApiException("Error calculating input stream length: " + e.getMessage());
        }
        return totalBytes;
    }

    private ClassicHttpResponse uploadToURL(String url, byte[] chunk, String requestId) throws IOException {
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        localVarHeaderParams.put("x-ads-request-id", requestId);
        localVarHeaderParams.put("Content-Type", "application/octet-stream");
        try {
            ClassicHttpResponse response = objectsApi.invokeGenericAPI(
                    url,
                    "Put",
                    null,
                    chunk,
                    localVarHeaderParams,
                    null);
            return response;
        } catch (OssApiException e) {
            throw e;
        }
    }

    private String handleRequestId(String parentRequestId, String bucketKey, String objectKey) {
        String requestId = (parentRequestId != null && !parentRequestId.isEmpty()) ? parentRequestId
                : java.util.UUID.randomUUID().toString();
        requestId = requestId + ":" + generateSdkRequestId(bucketKey, objectKey);
        return requestId;
    }

    private String generateSdkRequestId(String bucketKey, String objectKey) {
        return java.net.URLEncoder.encode(bucketKey + "/" + objectKey, StandardCharsets.UTF_8);
    }

    private long calculateNumberOfChunks(long fileSize) {
        if (fileSize == 0) {
            return 1;
        }
        long numberOfChunks = fileSize / Constants.ChunkSize;

        if (fileSize % Constants.ChunkSize != 0) {
            numberOfChunks++;
        }
        return numberOfChunks;
    }

    private void validateFileSize(String requestId, long fileSize) {
        long numberOfChunks = calculateNumberOfChunks(fileSize);
        if (numberOfChunks > this.maxChunkCountAllowed) {
            throw new OssApiException(requestId + " File size too big to upload. Max allowed size is "
                    + (this.maxChunkCountAllowed * Constants.ChunkSize) + " bytes.");
        }
    }

    public InputStream download(String bucketKey, String objectKey, String accessToken,
            Path filePath, AtomicBoolean isCancelled,
            String requestIdPrefix, ProgressCallback onProgress) throws IOException {

        String requestId = handleRequestId(requestIdPrefix, bucketKey, objectKey);

        Signeds3downloadResponse response = getS3SignedDownloadUrlWithRetry(bucketKey, objectKey, accessToken,
                requestId);
        long fileSize = response.getSize();
        long numberOfChunks = calculateNumberOfChunks(fileSize);

        if (onProgress != null) {
            onProgress.onProgress(1);
        }
        long start = 0;
        int partsDownloaded = 0;

        if (filePath != null) {
            try (OutputStream outputStream = Files.newOutputStream(filePath, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)) {
                downloadToStream(outputStream, response.getUrl(), fileSize, numberOfChunks, start, partsDownloaded,
                        isCancelled, requestId, onProgress);
                return null;
            }
        } else {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            downloadToStream(outputStream, response.getUrl(), fileSize, numberOfChunks, start, partsDownloaded,
                    isCancelled, requestId, onProgress);
            return new ByteArrayInputStream(outputStream.toByteArray());
        }
    }

    private void downloadToStream(OutputStream outputStream, String url, long fileSize, long numberOfChunks,
            long start, int partsDownloaded, AtomicBoolean isCancelled, String requestId, ProgressCallback onProgress)
            throws IOException {
        try {
            while (partsDownloaded < numberOfChunks) {
                if (isCancelled != null && isCancelled.get()) {
                    logger.info(requestId + " Download cancelled by user.");
                    throw new OssApiException(requestId + " Download cancelled by user.");
                }

                logger.info(requestId + " Downloading part: " + partsDownloaded);
                long end = Math.min((partsDownloaded + 1) * Constants.ChunkSize, fileSize);

                if (start >= end) {
                    break;
                }

                int attemptCount = 0;
                while (attemptCount < maxRetryOnUrlExpiry) {
                    try {
                        attemptCount++;
                        logger.debug(requestId + " Downloading file range: " + start + "-" + end);

                        try (InputStream chunkStream = downloadChunk(url, start, end, requestId)) {
                            chunkStream.transferTo(outputStream);
                        }

                        start = end;
                        partsDownloaded++;
                        int percentCompleted = (int) (((double) partsDownloaded / numberOfChunks) * 100);
                        if (onProgress != null)
                            onProgress.onProgress(percentCompleted);
                        break;
                    } catch (Exception e) {
                        logger.error(requestId + " Error downloading part: " + partsDownloaded +
                                ". Attempt " + attemptCount + "/" + maxRetryOnUrlExpiry +
                                ". Error: " + e.getMessage());

                        if (attemptCount == maxRetryOnUrlExpiry) {
                            throw new OssApiException(requestId + " Failed to download part after "
                                    + maxRetryOnUrlExpiry + " attempts: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new OssApiException(e.getMessage());
        }
    }

    private InputStream downloadChunk(String url, long start, long end, String requestId) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Range", "bytes=" + start + "-" + (end - 1)); // end - 1 since HTTP ranges are inclusive
        headers.put("x-ads-request-id", requestId);

        ClassicHttpResponse response = objectsApi.invokeGenericAPI(
                url,
                "GET",
                null,
                null,
                headers,
                null);
        return response.getEntity().getContent();
    }

    private Signeds3downloadResponse getS3SignedDownloadUrlWithRetry(String bucketKey, String objectKey,
            String accessToken, String requestId) {
        int attemptCount = 0;

        do {
            logger.info(requestId + " Get signed URL to download directly from S3 attempt: " + attemptCount);

            try {
                ApiResponse<Signeds3downloadResponse> response = objectsApi.signedS3Download(
                        bucketKey,
                        objectKey,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        accessToken);

                Signeds3downloadResponse signeds3downloadResponse = response.getData();

                if (!signeds3downloadResponse.getStatus().equals(DownloadStatus.COMPLETE)) {
                    logger.error(requestId + " File not available for download yet.");
                    throw new OssApiException(requestId + " File not available for download yet.");
                }

                return signeds3downloadResponse;
            } catch (Exception e) {
                if (e.getMessage().contains(Constants.accessTokenExpiredMessage)) {
                    attemptCount++;
                    accessToken = this.authProvider.getAccessToken();
                    logger.info(requestId + " Token expired. Trying to refresh");
                } else {
                    logger.error(requestId + " Error: " + e.getMessage());
                    throw new OssApiException(e.getMessage());
                }
            }
        } while (attemptCount < maxRetryOnTokenExpiry);

        throw new OssApiException(requestId + " Failed to get download urls after maximum retry.");
    }

    public CompletableFuture<InputStream> downloadAsync(String bucketKey, String objectKey, String accessToken,
            Path filePath, AtomicBoolean isCancelled,
            String requestIdPrefix, ProgressCallback onProgress) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return download(bucketKey, objectKey, accessToken, filePath, isCancelled, requestIdPrefix, onProgress);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }
}