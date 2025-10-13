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
  * Represents optional parameters for the `getThumbnail` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class GetThumbnailOptionalParams{
    private Region region;    
    private Width width;    
    private Height height;    
    private String accessToken;

    private GetThumbnailOptionalParams(Builder builder){
        this.region = builder.region;    
this.width = builder.width;    
this.height = builder.height;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of GetThumbnailOptionalParams.
     */
    public static class Builder {
         private Region region;    
 private Width width;    
 private Height height;    
        private String accessToken;      
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
         * @param width Width of thumbnail in pixels.  Possible values are: &#x60;&#x60;100&#x60;&#x60;, &#x60;&#x60;200&#x60;&#x60;, &#x60;&#x60;400&#x60;&#x60;  If &#x60;&#x60;width&#x60;&#x60; is omitted, but &#x60;&#x60;height&#x60;&#x60; is specified, &#x60;&#x60;width&#x60;&#x60; defaults to &#x60;&#x60;height&#x60;&#x60;. If both &#x60;&#x60;width&#x60;&#x60; and &#x60;&#x60;height&#x60;&#x60; are omitted, the server will return a thumbnail closest to &#x60;&#x60;200&#x60;&#x60;, if such a thumbnail is available.
         *
         * @return The Builder instance for chaining.
         */
        public Builder width(Width width){
            this.width = width;
            return this;
        }     
        /**
         * @param height Height of thumbnails. Possible values are: &#x60;&#x60;100&#x60;&#x60;, &#x60;&#x60;200&#x60;&#x60;, &#x60;&#x60;400&#x60;&#x60;.If &#x60;&#x60;height&#x60;&#x60; is omitted, but &#x60;&#x60;width&#x60;&#x60; is specified, &#x60;&#x60;height&#x60;&#x60; defaults to &#x60;&#x60;width&#x60;&#x60;.  If both &#x60;&#x60;width&#x60;&#x60; and &#x60;&#x60;height&#x60;&#x60; are omitted, the server will return a thumbnail closest to &#x60;&#x60;200&#x60;&#x60;, if such a thumbnail is available
         *
         * @return The Builder instance for chaining.
         */
        public Builder height(Height height){
            this.height = height;
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
         * Builds and returns an instance of GetThumbnailOptionalParams.
         * 
         * @return GetThumbnailOptionalParams object.
         */
        public GetThumbnailOptionalParams build() {
            return new GetThumbnailOptionalParams(this);
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
     * Gets the width value.
     *
     * @return Width
     */
    public Width getWidth(){
        return width;
    }
    /**
     * Gets the height value.
     *
     * @return Height
     */
    public Height getHeight(){
        return height;
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
