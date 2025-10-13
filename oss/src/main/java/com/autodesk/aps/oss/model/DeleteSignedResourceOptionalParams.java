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
  * Represents optional parameters for the `deleteSignedResource` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class DeleteSignedResourceOptionalParams{
    private Region region;    
    private String accessToken;

    private DeleteSignedResourceOptionalParams(Builder builder){
        this.region = builder.region;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of DeleteSignedResourceOptionalParams.
     */
    public static class Builder {
         private Region region;    
        private String accessToken;      
        /**
         * @param region Specifies where the bucket containing the object is stored. Possible values are:
 * 
 * - &#x60;&#x60;US&#x60;&#x60; - (Default) Data center for the US region.
 * - &#x60;&#x60;EMEA&#x60;&#x60; - Data center for the European Union, Middle East, and Africa.
 * - &#x60;&#x60;AUS&#x60;&#x60; -  (Beta) Data center for Australia.
 * 
 * **Note:** Beta features are subject to change. Please do not use in production environments.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder region(Region region){
            this.region = region;
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
         * Builds and returns an instance of DeleteSignedResourceOptionalParams.
         * 
         * @return DeleteSignedResourceOptionalParams object.
         */
        public DeleteSignedResourceOptionalParams build() {
            return new DeleteSignedResourceOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the region value.
     *
     * @return Region
     */
    public Region getRegion(){
        return region;
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
