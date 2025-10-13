package com.autodesk.aps.samples;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.event.Level;

import com.autodesk.aps.oss.OssClient;
import com.autodesk.aps.oss.model.BatchCompleteUploadOptionalParams;
import com.autodesk.aps.oss.model.BatchSignedS3DownloadOptionalParams;
import com.autodesk.aps.oss.model.BatchSignedS3UploadOptionalParams;
import com.autodesk.aps.oss.model.Batchsigneds3downloadObject;
import com.autodesk.aps.oss.model.CompleteSignedS3UploadOptionalParams;
import com.autodesk.aps.oss.model.Completes3uploadBody;
import com.autodesk.aps.oss.model.CopyToOptionalParams;
import com.autodesk.aps.oss.model.CreateBucketOptionalParams;
import com.autodesk.aps.oss.model.CreateBucketsPayload;
import com.autodesk.aps.oss.model.CreateSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.DeleteBucketOptionalParams;
import com.autodesk.aps.oss.model.DeleteSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.DownloadObjectOptionalParams;
import com.autodesk.aps.oss.model.GetBucketDetailsOptionalParams;
import com.autodesk.aps.oss.model.GetBucketsOptionalParams;
import com.autodesk.aps.oss.model.GetObjectsOptionalParams;
import com.autodesk.aps.oss.model.GetSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.ObjectDetails;
import com.autodesk.aps.oss.model.PolicyKey;
import com.autodesk.aps.oss.model.Region;
import com.autodesk.aps.oss.model.SignedS3DownloadOptionalParams;
import com.autodesk.aps.oss.model.SignedS3UploadOptionalParams;
import com.autodesk.aps.oss.model.UploadObjectOptionalParams;
import com.autodesk.aps.oss.model.UploadSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.UploadSignedResourcesChunkOptionalParams;
import com.autodesk.aps.sdkmanager.ApsLogger;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;
import com.autodesk.aps.sdkmanager.StaticAuthenticationProvider;

import io.github.cdimascio.dotenv.Dotenv;

public class OssSample {
    private OssClient ossClient;
    Dotenv dotenv = Dotenv.load();
    private final String bucketKey = dotenv.get("BUCKET_KEY");
    private final String objectKey = dotenv.get("OBJECT_KEY");
    private final String newObjectKey = dotenv.get("NEW_OBJECT_KEY");
    private final String hash = dotenv.get("HASH");
    private final java.io.File file = new java.io.File(dotenv.get("FILE_PATH"));
    private byte[] bytes;
    private final String token = dotenv.get("ACCESS_TOKEN");

    public void Initialize() {
        StaticAuthenticationProvider staticAuthenticationProvider = new StaticAuthenticationProvider(token);
        SdkManager sdkManager = SdkManagerBuilder.create()
                .addLogger(new ApsLogger(Level.INFO))
                .build();
        ossClient = new OssClient(sdkManager, staticAuthenticationProvider);
    }

    public void getBucketDetails() {
        try {
            var bucket = ossClient.getBucketDetails(bucketKey);
            System.out.println("Bucket details: " + bucket);
            
            // With optional parameters
            var optionalParams = new GetBucketDetailsOptionalParams.Builder()
            .accessToken("access-token").build();
            var bucketOpt = ossClient.getBucketDetails(bucketKey, optionalParams);
            System.out.println("Bucket details (optional): " + bucketOpt);
        } catch (Exception e) {
            System.out.println("Error in getBucketDetails: " + e.getMessage());
        }
    }

    public void createBucket() {
        try {
            var payload = new CreateBucketsPayload();
            payload.setBucketKey(bucketKey);
            payload.setPolicyKey(PolicyKey.TRANSIENT);
            var region = Region.US;
            var bucket = ossClient.createBucket(region, payload);
            System.out.println("Created bucket: " + bucket);
            
            // With optional parameters
            var optionalParams = new CreateBucketOptionalParams.Builder()
                    .accessToken("access-token").build();
            var bucketOpt = ossClient.createBucket(region, payload, optionalParams);
            System.out.println("Created bucket (optional): " + bucketOpt);
        } catch (Exception e) {
            System.out.println("Error in createBucket: " + e.getMessage());
        }
    }

    public void getBuckets() {
        try {
            var buckets = ossClient.getBuckets();
            System.out.println("Buckets: " + buckets);
            
            // With optional parameters
            var optionalParams = new GetBucketsOptionalParams.Builder()
                    .region(Region.US)
                    // .limit(1)
                    // .startAt("bucketKey")
                    .build();
            var bucketsOpt = ossClient.getBuckets(optionalParams);
            System.out.println("Buckets (optional): " + bucketsOpt);
        } catch (Exception e) {
            System.out.println("Error in getBuckets: " + e.getMessage());
        }
    }

    public void deleteBucket() {
        try {
            ossClient.deleteBucket(bucketKey);
            System.out.println("Deleted bucket: " + bucketKey);
            
            // With optional parameters
            var optionalParams = new DeleteBucketOptionalParams.Builder()
                    .accessToken("access-token").build();
            ossClient.deleteBucket(bucketKey, optionalParams);
            System.out.println("Deleted bucket (optional): " + bucketKey);
        } catch (Exception e) {
            System.out.println("Error in deleteBucket: " + e.getMessage());
        }
    }

    public void getObjects() {
        try {
            var objects = ossClient.getObjects(bucketKey);
            System.out.println("Objects: " + objects);
            
            // With optional parameters
            var optionalParams = new
            GetObjectsOptionalParams.Builder().limit(10).beginsWith("racbasic").build();
            var objectsOpt = ossClient.getObjects(bucketKey, optionalParams);
            System.out.println("Objects (optional): " + objectsOpt);
        } catch (Exception e) {
            System.out.println("Error in getObjects: " + e.getMessage());
        }
    }

    public void getObjectDetails() {
        try {
            var details = ossClient.getObjectDetails(bucketKey, objectKey);
            System.out.println("Object details: " + details);
            
            // With optional parameters
            // var optionalParams = new
            // GetObjectDetailsOptionalParams.Builder().ifModifiedSince(LocalDateTime.now())
            // .build();

            // System.out.println("ifModifiedSince zone: " +
            // optionalParams.getIfModifiedSince());

            // var detailsOpt = ossClient.getObjectDetails(bucketKey, objectKey,
            // optionalParams);
            // System.out.println("Object details (optional): " + detailsOpt);
        } catch (Exception e) {
            System.out.println("Error in getObjectDetails: " + e.getMessage());
        }
    }

    public void deleteObject() {
        try {
            ossClient.deleteObject(bucketKey, objectKey);
            System.out.println("Deleted object: " + objectKey);
            
            // With optional parameters
            // var optionalParams = new DeleteObjectOptionalParams.Builder()
            // .accessToken("access-token").build();
            // ossClient.deleteObject(bucketKey, objectKey, optionalParams);
            // System.out.println("Deleted object (optional): " + objectKey);
        } catch (Exception e) {
            System.out.println("Error in deleteObject: " + e.getMessage());
        }
    }

    public void copyTo() {
        try {
            var details = ossClient.copyTo(bucketKey, objectKey, newObjectKey, new CopyToOptionalParams.Builder()
                    .accessToken(token).build());
            System.out.println("Copied object: " + details);
            
            // With optional parameters
            // var optionalParams = new CopyToOptionalParams.Builder()
            // .accessToken("access-token").build();
            // var detailsOpt = ossClient.copyTo(bucketKey, objectKey, newObjectKey,
            // optionalParams);
            // System.out.println("Copied object (optional): " + detailsOpt);
        } catch (Exception e) {
            System.out.println("Error in copyTo: " + e.getMessage());
        }
    }

    public void batchCompleteUpload() {
        try {
            var response = ossClient.batchCompleteUpload(bucketKey);
            System.out.println("Batch complete upload response: " + response);
            
            // With optional parameters
            var optionalParams = new BatchCompleteUploadOptionalParams.Builder()
                    .accessToken("access-token").build();
            var responseOpt = ossClient.batchCompleteUpload(bucketKey, optionalParams);
            System.out.println("Batch complete upload response (optional): " + responseOpt);
        } catch (Exception e) {
            System.out.println("Error in batchCompleteUpload: " + e.getMessage());
        }
    }

    public void batchSignedS3Download() {
        try {
            var batchObj = new Batchsigneds3downloadObject();
            var response = ossClient.batchSignedS3Download(bucketKey, batchObj);
            System.out.println("Batch signed S3 download response: " + response);
            
            // With optional parameters
            var optionalParams = new BatchSignedS3DownloadOptionalParams.Builder()
                    .accessToken("access-token").minutesExpiration(5).build();
            var responseOpt = ossClient.batchSignedS3Download(bucketKey, batchObj, optionalParams);
            System.out.println("Batch signed S3 download response (optional): " + responseOpt);
        } catch (Exception e) {
            System.out.println("Error in batchSignedS3Download: " + e.getMessage());
        }
    }

    public void batchSignedS3Upload() {
        try {
            var response = ossClient.batchSignedS3Upload(bucketKey);
            System.out.println("Batch signed S3 upload response: " + response);
            
            // With optional parameters
            var optionalParams = new BatchSignedS3UploadOptionalParams.Builder()
                    .accessToken("access-token").minutesExpiration(5).build();
            var responseOpt = ossClient.batchSignedS3Upload(bucketKey, optionalParams);
            System.out.println("Batch signed S3 upload response (optional): " + responseOpt);
        } catch (Exception e) {
            System.out.println("Error in batchSignedS3Upload: " + e.getMessage());
        }
    }

    public void completeSignedS3Upload() {
        try {
            var body = new Completes3uploadBody();
            ossClient.completeSignedS3Upload(bucketKey, objectKey, "application/json", body);
            System.out.println("Completed signed S3 upload.");
            
            // With optional parameters
            var optionalParams = new CompleteSignedS3UploadOptionalParams.Builder()
                    .accessToken("access-token").build();
            ossClient.completeSignedS3Upload(bucketKey, objectKey, "application/json", body, optionalParams);
            System.out.println("Completed signed S3 upload (optional).");
        } catch (Exception e) {
            System.out.println("Error in completeSignedS3Upload: " + e.getMessage());
        }
    }

    public void createSignedResource() {
        try {
            var signed = ossClient.createSignedResource(bucketKey, objectKey);
            System.out.println("Created signed resource: " + signed);
            
            // With optional parameters
            CreateSignedResourceOptionalParams optionalParams = new CreateSignedResourceOptionalParams.Builder()
                    .accessToken("access-token").build();
            var signedOpt = ossClient.createSignedResource(bucketKey, objectKey, optionalParams);
            System.out.println("Created signed resource (optional): " + signedOpt);
        } catch (Exception e) {
            System.out.println("Error in createSignedResource: " + e.getMessage());
        }
    }

    public void deleteSignedResource() {
        try {
            ossClient.deleteSignedResource(hash);
            System.out.println("Deleted signed resource: " + hash);
            
            // With optional parameters
            DeleteSignedResourceOptionalParams optionalParams = new DeleteSignedResourceOptionalParams.Builder()
                    .accessToken("access-token").build();
            ossClient.deleteSignedResource(hash, optionalParams);
            System.out.println("Deleted signed resource (optional): " + hash);
        } catch (Exception e) {
            System.out.println("Error in deleteSignedResource: " + e.getMessage());
        }
    }

    public void getSignedResource() {
        try {
            var file = ossClient.getSignedResource(hash);
            System.out.println("Got signed resource file: " + file);
            
            // With optional parameters
            GetSignedResourceOptionalParams optionalParams = new GetSignedResourceOptionalParams.Builder()
                    .accessToken("access-token").build();
            var fileOpt = ossClient.getSignedResource(hash, optionalParams);
            System.out.println("Got signed resource file (optional): " + fileOpt);
        } catch (Exception e) {
            System.out.println("Error in getSignedResource: " + e.getMessage());
        }
    }

    public void signedS3Download() {
        try {
            var response = ossClient.signedS3Download(bucketKey, objectKey);
            System.out.println("Signed S3 download response: " + response);
            
            // With optional parameters
            SignedS3DownloadOptionalParams optionalParams = new SignedS3DownloadOptionalParams.Builder()
                    .accessToken("access-token").minutesExpiration(5).build();
            var responseOpt = ossClient.signedS3Download(bucketKey, objectKey, optionalParams);
            System.out.println("Signed S3 download response (optional): " + responseOpt);
        } catch (Exception e) {
            System.out.println("Error in signedS3Download: " + e.getMessage());
        }
    }

    public void signedS3Upload() {
        try {
            var response = ossClient.signedS3Upload(bucketKey, objectKey);
            System.out.println("Signed S3 upload response: " + response);
            
            // With optional parameters
            SignedS3UploadOptionalParams optionalParams = new SignedS3UploadOptionalParams.Builder()
                    .accessToken("access-token").minutesExpiration(5).build();
            var responseOpt = ossClient.signedS3Upload(bucketKey, objectKey, optionalParams);
            System.out.println("Signed S3 upload response (optional): " + responseOpt);
        } catch (Exception e) {
            System.out.println("Error in signedS3Upload: " + e.getMessage());
        }
    }

    public void uploadSignedResource() {
        try {
            bytes = java.nio.file.Files.readAllBytes(file.toPath());
            var details = ossClient.uploadSignedResource(hash, (int) file.length(), bytes);
            System.out.println("Uploaded signed resource: " + details);

            // With optional parameters
            UploadSignedResourceOptionalParams optionalParams = new UploadSignedResourceOptionalParams.Builder()
                    .accessToken("access-token").build();
            var detailsOpt = ossClient.uploadSignedResource(hash, (int) file.length(), bytes, optionalParams);
            System.out.println("Uploaded signed resource (optional): " + detailsOpt);
        } catch (Exception e) {
            System.out.println("Error in uploadSignedResource: " + e.getMessage());
        }
    }

    public void uploadSignedResourcesChunk() {
        try {
            bytes = java.nio.file.Files.readAllBytes(file.toPath());
            ObjectDetails chunkDetails = ossClient.uploadSignedResourcesChunk(hash, "bytes=0-9", "session-id", bytes);
            System.out.println("Uploaded signed resources chunk: " + chunkDetails);

            // With optional parameters
            UploadSignedResourcesChunkOptionalParams uploadChunkOptionalParams = new UploadSignedResourcesChunkOptionalParams.Builder()
                    .accessToken(token)
                    .contentType("application/octet-stream")
                    .xAdsRegion(Region.US)
                    .build();
            ObjectDetails chunkDetailsWithOptions = ossClient.uploadSignedResourcesChunk(
                    hash, 
                    "bytes=0-9", 
                    "session-id", 
                    bytes,
                    uploadChunkOptionalParams);
            System.out.println("Uploaded signed resources chunk (optional): " + chunkDetailsWithOptions);
        } catch (Exception e) {
            System.out.println("Error in uploadSignedResourcesChunk: " + e.getMessage());
        }
    }

    public void uploadObjectFile() {
        try {
            ObjectDetails uploadResponse = ossClient.uploadObject(bucketKey, objectKey, file);
            System.out.println("Uploaded object (file): " + uploadResponse);

            // With optional parameters
            UploadObjectOptionalParams uploadOptionalParams = new UploadObjectOptionalParams.Builder()
                    .accessToken(token)
                    .requestIdPrefix("file_upload")
                    .progressCallback(progress -> System.out.println("Upload progress: " + progress + "%"))
                    .build();
            ObjectDetails uploadResponseWithOptions = ossClient.uploadObject(bucketKey, objectKey, file, uploadOptionalParams);
            System.out.println("Uploaded object with options (file): " + uploadResponseWithOptions);
        } catch (Exception e) {
            System.out.println("Error in uploadObjectFile: " + e.getMessage());
        }
    }

    public void uploadObjectBytes() {
        try {
            bytes = java.nio.file.Files.readAllBytes(file.toPath());
            ObjectDetails uploadResponse = ossClient.uploadObject(bucketKey, objectKey, bytes);
            System.out.println("Uploaded object: " + uploadResponse);

            // With optional parameters
            UploadObjectOptionalParams uploadOptionalParams = new UploadObjectOptionalParams.Builder()
                    .accessToken(token)
                    .requestIdPrefix("bytes_upload")
                    .progressCallback(progress -> System.out.println("Upload progress: " + progress + "%"))
                    .build();
            ObjectDetails uploadResponseWithOptions = ossClient.uploadObject(bucketKey, objectKey, bytes, uploadOptionalParams);
            System.out.println("Uploaded object with options: " + uploadResponseWithOptions);
        } catch (Exception e) {
            System.out.println("Error in uploadObjectBytes: " + e.getMessage());
        }
    }

    public void uploadObjectStream() {
        try {
            bytes = java.nio.file.Files.readAllBytes(file.toPath());
            java.io.InputStream stream = new java.io.ByteArrayInputStream(bytes);

            ossClient.uploadObject(bucketKey, objectKey, stream);
            System.out.println("Uploaded object from stream");

            // With optional parameters
            stream = new java.io.ByteArrayInputStream(bytes); // Reset stream
            UploadObjectOptionalParams uploadOptionalParams = new UploadObjectOptionalParams.Builder()
                    .accessToken(token)
                    .requestIdPrefix("stream_upload")
                    .progressCallback(progress -> System.out.println("Upload progress: " + progress + "%"))
                    .build();
            ossClient.uploadObject(bucketKey, objectKey, stream, uploadOptionalParams);
            System.out.println("Uploaded object from stream with options");
        } catch (Exception e) {
            System.out.println("Error in uploadObjectStream: " + e.getMessage());
        }
    }

    public void downloadObjectToFile() {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("downloaded.txt");
            ossClient.downloadObject(bucketKey, objectKey, path);
            System.out.println("Downloaded object to file: " + path);

            // With optional parameters
            DownloadObjectOptionalParams downloadOptionalParams = new DownloadObjectOptionalParams.Builder()
                    .progressCallback(progress -> System.out.println("Download progress: " + progress + "%"))
                    .isCancelled(new AtomicBoolean(false))
                    .build();
            ossClient.downloadObject(bucketKey, objectKey, path, downloadOptionalParams);
            System.out.println("Downloaded object to file with options: " + path);
        } catch (Exception e) {
            System.out.println("Error in downloadObjectToFile: " + e.getMessage());
        }
    }

    public void downloadObjectToMemory() {
        try {
            java.io.InputStream downloadStream = ossClient.downloadObject(bucketKey, objectKey);
            System.out.println("Downloaded object to memory");

            // With optional parameters
            DownloadObjectOptionalParams downloadOptionalParams = new DownloadObjectOptionalParams.Builder()
                    .accessToken(token)
                    .requestIdPrefix("memory_download")
                    .progressCallback(progress -> System.out.println("Download progress: " + progress + "%"))
                    .isCancelled(new AtomicBoolean(false))
                    .build();
            java.io.InputStream downloadStreamWithOptions = ossClient.downloadObject(bucketKey, objectKey, downloadOptionalParams);
            System.out.println("Downloaded object to memory with options");
        } catch (Exception e) {
            System.out.println("Error in downloadObjectToMemory: " + e.getMessage());
        }
    }

    public void close() {
        if (ossClient != null) {
            ossClient.close();
        }
    }

    public static void main(String[] args) {
        OssSample ossSample = new OssSample();
        try {
            ossSample.Initialize();
            ossSample.getBucketDetails();
            // ossSample.createBucket();
            // ossSample.getBuckets();
            // ossSample.deleteBucket();
            // ossSample.getObjects();
            // ossSample.getObjectDetails();
            // ossSample.deleteObject();
            // ossSample.copyTo();
            // ossSample.batchCompleteUpload();
            // ossSample.batchSignedS3Download();
            // ossSample.batchSignedS3Upload();
            // ossSample.completeSignedS3Upload();
            // ossSample.createSignedResource();
            // ossSample.deleteSignedResource();
            // ossSample.getSignedResource();
            // ossSample.signedS3Download();
            // ossSample.signedS3Upload();
            // ossSample.uploadSignedResource();
            // ossSample.uploadSignedResourcesChunk();
            // ossSample.uploadObjectFile();
            // ossSample.uploadObjectBytes();
            // ossSample.uploadObjectStream();
            // ossSample.downloadObjectToFile();
            // ossSample.downloadObjectToMemory();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            ossSample.close();
        }
    }
}
