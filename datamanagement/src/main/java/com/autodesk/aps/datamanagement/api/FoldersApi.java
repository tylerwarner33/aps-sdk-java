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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.datamanagement.BaseApi;
import com.autodesk.aps.datamanagement.DataManagementApiException;
import com.autodesk.aps.datamanagement.model.ComparisonTypes;
import com.autodesk.aps.datamanagement.model.FilterDirection;
import com.autodesk.aps.datamanagement.model.FilterRefType;
import com.autodesk.aps.datamanagement.model.FilterType;
import com.autodesk.aps.datamanagement.model.FilterTypeVersion;
import com.autodesk.aps.datamanagement.model.Folder;
import com.autodesk.aps.datamanagement.model.FolderContents;
import com.autodesk.aps.datamanagement.model.FolderPayload;
import com.autodesk.aps.datamanagement.model.FolderRefs;
import com.autodesk.aps.datamanagement.model.GetFolderSearchOptionalParams;
import com.autodesk.aps.datamanagement.model.ModifyFolderPayload;
import com.autodesk.aps.datamanagement.model.RelationshipLinks;
import com.autodesk.aps.datamanagement.model.RelationshipRefs;
import com.autodesk.aps.datamanagement.model.RelationshipRefsPayload;
import com.autodesk.aps.datamanagement.model.Search;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class FoldersApi extends BaseApi {

  public FoldersApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create a Folder
   * Creates a new folder in the specified project. Use the
   * &#x60;&#x60;parent&#x60;&#x60; attribute in the request body to specify where
   * in the hierarchy the new folder should be located. Folders can be nested up
   * to 25 levels deep.
   * 
   * Use the &#x60;Modify a Folder
   * &lt;/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-PATCH/&gt;&#x60;_
   * operation to delete and restore folders.
   * 
   * Before you use the Data Management API to access BIM 360 Docs folders,
   * provision your app through the BIM 360 Account Administrator portal. For
   * details, see the [Manage Access to Docs
   * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId     The unique identifier of a project. For BIM 360 Docs and
   *                      ACC Docs, a hub ID corresponds to an Account ID. To
   *                      convert a BIM 360 or ACC Account ID to a hub ID, prefix
   *                      the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
   *                      example, an Account ID of
   *                      &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                      translates to a hub ID of
   *                      &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                      convert an ACC or BIM 360 project ID to a Data
   *                      Management project ID prefix the ACC or BIM 360 project
   *                      ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
   *                      project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                      translates to a project ID of
   *                      &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
   * @param folderPayload (required)
   * @param xUserId       In a two-legged authentication context, an app has
   *                      access to all users specified by the administrator in
   *                      the SaaS integrations UI. By providing this header, the
   *                      API call will be limited to act only on behalf of the
   *                      specified user. (optional)
   * @return Folder
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Folder> createFolder(String projectId, FolderPayload folderPayload, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into createFolder ");

    Object localVarPostBody = folderPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling createFolder");
    }

    // verify the required parameter 'folderPayload' is set
    if (folderPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderPayload' when calling createFolder");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

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
      this.logger.info("createFolder Request completed successfully with status " + statusCode);
      Folder folder = deserialize(entity, new TypeReference<Folder>() {
      });
      return new ApiResponse<Folder>(statusCode, response.getHeaders(), folder);
    } catch (DataManagementApiException e) {
      this.logger.error("createFolder Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createFolder Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Create a Custom Relationship for a Folder
   * Creates a custom relationship between a folder and another resource within
   * the data domain service (folder, item, or version).
   * 
   * @param folderId                The unique identifier of a folder. (required)
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
   * @param relationshipRefsPayload (required)
   * @param xUserId                 In a two-legged authentication context, an app
   *                                has access to all users specified by the
   *                                administrator in the SaaS integrations UI. By
   *                                providing this header, the API call will be
   *                                limited to act only on behalf of the specified
   *                                user. (optional)
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Void> createFolderRelationshipsRef(String folderId, String projectId,
      RelationshipRefsPayload relationshipRefsPayload, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into createFolderRelationshipsRef ");

    Object localVarPostBody = relationshipRefsPayload;

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderId' when calling createFolderRelationshipsRef");
    }

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling createFolderRelationshipsRef");
    }

    // verify the required parameter 'relationshipRefsPayload' is set
    if (relationshipRefsPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'relationshipRefsPayload' when calling createFolderRelationshipsRef");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/relationships/refs"
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId))
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

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
      this.logger.info("createFolderRelationshipsRef Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (DataManagementApiException e) {
      this.logger.error("createFolderRelationshipsRef Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createFolderRelationshipsRef Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get a Folder
   * Returns the folder specified by the &#x60;&#x60;folder_id&#x60;&#x60;
   * parameter from within the project identified by the
   * &#x60;&#x60;project_id&#x60;&#x60; parameter. All folders and subfolders
   * within a project (including the root folder) have a unique ID.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId       The unique identifier of a project. For BIM 360 Docs
   *                        and ACC Docs, a hub ID corresponds to an Account ID.
   *                        To convert a BIM 360 or ACC Account ID to a hub ID,
   *                        prefix the Account ID with &#x60;&#x60;b.&#x60;&#x60;.
   *                        For example, an Account ID of
   *                        &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                        translates to a hub ID of
   *                        &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                        convert an ACC or BIM 360 project ID to a Data
   *                        Management project ID prefix the ACC or BIM 360
   *                        project ID with &#x60;&#x60;b.&#x60;&#x60;. For
   *                        example, a project ID of
   *                        &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                        project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                        (required)
   * @param folderId        The unique identifier of a folder. (required)
   * @param ifModifiedSince Specify a date in the
   *                        &#x60;&#x60;YYYY-MM-DDThh:mm:ss.sz&#x60;&#x60; format.
   *                        If the resource has not been modified since the
   *                        specified date/time, the response will return a HTTP
   *                        status of 304 without any response body; the
   *                        &#x60;&#x60;Last-Modified&#x60;&#x60; response header
   *                        will contain the date of last modification. (optional)
   * @param xUserId         In a two-legged authentication context, an app has
   *                        access to all users specified by the administrator in
   *                        the SaaS integrations UI. By providing this header,
   *                        the API call will be limited to act only on behalf of
   *                        the specified user. (optional)
   * @return Folder
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Folder> getFolder(String projectId, String folderId, OffsetDateTime ifModifiedSince,
      String xUserId, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getFolder ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getFolder");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'folderId' when calling getFolder");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (ifModifiedSince != null) {
      localVarHeaderParams.put("If-Modified-Since", parameterToString(ifModifiedSince));
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
      this.logger.info("getFolder Request completed successfully with status " + statusCode);
      Folder folder = deserialize(entity, new TypeReference<Folder>() {
      });
      return new ApiResponse<Folder>(statusCode, response.getHeaders(), folder);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolder Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolder Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Folder Contents
   * Returns a list of items and folders within the specified folder. Items
   * represent word documents, fusion design files, drawings, spreadsheets, etc.
   * 
   * The resources contained in the &#x60;&#x60;included&#x60;&#x60; array of the
   * response are their tip versions.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId                    The unique identifier of a project. For
   *                                     BIM 360 Docs and ACC Docs, a hub ID
   *                                     corresponds to an Account ID. To convert
   *                                     a BIM 360 or ACC Account ID to a hub ID,
   *                                     prefix the Account ID with
   *                                     &#x60;&#x60;b.&#x60;&#x60;. For example,
   *                                     an Account ID of
   *                                     &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                                     translates to a hub ID of
   *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                                     Similarly, to convert an ACC or BIM 360
   *                                     project ID to a Data Management project
   *                                     ID prefix the ACC or BIM 360 project ID
   *                                     with &#x60;&#x60;b.&#x60;&#x60;. For
   *                                     example, a project ID of
   *                                     &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                                     translates to a project ID of
   *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                                     (required)
   * @param folderId                     The unique identifier of a folder.
   *                                     (required)
   * @param xUserId                      In a two-legged authentication context,
   *                                     an app has access to all users specified
   *                                     by the administrator in the SaaS
   *                                     integrations UI. By providing this
   *                                     header, the API call will be limited to
   *                                     act only on behalf of the specified user.
   *                                     (optional)
   * @param filterType                   Filter by the type of the objects in the
   *                                     folder. Supported values are
   *                                     &#x60;&#x60;folders&#x60;&#x60; and
   *                                     &#x60;&#x60;items&#x60;&#x60;. (optional)
   * @param filterId                     Filter by the &#x60;&#x60;id&#x60;&#x60;
   *                                     of the &#x60;&#x60;ref&#x60;&#x60;
   *                                     target. (optional)
   * @param filterExtensionType          Filter by the extension type. (optional)
   * @param filterLastModifiedTimeRollup Filter by the
   *                                     &#x60;&#x60;lastModifiedTimeRollup&#x60;&#x60;
   *                                     attribute. Supported values are date-time
   *                                     string in the form
   *                                     &#x60;&#x60;YYYY-MM-DDTHH:MM:SS.000000Z&#x60;&#x60;
   *                                     or
   *                                     &#x60;&#x60;YYYY-MM-DDTHH:MM:SS&#x60;&#x60;
   *                                     based on RFC3339. (optional)
   * @param pageNumber                   Specifies what page to return. Page
   *                                     numbers are 0-based (the first page is
   *                                     page 0). (optional)
   * @param pageLimit                    Specifies the maximum number of elements
   *                                     to return in the page. The default value
   *                                     is 200. The min value is 1. The max value
   *                                     is 200. (optional)
   * @param includeHidden                &#x60;&#x60;true&#x60;&#x60;: Response
   *                                     will contain items and folders that were
   *                                     deleted from BIM 360 Docs projects.
   *                                     &#x60;&#x60;false&#x60;&#x60;: (Default):
   *                                     Response will not contain items and
   *                                     folders that were deleted from BIM 360
   *                                     Docs projects. To return only items and
   *                                     folders that were deleted from BIM 360
   *                                     Docs projects, see the documentation on
   *                                     [Filtering](/en/docs/data/v2/overview/filtering/).
   *                                     (optional)
   * @return FolderContents
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<FolderContents> getFolderContents(String projectId, String folderId, String xUserId,
      List<FilterType> filterType, List<String> filterId, List<String> filterExtensionType,
      List<String> filterLastModifiedTimeRollup, Integer pageNumber, Integer pageLimit, Boolean includeHidden,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getFolderContents ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getFolderContents");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderId' when calling getFolderContents");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/contents"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

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
    if (filterLastModifiedTimeRollup != null) {
      localVarQueryParams.put("filter[lastModifiedTimeRollup]", parameterToString(filterLastModifiedTimeRollup));
    }
    if (pageNumber != null) {
      localVarQueryParams.put("page[number]", parameterToString(pageNumber));
    }
    if (pageLimit != null) {
      localVarQueryParams.put("page[limit]", parameterToString(pageLimit));
    }
    if (includeHidden != null) {
      localVarQueryParams.put("includeHidden", parameterToString(includeHidden));
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
      this.logger.info("getFolderContents Request completed successfully with status " + statusCode);
      FolderContents folderContents = deserialize(entity, new TypeReference<FolderContents>() {
      });
      return new ApiResponse<FolderContents>(statusCode, response.getHeaders(), folderContents);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolderContents Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolderContents Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Parent of a Folder
   * Returns the parent folder of the specified folder. In a project, folders are
   * organized in a hierarchy. Each folder except for the root folder has a parent
   * folder.
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
   * @param folderId  The unique identifier of a folder. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Folder
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Folder> getFolderParent(String projectId, String folderId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getFolderParent ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getFolderParent");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderId' when calling getFolderParent");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/parent"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

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
      this.logger.info("getFolderParent Request completed successfully with status " + statusCode);
      Folder folder = deserialize(entity, new TypeReference<Folder>() {
      });
      return new ApiResponse<Folder>(statusCode, response.getHeaders(), folder);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolderParent Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolderParent Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Related Resources for a Folder
   * Returns the resources (items, folders, and versions) that have a custom
   * relationship with the specified folder. Custom relationships can be
   * established between a folder and other resources within the data domain
   * service (folders, items, and versions).
   * 
   * Each relationship is defined by the id of the object at the other end of the
   * relationship, together with type, attributes, and relationships links.
   * Callers will typically use a filter parameter to restrict the response to the
   * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
   * are interested in.
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
   * @param folderId            The unique identifier of a folder. (required)
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
   * @return FolderRefs
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<FolderRefs> getFolderRefs(String projectId, String folderId, String xUserId,
      List<FilterTypeVersion> filterType, List<String> filterId, List<String> filterExtensionType, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getFolderRefs ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getFolderRefs");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'folderId' when calling getFolderRefs");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

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
      this.logger.info("getFolderRefs Request completed successfully with status " + statusCode);
      FolderRefs folderRefs = deserialize(entity, new TypeReference<FolderRefs>() {
      });
      return new ApiResponse<FolderRefs>(statusCode, response.getHeaders(), folderRefs);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolderRefs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolderRefs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Relationship Links for a Folder
   * Returns a list of links for the specified folder.
   * 
   * Custom relationships can be established between a folder and other external
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
   * @param folderId  The unique identifier of a folder. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return RelationshipLinks
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<RelationshipLinks> getFolderRelationshipsLinks(String projectId, String folderId, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getFolderRelationshipsLinks ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getFolderRelationshipsLinks");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderId' when calling getFolderRelationshipsLinks");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/relationships/links"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

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
      this.logger.info("getFolderRelationshipsLinks Request completed successfully with status " + statusCode);
      RelationshipLinks relationshipLinks = deserialize(entity, new TypeReference<RelationshipLinks>() {
      });
      return new ApiResponse<RelationshipLinks>(statusCode, response.getHeaders(), relationshipLinks);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolderRelationshipsLinks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolderRelationshipsLinks Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Custom Relationships for a Folder
   * Returns the custom relationships associated with the specified folder. Custom
   * relationships can be established between a folder and other resources within
   * the data domain service (folders, items, and versions).
   * 
   * Each relationship is defined by the ID of the object at the other end of the
   * relationship, together with type, specific reference meta including extension
   * data.
   * Callers will typically use a filter parameter to restrict the response to the
   * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
   * are interested in.
   * The response body will have an included array that contains the resources in
   * the relationship, which is essentially what is returned by the [List Related
   * Resources for a
   * Folder](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-refs-GET/)
   * operation.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param folderId            The unique identifier of a folder. (required)
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
  public ApiResponse<RelationshipRefs> getFolderRelationshipsRefs(String folderId, String projectId, String xUserId,
      List<FilterTypeVersion> filterType, List<String> filterId, FilterRefType filterRefType,
      FilterDirection filterDirection, List<String> filterExtensionType, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getFolderRelationshipsRefs ");

    Object localVarPostBody = null;

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderId' when calling getFolderRelationshipsRefs");
    }

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getFolderRelationshipsRefs");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/relationships/refs"
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId))
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

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
      this.logger.info("getFolderRelationshipsRefs Request completed successfully with status " + statusCode);
      RelationshipRefs relationshipRefs = deserialize(entity, new TypeReference<RelationshipRefs>() {
      });
      return new ApiResponse<RelationshipRefs>(statusCode, response.getHeaders(), relationshipRefs);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolderRelationshipsRefs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolderRelationshipsRefs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Folder and Subfolder Contents
   * Searches the specified folder and its subfolders and returns a list of the
   * latest versions of the items you can access.
   * 
   * 
   * Use the &#x60;&#x60;filter&#x60;&#x60; query string parameter to narrow down
   * the list as appropriate. You can filter by the following properties of the
   * version payload:
   * 
   * - &#x60;&#x60;type&#x60;&#x60; property,
   * - &#x60;&#x60;id&#x60;&#x60; property,
   * - any of the attributes object properties.
   * 
   * For example, you can filter by &#x60;&#x60;createTime&#x60;&#x60; and
   * &#x60;&#x60;mimeType&#x60;&#x60;. It returns tip versions (latest versions)
   * of properties where the filter conditions are satisfied. To verify the
   * properties of the attributes object for a specific version, use the [Get a
   * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-GET/)
   * operation.
   * 
   * To list the immediate contents of the folder without parsing subfolders, use
   * the [List Folder
   * Contents](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-contents-GET/)
   * operation.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param projectId  The unique identifier of a project. For BIM 360 Docs and
   *                   ACC Docs, a hub ID corresponds to an Account ID. To convert
   *                   a BIM 360 or ACC Account ID to a hub ID, prefix the Account
   *                   ID with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account
   *                   ID of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                   translates to a hub ID of
   *                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                   convert an ACC or BIM 360 project ID to a Data Management
   *                   project ID prefix the ACC or BIM 360 project ID with
   *                   &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
   *                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                   project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   *                   (required)
   * @param folderId   The unique identifier of a folder. (required)
   * @param filters    List of filters with field names, operator types, and
   *                   values.
   *                   This provides flexible filtering similar to .NET and
   *                   TypeScript SDKs.
   *                   (optional)
   * @param pageNumber Specifies what page to return. Page numbers are 0-based
   *                   (the first page is page 0). (optional)
   * @return Search
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Search> getFolderSearch(String projectId, String folderId,
      List<GetFolderSearchOptionalParams.Filter> filters,
      Integer pageNumber, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getFolderSearch ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getFolderSearch");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'folderId' when calling getFolderSearch");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}/search"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    // Process flexible filters
    if (filters != null && !filters.isEmpty()) {
      for (GetFolderSearchOptionalParams.Filter filter : filters) {
        String fieldName = filter.getFieldName();
        ComparisonTypes operatorType = filter.getOperatorType();
        List<String> values = filter.getValues();

        if (fieldName != null && values != null && !values.isEmpty()) {
          String filterKey;
          if (operatorType != null) {
            // Use operator format: filter[fieldName]-operator=value
            String operator = operatorType.getValue();
            filterKey = "filter[" + fieldName + "]-" + operator;
          } else {
            // Use direct format: filter[fieldName]=value
            filterKey = "filter[" + fieldName + "]";
          }

          // Join multiple values with commas, or use single value
          String filterValue = values.size() > 1 ? String.join(",", values) : values.get(0);
          localVarQueryParams.put(filterKey, filterValue);
        }
      }
    }

    if (pageNumber != null) {
      localVarQueryParams.put("page[number]", parameterToString(pageNumber));
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
      this.logger.info("getFolderSearch Request completed successfully with status " + statusCode);
      Search search = deserialize(entity, new TypeReference<Search>() {
      });
      return new ApiResponse<Search>(statusCode, response.getHeaders(), search);
    } catch (DataManagementApiException e) {
      this.logger.error("getFolderSearch Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFolderSearch Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Modify a Folder
   * Renames, moves, hides, or unhides a folder. Marking a BIM 360 Docs folder as
   * hidden effectively deletes it. You can restore it by changing its
   * &#x60;&#x60;hidden&#x60;&#x60; attribute. You can also move BIM 360 Docs
   * folders by changing their parent folder.
   * 
   * You cannot permanently delete BIM 360 Docs folders. They are tagged as hidden
   * folders and are removed from the BIM 360 Docs UI and from regular Data
   * Management API responses. You can use the hidden filter
   * (&#x60;&#x60;filter[hidden]&#x3D;true&#x60;&#x60;) to get a list of deleted
   * folders with the [List Folder
   * Contents](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-contents-GET/)
   * operation.
   * 
   * Before you use the Data Management API to access BIM 360 Docs folders,
   * provision your app through the BIM 360 Account Administrator portal. For
   * details, see the [Manage Access to Docs
   * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](/en.docs.acc.v1/overview/introduction/).
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
   * @param folderId            The unique identifier of a folder. (required)
   * @param modifyFolderPayload Describe the folder to be patched. (required)
   * @param xUserId             In a two-legged authentication context, an app has
   *                            access to all users specified by the administrator
   *                            in the SaaS integrations UI. By providing this
   *                            header, the API call will be limited to act only
   *                            on behalf of the specified user. (optional)
   * @return Folder
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Folder> patchFolder(String projectId, String folderId, ModifyFolderPayload modifyFolderPayload,
      String xUserId, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into patchFolder ");

    Object localVarPostBody = modifyFolderPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling patchFolder");
    }

    // verify the required parameter 'folderId' is set
    if (folderId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'folderId' when calling patchFolder");
    }

    // verify the required parameter 'modifyFolderPayload' is set
    if (modifyFolderPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'modifyFolderPayload' when calling patchFolder");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/folders/{folder_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "folder_id" + "\\}", parameterToString(folderId));

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
      this.logger.info("patchFolder Request completed successfully with status " + statusCode);
      Folder folder = deserialize(entity, new TypeReference<Folder>() {
      });
      return new ApiResponse<Folder>(statusCode, response.getHeaders(), folder);
    } catch (DataManagementApiException e) {
      this.logger.error("patchFolder Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("patchFolder Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

}
