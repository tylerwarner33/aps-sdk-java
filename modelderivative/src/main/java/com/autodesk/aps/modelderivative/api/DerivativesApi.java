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
package com.autodesk.aps.modelderivative.api;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.modelderivative.BaseApi;
import com.autodesk.aps.modelderivative.ModelDerivativeApiException;
import com.autodesk.aps.modelderivative.model.DerivativeDownload;
import com.autodesk.aps.modelderivative.model.Region;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class DerivativesApi extends BaseApi {

  public DerivativesApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Fetch Derivative Download URL
   * Returns a download URL and a set of signed cookies, which lets you securely
   * download the derivative specified by the
   * &#x60;&#x60;derivativeUrn&#x60;&#x60; URI parameter. The signed cookies have
   * a lifetime of 6 hours. You can use range headers with the returned download
   * URL to download the derivative in chunks, in parallel.
   * 
   * @param derivativeUrn              The URL-encoded URN of the derivative. Use
   *                                   the &#x60;Fetch Manifest operation
   *                                   &lt;/en/docs/model-derivative/v2/reference/http/manifest/urn-manifest-GET/&gt;&#x60;_to
   *                                   obtain the URNs of derivatives for the
   *                                   specified source design. (required)
   * @param urn                        The URL-safe Base64 encoded URN of the
   *                                   source design. (required)
   * @param minutesExpiration          Specifies how many minutes the signed
   *                                   cookies should remain valid. Default value
   *                                   is 360 minutes. The value you specify must
   *                                   be lower than the default value for this
   *                                   parameter. If you specify a value greater
   *                                   than the default value, the Model
   *                                   Derivative service will return an error
   *                                   with an HTTP status code of
   *                                   &#x60;&#x60;400&#x60;&#x60;. (optional)
   * @param responseContentDisposition The value that must be specified as the
   *                                   &#x60;&#x60;response-content-disposition&#x60;&#x60;
   *                                   query string parameter with the download
   *                                   URL. Must begin with
   *                                   &#x60;&#x60;attachment&#x60;&#x60;. This
   *                                   value defaults to the default value
   *                                   corresponding to the derivative/file.
   *                                   (optional)
   * @param region                     Specifies the data center where the
   *                                   manifest and derivatives of the specified
   *                                   source design are stored. Possible values
   *                                   are: - &#x60;&#x60;US&#x60;&#x60; -
   *                                   (Default) Data center for the US region. -
   *                                   &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                                   for the European Union, Middle East, and
   *                                   Africa. - &#x60;&#x60;AUS&#x60;&#x60; -
   *                                   Data center for the Australia region. -
   *                                   &#x60;&#x60;CAN&#x60;&#x60; - Data center
   *                                   for the Canada region. -
   *                                   &#x60;&#x60;DEU&#x60;&#x60; - Data center
   *                                   for the Germany region. -
   *                                   &#x60;&#x60;IND&#x60;&#x60; - Data center
   *                                   for the India region. -
   *                                   &#x60;&#x60;JPN&#x60;&#x60; - Data center
   *                                   for the Japan region. -
   *                                   &#x60;&#x60;GBR&#x60;&#x60; - Data center
   *                                   for the United Kingdom region. (optional)
   * @return DerivativeDownload
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<DerivativeDownload> getDerivativeUrl(String derivativeUrn, String urn, Integer minutesExpiration,
      String responseContentDisposition, Region region, String accessToken) throws ModelDerivativeApiException {
    this.logger.info("Entered into getDerivativeUrl ");

    Object localVarPostBody = null;

    // verify the required parameter 'derivativeUrn' is set
    if (derivativeUrn == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'derivativeUrn' when calling getDerivativeUrl");
    }

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling getDerivativeUrl");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/manifest/{derivativeUrn}/signedcookies"
        .replaceAll("\\{" + "derivativeUrn" + "\\}", parameterToString(derivativeUrn))
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (minutesExpiration != null) {
      localVarQueryParams.put("minutes-expiration", parameterToString(minutesExpiration));
    }
    if (responseContentDisposition != null) {
      localVarQueryParams.put("response-content-disposition", parameterToString(responseContentDisposition));
    }

    if (region != null) {
      localVarHeaderParams.put("region", parameterToString(region));
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
        throw new ModelDerivativeApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getDerivativeUrl Request completed successfully with status " + statusCode);
      DerivativeDownload derivativeDownload = deserialize(entity, new TypeReference<DerivativeDownload>() {
      });
      return new ApiResponse<DerivativeDownload>(statusCode, response.getHeaders(), derivativeDownload);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("getDerivativeUrl Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getDerivativeUrl Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

  /**
   * Check Derivative Details
   * Returns information about the specified derivative.
   * 
   * Use this operation to determine the total content length of a derivative
   * before you download it. If the derivative is large, you can choose to
   * download the derivative in chunks, by specifying a chunk size using the
   * &#x60;&#x60;Range&#x60;&#x60; header parameter.
   * 
   * @param urn           The URL-safe Base64 encoded URN of the source design.
   *                      (required)
   * @param derivativeUrn The URL-encoded URN of the derivative. Check the
   *                      manifest of the source design to get the URNs of the
   *                      derivatives available for download. (required)
   * @param region        Specifies the data center where the manifest and
   *                      derivatives of the specified source design are stored.
   *                      Possible values are: - &#x60;&#x60;US&#x60;&#x60; -
   *                      (Default) Data center for the US region. -
   *                      &#x60;&#x60;EMEA&#x60;&#x60; - Data center for the
   *                      European Union, Middle East, and Africa. -
   *                      &#x60;&#x60;AUS&#x60;&#x60; - Data center for the
   *                      Australia region. - &#x60;&#x60;CAN&#x60;&#x60; - Data
   *                      center for the Canada region. -
   *                      &#x60;&#x60;DEU&#x60;&#x60; - Data center for the
   *                      Germany region. - &#x60;&#x60;IND&#x60;&#x60; - Data
   *                      center for the India region. -
   *                      &#x60;&#x60;JPN&#x60;&#x60; - Data center for the Japan
   *                      region. - &#x60;&#x60;GBR&#x60;&#x60; - Data center for
   *                      the United Kingdom region. (optional)
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<Void> headCheckDerivative(String urn, String derivativeUrn, Region region, String accessToken)
      throws ModelDerivativeApiException {
    this.logger.info("Entered into headCheckDerivative ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'urn' when calling headCheckDerivative");
    }

    // verify the required parameter 'derivativeUrn' is set
    if (derivativeUrn == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'derivativeUrn' when calling headCheckDerivative");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/manifest/{derivativeUrn}"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn))
        .replaceAll("\\{" + "derivativeUrn" + "\\}", parameterToString(derivativeUrn));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarHeaderParams.put("region", parameterToString(region));
    }

    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Head",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new ModelDerivativeApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("headCheckDerivative Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (ModelDerivativeApiException e) {
      this.logger.error("headCheckDerivative Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("headCheckDerivative Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

}
