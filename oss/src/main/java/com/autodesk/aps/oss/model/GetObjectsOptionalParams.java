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
  * Represents optional parameters for the `getObjects` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class GetObjectsOptionalParams{
    private Integer limit;    
    private String beginsWith;    
    private String startAt;    
    private String accessToken;

    private GetObjectsOptionalParams(Builder builder){
        this.limit = builder.limit;    
this.beginsWith = builder.beginsWith;    
this.startAt = builder.startAt;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of GetObjectsOptionalParams.
     */
    public static class Builder {
         private Integer limit;    
 private String beginsWith;    
 private String startAt;    
        private String accessToken;      
        /**
         * @param limit The number of items you want per page.
 * Acceptable values &#x3D; 1-100. Default &#x3D; 10.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder limit(Integer limit){
            this.limit = limit;
            return this;
        }     
        /**
         * @param beginsWith Filters the results by the value you specify. Only the objects with their &#x60;&#x60;objectKey&#x60;&#x60; beginning with the specified string are returned.
         *
         * @return The Builder instance for chaining.
         */
        public Builder beginsWith(String beginsWith){
            this.beginsWith = beginsWith;
            return this;
        }     
        /**
         * @param startAt The ID of the last item that was returned in the previous result set.  It enables the system to return subsequent items starting from the next one after the specified ID.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder startAt(String startAt){
            this.startAt = startAt;
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
         * Builds and returns an instance of GetObjectsOptionalParams.
         * 
         * @return GetObjectsOptionalParams object.
         */
        public GetObjectsOptionalParams build() {
            return new GetObjectsOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the limit value.
     *
     * @return Integer
     */
    public Integer getLimit(){
        return limit;
    }
    /**
     * Gets the beginsWith value.
     *
     * @return String
     */
    public String getBeginsWith(){
        return beginsWith;
    }
    /**
     * Gets the startAt value.
     *
     * @return String
     */
    public String getStartAt(){
        return startAt;
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
