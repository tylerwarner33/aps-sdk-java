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
import com.autodesk.aps.datamanagement.model.CreatedDownload;
import com.autodesk.aps.datamanagement.model.Download;
import com.autodesk.aps.datamanagement.model.DownloadPayload;
import com.autodesk.aps.datamanagement.model.Hub;
import com.autodesk.aps.datamanagement.model.Job;
import com.autodesk.aps.datamanagement.model.Project;
import com.autodesk.aps.datamanagement.model.Projects;
import com.autodesk.aps.datamanagement.model.Storage;
import com.autodesk.aps.datamanagement.model.StoragePayload;
import com.autodesk.aps.datamanagement.model.TopFolders;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class ProjectsApi extends BaseApi {

  public ProjectsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create Download
   * Kicks off a job to generate the specified download format of the version.
   * Once the job completes, the specified format becomes available for download.
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
   * @param downloadPayload (required)
   * @param xUserId         In a two-legged authentication context, an app has
   *                        access to all users specified by the administrator in
   *                        the SaaS integrations UI. By providing this header,
   *                        the API call will be limited to act only on behalf of
   *                        the specified user. (optional)
   * @return CreatedDownload
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<CreatedDownload> createDownload(String projectId, DownloadPayload downloadPayload, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into createDownload ");

    Object localVarPostBody = downloadPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling createDownload");
    }

    // verify the required parameter 'downloadPayload' is set
    if (downloadPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'downloadPayload' when calling createDownload");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/downloads"
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
      this.logger.info("createDownload Request completed successfully with status " + statusCode);
      CreatedDownload createdDownload = deserialize(entity, new TypeReference<CreatedDownload>() {
      });
      return new ApiResponse<CreatedDownload>(statusCode, response.getHeaders(), createdDownload);
    } catch (DataManagementApiException e) {
      this.logger.error("createDownload Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createDownload Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Create a Storage Location in OSS
   * Creates a placeholder for an item or a version of an item in the OSS. Later,
   * you can upload the binary content for the item or version to this storage
   * location.
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
   * @param storagePayload (required)
   * @param xUserId        In a two-legged authentication context, an app has
   *                       access to all users specified by the administrator in
   *                       the SaaS integrations UI. By providing this header, the
   *                       API call will be limited to act only on behalf of the
   *                       specified user. (optional)
   * @return Storage
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Storage> createStorage(String projectId, StoragePayload storagePayload, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into createStorage ");

    Object localVarPostBody = storagePayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling createStorage");
    }

    // verify the required parameter 'storagePayload' is set
    if (storagePayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'storagePayload' when calling createStorage");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/storage"
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
      this.logger.info("createStorage Request completed successfully with status " + statusCode);
      Storage storage = deserialize(entity, new TypeReference<Storage>() {
      });
      return new ApiResponse<Storage>(statusCode, response.getHeaders(), storage);
    } catch (DataManagementApiException e) {
      this.logger.error("createStorage Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createStorage Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Download Details
   * Returns the details of a downloadable format of a version of an item.
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
   * @param downloadId The Job ID of the job used to generate the download.
   *                   (required)
   * @param xUserId    In a two-legged authentication context, an app has access
   *                   to all users specified by the administrator in the SaaS
   *                   integrations UI. By providing this header, the API call
   *                   will be limited to act only on behalf of the specified
   *                   user. (optional)
   * @return Download
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Download> getDownload(String projectId, String downloadId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getDownload ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getDownload");
    }

    // verify the required parameter 'downloadId' is set
    if (downloadId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'downloadId' when calling getDownload");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/downloads/{download_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "download_id" + "\\}", parameterToString(downloadId));

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
      this.logger.info("getDownload Request completed successfully with status " + statusCode);
      Download download = deserialize(entity, new TypeReference<Download>() {
      });
      return new ApiResponse<Download>(statusCode, response.getHeaders(), download);
    } catch (DataManagementApiException e) {
      this.logger.error("getDownload Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getDownload Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Check Download Creation Progress
   * Checks the status of a job that generates a downloadable format of a version
   * of an item.
   * 
   * **Note**: If the job has finished, this operation returns a HTTP status 303,
   * with the &#x60;&#x60;location&#x60;&#x60; return header set to the URI that
   * returns the details of the download.
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
   * @param jobId     The unique identifier of a job. (required)
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Job
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Job> getDownloadJob(String projectId, String jobId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getDownloadJob ");

    Object localVarPostBody = null;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getDownloadJob");
    }

    // verify the required parameter 'jobId' is set
    if (jobId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'jobId' when calling getDownloadJob");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/jobs/{job_id}"
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId))
        .replaceAll("\\{" + "job_id" + "\\}", parameterToString(jobId));

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
      this.logger.info("getDownloadJob Request completed successfully with status " + statusCode);
      Job job = deserialize(entity, new TypeReference<Job>() {
      });
      return new ApiResponse<Job>(statusCode, response.getHeaders(), job);
    } catch (DataManagementApiException e) {
      this.logger.error("getDownloadJob Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getDownloadJob Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Projects
   * Returns a collection of active projects within the specified hub. The
   * returned projects can be Autodesk Construction Cloud (ACC), BIM 360, BIM 360
   * Team, Fusion Team, and A360 Personal projects.
   * 
   * For BIM 360 and ACC projects a hub ID corresponds to an Account ID. To
   * convert an Account ID to a hub ID, prefix the account ID with
   * &#x60;&#x60;b.&#x60;&#x60;. For example, a BIM 360 account ID of
   * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
   * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * Similarly, to convert a BIM 360 and ACC project IDs to Data Management
   * project IDs prefix the BIM 360 or ACC Project ID with
   * &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
   * &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project ID of
   * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param hubId               The unique identifier of a hub. (required)
   * @param xUserId             In a two-legged authentication context, an app has
   *                            access to all users specified by the administrator
   *                            in the SaaS integrations UI. By providing this
   *                            header, the API call will be limited to act only
   *                            on behalf of the specified user. (optional)
   * @param filterId            Filter by the &#x60;&#x60;id&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. (optional)
   * @param filterExtensionType Filter by the extension type. (optional)
   * @param pageNumber          Specifies what page to return. Page numbers are
   *                            0-based (the first page is page 0). (optional)
   * @param pageLimit           Specifies the maximum number of elements to return
   *                            in the page. The default value is 200. The min
   *                            value is 1. The max value is 200. (optional)
   * @return Projects
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Projects> getHubProjects(String hubId, String xUserId, List<String> filterId,
      List<String> filterExtensionType, Integer pageNumber, Integer pageLimit, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getHubProjects ");

    Object localVarPostBody = null;

    // verify the required parameter 'hubId' is set
    if (hubId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'hubId' when calling getHubProjects");
    }

    // create path and map variables
    String localVarPath = "/project/v1/hubs/{hub_id}/projects"
        .replaceAll("\\{" + "hub_id" + "\\}", parameterToString(hubId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (filterId != null) {
      localVarQueryParams.put("filter[id]", parameterToString(filterId));
    }
    if (filterExtensionType != null) {
      localVarQueryParams.put("filter[extension.type]", parameterToString(filterExtensionType));
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
      this.logger.info("getHubProjects Request completed successfully with status " + statusCode);
      Projects projects = deserialize(entity, new TypeReference<Projects>() {
      });
      return new ApiResponse<Projects>(statusCode, response.getHeaders(), projects);
    } catch (DataManagementApiException e) {
      this.logger.error("getHubProjects Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getHubProjects Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get a Project
   * Returns the specified project from within the specified hub.
   * 
   * For BIM 360 Docs, a hub ID corresponds to a BIM 360 account ID. To convert a
   * BIM 360 account ID to a hub ID, prefix the account ID with
   * &#x60;&#x60;b.&#x60;&#x60;. For example, an account ID of
   * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
   * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * Similarly, to convert a BIM 360 project ID to a Data Management project ID
   * prefix the BIM 360 Project ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
   * project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project
   * ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param hubId     The unique identifier of a hub. (required)
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
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Project
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Project> getProject(String hubId, String projectId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getProject ");

    Object localVarPostBody = null;

    // verify the required parameter 'hubId' is set
    if (hubId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'hubId' when calling getProject");
    }

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'projectId' when calling getProject");
    }

    // create path and map variables
    String localVarPath = "/project/v1/hubs/{hub_id}/projects/{project_id}"
        .replaceAll("\\{" + "hub_id" + "\\}", parameterToString(hubId))
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

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
      this.logger.info("getProject Request completed successfully with status " + statusCode);
      Project project = deserialize(entity, new TypeReference<Project>() {
      });
      return new ApiResponse<Project>(statusCode, response.getHeaders(), project);
    } catch (DataManagementApiException e) {
      this.logger.error("getProject Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getProject Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * Get Hub for Project
   * Returns the hub that contains the project specified by the
   * &#x60;&#x60;project_id&#x60;&#x60; parameter.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param hubId     The unique identifier of a hub. (required)
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
   * @param xUserId   In a two-legged authentication context, an app has access to
   *                  all users specified by the administrator in the SaaS
   *                  integrations UI. By providing this header, the API call will
   *                  be limited to act only on behalf of the specified user.
   *                  (optional)
   * @return Hub
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Hub> getProjectHub(String hubId, String projectId, String xUserId, String accessToken)
      throws DataManagementApiException {
    this.logger.info("Entered into getProjectHub ");

    Object localVarPostBody = null;

    // verify the required parameter 'hubId' is set
    if (hubId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'hubId' when calling getProjectHub");
    }

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getProjectHub");
    }

    // create path and map variables
    String localVarPath = "/project/v1/hubs/{hub_id}/projects/{project_id}/hub"
        .replaceAll("\\{" + "hub_id" + "\\}", parameterToString(hubId))
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

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
      this.logger.info("getProjectHub Request completed successfully with status " + statusCode);
      Hub hub = deserialize(entity, new TypeReference<Hub>() {
      });
      return new ApiResponse<Hub>(statusCode, response.getHeaders(), hub);
    } catch (DataManagementApiException e) {
      this.logger.error("getProjectHub Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getProjectHub Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Top-level Project Folders
   * Returns the details of the highest level folders within a project that the
   * user calling this operation has access to. The user must have at least read
   * access to the folders.
   * 
   * If the user is a Project Admin, it returns all top-level folders in the
   * project. Otherwise, it returns all the highest level folders in the folder
   * hierarchy the user has access to.
   * 
   * Users with access permission to a folder has access permission to all its
   * subfolders.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param hubId            The unique identifier of a hub. (required)
   * @param projectId        The unique identifier of a project. For BIM 360 Docs
   *                         and ACC Docs, a hub ID corresponds to an Account ID.
   *                         To convert a BIM 360 or ACC Account ID to a hub ID,
   *                         prefix the Account ID with
   *                         &#x60;&#x60;b.&#x60;&#x60;. For example, an Account
   *                         ID of
   *                         &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
   *                         translates to a hub ID of
   *                         &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly,
   *                         to convert an ACC or BIM 360 project ID to a Data
   *                         Management project ID prefix the ACC or BIM 360
   *                         project ID with &#x60;&#x60;b.&#x60;&#x60;. For
   *                         example, a project ID of
   *                         &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
   *                         project ID of
   *                         &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
   * @param xUserId          In a two-legged authentication context, an app has
   *                         access to all users specified by the administrator in
   *                         the SaaS integrations UI. By providing this header,
   *                         the API call will be limited to act only on behalf of
   *                         the specified user. (optional)
   * @param excludeDeleted   Specifies whether deleted folders are excluded from
   *                         the response for BIM 360 Docs projects, when user
   *                         context is provided. - &#x60;&#x60;true&#x60;&#x60;:
   *                         Response excludes deleted folders for BIM 360 Docs
   *                         projects. - &#x60;&#x60;false&#x60;&#x60;: (Default)
   *                         Response will not exclude deleted folders for BIM 360
   *                         Docs projects. (optional)
   * @param projectFilesOnly Specifies what folders and subfolders to return for
   *                         BIM 360 Docs projects, when user context is provided.
   *                         - &#x60;&#x60;true&#x60;&#x60;: Response will be
   *                         restricted to folder and subfolders containing
   *                         project files for BIM 360 Docs projects. -
   *                         &#x60;&#x60;false&#x60;&#x60;: (Default) Response
   *                         will include all available folders. (optional)
   * @return TopFolders
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<TopFolders> getProjectTopFolders(String hubId, String projectId, String xUserId,
      Boolean excludeDeleted, Boolean projectFilesOnly, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getProjectTopFolders ");

    Object localVarPostBody = null;

    // verify the required parameter 'hubId' is set
    if (hubId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'hubId' when calling getProjectTopFolders");
    }

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling getProjectTopFolders");
    }

    // create path and map variables
    String localVarPath = "/project/v1/hubs/{hub_id}/projects/{project_id}/topFolders"
        .replaceAll("\\{" + "hub_id" + "\\}", parameterToString(hubId))
        .replaceAll("\\{" + "project_id" + "\\}", parameterToString(projectId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (excludeDeleted != null) {
      localVarQueryParams.put("excludeDeleted", parameterToString(excludeDeleted));
    }
    if (projectFilesOnly != null) {
      localVarQueryParams.put("projectFilesOnly", parameterToString(projectFilesOnly));
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
      this.logger.info("getProjectTopFolders Request completed successfully with status " + statusCode);
      TopFolders topFolders = deserialize(entity, new TypeReference<TopFolders>() {
      });
      return new ApiResponse<TopFolders>(statusCode, response.getHeaders(), topFolders);
    } catch (DataManagementApiException e) {
      this.logger.error("getProjectTopFolders Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getProjectTopFolders Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

}
