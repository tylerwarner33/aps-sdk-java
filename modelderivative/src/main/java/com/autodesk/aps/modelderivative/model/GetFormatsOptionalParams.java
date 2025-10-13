/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Model Derivative
 * Use the Model Derivative API to translate designs from one CAD format to another. You can also use this API to extract metadata from a model.
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
package com.autodesk.aps.modelderivative.model;  
  
 /**
  * Represents optional parameters for the `getFormats` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class GetFormatsOptionalParams{
    private String ifModifiedSince;    
    private String acceptEncoding;    
    private String accessToken;

    private GetFormatsOptionalParams(Builder builder){
        this.ifModifiedSince = builder.ifModifiedSince;    
this.acceptEncoding = builder.acceptEncoding;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of GetFormatsOptionalParams.
     */
    public static class Builder {
         private String ifModifiedSince;    
 private String acceptEncoding;    
        private String accessToken;      
        /**
         * @param ifModifiedSince Specifies a date in the &#x60;&#x60;Day of the week, DD Month YYYY HH:MM:SS GMT&#x60;&#x60; format. The response will contain only the formats modified since the specified date and time. If you specify an invalid date, the response will contain all supported formats. If no changes have been made after the specified date, the service returns HTTP status &#x60;&#x60;304&#x60;&#x60;, NOT MODIFIED.
         *
         * @return The Builder instance for chaining.
         */
        public Builder ifModifiedSince(String ifModifiedSince){
            this.ifModifiedSince = ifModifiedSince;
            return this;
        }     
        /**
         * @param acceptEncoding A comma separated list of the algorithms you want the response to be encoded in, specified in the order of preference.  
 * 
 * If you specify &#x60;&#x60;gzip&#x60;&#x60; or &#x60;&#x60;*&#x60;&#x60;, content is compressed and returned in gzip format.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder acceptEncoding(String acceptEncoding){
            this.acceptEncoding = acceptEncoding;
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
         * Builds and returns an instance of GetFormatsOptionalParams.
         * 
         * @return GetFormatsOptionalParams object.
         */
        public GetFormatsOptionalParams build() {
            return new GetFormatsOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the ifModifiedSince value.
     *
     * @return String
     */
    public String getIfModifiedSince(){
        return ifModifiedSince;
    }
    /**
     * Gets the acceptEncoding value.
     *
     * @return String
     */
    public String getAcceptEncoding(){
        return acceptEncoding;
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
