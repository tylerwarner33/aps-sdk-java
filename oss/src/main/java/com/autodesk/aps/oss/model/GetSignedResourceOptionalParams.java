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
 * Represents optional parameters for the `getSignedResource` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class GetSignedResourceOptionalParams {
    private String range;
    private String ifNoneMatch;
    private LocalDateTime ifModifiedSince;
    private String acceptEncoding;
    private Region region;
    private String responseContentDisposition;
    private String responseContentType;
    private String accessToken;

    private GetSignedResourceOptionalParams(Builder builder) {
        this.range = builder.range;
        this.ifNoneMatch = builder.ifNoneMatch;
        this.ifModifiedSince = builder.ifModifiedSince;
        this.acceptEncoding = builder.acceptEncoding;
        this.region = builder.region;
        this.responseContentDisposition = builder.responseContentDisposition;
        this.responseContentType = builder.responseContentType;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of GetSignedResourceOptionalParams.
     */
    public static class Builder {
        private String range;
        private String ifNoneMatch;
        private LocalDateTime ifModifiedSince;
        private String acceptEncoding;
        private Region region;
        private String responseContentDisposition;
        private String responseContentType;
        private String accessToken;

        /**
         * @param range The byte range to download, specified in the form
         *              &#x60;&#x60;bytes&#x3D;&lt;START_BYTE&gt;-&lt;END_BYTE&gt;&#x60;&#x60;.
         *
         * @return The Builder instance for chaining.
         */
        public Builder range(String range) {
            this.range = range;
            return this;
        }

        /**
         * @param ifNoneMatch The last known ETag value of the object. OSS returns the
         *                    requested data only if the
         *                    &#x60;&#x60;If-None-Match&#x60;&#x60; header differs from
         *                    the ETag value of the object on OSS, which indicates that
         *                    the object on OSS is newer. If not, it returns a 304
         *                    &quot;Not Modified&quot; HTTP status.
         *
         * @return The Builder instance for chaining.
         */
        public Builder ifNoneMatch(String ifNoneMatch) {
            this.ifNoneMatch = ifNoneMatch;
            return this;
        }

        /**
         * @param ifModifiedSince A timestamp in the HTTP date format (Mon, DD Month
         *                        YYYY HH:MM:SS GMT). The requested data is returned
         *                        only if the object has been modified since the
         *                        specified timestamp. If not, a 304 (Not Modified) HTTP
         *                        status is returned.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder ifModifiedSince(LocalDateTime ifModifiedSince) {
            this.ifModifiedSince = ifModifiedSince;
            return this;
        }

        /**
         * @param acceptEncoding The compression format your prefer to receive the data.
         *                       Possible values are:
         * 
         *                       - &#x60;&#x60;gzip&#x60;&#x60; - Use the gzip format
         * 
         *                       **Note:** You cannot use
         *                       &#x60;&#x60;Accept-Encoding:gzip&#x60;&#x60; with a
         *                       Range header containing an end byte range. OSS will not
         *                       honor the End byte range if
         *                       &#x60;&#x60;Accept-Encoding: gzip&#x60;&#x60; header is
         *                       used.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }

        /**
         * @param region Specifies where the bucket containing the object is stored.
         *               Possible values are:
         * 
         *               - &#x60;&#x60;US&#x60;&#x60; : (Default) Data center for the US
         *               region.
         *               - &#x60;&#x60;EMEA&#x60;&#x60; : Data center for the European
         *               Union, Middle East, and Africa.
         *               - &#x60;&#x60;AUS&#x60;&#x60; : (Beta) Data center for
         *               Australia.
         *               - &#x60;&#x60;CAN&#x60;&#x60; : Data center for the Canada
         *               region.
         *               - &#x60;&#x60;DEU&#x60;&#x60; : Data center for the Germany
         *               region.
         *               - &#x60;&#x60;IND&#x60;&#x60; : Data center for the India
         *               region.
         *               - &#x60;&#x60;JPN&#x60;&#x60; : Data center for the Japan
         *               region.
         *               - &#x60;&#x60;GBR&#x60;&#x60; : Data center for the United
         *               Kingdom region.
         * 
         *               **Note:** Beta features are subject to change. Please do not
         *               use in production environments.
         *
         * @return The Builder instance for chaining.
         */
        public Builder region(Region region) {
            this.region = region;
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
         * @param accessToken The access token string.
         *
         * @return The Builder instance for chaining.
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Builds and returns an instance of GetSignedResourceOptionalParams.
         * 
         * @return GetSignedResourceOptionalParams object.
         */
        public GetSignedResourceOptionalParams build() {
            return new GetSignedResourceOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the range value.
     *
     * @return String
     */
    public String getRange() {
        return range;
    }

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
     * Gets the acceptEncoding value.
     *
     * @return String
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * Gets the region value.
     *
     * @return Region
     */
    public Region getRegion() {
        return region;
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
     * Gets the responseContentType value.
     *
     * @return String
     */
    public String getResponseContentType() {
        return responseContentType;
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
