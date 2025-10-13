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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * An object containing key value pairs, where
 * the key represents the type of permission
 * that was checked and the value is &#x60;&#x60;true&#x60;&#x60;
 * if the user has permission.
 */
@Schema(description = "An object containing key value pairs, where  the key represents the type of permission  that was checked and the value is ``true``  if the user has permission.")
@JsonPropertyOrder({
    CheckPermissionAttributesExtensionDataPermissionsDetails.JSON_PROPERTY_CREATE,
    CheckPermissionAttributesExtensionDataPermissionsDetails.JSON_PROPERTY_DOWNLOAD,
    CheckPermissionAttributesExtensionDataPermissionsDetails.JSON_PROPERTY_VIEW
})
@JsonTypeName("CheckPermission_attributes_extension_data_permissions_details")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CheckPermissionAttributesExtensionDataPermissionsDetails {
  public static final String JSON_PROPERTY_CREATE = "create";
  private Boolean create;

  public static final String JSON_PROPERTY_DOWNLOAD = "download";
  private Boolean download;

  public static final String JSON_PROPERTY_VIEW = "view";
  private Boolean view;

  public CheckPermissionAttributesExtensionDataPermissionsDetails create(Boolean create) {

    this.create = create;
    return this;
  }

  /**
   * Get create
   * 
   * @return create
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CREATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getCreate() {
    return create;
  }

  @JsonProperty(JSON_PROPERTY_CREATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreate(Boolean create) {
    this.create = create;
  }

  public CheckPermissionAttributesExtensionDataPermissionsDetails download(Boolean download) {

    this.download = download;
    return this;
  }

  /**
   * Get download
   * 
   * @return download
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DOWNLOAD)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getDownload() {
    return download;
  }

  @JsonProperty(JSON_PROPERTY_DOWNLOAD)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDownload(Boolean download) {
    this.download = download;
  }

  public CheckPermissionAttributesExtensionDataPermissionsDetails view(Boolean view) {

    this.view = view;
    return this;
  }

  /**
   * Get view
   * 
   * @return view
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_VIEW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getView() {
    return view;
  }

  @JsonProperty(JSON_PROPERTY_VIEW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setView(Boolean view) {
    this.view = view;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckPermissionAttributesExtensionDataPermissionsDetails checkPermissionAttributesExtensionDataPermissionsDetails = (CheckPermissionAttributesExtensionDataPermissionsDetails) o;
    return Objects.equals(this.create, checkPermissionAttributesExtensionDataPermissionsDetails.create) &&
        Objects.equals(this.download, checkPermissionAttributesExtensionDataPermissionsDetails.download) &&
        Objects.equals(this.view, checkPermissionAttributesExtensionDataPermissionsDetails.view);
  }

  @Override
  public int hashCode() {
    return Objects.hash(create, download, view);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckPermissionAttributesExtensionDataPermissionsDetails {\n");
    sb.append("    create: ").append(toIndentedString(create)).append("\n");
    sb.append("    download: ").append(toIndentedString(download)).append("\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
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
