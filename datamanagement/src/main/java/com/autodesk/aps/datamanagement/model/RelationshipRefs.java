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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 */
@Schema(description = "")
@JsonPropertyOrder({
    RelationshipRefs.JSON_PROPERTY_JSONAPI,
    RelationshipRefs.JSON_PROPERTY_LINKS,
    RelationshipRefs.JSON_PROPERTY_DATA,
    RelationshipRefs.JSON_PROPERTY_INCLUDED
})
@JsonTypeName("RelationshipRefs")
@JsonIgnoreProperties(ignoreUnknown = true)

public class RelationshipRefs {
  public static final String JSON_PROPERTY_JSONAPI = "jsonapi";
  private JsonApiVersion jsonapi;

  public static final String JSON_PROPERTY_LINKS = "links";
  private RelationshipRefsLinks links;

  public static final String JSON_PROPERTY_DATA = "data";
  private List<RelationshipRefsData> data = null;

  public static final String JSON_PROPERTY_INCLUDED = "included";
  private List<RelationshipRefsIncluded> included = null;

  public RelationshipRefs jsonapi(JsonApiVersion jsonapi) {

    this.jsonapi = jsonapi;
    return this;
  }

  /**
   * Get jsonapi
   * 
   * @return jsonapi
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_JSONAPI)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiVersion getJsonapi() {
    return jsonapi;
  }

  @JsonProperty(JSON_PROPERTY_JSONAPI)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setJsonapi(JsonApiVersion jsonapi) {
    this.jsonapi = jsonapi;
  }

  public RelationshipRefs links(RelationshipRefsLinks links) {

    this.links = links;
    return this;
  }

  /**
   * Get links
   * 
   * @return links
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public RelationshipRefsLinks getLinks() {
    return links;
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLinks(RelationshipRefsLinks links) {
    this.links = links;
  }

  public RelationshipRefs data(List<RelationshipRefsData> data) {

    this.data = data;
    return this;
  }

  public RelationshipRefs adddataItem(RelationshipRefsData dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * An array of objects where each object represents the data of a folder, item,
   * or resource.
   * 
   * @return data
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects where each object represents the data of a folder, item, or resource.")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<RelationshipRefsData> getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setData(List<RelationshipRefsData> data) {
    this.data = data;
  }

  public RelationshipRefs included(List<RelationshipRefsIncluded> included) {

    this.included = included;
    return this;
  }

  public RelationshipRefs addincludedItem(RelationshipRefsIncluded includedItem) {
    if (this.included == null) {
      this.included = new ArrayList<>();
    }
    this.included.add(includedItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a folder, item, or version
   * included within this resource.
   * 
   * @return included
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object represents a folder, item, or version included within this resource.")
  @JsonProperty(JSON_PROPERTY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<RelationshipRefsIncluded> getIncluded() {
    return included;
  }

  @JsonProperty(JSON_PROPERTY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIncluded(List<RelationshipRefsIncluded> included) {
    this.included = included;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationshipRefs relationshipRefs = (RelationshipRefs) o;
    return Objects.equals(this.jsonapi, relationshipRefs.jsonapi) &&
        Objects.equals(this.links, relationshipRefs.links) &&
        Objects.equals(this.data, relationshipRefs.data) &&
        Objects.equals(this.included, relationshipRefs.included);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jsonapi, links, data, included);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationshipRefs {\n");
    sb.append("    jsonapi: ").append(toIndentedString(jsonapi)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
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
