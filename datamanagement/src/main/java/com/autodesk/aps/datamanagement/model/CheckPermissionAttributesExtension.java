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
 * An object that contains properties
 * specific to the CheckPermissions command,
 * extending the default properties of a command.
 */
@Schema(description = "An object that contains properties  specific to the CheckPermissions command,   extending the default properties of a command.")
@JsonPropertyOrder({
    CheckPermissionAttributesExtension.JSON_PROPERTY_TYPE,
    CheckPermissionAttributesExtension.JSON_PROPERTY_VERSION,
    CheckPermissionAttributesExtension.JSON_PROPERTY_SCHEMA,
    CheckPermissionAttributesExtension.JSON_PROPERTY_DATA
})
@JsonTypeName("CheckPermission_attributes_extension")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CheckPermissionAttributesExtension {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeCommandtypeCheckPermission type;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_SCHEMA = "schema";
  private CheckPermissionAttributesExtensionSchema schema;

  public static final String JSON_PROPERTY_DATA = "data";
  private CheckPermissionAttributesExtensionData data;

  public CheckPermissionAttributesExtension type(TypeCommandtypeCheckPermission type) {

    this.type = type;
    return this;
  }

  /**
   * Get type
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public TypeCommandtypeCheckPermission getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(TypeCommandtypeCheckPermission type) {
    this.type = type;
  }

  public CheckPermissionAttributesExtension version(String version) {

    this.version = version;
    return this;
  }

  /**
   * The version of the schema. Must be &#x60;&#x60;1.0.0&#x60;&#x60;
   * for the CheckPermission command.
   * 
   * @return version
   **/
  @javax.annotation.Nullable
  @Schema(description = "The version of the schema. Must be ``1.0.0``  for the CheckPermission command. ")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getVersion() {
    return version;
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setVersion(String version) {
    this.version = version;
  }

  public CheckPermissionAttributesExtension schema(CheckPermissionAttributesExtensionSchema schema) {

    this.schema = schema;
    return this;
  }

  /**
   * Get schema
   * 
   * @return schema
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public CheckPermissionAttributesExtensionSchema getSchema() {
    return schema;
  }

  @JsonProperty(JSON_PROPERTY_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSchema(CheckPermissionAttributesExtensionSchema schema) {
    this.schema = schema;
  }

  public CheckPermissionAttributesExtension data(CheckPermissionAttributesExtensionData data) {

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

  public CheckPermissionAttributesExtensionData getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setData(CheckPermissionAttributesExtensionData data) {
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
    CheckPermissionAttributesExtension checkPermissionAttributesExtension = (CheckPermissionAttributesExtension) o;
    return Objects.equals(this.type, checkPermissionAttributesExtension.type) &&
        Objects.equals(this.version, checkPermissionAttributesExtension.version) &&
        Objects.equals(this.schema, checkPermissionAttributesExtension.schema) &&
        Objects.equals(this.data, checkPermissionAttributesExtension.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, version, schema, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckPermissionAttributesExtension {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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
