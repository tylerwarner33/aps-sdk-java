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
 * Represents optional parameters for the `getObjectDetails` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class GetObjectDetailsOptionalParams {
    private LocalDateTime ifModifiedSince;
    private With with;
    private String accessToken;

    private GetObjectDetailsOptionalParams(Builder builder) {
        this.ifModifiedSince = builder.ifModifiedSince;
        this.with = builder.with;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of GetObjectDetailsOptionalParams.
     */
    public static class Builder {
        private LocalDateTime ifModifiedSince;
        private With with;
        private String accessToken;

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
         * @param with
         *
         * @return The Builder instance for chaining.
         */
        public Builder with(With with) {
            this.with = with;
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
         * Builds and returns an instance of GetObjectDetailsOptionalParams.
         * 
         * @return GetObjectDetailsOptionalParams object.
         */
        public GetObjectDetailsOptionalParams build() {
            return new GetObjectDetailsOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the ifModifiedSince value.
     *
     * @return LocalDateTime
     */
    public LocalDateTime getIfModifiedSince() {
        return ifModifiedSince;
    }

    /**
     * Gets the with value.
     *
     * @return With
     */
    public With getWith() {
        return with;
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
