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
  * Represents optional parameters for the `getDerivativeUrl` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class GetDerivativeUrlOptionalParams{
    private Integer minutesExpiration;    
    private String responseContentDisposition;    
    private Region region;    
    private String accessToken;

    private GetDerivativeUrlOptionalParams(Builder builder){
        this.minutesExpiration = builder.minutesExpiration;    
this.responseContentDisposition = builder.responseContentDisposition;    
this.region = builder.region;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of GetDerivativeUrlOptionalParams.
     */
    public static class Builder {
         private Integer minutesExpiration;    
 private String responseContentDisposition;    
 private Region region;    
        private String accessToken;      
        /**
         * @param minutesExpiration Specifies how many minutes the signed cookies should remain valid. Default value is 360 minutes. The value you specify must be lower than the default value for this parameter. If you specify a value greater than the default value, the Model Derivative service will return an error with an HTTP status code of &#x60;&#x60;400&#x60;&#x60;.
         *
         * @return The Builder instance for chaining.
         */
        public Builder minutesExpiration(Integer minutesExpiration){
            this.minutesExpiration = minutesExpiration;
            return this;
        }     
        /**
         * @param responseContentDisposition The value that must be specified as the &#x60;&#x60;response-content-disposition&#x60;&#x60; query string parameter with the download URL. Must begin with &#x60;&#x60;attachment&#x60;&#x60;. This value defaults to the default value corresponding to the derivative/file.
         *
         * @return The Builder instance for chaining.
         */
        public Builder responseContentDisposition(String responseContentDisposition){
            this.responseContentDisposition = responseContentDisposition;
            return this;
        }     
        /**
         * @param region Specifies the data center where the manifest and derivatives of the specified source design are stored. Possible values are:
 * 
 * - &#x60;&#x60;US&#x60;&#x60; - (Default) Data center for the US region.
 * - &#x60;&#x60;EMEA&#x60;&#x60; - Data center for the European Union, Middle East, and Africa. 
 * - &#x60;&#x60;AUS&#x60;&#x60; - Data center for the Australia region.
 * - &#x60;&#x60;CAN&#x60;&#x60; - Data center for the Canada region.
 * - &#x60;&#x60;DEU&#x60;&#x60; - Data center for the Germany region.
 * - &#x60;&#x60;IND&#x60;&#x60; - Data center for the India region.
 * - &#x60;&#x60;JPN&#x60;&#x60; - Data center for the Japan region.
 * - &#x60;&#x60;GBR&#x60;&#x60;  - Data center for the United Kingdom region.
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
         * Builds and returns an instance of GetDerivativeUrlOptionalParams.
         * 
         * @return GetDerivativeUrlOptionalParams object.
         */
        public GetDerivativeUrlOptionalParams build() {
            return new GetDerivativeUrlOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the minutesExpiration value.
     *
     * @return Integer
     */
    public Integer getMinutesExpiration(){
        return minutesExpiration;
    }
    /**
     * Gets the responseContentDisposition value.
     *
     * @return String
     */
    public String getResponseContentDisposition(){
        return responseContentDisposition;
    }
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
