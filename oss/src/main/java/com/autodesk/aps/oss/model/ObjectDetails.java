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
 * Represents an object within a bucket.
 */
@Schema(description = "Represents an object within a bucket.")
@JsonPropertyOrder({
  ObjectDetails.JSON_PROPERTY_BUCKET_KEY,
  ObjectDetails.JSON_PROPERTY_OBJECT_ID,
  ObjectDetails.JSON_PROPERTY_OBJECT_KEY,
  ObjectDetails.JSON_PROPERTY_SHA1,
  ObjectDetails.JSON_PROPERTY_SIZE,
  ObjectDetails.JSON_PROPERTY_CONTENT_TYPE,
  ObjectDetails.JSON_PROPERTY_LOCATION
})
@JsonTypeName("objectDetails")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ObjectDetails {
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


  public ObjectDetails bucketKey(String bucketKey) {
    
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


  public ObjectDetails objectId(String objectId) {
    
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


  public ObjectDetails objectKey(String objectKey) {
    
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


  public ObjectDetails sha1(byte[] sha1) {
    
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


  public ObjectDetails size(Long size) {
    
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


  public ObjectDetails contentType(String contentType) {
    
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


  public ObjectDetails location(String location) {
    
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectDetails objectDetails = (ObjectDetails) o;
    return Objects.equals(this.bucketKey, objectDetails.bucketKey) &&
        Objects.equals(this.objectId, objectDetails.objectId) &&
        Objects.equals(this.objectKey, objectDetails.objectKey) &&
        Arrays.equals(this.sha1, objectDetails.sha1) &&
        Objects.equals(this.size, objectDetails.size) &&
        Objects.equals(this.contentType, objectDetails.contentType) &&
        Objects.equals(this.location, objectDetails.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, objectId, objectKey, Arrays.hashCode(sha1), size, contentType, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectDetails {\n");
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

