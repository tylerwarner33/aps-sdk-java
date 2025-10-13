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
  * Represents optional parameters for the `batchSignedS3Download` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class BatchSignedS3DownloadOptionalParams{
    private Boolean publicResourceFallback;    
    private Integer minutesExpiration;    
    private String accessToken;

    private BatchSignedS3DownloadOptionalParams(Builder builder){
        this.publicResourceFallback = builder.publicResourceFallback;    
this.minutesExpiration = builder.minutesExpiration;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of BatchSignedS3DownloadOptionalParams.
     */
    public static class Builder {
         private Boolean publicResourceFallback;    
 private Integer minutesExpiration;    
        private String accessToken;      
        /**
         * @param publicResourceFallback Specifies how to return the signed URLs, in case the object was uploaded in chunks, and assembling of chunks is not yet complete.
 * 
 * - &#x60;&#x60;true&#x60;&#x60; : Return a single signed OSS URL.
 * - &#x60;&#x60;false&#x60;&#x60; : (Default) Return multiple signed S3 URLs, where each URL points to a chunk.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder publicResourceFallback(Boolean publicResourceFallback){
            this.publicResourceFallback = publicResourceFallback;
            return this;
        }     
        /**
         * @param minutesExpiration The time window (in minutes) the signed URL will remain usable. Acceptable values &#x3D; 1-60 minutes. Default &#x3D; 2 minutes.
 * 
 * **Tip:** Use the smallest possible time window to minimize exposure of the signed URL.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder minutesExpiration(Integer minutesExpiration){
            this.minutesExpiration = minutesExpiration;
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
         * Builds and returns an instance of BatchSignedS3DownloadOptionalParams.
         * 
         * @return BatchSignedS3DownloadOptionalParams object.
         */
        public BatchSignedS3DownloadOptionalParams build() {
            return new BatchSignedS3DownloadOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the publicResourceFallback value.
     *
     * @return Boolean
     */
    public Boolean getPublicResourceFallback(){
        return publicResourceFallback;
    }
    /**
     * Gets the minutesExpiration value.
     *
     * @return Integer
     */
    public Integer getMinutesExpiration(){
        return minutesExpiration;
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
