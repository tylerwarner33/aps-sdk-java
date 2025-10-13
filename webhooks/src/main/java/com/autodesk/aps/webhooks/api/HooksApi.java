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
package com.autodesk.aps.webhooks.api;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.webhooks.BaseApi;
import com.autodesk.aps.webhooks.WebhooksApiException;
import com.autodesk.aps.webhooks.model.Hook;
import com.autodesk.aps.webhooks.model.HookDetails;
import com.autodesk.aps.webhooks.model.HookPayload;
import com.autodesk.aps.webhooks.model.Hooks;
import com.autodesk.aps.webhooks.model.ModifyHookPayload;
import com.autodesk.aps.webhooks.model.Region;
import com.autodesk.aps.webhooks.model.Sort;
import com.autodesk.aps.webhooks.model.StatusFilter;
import com.autodesk.aps.webhooks.model.XAdsRegion;
import com.fasterxml.jackson.core.type.TypeReference;

public class HooksApi extends BaseApi {

  public HooksApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create a Webhook for an Event
   * Adds a new webhook to receive notifications of the occurrence of a specified
   * event for the specified system.
   * 
   * @param system      The ID of the system the webhook applies to. For example
   *                    data for Data Management. See [Supported
   *                    Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                    list of supported systems and their IDs. (required)
   * @param event       The ID of the event the webhook monitors. See [Supported
   *                    Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                    list of events. (required)
   * @param hookPayload (required)
   * @param region      Specifies the geographical location (region) of the server
   *                    the request must be executed on. This also corresponds to
   *                    the region where the Webhook data is stored. It is also
   *                    the location of the server that will make request to your
   *                    callback URL. Possible values: -
   *                    &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                    dedicated to serve the United States region. -
   *                    &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                    serve the European Union, Middle East, and Africa regions.
   *                    - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center
   *                    dedicated to serve the Australia region. -
   *                    &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                    serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                    Data center dedicated to serve the Germany region. -
   *                    &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                    serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                    Data center dedicated to serve the Japan region. -
   *                    &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                    serve the United Kingdom region. **Note:** 1. Beta
   *                    features are subject to change. Please avoid using them in
   *                    production environments. 2. You can also use the
   *                    &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                    region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                    query string parameter as well as the
   *                    &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                    &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                    precedence. (optional)
   * @param xAdsRegion  Specifies the geographical location (region) of the server
   *                    the request must be executed on. This also corresponds to
   *                    the region where the Webhook data is stored. It is also
   *                    the location of the server that will make requests to your
   *                    callback URL. Possible values: -
   *                    &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                    dedicated to serve the United States region. -
   *                    &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                    serve the European Union, Middle East, and Africa regions.
   *                    - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center
   *                    dedicated to serve the Australia region. -
   *                    &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                    serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                    Data center dedicated to serve the Germany region. -
   *                    &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                    serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                    Data center dedicated to serve the Japan region. -
   *                    &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                    serve the United Kingdom region. **Note:** 1. Beta
   *                    features are subject to change. Please avoid using them in
   *                    production environments. 2. You can also use the
   *                    &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                    specify the region. If you specify the
   *                    &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                    well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                    the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                    precedence. (optional)
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse <ClassicHttpResponse> createSystemEventHook(String system, String event, HookPayload hookPayload, Region region,
      XAdsRegion xAdsRegion, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into createSystemEventHook ");

    Object localVarPostBody = hookPayload;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling createSystemEventHook");
    }

    // verify the required parameter 'event' is set
    if (event == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'event' when calling createSystemEventHook");
    }

    // verify the required parameter 'hookPayload' is set
    if (hookPayload == null) {
      throw new WebhooksApiException(400,
          "Missing the required parameter 'hookPayload' when calling createSystemEventHook");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/events/{event}/hooks"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system))
        .replaceAll("\\{" + "event" + "\\}", parameterToString(event));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
    }

    localVarHeaderParams.put("Content-Type", "application/json");
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("createSystemEventHook Request completed successfully with status " + statusCode);
      return new ApiResponse<ClassicHttpResponse>(statusCode, response.getHeaders());
    } catch (WebhooksApiException e) {
      this.logger.error("createSystemEventHook Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createSystemEventHook Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * Create Webhooks for All Events
   * Adds a new webhook to receive notifications of all events for the specified
   * system.
   * 
   * @param system      The ID of the system the webhook applies to. For example
   *                    data for Data Management. See [Supported
   *                    Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                    list of supported systems and their IDs. (required)
   * @param hookPayload (required)
   * @param xAdsRegion  Specifies the geographical location (region) of the server
   *                    the request must be executed on. This also corresponds to
   *                    the region where the Webhook data is stored. It is also
   *                    the location of the server that will make requests to your
   *                    callback URL. Possible values: -
   *                    &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                    dedicated to serve the United States region. -
   *                    &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                    serve the European Union, Middle East, and Africa regions.
   *                    - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center
   *                    dedicated to serve the Australia region. -
   *                    &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                    serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                    Data center dedicated to serve the Germany region. -
   *                    &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                    serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                    Data center dedicated to serve the Japan region. -
   *                    &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                    serve the United Kingdom region. **Note:** 1. Beta
   *                    features are subject to change. Please avoid using them in
   *                    production environments. 2. You can also use the
   *                    &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                    specify the region. If you specify the
   *                    &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                    well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                    the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                    precedence. (optional)
   * @param region      Specifies the geographical location (region) of the server
   *                    the request must be executed on. This also corresponds to
   *                    the region where the Webhook data is stored. It is also
   *                    the location of the server that will make request to your
   *                    callback URL. Possible values: -
   *                    &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                    dedicated to serve the United States region. -
   *                    &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                    serve the European Union, Middle East, and Africa regions.
   *                    - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center
   *                    dedicated to serve the Australia region. -
   *                    &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                    serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                    Data center dedicated to serve the Germany region. -
   *                    &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                    serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                    Data center dedicated to serve the Japan region. -
   *                    &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                    serve the United Kingdom region. **Note:** 1. Beta
   *                    features are subject to change. Please avoid using them in
   *                    production environments. 2. You can also use the
   *                    &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                    region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                    query string parameter as well as the
   *                    &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                    &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                    precedence. (optional)
   * @return Hook
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Hook> createSystemHook(String system, HookPayload hookPayload, XAdsRegion xAdsRegion,
      Region region, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into createSystemHook ");

    Object localVarPostBody = hookPayload;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling createSystemHook");
    }

    // verify the required parameter 'hookPayload' is set
    if (hookPayload == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'hookPayload' when calling createSystemHook");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/hooks"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
    }

    localVarHeaderParams.put("Content-Type", "application/json");
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("createSystemHook Request completed successfully with status " + statusCode);
      Hook hook = deserialize(entity, new TypeReference<Hook>() {
      });
      return new ApiResponse<Hook>(statusCode, response.getHeaders(), hook);
    } catch (WebhooksApiException e) {
      this.logger.error("createSystemHook Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createSystemHook Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * Delete a Webhook
   * Deletes the webhook specified by its ID.
   * 
   * @param system     The ID of the system the webhook applies to. For example
   *                   data for Data Management. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of supported systems and their IDs. (required)
   * @param event      The ID of the event the webhook monitors. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of events. (required)
   * @param hookId     The ID of the webhook to delete. (required)
   * @param xAdsRegion Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make requests to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                   specify the region. If you specify the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                   well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                   the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param region     Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make request to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                   region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                   query string parameter as well as the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSystemEventHook(String system, String event, String hookId, XAdsRegion xAdsRegion,
      Region region, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into deleteSystemEventHook ");

    Object localVarPostBody = null;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling deleteSystemEventHook");
    }

    // verify the required parameter 'event' is set
    if (event == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'event' when calling deleteSystemEventHook");
    }

    // verify the required parameter 'hookId' is set
    if (hookId == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'hookId' when calling deleteSystemEventHook");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/events/{event}/hooks/{hook_id}"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system))
        .replaceAll("\\{" + "event" + "\\}", parameterToString(event))
        .replaceAll("\\{" + "hook_id" + "\\}", parameterToString(hookId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Delete",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("deleteSystemEventHook Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (WebhooksApiException e) {
      this.logger.error("deleteSystemEventHook Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteSystemEventHook Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * List All Webhooks for an App
   * Retrieves a paginated list of webhooks created by the calling application.
   * Each page includes up to 200 webhooks.
   * 
   * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
   * provided, the first page of results is returned. Use the
   * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
   * subsequent pages.
   * 
   * **Note:** This operation requires an access token through a Client
   * Credentials flow (two-legged OAuth).
   * 
   * @param xAdsRegion Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make requests to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                   specify the region. If you specify the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                   well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                   the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param pageState  Base64 encoded string to fetch the next page of the list of
   *                   webhooks. If you do not provide this parameter, the first
   *                   page of results is returned. Use the
   *                   &#x60;&#x60;next&#x60;&#x60; value from the previous
   *                   response to fetch subsequent pages. (optional)
   * @param status     Filters retrieved webhooks by their current state. Possible
   *                   values are - &#x60;&#x60;active&#x60;&#x60; - Successfully
   *                   delivered most recent event notifications. -
   *                   &#x60;&#x60;inactive&#x60;&#x60; - Failed to deliver most
   *                   recent event notification and has been deactivated. -
   *                   &#x60;&#x60;reactivated&#x60;&#x60; - Previously inactive
   *                   but was reactivated. No events have occurred since
   *                   reactivation. If this parameter is not specified, the
   *                   filter is not applied. See [Event Delivery
   *                   Guarantees](/en/docs/webhooks/v1/developers_guide/event-delivery-guarantees/)
   *                   for more information on how the state of a webhook changes.
   *                   (optional)
   * @param sort       Specifies the sorting order of the list of webhooks by
   *                   their &#x60;&#x60;lastUpdatedDate&#x60;&#x60; attribute. -
   *                   &#x60;&#x60;asc&#x60;&#x60; - Ascending order. -
   *                   &#x60;&#x60;desc&#x60;&#x60; - (Default) Descending order.
   *                   (optional)
   * @param region     Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make request to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                   region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                   query string parameter as well as the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @return Hooks
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Hooks> getAppHooks(XAdsRegion xAdsRegion, String pageState, StatusFilter status, Sort sort,
      Region region, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into getAppHooks ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/webhooks/v1/app/hooks";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (pageState != null) {
      localVarQueryParams.put("pageState", parameterToString(pageState));
    }
    if (status != null) {
      localVarQueryParams.put("status", parameterToString(status));
    }
    if (sort != null) {
      localVarQueryParams.put("sort", parameterToString(sort));
    }
    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getAppHooks Request completed successfully with status " + statusCode);
      Hooks hooks = deserialize(entity, new TypeReference<Hooks>() {
      });
      return new ApiResponse<Hooks>(statusCode, response.getHeaders(), hooks);
    } catch (WebhooksApiException e) {
      this.logger.error("getAppHooks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getAppHooks Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * Get Webhook Details
   * Retrieves the details of the webhook for the specified event within the
   * specified system.
   * 
   * @param system     The ID of the system the webhook applies to. For example
   *                   data for Data Management. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of supported systems and their IDs. (required)
   * @param event      The ID of the event the webhook monitors. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of events. (required)
   * @param hookId     The ID of the webhook to delete. (required)
   * @param xAdsRegion Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make requests to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                   specify the region. If you specify the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                   well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                   the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param region     Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make request to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                   region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                   query string parameter as well as the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @return HookDetails
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<HookDetails> getHookDetails(String system, String event, String hookId, XAdsRegion xAdsRegion,
      Region region, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into getHookDetails ");

    Object localVarPostBody = null;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling getHookDetails");
    }

    // verify the required parameter 'event' is set
    if (event == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'event' when calling getHookDetails");
    }

    // verify the required parameter 'hookId' is set
    if (hookId == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'hookId' when calling getHookDetails");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/events/{event}/hooks/{hook_id}"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system))
        .replaceAll("\\{" + "event" + "\\}", parameterToString(event))
        .replaceAll("\\{" + "hook_id" + "\\}", parameterToString(hookId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getHookDetails Request completed successfully with status " + statusCode);
      HookDetails hookDetails = deserialize(entity, new TypeReference<HookDetails>() {
      });
      return new ApiResponse<HookDetails>(statusCode, response.getHeaders(), hookDetails);
    } catch (WebhooksApiException e) {
      this.logger.error("getHookDetails Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getHookDetails Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * List All Webhooks
   * Retrieves a paginated list of webhooks available to the provided access token
   * within the specified region. Each page includes up to 200 webhooks.
   * 
   * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
   * provided, the first page of results is returned. Use the
   * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
   * subsequent pages.
   * 
   * @param pageState  Base64 encoded string to fetch the next page of the list of
   *                   webhooks. If you do not provide this parameter, the first
   *                   page of results is returned. Use the
   *                   &#x60;&#x60;next&#x60;&#x60; value from the previous
   *                   response to fetch subsequent pages. (optional)
   * @param status     Filters retrieved webhooks by their current state. Possible
   *                   values are - &#x60;&#x60;active&#x60;&#x60; - Successfully
   *                   delivered most recent event notifications. -
   *                   &#x60;&#x60;inactive&#x60;&#x60; - Failed to deliver most
   *                   recent event notification and has been deactivated. -
   *                   &#x60;&#x60;reactivated&#x60;&#x60; - Previously inactive
   *                   but was reactivated. No events have occurred since
   *                   reactivation. If this parameter is not specified, the
   *                   filter is not applied. See [Event Delivery
   *                   Guarantees](/en/docs/webhooks/v1/developers_guide/event-delivery-guarantees/)
   *                   for more information on how the state of a webhook changes.
   *                   (optional)
   * @param region     Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make request to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                   region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                   query string parameter as well as the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param xAdsRegion Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make requests to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                   specify the region. If you specify the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                   well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                   the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @return Hooks
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Hooks> getHooks(String pageState, StatusFilter status, Region region, XAdsRegion xAdsRegion,
      String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into getHooks ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/webhooks/v1/hooks";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (pageState != null) {
      localVarQueryParams.put("pageState", parameterToString(pageState));
    }
    if (status != null) {
      localVarQueryParams.put("status", parameterToString(status));
    }
    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getHooks Request completed successfully with status " + statusCode);
      Hooks hooks = deserialize(entity, new TypeReference<Hooks>() {
      });
      return new ApiResponse<Hooks>(statusCode, response.getHeaders(), hooks);
    } catch (WebhooksApiException e) {
      this.logger.error("getHooks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getHooks Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * List All Webhooks for an Event
   * Retrieves a paginated list of webhooks for the specified event. The returned
   * list contains a subset of webhooks accessible to the provided access token
   * within the specified region. Each page includes up to 200 webhooks.
   * 
   * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
   * provided, the first page of results is returned. Use the
   * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
   * subsequent pages.
   * 
   * @param system     The ID of the system the webhook applies to. For example
   *                   data for Data Management. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of supported systems and their IDs. (required)
   * @param event      The ID of the event the webhook monitors. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of events. (required)
   * @param xAdsRegion Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make requests to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                   specify the region. If you specify the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                   well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                   the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param region     Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make request to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                   region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                   query string parameter as well as the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param scopeName  Filters retrieved webhooks by the scope name used to create
   *                   hook. For example : &#x60;&#x60;folder&#x60;&#x60;. If this
   *                   parameter is not specified, the filter is not applied.
   *                   (optional)
   * @param pageState  Base64 encoded string to fetch the next page of the list of
   *                   webhooks. If you do not provide this parameter, the first
   *                   page of results is returned. Use the
   *                   &#x60;&#x60;next&#x60;&#x60; value from the previous
   *                   response to fetch subsequent pages. (optional)
   * @param status     Filters retrieved webhooks by their current state. Possible
   *                   values are - &#x60;&#x60;active&#x60;&#x60; - Successfully
   *                   delivered most recent event notifications. -
   *                   &#x60;&#x60;inactive&#x60;&#x60; - Failed to deliver most
   *                   recent event notification and has been deactivated. -
   *                   &#x60;&#x60;reactivated&#x60;&#x60; - Previously inactive
   *                   but was reactivated. No events have occurred since
   *                   reactivation. If this parameter is not specified, the
   *                   filter is not applied. See [Event Delivery
   *                   Guarantees](/en/docs/webhooks/v1/developers_guide/event-delivery-guarantees/)
   *                   for more information on how the state of a webhook changes.
   *                   (optional)
   * @return Hooks
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Hooks> getSystemEventHooks(String system, String event, XAdsRegion xAdsRegion, Region region,
      String scopeName, String pageState, StatusFilter status, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into getSystemEventHooks ");

    Object localVarPostBody = null;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling getSystemEventHooks");
    }

    // verify the required parameter 'event' is set
    if (event == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'event' when calling getSystemEventHooks");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/events/{event}/hooks"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system))
        .replaceAll("\\{" + "event" + "\\}", parameterToString(event));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }
    if (scopeName != null) {
      localVarQueryParams.put("scopeName", parameterToString(scopeName));
    }
    if (pageState != null) {
      localVarQueryParams.put("pageState", parameterToString(pageState));
    }
    if (status != null) {
      localVarQueryParams.put("status", parameterToString(status));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getSystemEventHooks Request completed successfully with status " + statusCode);
      Hooks hooks = deserialize(entity, new TypeReference<Hooks>() {
      });
      return new ApiResponse<Hooks>(statusCode, response.getHeaders(), hooks);
    } catch (WebhooksApiException e) {
      this.logger.error("getSystemEventHooks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getSystemEventHooks Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * List All Webhooks for a System
   * Retrieves a paginated list of webhooks for the specified system. The returned
   * list contains a subset of webhooks accessible to the provided access token
   * within the specified region. Each page includes up to 200 webhooks.
   * 
   * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
   * provided, the first page of results is returned. Use the
   * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
   * subsequent pages.
   * 
   * @param system     The ID of the system the webhook applies to. For example
   *                   data for Data Management. See [Supported
   *                   Events](/en/docs/webhooks/v1/reference/events/) for a full
   *                   list of supported systems and their IDs. (required)
   * @param xAdsRegion Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make requests to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                   specify the region. If you specify the
   *                   &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                   well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                   the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @param status     Filters retrieved webhooks by their current state. Possible
   *                   values are - &#x60;&#x60;active&#x60;&#x60; - Successfully
   *                   delivered most recent event notifications. -
   *                   &#x60;&#x60;inactive&#x60;&#x60; - Failed to deliver most
   *                   recent event notification and has been deactivated. -
   *                   &#x60;&#x60;reactivated&#x60;&#x60; - Previously inactive
   *                   but was reactivated. No events have occurred since
   *                   reactivation. If this parameter is not specified, the
   *                   filter is not applied. See [Event Delivery
   *                   Guarantees](/en/docs/webhooks/v1/developers_guide/event-delivery-guarantees/)
   *                   for more information on how the state of a webhook changes.
   *                   (optional)
   * @param pageState  Base64 encoded string to fetch the next page of the list of
   *                   webhooks. If you do not provide this parameter, the first
   *                   page of results is returned. Use the
   *                   &#x60;&#x60;next&#x60;&#x60; value from the previous
   *                   response to fetch subsequent pages. (optional)
   * @param region     Specifies the geographical location (region) of the server
   *                   the request must be executed on. This also corresponds to
   *                   the region where the Webhook data is stored. It is also the
   *                   location of the server that will make request to your
   *                   callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60;
   *                   - (Default) Data center dedicated to serve the United
   *                   States region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                   dedicated to serve the European Union, Middle East, and
   *                   Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                   center dedicated to serve the Australia region. -
   *                   &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                   serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                   Data center dedicated to serve the Germany region. -
   *                   &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                   serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                   Data center dedicated to serve the Japan region. -
   *                   &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                   serve the United Kingdom region. **Note:** 1. Beta features
   *                   are subject to change. Please avoid using them in
   *                   production environments. 2. You can also use the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify the
   *                   region. If you specify the &#x60;&#x60;region&#x60;&#x60;
   *                   query string parameter as well as the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                   &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                   precedence. (optional)
   * @return Hooks
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Hooks> getSystemHooks(String system, XAdsRegion xAdsRegion, StatusFilter status, String pageState,
      Region region, String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into getSystemHooks ");

    Object localVarPostBody = null;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling getSystemHooks");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/hooks"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (status != null) {
      localVarQueryParams.put("status", parameterToString(status));
    }
    if (pageState != null) {
      localVarQueryParams.put("pageState", parameterToString(pageState));
    }
    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getSystemHooks Request completed successfully with status " + statusCode);
      Hooks hooks = deserialize(entity, new TypeReference<Hooks>() {
      });
      return new ApiResponse<Hooks>(statusCode, response.getHeaders(), hooks);
    } catch (WebhooksApiException e) {
      this.logger.error("getSystemHooks Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getSystemHooks Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * Update a Webhook
   * Updates the webhook specified by the &#x60;&#x60;hook_id&#x60;&#x60;
   * parameter. Currently the only attributes you can update are:
   * 
   * - filter
   * - status
   * - hook attribute
   * - token
   * - auto-reactivate hook flag
   * - hook expiry
   * - callbackWithEventPaylaod flag
   * 
   * See the request body documentation for more information.
   * 
   * @param system            The ID of the system the webhook applies to. For
   *                          example data for Data Management. See [Supported
   *                          Events](/en/docs/webhooks/v1/reference/events/) for
   *                          a full list of supported systems and their IDs.
   *                          (required)
   * @param event             The ID of the event the webhook monitors. See
   *                          [Supported
   *                          Events](/en/docs/webhooks/v1/reference/events/) for
   *                          a full list of events. (required)
   * @param hookId            The ID of the webhook to delete. (required)
   * @param modifyHookPayload (required)
   * @param xAdsRegion        Specifies the geographical location (region) of the
   *                          server the request must be executed on. This also
   *                          corresponds to the region where the Webhook data is
   *                          stored. It is also the location of the server that
   *                          will make requests to your callback URL. Possible
   *                          values: - &#x60;&#x60;US&#x60;&#x60; - (Default)
   *                          Data center dedicated to serve the United States
   *                          region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                          dedicated to serve the European Union, Middle East,
   *                          and Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; -
   *                          (Beta) Data center dedicated to serve the Australia
   *                          region. - &#x60;&#x60;CAN&#x60;&#x60; - Data center
   *                          dedicated to serve the Canada region. -
   *                          &#x60;&#x60;DEU&#x60;&#x60; - Data center dedicated
   *                          to serve the Germany region. -
   *                          &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated
   *                          to serve the India region. -
   *                          &#x60;&#x60;JPN&#x60;&#x60; - Data center dedicated
   *                          to serve the Japan region. -
   *                          &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated
   *                          to serve the United Kingdom region. **Note:** 1.
   *                          Beta features are subject to change. Please avoid
   *                          using them in production environments. 2. You can
   *                          also use the &#x60;&#x60;region&#x60;&#x60; query
   *                          string parameter to specify the region. If you
   *                          specify the &#x60;&#x60;region&#x60;&#x60; query
   *                          string parameter as well as the
   *                          &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                          &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                          precedence. (optional)
   * @param region            Specifies the geographical location (region) of the
   *                          server the request must be executed on. This also
   *                          corresponds to the region where the Webhook data is
   *                          stored. It is also the location of the server that
   *                          will make request to your callback URL. Possible
   *                          values: - &#x60;&#x60;US&#x60;&#x60; - (Default)
   *                          Data center dedicated to serve the United States
   *                          region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                          dedicated to serve the European Union, Middle East,
   *                          and Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; -
   *                          (Beta) Data center dedicated to serve the Australia
   *                          region. - &#x60;&#x60;CAN&#x60;&#x60; - Data center
   *                          dedicated to serve the Canada region. -
   *                          &#x60;&#x60;DEU&#x60;&#x60; - Data center dedicated
   *                          to serve the Germany region. -
   *                          &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated
   *                          to serve the India region. -
   *                          &#x60;&#x60;JPN&#x60;&#x60; - Data center dedicated
   *                          to serve the Japan region. -
   *                          &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated
   *                          to serve the United Kingdom region. **Note:** 1.
   *                          Beta features are subject to change. Please avoid
   *                          using them in production environments. 2. You can
   *                          also use the &#x60;&#x60;x-ads-region&#x60;&#x60;
   *                          header to specify the region. If you specify the
   *                          &#x60;&#x60;region&#x60;&#x60; query string
   *                          parameter as well as the
   *                          &#x60;&#x60;x-ads-region&#x60;&#x60; header, the
   *                          &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                          precedence. (optional)
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Void> patchSystemEventHook(String system, String event, String hookId,
      ModifyHookPayload modifyHookPayload, XAdsRegion xAdsRegion, Region region, String accessToken)
      throws WebhooksApiException {
    this.logger.info("Entered into patchSystemEventHook ");

    Object localVarPostBody = modifyHookPayload;

    // verify the required parameter 'system' is set
    if (system == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'system' when calling patchSystemEventHook");
    }

    // verify the required parameter 'event' is set
    if (event == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'event' when calling patchSystemEventHook");
    }

    // verify the required parameter 'hookId' is set
    if (hookId == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'hookId' when calling patchSystemEventHook");
    }

    // verify the required parameter 'modifyHookPayload' is set
    if (modifyHookPayload == null) {
      throw new WebhooksApiException(400,
          "Missing the required parameter 'modifyHookPayload' when calling patchSystemEventHook");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/systems/{system}/events/{event}/hooks/{hook_id}"
        .replaceAll("\\{" + "system" + "\\}", parameterToString(system))
        .replaceAll("\\{" + "event" + "\\}", parameterToString(event))
        .replaceAll("\\{" + "hook_id" + "\\}", parameterToString(hookId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }

    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
    }

    localVarHeaderParams.put("Content-Type", "application/json");
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
        throw new WebhooksApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("patchSystemEventHook Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (WebhooksApiException e) {
      this.logger.error("patchSystemEventHook Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("patchSystemEventHook Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

}
