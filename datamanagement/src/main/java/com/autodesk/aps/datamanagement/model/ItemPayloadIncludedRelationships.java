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
 * A container of links to resources that are related to the item to be created.
 */
@Schema(description = "A container of links to resources that are related to the item to be created.")
@JsonPropertyOrder({
    ItemPayloadIncludedRelationships.JSON_PROPERTY_STORAGE,
    ItemPayloadIncludedRelationships.JSON_PROPERTY_REFS
})
@JsonTypeName("ItemPayload_included_relationships")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPayloadIncludedRelationships {
  public static final String JSON_PROPERTY_STORAGE = "storage";
  private ItemPayloadIncludedRelationshipsStorage storage;

  public static final String JSON_PROPERTY_REFS = "refs";
  private JsonApiRelationshipsRefs refs;

  public ItemPayloadIncludedRelationships storage(ItemPayloadIncludedRelationshipsStorage storage) {

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

  public ItemPayloadIncludedRelationshipsStorage getStorage() {
    return storage;
  }

  @JsonProperty(JSON_PROPERTY_STORAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStorage(ItemPayloadIncludedRelationshipsStorage storage) {
    this.storage = storage;
  }

  public ItemPayloadIncludedRelationships refs(JsonApiRelationshipsRefs refs) {

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

  public JsonApiRelationshipsRefs getRefs() {
    return refs;
  }

  @JsonProperty(JSON_PROPERTY_REFS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRefs(JsonApiRelationshipsRefs refs) {
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
    ItemPayloadIncludedRelationships itemPayloadIncludedRelationships = (ItemPayloadIncludedRelationships) o;
    return Objects.equals(this.storage, itemPayloadIncludedRelationships.storage) &&
        Objects.equals(this.refs, itemPayloadIncludedRelationships.refs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storage, refs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPayloadIncludedRelationships {\n");
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
