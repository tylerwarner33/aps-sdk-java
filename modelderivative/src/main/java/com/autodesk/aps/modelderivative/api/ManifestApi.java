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
import com.autodesk.aps.modelderivative.model.DeleteManifest;
import com.autodesk.aps.modelderivative.model.Manifest;
import com.autodesk.aps.modelderivative.model.Region;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class ManifestApi extends BaseApi {

  public ManifestApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Delete Manifest
   * Deletes the manifest of the specified source design. It also deletes all
   * derivatives (translated output files) generated from the source design.
   * However, it does not delete the source design.
   * 
   * **Note:** This operation is idempotent. So, if you call it multiple times,
   * even when no manifest exists, will still return a successful response (200).
   * 
   * @param urn    The URL-safe Base64 encoded URN of the source design.
   *               (required)
   * @param region Specifies the data center where the manifest and derivatives of
   *               the specified source design are stored. Possible values are: -
   *               &#x60;&#x60;US&#x60;&#x60; - (Default) Data center for the US
   *               region. - &#x60;&#x60;EMEA&#x60;&#x60; - Data center for the
   *               European Union, Middle East, and Africa. -
   *               &#x60;&#x60;AUS&#x60;&#x60; - Data center for the Australia
   *               region. - &#x60;&#x60;CAN&#x60;&#x60; - Data center for the
   *               Canada region. - &#x60;&#x60;DEU&#x60;&#x60; - Data center for
   *               the Germany region. - &#x60;&#x60;IND&#x60;&#x60; - Data center
   *               for the India region. - &#x60;&#x60;JPN&#x60;&#x60; - Data
   *               center for the Japan region. - &#x60;&#x60;GBR&#x60;&#x60; -
   *               Data center for the United Kingdom region. (optional)
   * @return DeleteManifest
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<DeleteManifest> deleteManifest(String urn, Region region, String accessToken)
      throws ModelDerivativeApiException {
    this.logger.info("Entered into deleteManifest ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling deleteManifest");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/manifest"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn));

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
          "Delete",
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
      this.logger.info("deleteManifest Request completed successfully with status " + statusCode);
      DeleteManifest deleteManifest = deserialize(entity, new TypeReference<DeleteManifest>() {
      });
      return new ApiResponse<DeleteManifest>(statusCode, response.getHeaders(), deleteManifest);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("deleteManifest Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteManifest Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

  /**
   * Fetch Manifest
   * Retrieves the manifest of the specified source design.
   * 
   * The manifest is a JSON file containing information about all the derivatives
   * translated from the specified source design. It contains information such as
   * the URNs of the derivatives, the translation status of each derivative, and
   * much more.
   * 
   * The first time you translate a source design, the Model Derivative service
   * creates a manifest for that design. Thereafter, every time you translate that
   * source design, even to a different format, the Model Derivative service
   * updates the same manifest. It does not create a new manifest. Instead, the
   * manifest acts like a central registry for all the derivatives of your source
   * design created through the Model Derivative service.
   * 
   * When the Model Derivative service starts a translation job (as a result of a
   * request you make using &#x60;Create Translation Job
   * &lt;/en/docs/model-derivative/v2/reference/http/jobs/job-POST/&gt;&#x60;_),
   * it keeps on updating the manifest at regular intervals. So, you can use the
   * manifest to check the status and progress of each derivative that is being
   * generated. When multiple derivatives have been requested each derivative may
   * complete at a different time. So, each derivative has its own
   * &#x60;&#x60;status&#x60;&#x60; attribute. The manifest also contains an
   * overall &#x60;&#x60;status&#x60;&#x60; attribute. The overall
   * &#x60;&#x60;status&#x60;&#x60; becomes &#x60;&#x60;complete&#x60;&#x60; when
   * the &#x60;&#x60;status&#x60;&#x60; of all individual derivatives become
   * complete.
   * 
   * Once the translation status of a derivative is
   * &#x60;&#x60;complete&#x60;&#x60; you can download the derivative.
   * 
   * **Note:** You cannot download 3D SVF2 derivatives.
   * 
   * @param urn            The URL-safe Base64 encoded URN of the source design.
   *                       (required)
   * @param acceptEncoding A comma separated list of the algorithms you want the
   *                       response to be encoded in, specified in the order of
   *                       preference. If you specify &#x60;&#x60;gzip&#x60;&#x60;
   *                       or &#x60;&#x60;*&#x60;&#x60;, content is compressed and
   *                       returned in gzip format. (optional)
   * @param region         Specifies the data center where the manifest and
   *                       derivatives of the specified source design are stored.
   *                       Possible values are: - &#x60;&#x60;US&#x60;&#x60; -
   *                       (Default) Data center for the US region. -
   *                       &#x60;&#x60;EMEA&#x60;&#x60; - Data center for the
   *                       European Union, Middle East, and Africa. -
   *                       &#x60;&#x60;AUS&#x60;&#x60; - Data center for the
   *                       Australia region. - &#x60;&#x60;CAN&#x60;&#x60; - Data
   *                       center for the Canada region. -
   *                       &#x60;&#x60;DEU&#x60;&#x60; - Data center for the
   *                       Germany region. - &#x60;&#x60;IND&#x60;&#x60; - Data
   *                       center for the India region. -
   *                       &#x60;&#x60;JPN&#x60;&#x60; - Data center for the Japan
   *                       region. - &#x60;&#x60;GBR&#x60;&#x60; - Data center for
   *                       the United Kingdom region. (optional)
   * @return Manifest
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<Manifest> getManifest(String urn, String acceptEncoding, Region region, String accessToken)
      throws ModelDerivativeApiException {
    this.logger.info("Entered into getManifest ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling getManifest");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/manifest"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (acceptEncoding != null) {
      localVarHeaderParams.put("Accept-Encoding", parameterToString(acceptEncoding));
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
      this.logger.info("getManifest Request completed successfully with status " + statusCode);
      Manifest manifest = deserialize(entity, new TypeReference<Manifest>() {
      });
      return new ApiResponse<Manifest>(statusCode, response.getHeaders(), manifest);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("getManifest Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getManifest Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

}
