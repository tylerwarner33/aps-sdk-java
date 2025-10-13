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

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.oss.BaseApi;
import com.autodesk.aps.oss.OssApiException;
import com.autodesk.aps.oss.model.Access;
import com.autodesk.aps.oss.model.BatchcompleteuploadObject;
import com.autodesk.aps.oss.model.BatchcompleteuploadResponse;
import com.autodesk.aps.oss.model.Batchsigneds3downloadObject;
import com.autodesk.aps.oss.model.Batchsigneds3downloadResponse;
import com.autodesk.aps.oss.model.Batchsigneds3uploadObject;
import com.autodesk.aps.oss.model.Batchsigneds3uploadResponse;
import com.autodesk.aps.oss.model.BucketObjects;
import com.autodesk.aps.oss.model.Completes3uploadBody;
import com.autodesk.aps.oss.model.CreateObjectSigned;
import com.autodesk.aps.oss.model.CreateSignedResource;
import com.autodesk.aps.oss.model.ObjectDetails;
import com.autodesk.aps.oss.model.ObjectFullDetails;
import com.autodesk.aps.oss.model.Region;
import com.autodesk.aps.oss.model.Signeds3downloadResponse;
import com.autodesk.aps.oss.model.Signeds3uploadResponse;
import com.autodesk.aps.oss.model.With;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class ObjectsApi extends BaseApi {

  public ObjectsApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Complete Batch Upload to S3 Signed URLs
   * Requests OSS to start reconstituting the set of objects that were uploaded
   * using signed S3 upload URLs. You must call this operation only after all the
   * objects have been uploaded.
   * 
   * You can specify up to 25 objects in this operation.
   * 
   * @param bucketKey                 The bucket key of the bucket that contains
   *                                  the objects you are operating on. (required)
   * @param batchcompleteuploadObject An array of objects, each of which
   *                                  represents an upload to complete. (optional)
   * @return BatchcompleteuploadResponse
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<BatchcompleteuploadResponse> batchCompleteUpload(String bucketKey,
      BatchcompleteuploadObject batchcompleteuploadObject, String accessToken) throws OssApiException {
    this.logger.info("Entered into batchCompleteUpload ");

    Object localVarPostBody = batchcompleteuploadObject;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling batchCompleteUpload");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/batchcompleteupload"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
      this.logger.info("batchCompleteUpload Request completed successfully with status " + statusCode);
      BatchcompleteuploadResponse batchcompleteuploadResponse = deserialize(entity,
          new TypeReference<BatchcompleteuploadResponse>() {
          });
      return new ApiResponse<BatchcompleteuploadResponse>(statusCode, response.getHeaders(),
          batchcompleteuploadResponse);
    } catch (OssApiException e) {
      this.logger.error("batchCompleteUpload Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("batchCompleteUpload Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Batch Generate Signed S3 Download URLs
   * Creates and returns signed URLs to download a set of objects directly from
   * S3. These signed URLs expire in 2 minutes by default, but you can change this
   * duration if needed. You must start download the objects before the signed
   * URLs expire. The download itself can take longer.
   * 
   * Only the application that owns the bucket can call this operation. All other
   * applications that call this operation will receive a &quot;403
   * Forbidden&quot; error.
   * 
   * @param bucketKey                   The bucket key of the bucket that contains
   *                                    the objects you are operating on.
   *                                    (required)
   * @param batchsigneds3downloadObject An array of objects representing each
   *                                    request for a signed download URL.
   *                                    (required)
   * @param publicResourceFallback      Specifies how to return the signed URLs,
   *                                    in case the object was uploaded in chunks,
   *                                    and assembling of chunks is not yet
   *                                    complete. - &#x60;&#x60;true&#x60;&#x60; :
   *                                    Return a single signed OSS URL. -
   *                                    &#x60;&#x60;false&#x60;&#x60; : (Default)
   *                                    Return multiple signed S3 URLs, where each
   *                                    URL points to a chunk. (optional)
   * @param minutesExpiration           The time window (in minutes) the signed
   *                                    URL will remain usable. Acceptable values
   *                                    &#x3D; 1-60 minutes. Default &#x3D; 2
   *                                    minutes. **Tip:** Use the smallest
   *                                    possible time window to minimize exposure
   *                                    of the signed URL. (optional)
   * @return Batchsigneds3downloadResponse
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Batchsigneds3downloadResponse> batchSignedS3Download(String bucketKey,
      Batchsigneds3downloadObject batchsigneds3downloadObject, Boolean publicResourceFallback,
      Integer minutesExpiration, String accessToken) throws OssApiException {
    this.logger.info("Entered into batchSignedS3Download ");

    Object localVarPostBody = batchsigneds3downloadObject;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling batchSignedS3Download");
    }

    // verify the required parameter 'batchsigneds3downloadObject' is set
    if (batchsigneds3downloadObject == null) {
      throw new OssApiException(400,
          "Missing the required parameter 'batchsigneds3downloadObject' when calling batchSignedS3Download");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/batchsigneds3download"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (publicResourceFallback != null) {
      localVarQueryParams.put("public-resource-fallback", parameterToString(publicResourceFallback));
    }
    if (minutesExpiration != null) {
      localVarQueryParams.put("minutesExpiration", parameterToString(minutesExpiration));
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
      this.logger.info("batchSignedS3Download Request completed successfully with status " + statusCode);
      Batchsigneds3downloadResponse batchsigneds3downloadResponse = deserialize(entity,
          new TypeReference<Batchsigneds3downloadResponse>() {
          });
      return new ApiResponse<Batchsigneds3downloadResponse>(statusCode, response.getHeaders(),
          batchsigneds3downloadResponse);
    } catch (OssApiException e) {
      this.logger.error("batchSignedS3Download Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("batchSignedS3Download Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Batch Generate Signed S3 Upload URLs
   * Creates and returns signed URLs to upload a set of objects directly to S3.
   * These signed URLs expire in 2 minutes by default, but you can change this
   * duration if needed. You must start uploading the objects before the signed
   * URLs expire. The upload itself can take longer.
   * 
   * Only the application that owns the bucket can call this operation. All other
   * applications that call this operation will receive a &quot;403
   * Forbidden&quot; error.
   * 
   * If required, you can request an array of signed URLs for each object, which
   * lets you upload the objects in chunks. Once you upload all chunks you must
   * call the [Complete Batch Upload to S3 Signed
   * URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-batchcompleteupload-POST/)
   * operation to indicate completion. This instructs OSS to assemble the chunks
   * and reconstitute the object on OSS. You must call this operation even if you
   * requested a single signed URL for an object.
   * 
   * If an upload fails after the validity period of a signed URL has elapsed, you
   * can call this operation again to obtain fresh signed URLs. However, you must
   * use the same &#x60;&#x60;uploadKey&#x60;&#x60; that was returned when you
   * originally called this operation.
   * 
   * @param bucketKey                 The bucket key of the bucket that contains
   *                                  the objects you are operating on. (required)
   * @param useAcceleration           &#x60;&#x60;true&#x60;&#x60; : (Default)
   *                                  Generates a faster S3 signed URL using
   *                                  Transfer Acceleration.
   *                                  &#x60;&#x60;false&#x60;&#x60;: Generates a
   *                                  standard S3 signed URL. (optional)
   * @param minutesExpiration         The time window (in minutes) the signed URL
   *                                  will remain usable. Acceptable values &#x3D;
   *                                  1-60 minutes. Default &#x3D; 2 minutes.
   *                                  **Tip:** Use the smallest possible time
   *                                  window to minimize exposure of the signed
   *                                  URL. (optional)
   * @param batchsigneds3uploadObject An array of objects representing each
   *                                  request for a signed upload URL. (optional)
   * @return Batchsigneds3uploadResponse
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Batchsigneds3uploadResponse> batchSignedS3Upload(String bucketKey, Boolean useAcceleration,
      Integer minutesExpiration, Batchsigneds3uploadObject batchsigneds3uploadObject, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into batchSignedS3Upload ");

    Object localVarPostBody = batchsigneds3uploadObject;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling batchSignedS3Upload");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/batchsigneds3upload"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (useAcceleration != null) {
      localVarQueryParams.put("useAcceleration", parameterToString(useAcceleration));
    }
    if (minutesExpiration != null) {
      localVarQueryParams.put("minutesExpiration", parameterToString(minutesExpiration));
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
      this.logger.info("batchSignedS3Upload Request completed successfully with status " + statusCode);
      Batchsigneds3uploadResponse batchsigneds3uploadResponse = deserialize(entity,
          new TypeReference<Batchsigneds3uploadResponse>() {
          });
      return new ApiResponse<Batchsigneds3uploadResponse>(statusCode, response.getHeaders(),
          batchsigneds3uploadResponse);
    } catch (OssApiException e) {
      this.logger.error("batchSignedS3Upload Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("batchSignedS3Upload Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Complete Upload to S3 Signed URL
   * Requests OSS to assemble and reconstitute the object that was uploaded using
   * signed S3 upload URL. You must call this operation only after all
   * parts/chunks of the object has been uploaded.
   * 
   * @param bucketKey                  The bucket key of the bucket that contains
   *                                   the objects you are operating on.
   *                                   (required)
   * @param objectKey                  The URL-encoded human friendly name of the
   *                                   object. (required)
   * @param contentType                Must be
   *                                   &#x60;&#x60;application/json&#x60;&#x60;.
   *                                   (required)
   * @param completes3uploadBody       (required)
   * @param xAdsMetaContentType        The Content-Type value for the uploaded
   *                                   object to record within OSS. (optional)
   * @param xAdsMetaContentDisposition The Content-Disposition value for the
   *                                   uploaded object to record within OSS.
   *                                   (optional)
   * @param xAdsMetaContentEncoding    The Content-Encoding value for the uploaded
   *                                   object to record within OSS. (optional)
   * @param xAdsMetaCacheControl       The Cache-Control value for the uploaded
   *                                   object to record within OSS. (optional)
   * @param xAdsUserDefinedMetadata    Custom metadata to be stored with the
   *                                   object, which can be retrieved later on
   *                                   download or when retrieving object details.
   *                                   Must be a JSON object that is less than 100
   *                                   bytes. (optional)
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<ObjectDetails> completeSignedS3Upload(String bucketKey, String objectKey, String contentType,
      Completes3uploadBody completes3uploadBody, String xAdsMetaContentType, String xAdsMetaContentDisposition,
      String xAdsMetaContentEncoding, String xAdsMetaCacheControl, String xAdsUserDefinedMetadata, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into completeSignedS3Upload ");

    Object localVarPostBody = completes3uploadBody;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling completeSignedS3Upload");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling completeSignedS3Upload");
    }

    // verify the required parameter 'contentType' is set
    if (contentType == null) {
      throw new OssApiException(400,
          "Missing the required parameter 'contentType' when calling completeSignedS3Upload");
    }

    // verify the required parameter 'completes3uploadBody' is set
    if (completes3uploadBody == null) {
      throw new OssApiException(400,
          "Missing the required parameter 'completes3uploadBody' when calling completeSignedS3Upload");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}/signeds3upload"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (contentType != null) {
      localVarHeaderParams.put("Content-Type", parameterToString(contentType));
    }
    if (xAdsMetaContentType != null) {
      localVarHeaderParams.put("x-ads-meta-Content-Type", parameterToString(xAdsMetaContentType));
    }
    if (xAdsMetaContentDisposition != null) {
      localVarHeaderParams.put("x-ads-meta-Content-Disposition", parameterToString(xAdsMetaContentDisposition));
    }
    if (xAdsMetaContentEncoding != null) {
      localVarHeaderParams.put("x-ads-meta-Content-Encoding", parameterToString(xAdsMetaContentEncoding));
    }
    if (xAdsMetaCacheControl != null) {
      localVarHeaderParams.put("x-ads-meta-Cache-Control", parameterToString(xAdsMetaCacheControl));
    }
    if (xAdsUserDefinedMetadata != null) {
      localVarHeaderParams.put("x-ads-user-defined-metadata", parameterToString(xAdsUserDefinedMetadata));
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
      this.logger.info("completeSignedS3Upload Request completed successfully with status " + statusCode);
      ObjectDetails objectDetails = deserialize(entity, new TypeReference<ObjectDetails>() {
      });
      this.logger.info(objectDetails.toString());
      return new ApiResponse<ObjectDetails>(statusCode, response.getHeaders(), objectDetails);
    } catch (OssApiException e) {
      this.logger.error("completeSignedS3Upload Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("completeSignedS3Upload Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Copy Object
   * Creates a copy of an object within the bucket.
   * 
   * @param bucketKey The bucket key of the bucket that contains the objects you
   *                  are operating on. (required)
   * @param objectKey The URL-encoded human friendly name of the object.
   *                  (required)
   * @param newObjKey A URL-encoded human friendly name to identify the copied
   *                  object. (required)
   * @return ObjectDetails
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<ObjectDetails> copyTo(String bucketKey, String objectKey, String newObjKey, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into copyTo ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling copyTo");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling copyTo");
    }

    // verify the required parameter 'newObjKey' is set
    if (newObjKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'newObjKey' when calling copyTo");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}/copyto/{newObjKey}"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey))
        .replaceAll("\\{" + "newObjKey" + "\\}", parameterToString(newObjKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("copyTo Request completed successfully with status " + statusCode);
      ObjectDetails objectDetails = deserialize(entity, new TypeReference<ObjectDetails>() {
      });
      return new ApiResponse<ObjectDetails>(statusCode, response.getHeaders(), objectDetails);
    } catch (OssApiException e) {
      this.logger.error("copyTo Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("copyTo Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Generate OSS Signed URL
   * Generates a signed URL that can be used to download or upload an object
   * within the specified expiration time. If the object the signed URL points to
   * is deleted or expires before the signed URL expires, the signed URL will no
   * longer be valid.
   * 
   * In addition to this operation that generates OSS signed URLs, OSS provides
   * operations to generate S3 signed URLs. S3 signed URLs allow direct
   * upload/download from S3 but are restricted to bucket owners. OSS signed URLs
   * also allow upload/download and can be configured for access by other
   * applications, making them suitable for sharing objects across applications.
   * 
   * Only the application that owns the bucket containing the object can call this
   * operation.
   * 
   * @param bucketKey            The bucket key of the bucket that contains the
   *                             objects you are operating on. (required)
   * @param objectKey            The URL-encoded human friendly name of the
   *                             object. (required)
   * @param access               (optional)
   * @param useCdn               &#x60;&#x60;true&#x60;&#x60; : Returns a
   *                             Cloudfront URL to the object instead of an
   *                             Autodesk URL (one that points to a location on
   *                             https://developer.api.autodesk.com). Applications
   *                             can interact with the Cloudfront URL exactly like
   *                             with any classic public resource in OSS. They can
   *                             use GET requests to download objects or PUT
   *                             requests to upload objects.
   *                             &#x60;&#x60;false&#x60;&#x60; : (Default) Returns
   *                             an Autodesk URL (one that points to a location on
   *                             https://developer.api.autodesk.com) to the
   *                             object. (optional)
   * @param createSignedResource (optional)
   * @return CreateObjectSigned
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<CreateObjectSigned> createSignedResource(String bucketKey, String objectKey, Access access,
      Boolean useCdn, CreateSignedResource createSignedResource, String accessToken) throws OssApiException {
    this.logger.info("Entered into createSignedResource ");

    Object localVarPostBody = createSignedResource;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling createSignedResource");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling createSignedResource");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}/signed"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (access != null) {
      localVarQueryParams.put("access", parameterToString(access));
    }
    if (useCdn != null) {
      localVarQueryParams.put("useCdn", parameterToString(useCdn));
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
      this.logger.info("createSignedResource Request completed successfully with status " + statusCode);
      CreateObjectSigned createObjectSigned = deserialize(entity, new TypeReference<CreateObjectSigned>() {
      });
      return new ApiResponse<CreateObjectSigned>(statusCode, response.getHeaders(), createObjectSigned);
    } catch (OssApiException e) {
      this.logger.error("createSignedResource Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createSignedResource Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Delete Object
   * Deletes an object from the bucket.
   * 
   * @param bucketKey The bucket key of the bucket that contains the objects you
   *                  are operating on. (required)
   * @param objectKey The URL-encoded human friendly name of the object.
   *                  (required)
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Void> deleteObject(String bucketKey, String objectKey, String accessToken) throws OssApiException {
    this.logger.info("Entered into deleteObject ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling deleteObject");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling deleteObject");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey));

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
      this.logger.info("deleteObject Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (OssApiException e) {
      this.logger.error("deleteObject Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteObject Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Delete Object Using Signed URL
   * Delete an object using an OSS signed URL to access it.
   * 
   * Only applications that own the bucket containing the object can call this
   * operation.
   * 
   * @param hash   The ID component of the signed URL. **Note:** The signed
   *               URL returned by [Generate OSS Signed
   *               URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
   *               contains &#x60;&#x60;hash&#x60;&#x60; as a URI parameter.
   *               (required)
   * @param region Specifies where the bucket containing the object is stored.
   *               Possible values are: - &#x60;&#x60;US&#x60;&#x60; :
   *               (Default) Data center for the US region. -
   *               &#x60;&#x60;EMEA&#x60;&#x60; : Data center for the European
   *               Union, Middle East, and Africa. -
   *               &#x60;&#x60;AUS&#x60;&#x60; : (Beta) Data center for
   *               Australia. - &#x60;&#x60;CAN&#x60;&#x60; : Data center for
   *               the Canada region. - &#x60;&#x60;DEU&#x60;&#x60; : Data
   *               center for the Germany region. -
   *               &#x60;&#x60;IND&#x60;&#x60; : Data center for the India
   *               region. - &#x60;&#x60;JPN&#x60;&#x60; : Data center for the
   *               Japan region. - &#x60;&#x60;GBR&#x60;&#x60; : Data center
   *               for the United Kingdom region. **Note:** Beta features are
   *               subject to change. Please do not use in production
   *               environments. (optional)
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSignedResource(String hash, Region region, String accessToken) throws OssApiException {
    this.logger.info("Entered into deleteSignedResource ");

    Object localVarPostBody = null;

    // verify the required parameter 'hash' is set
    if (hash == null) {
      throw new OssApiException(400, "Missing the required parameter 'hash' when calling deleteSignedResource");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/signedresources/{hash}"
        .replaceAll("\\{" + "hash" + "\\}", parameterToString(hash));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("deleteSignedResource Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (OssApiException e) {
      this.logger.error("deleteSignedResource Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteSignedResource Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Get Object Details
   * Returns detailed information about the specified object.
   * 
   * @param bucketKey       The bucket key of the bucket that contains the objects
   *                        you are operating on. (required)
   * @param objectKey       The URL-encoded human friendly name of the object.
   *                        (required)
   * @param ifModifiedSince A timestamp in the HTTP date format (Mon, DD Month
   *                        YYYY HH:MM:SS GMT). The requested data is returned
   *                        only if the object has been modified since the
   *                        specified timestamp. If not, a 304 (Not Modified) HTTP
   *                        status is returned. (optional)
   * @param with            (optional)
   * @return ObjectFullDetails
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<ObjectFullDetails> getObjectDetails(String bucketKey, String objectKey,
      LocalDateTime ifModifiedSince,
      With with, String accessToken) throws OssApiException {
    this.logger.info("Entered into getObjectDetails ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling getObjectDetails");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling getObjectDetails");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}/details"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (with != null) {
      localVarQueryParams.put("with", parameterToString(with));
    }

    if (ifModifiedSince != null) {
      localVarHeaderParams.put("If-Modified-Since", parameterToString(ifModifiedSince));
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
        String responseString = entity == null ? response.getReasonPhrase()
            : EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getObjectDetails Request completed successfully with status " + statusCode);
      ObjectFullDetails objectFullDetails = deserialize(entity, new TypeReference<ObjectFullDetails>() {
      });
      return new ApiResponse<ObjectFullDetails>(statusCode, response.getHeaders(), objectFullDetails);
    } catch (OssApiException e) {
      this.logger.error("getObjectDetails Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getObjectDetails Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * List Objects
   * Returns a list objects in the specified bucket.
   * 
   * Only the application that owns the bucket can call this operation. All other
   * applications that call this operation will receive a &quot;403
   * Forbidden&quot; error.
   * 
   * @param bucketKey  The bucket key of the bucket that contains the objects you
   *                   are operating on. (required)
   * @param limit      The number of items you want per page. Acceptable values
   *                   &#x3D; 1-100. Default &#x3D; 10. (optional, default to 10)
   * @param beginsWith Filters the results by the value you specify. Only the
   *                   objects with their &#x60;&#x60;objectKey&#x60;&#x60;
   *                   beginning with the specified string are returned.
   *                   (optional)
   * @param startAt    The ID of the last item that was returned in the previous
   *                   result set. It enables the system to return subsequent
   *                   items starting from the next one after the specified ID.
   *                   (optional)
   * @return BucketObjects
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<BucketObjects> getObjects(String bucketKey, Integer limit, String beginsWith, String startAt,
      String accessToken) throws OssApiException {
    this.logger.info("Entered into getObjects ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling getObjects");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (limit != null) {
      localVarQueryParams.put("limit", parameterToString(limit));
    }
    if (beginsWith != null) {
      localVarQueryParams.put("beginsWith", parameterToString(beginsWith));
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
      this.logger.info("getObjects Request completed successfully with status " + statusCode);
      BucketObjects bucketObjects = deserialize(entity, new TypeReference<BucketObjects>() {
      });
      return new ApiResponse<BucketObjects>(statusCode, response.getHeaders(), bucketObjects);
    } catch (OssApiException e) {
      this.logger.error("getObjects Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getObjects Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Download Object Using Signed URL
   * Downloads an object using an OSS signed URL.
   * 
   * **Note:** The signed URL returned by [Generate OSS Signed
   * URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/) contains the
   * &#x60;&#x60;hash&#x60;&#x60; URI parameter as well.
   * 
   * @param hash                       The ID component of the signed URL.
   *                                   **Note:** The signed URL returned by
   *                                   [Generate OSS Signed
   *                                   URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
   *                                   contains &#x60;&#x60;hash&#x60;&#x60; as a
   *                                   URI parameter. (required)
   * @param range                      The byte range to download, specified in
   *                                   the form
   *                                   &#x60;&#x60;bytes&#x3D;&lt;START_BYTE&gt;-&lt;END_BYTE&gt;&#x60;&#x60;.
   *                                   (optional)
   * @param ifNoneMatch                The last known ETag value of the object.
   *                                   OSS returns the requested data only if the
   *                                   &#x60;&#x60;If-None-Match&#x60;&#x60;
   *                                   header differs from the ETag value of the
   *                                   object on OSS, which indicates that the
   *                                   object on OSS is newer. If not, it returns
   *                                   a 304 \&quot;Not Modified\&quot; HTTP
   *                                   status. (optional)
   * @param ifModifiedSince            A timestamp in the HTTP date format (Mon,
   *                                   DD Month YYYY HH:MM:SS GMT). The requested
   *                                   data is returned only if the object has
   *                                   been modified since the specified
   *                                   timestamp. If not, a 304 (Not Modified)
   *                                   HTTP status is returned. (optional)
   * @param acceptEncoding             The compression format your prefer to
   *                                   receive the data. Possible values are: -
   *                                   &#x60;&#x60;gzip&#x60;&#x60; - Use the gzip
   *                                   format **Note:** You cannot use
   *                                   &#x60;&#x60;Accept-Encoding:gzip&#x60;&#x60;
   *                                   with a Range header containing an end byte
   *                                   range. OSS will not honor the End byte
   *                                   range if &#x60;&#x60;Accept-Encoding:
   *                                   gzip&#x60;&#x60; header is used. (optional)
   * @param region                     Specifies where the bucket containing the
   *                                   object is stored. Possible values are: -
   *                                   &#x60;&#x60;US&#x60;&#x60; : (Default) Data
   *                                   center for the US region. -
   *                                   &#x60;&#x60;EMEA&#x60;&#x60; : Data center
   *                                   for the European Union, Middle East, and
   *                                   Africa. - &#x60;&#x60;AUS&#x60;&#x60; :
   *                                   (Beta) Data center for Australia. -
   *                                   &#x60;&#x60;CAN&#x60;&#x60; : Data center
   *                                   for the Canada region. -
   *                                   &#x60;&#x60;DEU&#x60;&#x60; : Data center
   *                                   for the Germany region. -
   *                                   &#x60;&#x60;IND&#x60;&#x60; : Data center
   *                                   for the India region. -
   *                                   &#x60;&#x60;JPN&#x60;&#x60; : Data center
   *                                   for the Japan region. -
   *                                   &#x60;&#x60;GBR&#x60;&#x60; : Data center
   *                                   for the United Kingdom region. **Note:**
   *                                   Beta features are subject to change. Please
   *                                   do not use in production environments.
   *                                   (optional)
   * @param responseContentDisposition The value of the Content-Disposition header
   *                                   you want to receive when you download the
   *                                   object using the signed URL. If you do not
   *                                   specify a value, the Content-Disposition
   *                                   header defaults to the value stored with
   *                                   OSS. (optional)
   * @param responseContentType        The value of the Content-Type header you
   *                                   want to receive when you download the
   *                                   object using the signed URL. If you do not
   *                                   specify a value, the Content-Type header
   *                                   defaults to the value stored with OSS.
   *                                   (optional)
   * @return File
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<File> getSignedResource(String hash, String range, String ifNoneMatch,
      LocalDateTime ifModifiedSince,
      String acceptEncoding, Region region, String responseContentDisposition, String responseContentType,
      String accessToken) throws OssApiException {
    this.logger.info("Entered into getSignedResource ");

    Object localVarPostBody = null;

    // verify the required parameter 'hash' is set
    if (hash == null) {
      throw new OssApiException(400, "Missing the required parameter 'hash' when calling getSignedResource");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/signedresources/{hash}"
        .replaceAll("\\{" + "hash" + "\\}", parameterToString(hash));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (region != null) {
      localVarQueryParams.put("region", parameterToString(region));
    }
    if (responseContentDisposition != null) {
      localVarQueryParams.put("response-content-disposition", parameterToString(responseContentDisposition));
    }
    if (responseContentType != null) {
      localVarQueryParams.put("response-content-type", parameterToString(responseContentType));
    }

    if (range != null) {
      localVarHeaderParams.put("Range", parameterToString(range));
    }
    if (ifNoneMatch != null) {
      localVarHeaderParams.put("If-None-Match", parameterToString(ifNoneMatch));
    }
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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getSignedResource Request completed successfully with status " + statusCode);
      File _file = deserialize(entity, new TypeReference<File>() {
      });
      return new ApiResponse<File>(statusCode, response.getHeaders(), _file);
    } catch (OssApiException e) {
      this.logger.error("getSignedResource Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getSignedResource Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Generate Signed S3 Download URL
   * Gets a signed URL to download an object directly from S3, bypassing OSS
   * servers. This signed URL expires in 2 minutes by default, but you can change
   * this duration if needed. You must start the download before the signed URL
   * expires. The download itself can take longer. If the download fails after the
   * validity period of the signed URL has elapsed, you can call this operation
   * again to obtain a fresh signed URL.
   * 
   * Only applications that have read access to the object can call this
   * operation.
   * 
   * You can use range headers with the signed download URL to download the object
   * in chunks. This ability lets you download chunks in parallel, which can
   * result in faster downloads.
   * 
   * If the object you want to download was uploaded in chunks and is still
   * assembling on OSS, you will receive multiple S3 URLs instead of just one.
   * Each URL will point to a chunk. If you prefer to receive a single URL, set
   * the &#x60;&#x60;public-resource-fallback&#x60;&#x60; query parameter to
   * &#x60;&#x60;true&#x60;&#x60;. This setting will make OSS fallback to
   * returning a single signed OSS URL, if assembling is still in progress.
   * 
   * In addition to this operation that generates S3 signed URLs, OSS provides an
   * operation to generate OSS signed URLs. S3 signed URLs allow direct
   * upload/download from S3 but are restricted to bucket owners. OSS signed URLs
   * also allow upload/download and can be configured for access by other
   * applications, making them suitable for sharing objects across applications.
   * 
   * @param bucketKey                  The bucket key of the bucket that contains
   *                                   the objects you are operating on.
   *                                   (required)
   * @param objectKey                  The URL-encoded human friendly name of the
   *                                   object. (required)
   * @param ifNoneMatch                The last known ETag value of the object.
   *                                   OSS returns the signed URL only if the
   *                                   &#x60;&#x60;If-None-Match&#x60;&#x60;
   *                                   header differs from the ETag value of the
   *                                   object on S3. If not, it returns a 304
   *                                   \&quot;Not Modified\&quot; HTTP status.
   *                                   (optional)
   * @param ifModifiedSince            A timestamp in the HTTP date format (Mon,
   *                                   DD Month YYYY HH:MM:SS GMT). The signed URL
   *                                   is returned only if the object has been
   *                                   modified since the specified timestamp. If
   *                                   not, a 304 (Not Modified) HTTP status is
   *                                   returned. (optional)
   * @param responseContentType        The value of the Content-Type header you
   *                                   want to receive when you download the
   *                                   object using the signed URL. If you do not
   *                                   specify a value, the Content-Type header
   *                                   defaults to the value stored with OSS.
   *                                   (optional)
   * @param responseContentDisposition The value of the Content-Disposition header
   *                                   you want to receive when you download the
   *                                   object using the signed URL. If you do not
   *                                   specify a value, the Content-Disposition
   *                                   header defaults to the value stored with
   *                                   OSS. (optional)
   * @param responseCacheControl       The value of the Cache-Control header you
   *                                   want to receive when you download the
   *                                   object using the signed URL. If you do not
   *                                   specify a value, the Cache-Control header
   *                                   defaults to the value stored with OSS.
   *                                   (optional)
   * @param publicResourceFallback     Specifies how to return the signed URLs, in
   *                                   case the object was uploaded in chunks, and
   *                                   assembling of chunks is not yet complete. -
   *                                   &#x60;&#x60;true&#x60;&#x60; : Return a
   *                                   single signed OSS URL. -
   *                                   &#x60;&#x60;false&#x60;&#x60; : (Default)
   *                                   Return multiple signed S3 URLs, where each
   *                                   URL points to a chunk. (optional)
   * @param minutesExpiration          The time window (in minutes) the signed URL
   *                                   will remain usable. Acceptable values
   *                                   &#x3D; 1-60 minutes. Default &#x3D; 2
   *                                   minutes. **Tip:** Use the smallest possible
   *                                   time window to minimize exposure of the
   *                                   signed URL. (optional)
   * @param useCdn                     &#x60;&#x60;true&#x60;&#x60; : Returns a
   *                                   URL that points to a CloudFront edge
   *                                   location. &#x60;&#x60;false&#x60;&#x60; :
   *                                   (Default) Returns a URL that points
   *                                   directly to the S3 object. (optional)
   * @return Signeds3downloadResponse
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Signeds3downloadResponse> signedS3Download(String bucketKey, String objectKey, String ifNoneMatch,
      LocalDateTime ifModifiedSince, String responseContentType, String responseContentDisposition,
      String responseCacheControl, Boolean publicResourceFallback, Integer minutesExpiration, Boolean useCdn,
      String accessToken) throws OssApiException {
    this.logger.info("Entered into signedS3Download ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling signedS3Download");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling signedS3Download");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}/signeds3download"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (responseContentType != null) {
      localVarQueryParams.put("response-content-type", parameterToString(responseContentType));
    }
    if (responseContentDisposition != null) {
      localVarQueryParams.put("response-content-disposition", parameterToString(responseContentDisposition));
    }
    if (responseCacheControl != null) {
      localVarQueryParams.put("response-cache-control", parameterToString(responseCacheControl));
    }
    if (publicResourceFallback != null) {
      localVarQueryParams.put("public-resource-fallback", parameterToString(publicResourceFallback));
    }
    if (minutesExpiration != null) {
      localVarQueryParams.put("minutesExpiration", parameterToString(minutesExpiration));
    }
    if (useCdn != null) {
      localVarQueryParams.put("useCdn", parameterToString(useCdn));
    }

    if (ifNoneMatch != null) {
      localVarHeaderParams.put("If-None-Match", parameterToString(ifNoneMatch));
    }
    if (ifModifiedSince != null) {
      localVarHeaderParams.put("If-Modified-Since", parameterToString(ifModifiedSince));
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
      this.logger.info("signedS3Download Request completed successfully with status " + statusCode);
      Signeds3downloadResponse signeds3downloadResponse = deserialize(entity,
          new TypeReference<Signeds3downloadResponse>() {
          });
      return new ApiResponse<Signeds3downloadResponse>(statusCode, response.getHeaders(), signeds3downloadResponse);
    } catch (OssApiException e) {
      this.logger.error("signedS3Download Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("signedS3Download Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Generate Signed S3 Upload URL
   * Gets a signed URL to upload an object directly to S3, bypassing OSS servers.
   * You can also request an array of signed URLs which lets you upload an object
   * in chunks.
   * 
   * This signed URL expires in 2 minutes by default, but you can change this
   * duration if needed. You must start the upload before the signed URL expires.
   * The upload itself can take longer. If the upload fails after the validity
   * period of the signed URL has elapsed, you can call this operation again to
   * obtain a fresh signed URL (or an array of signed URLs as the case may be).
   * However, you must use the same &#x60;&#x60;uploadKey&#x60;&#x60; that was
   * returned when you originally called this operation.
   * 
   * Only applications that own the bucket can call this operation.
   * 
   * **Note:** Once you upload all chunks you must call the [Complete Upload to S3
   * Signed
   * URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/)
   * operation to indicate completion. This instructs OSS to assemble the chunks
   * and reconstitute the object on OSS. You must call this operation even when
   * using a single signed URL.
   * 
   * In addition to this operation that generates S3 signed URLs, OSS provides an
   * operation to generate OSS signed URLs. S3 signed URLs allow direct
   * upload/download from S3 but are restricted to bucket owners. OSS signed URLs
   * also allow upload/download and can be configured for access by other
   * applications, making them suitable for sharing objects across applications.
   * 
   * @param bucketKey         The bucket key of the bucket that contains the
   *                          objects you are operating on. (required)
   * @param objectKey         The URL-encoded human friendly name of the object.
   *                          (required)
   * @param parts             The number of parts you intend to chunk the object
   *                          for uploading. OSS will return that many signed
   *                          URLs, one URL for each chunk. If you do not specify
   *                          a value you&#39;ll get only one URL to upload the
   *                          entire object. (optional)
   * @param firstPart         The index of the first chunk to be uploaded.
   *                          (optional)
   * @param uploadKey         The &#x60;&#x60;uploadKey&#x60;&#x60; of a
   *                          previously-initiated upload, in order to request
   *                          more chunk upload URLs for the same upload. If you
   *                          do not specify a value, OSS will initiate a new
   *                          upload entirely. (optional)
   * @param minutesExpiration The time window (in minutes) the signed URL will
   *                          remain usable. Acceptable values &#x3D; 1-60
   *                          minutes. Default &#x3D; 2 minutes. **Tip:** Use the
   *                          smallest possible time window to minimize exposure
   *                          of the signed URL. (optional)
   * @param useAcceleration   &#x60;&#x60;true&#x60;&#x60; : (Default) Generates a
   *                          faster S3 signed URL using Transfer Acceleration.
   *                          &#x60;&#x60;false&#x60;&#x60;: Generates a standard
   *                          S3 signed URL. (optional)
   * @return Signeds3uploadResponse
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<Signeds3uploadResponse> signedS3Upload(String bucketKey, String objectKey, Integer parts,
      Integer firstPart, String uploadKey, Integer minutesExpiration, Boolean useAcceleration, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into signedS3Upload ");

    Object localVarPostBody = null;

    // verify the required parameter 'bucketKey' is set
    if (bucketKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'bucketKey' when calling signedS3Upload");
    }

    // verify the required parameter 'objectKey' is set
    if (objectKey == null) {
      throw new OssApiException(400, "Missing the required parameter 'objectKey' when calling signedS3Upload");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/buckets/{bucketKey}/objects/{objectKey}/signeds3upload"
        .replaceAll("\\{" + "bucketKey" + "\\}", parameterToString(bucketKey))
        .replaceAll("\\{" + "objectKey" + "\\}", parameterToString(objectKey));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (parts != null) {
      localVarQueryParams.put("parts", parameterToString(parts));
    }
    if (firstPart != null) {
      localVarQueryParams.put("firstPart", parameterToString(firstPart));
    }
    if (uploadKey != null) {
      localVarQueryParams.put("uploadKey", parameterToString(uploadKey));
    }
    if (minutesExpiration != null) {
      localVarQueryParams.put("minutesExpiration", parameterToString(minutesExpiration));
    }
    if (useAcceleration != null) {
      localVarQueryParams.put("useAcceleration", parameterToString(useAcceleration));
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
      this.logger.info("signedS3Upload Request completed successfully with status " + statusCode);
      Signeds3uploadResponse signeds3uploadResponse = deserialize(entity, new TypeReference<Signeds3uploadResponse>() {
      });
      return new ApiResponse<Signeds3uploadResponse>(statusCode, response.getHeaders(), signeds3uploadResponse);
    } catch (OssApiException e) {
      this.logger.error("signedS3Upload Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("signedS3Upload Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Replace Object Using Signed URL
   * Replaces an object that already exists on OSS, using an OSS signed URL.
   * 
   * The signed URL must fulfil the following conditions:
   * 
   * - The signed URL is valid (it has not expired as yet).
   * - It was generated with &#x60;&#x60;write&#x60;&#x60; or
   * &#x60;&#x60;readwrite&#x60;&#x60; for the &#x60;&#x60;access&#x60;&#x60;
   * parameter.
   * 
   * @param hash               The ID component of the signed URL. **Note:** The
   *                           signed URL returned by [Generate OSS Signed
   *                           URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
   *                           contains &#x60;&#x60;hash&#x60;&#x60; as a URI
   *                           parameter. (required)
   * @param contentLength      The size of the data contained in the request body,
   *                           in bytes. (required)
   * @param body               The object to upload. (required)
   * @param contentType        The MIME type of the object to upload; can be any
   *                           type except &#39;multipart/form-data&#39;. This can
   *                           be omitted, but we recommend adding it. (optional)
   * @param contentDisposition The suggested file name to use when this object is
   *                           downloaded as a file. (optional)
   * @param xAdsRegion         Specifies where the bucket containing the object is
   *                           stored. Possible values are: -
   *                           &#x60;&#x60;US&#x60;&#x60; : (Default) Data center
   *                           for the US region. - &#x60;&#x60;EMEA&#x60;&#x60; :
   *                           Data center for the European Union, Middle East,
   *                           and Africa. - &#x60;&#x60;AUS&#x60;&#x60; : (Beta)
   *                           Data center for Australia. -
   *                           &#x60;&#x60;CAN&#x60;&#x60; : Data center for the
   *                           Canada region. - &#x60;&#x60;DEU&#x60;&#x60; : Data
   *                           center for the Germany region. -
   *                           &#x60;&#x60;IND&#x60;&#x60; : Data center for the
   *                           India region. - &#x60;&#x60;JPN&#x60;&#x60; : Data
   *                           center for the Japan region. -
   *                           &#x60;&#x60;GBR&#x60;&#x60; : Data center for the
   *                           United Kingdom region. **Note:** Beta features are
   *                           subject to change. Please do not use in production
   *                           environments. (optional)
   * @param ifMatch            The current value of the
   *                           &#x60;&#x60;sha1&#x60;&#x60; attribute of the
   *                           object you want to replace. OSS checks the
   *                           &#x60;&#x60;If-Match&#x60;&#x60; header against the
   *                           &#x60;&#x60;sha1&#x60;&#x60; attribute of the
   *                           object in OSS. If they match, OSS allows the object
   *                           to be overwritten. Otherwise, it means that the
   *                           object on OSS has been modified since you retrieved
   *                           the &#x60;&#x60;sha1&#x60;&#x60; and the request
   *                           fails. (optional)
   * @return ObjectDetails
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<ObjectDetails> uploadSignedResource(String hash, Integer contentLength, byte[] body,
      String contentType, String contentDisposition, Region xAdsRegion, String ifMatch, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into uploadSignedResource ");

    Object localVarPostBody = body;

    // verify the required parameter 'hash' is set
    if (hash == null) {
      throw new OssApiException(400, "Missing the required parameter 'hash' when calling uploadSignedResource");
    }

    // verify the required parameter 'contentLength' is set
    if (contentLength == null) {
      throw new OssApiException(400,
          "Missing the required parameter 'contentLength' when calling uploadSignedResource");
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new OssApiException(400, "Missing the required parameter 'body' when calling uploadSignedResource");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/signedresources/{hash}"
        .replaceAll("\\{" + "hash" + "\\}", parameterToString(hash));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (contentType != null) {
      localVarHeaderParams.put("Content-Type", parameterToString(contentType));
    }
    if (contentLength != null) {
      localVarHeaderParams.put("Content-Length", parameterToString(contentLength));
    }
    if (contentDisposition != null) {
      localVarHeaderParams.put("Content-Disposition", parameterToString(contentDisposition));
    }
    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
    }
    if (ifMatch != null) {
      localVarHeaderParams.put("If-Match", parameterToString(ifMatch));
    }

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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("uploadSignedResource Request completed successfully with status " + statusCode);
      ObjectDetails objectDetails = deserialize(entity, new TypeReference<ObjectDetails>() {
      });
      return new ApiResponse<ObjectDetails>(statusCode, response.getHeaders(), objectDetails);
    } catch (OssApiException e) {
      this.logger.error("uploadSignedResource Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("uploadSignedResource Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

  /**
   * Upload Object Using Signed URL
   * Performs a resumable upload using an OSS signed URL. Use this operation to
   * upload an object in chunks.
   * 
   * **Note:** The signed URL returned by [Generate OSS Signed
   * URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/) contains the
   * &#x60;&#x60;hash&#x60;&#x60; as a URI parameter.
   * 
   * @param hash               The ID component of the signed URL. **Note:** The
   *                           signed URL returned by [Generate OSS Signed
   *                           URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
   *                           contains &#x60;&#x60;hash&#x60;&#x60; as a URI
   *                           parameter. (required)
   * @param contentRange       The byte range to upload, specified in the form
   *                           &#x60;&#x60;bytes&#x3D;&lt;START_BYTE&gt;-&lt;END_BYTE&gt;&#x60;&#x60;.
   *                           (required)
   * @param sessionId          An ID to uniquely identify the file upload session.
   *                           (required)
   * @param body               The chunk to upload. (required)
   * @param contentType        The MIME type of the object to upload; can be any
   *                           type except &#39;multipart/form-data&#39;. This can
   *                           be omitted, but we recommend adding it. (optional)
   * @param contentDisposition The suggested file name to use when this object is
   *                           downloaded as a file. (optional)
   * @param xAdsRegion         Specifies where the bucket containing the object is
   *                           stored. Possible values are: -
   *                           &#x60;&#x60;US&#x60;&#x60; : (Default) Data center
   *                           for the US region. - &#x60;&#x60;EMEA&#x60;&#x60; :
   *                           Data center for the European Union, Middle East,
   *                           and Africa. - &#x60;&#x60;AUS&#x60;&#x60; : (Beta)
   *                           Data center for Australia. -
   *                           &#x60;&#x60;CAN&#x60;&#x60; : Data center for the
   *                           Canada region. - &#x60;&#x60;DEU&#x60;&#x60; : Data
   *                           center for the Germany region. -
   *                           &#x60;&#x60;IND&#x60;&#x60; : Data center for the
   *                           India region. - &#x60;&#x60;JPN&#x60;&#x60; : Data
   *                           center for the Japan region. -
   *                           &#x60;&#x60;GBR&#x60;&#x60; : Data center for the
   *                           United Kingdom region. **Note:** Beta features are
   *                           subject to change. Please do not use in production
   *                           environments. (optional)
   * @return ObjectDetails
   * @throws OssApiException if fails to make API call
   */
  public ApiResponse<ObjectDetails> uploadSignedResourcesChunk(String hash, String contentRange, String sessionId,
      byte[] body, String contentType, String contentDisposition, Region xAdsRegion, String accessToken)
      throws OssApiException {
    this.logger.info("Entered into uploadSignedResourcesChunk ");

    Object localVarPostBody = body;

    // verify the required parameter 'hash' is set
    if (hash == null) {
      throw new OssApiException(400, "Missing the required parameter 'hash' when calling uploadSignedResourcesChunk");
    }

    // verify the required parameter 'contentRange' is set
    if (contentRange == null) {
      throw new OssApiException(400,
          "Missing the required parameter 'contentRange' when calling uploadSignedResourcesChunk");
    }

    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new OssApiException(400,
          "Missing the required parameter 'sessionId' when calling uploadSignedResourcesChunk");
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new OssApiException(400, "Missing the required parameter 'body' when calling uploadSignedResourcesChunk");
    }

    // create path and map variables
    String localVarPath = "/oss/v2/signedresources/{hash}/resumable"
        .replaceAll("\\{" + "hash" + "\\}", parameterToString(hash));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (contentType != null) {
      localVarHeaderParams.put("Content-Type", parameterToString(contentType));
    }
    if (contentRange != null) {
      localVarHeaderParams.put("Content-Range", parameterToString(contentRange));
    }
    if (contentDisposition != null) {
      localVarHeaderParams.put("Content-Disposition", parameterToString(contentDisposition));
    }
    if (xAdsRegion != null) {
      localVarHeaderParams.put("x-ads-region", parameterToString(xAdsRegion));
    }
    if (sessionId != null) {
      localVarHeaderParams.put("Session-Id", parameterToString(sessionId));
    }

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
        throw new OssApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("uploadSignedResourcesChunk Request completed successfully with status " + statusCode);
      if (entity == null || entity.getContentType() == null) {
        return new ApiResponse<ObjectDetails>(statusCode, response.getHeaders());
      } else {
        ObjectDetails objectDetails = deserialize(entity, new TypeReference<ObjectDetails>() {});
        return new ApiResponse<ObjectDetails>(statusCode, response.getHeaders(), objectDetails);
      }
    } catch (OssApiException e) {
      this.logger.error("uploadSignedResourcesChunk Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("uploadSignedResourcesChunk Request failed with exception: " + e.getMessage());
      throw new OssApiException(e);
    }
  }

}
