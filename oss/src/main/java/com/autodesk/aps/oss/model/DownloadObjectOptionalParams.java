package com.autodesk.aps.oss.model;

import java.util.concurrent.atomic.AtomicBoolean;

import com.autodesk.aps.oss.ProgressCallback;

/**
 * Represents optional parameters for the `downloadObject` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class DownloadObjectOptionalParams {
    private String requestIdPrefix;
    private ProgressCallback progressCallback;
    private AtomicBoolean isCancelled;
    private String accessToken;

    private DownloadObjectOptionalParams(Builder builder) {
        this.requestIdPrefix = builder.requestIdPrefix;
        this.progressCallback = builder.progressCallback;
        this.isCancelled = builder.isCancelled;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of DownloadObjectOptionalParams.
     */
    public static class Builder {
        private String requestIdPrefix;
        private ProgressCallback progressCallback;
        private AtomicBoolean isCancelled;
        private String accessToken;

        /**
         * @param requestIdPrefix A prefix to be used in the request ID to help identify the request
         * @return The Builder instance for chaining.
         */
        public Builder requestIdPrefix(String requestIdPrefix) {
            this.requestIdPrefix = requestIdPrefix;
            return this;
        }

        /**
         * @param progressCallback Callback to track download progress
         * @return The Builder instance for chaining.
         */
        public Builder progressCallback(ProgressCallback progressCallback) {
            this.progressCallback = progressCallback;
            return this;
        }

        /**
         * @param isCancelled AtomicBoolean flag to control cancellation of the download
         * @return The Builder instance for chaining.
         */
        public Builder isCancelled(AtomicBoolean isCancelled) {
            this.isCancelled = isCancelled;
            return this;
        }

        /**
         * @param accessToken The access token string.
         * @return The Builder instance for chaining.
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Builds and returns an instance of DownloadObjectOptionalParams.
         * 
         * @return DownloadObjectOptionalParams object.
         */
        public DownloadObjectOptionalParams build() {
            return new DownloadObjectOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the requestIdPrefix value.
     * @return String
     */
    public String getRequestIdPrefix() {
        return requestIdPrefix;
    }

    /**
     * Gets the progressCallback value.
     * @return ProgressCallback
     */
    public ProgressCallback getProgressCallback() {
        return progressCallback;
    }

    /**
     * Gets the isCancelled value.
     * @return AtomicBoolean
     */
    public AtomicBoolean getIsCancelled() {
        return isCancelled;
    }

    /**
     * Gets the access token for authentication.
     * @return String
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token for authentication.
     * @param accessToken The access token string.
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
} 