/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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

package com.autodesk.aps.datamanagement.model;

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
 * A container of the results of the resources
 * that were checked for permission.
 */
@Schema(description = "A container of the results of the resources that were checked for permission.")
@JsonPropertyOrder({
    CheckPermissionAttributesExtensionData.JSON_PROPERTY_PERMISSIONS,
    CheckPermissionAttributesExtensionData.JSON_PROPERTY_REQUIRED_ACTIONS
})
@JsonTypeName("CheckPermission_attributes_extension_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CheckPermissionAttributesExtensionData {
  public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
  private List<CheckPermissionAttributesExtensionDataPermissions> permissions = null;

  public static final String JSON_PROPERTY_REQUIRED_ACTIONS = "requiredActions";
  private List<String> requiredActions = null;

  public CheckPermissionAttributesExtensionData permissions(
      List<CheckPermissionAttributesExtensionDataPermissions> permissions) {

    this.permissions = permissions;
    return this;
  }

  public CheckPermissionAttributesExtensionData addpermissionsItem(
      CheckPermissionAttributesExtensionDataPermissions permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * An array of objects, where each object
   * represents a folder, item, or version that
   * permission was checked for.
   * 
   * @return permissions
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object  represents a folder, item, or version that  permission was checked for.")
  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<CheckPermissionAttributesExtensionDataPermissions> getPermissions() {
    return permissions;
  }

  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPermissions(List<CheckPermissionAttributesExtensionDataPermissions> permissions) {
    this.permissions = permissions;
  }

  public CheckPermissionAttributesExtensionData requiredActions(List<String> requiredActions) {

    this.requiredActions = requiredActions;
    return this;
  }

  public CheckPermissionAttributesExtensionData addrequiredActionsItem(String requiredActionsItem) {
    if (this.requiredActions == null) {
      this.requiredActions = new ArrayList<>();
    }
    this.requiredActions.add(requiredActionsItem);
    return this;
  }

  /**
   * An array of keywords where each keyword
   * is an action that permission was checked
   * for. Possible values:
   * 
   * - &#x60;&#x60;read&#x60;&#x60; - Download and view specified resource.
   * - &#x60;&#x60;view&#x60;&#x60; - View specified resource without downloading.
   * - &#x60;&#x60;download&#x60;&#x60; - Download and view specified resource.
   * - &#x60;&#x60;collaborate&#x60;&#x60; - Add comments for the specified
   * resource.
   * - &#x60;&#x60;write&#x60;&#x60; - Write to the specified resource.
   * - &#x60;&#x60;upload&#x60;&#x60; - Upload to the specified resource.
   * - &#x60;&#x60;updateMetaData&#x60;&#x60; - Update metadata of the specified
   * resource.
   * - &#x60;&#x60;create&#x60;&#x60; - Write and upload to the specified
   * resource.
   * - &#x60;&#x60;delete&#x60;&#x60; - Delete the specified resource.
   * - &#x60;&#x60;admin&#x60;&#x60; - Perform administrative operations on
   * specified resource.
   * - &#x60;&#x60;share&#x60;&#x60;- Share the specified resource.
   * 
   * @return requiredActions
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of keywords where each keyword  is an action that permission was checked for. Possible values:  - ``read`` - Download and view specified resource. - ``view`` - View specified resource without downloading. - ``download`` - Download and view specified resource. - ``collaborate`` - Add comments for the specified resource. - ``write`` - Write to the specified resource. - ``upload`` - Upload to the specified resource. - ``updateMetaData`` - Update metadata of the specified resource. - ``create`` - Write and upload to the specified resource. - ``delete`` - Delete the specified resource. - ``admin`` - Perform administrative operations on specified resource. - ``share``- Share the specified resource.")
  @JsonProperty(JSON_PROPERTY_REQUIRED_ACTIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getRequiredActions() {
    return requiredActions;
  }

  @JsonProperty(JSON_PROPERTY_REQUIRED_ACTIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRequiredActions(List<String> requiredActions) {
    this.requiredActions = requiredActions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckPermissionAttributesExtensionData checkPermissionAttributesExtensionData = (CheckPermissionAttributesExtensionData) o;
    return Objects.equals(this.permissions, checkPermissionAttributesExtensionData.permissions) &&
        Objects.equals(this.requiredActions, checkPermissionAttributesExtensionData.requiredActions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissions, requiredActions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckPermissionAttributesExtensionData {\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    requiredActions: ").append(toIndentedString(requiredActions)).append("\n");
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
