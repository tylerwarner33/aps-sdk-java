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
import com.autodesk.aps.webhooks.model.Region;
import com.autodesk.aps.webhooks.model.Token;
import com.autodesk.aps.webhooks.model.TokenPayload;
import com.autodesk.aps.webhooks.model.XAdsRegion;
import com.fasterxml.jackson.core.type.TypeReference;

public class TokensApi extends BaseApi {

  public TokensApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create Secret Token
   * Sets a secret token to verify the authenticity of webhook payloads.
   * 
   * When a webhook event occurs, the service calculates a hash signature using
   * the token and includes it in the event notification. The receiving
   * application listening at the callback URL can verify the payload&#39;s
   * integrity by comparing the calculated signature to the one received.
   * 
   * The webhooks affected by this operation are determined by the type of access
   * token you use.
   * 
   * - Two-legged Access Token: Sets the secret token for all webhooks owned by
   * calling the app.
   * - Three-legged Access Token: Sets the secret token for all webhooks owned by
   * the calling user
   * 
   * **Note:** Use the [Update Webhook
   * operation](/en/docs/webhooks/v1/reference/http/webhooks/systems-system-events-event-hooks-hook_id-PATCH/)
   * to set a token for a specific webhook.
   * 
   * 
   * See the [Secret
   * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
   * API Basics for more information.
   * 
   * @param tokenPayload The request payload for a Create Secret request
   *                     (required)
   * @param xAdsRegion   Specifies the geographical location (region) of the
   *                     server the request must be executed on. This also
   *                     corresponds to the region where the Webhook data is
   *                     stored. It is also the location of the server that will
   *                     make requests to your callback URL. Possible values: -
   *                     &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                     dedicated to serve the United States region. -
   *                     &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                     serve the European Union, Middle East, and Africa
   *                     regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                     center dedicated to serve the Australia region. -
   *                     &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                     serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                     Data center dedicated to serve the Germany region. -
   *                     &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                     serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                     Data center dedicated to serve the Japan region. -
   *                     &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                     serve the United Kingdom region. **Note:** 1. Beta
   *                     features are subject to change. Please avoid using them
   *                     in production environments. 2. You can also use the
   *                     &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                     specify the region. If you specify the
   *                     &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                     well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                     the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                     precedence. (optional)
   * @param region       Specifies the geographical location (region) of the
   *                     server the request must be executed on. This also
   *                     corresponds to the region where the Webhook data is
   *                     stored. It is also the location of the server that will
   *                     make request to your callback URL. Possible values: -
   *                     &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                     dedicated to serve the United States region. -
   *                     &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                     serve the European Union, Middle East, and Africa
   *                     regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                     center dedicated to serve the Australia region. -
   *                     &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                     serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                     Data center dedicated to serve the Germany region. -
   *                     &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                     serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                     Data center dedicated to serve the Japan region. -
   *                     &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                     serve the United Kingdom region. **Note:** 1. Beta
   *                     features are subject to change. Please avoid using them
   *                     in production environments. 2. You can also use the
   *                     &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify
   *                     the region. If you specify the
   *                     &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                     well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                     the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                     precedence. (optional)
   * @return Token
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Token> createToken(TokenPayload tokenPayload, XAdsRegion xAdsRegion, Region region,
      String accessToken) throws WebhooksApiException {
    this.logger.info("Entered into createToken ");

    Object localVarPostBody = tokenPayload;

    // verify the required parameter 'tokenPayload' is set
    if (tokenPayload == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'tokenPayload' when calling createToken");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/tokens";

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
      this.logger.info("createToken Request completed successfully with status " + statusCode);
      Token token = deserialize(entity, new TypeReference<Token>() {
      });
      return new ApiResponse<Token>(statusCode, response.getHeaders(), token);
    } catch (WebhooksApiException e) {
      this.logger.error("createToken Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createToken Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * Delete Secret Token
   * Removes an existing secret token from the webhooks impacted by this
   * operation.
   * 
   * The webhooks affected by this operation are determined by the type of access
   * token you use.
   * 
   * - Two-legged Access Token: Sets the secret token for all webhooks owned by
   * calling the app.
   * - Three-legged Access Token: Sets the secrety token for all webhooks owned by
   * the calling user
   * 
   * Note that there can be a delay of up to 10 minutes while the change takes
   * effect. We recommend that your callback accept both secret token values for a
   * period of time to allow all requests to go through.
   * 
   * See the [Secret
   * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
   * API Basics for more information.
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
  public ApiResponse<Void> deleteToken(XAdsRegion xAdsRegion, Region region, String accessToken)
      throws WebhooksApiException {
    this.logger.info("Entered into deleteToken ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/webhooks/v1/tokens/@me";

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
      this.logger.info("deleteToken Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (WebhooksApiException e) {
      this.logger.error("deleteToken Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteToken Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

  /**
   * Update Secret Token
   * Replaces an existing secret token with a new one.
   * 
   * Note that there can be a delay of up to 10 minutes while the change takes
   * effect. We recommend that your callback accept both secret token values for a
   * period of time to allow all requests to go through.
   * 
   * The webhooks affected by this operation are determined by the type of access
   * token you use.
   * 
   * - Two-legged Access Token: Sets the secret token for all webhooks owned by
   * calling the app.
   * - Three-legged Access Token: Sets the secrety token for all webhooks owned by
   * the calling user
   * 
   * **Note:** Use the [Update Webhook
   * operation](/en/docs/webhooks/v1/reference/http/webhooks/systems-system-events-event-hooks-hook_id-PATCH/)
   * to set a token for a specific webhook.
   * 
   * 
   * See the [Secret
   * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
   * API Basics for more information.
   * 
   * @param tokenPayload (required)
   * @param xAdsRegion   Specifies the geographical location (region) of the
   *                     server the request must be executed on. This also
   *                     corresponds to the region where the Webhook data is
   *                     stored. It is also the location of the server that will
   *                     make requests to your callback URL. Possible values: -
   *                     &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                     dedicated to serve the United States region. -
   *                     &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                     serve the European Union, Middle East, and Africa
   *                     regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                     center dedicated to serve the Australia region. -
   *                     &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                     serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                     Data center dedicated to serve the Germany region. -
   *                     &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                     serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                     Data center dedicated to serve the Japan region. -
   *                     &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                     serve the United Kingdom region. **Note:** 1. Beta
   *                     features are subject to change. Please avoid using them
   *                     in production environments. 2. You can also use the
   *                     &#x60;&#x60;region&#x60;&#x60; query string parameter to
   *                     specify the region. If you specify the
   *                     &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                     well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                     the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                     precedence. (optional)
   * @param region       Specifies the geographical location (region) of the
   *                     server the request must be executed on. This also
   *                     corresponds to the region where the Webhook data is
   *                     stored. It is also the location of the server that will
   *                     make request to your callback URL. Possible values: -
   *                     &#x60;&#x60;US&#x60;&#x60; - (Default) Data center
   *                     dedicated to serve the United States region. -
   *                     &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to
   *                     serve the European Union, Middle East, and Africa
   *                     regions. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data
   *                     center dedicated to serve the Australia region. -
   *                     &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to
   *                     serve the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; -
   *                     Data center dedicated to serve the Germany region. -
   *                     &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
   *                     serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; -
   *                     Data center dedicated to serve the Japan region. -
   *                     &#x60;&#x60;GBR&#x60;&#x60; - Data center dedicated to
   *                     serve the United Kingdom region. **Note:** 1. Beta
   *                     features are subject to change. Please avoid using them
   *                     in production environments. 2. You can also use the
   *                     &#x60;&#x60;x-ads-region&#x60;&#x60; header to specify
   *                     the region. If you specify the
   *                     &#x60;&#x60;region&#x60;&#x60; query string parameter as
   *                     well as the &#x60;&#x60;x-ads-region&#x60;&#x60; header,
   *                     the &#x60;&#x60;x-ads-region&#x60;&#x60; header takes
   *                     precedence. (optional)
   * @throws WebhooksApiException if fails to make API call
   */
  public ApiResponse<Void> putToken(TokenPayload tokenPayload, XAdsRegion xAdsRegion, Region region, String accessToken)
      throws WebhooksApiException {
    this.logger.info("Entered into putToken ");

    Object localVarPostBody = tokenPayload;

    // verify the required parameter 'tokenPayload' is set
    if (tokenPayload == null) {
      throw new WebhooksApiException(400, "Missing the required parameter 'tokenPayload' when calling putToken");
    }

    // create path and map variables
    String localVarPath = "/webhooks/v1/tokens/@me";

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
          "Put",
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
      this.logger.info("putToken Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (WebhooksApiException e) {
      this.logger.error("putToken Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("putToken Request failed with exception: " + e.getMessage());
      throw new WebhooksApiException(e);
    }
  }

}
