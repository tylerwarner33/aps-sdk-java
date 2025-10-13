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
 * A container of the attributes to be updated.
 */
@Schema(description = "A container of the attributes to be updated.")
@JsonPropertyOrder({
    ModifyItemPayloadDataAttributes.JSON_PROPERTY_DISPLAY_NAME
})
@JsonTypeName("ModifyItemPayload_data_attributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ModifyItemPayloadDataAttributes {
  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public ModifyItemPayloadDataAttributes displayName(String displayName) {

    this.displayName = displayName;
    return this;
  }

  /**
   * A human friendly name to identify an item.
   ** 
   * Note:** For BIM 360 projects this attribute is reserved for future releases
   * and should not be used. For such items use a version&#39;s
   * &#x60;&#x60;attributes.name&#x60;&#x60; as the item&#39;s name.
   * 
   * @return displayName
   **/
  @javax.annotation.Nullable
  @Schema(description = "A human friendly name to identify an item.   **Note:** For BIM 360 projects this attribute is reserved for future releases and should not be used. For such items use a version's ``attributes.name`` as the item's name. ")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyItemPayloadDataAttributes modifyItemPayloadDataAttributes = (ModifyItemPayloadDataAttributes) o;
    return Objects.equals(this.displayName, modifyItemPayloadDataAttributes.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyItemPayloadDataAttributes {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
