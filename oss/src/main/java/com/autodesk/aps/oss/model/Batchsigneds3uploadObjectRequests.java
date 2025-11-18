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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Batchsigneds3uploadObjectRequests
 */
@JsonPropertyOrder({
    Batchsigneds3uploadObjectRequests.JSON_PROPERTY_OBJECT_KEY,
    Batchsigneds3uploadObjectRequests.JSON_PROPERTY_FIRST_PART,
    Batchsigneds3uploadObjectRequests.JSON_PROPERTY_PARTS,
    Batchsigneds3uploadObjectRequests.JSON_PROPERTY_UPLOAD_KEY
})
@JsonTypeName("batchsigneds3upload_object_requests")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Batchsigneds3uploadObjectRequests {
  public static final String JSON_PROPERTY_OBJECT_KEY = "objectKey";
  private String objectKey;

  public static final String JSON_PROPERTY_FIRST_PART = "firstPart";
  private Integer firstPart;

  public static final String JSON_PROPERTY_PARTS = "parts";
  private Integer parts;

  public static final String JSON_PROPERTY_UPLOAD_KEY = "uploadKey";
  private String uploadKey;

  public Batchsigneds3uploadObjectRequests objectKey(String objectKey) {

    this.objectKey = objectKey;
    return this;
  }

  /**
   * A URL-encoded human friendly name of the object to upload.
   * 
   * @return objectKey
   **/
  @Schema(required = true, description = "A URL-encoded human friendly name of the object to upload.")
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

  public Batchsigneds3uploadObjectRequests firstPart(Integer firstPart) {

    this.firstPart = firstPart;
    return this;
  }

  /**
   * The index of first chunk to be uploaded.
   * 
   * @return firstPart
   **/
  @javax.annotation.Nullable
  @Schema(description = "The index of first chunk to be uploaded.")
  @JsonProperty(JSON_PROPERTY_FIRST_PART)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getFirstPart() {
    return firstPart;
  }

  @JsonProperty(JSON_PROPERTY_FIRST_PART)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFirstPart(Integer firstPart) {
    this.firstPart = firstPart;
  }

  public Batchsigneds3uploadObjectRequests parts(Integer parts) {

    this.parts = parts;
    return this;
  }

  /**
   * The number of parts you intend to chunk the object for uploading. OSS will
   * return that many signed URLs, one URL for each chunk. If you do not specify a
   * value you&#39;ll get only one URL to upload the entire object.
   * 
   * @return parts
   **/
  @javax.annotation.Nullable
  @Schema(description = "The number of parts you intend to chunk the object for uploading. OSS will return that many signed URLs, one URL for each chunk. If you do not specify a value you'll get only one URL to upload the entire object.")
  @JsonProperty(JSON_PROPERTY_PARTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getParts() {
    return parts;
  }

  @JsonProperty(JSON_PROPERTY_PARTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setParts(Integer parts) {
    this.parts = parts;
  }

  public Batchsigneds3uploadObjectRequests uploadKey(String uploadKey) {

    this.uploadKey = uploadKey;
    return this;
  }

  /**
   * The &#x60;&#x60;uploadKey&#x60;&#x60; of a previously-initiated upload, in
   * order to request more chunk upload URLs for the same upload. If you do not
   * specify a value, OSS will initiate a new upload entirely.
   * 
   * @return uploadKey
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ``uploadKey`` of a previously-initiated upload, in order to request more chunk upload URLs for the same upload. If you do not specify a value, OSS will initiate a new upload entirely.")
  @JsonProperty(JSON_PROPERTY_UPLOAD_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUploadKey() {
    return uploadKey;
  }

  @JsonProperty(JSON_PROPERTY_UPLOAD_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUploadKey(String uploadKey) {
    this.uploadKey = uploadKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Batchsigneds3uploadObjectRequests batchsigneds3uploadObjectRequests = (Batchsigneds3uploadObjectRequests) o;
    return Objects.equals(this.objectKey, batchsigneds3uploadObjectRequests.objectKey) &&
        Objects.equals(this.firstPart, batchsigneds3uploadObjectRequests.firstPart) &&
        Objects.equals(this.parts, batchsigneds3uploadObjectRequests.parts) &&
        Objects.equals(this.uploadKey, batchsigneds3uploadObjectRequests.uploadKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectKey, firstPart, parts, uploadKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Batchsigneds3uploadObjectRequests {\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    firstPart: ").append(toIndentedString(firstPart)).append("\n");
    sb.append("    parts: ").append(toIndentedString(parts)).append("\n");
    sb.append("    uploadKey: ").append(toIndentedString(uploadKey)).append("\n");
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
