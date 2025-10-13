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
 * A container of links to resources that are related to the version to be
 * created.
 */
@Schema(description = "A container of links to resources that are related to the version to be created.")
@JsonPropertyOrder({
    VersionPayloadDataRelationships.JSON_PROPERTY_ITEM,
    VersionPayloadDataRelationships.JSON_PROPERTY_STORAGE,
    VersionPayloadDataRelationships.JSON_PROPERTY_REFS
})
@JsonTypeName("VersionPayload_data_relationships")
@JsonIgnoreProperties(ignoreUnknown = true)

public class VersionPayloadDataRelationships {
  public static final String JSON_PROPERTY_ITEM = "item";
  private VersionPayloadDataRelationshipsItem item;

  public static final String JSON_PROPERTY_STORAGE = "storage";
  private VersionPayloadDataRelationshipsStorage storage;

  public static final String JSON_PROPERTY_REFS = "refs";
  private VersionPayloadDataRelationshipsRefs refs;

  public VersionPayloadDataRelationships item(VersionPayloadDataRelationshipsItem item) {

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

  public VersionPayloadDataRelationshipsItem getItem() {
    return item;
  }

  @JsonProperty(JSON_PROPERTY_ITEM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setItem(VersionPayloadDataRelationshipsItem item) {
    this.item = item;
  }

  public VersionPayloadDataRelationships storage(VersionPayloadDataRelationshipsStorage storage) {

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

  public VersionPayloadDataRelationshipsStorage getStorage() {
    return storage;
  }

  @JsonProperty(JSON_PROPERTY_STORAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStorage(VersionPayloadDataRelationshipsStorage storage) {
    this.storage = storage;
  }

  public VersionPayloadDataRelationships refs(VersionPayloadDataRelationshipsRefs refs) {

    this.refs = refs;
    return this;
  }

  /**
   * Get refs
   * 
   * @return refs
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_REFS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public VersionPayloadDataRelationshipsRefs getRefs() {
    return refs;
  }

  @JsonProperty(JSON_PROPERTY_REFS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRefs(VersionPayloadDataRelationshipsRefs refs) {
    this.refs = refs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionPayloadDataRelationships versionPayloadDataRelationships = (VersionPayloadDataRelationships) o;
    return Objects.equals(this.item, versionPayloadDataRelationships.item) &&
        Objects.equals(this.storage, versionPayloadDataRelationships.storage) &&
        Objects.equals(this.refs, versionPayloadDataRelationships.refs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, storage, refs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionPayloadDataRelationships {\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
    sb.append("    refs: ").append(toIndentedString(refs)).append("\n");
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
