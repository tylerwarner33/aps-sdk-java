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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * Represents detailed information about an object within a bucket.
 */
@Schema(description = "Represents detailed information about an object within a bucket.")
@JsonPropertyOrder({
  ObjectFullDetails.JSON_PROPERTY_BUCKET_KEY,
  ObjectFullDetails.JSON_PROPERTY_OBJECT_ID,
  ObjectFullDetails.JSON_PROPERTY_OBJECT_KEY,
  ObjectFullDetails.JSON_PROPERTY_SHA1,
  ObjectFullDetails.JSON_PROPERTY_SIZE,
  ObjectFullDetails.JSON_PROPERTY_CONTENT_TYPE,
  ObjectFullDetails.JSON_PROPERTY_LOCATION,
  ObjectFullDetails.JSON_PROPERTY_CREATED_DATE,
  ObjectFullDetails.JSON_PROPERTY_LAST_ACCESSED_DATE,
  ObjectFullDetails.JSON_PROPERTY_LAST_MODIFIED_DATE,
  ObjectFullDetails.JSON_PROPERTY_USER_DEFINED_METADATA
})
@JsonTypeName("objectFullDetails")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ObjectFullDetails {
  public static final String JSON_PROPERTY_BUCKET_KEY = "bucketKey";
  private String bucketKey;

  public static final String JSON_PROPERTY_OBJECT_ID = "objectId";
  private String objectId;

  public static final String JSON_PROPERTY_OBJECT_KEY = "objectKey";
  private String objectKey;

  public static final String JSON_PROPERTY_SHA1 = "sha1";
  private byte[] sha1;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_CONTENT_TYPE = "contentType";
  private String contentType;

  public static final String JSON_PROPERTY_LOCATION = "location";
  private String location;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  private Long createdDate;

  public static final String JSON_PROPERTY_LAST_ACCESSED_DATE = "lastAccessedDate";
  private Long lastAccessedDate;

  public static final String JSON_PROPERTY_LAST_MODIFIED_DATE = "lastModifiedDate";
  private Long lastModifiedDate;

  public static final String JSON_PROPERTY_USER_DEFINED_METADATA = "userDefinedMetadata";
  private String userDefinedMetadata;


  public ObjectFullDetails bucketKey(String bucketKey) {
    
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * The bucket key of the bucket that contains the object.
   * @return bucketKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "The bucket key of the bucket that contains the object.")
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


  public ObjectFullDetails objectId(String objectId) {
    
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


  public ObjectFullDetails objectKey(String objectKey) {
    
    this.objectKey = objectKey;
    return this;
  }

   /**
   * A URL-encoded human friendly name to identify the object.
   * @return objectKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "A URL-encoded human friendly name to identify the object.")
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


  public ObjectFullDetails sha1(byte[] sha1) {
    
    this.sha1 = sha1;
    return this;
  }

   /**
   * A hash value computed from the data of the object.
   * @return sha1
  **/
  @javax.annotation.Nullable
  @Schema(description = "A hash value computed from the data of the object.")
  @JsonProperty(JSON_PROPERTY_SHA1)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public byte[] getSha1() {
    return sha1;
  }


  @JsonProperty(JSON_PROPERTY_SHA1)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSha1(byte[] sha1) {
    this.sha1 = sha1;
  }


  public ObjectFullDetails size(Long size) {
    
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


  public ObjectFullDetails contentType(String contentType) {
    
    this.contentType = contentType;
    return this;
  }

   /**
   * The format of the data stored within the object, expressed as a MIME type.
   * @return contentType
  **/
  @javax.annotation.Nullable
  @Schema(description = "The format of the data stored within the object, expressed as a MIME type.")
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


  public ObjectFullDetails location(String location) {
    
    this.location = location;
    return this;
  }

   /**
   * A URL that points to the actual location of the object.
   * @return location
  **/
  @javax.annotation.Nullable
  @Schema(description = "A URL that points to the actual location of the object.")
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLocation() {
    return location;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLocation(String location) {
    this.location = location;
  }


  public ObjectFullDetails createdDate(Long createdDate) {
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The time the object was created, represented as a Unix timestamp. Only returned if explicitly requested using the &#x60;&#x60;with&#x60;&#x60; query string parameter.
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @Schema(description = "The time the object was created, represented as a Unix timestamp. Only returned if explicitly requested using the ``with`` query string parameter.")
  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getCreatedDate() {
    return createdDate;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatedDate(Long createdDate) {
    this.createdDate = createdDate;
  }


  public ObjectFullDetails lastAccessedDate(Long lastAccessedDate) {
    
    this.lastAccessedDate = lastAccessedDate;
    return this;
  }

   /**
   * The time the object was last accessed, represented as a Unix timestamp. Only returned if explicitly requested using the &#x60;&#x60;with&#x60;&#x60; query string parameter.
   * @return lastAccessedDate
  **/
  @javax.annotation.Nullable
  @Schema(description = "The time the object was last accessed, represented as a Unix timestamp. Only returned if explicitly requested using the ``with`` query string parameter.")
  @JsonProperty(JSON_PROPERTY_LAST_ACCESSED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getLastAccessedDate() {
    return lastAccessedDate;
  }


  @JsonProperty(JSON_PROPERTY_LAST_ACCESSED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLastAccessedDate(Long lastAccessedDate) {
    this.lastAccessedDate = lastAccessedDate;
  }


  public ObjectFullDetails lastModifiedDate(Long lastModifiedDate) {
    
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

   /**
   * The time the object was most recently modified, represented as a Unix timestamp. Only returned if explicitly requested using the &#x60;&#x60;with&#x60;&#x60; query string parameter.
   * @return lastModifiedDate
  **/
  @javax.annotation.Nullable
  @Schema(description = "The time the object was most recently modified, represented as a Unix timestamp. Only returned if explicitly requested using the ``with`` query string parameter.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getLastModifiedDate() {
    return lastModifiedDate;
  }


  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLastModifiedDate(Long lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }


  public ObjectFullDetails userDefinedMetadata(String userDefinedMetadata) {
    
    this.userDefinedMetadata = userDefinedMetadata;
    return this;
  }

   /**
   * Any custom metadata, if available. Only returned if explicitly requested for using the &#x60;&#x60;with&#x60;&#x60; query string parameter.
   * @return userDefinedMetadata
  **/
  @javax.annotation.Nullable
  @Schema(description = "Any custom metadata, if available. Only returned if explicitly requested for using the ``with`` query string parameter.")
  @JsonProperty(JSON_PROPERTY_USER_DEFINED_METADATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUserDefinedMetadata() {
    return userDefinedMetadata;
  }


  @JsonProperty(JSON_PROPERTY_USER_DEFINED_METADATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUserDefinedMetadata(String userDefinedMetadata) {
    this.userDefinedMetadata = userDefinedMetadata;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectFullDetails objectFullDetails = (ObjectFullDetails) o;
    return Objects.equals(this.bucketKey, objectFullDetails.bucketKey) &&
        Objects.equals(this.objectId, objectFullDetails.objectId) &&
        Objects.equals(this.objectKey, objectFullDetails.objectKey) &&
        Arrays.equals(this.sha1, objectFullDetails.sha1) &&
        Objects.equals(this.size, objectFullDetails.size) &&
        Objects.equals(this.contentType, objectFullDetails.contentType) &&
        Objects.equals(this.location, objectFullDetails.location) &&
        Objects.equals(this.createdDate, objectFullDetails.createdDate) &&
        Objects.equals(this.lastAccessedDate, objectFullDetails.lastAccessedDate) &&
        Objects.equals(this.lastModifiedDate, objectFullDetails.lastModifiedDate) &&
        Objects.equals(this.userDefinedMetadata, objectFullDetails.userDefinedMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, objectId, objectKey, Arrays.hashCode(sha1), size, contentType, location, createdDate, lastAccessedDate, lastModifiedDate, userDefinedMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectFullDetails {\n");
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastAccessedDate: ").append(toIndentedString(lastAccessedDate)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
    sb.append("    userDefinedMetadata: ").append(toIndentedString(userDefinedMetadata)).append("\n");
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

