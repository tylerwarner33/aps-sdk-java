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
 * A container of additional properties that extends the default properties of
 * this resource.
 */
@Schema(description = "A container of additional properties that extends the default properties of this resource.")
@JsonPropertyOrder({
    JsonApiRelationshipsRefsDataMetaExtension.JSON_PROPERTY_TYPE,
    JsonApiRelationshipsRefsDataMetaExtension.JSON_PROPERTY_VERSION,
    JsonApiRelationshipsRefsDataMetaExtension.JSON_PROPERTY_DATA
})
@JsonTypeName("json_api_relationships_refs_data_meta_extension")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonApiRelationshipsRefsDataMetaExtension {
  public static final String JSON_PROPERTY_TYPE = "type";
  private ExtensionTypeCoreXref type;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_DATA = "data";
  private JsonApiRelationshipsRefsDataMetaExtensionData data;

  public JsonApiRelationshipsRefsDataMetaExtension type(ExtensionTypeCoreXref type) {

    this.type = type;
    return this;
  }

  /**
   * Get type
   * 
   * @return type
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ExtensionTypeCoreXref getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(ExtensionTypeCoreXref type) {
    this.type = type;
  }

  public JsonApiRelationshipsRefsDataMetaExtension version(String version) {

    this.version = version;
    return this;
  }

  /**
   * The version of the type. The current version is
   * &#x60;&#x60;1.1.0&#x60;&#x60;.
   * 
   * @return version
   **/
  @Schema(required = true, description = "The version of the type. The current version is ``1.1.0``. ")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getVersion() {
    return version;
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVersion(String version) {
    this.version = version;
  }

  public JsonApiRelationshipsRefsDataMetaExtension data(JsonApiRelationshipsRefsDataMetaExtensionData data) {

    this.data = data;
    return this;
  }

  /**
   * Get data
   * 
   * @return data
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsRefsDataMetaExtensionData getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setData(JsonApiRelationshipsRefsDataMetaExtensionData data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiRelationshipsRefsDataMetaExtension jsonApiRelationshipsRefsDataMetaExtension = (JsonApiRelationshipsRefsDataMetaExtension) o;
    return Objects.equals(this.type, jsonApiRelationshipsRefsDataMetaExtension.type) &&
        Objects.equals(this.version, jsonApiRelationshipsRefsDataMetaExtension.version) &&
        Objects.equals(this.data, jsonApiRelationshipsRefsDataMetaExtension.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, version, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiRelationshipsRefsDataMetaExtension {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
