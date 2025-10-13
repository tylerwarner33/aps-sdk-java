/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * oss
 * The Object Storage Service (OSS) allows your application to download and upload raw files (such as PDF, XLS, DWG, or RVT) that are managed by the Data service.
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
package com.autodesk.aps.oss.api;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.oss.BaseApi;
import com.autodesk.aps.oss.OssApiException;
import com.autodesk.aps.oss.model.Bucket;
import com.autodesk.aps.oss.model.Buckets;
import com.autodesk.aps.oss.model.CreateBucketsPayload;
import com.autodesk.aps.oss.model.Region;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class BucketsApi extends BaseApi {

  public BucketsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Create Bucket
   * Creates a bucket.
   * 
   * Buckets are virtual container within the Object Storage Service (OSS), which
   * you can use to store and manage objects (files) in the cloud. The application
   * creating the bucket is the owner of the bucket.
   * 
   * **Note:** Do not use this operation to create buckets for BIM360 Document
   * Management. Use [POST
   * projects/{project_id}/storage](/en/docs/data/v2/reference/http/projects-project_id-storage-POST&gt;)
   * instead. For details, see [Upload Files to BIM 360 Document
   * Management](/en/docs/bim360/v1/tutorials/document-management/upload-document).
   * 
   * @param region               Specifies where the bucket containing the object
   *                             is stored. Possible values are: -
   *                             &#x60;&#x60;US&#x60;&#x60; : (Default) Data
   *                             center for the US region. -
   *                             &#x60;&#x60;EMEA&#x60;&#x60; : Data center for
   *                             the European Union, Middle East, and Africa. -
   *                             &#x60;&#x60;AUS&#x60;&#x60; : (Beta) Data center
   *                             for Australia. - &#x60;&#x60;CAN&#x60;&#x60; :
   *                             Data center for the Canada region. -
   *                             &#x60;&#x60;DEU&#x60;&#x60; : Data center for the
   *                             Germany region. - &#x60;&#x60;IND&#x60;&#x60; :
   *                             Data center for the India region. -
   *                             &#x60;&#x60;JPN&#x60;&#x60; : Data center for the
   *                             Japan region. - &#x60;&#x60;GBR&#x60;&#x60; :
   *                             Data center for the United Kingdom region.
   *                             **Note:** Beta features are subject to change.
   *                             Please do not use in production environments.
   *                             (required)
   * @param createBucketsPayload (required)
   * @return Bucket
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Bucket> createBucket(Region region, CreateBucketsPayload createBucketsPayload, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into createBucket ");

    Object localVarPostBody = createBucketsPayload;

    // verify the required parameter 'region' is set
    if (region == null) {
      throw new OssApiException(400, "Missing the required parameter 'region' when calling createBucket");
    }

    // verify the required parameter 'createBucketsPayload' is set
    if (createBucketsPayload == null) {
      throw new OssApiException(400, "Missing the required parameter 'createBucketsPayload' when calling createBucket");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets";

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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("createBucket Request completed successfully with status " + statusCode);
      Bucket bucket = deserialize(entity, new TypeReference<Bucket>() {
      });
      return new ApiResponse<Bucket>(statusCode, response.getHeaders(), bucket);
    } catch (OssApiException e) {
      this.logger.error("createBucket Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createBucket Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Delete Bucket
   * Deletes the specified bucket. Only the application that owns the bucket can
   * call this operation. All other applications that call this operation will
   * receive a &quot;403 Forbidden&quot; error.
   * 
   * The initial processing of a bucket deletion request can be time-consuming.
   * So, we recommend only deleting buckets containing a few objects, like those
   * typically used for acceptance testing and prototyping.
   * 
   * **Note:** Bucket keys will not be immediately available for reuse.
   * 
   * @param bucketKey The bucket key of the bucket to delete. (required)
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Void> deleteBucket(String bucketKey, String accessToken) throws OssApiException {
    this.logger.info("Entered into deleteBucket ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling deleteBucket");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("deleteBucket Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (OssApiException e) {
      this.logger.error("deleteBucket Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteBucket Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Get Bucket Details
   * Returns detailed information about the specified bucket.
   * 
   * **Note:** Only the application that owns the bucket can call this operation.
   * All other applications that call this operation will receive a &quot;403
   * Forbidden&quot; error.
   * 
   * @param bucketKey The bucket key of the bucket to query. (required)
   * @return Bucket
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Bucket> getBucketDetails(String bucketKey, String accessToken) throws OssApiException {
    this.logger.info("Entered into getBucketDetails ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling getBucketDetails");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/details"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getBucketDetails Request completed successfully with status " + statusCode);
      Bucket bucket = deserialize(entity, new TypeReference<Bucket>() {
      });
      return new ApiResponse<Bucket>(statusCode, response.getHeaders(), bucket);
    } catch (OssApiException e) {
      this.logger.error("getBucketDetails Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getBucketDetails Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * List Buckets
   * Returns a list of buckets owned by the application.
   * 
   * @param region  Specifies where the bucket containing the object is stored.
   *                Possible values are: - &#x60;&#x60;US&#x60;&#x60; : (Default)
   *                Data center for the US region. - &#x60;&#x60;EMEA&#x60;&#x60;
   *                : Data center for the European Union, Middle East, and Africa.
   *                - &#x60;&#x60;AUS&#x60;&#x60; : (Beta) Data center for
   *                Australia. - &#x60;&#x60;CAN&#x60;&#x60; : Data center for the
   *                Canada region. - &#x60;&#x60;DEU&#x60;&#x60; : Data center for
   *                the Germany region. - &#x60;&#x60;IND&#x60;&#x60; : Data
   *                center for the India region. - &#x60;&#x60;JPN&#x60;&#x60; :
   *                Data center for the Japan region. -
   *                &#x60;&#x60;GBR&#x60;&#x60; : Data center for the United
   *                Kingdom region. **Note:** Beta features are subject to change.
   *                Please do not use in production environments. (optional)
   * @param limit   The number of items you want per page. Acceptable values
   *                &#x3D; 1-100. Default &#x3D; 10. (optional, default to 10)
   * @param startAt The ID of the last item that was returned in the previous
   *                result set. It enables the system to return subsequent items
   *                starting from the next one after the specified ID. (optional)
   * @return Buckets
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Buckets> getBuckets(Region region, Integer limit, String startAt, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into getBuckets ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/oss/v2/buckets";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }
    if (limit != null) {
      localVarQueryParams.put("limit", parameterToString(limit));
    }
    if (startAt != null) {
      localVarQueryParams.put("startAt", parameterToString(startAt));
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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getBuckets Request completed successfully with status " + statusCode);
      Buckets buckets = deserialize(entity, new TypeReference<Buckets>() {
      });
      return new ApiResponse<Buckets>(statusCode, response.getHeaders(), buckets);
    } catch (OssApiException e) {
      this.logger.error("getBuckets Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getBuckets Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

}
