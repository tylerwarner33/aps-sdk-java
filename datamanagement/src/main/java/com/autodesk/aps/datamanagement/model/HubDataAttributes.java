/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk's expertise in design and engineering.
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
 * The properties of the hub.
 */
@Schema(description = "The properties of the hub.")
@JsonPropertyOrder({
    HubDataAttributes.JSON_PROPERTY_NAME,
    HubDataAttributes.JSON_PROPERTY_EXTENSION,
    HubDataAttributes.JSON_PROPERTY_REGION
})
@JsonTypeName("HubData_attributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class HubDataAttributes {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private BaseAttributesExtensionObjectWithSchemaLink extension;

  public static final String JSON_PROPERTY_REGION = "region";
  private String region;

  public HubDataAttributes name(String name) {

    this.name = name;
    return this;
  }

  /**
   * A human friendly name to identify the hub.
   * 
   * @return name
   **/
  @javax.annotation.Nullable
  @Schema(description = "A human friendly name to identify the hub.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setName(String name) {
    this.name = name;
  }

  public HubDataAttributes extension(BaseAttributesExtensionObjectWithSchemaLink extension) {

    this.extension = extension;
    return this;
  }

  /**
   * Get extension
   * 
   * @return extension
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public BaseAttributesExtensionObjectWithSchemaLink getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExtension(BaseAttributesExtensionObjectWithSchemaLink extension) {
    this.extension = extension;
  }

  public HubDataAttributes region(String region) {

    this.region = region;
    return this;
  }

  /**
   * Get region
   * 
   * @return region
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getRegion() {
    return region;
  }

  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRegion(String region) {
    this.region = region;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HubDataAttributes hubDataAttributes = (HubDataAttributes) o;
    return Objects.equals(this.name, hubDataAttributes.name) &&
        Objects.equals(this.extension, hubDataAttributes.extension) &&
        Objects.equals(this.region, hubDataAttributes.region);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, extension, region);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HubDataAttributes {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
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
