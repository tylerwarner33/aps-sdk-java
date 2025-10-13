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
import com.autodesk.aps.datamanagement.model.Hub;
import com.autodesk.aps.datamanagement.model.Hubs;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class HubsApi extends BaseApi {

  public HubsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Get a Hub
   * Returns the hub specified by the &#x60;&#x60;hub_id&#x60;&#x60; parameter.
   * 
   * For BIM 360 Docs, a hub ID corresponds to a BIM 360 account ID. To convert a
   * BIM 360 account ID to a hub ID, prefix the account ID with
   * &#x60;&#x60;b.&#x60;&#x60;. For example, an account ID of
   * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
   * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param hubId   The unique identifier of a hub. (required)
   * @param xUserId In a two-legged authentication context, an app has access to
   *                all users specified by the administrator in the SaaS
   *                integrations UI. By providing this header, the API call will
   *                be limited to act only on behalf of the specified user.
   *                (optional)
   * @return Hub
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Hub> getHub(String hubId, String xUserId, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getHub ");

    Object localVarPostBody = null;

    // verify the required parameter 'hubId' is set
    if (hubId == null) {
      throw new DataManagementApiException(400, "Missing the required parameter 'hubId' when calling getHub");
    }

    // create path and map variables
    String localVarPath = "/project/v1/hubs/{hub_id}"
        .replaceAll("\\{" + "hub_id" + "\\}", parameterToString(hubId));

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
      this.logger.info("getHub Request completed successfully with status " + statusCode);
      Hub hub = deserialize(entity, new TypeReference<Hub>() {
      });
      return new ApiResponse<Hub>(statusCode, response.getHeaders(), hub);
    } catch (DataManagementApiException e) {
      this.logger.error("getHub Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getHub Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

  /**
   * List Hubs
   * Returns a collection of hubs that the user of your app can access.
   * 
   * The returned hubs can be BIM 360 Team hubs, Fusion Team hubs (formerly known
   * as A360 Team hubs), A360 Personal hubs, ACC Docs (Autodesk Docs) accounts, or
   * BIM 360 Docs accounts. Only active hubs are returned.
   * 
   * For BIM 360 Docs and ACC Docs, a hub ID corresponds to an Account ID. To
   * convert a BIM 360 or ACC Account ID to a hub ID, prefix the Account ID with
   * &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID of
   * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
   * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
   * For more information, see the [ACC Platform API
   * documentation](https://en.docs.acc.v1/overview/introduction/).
   * 
   * @param xUserId             In a two-legged authentication context, an app has
   *                            access to all users specified by the administrator
   *                            in the SaaS integrations UI. By providing this
   *                            header, the API call will be limited to act only
   *                            on behalf of the specified user. (optional)
   * @param filterId            Filter by the &#x60;&#x60;id&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. (optional)
   * @param filterName          Filter by the &#x60;&#x60;name&#x60;&#x60; of the
   *                            &#x60;&#x60;ref&#x60;&#x60; target. (optional)
   * @param filterExtensionType Filter by the extension type. (optional)
   * @return Hubs
   * @throws DataManagementApiException if fails to make API call
   */
  public ApiResponse<Hubs> getHubs(String xUserId, List<String> filterId, List<String> filterName,
      List<String> filterExtensionType, String accessToken) throws DataManagementApiException {
    this.logger.info("Entered into getHubs ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/project/v1/hubs";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (filterId != null) {
      localVarQueryParams.put("filter[id]", parameterToString(filterId));
    }
    if (filterName != null) {
      localVarQueryParams.put("filter[name]", parameterToString(filterName));
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
      this.logger.info("getHubs Request completed successfully with status " + statusCode);
      Hubs hubs = deserialize(entity, new TypeReference<Hubs>() {
      });
      return new ApiResponse<Hubs>(statusCode, response.getHeaders(), hubs);
    } catch (DataManagementApiException e) {
      this.logger.error("getHubs Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getHubs Request failed with exception: " + e.getMessage());
      throw new DataManagementApiException(e);
    }
  }

}
