/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * oss
 * The Object Storage Service (OSS) allows your application to download and upload raw files (such as PDF, XLS, DWG, or RVT) that are managed by the Data service.
 *
 * Contact: aps.help@autodesk.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.autodesk.aps.oss.model;

import java.time.LocalDateTime;

/**
 * Represents optional parameters for the `signedS3Download` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class SignedS3DownloadOptionalParams {
    private String ifNoneMatch;
    private LocalDateTime ifModifiedSince;
    private String responseContentType;
    private String responseContentDisposition;
    private String responseCacheControl;
    private Boolean publicResourceFallback;
    private Integer minutesExpiration;
    private Boolean useCdn;
    private String accessToken;

    private SignedS3DownloadOptionalParams(Builder builder) {
        this.ifNoneMatch = builder.ifNoneMatch;
        this.ifModifiedSince = builder.ifModifiedSince;
        this.responseContentType = builder.responseContentType;
        this.responseContentDisposition = builder.responseContentDisposition;
        this.responseCacheControl = builder.responseCacheControl;
        this.publicResourceFallback = builder.publicResourceFallback;
        this.minutesExpiration = builder.minutesExpiration;
        this.useCdn = builder.useCdn;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of SignedS3DownloadOptionalParams.
     */
    public static class Builder {
        private String ifNoneMatch;
        private LocalDateTime ifModifiedSince;
        private String responseContentType;
        private String responseContentDisposition;
        private String responseCacheControl;
        private Boolean publicResourceFallback;
        private Integer minutesExpiration;
        private Boolean useCdn;
        private String accessToken;

        /**
         * @param ifNoneMatch The last known ETag value of the object. OSS returns the
         *                    signed URL only if the
         *                    &#x60;&#x60;If-None-Match&#x60;&#x60; header differs from
         *                    the ETag value of the object on S3. If not, it returns a
         *                    304 &quot;Not Modified&quot; HTTP status.
         *
         * @return The Builder instance for chaining.
         */
        public Builder ifNoneMatch(String ifNoneMatch) {
            this.ifNoneMatch = ifNoneMatch;
            return this;
        }

        /**
         * @param ifModifiedSince A timestamp in the HTTP date format (Mon, DD Month
         *                        YYYY HH:MM:SS GMT). The signed URL is returned only if
         *                        the object has been modified since the specified
         *                        timestamp. If not, a 304 (Not Modified) HTTP status is
         *                        returned.
         *
         * @return The Builder instance for chaining.
         */
        public Builder ifModifiedSince(LocalDateTime ifModifiedSince) {
            this.ifModifiedSince = ifModifiedSince;
            return this;
        }

        /**
         * @param responseContentType The value of the Content-Type header you want to
         *                            receive when you download the object using the
         *                            signed URL. If you do not specify a value, the
         *                            Content-Type header defaults to the value stored
         *                            with OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder responseContentType(String responseContentType) {
            this.responseContentType = responseContentType;
            return this;
        }

        /**
         * @param responseContentDisposition The value of the Content-Disposition header
         *                                   you want to receive when you download the
         *                                   object using the signed URL. If you do not
         *                                   specify a value, the Content-Disposition
         *                                   header defaults to the value stored with
         *                                   OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder responseContentDisposition(String responseContentDisposition) {
            this.responseContentDisposition = responseContentDisposition;
            return this;
        }

        /**
         * @param responseCacheControl The value of the Cache-Control header you want to
         *                             receive when you download the object using the
         *                             signed URL. If you do not specify a value, the
         *                             Cache-Control header defaults to the value stored
         *                             with OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder responseCacheControl(String responseCacheControl) {
            this.responseCacheControl = responseCacheControl;
            return this;
        }

        /**
         * @param publicResourceFallback Specifies how to return the signed URLs, in
         *                               case the object was uploaded in chunks, and
         *                               assembling of chunks is not yet complete.
         * 
         *                               - &#x60;&#x60;true&#x60;&#x60; : Return a
         *                               single signed OSS URL.
         *                               - &#x60;&#x60;false&#x60;&#x60; : (Default)
         *                               Return multiple signed S3 URLs, where each URL
         *                               points to a chunk.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder publicResourceFallback(Boolean publicResourceFallback) {
            this.publicResourceFallback = publicResourceFallback;
            return this;
        }

        /**
         * @param minutesExpiration The time window (in minutes) the signed URL will
         *                          remain usable. Acceptable values &#x3D; 1-60
         *                          minutes. Default &#x3D; 2 minutes.
         * 
         *                          **Tip:** Use the smallest possible time window to
         *                          minimize exposure of the signed URL.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder minutesExpiration(Integer minutesExpiration) {
            this.minutesExpiration = minutesExpiration;
            return this;
        }

        /**
         * @param useCdn &#x60;&#x60;true&#x60;&#x60; : Returns a URL that points to a
         *               CloudFront edge location.
         * 
         *               &#x60;&#x60;false&#x60;&#x60; : (Default) Returns a URL that
         *               points directly to the S3 object.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder useCdn(Boolean useCdn) {
            this.useCdn = useCdn;
            return this;
        }

        /**
         * @param accessToken The access token string.
         *
         * @return The Builder instance for chaining.
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Builds and returns an instance of SignedS3DownloadOptionalParams.
         * 
         * @return SignedS3DownloadOptionalParams object.
         */
        public SignedS3DownloadOptionalParams build() {
            return new SignedS3DownloadOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the ifNoneMatch value.
     *
     * @return String
     */
    public String getIfNoneMatch() {
        return ifNoneMatch;
    }

    /**
     * Gets the ifModifiedSince value.
     *
     * @return LocalDate
     */
    public LocalDateTime getIfModifiedSince() {
        return ifModifiedSince;
    }

    /**
     * Gets the responseContentType value.
     *
     * @return String
     */
    public String getResponseContentType() {
        return responseContentType;
    }

    /**
     * Gets the responseContentDisposition value.
     *
     * @return String
     */
    public String getResponseContentDisposition() {
        return responseContentDisposition;
    }

    /**
     * Gets the responseCacheControl value.
     *
     * @return String
     */
    public String getResponseCacheControl() {
        return responseCacheControl;
    }

    /**
     * Gets the publicResourceFallback value.
     *
     * @return Boolean
     */
    public Boolean getPublicResourceFallback() {
        return publicResourceFallback;
    }

    /**
     * Gets the minutesExpiration value.
     *
     * @return Integer
     */
    public Integer getMinutesExpiration() {
        return minutesExpiration;
    }

    /**
     * Gets the useCdn value.
     *
     * @return Boolean
     */
    public Boolean getUseCdn() {
        return useCdn;
    }

    /**
     * Gets the access token for authentication.
     *
     * @return String.
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
