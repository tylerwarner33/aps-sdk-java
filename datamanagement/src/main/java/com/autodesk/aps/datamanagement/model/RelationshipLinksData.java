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
 * RelationshipLinksData
 */
@JsonPropertyOrder({
    RelationshipLinksData.JSON_PROPERTY_TYPE,
    RelationshipLinksData.JSON_PROPERTY_ID,
    RelationshipLinksData.JSON_PROPERTY_META
})
@JsonTypeName("RelationshipLinks_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class RelationshipLinksData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeLink type;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_META = "meta";
  private RelationshipLinksDataMeta meta;

  public RelationshipLinksData type(TypeLink type) {

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

  public TypeLink getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(TypeLink type) {
    this.type = type;
  }

  public RelationshipLinksData id(String id) {

    this.id = id;
    return this;
  }

  /**
   * The ID of the resource.
   * 
   * @return id
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the resource.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setId(String id) {
    this.id = id;
  }

  public RelationshipLinksData meta(RelationshipLinksDataMeta meta) {

    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * 
   * @return meta
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public RelationshipLinksDataMeta getMeta() {
    return meta;
  }

  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMeta(RelationshipLinksDataMeta meta) {
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
    RelationshipLinksData relationshipLinksData = (RelationshipLinksData) o;
    return Objects.equals(this.type, relationshipLinksData.type) &&
        Objects.equals(this.id, relationshipLinksData.id) &&
        Objects.equals(this.meta, relationshipLinksData.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationshipLinksData {\n");
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
