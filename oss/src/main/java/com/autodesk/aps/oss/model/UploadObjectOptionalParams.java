package com.autodesk.aps.oss.model;

import com.autodesk.aps.oss.ProgressCallback;

/**
 * Represents optional parameters for the `uploadObject` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class UploadObjectOptionalParams {
    private String requestIdPrefix;
    private ProgressCallback progressCallback;
    private String xAdsMetaContentType;
    private String xAdsMetaContentDisposition;
    private String xAdsMetaContentEncoding;
    private String xAdsMetaCacheControl;
    private String accessToken;

    private UploadObjectOptionalParams(Builder builder) {
        this.requestIdPrefix = builder.requestIdPrefix;
        this.progressCallback = builder.progressCallback;
        this.xAdsMetaContentType = builder.xAdsMetaContentType;
        this.xAdsMetaContentDisposition = builder.xAdsMetaContentDisposition;
        this.xAdsMetaContentEncoding = builder.xAdsMetaContentEncoding;
        this.xAdsMetaCacheControl = builder.xAdsMetaCacheControl;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of UploadObjectOptionalParams.
     */
    public static class Builder {
        private String requestIdPrefix;
        private ProgressCallback progressCallback;
        private String xAdsMetaContentType;
        private String xAdsMetaContentDisposition;
        private String xAdsMetaContentEncoding;
        private String xAdsMetaCacheControl;
        private String accessToken;

        /**
         * @param requestIdPrefix A prefix to be used in the request ID to help identify
         *                        the request
         * @return The Builder instance for chaining.
         */
        public Builder requestIdPrefix(String requestIdPrefix) {
            this.requestIdPrefix = requestIdPrefix;
            return this;
        }

        /**
         * @param progressCallback Callback to track upload progress
         * @return The Builder instance for chaining.
         */
        public Builder progressCallback(ProgressCallback progressCallback) {
            this.progressCallback = progressCallback;
            return this;
        }

        /**
         * @param xAdsMetaContentType The content type of the object.
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaContentType(String xAdsMetaContentType) {
            this.xAdsMetaContentType = xAdsMetaContentType;
            return this;
        }

        /**
         * @param xAdsMetaContentDisposition The content disposition of the object.
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaContentDisposition(String xAdsMetaContentDisposition) {
            this.xAdsMetaContentDisposition = xAdsMetaContentDisposition;
            return this;
        }

        /**
         * @param xAdsMetaContentEncoding The content encoding of the object.
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaContentEncoding(String xAdsMetaContentEncoding) {
            this.xAdsMetaContentEncoding = xAdsMetaContentEncoding;
            return this;
        }

        /**
         * @param xAdsMetaCacheControl The cache control directive for the object.
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaCacheControl(String xAdsMetaCacheControl) {
            this.xAdsMetaCacheControl = xAdsMetaCacheControl;
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
         * Builds and returns an instance of UploadObjectOptionalParams.
         * 
         * @return UploadObjectOptionalParams object.
         */
        public UploadObjectOptionalParams build() {
            return new UploadObjectOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the requestIdPrefix value.
     * 
     * @return String
     */
    public String getRequestIdPrefix() {
        return requestIdPrefix;
    }

    /**
     * Gets the progressCallback value.
     * 
     * @return ProgressCallback
     */
    public ProgressCallback getProgressCallback() {
        return progressCallback;
    }

    /**
     * Gets the content type metadata for the object.
     * 
     * @return String
     */
    public String getXAdsMetaContentType() {
        return xAdsMetaContentType;
    }

    /**
     * Gets the content disposition metadata for the object.
     * 
     * @return String
     */
    public String getXAdsMetaContentDisposition() {
        return xAdsMetaContentDisposition;
    }

    /**
     * Gets the content encoding metadata for the object.
     * 
     * @return String
     */
    public String getXAdsMetaContentEncoding() {
        return xAdsMetaContentEncoding;
    }

    /**
     * Gets the cache control metadata for the object.
     * 
     * @return String
     */
    public String getXAdsMetaCacheControl() {
        return xAdsMetaCacheControl;
    }

    /**
     * Gets the access token for authentication.
     * 
     * @return String
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token for authentication.
     * 
     * @param accessToken The access token string.
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}