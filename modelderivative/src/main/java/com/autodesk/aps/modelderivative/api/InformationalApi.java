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
import com.autodesk.aps.modelderivative.model.SupportedFormats;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class InformationalApi extends BaseApi {

  public InformationalApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * List Supported Formats
   * Returns an up-to-date list of supported translations. This operation also
   * provides information on the types of derivatives that can be generated for
   * each source design file type. Furthermore, it allows you to obtain a list of
   * translations that have changed since a specified date.
   * 
   * See the [Supported Translation Formats
   * table](/en/docs/model-derivative/v2/overview/supported-translations/) for
   * more details.
   * 
   * **Note:** We keep adding new file formats to our supported translations list,
   * constantly.
   * 
   * @param ifModifiedSince Specifies a date in the &#x60;&#x60;Day of the week,
   *                        DD Month YYYY HH:MM:SS GMT&#x60;&#x60; format. The
   *                        response will contain only the formats modified since
   *                        the specified date and time. If you specify an invalid
   *                        date, the response will contain all supported formats.
   *                        If no changes have been made after the specified date,
   *                        the service returns HTTP status
   *                        &#x60;&#x60;304&#x60;&#x60;, NOT MODIFIED. (optional)
   * @param acceptEncoding  A comma separated list of the algorithms you want the
   *                        response to be encoded in, specified in the order of
   *                        preference. If you specify
   *                        &#x60;&#x60;gzip&#x60;&#x60; or
   *                        &#x60;&#x60;*&#x60;&#x60;, content is compressed and
   *                        returned in gzip format. (optional)
   * @return SupportedFormats
   * @throws ModelDerivativeApiException if fails to make API call
   */
  public ApiResponse<SupportedFormats> getFormats(String ifModifiedSince, String acceptEncoding, String accessToken)
      throws ModelDerivativeApiException {
    this.logger.info("Entered into getFormats ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/modelderivative/v2/designdata/formats";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (ifModifiedSince != null) {
      localVarHeaderParams.put("If-Modified-Since", parameterToString(ifModifiedSince));
    }
    if (acceptEncoding != null) {
      localVarHeaderParams.put("Accept-Encoding", parameterToString(acceptEncoding));
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
      this.logger.info("getFormats Request completed successfully with status " + statusCode);
      SupportedFormats supportedFormats = deserialize(entity, new TypeReference<SupportedFormats>() {
      });
      return new ApiResponse<SupportedFormats>(statusCode, response.getHeaders(), supportedFormats);
    } catch (ModelDerivativeApiException e) {
      this.logger.error("getFormats Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getFormats Request failed with exception: " + e.getMessage());
      throw new ModelDerivativeApiException(e);
    }
  }

}
