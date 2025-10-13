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
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.datamanagement.BaseApi;
import com.autodesk.aps.datamanagement.DataManagementApiException;
import com.autodesk.aps.datamanagement.model.Command;
import com.autodesk.aps.datamanagement.model.CommandPayload;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class CommandsApi extends BaseApi {

  public CommandsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Execute a Command
   * Executes the command that you specify in the request body. Commands enable
   * you to perform general operations on multiple resources.
   * 
   * For example, you can check whether a user has permission to delete a
   * collection of versions, items, and folders.
   * 
   * The command as well as the input data for the command are specified using the
   * &#x60;&#x60;data&#x60;&#x60; object of the request body.
   * 
   * For more information about commands see the
   * [Commands](/en/docs/data/v2/overview/commands/) section in the
   * Developer&#39;s Guide.
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
   * @param commandPayload The request body&#39;s &#x60;&#x60;data&#x60;&#x60;
   *                       object defines the command to execute and contains any
   *                       required input data. (required)
   * @param xUserId        In a two-legged authentication context, an app has
   *                       access to all users specified by the administrator in
   *                       the SaaS integrations UI. By providing this header, the
   *                       API call will be limited to act only on behalf of the
   *                       specified user. (optional)
   * @return Command
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Command> executeCommand(String projectId, CommandPayload commandPayload, String xUserId,
      String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into executeCommand ");

    Object localVarPostBody = commandPayload;

    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'projectId' when calling executeCommand");
    }

    // verify the required parameter 'commandPayload' is set
    if (commandPayload == null) {
      throw new DataManagementApiException(400,
          "Missing the required parameter 'commandPayload' when calling executeCommand");
    }

    // create path and map variables
    String localVarPath = "/data/v1/projects/{project_id}/commands"
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
      this.logger.info("executeCommand Request completed successfully with status " + statusCode);
      Command command = deserialize(entity, new TypeReference<Command>() {
      });
      return new ApiResponse<Command>(statusCode, response.getHeaders(), command);
    } catch (DataManagementApiException e) {
      this.logger.error("executeCommand Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("executeCommand Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

}
