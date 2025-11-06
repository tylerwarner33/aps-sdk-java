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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The request payload for the Create Bucket operation.
 */
@Schema(description = "The request payload for the Create Bucket operation.")
@JsonPropertyOrder({
    CreateBucketsPayload.JSON_PROPERTY_BUCKET_KEY,
    CreateBucketsPayload.JSON_PROPERTY_ALLOW,
    CreateBucketsPayload.JSON_PROPERTY_POLICY_KEY
})
@JsonTypeName("create_buckets_payload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateBucketsPayload {
  public static final String JSON_PROPERTY_BUCKET_KEY = "bucketKey";
  private String bucketKey;

  public static final String JSON_PROPERTY_ALLOW = "allow";
  private List<CreateBucketsPayloadAllow> allow = null;

  public static final String JSON_PROPERTY_POLICY_KEY = "policyKey";
  private PolicyKey policyKey = PolicyKey.TRANSIENT;

  public CreateBucketsPayload bucketKey(String bucketKey) {

    this.bucketKey = bucketKey;
    return this;
  }

  /**
   * Bucket key: A unique name you assign to a bucket. Bucket keys must be
   * globally unique across all applications and regions. They must consist of
   * only lower case characters, numbers 0-9, and underscores (_).
   ** 
   * Note:** You cannot change a bucket key once the bucket is created.
   * 
   * @return bucketKey
   **/
  @Schema(required = true, description = "Bucket key: A unique name you assign to a bucket. Bucket keys must be globally unique across all applications and regions. They must consist of only lower case characters, numbers 0-9, and underscores (_).  **Note:** You cannot change a bucket key once the bucket is created. ")
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

  public CreateBucketsPayload allow(List<CreateBucketsPayloadAllow> allow) {

    this.allow = allow;
    return this;
  }

  public CreateBucketsPayload addallowItem(CreateBucketsPayloadAllow allowItem) {
    if (this.allow == null) {
      this.allow = new ArrayList<>();
    }
    this.allow.add(allowItem);
    return this;
  }

  /**
   * An array of objects, where each object represents an application that can
   * access the bucket.
   * 
   * @return allow
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object represents an application that can access the bucket.")
  @JsonProperty(JSON_PROPERTY_ALLOW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<CreateBucketsPayloadAllow> getAllow() {
    return allow;
  }

  @JsonProperty(JSON_PROPERTY_ALLOW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAllow(List<CreateBucketsPayloadAllow> allow) {
    this.allow = allow;
  }

  public CreateBucketsPayload policyKey(PolicyKey policyKey) {

    this.policyKey = policyKey;
    return this;
  }

  /**
   * Get policyKey
   * 
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
    CreateBucketsPayload createBucketsPayload = (CreateBucketsPayload) o;
    return Objects.equals(this.bucketKey, createBucketsPayload.bucketKey) &&
        Objects.equals(this.allow, createBucketsPayload.allow) &&
        Objects.equals(this.policyKey, createBucketsPayload.policyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, allow, policyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBucketsPayload {\n");
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    allow: ").append(toIndentedString(allow)).append("\n");
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
