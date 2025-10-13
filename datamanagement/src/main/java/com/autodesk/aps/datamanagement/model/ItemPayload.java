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
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Describe the item to be created.
 */
@Schema(description = "Describe the item to be created.")
@JsonPropertyOrder({
    ItemPayload.JSON_PROPERTY_JSONAPI,
    ItemPayload.JSON_PROPERTY_DATA,
    ItemPayload.JSON_PROPERTY_INCLUDED,
    ItemPayload.JSON_PROPERTY_META
})
@JsonTypeName("ItemPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPayload {
  public static final String JSON_PROPERTY_JSONAPI = "jsonapi";
  private JsonApiVersion jsonapi;

  public static final String JSON_PROPERTY_DATA = "data";
  private ItemPayloadData data;

  public static final String JSON_PROPERTY_INCLUDED = "included";
  private List<ItemPayloadIncluded> included = new ArrayList<>();

  public static final String JSON_PROPERTY_META = "meta";
  private MetaForWebhooks meta;

  public ItemPayload jsonapi(JsonApiVersion jsonapi) {

    this.jsonapi = jsonapi;
    return this;
  }

  /**
   * Get jsonapi
   * 
   * @return jsonapi
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_JSONAPI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiVersion getJsonapi() {
    return jsonapi;
  }

  @JsonProperty(JSON_PROPERTY_JSONAPI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setJsonapi(JsonApiVersion jsonapi) {
    this.jsonapi = jsonapi;
  }

  public ItemPayload data(ItemPayloadData data) {

    this.data = data;
    return this;
  }

  /**
   * Get data
   * 
   * @return data
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ItemPayloadData getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setData(ItemPayloadData data) {
    this.data = data;
  }

  public ItemPayload included(List<ItemPayloadIncluded> included) {

    this.included = included;
    return this;
  }

  public ItemPayload addincludedItem(ItemPayloadIncluded includedItem) {
    this.included.add(includedItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a version of the item to be
   * created. In this case there will only be one element in the array.
   * 
   * @return included
   **/
  @Schema(required = true, description = "An array of objects, where each object represents a version of the item to be created. In this case there will only be one element in the array.")
  @JsonProperty(JSON_PROPERTY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ItemPayloadIncluded> getIncluded() {
    return included;
  }

  @JsonProperty(JSON_PROPERTY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIncluded(List<ItemPayloadIncluded> included) {
    this.included = included;
  }

  public ItemPayload meta(MetaForWebhooks meta) {

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

  public MetaForWebhooks getMeta() {
    return meta;
  }

  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMeta(MetaForWebhooks meta) {
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
    ItemPayload itemPayload = (ItemPayload) o;
    return Objects.equals(this.jsonapi, itemPayload.jsonapi) &&
        Objects.equals(this.data, itemPayload.data) &&
        Objects.equals(this.included, itemPayload.included) &&
        Objects.equals(this.meta, itemPayload.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jsonapi, data, included, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPayload {\n");
    sb.append("    jsonapi: ").append(toIndentedString(jsonapi)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
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
