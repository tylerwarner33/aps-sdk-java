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
 * Contains meta information about the reference.
 */
@Schema(description = "Contains meta information about the reference.")
@JsonPropertyOrder({
    VersionPayloadDataRelationshipsRefsDataMeta.JSON_PROPERTY_REF_TYPE,
    VersionPayloadDataRelationshipsRefsDataMeta.JSON_PROPERTY_DIRECTION,
    VersionPayloadDataRelationshipsRefsDataMeta.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("VersionPayload_data_relationships_refs_data_meta")
@JsonIgnoreProperties(ignoreUnknown = true)

public class VersionPayloadDataRelationshipsRefsDataMeta {
  public static final String JSON_PROPERTY_REF_TYPE = "refType";
  private ReftypesXref refType;

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  private MetarefsDirection direction;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private VersionPayloadDataRelationshipsRefsDataMetaExtension extension;

  public VersionPayloadDataRelationshipsRefsDataMeta refType(ReftypesXref refType) {

    this.refType = refType;
    return this;
  }

  /**
   * Get refType
   * 
   * @return refType
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_REF_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ReftypesXref getRefType() {
    return refType;
  }

  @JsonProperty(JSON_PROPERTY_REF_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRefType(ReftypesXref refType) {
    this.refType = refType;
  }

  public VersionPayloadDataRelationshipsRefsDataMeta direction(MetarefsDirection direction) {

    this.direction = direction;
    return this;
  }

  /**
   * Get direction
   * 
   * @return direction
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public MetarefsDirection getDirection() {
    return direction;
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirection(MetarefsDirection direction) {
    this.direction = direction;
  }

  public VersionPayloadDataRelationshipsRefsDataMeta extension(
      VersionPayloadDataRelationshipsRefsDataMetaExtension extension) {

    this.extension = extension;
    return this;
  }

  /**
   * Get extension
   * 
   * @return extension
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VersionPayloadDataRelationshipsRefsDataMetaExtension getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExtension(VersionPayloadDataRelationshipsRefsDataMetaExtension extension) {
    this.extension = extension;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionPayloadDataRelationshipsRefsDataMeta versionPayloadDataRelationshipsRefsDataMeta = (VersionPayloadDataRelationshipsRefsDataMeta) o;
    return Objects.equals(this.refType, versionPayloadDataRelationshipsRefsDataMeta.refType) &&
        Objects.equals(this.direction, versionPayloadDataRelationshipsRefsDataMeta.direction) &&
        Objects.equals(this.extension, versionPayloadDataRelationshipsRefsDataMeta.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refType, direction, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionPayloadDataRelationshipsRefsDataMeta {\n");
    sb.append("    refType: ").append(toIndentedString(refType)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
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
