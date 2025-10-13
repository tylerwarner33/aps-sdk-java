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
 * The object containing information about the hub.
 */
@Schema(description = "The object containing information about the hub.")
@JsonPropertyOrder({
    HubData.JSON_PROPERTY_TYPE,
    HubData.JSON_PROPERTY_ID,
    HubData.JSON_PROPERTY_ATTRIBUTES,
    HubData.JSON_PROPERTY_RELATIONSHIPS,
    HubData.JSON_PROPERTY_LINKS
})
@JsonTypeName("HubData")
@JsonIgnoreProperties(ignoreUnknown = true)

public class HubData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeHub type;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private HubDataAttributes attributes;

  public static final String JSON_PROPERTY_RELATIONSHIPS = "relationships";
  private HubDataRelationships relationships;

  public static final String JSON_PROPERTY_LINKS = "links";
  private JsonApiLinksSelf links;

  public HubData type(TypeHub type) {

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

  public TypeHub getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(TypeHub type) {
    this.type = type;
  }

  public HubData id(String id) {

    this.id = id;
    return this;
  }

  /**
   * The hub ID, which uniquely identifies the hub.
   * 
   * @return id
   **/
  @javax.annotation.Nullable
  @Schema(description = "The hub ID, which uniquely identifies the hub.")
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

  public HubData attributes(HubDataAttributes attributes) {

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

  public HubDataAttributes getAttributes() {
    return attributes;
  }

  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAttributes(HubDataAttributes attributes) {
    this.attributes = attributes;
  }

  public HubData relationships(HubDataRelationships relationships) {

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

  public HubDataRelationships getRelationships() {
    return relationships;
  }

  @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRelationships(HubDataRelationships relationships) {
    this.relationships = relationships;
  }

  public HubData links(JsonApiLinksSelf links) {

    this.links = links;
    return this;
  }

  /**
   * Get links
   * 
   * @return links
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiLinksSelf getLinks() {
    return links;
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLinks(JsonApiLinksSelf links) {
    this.links = links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HubData hubData = (HubData) o;
    return Objects.equals(this.type, hubData.type) &&
        Objects.equals(this.id, hubData.id) &&
        Objects.equals(this.attributes, hubData.attributes) &&
        Objects.equals(this.relationships, hubData.relationships) &&
        Objects.equals(this.links, hubData.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, attributes, relationships, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HubData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
