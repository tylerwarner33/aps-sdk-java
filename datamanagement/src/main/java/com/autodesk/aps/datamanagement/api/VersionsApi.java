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
import com.autodesk.aps.datamanagement.model.CreatedVersion;
import com.autodesk.aps.datamanagement.model.DownloadFormats;
import com.autodesk.aps.datamanagement.model.Downloads;
import com.autodesk.aps.datamanagement.model.FilterDirection;
import com.autodesk.aps.datamanagement.model.FilterRefType;
import com.autodesk.aps.datamanagement.model.FilterTypeVersion;
import com.autodesk.aps.datamanagement.model.Item;
import com.autodesk.aps.datamanagement.model.ModifyVersionPayload;
import com.autodesk.aps.datamanagement.model.Refs;
import com.autodesk.aps.datamanagement.model.RelationshipLinks;
import com.autodesk.aps.datamanagement.model.RelationshipRefs;
import com.autodesk.aps.datamanagement.model.RelationshipRefsPayload;
import com.autodesk.aps.datamanagement.model.Version;
import com.autodesk.aps.datamanagement.model.VersionPayload;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class VersionsApi extends BaseApi {

  public VersionsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create a Version
   * Creates a new versions of an existing item.
   * 
   * Before creating a new version you must create a storage location for the
   * version in OSS, and upload the file to that location. For more details about
   * the workflow, see the tutorial on uploading a file.
   * 
   * This operation also allows you to create a new version of an item by copying
   * a specific version of an existing item from another folder within the
   * project. The new version becomes the tip version of the item.
   * 
   * Use the [Create an
   * Item](/en/docs/data/v2/reference/http/projects-project_id-items-POST/)
   * operation to copy a specific version of an existing item as a new item in
   * another folder.
   * 
   * This operation can also be used to delete files on BIM360 Document
   * Management. For more information, please refer to the delete and restore a
   * file tutorial.
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
   * @param projectId      The unique identifier of a project. For BIM 360 Docs
   *                       and ACC Docs, a hub ID corresponds to an Account ID. To
   *                       convert a BIM 360 or ACC Account ID to a hub ID, prefix
   *                       the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
   *                       example, an Account ID of
   *                       &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                       translates to a hub ID of
   *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
   *                       convert an ACC or BIM 360 project ID to a Data
   *                       Management project ID prefix the ACC or BIM 360 project
   *                       ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
   *                       project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
   *                       translates to a project ID of
   *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
   * @param versionPayload (required)
   * @param xUserId        In a two-legged authentication context, an app has
   *                       access to all users specified by the administrator in
   *                       the SaaS integrations UI. By providing this header, the
   *                       API call will be limited to act only on behalf of the
   *                       specified user. (optional)
   * @param copyFrom       The Version ID (URN) of the version to copy from.
   *                       **Note**: This parameter is relevant only for copying
   *                       files to BIM 360 Docs. For information on how to find
   *                       the URN, see the initial steps of the [Download a
   *                       File](/en/docs/data/v2/tutorials/download-file/)
   *                       tutorial. You can only copy files to the Plans folder
   *                       or to subfolders of the Plans folder with an
   *                       &#x60;&#x60;item:autodesk.bim360:Document&#x60;&#x60;
   *                       item extension type. You can only copy files to the
   *                       Project Files folder or to subfolders of the Project
   *                       Files folder with an
   *                       &#x60;&#x60;item:autodesk.bim360:File&#x60;&#x60; item
   *                       extension type. To verify an item’s extension type, use
   *                       the [Get an
   *                       Item](/en/docs/data/v2/reference/http/projects-project_id-items-item_id-GET/)
   *                       operation, and check the
   *                       &#x60;&#x60;attributes.extension.type&#x60;&#x60;
   *                       attribute. Note that if you copy a file to the Plans
   *                       folder or to a subfolder of the Plans folder, the
   *                       copied file inherits the permissions of the source
   *                       file. For example, if users of your app did not have
   *                       permission to download files in the source folder, but
   *                       does have permission to download files in the target
   *                       folder, they will not be able to download the copied
   *                       file. Note that you cannot copy a file while it is
   *                       being uploaded, updated, or copied. To verify the
   *                       current process state of a file, call the [Get an
   *                       Item](en/docs/data/v2/reference/http/projects-project_id-items-item_id-GET/)
   *                       operation , and check the
   *                       &#x60;&#x60;attributes.extension.data.processState&#x60;&#x60;
   *                       attribute. (optional)
   * @return CreatedVersion
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<CreatedVersion> createVersion(String projectId, VersionPayload versionPayload, String xUserId,
      String copyFrom, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into createVersion ");

    Object localVarPostBody = versionPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling createVersion");
    }

    // verify the required parameter 'versionPayload' is set
    if (versionPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionPayload' when calling createVersion");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (copyFrom != null) {
      localVarQueryParams.put("copyFrom", parameterToString(copyFrom));
    }

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
      this.logger.info("createVersion Request completed successfully with status " + statusCode);
      CreatedVersion createdVersion = deserialize(entity, new TypeReference<CreatedVersion>() {
      });
      return new ApiResponse<CreatedVersion>(statusCode, response.getHeaders(), createdVersion);
    } catch (DataManagementApiException e) {
      this.logger.error("createVersion Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createVersion Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Create a Custom Relationship for a Version
   * Creates a custom relationship between a version of an item and another
   * resource within the data domain service (folder, item, or version).
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
   * @param versionId               The URL encoded unique identifier of a
   *                                version. (required)
   * @param relationshipRefsPayload (required)
   * @param xUserId                 In a two-legged authentication context, an app
   *                                has access to all users specified by the
   *                                administrator in the SaaS integrations UI. By
   *                                providing this header, the API call will be
   *                                limited to act only on behalf of the specified
   *                                user. (optional)
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Void> createVersionRelationshipsRef(String projectId, String versionId,
      RelationshipRefsPayload relationshipRefsPayload, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into createVersionRelationshipsRef ");

    Object localVarPostBody = relationshipRefsPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling createVersionRelationshipsRef");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling createVersionRelationshipsRef");
    }

    // verify the required parameter 'relationshipRefsPayload' is set
    if (relationshipRefsPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'relationshipRefsPayload' when calling createVersionRelationshipsRef");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}/relationships/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("createVersionRelationshipsRef Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (DataManagementApiException e) {
      this.logger.error("createVersionRelationshipsRef Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createVersionRelationshipsRef Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get a Version
   * Returns the specified version of an item.
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
   * @param versionId The URL encoded unique identifier of a version. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Version
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Version> getVersion(String projectId, String versionId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getVersion ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getVersion");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'versionId' when calling getVersion");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("getVersion Request completed successfully with status " + statusCode);
      Version version = deserialize(entity, new TypeReference<Version>() {
      });
      return new ApiResponse<Version>(statusCode, response.getHeaders(), version);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersion Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersion Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Supported Download Formats
   * Returns a list of file formats the specified version of an item can be
   * downloaded as.
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
   * @param versionId The URL encoded unique identifier of a version. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return DownloadFormats
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<DownloadFormats> getVersionDownloadFormats(String projectId, String versionId, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getVersionDownloadFormats ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getVersionDownloadFormats");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling getVersionDownloadFormats");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}/downloadFormats"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("getVersionDownloadFormats Request completed successfully with status " + statusCode);
      DownloadFormats downloadFormats = deserialize(entity, new TypeReference<DownloadFormats>() {
      });
      return new ApiResponse<DownloadFormats>(statusCode, response.getHeaders(), downloadFormats);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersionDownloadFormats Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersionDownloadFormats Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Available Download Formats
   * Returns the list of file formats of the specified version of an item
   * currently available for download.
   * 
   * **Note:** This operation is not fully implemented as yet. It currently
   * returns an empty data object.
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
   * @param versionId            The URL encoded unique identifier of a version.
   *                             (required)
   * @param xUserId              In a two-legged authentication context, an app
   *                             has access to all users specified by the
   *                             administrator in the SaaS integrations UI. By
   *                             providing this header, the API call will be
   *                             limited to act only on behalf of the specified
   *                             user. (optional)
   * @param filterFormatFileType Filter by the file type of the download object.
   *                             (optional)
   * @return Downloads
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Downloads> getVersionDownloads(String projectId, String versionId, String xUserId,
      List<String> filterFormatFileType, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getVersionDownloads ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getVersionDownloads");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling getVersionDownloads");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}/downloads"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (filterFormatFileType != null) {
      localVarQueryParams.put("filter[format.fileType]", parameterToString(filterFormatFileType));
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
      this.logger.info("getVersionDownloads Request completed successfully with status " + statusCode);
      Downloads downloads = deserialize(entity, new TypeReference<Downloads>() {
      });
      return new ApiResponse<Downloads>(statusCode, response.getHeaders(), downloads);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersionDownloads Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersionDownloads Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Item by Version
   * Returns the item corresponding to the specified version.
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
   * @param versionId The URL encoded unique identifier of a version. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Item
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Item> getVersionItem(String projectId, String versionId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getVersionItem ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getVersionItem");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling getVersionItem");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}/item"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("getVersionItem Request completed successfully with status " + statusCode);
      Item item = deserialize(entity, new TypeReference<Item>() {
      });
      return new ApiResponse<Item>(statusCode, response.getHeaders(), item);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersionItem Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersionItem Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Related Resources for a Version
   * Returns the resources (items, folders, and versions) that have a custom
   * relationship with the specified version.
   * 
   * Custom relationships can be established between a version of an item and
   * other resources within the data domain service (folders, items, and
   * versions).
   * 
   * - Each relationship is defined by the id of the object at the other end of
   * the relationship, together with type, attributes, and relationships links.
   * - Callers will typically use a filter parameter to restrict the response to
   * the custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;)
   * they are interested in.
   * - The response body will have an included array that contains the ref
   * resources that are involved in the relationship, which is essentially the
   * response to the [List Custom Relationships for a
   * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-relationships-refs-GET/)
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
   * @param versionId           The URL encoded unique identifier of a version.
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
   * @param filterExtensionType Filter by the extension type. (optional)
   * @return Refs
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Refs> getVersionRefs(String projectId, String versionId, String xUserId,
      List<FilterTypeVersion> filterType, List<String> filterId, List<String> filterExtensionType, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getVersionRefs ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getVersionRefs");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling getVersionRefs");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("getVersionRefs Request completed successfully with status " + statusCode);
      Refs refs = deserialize(entity, new TypeReference<Refs>() {
      });
      return new ApiResponse<Refs>(statusCode, response.getHeaders(), refs);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersionRefs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersionRefs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Links for a Version
   * Returns a collection of links for the specified version of an item. Custom
   * relationships can be established between a version of an item and other
   * external resources residing outside the data domain service. A link’s href
   * defines the target URI to access the resource.
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
   * @param versionId The URL encoded unique identifier of a version. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return RelationshipLinks
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<RelationshipLinks> getVersionRelationshipsLinks(String projectId, String versionId, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getVersionRelationshipsLinks ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getVersionRelationshipsLinks");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling getVersionRelationshipsLinks");
    }

    // create path and map variables
    String localVarPath = "/projects/{project_id}/versions/{version_id}/relationships/links"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("getVersionRelationshipsLinks Request completed successfully with status " + statusCode);
      RelationshipLinks relationshipLinks = deserialize(entity, new TypeReference<RelationshipLinks>() {
      });
      return new ApiResponse<RelationshipLinks>(statusCode, response.getHeaders(), relationshipLinks);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersionRelationshipsLinks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersionRelationshipsLinks Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Custom Relationships for a Version
   * Returns the custom relationships for the specified version.
   * 
   * Custom relationships can be established between a version of an item and
   * other resources within the data domain service (folders, items, and
   * versions).
   * 
   * - Each relationship is defined by the id of the object at the other end of
   * the relationship, together with type, specific reference meta including
   * extension data.
   * - Callers will typically use a filter parameter to restrict the response to
   * the custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;)
   * they are interested in.
   * - The response body will have an included array that contains the resources
   * in the relationship, which is essentially the response to the [List Related
   * Resources
   * operation](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-relationships-refs-POST/).
   * - To get custom relationships for multiple versions, see the ListRefs
   * command.
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
   * @param versionId           The URL encoded unique identifier of a version.
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
  public ApiResponse<RelationshipRefs> getVersionRelationshipsRefs(String projectId, String versionId, String xUserId,
      List<FilterTypeVersion> filterType, List<String> filterId, FilterRefType filterRefType,
      FilterDirection filterDirection, List<String> filterExtensionType, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getVersionRelationshipsRefs ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getVersionRelationshipsRefs");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'versionId' when calling getVersionRelationshipsRefs");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}/relationships/refs"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

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
      this.logger.info("getVersionRelationshipsRefs Request completed successfully with status " + statusCode);
      RelationshipRefs relationshipRefs = deserialize(entity, new TypeReference<RelationshipRefs>() {
      });
      return new ApiResponse<RelationshipRefs>(statusCode, response.getHeaders(), relationshipRefs);
    } catch (DataManagementApiException e) {
      this.logger.error("getVersionRelationshipsRefs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getVersionRelationshipsRefs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Update a Version
   * Updates the properties of the specified version of an item. Currently, you
   * can only change the name of the version.
   * 
   * **Note:** This operation is not supported for BIM 360 and ACC. If you want to
   * rename a version, create a new version with a new name.
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
   * @param versionId            The URL encoded unique identifier of a version.
   *                             (required)
   * @param modifyVersionPayload (required)
   * @return Version
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Version> patchVersion(String projectId, String versionId,
      ModifyVersionPayload modifyVersionPayload, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into patchVersion ");

    Object localVarPostBody = modifyVersionPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling patchVersion");
    }

    // verify the required parameter 'versionId' is set
    if (versionId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'versionId' when calling patchVersion");
    }

    // verify the required parameter 'modifyVersionPayload' is set
    if (modifyVersionPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'modifyVersionPayload' when calling patchVersion");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/versions/{version_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "version_id" + "\\}", parameterToString(versionId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
      this.logger.info("patchVersion Request completed successfully with status " + statusCode);
      Version version = deserialize(entity, new TypeReference<Version>() {
      });
      return new ApiResponse<Version>(statusCode, response.getHeaders(), version);
    } catch (DataManagementApiException e) {
      this.logger.error("patchVersion Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("patchVersion Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

}
