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
  * Represents optional parameters for the `signedS3Upload` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class SignedS3UploadOptionalParams{
    private Integer parts;    
    private Integer firstPart;    
    private String uploadKey;    
    private Integer minutesExpiration;    
    private Boolean useAcceleration;    
    private String accessToken;

    private SignedS3UploadOptionalParams(Builder builder){
        this.parts = builder.parts;    
this.firstPart = builder.firstPart;    
this.uploadKey = builder.uploadKey;    
this.minutesExpiration = builder.minutesExpiration;    
this.useAcceleration = builder.useAcceleration;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of SignedS3UploadOptionalParams.
     */
    public static class Builder {
         private Integer parts;    
 private Integer firstPart;    
 private String uploadKey;    
 private Integer minutesExpiration;    
 private Boolean useAcceleration;    
        private String accessToken;      
        /**
         * @param parts The number of parts you intend to chunk the object for uploading. OSS will return that many signed URLs, one URL for each chunk. If you do not specify a value you&#39;ll get only one URL to upload the entire object.             
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder parts(Integer parts){
            this.parts = parts;
            return this;
        }     
        /**
         * @param firstPart The index of the first chunk to be uploaded.
         *
         * @return The Builder instance for chaining.
         */
        public Builder firstPart(Integer firstPart){
            this.firstPart = firstPart;
            return this;
        }     
        /**
         * @param uploadKey The &#x60;&#x60;uploadKey&#x60;&#x60; of a previously-initiated upload, in order to request more chunk upload URLs for the same upload. If you do not specify a value, OSS will initiate a new upload entirely.
         *
         * @return The Builder instance for chaining.
         */
        public Builder uploadKey(String uploadKey){
            this.uploadKey = uploadKey;
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
         * @param useAcceleration &#x60;&#x60;true&#x60;&#x60; : (Default) Generates a faster S3 signed URL using Transfer Acceleration.
 * 
 * &#x60;&#x60;false&#x60;&#x60;: Generates a standard S3 signed URL.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder useAcceleration(Boolean useAcceleration){
            this.useAcceleration = useAcceleration;
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
         * Builds and returns an instance of SignedS3UploadOptionalParams.
         * 
         * @return SignedS3UploadOptionalParams object.
         */
        public SignedS3UploadOptionalParams build() {
            return new SignedS3UploadOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the parts value.
     *
     * @return Integer
     */
    public Integer getParts(){
        return parts;
    }
    /**
     * Gets the firstPart value.
     *
     * @return Integer
     */
    public Integer getFirstPart(){
        return firstPart;
    }
    /**
     * Gets the uploadKey value.
     *
     * @return String
     */
    public String getUploadKey(){
        return uploadKey;
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
     * Gets the useAcceleration value.
     *
     * @return Boolean
     */
    public Boolean getUseAcceleration(){
        return useAcceleration;
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
