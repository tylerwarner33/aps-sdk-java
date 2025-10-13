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
import com.autodesk.aps.oss.model.PolicyKey;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * An object containing the properties of a bucket.
 */
@Schema(description = "An object containing the properties of a bucket.")
@JsonPropertyOrder({
  BucketsItems.JSON_PROPERTY_BUCKET_KEY,
  BucketsItems.JSON_PROPERTY_CREATED_DATE,
  BucketsItems.JSON_PROPERTY_POLICY_KEY
})
@JsonTypeName("buckets_items")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BucketsItems {
  public static final String JSON_PROPERTY_BUCKET_KEY = "bucketKey";
  private String bucketKey;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  private Long createdDate;

  public static final String JSON_PROPERTY_POLICY_KEY = "policyKey";
  private PolicyKey policyKey = PolicyKey.TRANSIENT;


  public BucketsItems bucketKey(String bucketKey) {
    
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * Bucket key: An ID that uniquely identifies the bucket.
   * @return bucketKey
  **/
  @Schema(required = true, description = "Bucket key: An ID that uniquely identifies the bucket.")
  @JsonProperty(JSON_PROPERTY_BUCKET_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBucketKey() {
    return bucketKey;
  }


  @JsonProperty(JSON_PROPERTY_BUCKET_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
  }


  public BucketsItems createdDate(Long createdDate) {
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The time the bucket was created, represented as a Unix timestamp.
   * @return createdDate
  **/
  @Schema(required = true, description = "The time the bucket was created, represented as a Unix timestamp.")
  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getCreatedDate() {
    return createdDate;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreatedDate(Long createdDate) {
    this.createdDate = createdDate;
  }


  public BucketsItems policyKey(PolicyKey policyKey) {
    
    this.policyKey = policyKey;
    return this;
  }

   /**
   * Get policyKey
   * @return policyKey
  **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_POLICY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PolicyKey getPolicyKey() {
    return policyKey;
  }


  @JsonProperty(JSON_PROPERTY_POLICY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPolicyKey(PolicyKey policyKey) {
    this.policyKey = policyKey;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BucketsItems bucketsItems = (BucketsItems) o;
    return Objects.equals(this.bucketKey, bucketsItems.bucketKey) &&
        Objects.equals(this.createdDate, bucketsItems.createdDate) &&
        Objects.equals(this.policyKey, bucketsItems.policyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, createdDate, policyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BucketsItems {\n");
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    policyKey: ").append(toIndentedString(policyKey)).append("\n");
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

