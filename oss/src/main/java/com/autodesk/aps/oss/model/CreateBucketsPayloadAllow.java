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
 * An object that represents the permissions allowed for a bucket.
 */
@Schema(description = "An object that represents the permissions allowed for a bucket.")
@JsonPropertyOrder({
    CreateBucketsPayloadAllow.JSON_PROPERTY_AUTH_ID,
    CreateBucketsPayloadAllow.JSON_PROPERTY_ACCESS
})
@JsonTypeName("create_buckets_payload_allow")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateBucketsPayloadAllow {
  public static final String JSON_PROPERTY_AUTH_ID = "authId";
  private String authId;

  public static final String JSON_PROPERTY_ACCESS = "access";
  private AllowAccess access;

  public CreateBucketsPayloadAllow authId(String authId) {

    this.authId = authId;
    return this;
  }

  /**
   * The Client ID of the application.
   * 
   * @return authId
   **/
  @Schema(required = true, description = "The Client ID of the application.")
  @JsonProperty(JSON_PROPERTY_AUTH_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAuthId() {
    return authId;
  }

  @JsonProperty(JSON_PROPERTY_AUTH_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAuthId(String authId) {
    this.authId = authId;
  }

  public CreateBucketsPayloadAllow access(AllowAccess access) {

    this.access = access;
    return this;
  }

  /**
   * Get access
   * 
   * @return access
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_ACCESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AllowAccess getAccess() {
    return access;
  }

  @JsonProperty(JSON_PROPERTY_ACCESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccess(AllowAccess access) {
    this.access = access;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBucketsPayloadAllow createBucketsPayloadAllow = (CreateBucketsPayloadAllow) o;
    return Objects.equals(this.authId, createBucketsPayloadAllow.authId) &&
        Objects.equals(this.access, createBucketsPayloadAllow.access);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authId, access);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBucketsPayloadAllow {\n");
    sb.append("    authId: ").append(toIndentedString(authId)).append("\n");
    sb.append("    access: ").append(toIndentedString(access)).append("\n");
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
