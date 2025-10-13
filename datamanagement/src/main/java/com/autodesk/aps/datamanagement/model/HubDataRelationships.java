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
 * Contains links to resources that are directly related to this hub.
 */
@Schema(description = "Contains links to resources that are directly related to this hub.")
@JsonPropertyOrder({
    HubDataRelationships.JSON_PROPERTY_PROJECTS,
    HubDataRelationships.JSON_PROPERTY_PIM_COLLECTION
})
@JsonTypeName("HubData_relationships")
@JsonIgnoreProperties(ignoreUnknown = true)

public class HubDataRelationships {
  public static final String JSON_PROPERTY_PROJECTS = "projects";
  private HubDataRelationshipsProjects projects;

  public static final String JSON_PROPERTY_PIM_COLLECTION = "pimCollection";
  private HubDataRelationshipsPimCollection pimCollection;

  public HubDataRelationships projects(HubDataRelationshipsProjects projects) {

    this.projects = projects;
    return this;
  }

  /**
   * Get projects
   * 
   * @return projects
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PROJECTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public HubDataRelationshipsProjects getProjects() {
    return projects;
  }

  @JsonProperty(JSON_PROPERTY_PROJECTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProjects(HubDataRelationshipsProjects projects) {
    this.projects = projects;
  }

  public HubDataRelationships pimCollection(HubDataRelationshipsPimCollection pimCollection) {

    this.pimCollection = pimCollection;
    return this;
  }

  /**
   * Get pimCollection
   * 
   * @return pimCollection
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PIM_COLLECTION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public HubDataRelationshipsPimCollection getPimCollection() {
    return pimCollection;
  }

  @JsonProperty(JSON_PROPERTY_PIM_COLLECTION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPimCollection(HubDataRelationshipsPimCollection pimCollection) {
    this.pimCollection = pimCollection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HubDataRelationships hubDataRelationships = (HubDataRelationships) o;
    return Objects.equals(this.projects, hubDataRelationships.projects) &&
        Objects.equals(this.pimCollection, hubDataRelationships.pimCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projects, pimCollection);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HubDataRelationships {\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
    sb.append("    pimCollection: ").append(toIndentedString(pimCollection)).append("\n");
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
