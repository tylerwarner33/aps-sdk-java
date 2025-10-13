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
import com.autodesk.aps.modelderivative.model.Job;
import com.autodesk.aps.modelderivative.model.JobPayload;
import com.autodesk.aps.modelderivative.model.Region;
import com.autodesk.aps.modelderivative.model.SpecifyReferences;
import com.autodesk.aps.modelderivative.model.SpecifyReferencesPayload;
import com.autodesk.aps.modelderivative.model.XAdsDerivativeFormat;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class JobsApi extends BaseApi {

  public JobsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Specify References
   * Specifies the location of the files referenced by the specified source
   * design.
   * 
   * When you call &#x60;Create Translation Job
   * &lt;/en/docs/model-derivative/v2/reference/http/job-POST&gt;&#x60;_, set
   * &#x60;&#x60;checkReferences&#x60;&#x60; to &#x60;&#x60;true&#x60;&#x60;. The
   * Model Derivative service will then use the details you specify in this
   * operation to locate and download the referenced files.
   * 
   * @param urn                      The Base64 (URL Safe) encoded design URN.
   *                                 (required)
   * @param specifyReferencesPayload (required)
   * @param region                   Specifies the data center where the manifest
   *                                 and derivatives of the specified source
   *                                 design are stored. Possible values are: -
   *                                 &#x60;&#x60;US&#x60;&#x60; - (Default) Data
   *                                 center for the US region. -
   *                                 &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                                 for the European Union, Middle East, and
   *                                 Africa. - &#x60;&#x60;AUS&#x60;&#x60; - Data
   *                                 center for the Australia region. -
   *                                 &#x60;&#x60;CAN&#x60;&#x60; - Data center for
   *                                 the Canada region. -
   *                                 &#x60;&#x60;DEU&#x60;&#x60; - Data center for
   *                                 the Germany region. -
   *                                 &#x60;&#x60;IND&#x60;&#x60; - Data center for
   *                                 the India region. -
   *                                 &#x60;&#x60;JPN&#x60;&#x60; - Data center for
   *                                 the Japan region. -
   *                                 &#x60;&#x60;GBR&#x60;&#x60; - Data center for
   *                                 the United Kingdom region. (optional)
   * @return SpecifyReferences
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<SpecifyReferences> specifyReferences(String urn, SpecifyReferencesPayload specifyReferencesPayload,
      Region region, String accessToken) throws ModelDerivativeApiException {
    this.logger.info("Entered into specifyReferences ");

    Object localVarPostBody = specifyReferencesPayload;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling specifyReferences");
    }

    // verify the required parameter 'specifyReferencesPayload' is set
    if (specifyReferencesPayload == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'specifyReferencesPayload' when calling specifyReferences");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/references"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarHeaderParams.put("region", parameterToString(region));
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
        throw new ModelDerivativeApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("specifyReferences Request completed successfully with status " + statusCode);
      SpecifyReferences specifyReferences = deserialize(entity, new TypeReference<SpecifyReferences>() {
      });
      return new ApiResponse<SpecifyReferences>(statusCode, response.getHeaders(), specifyReferences);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("specifyReferences Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("specifyReferences Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

  /**
   * Create Translation Job
   * Creates a job to translate the specified source design to another format,
   * generating derivatives of the source design. You can optionally:
   * 
   * - Extract selected parts of a design and export the set of geometries in OBJ
   * format.
   * - Generate different-sized thumbnails.
   * 
   * When the translation job runs, details about the process and generated
   * derivatives are logged to a JSON file known as a manifest. This manifest is
   * typically created during the first translation of a source design.
   * Subsequently, the system updates the same manifest whenever a translation is
   * performed for that design.
   * 
   * If necessary, you can set the &#x60;&#x60;x-ads-force&#x60;&#x60; parameter
   * to &#x60;&#x60;true&#x60;&#x60;. Then, the system will delete the existing
   * manifest and create a new one. However, be aware that doing so will also
   * delete all previously generated derivatives.
   * 
   * @param jobPayload           (required)
   * @param xAdsForce            - &#x60;&#x60;true&#x60;&#x60;: Forces the system
   *                             to parse property data all over again. Use this
   *                             option to retrieve an object tree when previous
   *                             attempts have failed. -
   *                             &#x60;&#x60;false&#x60;&#x60;: (Default) Use
   *                             previously parsed property data to extract the
   *                             object tree. (optional)
   * @param xAdsDerivativeFormat Specifies what Object IDs to return, if the
   *                             design has legacy SVF derivatives generated by
   *                             the BIM Docs service. Possible values are: -
   *                             &#x60;&#x60;latest&#x60;&#x60; - (Default) Return
   *                             SVF2 Object IDs. -
   *                             &#x60;&#x60;fallback&#x60;&#x60; - Return SVF
   *                             Object IDs. **Note:** 1. This parameter applies
   *                             only to designs with legacy SVF derivatives
   *                             generated by the BIM 360 Docs service. 2. The BIM
   *                             360 Docs service now generates SVF2 derivatives.
   *                             SVF2 Object IDs may not be compatible with the
   *                             SVF Object IDs previously generated by the BIM
   *                             360 Docs service. Setting this header to fallback
   *                             may resolve backward compatibility issues
   *                             resulting from Object IDs of legacy SVF
   *                             derivatives being retained on the client side. 3.
   *                             If you use this parameter with one derivative
   *                             (URN), you must use it consistently across the
   *                             following: - &#x60;Create Translation Job
   *                             &lt;/en/docs/model-derivative/v2/reference/http/job-POST&gt;&#x60;_
   *                             (for OBJ output) - &#x60;Fetch Object Tree
   *                             &lt;/en/docs/model-derivative/v2/reference/http/urn-metadata-modelguid-GET&gt;&#x60;_
   *                             - &#x60;Fetch All Properties
   *                             &lt;/en/docs/model-derivative/v2/reference/http/urn-metadata-guid-properties-GET&gt;&#x60;_
   *                             - &#x60;Fetch Specific Properties
   *                             &lt;en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-guid-properties-query-POST&gt;&#x60;_
   *                             (optional)
   * @param region               Specifies the data center where the manifest and
   *                             derivatives of the specified source design are
   *                             stored. Possible values are: -
   *                             &#x60;&#x60;US&#x60;&#x60; - (Default) Data
   *                             center for the US region. -
   *                             &#x60;&#x60;EMEA&#x60;&#x60; - Data center for
   *                             the European Union, Middle East, and Africa. -
   *                             &#x60;&#x60;AUS&#x60;&#x60; - Data center for the
   *                             Australia region. - &#x60;&#x60;CAN&#x60;&#x60; -
   *                             Data center for the Canada region. -
   *                             &#x60;&#x60;DEU&#x60;&#x60; - Data center for the
   *                             Germany region. - &#x60;&#x60;IND&#x60;&#x60; -
   *                             Data center for the India region. -
   *                             &#x60;&#x60;JPN&#x60;&#x60; - Data center for the
   *                             Japan region. - &#x60;&#x60;GBR&#x60;&#x60; -
   *                             Data center for the United Kingdom region.
   *                             (optional)
   * @return Job
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<Job> startJob(JobPayload jobPayload, Boolean xAdsForce, XAdsDerivativeFormat xAdsDerivativeFormat,
      Region region, String accessToken) throws ModelDerivativeApiException {
    this.logger.info("Entered into startJob ");

    Object localVarPostBody = jobPayload;

    // verify the required parameter 'jobPayload' is set
    if (jobPayload == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'jobPayload' when calling startJob");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/job";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (xAdsForce != null) {
      localVarHeaderParams.put("x-ads-force", parameterToString(xAdsForce));
    }
    if (xAdsDerivativeFormat != null) {
      localVarHeaderParams.put("x-ads-derivative-format", parameterToString(xAdsDerivativeFormat));
    }
    if (region != null) {
      localVarHeaderParams.put("region", parameterToString(region));
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
        throw new ModelDerivativeApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("startJob Request completed successfully with status " + statusCode);
      Job job = deserialize(entity, new TypeReference<Job>() {
      });
      return new ApiResponse<Job>(statusCode, response.getHeaders(), job);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("startJob Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("startJob Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

}
