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
package com.autodesk.aps.oss;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.autodesk.aps.oss.api.BucketsApi;
import com.autodesk.aps.oss.api.ObjectsApi;
import com.autodesk.aps.oss.model.BatchCompleteUploadOptionalParams;
import com.autodesk.aps.oss.model.BatchSignedS3DownloadOptionalParams;
import com.autodesk.aps.oss.model.BatchSignedS3UploadOptionalParams;
import com.autodesk.aps.oss.model.BatchcompleteuploadResponse;
import com.autodesk.aps.oss.model.Batchsigneds3downloadObject;
import com.autodesk.aps.oss.model.Batchsigneds3downloadResponse;
import com.autodesk.aps.oss.model.Batchsigneds3uploadResponse;
import com.autodesk.aps.oss.model.Bucket;
import com.autodesk.aps.oss.model.BucketObjects;
import com.autodesk.aps.oss.model.Buckets;
import com.autodesk.aps.oss.model.CompleteSignedS3UploadOptionalParams;
import com.autodesk.aps.oss.model.Completes3uploadBody;
import com.autodesk.aps.oss.model.CopyToOptionalParams;
import com.autodesk.aps.oss.model.CreateBucketOptionalParams;
import com.autodesk.aps.oss.model.CreateBucketsPayload;
import com.autodesk.aps.oss.model.CreateObjectSigned;
import com.autodesk.aps.oss.model.CreateSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.DeleteBucketOptionalParams;
import com.autodesk.aps.oss.model.DeleteObjectOptionalParams;
import com.autodesk.aps.oss.model.DeleteSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.DownloadObjectOptionalParams;
import com.autodesk.aps.oss.model.GetBucketDetailsOptionalParams;
import com.autodesk.aps.oss.model.GetBucketsOptionalParams;
import com.autodesk.aps.oss.model.GetObjectDetailsOptionalParams;
import com.autodesk.aps.oss.model.GetObjectsOptionalParams;
import com.autodesk.aps.oss.model.GetSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.ObjectDetails;
import com.autodesk.aps.oss.model.ObjectFullDetails;
import com.autodesk.aps.oss.model.Region;
import com.autodesk.aps.oss.model.SignedS3DownloadOptionalParams;
import com.autodesk.aps.oss.model.SignedS3UploadOptionalParams;
import com.autodesk.aps.oss.model.Signeds3downloadResponse;
import com.autodesk.aps.oss.model.Signeds3uploadResponse;
import com.autodesk.aps.oss.model.UploadObjectOptionalParams;
import com.autodesk.aps.oss.model.UploadSignedResourceOptionalParams;
import com.autodesk.aps.oss.model.UploadSignedResourcesChunkOptionalParams;
import com.autodesk.aps.sdkmanager.BaseClient;
import com.autodesk.aps.sdkmanager.IAuthenticationProvider;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;

public class OssClient extends BaseClient {
    private final ObjectsApi objectsApi;
    private final BucketsApi bucketsApi;
    private final OssFileTransfer ossFileTransfer;

    /**
     * Initializes a new instance of the OssClient class.
     * 
     * @param sdkManager             The SDK manager instance.
     * @param authenticationProvider The authentication provider.
     */
    public OssClient(SdkManager sdkManager, IAuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
        if (sdkManager == null) {
            sdkManager = SdkManagerBuilder.create().build();
        }
        this.objectsApi = new ObjectsApi(sdkManager);
        this.bucketsApi = new BucketsApi(sdkManager);

        this.ossFileTransfer = new OssFileTransfer(new FileTransferConfigurations(3), sdkManager,
                authenticationProvider);
    }

    /**
     * Initializes a new instance of the OssClient class with a default
     * SDK manager.
     * 
     * @param authenticationProvider The authentication provider.
     */
    public OssClient(IAuthenticationProvider authenticationProvider) {
        this(SdkManagerBuilder.create().build(), authenticationProvider);
    }

    /**
     * Initializes a new instance of the OssClient class without an
     * authentication provider.
     * 
     * @param sdkManager
     */

    public OssClient(SdkManager sdkManager) {
        this(sdkManager, null);
    }

    /**
     * Initializes a new instance of the OssClient class with a default
     * SDK manager and without an authentication provider.
     */
    public OssClient() {
        this(SdkManagerBuilder.create().build(), null);
    }

    public void close() {
        this.bucketsApi.close();
    }

    /**
     * Complete Batch Upload to S3 Signed URLs
     * Requests OSS to start reconstituting the set of objects that were uploaded
     * using signed S3 upload URLs. You must call this operation only after all the
     * objects have been uploaded.
     * 
     * You can specify up to 25 objects in this operation.
     * 
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @return BatchcompleteuploadResponse
     * @throws OssApiException when an API call fails.
     */

    public BatchcompleteuploadResponse batchCompleteUpload(String bucketKey) throws OssApiException {
        return batchCompleteUpload(bucketKey, null);
    }

    /**
     * Complete Batch Upload to S3 Signed URLs
     * Requests OSS to start reconstituting the set of objects that were uploaded
     * using signed S3 upload URLs. You must call this operation only after all the
     * objects have been uploaded.
     * 
     * You can specify up to 25 objects in this operation.
     * 
     * @param bucketKey                        The bucket key of the bucket that
     *                                         contains the objects you are
     *                                         operating on. (required)
     * @param batchCompleteUploadOptionaParams class containing all optional
     *                                         parameters for the
     *                                         batchCompleteUpload method.
     * @return BatchcompleteuploadResponse
     * @throws OssApiException when an API call fails.
     */

    public BatchcompleteuploadResponse batchCompleteUpload(String bucketKey,
            BatchCompleteUploadOptionalParams batchCompleteUploadOptionalParams) throws OssApiException {
        try {
            if (batchCompleteUploadOptionalParams == null) {
                batchCompleteUploadOptionalParams = new BatchCompleteUploadOptionalParams.Builder().build();
            }
            if (batchCompleteUploadOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (batchCompleteUploadOptionalParams.getAccessToken() == null) {
                batchCompleteUploadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi
                    .batchCompleteUpload(bucketKey, batchCompleteUploadOptionalParams.getBatchcompleteuploadObject(),
                            batchCompleteUploadOptionalParams.getAccessToken())
                    .getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @return Batchsigneds3downloadResponse
     * @throws OssApiException when an API call fails.
     */

    public Batchsigneds3downloadResponse batchSignedS3Download(String bucketKey,
            Batchsigneds3downloadObject batchsigneds3downloadObject) throws OssApiException {
        return batchSignedS3Download(bucketKey, batchsigneds3downloadObject, null);
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
     * @param bucketKey                          The bucket key of the bucket that
     *                                           contains the objects you are
     *                                           operating on. (required)
     * @param batchsigneds3downloadObject        An array of objects representing
     *                                           each request for a signed download
     *                                           URL. (required)
     * @param batchSignedS3DownloadOptionaParams class containing all optional
     *                                           parameters for the
     *                                           batchSignedS3Download method.
     * @return Batchsigneds3downloadResponse
     * @throws OssApiException when an API call fails.
     */

    public Batchsigneds3downloadResponse batchSignedS3Download(String bucketKey,
            Batchsigneds3downloadObject batchsigneds3downloadObject,
            BatchSignedS3DownloadOptionalParams batchSignedS3DownloadOptionalParams) throws OssApiException {
        try {
            if (batchSignedS3DownloadOptionalParams == null) {
                batchSignedS3DownloadOptionalParams = new BatchSignedS3DownloadOptionalParams.Builder().build();
            }
            if (batchSignedS3DownloadOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (batchSignedS3DownloadOptionalParams.getAccessToken() == null) {
                batchSignedS3DownloadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.batchSignedS3Download(bucketKey, batchsigneds3downloadObject,
                    batchSignedS3DownloadOptionalParams.getPublicResourceFallback(),
                    batchSignedS3DownloadOptionalParams.getMinutesExpiration(),
                    batchSignedS3DownloadOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @return Batchsigneds3uploadResponse
     * @throws OssApiException when an API call fails.
     */

    public Batchsigneds3uploadResponse batchSignedS3Upload(String bucketKey) throws OssApiException {
        return batchSignedS3Upload(bucketKey, null);
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
     * @param bucketKey                        The bucket key of the bucket that
     *                                         contains the objects you are
     *                                         operating on. (required)
     * @param batchSignedS3UploadOptionaParams class containing all optional
     *                                         parameters for the
     *                                         batchSignedS3Upload method.
     * @return Batchsigneds3uploadResponse
     * @throws OssApiException when an API call fails.
     */

    public Batchsigneds3uploadResponse batchSignedS3Upload(String bucketKey,
            BatchSignedS3UploadOptionalParams batchSignedS3UploadOptionalParams) throws OssApiException {
        try {
            if (batchSignedS3UploadOptionalParams == null) {
                batchSignedS3UploadOptionalParams = new BatchSignedS3UploadOptionalParams.Builder().build();
            }
            if (batchSignedS3UploadOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (batchSignedS3UploadOptionalParams.getAccessToken() == null) {
                batchSignedS3UploadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.batchSignedS3Upload(bucketKey, batchSignedS3UploadOptionalParams.getUseAcceleration(),
                    batchSignedS3UploadOptionalParams.getMinutesExpiration(),
                    batchSignedS3UploadOptionalParams.getBatchsigneds3uploadObject(),
                    batchSignedS3UploadOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Complete Upload to S3 Signed URL
     * Requests OSS to assemble and reconstitute the object that was uploaded using
     * signed S3 upload URL. You must call this operation only after all
     * parts/chunks of the object has been uploaded.
     * 
     * @param bucketKey            The bucket key of the bucket that contains the
     *                             objects you are operating on. (required)
     * @param objectKey            The URL-encoded human friendly name of the
     *                             object. (required)
     * @param contentType          Must be &#x60;&#x60;application/json&#x60;&#x60;.
     *                             (required)
     * @param completes3uploadBody (required)
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails completeSignedS3Upload(String bucketKey, String objectKey, String contentType,
            Completes3uploadBody completes3uploadBody) throws OssApiException {
        return completeSignedS3Upload(bucketKey, objectKey, contentType, completes3uploadBody, null);
    }

    /**
     * Complete Upload to S3 Signed URL
     * Requests OSS to assemble and reconstitute the object that was uploaded using
     * signed S3 upload URL. You must call this operation only after all
     * parts/chunks of the object has been uploaded.
     * 
     * @param bucketKey                           The bucket key of the bucket that
     *                                            contains the objects you are
     *                                            operating on. (required)
     * @param objectKey                           The URL-encoded human friendly
     *                                            name of the object. (required)
     * @param contentType                         Must be
     *                                            &#x60;&#x60;application/json&#x60;&#x60;.
     *                                            (required)
     * @param completes3uploadBody                (required)
     * @param completeSignedS3UploadOptionaParams class containing all optional
     *                                            parameters for the
     *                                            completeSignedS3Upload method.
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails completeSignedS3Upload(String bucketKey, String objectKey, String contentType,
            Completes3uploadBody completes3uploadBody,
            CompleteSignedS3UploadOptionalParams completeSignedS3UploadOptionalParams) throws OssApiException {
        try {
            if (completeSignedS3UploadOptionalParams == null) {
                completeSignedS3UploadOptionalParams = new CompleteSignedS3UploadOptionalParams.Builder().build();
            }
            if (completeSignedS3UploadOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (completeSignedS3UploadOptionalParams.getAccessToken() == null) {
                completeSignedS3UploadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.completeSignedS3Upload(bucketKey, objectKey, contentType, completes3uploadBody,
                    completeSignedS3UploadOptionalParams.getXAdsMetaContentType(),
                    completeSignedS3UploadOptionalParams.getXAdsMetaContentDisposition(),
                    completeSignedS3UploadOptionalParams.getXAdsMetaContentEncoding(),
                    completeSignedS3UploadOptionalParams.getXAdsMetaCacheControl(),
                    completeSignedS3UploadOptionalParams.getXAdsUserDefinedMetadata(),
                    completeSignedS3UploadOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails copyTo(String bucketKey, String objectKey, String newObjKey) throws OssApiException {
        return copyTo(bucketKey, objectKey, newObjKey, null);
    }

    /**
     * Copy Object
     * Creates a copy of an object within the bucket.
     * 
     * @param bucketKey           The bucket key of the bucket that contains the
     *                            objects you are operating on. (required)
     * @param objectKey           The URL-encoded human friendly name of the object.
     *                            (required)
     * @param newObjKey           A URL-encoded human friendly name to identify the
     *                            copied object. (required)
     * @param copyToOptionaParams class containing all optional parameters for the
     *                            copyTo method.
     * @return ObjectDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails copyTo(String bucketKey, String objectKey, String newObjKey,
            CopyToOptionalParams copyToOptionalParams) throws OssApiException {
        try {
            if (copyToOptionalParams == null) {
                copyToOptionalParams = new CopyToOptionalParams.Builder().build();
            }
            if (copyToOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (copyToOptionalParams.getAccessToken() == null) {
                copyToOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.copyTo(bucketKey, objectKey, newObjKey, copyToOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
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
     * @throws OssApiException when an API call fails.
     */

    public Bucket createBucket(Region region, CreateBucketsPayload createBucketsPayload) throws OssApiException {
        return createBucket(region, createBucketsPayload, null);
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
     * @param region                    Specifies where the bucket containing the
     *                                  object is stored. Possible values are: -
     *                                  &#x60;&#x60;US&#x60;&#x60; : (Default) Data
     *                                  center for the US region. -
     *                                  &#x60;&#x60;EMEA&#x60;&#x60; : Data center
     *                                  for the European Union, Middle East, and
     *                                  Africa. - &#x60;&#x60;AUS&#x60;&#x60; :
     *                                  (Beta) Data center for Australia. -
     *                                  &#x60;&#x60;CAN&#x60;&#x60; : Data center
     *                                  for the Canada region. -
     *                                  &#x60;&#x60;DEU&#x60;&#x60; : Data center
     *                                  for the Germany region. -
     *                                  &#x60;&#x60;IND&#x60;&#x60; : Data center
     *                                  for the India region. -
     *                                  &#x60;&#x60;JPN&#x60;&#x60; : Data center
     *                                  for the Japan region. -
     *                                  &#x60;&#x60;GBR&#x60;&#x60; : Data center
     *                                  for the United Kingdom region. **Note:**
     *                                  Beta features are subject to change. Please
     *                                  do not use in production environments.
     *                                  (required)
     * @param createBucketsPayload      (required)
     * @param createBucketOptionaParams class containing all optional parameters for
     *                                  the createBucket method.
     * @return Bucket
     * @throws OssApiException when an API call fails.
     */

    public Bucket createBucket(Region region, CreateBucketsPayload createBucketsPayload,
            CreateBucketOptionalParams createBucketOptionalParams) throws OssApiException {
        try {
            if (createBucketOptionalParams == null) {
                createBucketOptionalParams = new CreateBucketOptionalParams.Builder().build();
            }
            if (createBucketOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (createBucketOptionalParams.getAccessToken() == null) {
                createBucketOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return bucketsApi.createBucket(region, createBucketsPayload, createBucketOptionalParams.getAccessToken())
                    .getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @param objectKey The URL-encoded human friendly name of the object.
     *                  (required)
     * @return CreateObjectSigned
     * @throws OssApiException when an API call fails.
     */

    public CreateObjectSigned createSignedResource(String bucketKey, String objectKey) throws OssApiException {
        return createSignedResource(bucketKey, objectKey, null);
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
     * @param bucketKey                         The bucket key of the bucket that
     *                                          contains the objects you are
     *                                          operating on. (required)
     * @param objectKey                         The URL-encoded human friendly name
     *                                          of the object. (required)
     * @param createSignedResourceOptionaParams class containing all optional
     *                                          parameters for the
     *                                          createSignedResource method.
     * @return CreateObjectSigned
     * @throws OssApiException when an API call fails.
     */

    public CreateObjectSigned createSignedResource(String bucketKey, String objectKey,
            CreateSignedResourceOptionalParams createSignedResourceOptionalParams) throws OssApiException {
        try {
            if (createSignedResourceOptionalParams == null) {
                createSignedResourceOptionalParams = new CreateSignedResourceOptionalParams.Builder().build();
            }
            if (createSignedResourceOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (createSignedResourceOptionalParams.getAccessToken() == null) {
                createSignedResourceOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.createSignedResource(bucketKey, objectKey, createSignedResourceOptionalParams.getAccess(),
                    createSignedResourceOptionalParams.getUseCdn(),
                    createSignedResourceOptionalParams.getCreateSignedResource(),
                    createSignedResourceOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @throws OssApiException when an API call fails.
     */

    public void deleteBucket(String bucketKey) throws OssApiException {
        deleteBucket(bucketKey, null);
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
     * @param bucketKey                 The bucket key of the bucket to delete.
     *                                  (required)
     * @param deleteBucketOptionaParams class containing all optional parameters for
     *                                  the deleteBucket method.
     * @throws OssApiException when an API call fails.
     */

    public void deleteBucket(String bucketKey, DeleteBucketOptionalParams deleteBucketOptionalParams)
            throws OssApiException {
        try {
            if (deleteBucketOptionalParams == null) {
                deleteBucketOptionalParams = new DeleteBucketOptionalParams.Builder().build();
            }
            if (deleteBucketOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (deleteBucketOptionalParams.getAccessToken() == null) {
                deleteBucketOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            bucketsApi.deleteBucket(bucketKey, deleteBucketOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @throws OssApiException when an API call fails.
     */

    public void deleteObject(String bucketKey, String objectKey) throws OssApiException {
        deleteObject(bucketKey, objectKey, null);
    }

    /**
     * Delete Object
     * Deletes an object from the bucket.
     * 
     * @param bucketKey                 The bucket key of the bucket that contains
     *                                  the objects you are operating on. (required)
     * @param objectKey                 The URL-encoded human friendly name of the
     *                                  object. (required)
     * @param deleteObjectOptionaParams class containing all optional parameters for
     *                                  the deleteObject method.
     * @throws OssApiException when an API call fails.
     */

    public void deleteObject(String bucketKey, String objectKey, DeleteObjectOptionalParams deleteObjectOptionalParams)
            throws OssApiException {
        try {
            if (deleteObjectOptionalParams == null) {
                deleteObjectOptionalParams = new DeleteObjectOptionalParams.Builder().build();
            }
            if (deleteObjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (deleteObjectOptionalParams.getAccessToken() == null) {
                deleteObjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            objectsApi.deleteObject(bucketKey, objectKey, deleteObjectOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param hash The ID component of the signed URL. **Note:** The signed URL
     *             returned by [Generate OSS Signed
     *             URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *             contains &#x60;&#x60;hash&#x60;&#x60; as a URI parameter.
     *             (required)
     * @throws OssApiException when an API call fails.
     */

    public void deleteSignedResource(String hash) throws OssApiException {
        deleteSignedResource(hash, null);
    }

    /**
     * Delete Object Using Signed URL
     * Delete an object using an OSS signed URL to access it.
     * 
     * Only applications that own the bucket containing the object can call this
     * operation.
     * 
     * @param hash                              The ID component of the signed URL.
     *                                          **Note:** The signed URL returned by
     *                                          [Generate OSS Signed
     *                                          URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *                                          contains
     *                                          &#x60;&#x60;hash&#x60;&#x60; as a
     *                                          URI parameter. (required)
     * @param deleteSignedResourceOptionaParams class containing all optional
     *                                          parameters for the
     *                                          deleteSignedResource method.
     * @throws OssApiException when an API call fails.
     */

    public void deleteSignedResource(String hash, DeleteSignedResourceOptionalParams deleteSignedResourceOptionalParams)
            throws OssApiException {
        try {
            if (deleteSignedResourceOptionalParams == null) {
                deleteSignedResourceOptionalParams = new DeleteSignedResourceOptionalParams.Builder().build();
            }
            if (deleteSignedResourceOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (deleteSignedResourceOptionalParams.getAccessToken() == null) {
                deleteSignedResourceOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            objectsApi.deleteSignedResource(hash, deleteSignedResourceOptionalParams.getRegion(),
                    deleteSignedResourceOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @throws OssApiException when an API call fails.
     */

    public Bucket getBucketDetails(String bucketKey) throws OssApiException {
        return getBucketDetails(bucketKey, null);
    }

    /**
     * Get Bucket Details
     * Returns detailed information about the specified bucket.
     * 
     * **Note:** Only the application that owns the bucket can call this operation.
     * All other applications that call this operation will receive a &quot;403
     * Forbidden&quot; error.
     * 
     * @param bucketKey                     The bucket key of the bucket to query.
     *                                      (required)
     * @param getBucketDetailsOptionaParams class containing all optional parameters
     *                                      for the getBucketDetails method.
     * @return Bucket
     * @throws OssApiException when an API call fails.
     */

    public Bucket getBucketDetails(String bucketKey, GetBucketDetailsOptionalParams getBucketDetailsOptionalParams)
            throws OssApiException {
        try {
            if (getBucketDetailsOptionalParams == null) {
                getBucketDetailsOptionalParams = new GetBucketDetailsOptionalParams.Builder().build();
            }
            if (getBucketDetailsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (getBucketDetailsOptionalParams.getAccessToken() == null) {
                getBucketDetailsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return bucketsApi.getBucketDetails(bucketKey, getBucketDetailsOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * List Buckets
     * Returns a list of buckets owned by the application.
     * 
     * @return Buckets
     * @throws OssApiException when an API call fails.
     */

    public Buckets getBuckets() throws OssApiException {
        return getBuckets(null);
    }

    /**
     * List Buckets
     * Returns a list of buckets owned by the application.
     * 
     * @param getBucketsOptionaParams class containing all optional parameters for
     *                                the getBuckets method.
     * @return Buckets
     * @throws OssApiException when an API call fails.
     */

    public Buckets getBuckets(GetBucketsOptionalParams getBucketsOptionalParams) throws OssApiException {
        try {
            if (getBucketsOptionalParams == null) {
                getBucketsOptionalParams = new GetBucketsOptionalParams.Builder().build();
            }
            if (getBucketsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (getBucketsOptionalParams.getAccessToken() == null) {
                getBucketsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return bucketsApi.getBuckets(getBucketsOptionalParams.getRegion(), getBucketsOptionalParams.getLimit(),
                    getBucketsOptionalParams.getStartAt(), getBucketsOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Get Object Details
     * Returns detailed information about the specified object.
     * 
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @param objectKey The URL-encoded human friendly name of the object.
     *                  (required)
     * @return ObjectFullDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectFullDetails getObjectDetails(String bucketKey, String objectKey) throws OssApiException {
        return getObjectDetails(bucketKey, objectKey, null);
    }

    /**
     * Get Object Details
     * Returns detailed information about the specified object.
     * 
     * @param bucketKey                     The bucket key of the bucket that
     *                                      contains the objects you are operating
     *                                      on. (required)
     * @param objectKey                     The URL-encoded human friendly name of
     *                                      the object. (required)
     * @param getObjectDetailsOptionaParams class containing all optional parameters
     *                                      for the getObjectDetails method.
     * @return ObjectFullDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectFullDetails getObjectDetails(String bucketKey, String objectKey,
            GetObjectDetailsOptionalParams getObjectDetailsOptionalParams) throws OssApiException {
        try {
            if (getObjectDetailsOptionalParams == null) {
                getObjectDetailsOptionalParams = new GetObjectDetailsOptionalParams.Builder().build();
            }
            if (getObjectDetailsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (getObjectDetailsOptionalParams.getAccessToken() == null) {
                getObjectDetailsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi
                    .getObjectDetails(bucketKey, objectKey, getObjectDetailsOptionalParams.getIfModifiedSince(),
                            getObjectDetailsOptionalParams.getWith(), getObjectDetailsOptionalParams.getAccessToken())
                    .getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @return BucketObjects
     * @throws OssApiException when an API call fails.
     */

    public BucketObjects getObjects(String bucketKey) throws OssApiException {
        return getObjects(bucketKey, null);
    }

    /**
     * List Objects
     * Returns a list objects in the specified bucket.
     * 
     * Only the application that owns the bucket can call this operation. All other
     * applications that call this operation will receive a &quot;403
     * Forbidden&quot; error.
     * 
     * @param bucketKey               The bucket key of the bucket that contains the
     *                                objects you are operating on. (required)
     * @param getObjectsOptionaParams class containing all optional parameters for
     *                                the getObjects method.
     * @return BucketObjects
     * @throws OssApiException when an API call fails.
     */

    public BucketObjects getObjects(String bucketKey, GetObjectsOptionalParams getObjectsOptionalParams)
            throws OssApiException {
        try {
            if (getObjectsOptionalParams == null) {
                getObjectsOptionalParams = new GetObjectsOptionalParams.Builder().build();
            }
            if (getObjectsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (getObjectsOptionalParams.getAccessToken() == null) {
                getObjectsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.getObjects(bucketKey, getObjectsOptionalParams.getLimit(),
                    getObjectsOptionalParams.getBeginsWith(), getObjectsOptionalParams.getStartAt(),
                    getObjectsOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param hash The ID component of the signed URL. **Note:** The signed URL
     *             returned by [Generate OSS Signed
     *             URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *             contains &#x60;&#x60;hash&#x60;&#x60; as a URI parameter.
     *             (required)
     * @return File
     * @throws OssApiException when an API call fails.
     */

    public File getSignedResource(String hash) throws OssApiException {
        return getSignedResource(hash, null);
    }

    /**
     * Download Object Using Signed URL
     * Downloads an object using an OSS signed URL.
     * 
     * **Note:** The signed URL returned by [Generate OSS Signed
     * URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/) contains the
     * &#x60;&#x60;hash&#x60;&#x60; URI parameter as well.
     * 
     * @param hash                           The ID component of the signed URL.
     *                                       **Note:** The signed URL returned by
     *                                       [Generate OSS Signed
     *                                       URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *                                       contains &#x60;&#x60;hash&#x60;&#x60;
     *                                       as a URI parameter. (required)
     * @param getSignedResourceOptionaParams class containing all optional
     *                                       parameters for the getSignedResource
     *                                       method.
     * @return File
     * @throws OssApiException when an API call fails.
     */

    public File getSignedResource(String hash, GetSignedResourceOptionalParams getSignedResourceOptionalParams)
            throws OssApiException {
        try {
            if (getSignedResourceOptionalParams == null) {
                getSignedResourceOptionalParams = new GetSignedResourceOptionalParams.Builder().build();
            }
            if (getSignedResourceOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (getSignedResourceOptionalParams.getAccessToken() == null) {
                getSignedResourceOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.getSignedResource(hash, getSignedResourceOptionalParams.getRange(),
                    getSignedResourceOptionalParams.getIfNoneMatch(),
                    getSignedResourceOptionalParams.getIfModifiedSince(),
                    getSignedResourceOptionalParams.getAcceptEncoding(), getSignedResourceOptionalParams.getRegion(),
                    getSignedResourceOptionalParams.getResponseContentDisposition(),
                    getSignedResourceOptionalParams.getResponseContentType(),
                    getSignedResourceOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @param objectKey The URL-encoded human friendly name of the object.
     *                  (required)
     * @return Signeds3downloadResponse
     * @throws OssApiException when an API call fails.
     */

    public Signeds3downloadResponse signedS3Download(String bucketKey, String objectKey) throws OssApiException {
        return signedS3Download(bucketKey, objectKey, null);
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
     * @param bucketKey                     The bucket key of the bucket that
     *                                      contains the objects you are operating
     *                                      on. (required)
     * @param objectKey                     The URL-encoded human friendly name of
     *                                      the object. (required)
     * @param signedS3DownloadOptionaParams class containing all optional parameters
     *                                      for the signedS3Download method.
     * @return Signeds3downloadResponse
     * @throws OssApiException when an API call fails.
     */

    public Signeds3downloadResponse signedS3Download(String bucketKey, String objectKey,
            SignedS3DownloadOptionalParams signedS3DownloadOptionalParams) throws OssApiException {
        try {
            if (signedS3DownloadOptionalParams == null) {
                signedS3DownloadOptionalParams = new SignedS3DownloadOptionalParams.Builder().build();
            }
            if (signedS3DownloadOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (signedS3DownloadOptionalParams.getAccessToken() == null) {
                signedS3DownloadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi
                    .signedS3Download(bucketKey, objectKey, signedS3DownloadOptionalParams.getIfNoneMatch(),
                            signedS3DownloadOptionalParams.getIfModifiedSince(),
                            signedS3DownloadOptionalParams.getResponseContentType(),
                            signedS3DownloadOptionalParams.getResponseContentDisposition(),
                            signedS3DownloadOptionalParams.getResponseCacheControl(),
                            signedS3DownloadOptionalParams.getPublicResourceFallback(),
                            signedS3DownloadOptionalParams.getMinutesExpiration(),
                            signedS3DownloadOptionalParams.getUseCdn(), signedS3DownloadOptionalParams.getAccessToken())
                    .getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param bucketKey The bucket key of the bucket that contains the objects you
     *                  are operating on. (required)
     * @param objectKey The URL-encoded human friendly name of the object.
     *                  (required)
     * @return Signeds3uploadResponse
     * @throws OssApiException when an API call fails.
     */

    public Signeds3uploadResponse signedS3Upload(String bucketKey, String objectKey) throws OssApiException {
        return signedS3Upload(bucketKey, objectKey, null);
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
     * @param bucketKey                   The bucket key of the bucket that contains
     *                                    the objects you are operating on.
     *                                    (required)
     * @param objectKey                   The URL-encoded human friendly name of the
     *                                    object. (required)
     * @param signedS3UploadOptionaParams class containing all optional parameters
     *                                    for the signedS3Upload method.
     * @return Signeds3uploadResponse
     * @throws OssApiException when an API call fails.
     */

    public Signeds3uploadResponse signedS3Upload(String bucketKey, String objectKey,
            SignedS3UploadOptionalParams signedS3UploadOptionalParams) throws OssApiException {
        try {
            if (signedS3UploadOptionalParams == null) {
                signedS3UploadOptionalParams = new SignedS3UploadOptionalParams.Builder().build();
            }
            if (signedS3UploadOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (signedS3UploadOptionalParams.getAccessToken() == null) {
                signedS3UploadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.signedS3Upload(bucketKey, objectKey, signedS3UploadOptionalParams.getParts(),
                    signedS3UploadOptionalParams.getFirstPart(), signedS3UploadOptionalParams.getUploadKey(),
                    signedS3UploadOptionalParams.getMinutesExpiration(),
                    signedS3UploadOptionalParams.getUseAcceleration(), signedS3UploadOptionalParams.getAccessToken())
                    .getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param hash          The ID component of the signed URL. **Note:** The signed
     *                      URL returned by [Generate OSS Signed
     *                      URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *                      contains &#x60;&#x60;hash&#x60;&#x60; as a URI
     *                      parameter. (required)
     * @param contentLength The size of the data contained in the request body, in
     *                      bytes. (required)
     * @param body          The object to upload. (required)
     * @return ObjectDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails uploadSignedResource(String hash, Integer contentLength, byte[] body) throws OssApiException {
        return uploadSignedResource(hash, contentLength, body, null);
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
     * @param hash                              The ID component of the signed URL.
     *                                          **Note:** The signed URL returned by
     *                                          [Generate OSS Signed
     *                                          URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *                                          contains
     *                                          &#x60;&#x60;hash&#x60;&#x60; as a
     *                                          URI parameter. (required)
     * @param contentLength                     The size of the data contained in
     *                                          the request body, in bytes.
     *                                          (required)
     * @param body                              The object to upload. (required)
     * @param uploadSignedResourceOptionaParams class containing all optional
     *                                          parameters for the
     *                                          uploadSignedResource method.
     * @return ObjectDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails uploadSignedResource(String hash, Integer contentLength, byte[] body,
            UploadSignedResourceOptionalParams uploadSignedResourceOptionalParams) throws OssApiException {
        try {
            if (uploadSignedResourceOptionalParams == null) {
                uploadSignedResourceOptionalParams = new UploadSignedResourceOptionalParams.Builder().build();
            }
            if (uploadSignedResourceOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (uploadSignedResourceOptionalParams.getAccessToken() == null) {
                uploadSignedResourceOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.uploadSignedResource(hash, contentLength, body,
                    uploadSignedResourceOptionalParams.getContentType(),
                    uploadSignedResourceOptionalParams.getContentDisposition(),
                    uploadSignedResourceOptionalParams.getXAdsRegion(), uploadSignedResourceOptionalParams.getIfMatch(),
                    uploadSignedResourceOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
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
     * @param hash         The ID component of the signed URL. **Note:** The signed
     *                     URL returned by [Generate OSS Signed
     *                     URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *                     contains &#x60;&#x60;hash&#x60;&#x60; as a URI parameter.
     *                     (required)
     * @param contentRange The byte range to upload, specified in the form
     *                     &#x60;&#x60;bytes&#x3D;&lt;START_BYTE&gt;-&lt;END_BYTE&gt;&#x60;&#x60;.
     *                     (required)
     * @param sessionId    An ID to uniquely identify the file upload session.
     *                     (required)
     * @param body         The chunk to upload. (required)
     * @return ObjectDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails uploadSignedResourcesChunk(String hash, String contentRange, String sessionId, byte[] body)
            throws OssApiException {
        return uploadSignedResourcesChunk(hash, contentRange, sessionId, body, null);
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
     * @param hash                                    The ID component of the signed
     *                                                URL. **Note:** The signed URL
     *                                                returned by [Generate OSS
     *                                                Signed
     *                                                URL](/en/docs/data/v2/reference/http/signedresources-:id-GET/)
     *                                                contains
     *                                                &#x60;&#x60;hash&#x60;&#x60;
     *                                                as a URI parameter. (required)
     * @param contentRange                            The byte range to upload,
     *                                                specified in the form
     *                                                &#x60;&#x60;bytes&#x3D;&lt;START_BYTE&gt;-&lt;END_BYTE&gt;&#x60;&#x60;.
     *                                                (required)
     * @param sessionId                               An ID to uniquely identify the
     *                                                file upload session.
     *                                                (required)
     * @param body                                    The chunk to upload.
     *                                                (required)
     * @param uploadSignedResourcesChunkOptionaParams class containing all optional
     *                                                parameters for the
     *                                                uploadSignedResourcesChunk
     *                                                method.
     * @return ObjectDetails
     * @throws OssApiException when an API call fails.
     */

    public ObjectDetails uploadSignedResourcesChunk(String hash, String contentRange, String sessionId, byte[] body,
            UploadSignedResourcesChunkOptionalParams uploadSignedResourcesChunkOptionalParams) throws OssApiException {
        try {
            if (uploadSignedResourcesChunkOptionalParams == null) {
                uploadSignedResourcesChunkOptionalParams = new UploadSignedResourcesChunkOptionalParams.Builder()
                        .build();
            }
            if (uploadSignedResourcesChunkOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (uploadSignedResourcesChunkOptionalParams.getAccessToken() == null) {
                uploadSignedResourcesChunkOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return objectsApi.uploadSignedResourcesChunk(hash, contentRange, sessionId, body,
                    uploadSignedResourcesChunkOptionalParams.getContentType(),
                    uploadSignedResourcesChunkOptionalParams.getContentDisposition(),
                    uploadSignedResourcesChunkOptionalParams.getXAdsRegion(),
                    uploadSignedResourcesChunkOptionalParams.getAccessToken()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Instructs OSS to complete the object creation process for numerous objects
     * after their bytes have been uploaded directly to S3. An object will not be
     * accessible until you complete the object creation process, either with this
     * endpoint or the single Complete Upload endpoint. This endpoint accepts batch
     * sizes of up to 25. Any larger and the request will fail.
     * 
     * @param bucketKey      URL-encoded bucket key
     * @param objectKey      URL-encoded object name
     * @param sourceToUpload The file to be uploaded.
     * @throws OssApiException when an API call fails.
     */
    public ObjectDetails uploadObject(String bucketKey, String objectKey, File sourceToUpload) throws OssApiException {
        return uploadObject(bucketKey, objectKey, sourceToUpload, null);
    }

    /**
     * Instructs OSS to complete the object creation process for numerous objects
     * after their bytes have been uploaded directly to S3. An object will not be
     * accessible until you complete the object creation process, either with this
     * endpoint or the single Complete Upload endpoint. This endpoint accepts batch
     * sizes of up to 25. Any larger and the request will fail.
     * 
     * @param bucketKey                  URL-encoded bucket key
     * @param objectKey                  URL-encoded object name
     * @param sourceToUpload             The file to be uploaded.
     * @param uploadObjectOptionalParams class containing all optional parameters
     *                                   for the uploadObject method.
     * @throws OssApiException when an API call fails.
     */
    public ObjectDetails uploadObject(String bucketKey, String objectKey, File sourceToUpload,
            UploadObjectOptionalParams uploadObjectOptionalParams) throws OssApiException {
        try {
            if (uploadObjectOptionalParams == null) {
                uploadObjectOptionalParams = new UploadObjectOptionalParams.Builder().build();
            }
            if (uploadObjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (uploadObjectOptionalParams.getAccessToken() == null) {
                uploadObjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            InputStream inputStream = new FileInputStream(sourceToUpload);
            return this.ossFileTransfer.upload(bucketKey, objectKey, inputStream, sourceToUpload.length(),
                    uploadObjectOptionalParams.getAccessToken(), uploadObjectOptionalParams.getRequestIdPrefix(),
                    uploadObjectOptionalParams.getProgressCallback(),
                    uploadObjectOptionalParams.getXAdsMetaContentType(),
                    uploadObjectOptionalParams.getXAdsMetaContentDisposition(),
                    uploadObjectOptionalParams.getXAdsMetaContentEncoding(),
                    uploadObjectOptionalParams.getXAdsMetaCacheControl()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Instructs OSS to complete the object creation process for numerous objects
     * after their bytes have been uploaded directly to S3. An object will not be
     * accessible until you complete the object creation process, either with this
     * endpoint or the single Complete Upload endpoint. This endpoint accepts batch
     * sizes of up to 25. Any larger and the request will fail.
     * 
     * @param bucketKey      URL-encoded bucket key
     * @param objectKey      URL-encoded object name
     * @param sourceToUpload The buffer to be uploaded.
     * @throws OssApiException when an API call fails.
     */
    public ObjectDetails uploadObject(String bucketKey, String objectKey, byte[] sourceToUpload)
            throws OssApiException {
        return uploadObject(bucketKey, objectKey, sourceToUpload, null);
    }

    /**
     * Instructs OSS to complete the object creation process for numerous objects
     * after their bytes have been uploaded directly to S3. An object will not be
     * accessible until you complete the object creation process, either with this
     * endpoint or the single Complete Upload endpoint. This endpoint accepts batch
     * sizes of up to 25. Any larger and the request will fail.
     * 
     * @param bucketKey                  URL-encoded bucket key
     * @param objectKey                  URL-encoded object name
     * @param sourceToUpload             The buffer to be uploaded.
     * @param uploadObjectOptionalParams class containing all optional parameters
     *                                   for the uploadObject method.
     * @throws OssApiException when an API call fails.
     */
    public ObjectDetails uploadObject(String bucketKey, String objectKey, byte[] sourceToUpload,
            UploadObjectOptionalParams uploadObjectOptionalParams) throws OssApiException {
        try {
            if (uploadObjectOptionalParams == null) {
                uploadObjectOptionalParams = new UploadObjectOptionalParams.Builder().build();
            }
            if (uploadObjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (uploadObjectOptionalParams.getAccessToken() == null) {
                uploadObjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            InputStream inputStream = new ByteArrayInputStream(sourceToUpload);
            return this.ossFileTransfer.upload(bucketKey, objectKey, inputStream, (long) sourceToUpload.length,
                    uploadObjectOptionalParams.getAccessToken(), uploadObjectOptionalParams.getRequestIdPrefix(),
                    uploadObjectOptionalParams.getProgressCallback(),
                    uploadObjectOptionalParams.getXAdsMetaContentType(),
                    uploadObjectOptionalParams.getXAdsMetaContentDisposition(),
                    uploadObjectOptionalParams.getXAdsMetaContentEncoding(),
                    uploadObjectOptionalParams.getXAdsMetaCacheControl()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Instructs OSS to complete the object creation process for numerous objects
     * after their bytes have been uploaded directly to S3. An object will not be
     * accessible until you complete the object creation process, either with this
     * endpoint or the single Complete Upload endpoint. This endpoint accepts batch
     * sizes of up to 25. Any larger and the request will fail.
     * 
     * @param bucketKey      URL-encoded bucket key
     * @param objectKey      URL-encoded object name
     * @param sourceToUpload The stream to be uploaded.
     * @throws OssApiException when an API call fails.
     */
    public ObjectDetails uploadObject(String bucketKey, String objectKey, InputStream sourceToUpload)
            throws OssApiException {
        return uploadObject(bucketKey, objectKey, sourceToUpload, null);
    }

    /**
     * Instructs OSS to complete the object creation process for numerous objects
     * after their bytes have been uploaded directly to S3. An object will not be
     * accessible until you complete the object creation process, either with this
     * endpoint or the single Complete Upload endpoint. This endpoint accepts batch
     * sizes of up to 25. Any larger and the request will fail.
     * 
     * @param bucketKey                  URL-encoded bucket key
     * @param objectKey                  URL-encoded object name
     * @param sourceToUpload             The stream to be uploaded.
     * @param uploadObjectOptionalParams class containing all optional parameters
     *                                   for the uploadObject method.
     * @throws OssApiException when an API call fails.
     */
    public ObjectDetails uploadObject(String bucketKey, String objectKey, InputStream sourceToUpload,
            UploadObjectOptionalParams uploadObjectOptionalParams) throws OssApiException {
        try {
            if (uploadObjectOptionalParams == null) {
                uploadObjectOptionalParams = new UploadObjectOptionalParams.Builder().build();
            }
            if (uploadObjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (uploadObjectOptionalParams.getAccessToken() == null) {
                uploadObjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return this.ossFileTransfer.upload(bucketKey, objectKey, sourceToUpload, null,
                    uploadObjectOptionalParams.getAccessToken(), uploadObjectOptionalParams.getRequestIdPrefix(),
                    uploadObjectOptionalParams.getProgressCallback(),
                    uploadObjectOptionalParams.getXAdsMetaContentType(),
                    uploadObjectOptionalParams.getXAdsMetaContentDisposition(),
                    uploadObjectOptionalParams.getXAdsMetaContentEncoding(),
                    uploadObjectOptionalParams.getXAdsMetaCacheControl()).getData();
        } catch (OssApiException e) {
            throw e;
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Downloads an object from the specified bucket.
     * 
     * @param bucketKey URL-encoded bucket key
     * @param objectKey URL-encoded object name
     * @param filePath  The path where the file should be saved. If null, returns
     *                  an InputStream
     * @throws OssApiException when an API call fails.
     */
    public void downloadObject(String bucketKey, String objectKey, java.nio.file.Path filePath)
            throws OssApiException {
        downloadObject(bucketKey, objectKey, filePath, null);
    }

    /**
     * Downloads an object from the specified bucket.
     * 
     * @param bucketKey                    URL-encoded bucket key
     * @param objectKey                    URL-encoded object name
     * @param filePath                     The path where the file should be saved.
     *                                     If null, returns
     *                                     an InputStream
     * @param downloadObjectOptionalParams class containing all optional parameters
     *                                     for the downloadObject method.
     * @throws OssApiException when an API call fails.
     */
    public void downloadObject(String bucketKey, String objectKey, java.nio.file.Path filePath,
            DownloadObjectOptionalParams downloadObjectOptionalParams) throws OssApiException {
        try {
            if (downloadObjectOptionalParams == null) {
                downloadObjectOptionalParams = new DownloadObjectOptionalParams.Builder().build();
            }
            if (downloadObjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (downloadObjectOptionalParams.getAccessToken() == null) {
                downloadObjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            this.ossFileTransfer.download(bucketKey, objectKey, downloadObjectOptionalParams.getAccessToken(),
                    filePath, downloadObjectOptionalParams.getIsCancelled(),
                    downloadObjectOptionalParams.getRequestIdPrefix(),
                    downloadObjectOptionalParams.getProgressCallback());
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }

    /**
     * Downloads an object from the specified bucket to memory.
     * 
     * @param bucketKey URL-encoded bucket key
     * @param objectKey URL-encoded object name
     * @return InputStream containing the object data.
     * @throws OssApiException when an API call fails.
     */
    public InputStream downloadObject(String bucketKey, String objectKey) throws OssApiException {
        return downloadObject(bucketKey, objectKey, (DownloadObjectOptionalParams) null);
    }

    /**
     * Downloads an object from the specified bucket to memory.
     * 
     * @param bucketKey                    URL-encoded bucket key
     * @param objectKey                    URL-encoded object name
     * @param downloadObjectOptionalParams class containing all optional parameters
     *                                     for the downloadObject method.
     * @return InputStream containing the object data.
     * @throws OssApiException when an API call fails.
     */
    public InputStream downloadObject(String bucketKey, String objectKey,
            DownloadObjectOptionalParams downloadObjectOptionalParams) throws OssApiException {
        try {
            if (downloadObjectOptionalParams == null) {
                downloadObjectOptionalParams = new DownloadObjectOptionalParams.Builder().build();
            }
            if (downloadObjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new OssApiException("Please provide a valid access token!");
            } else if (downloadObjectOptionalParams.getAccessToken() == null) {
                downloadObjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return this.ossFileTransfer.download(bucketKey, objectKey, downloadObjectOptionalParams.getAccessToken(),
                    null, downloadObjectOptionalParams.getIsCancelled(),
                    downloadObjectOptionalParams.getRequestIdPrefix(),
                    downloadObjectOptionalParams.getProgressCallback());
        } catch (Exception e) {
            throw new OssApiException(e);
        }
    }
}