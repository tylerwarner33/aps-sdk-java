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
import com.autodesk.aps.oss.model.BatchCompletedResultsParts;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * The results returned by the Complete Batch Upload to S3 Signed URLs operation.
 */
@Schema(description = "The results returned by the Complete Batch Upload to S3 Signed URLs operation.")
@JsonPropertyOrder({
  BatchCompletedResults.JSON_PROPERTY_STATUS,
  BatchCompletedResults.JSON_PROPERTY_BUCKET_KEY,
  BatchCompletedResults.JSON_PROPERTY_OBJECT_KEY,
  BatchCompletedResults.JSON_PROPERTY_OBJECT_ID,
  BatchCompletedResults.JSON_PROPERTY_SIZE,
  BatchCompletedResults.JSON_PROPERTY_CONTENT_TYPE,
  BatchCompletedResults.JSON_PROPERTY_CONTENT_DISPOSITION,
  BatchCompletedResults.JSON_PROPERTY_CONTENT_ENCODING,
  BatchCompletedResults.JSON_PROPERTY_CACHE_CONTROL,
  BatchCompletedResults.JSON_PROPERTY_PARTS,
  BatchCompletedResults.JSON_PROPERTY_REASON
})
@JsonTypeName("batch_completed_results")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BatchCompletedResults {
  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_BUCKET_KEY = "bucketKey";
  private String bucketKey;

  public static final String JSON_PROPERTY_OBJECT_KEY = "objectKey";
  private String objectKey;

  public static final String JSON_PROPERTY_OBJECT_ID = "objectId";
  private String objectId;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_CONTENT_TYPE = "contentType";
  private String contentType;

  public static final String JSON_PROPERTY_CONTENT_DISPOSITION = "contentDisposition";
  private String contentDisposition;

  public static final String JSON_PROPERTY_CONTENT_ENCODING = "contentEncoding";
  private String contentEncoding;

  public static final String JSON_PROPERTY_CACHE_CONTROL = "cacheControl";
  private String cacheControl;

  public static final String JSON_PROPERTY_PARTS = "parts";
  private List<BatchCompletedResultsParts> parts = null;

  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;


  public BatchCompletedResults status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * If this attribute is not returned, completion has succeeded. If the value of this attribute is &quot;error&quot;, completion failed.&#39;

   * @return status
  **/
  @javax.annotation.Nullable
  @Schema(description = "If this attribute is not returned, completion has succeeded. If the value of this attribute is \"error\", completion failed.' ")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(String status) {
    this.status = status;
  }


  public BatchCompletedResults bucketKey(String bucketKey) {
    
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * The bucket key of the bucket the object was uploaded to.
   * @return bucketKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "The bucket key of the bucket the object was uploaded to.")
  @JsonProperty(JSON_PROPERTY_BUCKET_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getBucketKey() {
    return bucketKey;
  }


  @JsonProperty(JSON_PROPERTY_BUCKET_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setBucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
  }


  public BatchCompletedResults objectKey(String objectKey) {
    
    this.objectKey = objectKey;
    return this;
  }

   /**
   * The URL-encoded human friendly name of the object.
   * @return objectKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "The URL-encoded human friendly name of the object.")
  @JsonProperty(JSON_PROPERTY_OBJECT_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getObjectKey() {
    return objectKey;
  }


  @JsonProperty(JSON_PROPERTY_OBJECT_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }


  public BatchCompletedResults objectId(String objectId) {
    
    this.objectId = objectId;
    return this;
  }

   /**
   * An identifier (URN) that uniquely and persistently identifies the object.
   * @return objectId
  **/
  @javax.annotation.Nullable
  @Schema(description = "An identifier (URN) that uniquely and persistently identifies the object.")
  @JsonProperty(JSON_PROPERTY_OBJECT_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getObjectId() {
    return objectId;
  }


  @JsonProperty(JSON_PROPERTY_OBJECT_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }


  public BatchCompletedResults size(Long size) {
    
    this.size = size;
    return this;
  }

   /**
   * The total amount of storage space occupied by the object, in bytes.
   * @return size
  **/
  @javax.annotation.Nullable
  @Schema(description = "The total amount of storage space occupied by the object, in bytes.")
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


  public BatchCompletedResults contentType(String contentType) {
    
    this.contentType = contentType;
    return this;
  }

   /**
   * The format of the data stored within the object, expressed as a MIME type. This attribute is returned only if it was specified when the object was uploaded.
   * @return contentType
  **/
  @javax.annotation.Nullable
  @Schema(description = "The format of the data stored within the object, expressed as a MIME type. This attribute is returned only if it was specified when the object was uploaded.")
  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getContentType() {
    return contentType;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }


  public BatchCompletedResults contentDisposition(String contentDisposition) {
    
    this.contentDisposition = contentDisposition;
    return this;
  }

   /**
   * The Content-Disposition value for the uploaded object as recorded within OSS. This attribute is returned only if it was specified when the object was uploaded.
   * @return contentDisposition
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Content-Disposition value for the uploaded object as recorded within OSS. This attribute is returned only if it was specified when the object was uploaded.")
  @JsonProperty(JSON_PROPERTY_CONTENT_DISPOSITION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getContentDisposition() {
    return contentDisposition;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT_DISPOSITION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setContentDisposition(String contentDisposition) {
    this.contentDisposition = contentDisposition;
  }


  public BatchCompletedResults contentEncoding(String contentEncoding) {
    
    this.contentEncoding = contentEncoding;
    return this;
  }

   /**
   * The Content-Encoding value for the uploaded object as recorded within OSS. This attribute is returned only if it was specified when the object was uploaded.
   * @return contentEncoding
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Content-Encoding value for the uploaded object as recorded within OSS. This attribute is returned only if it was specified when the object was uploaded.")
  @JsonProperty(JSON_PROPERTY_CONTENT_ENCODING)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getContentEncoding() {
    return contentEncoding;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT_ENCODING)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setContentEncoding(String contentEncoding) {
    this.contentEncoding = contentEncoding;
  }


  public BatchCompletedResults cacheControl(String cacheControl) {
    
    this.cacheControl = cacheControl;
    return this;
  }

   /**
   * The Cache-Control value for the uploaded object as recorded within OSS. This attribute is returned only if it was specified when the object was uploaded.
   * @return cacheControl
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Cache-Control value for the uploaded object as recorded within OSS. This attribute is returned only if it was specified when the object was uploaded.")
  @JsonProperty(JSON_PROPERTY_CACHE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCacheControl() {
    return cacheControl;
  }


  @JsonProperty(JSON_PROPERTY_CACHE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCacheControl(String cacheControl) {
    this.cacheControl = cacheControl;
  }


  public BatchCompletedResults parts(List<BatchCompletedResultsParts> parts) {
    
    this.parts = parts;
    return this;
  }

  public BatchCompletedResults addpartsItem(BatchCompletedResultsParts partsItem) {
    if (this.parts == null) {
      this.parts = new ArrayList<>();
    }
    this.parts.add(partsItem);
    return this;
  }

   /**
   * An array containing the status of each part, indicating any issues with eTag or size mismatch issues.
   * @return parts
  **/
  @javax.annotation.Nullable
  @Schema(description = "An array containing the status of each part, indicating any issues with eTag or size mismatch issues.")
  @JsonProperty(JSON_PROPERTY_PARTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<BatchCompletedResultsParts> getParts() {
    return parts;
  }


  @JsonProperty(JSON_PROPERTY_PARTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setParts(List<BatchCompletedResultsParts> parts) {
    this.parts = parts;
  }


  public BatchCompletedResults reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * The reason for the failure, if the status is &#x60;&#x60;error&#x60;&#x60;.
   * @return reason
  **/
  @javax.annotation.Nullable
  @Schema(description = "The reason for the failure, if the status is ``error``.")
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getReason() {
    return reason;
  }


  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchCompletedResults batchCompletedResults = (BatchCompletedResults) o;
    return Objects.equals(this.status, batchCompletedResults.status) &&
        Objects.equals(this.bucketKey, batchCompletedResults.bucketKey) &&
        Objects.equals(this.objectKey, batchCompletedResults.objectKey) &&
        Objects.equals(this.objectId, batchCompletedResults.objectId) &&
        Objects.equals(this.size, batchCompletedResults.size) &&
        Objects.equals(this.contentType, batchCompletedResults.contentType) &&
        Objects.equals(this.contentDisposition, batchCompletedResults.contentDisposition) &&
        Objects.equals(this.contentEncoding, batchCompletedResults.contentEncoding) &&
        Objects.equals(this.cacheControl, batchCompletedResults.cacheControl) &&
        Objects.equals(this.parts, batchCompletedResults.parts) &&
        Objects.equals(this.reason, batchCompletedResults.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, bucketKey, objectKey, objectId, size, contentType, contentDisposition, contentEncoding, cacheControl, parts, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchCompletedResults {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    contentDisposition: ").append(toIndentedString(contentDisposition)).append("\n");
    sb.append("    contentEncoding: ").append(toIndentedString(contentEncoding)).append("\n");
    sb.append("    cacheControl: ").append(toIndentedString(cacheControl)).append("\n");
    sb.append("    parts: ").append(toIndentedString(parts)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

