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
 * GetHubs403Response
 */
@JsonPropertyOrder({
    GetHubs403Response.JSON_PROPERTY_JSONAPI,
    GetHubs403Response.JSON_PROPERTY_LINKS,
    GetHubs403Response.JSON_PROPERTY_DATA,
    GetHubs403Response.JSON_PROPERTY_META
})
@JsonTypeName("getHubs_403_response")
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetHubs403Response {
  public static final String JSON_PROPERTY_JSONAPI = "jsonapi";
  private Object jsonapi;

  public static final String JSON_PROPERTY_LINKS = "links";
  private Object links;

  public static final String JSON_PROPERTY_DATA = "data";
  private List<Object> data = null;

  public static final String JSON_PROPERTY_META = "meta";
  private GetHubs403ResponseMeta meta;

  public GetHubs403Response jsonapi(Object jsonapi) {

    this.jsonapi = jsonapi;
    return this;
  }

  /**
   * The JSON API object.
   * 
   * @return jsonapi
   **/
  @javax.annotation.Nullable
  @Schema(description = "The JSON API object.")
  @JsonProperty(JSON_PROPERTY_JSONAPI)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getJsonapi() {
    return jsonapi;
  }

  @JsonProperty(JSON_PROPERTY_JSONAPI)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setJsonapi(Object jsonapi) {
    this.jsonapi = jsonapi;
  }

  public GetHubs403Response links(Object links) {

    this.links = links;
    return this;
  }

  /**
   * An object intended to contain the URI of a resource. Empty in this case,
   * because an error has occurred.
   * 
   * @return links
   **/
  @javax.annotation.Nullable
  @Schema(description = "An object intended to contain the URI of a resource. Empty in this case, because an error has occurred.")
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getLinks() {
    return links;
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLinks(Object links) {
    this.links = links;
  }

  public GetHubs403Response data(List<Object> data) {

    this.data = data;
    return this;
  }

  public GetHubs403Response adddataItem(Object dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * An object intended to contain the return data. Empty in this case, because an
   * error has occurred.
   * 
   * @return data
   **/
  @javax.annotation.Nullable
  @Schema(description = "An object intended to contain the return data. Empty in this case, because an error has occurred.")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setData(List<Object> data) {
    this.data = data;
  }

  public GetHubs403Response meta(GetHubs403ResponseMeta meta) {

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

  public GetHubs403ResponseMeta getMeta() {
    return meta;
  }

  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMeta(GetHubs403ResponseMeta meta) {
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
    GetHubs403Response getHubs403Response = (GetHubs403Response) o;
    return Objects.equals(this.jsonapi, getHubs403Response.jsonapi) &&
        Objects.equals(this.links, getHubs403Response.links) &&
        Objects.equals(this.data, getHubs403Response.data) &&
        Objects.equals(this.meta, getHubs403Response.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jsonapi, links, data, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetHubs403Response {\n");
    sb.append("    jsonapi: ").append(toIndentedString(jsonapi)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
