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
import com.autodesk.aps.oss.model.Permission;
import com.autodesk.aps.oss.model.PolicyKey;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * An object representing a bucket.
 */
@Schema(description = "An object representing a bucket.")
@JsonPropertyOrder({
  Bucket.JSON_PROPERTY_BUCKET_KEY,
  Bucket.JSON_PROPERTY_BUCKET_OWNER,
  Bucket.JSON_PROPERTY_CREATED_DATE,
  Bucket.JSON_PROPERTY_PERMISSIONS,
  Bucket.JSON_PROPERTY_POLICY_KEY
})
@JsonTypeName("bucket")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Bucket {
  public static final String JSON_PROPERTY_BUCKET_KEY = "bucketKey";
  private String bucketKey;

  public static final String JSON_PROPERTY_BUCKET_OWNER = "bucketOwner";
  private String bucketOwner;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  private Long createdDate;

  public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
  private List<Permission> permissions = null;

  public static final String JSON_PROPERTY_POLICY_KEY = "policyKey";
  private PolicyKey policyKey = PolicyKey.TRANSIENT;


  public Bucket bucketKey(String bucketKey) {
    
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * Bucket key: An ID that uniquely identifies the bucket.
   * @return bucketKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "Bucket key: An ID that uniquely identifies the bucket.")
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


  public Bucket bucketOwner(String bucketOwner) {
    
    this.bucketOwner = bucketOwner;
    return this;
  }

   /**
   * The Client ID of the application that owns the bucket.
   * @return bucketOwner
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Client ID of the application that owns the bucket.")
  @JsonProperty(JSON_PROPERTY_BUCKET_OWNER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getBucketOwner() {
    return bucketOwner;
  }


  @JsonProperty(JSON_PROPERTY_BUCKET_OWNER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setBucketOwner(String bucketOwner) {
    this.bucketOwner = bucketOwner;
  }


  public Bucket createdDate(Long createdDate) {
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The time the bucket was created, represented as a Unix timestamp.
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @Schema(description = "The time the bucket was created, represented as a Unix timestamp.")
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


  public Bucket permissions(List<Permission> permissions) {
    
    this.permissions = permissions;
    return this;
  }

  public Bucket addpermissionsItem(Permission permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

   /**
   * An array of objects, where each object represents an application that can access the bucket.
   * @return permissions
  **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object represents an application that can access the bucket.")
  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Permission> getPermissions() {
    return permissions;
  }


  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }


  public Bucket policyKey(PolicyKey policyKey) {
    
    this.policyKey = policyKey;
    return this;
  }

   /**
   * Get policyKey
   * @return policyKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_POLICY_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public PolicyKey getPolicyKey() {
    return policyKey;
  }


  @JsonProperty(JSON_PROPERTY_POLICY_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
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
    Bucket bucket = (Bucket) o;
    return Objects.equals(this.bucketKey, bucket.bucketKey) &&
        Objects.equals(this.bucketOwner, bucket.bucketOwner) &&
        Objects.equals(this.createdDate, bucket.createdDate) &&
        Objects.equals(this.permissions, bucket.permissions) &&
        Objects.equals(this.policyKey, bucket.policyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, bucketOwner, createdDate, permissions, policyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bucket {\n");
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    bucketOwner: ").append(toIndentedString(bucketOwner)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

