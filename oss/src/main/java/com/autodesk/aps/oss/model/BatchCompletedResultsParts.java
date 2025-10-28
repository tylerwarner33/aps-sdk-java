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
 * BatchCompletedResultsParts
 */
@JsonPropertyOrder({
  BatchCompletedResultsParts.JSON_PROPERTY_FIRST_PART,
  BatchCompletedResultsParts.JSON_PROPERTY_STATUS,
  BatchCompletedResultsParts.JSON_PROPERTY_SIZE,
  BatchCompletedResultsParts.JSON_PROPERTY_E_TAG
})
@JsonTypeName("batch_completed_results_parts")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BatchCompletedResultsParts {
  public static final String JSON_PROPERTY_FIRST_PART = "firstPart";
  private Integer firstPart;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Status status;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_E_TAG = "eTag";
  private String eTag;


  public BatchCompletedResultsParts firstPart(Integer firstPart) {
    
    this.firstPart = firstPart;
    return this;
  }

   /**
   * The index of the first part in the multipart upload.
   * @return firstPart
  **/
  @javax.annotation.Nullable
  @Schema(description = "The index of the first part in the multipart upload.")
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


  public BatchCompletedResultsParts status(Status status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Status getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(Status status) {
    this.status = status;
  }


  public BatchCompletedResultsParts size(Long size) {
    
    this.size = size;
    return this;
  }

   /**
   * The size of the corresponding part detected in S3.
   * @return size
  **/
  @javax.annotation.Nullable
  @Schema(description = "The size of the corresponding part detected in S3.")
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


  public BatchCompletedResultsParts eTag(String eTag) {
    
    this.eTag = eTag;
    return this;
  }

   /**
   * The eTag of the detected part in S3.
   * @return eTag
  **/
  @javax.annotation.Nullable
  @Schema(description = "The eTag of the detected part in S3.")
  @JsonProperty(JSON_PROPERTY_E_TAG)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String geteTag() {
    return eTag;
  }


  @JsonProperty(JSON_PROPERTY_E_TAG)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void seteTag(String eTag) {
    this.eTag = eTag;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchCompletedResultsParts batchCompletedResultsParts = (BatchCompletedResultsParts) o;
    return Objects.equals(this.firstPart, batchCompletedResultsParts.firstPart) &&
        Objects.equals(this.status, batchCompletedResultsParts.status) &&
        Objects.equals(this.size, batchCompletedResultsParts.size) &&
        Objects.equals(this.eTag, batchCompletedResultsParts.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstPart, status, size, eTag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchCompletedResultsParts {\n");
    sb.append("    firstPart: ").append(toIndentedString(firstPart)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    eTag: ").append(toIndentedString(eTag)).append("\n");
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

