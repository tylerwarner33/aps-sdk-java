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
 * Contains the links to use to access references of this resource.
 */
@Schema(description = "Contains the links to use to access references of this resource.")
@JsonPropertyOrder({
    CreatedVersionIncludedLinks.JSON_PROPERTY_SELF,
    CreatedVersionIncludedLinks.JSON_PROPERTY_RELATED
})
@JsonTypeName("CreatedVersion_included_links")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreatedVersionIncludedLinks {
  public static final String JSON_PROPERTY_SELF = "self";
  private JsonApiLinksSelf self;

  public static final String JSON_PROPERTY_RELATED = "related";
  private JsonApiLinksRelated related;

  public CreatedVersionIncludedLinks self(JsonApiLinksSelf self) {

    this.self = self;
    return this;
  }

  /**
   * Get self
   * 
   * @return self
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiLinksSelf getSelf() {
    return self;
  }

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSelf(JsonApiLinksSelf self) {
    this.self = self;
  }

  public CreatedVersionIncludedLinks related(JsonApiLinksRelated related) {

    this.related = related;
    return this;
  }

  /**
   * Get related
   * 
   * @return related
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_RELATED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiLinksRelated getRelated() {
    return related;
  }

  @JsonProperty(JSON_PROPERTY_RELATED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRelated(JsonApiLinksRelated related) {
    this.related = related;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatedVersionIncludedLinks createdVersionIncludedLinks = (CreatedVersionIncludedLinks) o;
    return Objects.equals(this.self, createdVersionIncludedLinks.self) &&
        Objects.equals(this.related, createdVersionIncludedLinks.related);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, related);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatedVersionIncludedLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    related: ").append(toIndentedString(related)).append("\n");
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
