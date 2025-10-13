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
 * Information on links for this resource. &#x60;&#x60;first&#x60;&#x60;,
 * &#x60;&#x60;prev&#x60;&#x60;, and &#x60;&#x60;next&#x60;&#x60; are available
 * only when the response is paginated.
 */
@Schema(description = "Information on links for this resource. ``first``, ``prev``, and ``next`` are available only when the response is paginated.")
@JsonPropertyOrder({
    FolderContentsLinks.JSON_PROPERTY_SELF,
    FolderContentsLinks.JSON_PROPERTY_FIRST,
    FolderContentsLinks.JSON_PROPERTY_PREV,
    FolderContentsLinks.JSON_PROPERTY_NEXT
})
@JsonTypeName("FolderContents_links")
@JsonIgnoreProperties(ignoreUnknown = true)

public class FolderContentsLinks {
  public static final String JSON_PROPERTY_SELF = "self";
  private JsonApiLink self;

  public static final String JSON_PROPERTY_FIRST = "first";
  private JsonApiLink first;

  public static final String JSON_PROPERTY_PREV = "prev";
  private JsonApiLink prev;

  public static final String JSON_PROPERTY_NEXT = "next";
  private JsonApiLink next;

  public FolderContentsLinks self(JsonApiLink self) {

    this.self = self;
    return this;
  }

  /**
   * Get self
   * 
   * @return self
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiLink getSelf() {
    return self;
  }

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSelf(JsonApiLink self) {
    this.self = self;
  }

  public FolderContentsLinks first(JsonApiLink first) {

    this.first = first;
    return this;
  }

  /**
   * Get first
   * 
   * @return first
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiLink getFirst() {
    return first;
  }

  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFirst(JsonApiLink first) {
    this.first = first;
  }

  public FolderContentsLinks prev(JsonApiLink prev) {

    this.prev = prev;
    return this;
  }

  /**
   * Get prev
   * 
   * @return prev
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PREV)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiLink getPrev() {
    return prev;
  }

  @JsonProperty(JSON_PROPERTY_PREV)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPrev(JsonApiLink prev) {
    this.prev = prev;
  }

  public FolderContentsLinks next(JsonApiLink next) {

    this.next = next;
    return this;
  }

  /**
   * Get next
   * 
   * @return next
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiLink getNext() {
    return next;
  }

  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setNext(JsonApiLink next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FolderContentsLinks folderContentsLinks = (FolderContentsLinks) o;
    return Objects.equals(this.self, folderContentsLinks.self) &&
        Objects.equals(this.first, folderContentsLinks.first) &&
        Objects.equals(this.prev, folderContentsLinks.prev) &&
        Objects.equals(this.next, folderContentsLinks.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, prev, next);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FolderContentsLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
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
