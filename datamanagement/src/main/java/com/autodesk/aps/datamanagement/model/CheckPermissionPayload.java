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
 * An object that contains the input data required to execute the
 * CheckPermission command.
 * 
 * The CheckPermission command checks if a user has permission to perform
 * specified actions on specified resources.
 * The user’s identity is derived from the &#x60;&#x60;x-user-id&#x60;&#x60;
 * header (in a 2-Legged call), or from the access token (in a 3-Legged call).
 * 
 * See the [Developer&#39;s Guide topic on the CheckPermission
 * command](/en/docs/data/v2/developers_guide/commands/checkpermission/) for
 * more information.
 * 
 */
@Schema(description = "An object that contains the input data required to execute the CheckPermission command.  The CheckPermission command checks if a user has permission to perform specified actions on specified resources. The user’s identity is derived from the ``x-user-id`` header (in a 2-Legged call), or from the access token (in a 3-Legged call).   See the [Developer's Guide topic on the CheckPermission command](/en/docs/data/v2/developers_guide/commands/checkpermission/) for more information. ")
@JsonPropertyOrder({
    CheckPermissionPayload.JSON_PROPERTY_TYPE,
    CheckPermissionPayload.JSON_PROPERTY_ATTRIBUTES,
    CheckPermissionPayload.JSON_PROPERTY_RELATIONSHIPS
})
@JsonTypeName("CheckPermissionPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CheckPermissionPayload implements CommandPayloadData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeCommands type;

  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private CheckPermissionPayloadAttributes attributes;

  public static final String JSON_PROPERTY_RELATIONSHIPS = "relationships";
  private CheckPermissionPayloadRelationships relationships;

  public CheckPermissionPayload type(TypeCommands type) {

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

  public TypeCommands getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(TypeCommands type) {
    this.type = type;
  }

  public CheckPermissionPayload attributes(CheckPermissionPayloadAttributes attributes) {

    this.attributes = attributes;
    return this;
  }

  /**
   * Get attributes
   * 
   * @return attributes
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public CheckPermissionPayloadAttributes getAttributes() {
    return attributes;
  }

  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAttributes(CheckPermissionPayloadAttributes attributes) {
    this.attributes = attributes;
  }

  public CheckPermissionPayload relationships(CheckPermissionPayloadRelationships relationships) {

    this.relationships = relationships;
    return this;
  }

  /**
   * Get relationships
   * 
   * @return relationships
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public CheckPermissionPayloadRelationships getRelationships() {
    return relationships;
  }

  @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRelationships(CheckPermissionPayloadRelationships relationships) {
    this.relationships = relationships;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckPermissionPayload checkPermissionPayload = (CheckPermissionPayload) o;
    return Objects.equals(this.type, checkPermissionPayload.type) &&
        Objects.equals(this.attributes, checkPermissionPayload.attributes) &&
        Objects.equals(this.relationships, checkPermissionPayload.relationships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, attributes, relationships);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckPermissionPayload {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
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
