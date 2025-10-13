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
 * Contains links to resources that are directly related to this item.
 */
@Schema(description = "Contains links to resources that are directly related to this item.")
@JsonPropertyOrder({
    ItemDataRelationships.JSON_PROPERTY_PARENT,
    ItemDataRelationships.JSON_PROPERTY_TIP,
    ItemDataRelationships.JSON_PROPERTY_VERSIONS,
    ItemDataRelationships.JSON_PROPERTY_REFS,
    ItemDataRelationships.JSON_PROPERTY_LINKS
})
@JsonTypeName("ItemData_relationships")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemDataRelationships {
  public static final String JSON_PROPERTY_PARENT = "parent";
  private JsonApiRelationshipsLinksFolderParent parent;

  public static final String JSON_PROPERTY_TIP = "tip";
  private JsonApiRelationshipsLinksToTipVersion tip;

  public static final String JSON_PROPERTY_VERSIONS = "versions";
  private JsonApiRelationshipsLinksVersions versions;

  public static final String JSON_PROPERTY_REFS = "refs";
  private JsonApiRelationshipsLinksRefs refs;

  public static final String JSON_PROPERTY_LINKS = "links";
  private JsonApiRelationshipsLinksLinks links;

  public ItemDataRelationships parent(JsonApiRelationshipsLinksFolderParent parent) {

    this.parent = parent;
    return this;
  }

  /**
   * Get parent
   * 
   * @return parent
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_PARENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiRelationshipsLinksFolderParent getParent() {
    return parent;
  }

  @JsonProperty(JSON_PROPERTY_PARENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setParent(JsonApiRelationshipsLinksFolderParent parent) {
    this.parent = parent;
  }

  public ItemDataRelationships tip(JsonApiRelationshipsLinksToTipVersion tip) {

    this.tip = tip;
    return this;
  }

  /**
   * Get tip
   * 
   * @return tip
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_TIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiRelationshipsLinksToTipVersion getTip() {
    return tip;
  }

  @JsonProperty(JSON_PROPERTY_TIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTip(JsonApiRelationshipsLinksToTipVersion tip) {
    this.tip = tip;
  }

  public ItemDataRelationships versions(JsonApiRelationshipsLinksVersions versions) {

    this.versions = versions;
    return this;
  }

  /**
   * Get versions
   * 
   * @return versions
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiRelationshipsLinksVersions getVersions() {
    return versions;
  }

  @JsonProperty(JSON_PROPERTY_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVersions(JsonApiRelationshipsLinksVersions versions) {
    this.versions = versions;
  }

  public ItemDataRelationships refs(JsonApiRelationshipsLinksRefs refs) {

    this.refs = refs;
    return this;
  }

  /**
   * Get refs
   * 
   * @return refs
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_REFS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiRelationshipsLinksRefs getRefs() {
    return refs;
  }

  @JsonProperty(JSON_PROPERTY_REFS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRefs(JsonApiRelationshipsLinksRefs refs) {
    this.refs = refs;
  }

  public ItemDataRelationships links(JsonApiRelationshipsLinksLinks links) {

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

  public JsonApiRelationshipsLinksLinks getLinks() {
    return links;
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLinks(JsonApiRelationshipsLinksLinks links) {
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
    ItemDataRelationships itemDataRelationships = (ItemDataRelationships) o;
    return Objects.equals(this.parent, itemDataRelationships.parent) &&
        Objects.equals(this.tip, itemDataRelationships.tip) &&
        Objects.equals(this.versions, itemDataRelationships.versions) &&
        Objects.equals(this.refs, itemDataRelationships.refs) &&
        Objects.equals(this.links, itemDataRelationships.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parent, tip, versions, refs, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemDataRelationships {\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    tip: ").append(toIndentedString(tip)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
    sb.append("    refs: ").append(toIndentedString(refs)).append("\n");
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
