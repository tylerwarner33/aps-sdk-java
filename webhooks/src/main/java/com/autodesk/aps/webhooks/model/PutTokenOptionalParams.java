/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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
package com.autodesk.aps.webhooks.model;  
  
 /**
  * Represents optional parameters for the `putToken` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class PutTokenOptionalParams{
    private XAdsRegion xAdsRegion;    
    private Region region;    
    private String accessToken;

    private PutTokenOptionalParams(Builder builder){
        this.xAdsRegion = builder.xAdsRegion;    
this.region = builder.region;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of PutTokenOptionalParams.
     */
    public static class Builder {
         private XAdsRegion xAdsRegion;    
 private Region region;    
        private String accessToken;      
        /**
         * @param xAdsRegion Specifies the geographical location (region) of the server the request must be executed on. This also corresponds to the region where the Webhook data is stored. It is also the location of the server that will make requests to your callback URL. Possible values:
 * 
 * - &#x60;&#x60;US&#x60;&#x60; - (Default) Data center dedicated to serve the United States region.
 * - &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to serve the European Union, Middle East, and Africa regions.
 * - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center dedicated to serve the Australia region.
 * - &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to serve the Canada region.
 * - &#x60;&#x60;DEU&#x60;&#x60; - Data center dedicated to serve the Germany region.
 * - &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to serve the India region.
 * - &#x60;&#x60;JPN&#x60;&#x60; - Data center dedicated to serve the Japan region.
 * - &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to serve the United Kingdom region.
 * 
 * **Note:** 
 * 
 * 1. Beta features are subject to change. Please avoid using them in production environments.
 * 2. You can also use the &#x60;&#x60;region&#x60;&#x60; query string parameter to specify the region. If you specify the &#x60;&#x60;region&#x60;&#x60; query string parameter as well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header, the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes precedence.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder xAdsRegion(XAdsRegion xAdsRegion){
            this.xAdsRegion = xAdsRegion;
            return this;
        }     
        /**
         * @param region Specifies the geographical location (region) of the server the request must be executed on. This also corresponds to the region where the Webhook data is stored. It is also the location of the server that will make request to your callback URL. Possible values:
 * 
 * - &#x60;&#x60;US&#x60;&#x60; - (Default) Data center dedicated to serve the United States region.
 * - &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to serve the European Union, Middle East, and Africa regions.
 * - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center dedicated to serve the Australia region.
 * - &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to serve the Canada region.
 * - &#x60;&#x60;DEU&#x60;&#x60; - Data center dedicated to serve the Germany region.
 * - &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to serve the India region.
 * - &#x60;&#x60;JPN&#x60;&#x60; - Data center dedicated to serve the Japan region.
 * - &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to serve the United Kingdom region.
 * 
 * **Note:** 
 * 
 * 1. Beta features are subject to change. Please avoid using them in production environments.
 * 2. You can also use the &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the region. If you specify the &#x60;&#x60;region&#x60;&#x60; query string parameter as well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header, the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes precedence.
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
         * Builds and returns an instance of PutTokenOptionalParams.
         * 
         * @return PutTokenOptionalParams object.
         */
        public PutTokenOptionalParams build() {
            return new PutTokenOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the xAdsRegion value.
     *
     * @return XAdsRegion
     */
    public XAdsRegion getXAdsRegion(){
        return xAdsRegion;
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
