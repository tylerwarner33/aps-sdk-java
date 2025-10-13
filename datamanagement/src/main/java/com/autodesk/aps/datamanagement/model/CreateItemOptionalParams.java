/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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
package com.autodesk.aps.datamanagement.model;  
  
 /**
  * Represents optional parameters for the `createItem` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class CreateItemOptionalParams{
    private String copyFrom;    
    private String xUserId;    
    private String accessToken;

    private CreateItemOptionalParams(Builder builder){
        this.copyFrom = builder.copyFrom;    
this.xUserId = builder.xUserId;    
        this.accessToken = builder.accessToken;
    }

    
    /**
     * Builder class for constructing instances of CreateItemOptionalParams.
     */
    public static class Builder {
         private String copyFrom;    
 private String xUserId;    
        private String accessToken;      
        /**
         * @param copyFrom The Version ID (URN) of the version to copy from. 
 * 
 * **Note**: This parameter is relevant only for copying files to BIM 360 Docs.
 * 
 * For information on how to find the URN, see the initial steps of the [Download a File](/en/docs/data/v2/tutorials/download-file/) tutorial.
 * 
 * You can only copy files to the Plans folder or to subfolders of the Plans folder with an &#x60;&#x60;item:autodesk.bim360:Document&#x60;&#x60; item extension type. You can only copy files to the Project Files folder or to subfolders of the Project Files folder with an &#x60;&#x60;item:autodesk.bim360:File&#x60;&#x60; item extension type.  
 * 
 * To verify an item’s extension type, use the [Get an Item](/en/docs/data/v2/reference/http/projects-project_id-items-item_id-GET/) operation, and check the &#x60;&#x60;attributes.extension.type&#x60;&#x60; attribute.  
 * 
 * Note that if you copy a file to the Plans folder or to a subfolder of the Plans folder, the copied file inherits the permissions of the source file. For example, if users of your app did not have permission to download files in the source folder, but does have permission to download files in the target folder, they will not be able to download the copied file.  
 * 
 * Note that you cannot copy a file while it is being uploaded, updated, or copied. To verify the current process state of a file, call the [Get an Item](en/docs/data/v2/reference/http/projects-project_id-items-item_id-GET/) operation , and check the &#x60;&#x60;attributes.extension.data.processState&#x60;&#x60; attribute.
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder copyFrom(String copyFrom){
            this.copyFrom = copyFrom;
            return this;
        }     
        /**
         * @param xUserId In a two-legged authentication context, the app has access to all users specified by the administrator in the SaaS integrations UI. By providing this header, the API call will be limited to act on behalf of only the user specified.        
 * 
 * Note that for a three-legged OAuth flow or for a two-legged OAuth flow with user impersonation (&#x60;&#x60;x-user-id&#x60;&#x60;), the users of your app must have permission to upload files to the specified parent folder (&#x60;&#x60;data.attributes.relationships.parent.data.id&#x60;&#x60;).
 * 
 * For copying files, users of your app must have permission to view the source folder. 
 * 
 * For information about managing and verifying folder permissions for BIM 360 Docs, see the section on [Managing Folder Permissions](http://help.autodesk.com/view/BIM360D/ENU/?guid&#x3D;GUID-2643FEEF-B48A-45A1-B354-797DAD628C37).&#39;
 * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder xUserId(String xUserId){
            this.xUserId = xUserId;
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
         * Builds and returns an instance of CreateItemOptionalParams.
         * 
         * @return CreateItemOptionalParams object.
         */
        public CreateItemOptionalParams build() {
            return new CreateItemOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the copyFrom value.
     *
     * @return String
     */
    public String getCopyFrom(){
        return copyFrom;
    }
    /**
     * Gets the xUserId value.
     *
     * @return String
     */
    public String getXUserId(){
        return xUserId;
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
