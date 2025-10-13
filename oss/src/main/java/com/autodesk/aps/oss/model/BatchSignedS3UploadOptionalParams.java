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
  * Represents optional parameters for the `batchSignedS3Upload` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class BatchSignedS3UploadOptionalParams{
    private Boolean useAcceleration;    
    private Integer minutesExpiration;    
    private Batchsigneds3uploadObject batchsigneds3uploadObject;    
    private String accessToken;

    private BatchSignedS3UploadOptionalParams(Builder builder){
        this.useAcceleration = builder.useAcceleration;    
this.minutesExpiration = builder.minutesExpiration;    
this.batchsigneds3uploadObject = builder.batchsigneds3uploadObject;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of BatchSignedS3UploadOptionalParams.
     */
    public static class Builder {
         private Boolean useAcceleration;    
 private Integer minutesExpiration;    
 private Batchsigneds3uploadObject batchsigneds3uploadObject;    
        private String accessToken;      
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
         * @param batchsigneds3uploadObject 
         *
         * @return The Builder instance for chaining.
         */
        public Builder batchsigneds3uploadObject(Batchsigneds3uploadObject batchsigneds3uploadObject){
            this.batchsigneds3uploadObject = batchsigneds3uploadObject;
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
         * Builds and returns an instance of BatchSignedS3UploadOptionalParams.
         * 
         * @return BatchSignedS3UploadOptionalParams object.
         */
        public BatchSignedS3UploadOptionalParams build() {
            return new BatchSignedS3UploadOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the useAcceleration value.
     *
     * @return Boolean
     */
    public Boolean getUseAcceleration(){
        return useAcceleration;
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
     * Gets the batchsigneds3uploadObject value.
     *
     * @return Batchsigneds3uploadObject
     */
    public Batchsigneds3uploadObject getBatchsigneds3uploadObject(){
        return batchsigneds3uploadObject;
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
