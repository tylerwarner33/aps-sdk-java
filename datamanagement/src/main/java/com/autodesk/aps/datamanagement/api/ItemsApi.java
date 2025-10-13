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
package com.autodesk.aps.datamanagement.api;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.datamanagement.BaseApi;
import com.autodesk.aps.datamanagement.DataManagementApiException;
import com.autodesk.aps.datamanagement.model.CreatedItem;
import com.autodesk.aps.datamanagement.model.FilterDirection;
import com.autodesk.aps.datamanagement.model.FilterRefType;
import com.autodesk.aps.datamanagement.model.FilterTypeVersion;
import com.autodesk.aps.datamanagement.model.Folder;
import com.autodesk.aps.datamanagement.model.Item;
import com.autodesk.aps.datamanagement.model.ItemPayload;
import com.autodesk.aps.datamanagement.model.ItemTip;
import com.autodesk.aps.datamanagement.model.ModifyItemPayload;
import com.autodesk.aps.datamanagement.model.Refs;
import com.autodesk.aps.datamanagement.model.RelationshipLinks;
import com.autodesk.aps.datamanagement.model.RelationshipRefs;
import com.autodesk.aps.datamanagement.model.RelationshipRefsPayload;
import com.autodesk.aps.datamanagement.model.Versions;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class ItemsApi extends BaseApi {

  public ItemsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create an Item
   * Creates the first version of a file (item). To create additional versions of
   * an item, use POST versions.
   * 
   * Before you create the first version of an item, you must create a placeholder
   * for the file, and upload the file to the placeholder. For more details about
   * the workflow, see the tutorial on uploading a file.
   * 
   * This operation also allows you to create a new item by copying a specific
   * version of an existing item to another folder. The copied version becomes the
   * first version of the new item in the target folder.
   * 
   * **Note:** You cannot copy versions of items across different projects and
   * accounts.
   * 
   * Use the [Create
   * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-POST/)
   * operation with the &#x60;&#x60;copyFrom&#x60;&#x60; parameter if you want to
   * create a new version of an item by copying a specific version of another
   * item.
   * 
   * Before you use the Data Management API to access BIM 360 Docs files, you must
   * provision your app through the BIM 360 Account Administrator portal. For
   * details, see the [Manage Access to Docs
   * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId   The unique identifier of a project. For BIM 360 Docs and
   *                    ACC Docs, a hub ID corresponds to an Account ID. To
   *                    convert a BIM 360 or ACC Account ID to a hub ID, prefix
   *                    the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
   *                    example, an Account ID of
   *                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                    translates to a hub ID of
   *                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                    convert an ACC or BIM 360 project ID to a Data Management
   *                    project ID prefix the ACC or BIM 360 project ID with
   *                    &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
   *                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                    project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                    (required)
   * @param itemPayload (required)
   * @param copyFrom    The Version ID (URN) of the version to copy from.
   *                    **Note**: This parameter is relevant only for copying
   *                    files to BIM 360 Docs. For information on how to find the
   *                    URN, see the initial steps of the [Download a
   *                    File](/en/docs/data/v2/tutorials/download-file/) tutorial.
   *                    You can only copy files to the Plans folder or to
   *                    subfolders of the Plans folder with an
   *                    &#x60;&#x60;item:autodesk.bim360:Document&#x60;&#x60; item
   *                    extension type. You can only copy files to the Project
   *                    Files folder or to subfolders of the Project Files folder
   *                    with an &#x60;&#x60;item:autodesk.bim360:File&#x60;&#x60;
   *                    item extension type. To verify an item’s extension type,
   *                    use the [Get an
   *                    Item](/en/docs/data/v2/reference/http/projects-project_id-items-item_id-GET/)
   *                    operation, and check the
   *                    &#x60;&#x60;attributes.extension.type&#x60;&#x60;
   *                    attribute. Note that if you copy a file to the Plans
   *                    folder or to a subfolder of the Plans folder, the copied
   *                    file inherits the permissions of the source file. For
   *                    example, if users of your app did not have permission to
   *                    download files in the source folder, but does have
   *                    permission to download files in the target folder, they
   *                    will not be able to download the copied file. Note that
   *                    you cannot copy a file while it is being uploaded,
   *                    updated, or copied. To verify the current process state of
   *                    a file, call the [Get an
   *                    Item](en/docs/data/v2/reference/http/projects-project_id-items-item_id-GET/)
   *                    operation , and check the
   *                    &#x60;&#x60;attributes.extension.data.processState&#x60;&#x60;
   *                    attribute. (optional)
   * @param xUserId     In a two-legged authentication context, the app has access
   *                    to all users specified by the administrator in the SaaS
   *                    integrations UI. By providing this header, the API call
   *                    will be limited to act on behalf of only the user
   *                    specified. Note that for a three-legged OAuth flow or for
   *                    a two-legged OAuth flow with user impersonation
   *                    (&#x60;&#x60;x-user-id&#x60;&#x60;), the users of your app
   *                    must have permission to upload files to the specified
   *                    parent folder
   *                    (&#x60;&#x60;data.attributes.relationships.parent.data.id&#x60;&#x60;).
   *                    For copying files, users of your app must have permission
   *                    to view the source folder. For information about managing
   *                    and verifying folder permissions for BIM 360 Docs, see the
   *                    section on [Managing Folder
   *                    Permissions](http://help.autodesk.com/view/BIM360D/ENU/?guid&#x3D;GUID-2643FEEF-B48A-45A1-B354-797DAD628C37).&#39;
   *                    (optional)
   * @return CreatedItem
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<CreatedItem> createItem(String projectId, ItemPayload itemPayload, String copyFrom, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into createItem ");

    Object localVarPostBody = itemPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling createItem");
    }

    // verify the required parameter 'itemPayload' is set
    if (itemPayload == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'itemPayload' when calling createItem");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (copyFrom != null) {
      localVarQueryParams.put("copyFrom", parameterToString(copyFrom));
    }
    if (xUserId != null) {
      localVarQueryParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Content-Type", "application/vnd.api+json");
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Post",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("createItem Request completed successfully with status " + statusCode);
      CreatedItem createdItem = deserialize(entity, new TypeReference<CreatedItem>() {
      });
      return new ApiResponse<CreatedItem>(statusCode, response.getHeaders(), createdItem);
    } catch (DataManagementApiException e) {
      this.logger.error("createItem Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createItem Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Create a Custom Relationship for an Item
   * Creates a custom relationship between an item and another resource within the
   * data domain service (folder, item, or version).
   * 
   * @param projectId               The unique identifier of a project. For BIM
   *                                360 Docs and ACC Docs, a hub ID corresponds to
   *                                an Account ID. To convert a BIM 360 or ACC
   *                                Account ID to a hub ID, prefix the Account ID
   *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
   *                                an Account ID of
   *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                                translates to a hub ID of
   *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                                Similarly, to convert an ACC or BIM 360
   *                                project ID to a Data Management project ID
   *                                prefix the ACC or BIM 360 project ID with
   *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
   *                                project ID of
   *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                                translates to a project ID of
   *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                                (required)
   * @param itemId                  The unique identifier of an item. (required)
   * @param relationshipRefsPayload (required)
   * @param xUserId                 In a two-legged authentication context, an app
   *                                has access to all users specified by the
   *                                administrator in the SaaS integrations UI. By
   *                                providing this header, the API call will be
   *                                limited to act only on behalf of the specified
   *                                user. (optional)
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Void> createItemRelationshipsRef(String projectId, String itemId,
      RelationshipRefsPayload relationshipRefsPayload, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into createItemRelationshipsRef ");

    Object localVarPostBody = relationshipRefsPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling createItemRelationshipsRef");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'itemId' when calling createItemRelationshipsRef");
    }

    // verify the required parameter 'relationshipRefsPayload' is set
    if (relationshipRefsPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'relationshipRefsPayload' when calling createItemRelationshipsRef");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/relationships/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Content-Type", "application/vnd.api+json");
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Post",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("createItemRelationshipsRef Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (DataManagementApiException e) {
      this.logger.error("createItemRelationshipsRef Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createItemRelationshipsRef Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get an Item
   * Retrieves an item. Items represent Word documents, Fusion 360 design files,
   * drawings, spreadsheets, etc.
   * 
   * The tip version for the item is included in the included array of the
   * payload.
   * To retrieve multiple items, see the ListItems command.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId            The unique identifier of a project. For BIM 360
   *                             Docs and ACC Docs, a hub ID corresponds to an
   *                             Account ID. To convert a BIM 360 or ACC Account
   *                             ID to a hub ID, prefix the Account ID with
   *                             &#x60;&#x60;b.&#x60;&#x60;. For example, an
   *                             Account ID of
   *                             &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                             translates to a hub ID of
   *                             &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                             Similarly, to convert an ACC or BIM 360 project
   *                             ID to a Data Management project ID prefix the ACC
   *                             or BIM 360 project ID with
   *                             &#x60;&#x60;b.&#x60;&#x60;. For example, a
   *                             project ID of
   *                             &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates
   *                             to a project ID of
   *                             &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                             (required)
   * @param itemId               The unique identifier of an item. (required)
   * @param xUserId              In a two-legged authentication context, an app
   *                             has access to all users specified by the
   *                             administrator in the SaaS integrations UI. By
   *                             providing this header, the API call will be
   *                             limited to act only on behalf of the specified
   *                             user. (optional)
   * @param includePathInProject Specify whether to return
   *                             &#x60;&#x60;pathInProject&#x60;&#x60; attribute
   *                             in response for BIM 360 Docs projects.
   *                             &#x60;&#x60;pathInProject&#x60;&#x60; is the
   *                             relative path of the item starting from project’s
   *                             root folder. - &#x60;&#x60;true&#x60;&#x60;:
   *                             Response will include the
   *                             &#x60;&#x60;pathInProject&#x60;&#x60; attribute
   *                             for BIM 360 Docs projects. -
   *                             &#x60;&#x60;false&#x60;&#x60;: (Default) Response
   *                             will not include
   *                             &#x60;&#x60;pathInProject&#x60;&#x60; attribute
   *                             for BIM 360 Docs projects. (optional)
   * @return Item
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Item> getItem(String projectId, String itemId, String xUserId, Boolean includePathInProject,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getItem ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getItem");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'itemId' when calling getItem");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (includePathInProject != null) {
      localVarQueryParams.put("includePathInProject", parameterToString(includePathInProject));
    }

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItem Request completed successfully with status " + statusCode);
      Item item = deserialize(entity, new TypeReference<Item>() {
      });
      return new ApiResponse<Item>(statusCode, response.getHeaders(), item);
    } catch (DataManagementApiException e) {
      this.logger.error("getItem Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItem Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Parent of an Item
   * Returns the parent folder of the specified item.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
   *                  Docs, a hub ID corresponds to an Account ID. To convert a
   *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
   *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
   *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                  translates to a hub ID of
   *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                  convert an ACC or BIM 360 project ID to a Data Management
   *                  project ID prefix the ACC or BIM 360 project ID with
   *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
   *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                  (required)
   * @param itemId    The unique identifier of an item. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Folder
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Folder> getItemParentFolder(String projectId, String itemId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getItemParentFolder ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getItemParentFolder");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'itemId' when calling getItemParentFolder");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/parent"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItemParentFolder Request completed successfully with status " + statusCode);
      Folder folder = deserialize(entity, new TypeReference<Folder>() {
      });
      return new ApiResponse<Folder>(statusCode, response.getHeaders(), folder);
    } catch (DataManagementApiException e) {
      this.logger.error("getItemParentFolder Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItemParentFolder Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Related Resources for an Item
   * Returns the resources (items, folders, and versions) that have a custom
   * relationship with the specified item. Custom relationships can be established
   * between an item and other resources within the data domain service (folders,
   * items, and versions).
   * 
   * 
   * Each relationship is defined by the ID of the object at the other end of the
   * relationship, together with type, attributes, and relationships links.
   * Callers will typically use a filter parameter to restrict the response to the
   * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
   * are interested in.
   * 
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId           The unique identifier of a project. For BIM 360
   *                            Docs and ACC Docs, a hub ID corresponds to an
   *                            Account ID. To convert a BIM 360 or ACC Account ID
   *                            to a hub ID, prefix the Account ID with
   *                            &#x60;&#x60;b.&#x60;&#x60;. For example, an
   *                            Account ID of
   *                            &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                            translates to a hub ID of
   *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                            Similarly, to convert an ACC or BIM 360 project ID
   *                            to a Data Management project ID prefix the ACC or
   *                            BIM 360 project ID with
   *                            &#x60;&#x60;b.&#x60;&#x60;. For example, a project
   *                            ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                            translates to a project ID of
   *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                            (required)
   * @param itemId              The unique identifier of an item. (required)
   * @param xUserId             In a two-legged authentication context, an app has
   *                            access to all users specified by the administrator
   *                            in the SaaS integrations UI. By providing this
   *                            header, the API call will be limited to act only
   *                            on behalf of the specified user. (optional)
   * @param filterType          Filter by the &#x60;&#x60;type&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. Supported
   *                            values include &#x60;&#x60;folders&#x60;&#x60;,
   *                            &#x60;&#x60;items&#x60;&#x60;, and
   *                            &#x60;&#x60;versions&#x60;&#x60;. (optional)
   * @param filterId            Filter by the &#x60;&#x60;id&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. (optional)
   * @param filterExtensionType Filter by the extension type. (optional)
   * @return Refs
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Refs> getItemRefs(String projectId, String itemId, String xUserId,
      List<FilterTypeVersion> filterType, List<String> filterId, List<String> filterExtensionType, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getItemRefs ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getItemRefs");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'itemId' when calling getItemRefs");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (filterType != null) {
      localVarQueryParams.put("filter[type]", parameterToString(filterType));
    }
    if (filterId != null) {
      localVarQueryParams.put("filter[id]", parameterToString(filterId));
    }
    if (filterExtensionType != null) {
      localVarQueryParams.put("filter[extension.type]", parameterToString(filterExtensionType));
    }

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItemRefs Request completed successfully with status " + statusCode);
      Refs refs = deserialize(entity, new TypeReference<Refs>() {
      });
      return new ApiResponse<Refs>(statusCode, response.getHeaders(), refs);
    } catch (DataManagementApiException e) {
      this.logger.error("getItemRefs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItemRefs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Relationship Links for an Item
   * Returns a list of links for the specified item.
   * 
   * Custom relationships can be established between an item and other external
   * resources residing outside the data domain service. A link’s
   * &#x60;&#x60;href&#x60;&#x60; attribute defines the target URI to access a
   * resource.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
   *                  Docs, a hub ID corresponds to an Account ID. To convert a
   *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
   *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
   *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                  translates to a hub ID of
   *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                  convert an ACC or BIM 360 project ID to a Data Management
   *                  project ID prefix the ACC or BIM 360 project ID with
   *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
   *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                  (required)
   * @param itemId    The unique identifier of an item. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return RelationshipLinks
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<RelationshipLinks> getItemRelationshipsLinks(String projectId, String itemId, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getItemRelationshipsLinks ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getItemRelationshipsLinks");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'itemId' when calling getItemRelationshipsLinks");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/relationships/links"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItemRelationshipsLinks Request completed successfully with status " + statusCode);
      RelationshipLinks relationshipLinks = deserialize(entity, new TypeReference<RelationshipLinks>() {
      });
      return new ApiResponse<RelationshipLinks>(statusCode, response.getHeaders(), relationshipLinks);
    } catch (DataManagementApiException e) {
      this.logger.error("getItemRelationshipsLinks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItemRelationshipsLinks Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Custom Relationships for an Item
   * Returns the custom relationships that are associated with the specified item.
   * Custom relationships can be established between an item and other resources
   * within the &#x60;&#x60;data&#x60;&#x60; domain service (folders, items, and
   * versions).
   * 
   * Each relationship is defined by the ID of the object at the other end of the
   * relationship, together with type, specific reference meta including extension
   * data.
   * Callers will typically use a filter parameter to restrict the response to the
   * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
   * are interested in.
   * The response body will have an included array that contains the resources in
   * the relationship, which is essentially what is returned by the [List Related
   * Resources for an
   * Item](/en/docs/data/v2/reference/http/projects-project_id-items-item_id-refs-GET/)
   * operation.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId           The unique identifier of a project. For BIM 360
   *                            Docs and ACC Docs, a hub ID corresponds to an
   *                            Account ID. To convert a BIM 360 or ACC Account ID
   *                            to a hub ID, prefix the Account ID with
   *                            &#x60;&#x60;b.&#x60;&#x60;. For example, an
   *                            Account ID of
   *                            &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                            translates to a hub ID of
   *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                            Similarly, to convert an ACC or BIM 360 project ID
   *                            to a Data Management project ID prefix the ACC or
   *                            BIM 360 project ID with
   *                            &#x60;&#x60;b.&#x60;&#x60;. For example, a project
   *                            ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                            translates to a project ID of
   *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                            (required)
   * @param itemId              The unique identifier of an item. (required)
   * @param xUserId             In a two-legged authentication context, an app has
   *                            access to all users specified by the administrator
   *                            in the SaaS integrations UI. By providing this
   *                            header, the API call will be limited to act only
   *                            on behalf of the specified user. (optional)
   * @param filterType          Filter by the &#x60;&#x60;type&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. Supported
   *                            values include &#x60;&#x60;folders&#x60;&#x60;,
   *                            &#x60;&#x60;items&#x60;&#x60;, and
   *                            &#x60;&#x60;versions&#x60;&#x60;. (optional)
   * @param filterId            Filter by the &#x60;&#x60;id&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. (optional)
   * @param filterRefType       Filter by &#x60;&#x60;refType&#x60;&#x60;.
   *                            Possible values: &#x60;&#x60;derived&#x60;&#x60;,
   *                            &#x60;&#x60;dependencies&#x60;&#x60;,
   *                            &#x60;&#x60;auxiliary&#x60;&#x60;,
   *                            &#x60;&#x60;xrefs&#x60;&#x60;, and
   *                            &#x60;&#x60;includes&#x60;&#x60;. (optional)
   * @param filterDirection     Filter by the direction of the reference. Possible
   *                            values: &#x60;&#x60;from&#x60;&#x60; and
   *                            &#x60;&#x60;to&#x60;&#x60;. (optional)
   * @param filterExtensionType Filter by the extension type. (optional)
   * @return RelationshipRefs
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<RelationshipRefs> getItemRelationshipsRefs(String projectId, String itemId, String xUserId,
      List<FilterTypeVersion> filterType, List<String> filterId, FilterRefType filterRefType,
      FilterDirection filterDirection, List<String> filterExtensionType, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getItemRelationshipsRefs ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getItemRelationshipsRefs");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'itemId' when calling getItemRelationshipsRefs");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/relationships/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (filterType != null) {
      localVarQueryParams.put("filter[type]", parameterToString(filterType));
    }
    if (filterId != null) {
      localVarQueryParams.put("filter[id]", parameterToString(filterId));
    }
    if (filterRefType != null) {
      localVarQueryParams.put("filter[refType]", parameterToString(filterRefType));
    }
    if (filterDirection != null) {
      localVarQueryParams.put("filter[direction]", parameterToString(filterDirection));
    }
    if (filterExtensionType != null) {
      localVarQueryParams.put("filter[extension.type]", parameterToString(filterExtensionType));
    }

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItemRelationshipsRefs Request completed successfully with status " + statusCode);
      RelationshipRefs relationshipRefs = deserialize(entity, new TypeReference<RelationshipRefs>() {
      });
      return new ApiResponse<RelationshipRefs>(statusCode, response.getHeaders(), relationshipRefs);
    } catch (DataManagementApiException e) {
      this.logger.error("getItemRelationshipsRefs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItemRelationshipsRefs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Tip Version of an Item
   * Returns the latest version of the specified item. A project can contain
   * multiple versions of a resource item. The latest version is referred to as
   * the tip version, which is returned by this operation.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
   *                  Docs, a hub ID corresponds to an Account ID. To convert a
   *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
   *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
   *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                  translates to a hub ID of
   *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                  convert an ACC or BIM 360 project ID to a Data Management
   *                  project ID prefix the ACC or BIM 360 project ID with
   *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
   *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                  (required)
   * @param itemId    The unique identifier of an item. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return ItemTip
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<ItemTip> getItemTip(String projectId, String itemId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getItemTip ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getItemTip");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'itemId' when calling getItemTip");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/tip"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItemTip Request completed successfully with status " + statusCode);
      ItemTip itemTip = deserialize(entity, new TypeReference<ItemTip>() {
      });
      return new ApiResponse<ItemTip>(statusCode, response.getHeaders(), itemTip);
    } catch (DataManagementApiException e) {
      this.logger.error("getItemTip Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItemTip Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List all Versions of an Item
   * Lists all versions of the specified item. A project can contain multiple
   * versions of a resource item.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId           The unique identifier of a project. For BIM 360
   *                            Docs and ACC Docs, a hub ID corresponds to an
   *                            Account ID. To convert a BIM 360 or ACC Account ID
   *                            to a hub ID, prefix the Account ID with
   *                            &#x60;&#x60;b.&#x60;&#x60;. For example, an
   *                            Account ID of
   *                            &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                            translates to a hub ID of
   *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                            Similarly, to convert an ACC or BIM 360 project ID
   *                            to a Data Management project ID prefix the ACC or
   *                            BIM 360 project ID with
   *                            &#x60;&#x60;b.&#x60;&#x60;. For example, a project
   *                            ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                            translates to a project ID of
   *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                            (required)
   * @param itemId              The unique identifier of an item. (required)
   * @param xUserId             In a two-legged authentication context, an app has
   *                            access to all users specified by the administrator
   *                            in the SaaS integrations UI. By providing this
   *                            header, the API call will be limited to act only
   *                            on behalf of the specified user. (optional)
   * @param filterId            Filter by the &#x60;&#x60;id&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. (optional)
   * @param filterExtensionType Filter by the extension type. (optional)
   * @param filterVersionNumber Filter by versionNumber. (optional)
   * @param pageNumber          Specifies what page to return. Page numbers are
   *                            0-based (the first page is page 0). (optional)
   * @param pageLimit           Specifies the maximum number of elements to return
   *                            in the page. The default value is 200. The min
   *                            value is 1. The max value is 200. (optional)
   * @return Versions
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Versions> getItemVersions(String projectId, String itemId, String xUserId, List<String> filterId,
      List<String> filterExtensionType, List<Integer> filterVersionNumber, Integer pageNumber, Integer pageLimit,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getItemVersions ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getItemVersions");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'itemId' when calling getItemVersions");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}/versions"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (filterId != null) {
      localVarQueryParams.put("filter[id]", parameterToString(filterId));
    }
    if (filterExtensionType != null) {
      localVarQueryParams.put("filter[extension.type]", parameterToString(filterExtensionType));
    }
    if (filterVersionNumber != null) {
      localVarQueryParams.put("filter[versionNumber]", parameterToString(filterVersionNumber));
    }
    if (pageNumber != null) {
      localVarQueryParams.put("page[number]", parameterToString(pageNumber));
    }
    if (pageLimit != null) {
      localVarQueryParams.put("page[limit]", parameterToString(pageLimit));
    }

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getItemVersions Request completed successfully with status " + statusCode);
      Versions versions = deserialize(entity, new TypeReference<Versions>() {
      });
      return new ApiResponse<Versions>(statusCode, response.getHeaders(), versions);
    } catch (DataManagementApiException e) {
      this.logger.error("getItemVersions Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getItemVersions Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Update an Item
   * Updates the &#x60;&#x60;displayName&#x60;&#x60; of the specified item. Note
   * that updating the &#x60;&#x60;displayName&#x60;&#x60; of an item is not
   * supported for BIM 360 Docs or ACC items.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId         The unique identifier of a project. For BIM 360 Docs
   *                          and ACC Docs, a hub ID corresponds to an Account ID.
   *                          To convert a BIM 360 or ACC Account ID to a hub ID,
   *                          prefix the Account ID with
   *                          &#x60;&#x60;b.&#x60;&#x60;. For example, an Account
   *                          ID of
   *                          &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                          translates to a hub ID of
   *                          &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly,
   *                          to convert an ACC or BIM 360 project ID to a Data
   *                          Management project ID prefix the ACC or BIM 360
   *                          project ID with &#x60;&#x60;b.&#x60;&#x60;. For
   *                          example, a project ID of
   *                          &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to
   *                          a project ID of
   *                          &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
   * @param itemId            The unique identifier of an item. (required)
   * @param modifyItemPayload Describe the item to be patched. (required)
   * @param xUserId           In a two-legged authentication context, an app has
   *                          access to all users specified by the administrator
   *                          in the SaaS integrations UI. By providing this
   *                          header, the API call will be limited to act only on
   *                          behalf of the specified user. (optional)
   * @return Item
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Item> patchItem(String projectId, String itemId, ModifyItemPayload modifyItemPayload,
      String xUserId, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into patchItem ");

    Object localVarPostBody = modifyItemPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling patchItem");
    }

    // verify the required parameter 'itemId' is set
    if (itemId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'itemId' when calling patchItem");
    }

    // verify the required parameter 'modifyItemPayload' is set
    if (modifyItemPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'modifyItemPayload' when calling patchItem");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/items/{item_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "item_id" + "\\}", parameterToString(itemId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (xUserId != null) {
      localVarHeaderParams.put("x-user-id", parameterToString(xUserId));
    }

    localVarHeaderParams.put("Content-Type", "application/vnd.api+json");
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Patch",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new DataManagementApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("patchItem Request completed successfully with status " + statusCode);
      Item item = deserialize(entity, new TypeReference<Item>() {
      });
      return new ApiResponse<Item>(statusCode, response.getHeaders(), item);
    } catch (DataManagementApiException e) {
      this.logger.error("patchItem Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("patchItem Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

}
