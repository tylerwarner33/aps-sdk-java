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
import com.autodesk.aps.modelderivative.model.ModelViews;
import com.autodesk.aps.modelderivative.model.ObjectTree;
import com.autodesk.aps.modelderivative.model.Properties;
import com.autodesk.aps.modelderivative.model.Region;
import com.autodesk.aps.modelderivative.model.SpecificProperties;
import com.autodesk.aps.modelderivative.model.SpecificPropertiesPayload;
import com.autodesk.aps.modelderivative.model.XAdsDerivativeFormat;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class MetadataApi extends BaseApi {

  public MetadataApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Fetch Specific Properties
   * Queries the objects in the Model View (Viewable) specified by the
   * &#x60;&#x60;modelGuid&#x60;&#x60; parameter and returns the specified
   * properties in a paginated list. You can limit the number of objects to be
   * queried by specifying a filter using the &#x60;&#x60;query&#x60;&#x60;
   * attribute in the request body.
   * 
   * **Note:** A design file must be translated to SVF or SVF2 before you can
   * query object properties.
   * 
   * Before you call this operation:
   * 
   * - Use the &#x60;List Model Views
   * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
   * operation to obtain the list of Model Views in the source design.
   * - Pick the ID of the Model View you want to query and specify that ID as the
   * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
   * 
   * @param urn                       The URL-safe Base64 encoded URN of the
   *                                  source design. (required)
   * @param modelGuid                 The ID of the Model View you are querying.
   *                                  Use the &#x60;List Model Views
   *                                  &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
   *                                  operation to get the IDs of the Model Views
   *                                  in the source design. (required)
   * @param specificPropertiesPayload (required)
   * @param acceptEncoding            A comma separated list of the algorithms you
   *                                  want the response to be encoded in,
   *                                  specified in the order of preference. If you
   *                                  specify &#x60;&#x60;gzip&#x60;&#x60; or
   *                                  &#x60;&#x60;*&#x60;&#x60;, content is
   *                                  compressed and returned in gzip format.
   *                                  (optional)
   * @param region                    Specifies the data center where the manifest
   *                                  and derivatives of the specified source
   *                                  design are stored. Possible values are: -
   *                                  &#x60;&#x60;US&#x60;&#x60; - (Default) Data
   *                                  center for the US region. -
   *                                  &#x60;&#x60;EMEA&#x60;&#x60; - Data center
   *                                  for the European Union, Middle East, and
   *                                  Africa. - &#x60;&#x60;AUS&#x60;&#x60; - Data
   *                                  center for the Australia region. -
   *                                  &#x60;&#x60;CAN&#x60;&#x60; - Data center
   *                                  for the Canada region. -
   *                                  &#x60;&#x60;DEU&#x60;&#x60; - Data center
   *                                  for the Germany region. -
   *                                  &#x60;&#x60;IND&#x60;&#x60; - Data center
   *                                  for the India region. -
   *                                  &#x60;&#x60;JPN&#x60;&#x60; - Data center
   *                                  for the Japan region. -
   *                                  &#x60;&#x60;GBR&#x60;&#x60; - Data center
   *                                  for the United Kingdom region. (optional)
   * @param xAdsDerivativeFormat      Specifies what Object IDs to return, if the
   *                                  design has legacy SVF derivatives generated
   *                                  by the BIM Docs service. Possible values
   *                                  are: - &#x60;&#x60;latest&#x60;&#x60; -
   *                                  (Default) Return SVF2 Object IDs. -
   *                                  &#x60;&#x60;fallback&#x60;&#x60; - Return
   *                                  SVF Object IDs. **Note:** 1. This parameter
   *                                  applies only to designs with legacy SVF
   *                                  derivatives generated by the BIM 360 Docs
   *                                  service. 2. The BIM 360 Docs service now
   *                                  generates SVF2 derivatives. SVF2 Object IDs
   *                                  may not be compatible with the SVF Object
   *                                  IDs previously generated by the BIM 360 Docs
   *                                  service. Setting this header to fallback may
   *                                  resolve backward compatibility issues
   *                                  resulting from Object IDs of legacy SVF
   *                                  derivatives being retained on the client
   *                                  side. 3. If you use this parameter with one
   *                                  derivative (URN), you must use it
   *                                  consistently across the following: -
   *                                  &#x60;Create Translation Job
   *                                  &lt;/en/docs/model-derivative/v2/reference/http/job-POST&gt;&#x60;_
   *                                  (for OBJ output) - &#x60;Fetch Object Tree
   *                                  &lt;/en/docs/model-derivative/v2/reference/http/urn-metadata-modelguid-GET&gt;&#x60;_
   *                                  - &#x60;Fetch All Properties
   *                                  &lt;/en/docs/model-derivative/v2/reference/http/urn-metadata-guid-properties-GET&gt;&#x60;_
   *                                  - &#x60;Fetch Specific Properties
   *                                  &lt;en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-guid-properties-query-POST&gt;&#x60;_
   *                                  (optional)
   * @return SpecificProperties
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<SpecificProperties> fetchSpecificProperties(String urn, String modelGuid,
      SpecificPropertiesPayload specificPropertiesPayload, String acceptEncoding, Region region,
      XAdsDerivativeFormat xAdsDerivativeFormat, String accessToken) throws ModelDerivativeApiException {
    this.logger.info("Entered into fetchSpecificProperties ");

    Object localVarPostBody = specificPropertiesPayload;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'urn' when calling fetchSpecificProperties");
    }

    // verify the required parameter 'modelGuid' is set
    if (modelGuid == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'modelGuid' when calling fetchSpecificProperties");
    }

    // verify the required parameter 'specificPropertiesPayload' is set
    if (specificPropertiesPayload == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'specificPropertiesPayload' when calling fetchSpecificProperties");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/metadata/{modelGuid}/properties:query"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn))
        .replaceAll("\\{" + "modelGuid" + "\\}", parameterToString(modelGuid));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (acceptEncoding != null) {
      localVarHeaderParams.put("Accept-Encoding", parameterToString(acceptEncoding));
    }
    if (region != null) {
      localVarHeaderParams.put("region", parameterToString(region));
    }
    if (xAdsDerivativeFormat != null) {
      localVarHeaderParams.put("x-ads-derivative-format", parameterToString(xAdsDerivativeFormat));
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
      this.logger.info("fetchSpecificProperties Request completed successfully with status " + statusCode);
      SpecificProperties specificProperties = deserialize(entity, new TypeReference<SpecificProperties>() {
      });
      return new ApiResponse<SpecificProperties>(statusCode, response.getHeaders(), specificProperties);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("fetchSpecificProperties Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("fetchSpecificProperties Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

  /**
   * Fetch All Properties
   * Returns a list of properties of all objects in the Model View specified by
   * the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
   * 
   * This operation returns properties of all objects by default. However, you can
   * restrict the results to a specific object by specifying its ID as the
   * &#x60;&#x60;objectid&#x60;&#x60; parameter.
   * 
   * Properties are returned as a flat list, ordered, by their
   * &#x60;&#x60;objectid&#x60;&#x60;. The &#x60;&#x60;objectid&#x60;&#x60; is a
   * non-persistent ID assigned to an object when the source design is translated
   * to the SVF or SVF2 format. This means that:
   * 
   * - A design file must be translated to SVF or SVF2 before you can retrieve
   * properties.
   * - The &#x60;&#x60;objectid&#x60;&#x60; of an object can change if the design
   * is translated to SVF or SVF2 again. If you require a persistent ID across
   * translations, use &#x60;&#x60;externalId&#x60;&#x60; to reference objects,
   * instead of &#x60;&#x60;objectid&#x60;&#x60;.
   * 
   * Before you call this operation:
   * 
   * - Use the &#x60;List Model Views
   * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
   * operation to obtain the list of Model Views (Viewables) in the source design.
   * - Pick the ID of the Model View you want to query and specify that ID as the
   * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
   * 
   * **Tip**: Use &#x60;Fetch Specific Properties
   * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-guid-properties-query-POST/&gt;&#x60;_
   * to retrieve only the objects and properties of interest. What’s more, the
   * response is paginated. So, when the number of properties returned is large,
   * responses start arriving more promptly.
   * 
   * @param urn                  The URL-safe Base64 encoded URN of the source
   *                             design. (required)
   * @param modelGuid            The ID of the Model View you are querying. Use
   *                             the &#x60;List Model Views
   *                             &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
   *                             operation to get the IDs of the Model Views in
   *                             the source design. (required)
   * @param acceptEncoding       A comma separated list of the algorithms you want
   *                             the response to be encoded in, specified in the
   *                             order of preference. If you specify
   *                             &#x60;&#x60;gzip&#x60;&#x60; or
   *                             &#x60;&#x60;*&#x60;&#x60;, content is compressed
   *                             and returned in gzip format. (optional)
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
   * @param objectid             The Object ID of the object you want to restrict
   *                             the response to. If you do not specify this
   *                             parameter, all properties of all objects within
   *                             the Model View are returned. (optional)
   * @param forceget             &#x60;&#x60;true&#x60;&#x60;: Retrieves large
   *                             resources, even beyond the 20 MB limit. If
   *                             exceptionally large (over 800 MB), the system
   *                             acts as if &#x60;&#x60;forceget&#x60;&#x60; is
   *                             &#x60;&#x60;false&#x60;&#x60;.
   *                             &#x60;&#x60;false&#x60;&#x60;: (Default) Does not
   *                             retrieve resources if they are larger than 20 MB.
   *                             (optional)
   * @return Properties
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<Properties> getAllProperties(String urn, String modelGuid, String acceptEncoding,
      Boolean xAdsForce, XAdsDerivativeFormat xAdsDerivativeFormat, Region region, Integer objectid, String forceget,
      String accessToken) throws ModelDerivativeApiException {
    this.logger.info("Entered into getAllProperties ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling getAllProperties");
    }

    // verify the required parameter 'modelGuid' is set
    if (modelGuid == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'modelGuid' when calling getAllProperties");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/metadata/{modelGuid}/properties"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn))
        .replaceAll("\\{" + "modelGuid" + "\\}", parameterToString(modelGuid));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (objectid != null) {
      localVarQueryParams.put("objectid", parameterToString(objectid));
    }
    if (forceget != null) {
      localVarQueryParams.put("forceget", parameterToString(forceget));
    }

    if (acceptEncoding != null) {
      localVarHeaderParams.put("Accept-Encoding", parameterToString(acceptEncoding));
    }
    if (xAdsForce != null) {
      localVarHeaderParams.put("x-ads-force", parameterToString(xAdsForce));
    }
    if (xAdsDerivativeFormat != null) {
      localVarHeaderParams.put("x-ads-derivative-format", parameterToString(xAdsDerivativeFormat));
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
      this.logger.info("getAllProperties Request completed successfully with status " + statusCode);
      Properties properties = deserialize(entity, new TypeReference<Properties>() {
      });
      return new ApiResponse<Properties>(statusCode, response.getHeaders(), properties);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("getAllProperties Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getAllProperties Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

  /**
   * List Model Views
   * Returns a list of Model Views (Viewables) in the source design specified by
   * the &#x60;&#x60;urn&#x60;&#x60; parameter. It also returns an ID that
   * uniquely identifies the Model View. You can use these IDs with other metadata
   * operations to obtain information about the objects within those Model Views.
   * 
   * Designs created with applications like Fusion 360 and Inventor contain only
   * one Model View per design. Applications like Revit allow multiple Model Views
   * per design.
   * 
   * **Note:** You can retrieve metadata only from a design that has already been
   * translated to SVF or SVF2.
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
   * @return ModelViews
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<ModelViews> getModelViews(String urn, String acceptEncoding, Region region, String accessToken)
      throws ModelDerivativeApiException {
    this.logger.info("Entered into getModelViews ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling getModelViews");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/metadata"
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
      this.logger.info("getModelViews Request completed successfully with status " + statusCode);
      ModelViews modelViews = deserialize(entity, new TypeReference<ModelViews>() {
      });
      return new ApiResponse<ModelViews>(statusCode, response.getHeaders(), modelViews);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("getModelViews Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getModelViews Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

  /**
   * Fetch Object tree
   * Retrieves the structured hierarchy of objects, known as an object tree, from
   * the specified Model View (Viewable) within the specified source design. The
   * object tree represents the arrangement and relationships of various objects
   * present in that Model View.
   * 
   * **Note:** A design file must be translated to SVF or SVF2 before you can
   * retrieve its object tree.
   * 
   * Before you call this operation:
   * 
   * - Use the &#x60;List Model Views
   * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
   * operation to obtain the list of Model Views in the source design.
   * - Pick the ID of the Model View you want to query and specify that ID as the
   * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
   * 
   * @param urn                  The URL-safe Base64 encoded URN of the source
   *                             design. (required)
   * @param modelGuid            The ID of the Model View you are extracting the
   *                             object tree from. Use the &#x60;List Model Views
   *                             &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
   *                             operation to get the IDs of the Model Views in
   *                             the source design. (required)
   * @param acceptEncoding       A comma separated list of the algorithms you want
   *                             the response to be encoded in, specified in the
   *                             order of preference. If you specify
   *                             &#x60;&#x60;gzip&#x60;&#x60; or
   *                             &#x60;&#x60;*&#x60;&#x60;, content is compressed
   *                             and returned in gzip format. (optional)
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
   * @param forceget             &#x60;&#x60;true&#x60;&#x60;: Retrieves large
   *                             resources, even beyond the 20 MB limit. If
   *                             exceptionally large (over 800 MB), the system
   *                             acts as if &#x60;&#x60;forceget&#x60;&#x60; is
   *                             &#x60;&#x60;false&#x60;&#x60;.
   *                             &#x60;&#x60;false&#x60;&#x60;: (Default) Does not
   *                             retrieve resources if they are larger than 20 MB.
   *                             (optional)
   * @param objectid             If specified, retrieves the sub-tree that has the
   *                             specified Object ID as its parent node. If this
   *                             parameter is not specified, retrieves the entire
   *                             object tree. (optional)
   * @param level                Specifies how many child levels of the hierarchy
   *                             to return, when the
   *                             &#x60;&#x60;objectid&#x60;&#x60; parameter is
   *                             specified. Currently supports only
   *                             &#x60;&#x60;level&#x60;&#x60; &#x3D;
   *                             &#x60;&#x60;1&#x60;&#x60;. (optional)
   * @return ObjectTree
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<ObjectTree> getObjectTree(String urn, String modelGuid, String acceptEncoding, Region region,
      Boolean xAdsForce, XAdsDerivativeFormat xAdsDerivativeFormat, String forceget, Integer objectid, String level,
      String accessToken) throws ModelDerivativeApiException {
    this.logger.info("Entered into getObjectTree ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling getObjectTree");
    }

    // verify the required parameter 'modelGuid' is set
    if (modelGuid == null) {
      throw new ModelDerivativeApiException(400,
          "Missing the required parameter 'modelGuid' when calling getObjectTree");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/metadata/{modelGuid}"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn))
        .replaceAll("\\{" + "modelGuid" + "\\}", parameterToString(modelGuid));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (forceget != null) {
      localVarQueryParams.put("forceget", parameterToString(forceget));
    }
    if (objectid != null) {
      localVarQueryParams.put("objectid", parameterToString(objectid));
    }
    if (level != null) {
      localVarQueryParams.put("level", parameterToString(level));
    }

    if (acceptEncoding != null) {
      localVarHeaderParams.put("Accept-Encoding", parameterToString(acceptEncoding));
    }
    if (region != null) {
      localVarHeaderParams.put("region", parameterToString(region));
    }
    if (xAdsForce != null) {
      localVarHeaderParams.put("x-ads-force", parameterToString(xAdsForce));
    }
    if (xAdsDerivativeFormat != null) {
      localVarHeaderParams.put("x-ads-derivative-format", parameterToString(xAdsDerivativeFormat));
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
      this.logger.info("getObjectTree Request completed successfully with status " + statusCode);
      ObjectTree objectTree = deserialize(entity, new TypeReference<ObjectTree>() {
      });
      return new ApiResponse<ObjectTree>(statusCode, response.getHeaders(), objectTree);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("getObjectTree Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getObjectTree Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

}
