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
 * VersionPayloadDataRelationshipsRefsData
 */
@JsonPropertyOrder({
    VersionPayloadDataRelationshipsRefsData.JSON_PROPERTY_TYPE,
    VersionPayloadDataRelationshipsRefsData.JSON_PROPERTY_ID,
    VersionPayloadDataRelationshipsRefsData.JSON_PROPERTY_META
})
@JsonTypeName("VersionPayload_data_relationships_refs_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class VersionPayloadDataRelationshipsRefsData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeVersion type;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_META = "meta";
  private VersionPayloadDataRelationshipsRefsDataMeta meta;

  public VersionPayloadDataRelationshipsRefsData type(TypeVersion type) {

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

  public TypeVersion getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeVersion type) {
    this.type = type;
  }

  public VersionPayloadDataRelationshipsRefsData id(String id) {

    this.id = id;
    return this;
  }

  /**
   * The URN (Version ID) of the referenced version.
   * 
   * @return id
   **/
  @Schema(required = true, description = "The URN (Version ID) of the referenced version.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }

  public VersionPayloadDataRelationshipsRefsData meta(VersionPayloadDataRelationshipsRefsDataMeta meta) {

    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * 
   * @return meta
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VersionPayloadDataRelationshipsRefsDataMeta getMeta() {
    return meta;
  }

  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMeta(VersionPayloadDataRelationshipsRefsDataMeta meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionPayloadDataRelationshipsRefsData versionPayloadDataRelationshipsRefsData = (VersionPayloadDataRelationshipsRefsData) o;
    return Objects.equals(this.type, versionPayloadDataRelationshipsRefsData.type) &&
        Objects.equals(this.id, versionPayloadDataRelationshipsRefsData.id) &&
        Objects.equals(this.meta, versionPayloadDataRelationshipsRefsData.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionPayloadDataRelationshipsRefsData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
