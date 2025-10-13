package com.autodesk.aps.oss;
public class FileTransferConfigurations {
    private int retryCount;
    private int maxChunkCountAllowed;
    private int maxRetryOnTokenExpiry;
    private int maxRetryOnUrlExpiry;

    private static final int DEFAULT_MAX_CHUNK_COUNT = 10000;
    private static final int DEFAULT_MAX_RETRY_ON_TOKEN_EXPIRY = 2;
    private static final int DEFAULT_MAX_RETRY_ON_URL_EXPIRY = 2;

    public FileTransferConfigurations(int retryCount, int maxChunkCountAllowed, int maxRetryOnTokenExpiry,
                                       int maxRetryOnUrlExpiry) {
        this.retryCount = retryCount;
        this.maxChunkCountAllowed = maxChunkCountAllowed;
        this.maxRetryOnTokenExpiry = maxRetryOnTokenExpiry;
        this.maxRetryOnUrlExpiry = maxRetryOnUrlExpiry;
    }

    public FileTransferConfigurations(int retryCount) {
        this(retryCount, DEFAULT_MAX_CHUNK_COUNT, DEFAULT_MAX_RETRY_ON_TOKEN_EXPIRY, DEFAULT_MAX_RETRY_ON_URL_EXPIRY);
    }

    public int getRetryCount() {
        return retryCount;
    }

    public int getMaxChunkCountAllowed() {
        return maxChunkCountAllowed;
    }

    public int getMaxRetryOnTokenExpiry() {
        return maxRetryOnTokenExpiry;
    }

    public int getMaxRetryOnUrlExpiry() {
        return maxRetryOnUrlExpiry;
    }
}
