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
  * Represents optional parameters for the `completeSignedS3Upload` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class CompleteSignedS3UploadOptionalParams{
    private String xAdsMetaContentType;    
    private String xAdsMetaContentDisposition;    
    private String xAdsMetaContentEncoding;    
    private String xAdsMetaCacheControl;    
    private String xAdsUserDefinedMetadata;    
    private String accessToken;

    private CompleteSignedS3UploadOptionalParams(Builder builder){
        this.xAdsMetaContentType = builder.xAdsMetaContentType;    
this.xAdsMetaContentDisposition = builder.xAdsMetaContentDisposition;    
this.xAdsMetaContentEncoding = builder.xAdsMetaContentEncoding;    
this.xAdsMetaCacheControl = builder.xAdsMetaCacheControl;    
this.xAdsUserDefinedMetadata = builder.xAdsUserDefinedMetadata;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of CompleteSignedS3UploadOptionalParams.
     */
    public static class Builder {
         private String xAdsMetaContentType;    
 private String xAdsMetaContentDisposition;    
 private String xAdsMetaContentEncoding;    
 private String xAdsMetaCacheControl;    
 private String xAdsUserDefinedMetadata;    
        private String accessToken;      
        /**
         * @param xAdsMetaContentType The Content-Type value for the uploaded object to record within OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaContentType(String xAdsMetaContentType){
            this.xAdsMetaContentType = xAdsMetaContentType;
            return this;
        }     
        /**
         * @param xAdsMetaContentDisposition The Content-Disposition value for the uploaded object to record within OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaContentDisposition(String xAdsMetaContentDisposition){
            this.xAdsMetaContentDisposition = xAdsMetaContentDisposition;
            return this;
        }     
        /**
         * @param xAdsMetaContentEncoding The Content-Encoding value for the uploaded object to record within OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaContentEncoding(String xAdsMetaContentEncoding){
            this.xAdsMetaContentEncoding = xAdsMetaContentEncoding;
            return this;
        }     
        /**
         * @param xAdsMetaCacheControl The Cache-Control value for the uploaded object to record within OSS.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsMetaCacheControl(String xAdsMetaCacheControl){
            this.xAdsMetaCacheControl = xAdsMetaCacheControl;
            return this;
        }     
        /**
         * @param xAdsUserDefinedMetadata Custom metadata to be stored with the object, which can be retrieved later on download or when retrieving object details. Must be a JSON object that is less than 100 bytes.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsUserDefinedMetadata(String xAdsUserDefinedMetadata){
            this.xAdsUserDefinedMetadata = xAdsUserDefinedMetadata;
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
         * Builds and returns an instance of CompleteSignedS3UploadOptionalParams.
         * 
         * @return CompleteSignedS3UploadOptionalParams object.
         */
        public CompleteSignedS3UploadOptionalParams build() {
            return new CompleteSignedS3UploadOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the xAdsMetaContentType value.
     *
     * @return String
     */
    public String getXAdsMetaContentType(){
        return xAdsMetaContentType;
    }
    /**
     * Gets the xAdsMetaContentDisposition value.
     *
     * @return String
     */
    public String getXAdsMetaContentDisposition(){
        return xAdsMetaContentDisposition;
    }
    /**
     * Gets the xAdsMetaContentEncoding value.
     *
     * @return String
     */
    public String getXAdsMetaContentEncoding(){
        return xAdsMetaContentEncoding;
    }
    /**
     * Gets the xAdsMetaCacheControl value.
     *
     * @return String
     */
    public String getXAdsMetaCacheControl(){
        return xAdsMetaCacheControl;
    }
    /**
     * Gets the xAdsUserDefinedMetadata value.
     *
     * @return String
     */
    public String getXAdsUserDefinedMetadata(){
        return xAdsUserDefinedMetadata;
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
