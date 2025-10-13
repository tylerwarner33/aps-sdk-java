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

/**
 * Represents optional parameters for the `uploadSignedResourcesChunk` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class UploadSignedResourcesChunkOptionalParams {
    private String contentType;
    private String contentDisposition;
    private Region xAdsRegion;
    private String accessToken;

    private UploadSignedResourcesChunkOptionalParams(Builder builder) {
        this.contentType = builder.contentType;
        this.contentDisposition = builder.contentDisposition;
        this.xAdsRegion = builder.xAdsRegion;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of
     * UploadSignedResourcesChunkOptionalParams.
     */
    public static class Builder {
        private String contentType;
        private String contentDisposition;
        private Region xAdsRegion;
        private String accessToken;

        /**
         * @param contentType The MIME type of the object to upload; can be any type
         *                    except &#39;multipart/form-data&#39;. This can be omitted,
         *                    but we recommend adding it.
         *
         * @return The Builder instance for chaining.
         */
        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * @param contentDisposition The suggested file name to use when this object is
         *                           downloaded as a file.
         *
         * @return The Builder instance for chaining.
         */
        public Builder contentDisposition(String contentDisposition) {
            this.contentDisposition = contentDisposition;
            return this;
        }

        /**
         * @param xAdsRegion Specifies where the bucket containing the object is stored.
         *                   Possible values are:
         * 
         *                   - &#x60;&#x60;US&#x60;&#x60; : (Default) Data center for
         *                   the US region.
         *                   - &#x60;&#x60;EMEA&#x60;&#x60; : Data center for the
         *                   European Union, Middle East, and Africa.
         *                   - &#x60;&#x60;AUS&#x60;&#x60; : (Beta) Data center for
         *                   Australia.
         *                   - &#x60;&#x60;CAN&#x60;&#x60; : Data center for the Canada
         *                   region.
         *                   - &#x60;&#x60;DEU&#x60;&#x60; : Data center for the Germany
         *                   region.
         *                   - &#x60;&#x60;IND&#x60;&#x60; : Data center for the India
         *                   region.
         *                   - &#x60;&#x60;JPN&#x60;&#x60; : Data center for the Japan
         *                   region.
         *                   - &#x60;&#x60;GBR&#x60;&#x60; : Data center for the United
         *                   Kingdom region.
         * 
         *                   **Note:** Beta features are subject to change. Please do
         *                   not use in production environments.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsRegion(Region xAdsRegion) {
            this.xAdsRegion = xAdsRegion;
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
         * Builds and returns an instance of UploadSignedResourcesChunkOptionalParams.
         * 
         * @return UploadSignedResourcesChunkOptionalParams object.
         */
        public UploadSignedResourcesChunkOptionalParams build() {
            return new UploadSignedResourcesChunkOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the contentType value.
     *
     * @return String
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Gets the contentDisposition value.
     *
     * @return String
     */
    public String getContentDisposition() {
        return contentDisposition;
    }

    /**
     * Gets the xAdsRegion value.
     *
     * @return Region
     */
    public Region getXAdsRegion() {
        return xAdsRegion;
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
