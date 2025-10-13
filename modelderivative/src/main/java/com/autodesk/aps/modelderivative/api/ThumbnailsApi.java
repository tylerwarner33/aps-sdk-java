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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.modelderivative.BaseApi;
import com.autodesk.aps.modelderivative.ModelDerivativeApiException;
import com.autodesk.aps.modelderivative.model.Height;
import com.autodesk.aps.modelderivative.model.Region;
import com.autodesk.aps.modelderivative.model.Width;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;

public class ThumbnailsApi extends BaseApi {

  public ThumbnailsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Fetch Thumbnail
   * Downloads a thumbnail of the specified source design.
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
   * @param width  Width of thumbnail in pixels. Possible values are:
   *               &#x60;&#x60;100&#x60;&#x60;, &#x60;&#x60;200&#x60;&#x60;,
   *               &#x60;&#x60;400&#x60;&#x60; If &#x60;&#x60;width&#x60;&#x60; is
   *               omitted, but &#x60;&#x60;height&#x60;&#x60; is specified,
   *               &#x60;&#x60;width&#x60;&#x60; defaults to
   *               &#x60;&#x60;height&#x60;&#x60;. If both
   *               &#x60;&#x60;width&#x60;&#x60; and
   *               &#x60;&#x60;height&#x60;&#x60; are omitted, the server will
   *               return a thumbnail closest to &#x60;&#x60;200&#x60;&#x60;, if
   *               such a thumbnail is available. (optional)
   * @param height Height of thumbnails. Possible values are:
   *               &#x60;&#x60;100&#x60;&#x60;, &#x60;&#x60;200&#x60;&#x60;,
   *               &#x60;&#x60;400&#x60;&#x60;.If &#x60;&#x60;height&#x60;&#x60;
   *               is omitted, but &#x60;&#x60;width&#x60;&#x60; is specified,
   *               &#x60;&#x60;height&#x60;&#x60; defaults to
   *               &#x60;&#x60;width&#x60;&#x60;. If both
   *               &#x60;&#x60;width&#x60;&#x60; and
   *               &#x60;&#x60;height&#x60;&#x60; are omitted, the server will
   *               return a thumbnail closest to &#x60;&#x60;200&#x60;&#x60;, if
   *               such a thumbnail is available (optional)
   * @return InputStream
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<InputStream> getThumbnail(String urn, Region region, Width width, Height height, String accessToken)
      throws ModelDerivativeApiException {
    this.logger.info("Entered into getThumbnail ");

    Object localVarPostBody = null;

    // verify the required parameter 'urn' is set
    if (urn == null) {
      throw new ModelDerivativeApiException(400, "Missing the required parameter 'urn' when calling getThumbnail");
    }

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/{urn}/thumbnail"
        .replaceAll("\\{" + "urn" + "\\}", parameterToString(urn));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (width != null) {
      localVarQueryParams.put("width", parameterToString(width));
    }
    if (height != null) {
      localVarQueryParams.put("height", parameterToString(height));
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
      this.logger.info("getThumbnail Request completed successfully with status " + statusCode);

      byte[] bytes = EntityUtils.toByteArray(entity);
      InputStream inputStream = new ByteArrayInputStream(bytes);
      return new ApiResponse<InputStream>(statusCode, response.getHeaders(), inputStream);

    } catch (ModelDerivativeApiException e) {
      this.logger.error("getThumbnail Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getThumbnail Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

}
