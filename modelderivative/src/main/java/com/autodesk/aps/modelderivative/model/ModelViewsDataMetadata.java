/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Model Derivative
 * Use the Model Derivative API to translate designs from one CAD format to another. You can also use this API to extract metadata from a model.
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

package com.autodesk.aps.modelderivative.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * An array of flat JSON objects representing metadata.
 */
@Schema(description = "An array of flat JSON objects representing metadata.")
@JsonPropertyOrder({
    ModelViewsDataMetadata.JSON_PROPERTY_NAME,
    ModelViewsDataMetadata.JSON_PROPERTY_GUID,
    ModelViewsDataMetadata.JSON_PROPERTY_ROLE,
    ModelViewsDataMetadata.JSON_PROPERTY_IS_MASTER_VIEW
})
@JsonTypeName("ModelViews_data_metadata")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ModelViewsDataMetadata {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_ROLE = "role";
  private Role role;

  public static final String JSON_PROPERTY_IS_MASTER_VIEW = "isMasterView";
  private Boolean isMasterView;

  public ModelViewsDataMetadata name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Name of the Model View.
   * 
   * @return name
   **/
  @Schema(required = true, description = "Name of the Model View.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }

  public ModelViewsDataMetadata guid(String guid) {

    this.guid = guid;
    return this;
  }

  /**
   * Unique ID of the Model View.
   * 
   * @return guid
   **/
  @Schema(required = true, description = "Unique ID of the Model View.")
  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGuid() {
    return guid;
  }

  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGuid(String guid) {
    this.guid = guid;
  }

  public ModelViewsDataMetadata role(Role role) {

    this.role = role;
    return this;
  }

  /**
   * Get role
   * 
   * @return role
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Role getRole() {
    return role;
  }

  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRole(Role role) {
    this.role = role;
  }

  public ModelViewsDataMetadata isMasterView(Boolean isMasterView) {

    this.isMasterView = isMasterView;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60;: Model View is a Master View derived from a
   * Revit source design.
   * - &#x60;&#x60;false&#x60;&#x60;: Model View is not a Master View.
   * 
   * @return isMasterView
   **/
  @Schema(required = true, description = "- ``true``: Model View is a Master View derived from a Revit source design. - ``false``: Model View is not a Master View.")
  @JsonProperty(JSON_PROPERTY_IS_MASTER_VIEW)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsMasterView() {
    return isMasterView;
  }

  @JsonProperty(JSON_PROPERTY_IS_MASTER_VIEW)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsMasterView(Boolean isMasterView) {
    this.isMasterView = isMasterView;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelViewsDataMetadata modelViewsDataMetadata = (ModelViewsDataMetadata) o;
    return Objects.equals(this.name, modelViewsDataMetadata.name) &&
        Objects.equals(this.guid, modelViewsDataMetadata.guid) &&
        Objects.equals(this.role, modelViewsDataMetadata.role) &&
        Objects.equals(this.isMasterView, modelViewsDataMetadata.isMasterView);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, guid, role, isMasterView);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelViewsDataMetadata {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    isMasterView: ").append(toIndentedString(isMasterView)).append("\n");
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
