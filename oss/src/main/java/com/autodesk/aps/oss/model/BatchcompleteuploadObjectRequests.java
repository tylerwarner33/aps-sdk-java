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

package com.autodesk.aps.oss.model;

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * BatchcompleteuploadObjectRequests
 */
@JsonPropertyOrder({
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_OBJECT_KEY,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_UPLOAD_KEY,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_SIZE,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_E_TAGS,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_X_ADS_META_CONTENT_TYPE,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_X_ADS_META_CONTENT_DISPOSITION,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_X_ADS_META_CONTENT_ENCODING,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_X_ADS_META_CACHE_CONTROL,
  BatchcompleteuploadObjectRequests.JSON_PROPERTY_X_ADS_USER_DEFINED_METADATA
})
@JsonTypeName("batchcompleteupload_object_requests")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BatchcompleteuploadObjectRequests {
  public static final String JSON_PROPERTY_OBJECT_KEY = "objectKey";
  private String objectKey;

  public static final String JSON_PROPERTY_UPLOAD_KEY = "uploadKey";
  private String uploadKey;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_E_TAGS = "eTags";
  private List<String> eTags = null;

  public static final String JSON_PROPERTY_X_ADS_META_CONTENT_TYPE = "x-ads-meta-Content-Type";
  private String xAdsMetaContentType;

  public static final String JSON_PROPERTY_X_ADS_META_CONTENT_DISPOSITION = "x-ads-meta-Content-Disposition";
  private String xAdsMetaContentDisposition;

  public static final String JSON_PROPERTY_X_ADS_META_CONTENT_ENCODING = "x-ads-meta-Content-Encoding";
  private String xAdsMetaContentEncoding;

  public static final String JSON_PROPERTY_X_ADS_META_CACHE_CONTROL = "x-ads-meta-Cache-Control";
  private String xAdsMetaCacheControl;

  public static final String JSON_PROPERTY_X_ADS_USER_DEFINED_METADATA = "x-ads-user-defined-metadata";
  private String xAdsUserDefinedMetadata;


  public BatchcompleteuploadObjectRequests objectKey(String objectKey) {
    
    this.objectKey = objectKey;
    return this;
  }

   /**
   * The URL-encoded human friendly name of the object for which to complete an upload.
   * @return objectKey
  **/
  @Schema(required = true, description = "The URL-encoded human friendly name of the object for which to complete an upload.")
  @JsonProperty(JSON_PROPERTY_OBJECT_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getObjectKey() {
    return objectKey;
  }


  @JsonProperty(JSON_PROPERTY_OBJECT_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }


  public BatchcompleteuploadObjectRequests uploadKey(String uploadKey) {
    
    this.uploadKey = uploadKey;
    return this;
  }

   /**
   * The ID uniquely identifying the upload session that was returned when you obtained the signed upload URL.
   * @return uploadKey
  **/
  @Schema(required = true, description = "The ID uniquely identifying the upload session that was returned when you obtained the signed upload URL.")
  @JsonProperty(JSON_PROPERTY_UPLOAD_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUploadKey() {
    return uploadKey;
  }


  @JsonProperty(JSON_PROPERTY_UPLOAD_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUploadKey(String uploadKey) {
    this.uploadKey = uploadKey;
  }


  public BatchcompleteuploadObjectRequests size(Long size) {
    
    this.size = size;
    return this;
  }

   /**
   * The expected size of the object. If provided, OSS will check this against the object in S3 and return an error if the size does not match.
   * @return size
  **/
  @javax.annotation.Nullable
  @Schema(description = "The expected size of the object. If provided, OSS will check this against the object in S3 and return an error if the size does not match.")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getSize() {
    return size;
  }


  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSize(Long size) {
    this.size = size;
  }


  public BatchcompleteuploadObjectRequests eTags(List<String> eTags) {
    
    this.eTags = eTags;
    return this;
  }

  public BatchcompleteuploadObjectRequests addeTagsItem(String eTagsItem) {
    if (this.eTags == null) {
      this.eTags = new ArrayList<>();
    }
    this.eTags.add(eTagsItem);
    return this;
  }

   /**
   * An array of eTags. S3 returns an eTag to each upload request, be it for a chunk or an entire file. For a single-part upload, this array contains the expected eTag of the entire object. For a multipart upload, this array contains the expected eTag of each part of the upload; the index of an eTag in the array corresponds to its part number in the upload. If provided, OSS will validate these eTags against the content in S3, and return an error if the eTags do not match.
   * @return eTags
  **/
  @javax.annotation.Nullable
  @Schema(description = "An array of eTags. S3 returns an eTag to each upload request, be it for a chunk or an entire file. For a single-part upload, this array contains the expected eTag of the entire object. For a multipart upload, this array contains the expected eTag of each part of the upload; the index of an eTag in the array corresponds to its part number in the upload. If provided, OSS will validate these eTags against the content in S3, and return an error if the eTags do not match.")
  @JsonProperty(JSON_PROPERTY_E_TAGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> geteTags() {
    return eTags;
  }


  @JsonProperty(JSON_PROPERTY_E_TAGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void seteTags(List<String> eTags) {
    this.eTags = eTags;
  }


  public BatchcompleteuploadObjectRequests xAdsMetaContentType(String xAdsMetaContentType) {
    
    this.xAdsMetaContentType = xAdsMetaContentType;
    return this;
  }

   /**
   * The Content-Type value for the uploaded object to record within OSS.
   * @return xAdsMetaContentType
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Content-Type value for the uploaded object to record within OSS.")
  @JsonProperty(JSON_PROPERTY_X_ADS_META_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getxAdsMetaContentType() {
    return xAdsMetaContentType;
  }


  @JsonProperty(JSON_PROPERTY_X_ADS_META_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setxAdsMetaContentType(String xAdsMetaContentType) {
    this.xAdsMetaContentType = xAdsMetaContentType;
  }


  public BatchcompleteuploadObjectRequests xAdsMetaContentDisposition(String xAdsMetaContentDisposition) {
    
    this.xAdsMetaContentDisposition = xAdsMetaContentDisposition;
    return this;
  }

   /**
   * The Content-Disposition value for the uploaded object to record within OSS.
   * @return xAdsMetaContentDisposition
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Content-Disposition value for the uploaded object to record within OSS.")
  @JsonProperty(JSON_PROPERTY_X_ADS_META_CONTENT_DISPOSITION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getxAdsMetaContentDisposition() {
    return xAdsMetaContentDisposition;
  }


  @JsonProperty(JSON_PROPERTY_X_ADS_META_CONTENT_DISPOSITION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setxAdsMetaContentDisposition(String xAdsMetaContentDisposition) {
    this.xAdsMetaContentDisposition = xAdsMetaContentDisposition;
  }


  public BatchcompleteuploadObjectRequests xAdsMetaContentEncoding(String xAdsMetaContentEncoding) {
    
    this.xAdsMetaContentEncoding = xAdsMetaContentEncoding;
    return this;
  }

   /**
   * The Content-Encoding value for the uploaded object to record within OSS.
   * @return xAdsMetaContentEncoding
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Content-Encoding value for the uploaded object to record within OSS.")
  @JsonProperty(JSON_PROPERTY_X_ADS_META_CONTENT_ENCODING)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getxAdsMetaContentEncoding() {
    return xAdsMetaContentEncoding;
  }


  @JsonProperty(JSON_PROPERTY_X_ADS_META_CONTENT_ENCODING)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setxAdsMetaContentEncoding(String xAdsMetaContentEncoding) {
    this.xAdsMetaContentEncoding = xAdsMetaContentEncoding;
  }


  public BatchcompleteuploadObjectRequests xAdsMetaCacheControl(String xAdsMetaCacheControl) {
    
    this.xAdsMetaCacheControl = xAdsMetaCacheControl;
    return this;
  }

   /**
   * The Cache-Control value for the uploaded object to record within OSS.
   * @return xAdsMetaCacheControl
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Cache-Control value for the uploaded object to record within OSS.")
  @JsonProperty(JSON_PROPERTY_X_ADS_META_CACHE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getxAdsMetaCacheControl() {
    return xAdsMetaCacheControl;
  }


  @JsonProperty(JSON_PROPERTY_X_ADS_META_CACHE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setxAdsMetaCacheControl(String xAdsMetaCacheControl) {
    this.xAdsMetaCacheControl = xAdsMetaCacheControl;
  }


  public BatchcompleteuploadObjectRequests xAdsUserDefinedMetadata(String xAdsUserDefinedMetadata) {
    
    this.xAdsUserDefinedMetadata = xAdsUserDefinedMetadata;
    return this;
  }

   /**
   * Custom metadata to be stored with the object, which can be retrieved later on download or when retrieving object details. Must be a JSON object that is less than 100 bytes.

   * @return xAdsUserDefinedMetadata
  **/
  @javax.annotation.Nullable
  @Schema(description = "Custom metadata to be stored with the object, which can be retrieved later on download or when retrieving object details. Must be a JSON object that is less than 100 bytes. ")
  @JsonProperty(JSON_PROPERTY_X_ADS_USER_DEFINED_METADATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getxAdsUserDefinedMetadata() {
    return xAdsUserDefinedMetadata;
  }


  @JsonProperty(JSON_PROPERTY_X_ADS_USER_DEFINED_METADATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setxAdsUserDefinedMetadata(String xAdsUserDefinedMetadata) {
    this.xAdsUserDefinedMetadata = xAdsUserDefinedMetadata;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchcompleteuploadObjectRequests batchcompleteuploadObjectRequests = (BatchcompleteuploadObjectRequests) o;
    return Objects.equals(this.objectKey, batchcompleteuploadObjectRequests.objectKey) &&
        Objects.equals(this.uploadKey, batchcompleteuploadObjectRequests.uploadKey) &&
        Objects.equals(this.size, batchcompleteuploadObjectRequests.size) &&
        Objects.equals(this.eTags, batchcompleteuploadObjectRequests.eTags) &&
        Objects.equals(this.xAdsMetaContentType, batchcompleteuploadObjectRequests.xAdsMetaContentType) &&
        Objects.equals(this.xAdsMetaContentDisposition, batchcompleteuploadObjectRequests.xAdsMetaContentDisposition) &&
        Objects.equals(this.xAdsMetaContentEncoding, batchcompleteuploadObjectRequests.xAdsMetaContentEncoding) &&
        Objects.equals(this.xAdsMetaCacheControl, batchcompleteuploadObjectRequests.xAdsMetaCacheControl) &&
        Objects.equals(this.xAdsUserDefinedMetadata, batchcompleteuploadObjectRequests.xAdsUserDefinedMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectKey, uploadKey, size, eTags, xAdsMetaContentType, xAdsMetaContentDisposition, xAdsMetaContentEncoding, xAdsMetaCacheControl, xAdsUserDefinedMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchcompleteuploadObjectRequests {\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    uploadKey: ").append(toIndentedString(uploadKey)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    eTags: ").append(toIndentedString(eTags)).append("\n");
    sb.append("    xAdsMetaContentType: ").append(toIndentedString(xAdsMetaContentType)).append("\n");
    sb.append("    xAdsMetaContentDisposition: ").append(toIndentedString(xAdsMetaContentDisposition)).append("\n");
    sb.append("    xAdsMetaContentEncoding: ").append(toIndentedString(xAdsMetaContentEncoding)).append("\n");
    sb.append("    xAdsMetaCacheControl: ").append(toIndentedString(xAdsMetaCacheControl)).append("\n");
    sb.append("    xAdsUserDefinedMetadata: ").append(toIndentedString(xAdsUserDefinedMetadata)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

