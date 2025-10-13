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
 * Contains information on other resources related to this resource.
 */
@Schema(description = "Contains information on other resources related to this resource.")
@JsonPropertyOrder({
    VersionDataRelationships.JSON_PROPERTY_ITEM,
    VersionDataRelationships.JSON_PROPERTY_REFS,
    VersionDataRelationships.JSON_PROPERTY_LINKS,
    VersionDataRelationships.JSON_PROPERTY_STORAGE,
    VersionDataRelationships.JSON_PROPERTY_DERIVATIVES,
    VersionDataRelationships.JSON_PROPERTY_THUMBNAILS,
    VersionDataRelationships.JSON_PROPERTY_DOWNLOAD_FORMATS
})
@JsonTypeName("VersionData_relationships")
@JsonIgnoreProperties(ignoreUnknown = true)

public class VersionDataRelationships {
  public static final String JSON_PROPERTY_ITEM = "item";
  private VersionDataRelationshipsItem item;

  public static final String JSON_PROPERTY_REFS = "refs";
  private JsonApiRelationshipsLinksRefs refs;

  public static final String JSON_PROPERTY_LINKS = "links";
  private JsonApiRelationshipsLinksLinks links;

  public static final String JSON_PROPERTY_STORAGE = "storage";
  private VersionDataRelationshipsStorage storage;

  public static final String JSON_PROPERTY_DERIVATIVES = "derivatives";
  private VersionDataRelationshipsDerivatives derivatives;

  public static final String JSON_PROPERTY_THUMBNAILS = "thumbnails";
  private VersionDataRelationshipsThumbnails thumbnails;

  public static final String JSON_PROPERTY_DOWNLOAD_FORMATS = "downloadFormats";
  private VersionDataRelationshipsDownloadFormats downloadFormats;

  public VersionDataRelationships item(VersionDataRelationshipsItem item) {

    this.item = item;
    return this;
  }

  /**
   * Get item
   * 
   * @return item
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_ITEM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VersionDataRelationshipsItem getItem() {
    return item;
  }

  @JsonProperty(JSON_PROPERTY_ITEM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setItem(VersionDataRelationshipsItem item) {
    this.item = item;
  }

  public VersionDataRelationships refs(JsonApiRelationshipsLinksRefs refs) {

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

  public VersionDataRelationships links(JsonApiRelationshipsLinksLinks links) {

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

  public VersionDataRelationships storage(VersionDataRelationshipsStorage storage) {

    this.storage = storage;
    return this;
  }

  /**
   * Get storage
   * 
   * @return storage
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_STORAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public VersionDataRelationshipsStorage getStorage() {
    return storage;
  }

  @JsonProperty(JSON_PROPERTY_STORAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStorage(VersionDataRelationshipsStorage storage) {
    this.storage = storage;
  }

  public VersionDataRelationships derivatives(VersionDataRelationshipsDerivatives derivatives) {

    this.derivatives = derivatives;
    return this;
  }

  /**
   * Get derivatives
   * 
   * @return derivatives
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DERIVATIVES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public VersionDataRelationshipsDerivatives getDerivatives() {
    return derivatives;
  }

  @JsonProperty(JSON_PROPERTY_DERIVATIVES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDerivatives(VersionDataRelationshipsDerivatives derivatives) {
    this.derivatives = derivatives;
  }

  public VersionDataRelationships thumbnails(VersionDataRelationshipsThumbnails thumbnails) {

    this.thumbnails = thumbnails;
    return this;
  }

  /**
   * Get thumbnails
   * 
   * @return thumbnails
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_THUMBNAILS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public VersionDataRelationshipsThumbnails getThumbnails() {
    return thumbnails;
  }

  @JsonProperty(JSON_PROPERTY_THUMBNAILS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setThumbnails(VersionDataRelationshipsThumbnails thumbnails) {
    this.thumbnails = thumbnails;
  }

  public VersionDataRelationships downloadFormats(VersionDataRelationshipsDownloadFormats downloadFormats) {

    this.downloadFormats = downloadFormats;
    return this;
  }

  /**
   * Get downloadFormats
   * 
   * @return downloadFormats
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DOWNLOAD_FORMATS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public VersionDataRelationshipsDownloadFormats getDownloadFormats() {
    return downloadFormats;
  }

  @JsonProperty(JSON_PROPERTY_DOWNLOAD_FORMATS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDownloadFormats(VersionDataRelationshipsDownloadFormats downloadFormats) {
    this.downloadFormats = downloadFormats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionDataRelationships versionDataRelationships = (VersionDataRelationships) o;
    return Objects.equals(this.item, versionDataRelationships.item) &&
        Objects.equals(this.refs, versionDataRelationships.refs) &&
        Objects.equals(this.links, versionDataRelationships.links) &&
        Objects.equals(this.storage, versionDataRelationships.storage) &&
        Objects.equals(this.derivatives, versionDataRelationships.derivatives) &&
        Objects.equals(this.thumbnails, versionDataRelationships.thumbnails) &&
        Objects.equals(this.downloadFormats, versionDataRelationships.downloadFormats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, refs, links, storage, derivatives, thumbnails, downloadFormats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionDataRelationships {\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    refs: ").append(toIndentedString(refs)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
    sb.append("    derivatives: ").append(toIndentedString(derivatives)).append("\n");
    sb.append("    thumbnails: ").append(toIndentedString(thumbnails)).append("\n");
    sb.append("    downloadFormats: ").append(toIndentedString(downloadFormats)).append("\n");
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
