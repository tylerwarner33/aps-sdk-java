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
 * An object that is returned with responses that can be split across multiple
 * pages. &quot;Next,&quot; &quot;Previous,&quot; and &quot;First&quot; are
 * available only if the response is split across multiple pages.
 */
@Schema(description = "An object that is returned with responses that can be split across multiple pages. \"Next,\" \"Previous,\" and \"First\" are available only if the response is split across multiple pages.")
@JsonPropertyOrder({
    PaginationInfo.JSON_PROPERTY_SELF,
    PaginationInfo.JSON_PROPERTY_FIRST,
    PaginationInfo.JSON_PROPERTY_NEXT,
    PaginationInfo.JSON_PROPERTY_PREV
})
@JsonTypeName("PaginationInfo")
@JsonIgnoreProperties(ignoreUnknown = true)

public class PaginationInfo {
  public static final String JSON_PROPERTY_SELF = "self";
  private PaginationInfoSelf self;

  public static final String JSON_PROPERTY_FIRST = "first";
  private PaginationInfoFirst first;

  public static final String JSON_PROPERTY_NEXT = "next";
  private PaginationInfoNext next;

  public static final String JSON_PROPERTY_PREV = "prev";
  private PaginationInfoPrev prev;

  public PaginationInfo self(PaginationInfoSelf self) {

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

  public PaginationInfoSelf getSelf() {
    return self;
  }

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSelf(PaginationInfoSelf self) {
    this.self = self;
  }

  public PaginationInfo first(PaginationInfoFirst first) {

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

  public PaginationInfoFirst getFirst() {
    return first;
  }

  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFirst(PaginationInfoFirst first) {
    this.first = first;
  }

  public PaginationInfo next(PaginationInfoNext next) {

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

  public PaginationInfoNext getNext() {
    return next;
  }

  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setNext(PaginationInfoNext next) {
    this.next = next;
  }

  public PaginationInfo prev(PaginationInfoPrev prev) {

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

  public PaginationInfoPrev getPrev() {
    return prev;
  }

  @JsonProperty(JSON_PROPERTY_PREV)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPrev(PaginationInfoPrev prev) {
    this.prev = prev;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationInfo paginationInfo = (PaginationInfo) o;
    return Objects.equals(this.self, paginationInfo.self) &&
        Objects.equals(this.first, paginationInfo.first) &&
        Objects.equals(this.next, paginationInfo.next) &&
        Objects.equals(this.prev, paginationInfo.prev);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, next, prev);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationInfo {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
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
