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
package com.autodesk.aps.modelderivative;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import com.autodesk.aps.sdkmanager.ApsServiceRequestConfig;
import com.autodesk.aps.sdkmanager.IApsLogger;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseApi {

    protected SdkManager sdkManager;
    protected IApsLogger logger;
    private ObjectMapper objectMapper;
    String userAgent = "APS SDK/MODELDERIVATIVE/JAVA/1.0.0";

    public BaseApi(SdkManager sdkManager, IApsLogger logger) {
        this.sdkManager = sdkManager;
        this.logger = logger;
        this.objectMapper = new ObjectMapper();
    }

    public <T> T deserialize(HttpEntity entity, TypeReference<T> valueType)
            throws ModelDerivativeApiException {
        try {
            if (valueType == null) {
                return null;
            }
            String content = EntityUtils.toString(entity);
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        } 
    }

    public <T> ClassicHttpResponse invokeAPI(
            String path,
            String method,
            Map<String, String> queryParams,
            Object body,
            Map<String, String> headerParams,
            Map<String, Object> formParams) throws ModelDerivativeApiException {
        try {
            if (body != null && formParams != null && !formParams.isEmpty()) {
                throw new ModelDerivativeApiException("Cannot have body and form params");
            }

            final String url = sdkManager.getApsConfiguration().getBaseAddress() + path;

            ApsServiceRequestConfig requestConfig = new ApsServiceRequestConfig();

            requestConfig.setUrl(url);
            requestConfig.setMethod(method);

            if (queryParams != null && !queryParams.isEmpty()) {
                requestConfig.setQueryParams(queryParams);
            }
            if (headerParams != null && !headerParams.isEmpty()) {
                requestConfig.setHeaders(headerParams);
            }
            if (formParams != null && !formParams.isEmpty()) {
                List<BasicNameValuePair> formValues = new ArrayList<>();
                for (Map.Entry<String, Object> paramEntry : formParams.entrySet()) {
                    formValues.add(new BasicNameValuePair(paramEntry.getKey(), parameterToString(paramEntry.getValue())));
                }
                requestConfig.setBody(new UrlEncodedFormEntity(formValues, StandardCharsets.UTF_8));
            }

            if (body != null) {
                requestConfig.setBody(body);
            }

            return sdkManager.getApsClient().getApsService().request(requestConfig);
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }

    }

    public final String getUserAgent() {
        return userAgent;
    }

    protected boolean isSuccessfulStatus(int statusCode) {
        return statusCode >= 200 && statusCode < 300;
    }
   
    public String parameterToString(Object param) {
        return String.valueOf(param);
    }

    public void close() {
        try {
            this.sdkManager.getApsClient().getApsService().close();
        } catch (Exception e) {
            this.logger.error("Error closing APS Service: " + e.getMessage());
            throw new ModelDerivativeApiException(e);
        }
    }
}