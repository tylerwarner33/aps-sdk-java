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
 * An object representing the permissions for accessing a bucket.
 */
@Schema(description = "An object representing the permissions for accessing a bucket.")
@JsonPropertyOrder({
    Permission.JSON_PROPERTY_AUTH_ID,
    Permission.JSON_PROPERTY_ACCESS
})
@JsonTypeName("Permission")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Permission {
  public static final String JSON_PROPERTY_AUTH_ID = "authId";
  private String authId;

  public static final String JSON_PROPERTY_ACCESS = "access";
  private PermissionAccess access;

  public Permission authId(String authId) {

    this.authId = authId;
    return this;
  }

  /**
   * The Client ID of the application.
   * 
   * @return authId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The Client ID of the application.")
  @JsonProperty(JSON_PROPERTY_AUTH_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getAuthId() {
    return authId;
  }

  @JsonProperty(JSON_PROPERTY_AUTH_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAuthId(String authId) {
    this.authId = authId;
  }

  public Permission access(PermissionAccess access) {

    this.access = access;
    return this;
  }

  /**
   * Get access
   * 
   * @return access
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ACCESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public PermissionAccess getAccess() {
    return access;
  }

  @JsonProperty(JSON_PROPERTY_ACCESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAccess(PermissionAccess access) {
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
    Permission permission = (Permission) o;
    return Objects.equals(this.authId, permission.authId) &&
        Objects.equals(this.access, permission.access);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authId, access);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Permission {\n");
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
