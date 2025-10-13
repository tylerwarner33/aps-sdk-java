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
 * Contains links to resources related to this project.
 */
@Schema(description = "Contains links to resources related to this project.")
@JsonPropertyOrder({
    ProjectDataRelationships.JSON_PROPERTY_HUB,
    ProjectDataRelationships.JSON_PROPERTY_ROOT_FOLDER,
    ProjectDataRelationships.JSON_PROPERTY_TOP_FOLDERS,
    ProjectDataRelationships.JSON_PROPERTY_ISSUES,
    ProjectDataRelationships.JSON_PROPERTY_SUBMITTALS,
    ProjectDataRelationships.JSON_PROPERTY_RFIS,
    ProjectDataRelationships.JSON_PROPERTY_MARKUPS,
    ProjectDataRelationships.JSON_PROPERTY_CHECKLISTS,
    ProjectDataRelationships.JSON_PROPERTY_COST,
    ProjectDataRelationships.JSON_PROPERTY_LOCATIONS
})
@JsonTypeName("ProjectData_relationships")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProjectDataRelationships {
  public static final String JSON_PROPERTY_HUB = "hub";
  private JsonApiRelationshipsLinksInternalResource hub;

  public static final String JSON_PROPERTY_ROOT_FOLDER = "rootFolder";
  private JsonApiRelationshipsLinksRootFolder rootFolder;

  public static final String JSON_PROPERTY_TOP_FOLDERS = "topFolders";
  private ProjectDataRelationshipsTopFolders topFolders;

  public static final String JSON_PROPERTY_ISSUES = "issues";
  private JsonApiRelationshipsLinksOnlyBim issues;

  public static final String JSON_PROPERTY_SUBMITTALS = "submittals";
  private JsonApiRelationshipsLinksOnlyBim submittals;

  public static final String JSON_PROPERTY_RFIS = "rfis";
  private JsonApiRelationshipsLinksOnlyBim rfis;

  public static final String JSON_PROPERTY_MARKUPS = "markups";
  private JsonApiRelationshipsLinksOnlyBim markups;

  public static final String JSON_PROPERTY_CHECKLISTS = "checklists";
  private JsonApiRelationshipsLinksOnlyBim checklists;

  public static final String JSON_PROPERTY_COST = "cost";
  private JsonApiRelationshipsLinksOnlyBim cost;

  public static final String JSON_PROPERTY_LOCATIONS = "locations";
  private JsonApiRelationshipsLinksOnlyBim locations;

  public ProjectDataRelationships hub(JsonApiRelationshipsLinksInternalResource hub) {

    this.hub = hub;
    return this;
  }

  /**
   * Get hub
   * 
   * @return hub
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_HUB)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksInternalResource getHub() {
    return hub;
  }

  @JsonProperty(JSON_PROPERTY_HUB)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHub(JsonApiRelationshipsLinksInternalResource hub) {
    this.hub = hub;
  }

  public ProjectDataRelationships rootFolder(JsonApiRelationshipsLinksRootFolder rootFolder) {

    this.rootFolder = rootFolder;
    return this;
  }

  /**
   * Get rootFolder
   * 
   * @return rootFolder
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ROOT_FOLDER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksRootFolder getRootFolder() {
    return rootFolder;
  }

  @JsonProperty(JSON_PROPERTY_ROOT_FOLDER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRootFolder(JsonApiRelationshipsLinksRootFolder rootFolder) {
    this.rootFolder = rootFolder;
  }

  public ProjectDataRelationships topFolders(ProjectDataRelationshipsTopFolders topFolders) {

    this.topFolders = topFolders;
    return this;
  }

  /**
   * Get topFolders
   * 
   * @return topFolders
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TOP_FOLDERS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public ProjectDataRelationshipsTopFolders getTopFolders() {
    return topFolders;
  }

  @JsonProperty(JSON_PROPERTY_TOP_FOLDERS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTopFolders(ProjectDataRelationshipsTopFolders topFolders) {
    this.topFolders = topFolders;
  }

  public ProjectDataRelationships issues(JsonApiRelationshipsLinksOnlyBim issues) {

    this.issues = issues;
    return this;
  }

  /**
   * Get issues
   * 
   * @return issues
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ISSUES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getIssues() {
    return issues;
  }

  @JsonProperty(JSON_PROPERTY_ISSUES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIssues(JsonApiRelationshipsLinksOnlyBim issues) {
    this.issues = issues;
  }

  public ProjectDataRelationships submittals(JsonApiRelationshipsLinksOnlyBim submittals) {

    this.submittals = submittals;
    return this;
  }

  /**
   * Get submittals
   * 
   * @return submittals
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SUBMITTALS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getSubmittals() {
    return submittals;
  }

  @JsonProperty(JSON_PROPERTY_SUBMITTALS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSubmittals(JsonApiRelationshipsLinksOnlyBim submittals) {
    this.submittals = submittals;
  }

  public ProjectDataRelationships rfis(JsonApiRelationshipsLinksOnlyBim rfis) {

    this.rfis = rfis;
    return this;
  }

  /**
   * Get rfis
   * 
   * @return rfis
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_RFIS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getRfis() {
    return rfis;
  }

  @JsonProperty(JSON_PROPERTY_RFIS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRfis(JsonApiRelationshipsLinksOnlyBim rfis) {
    this.rfis = rfis;
  }

  public ProjectDataRelationships markups(JsonApiRelationshipsLinksOnlyBim markups) {

    this.markups = markups;
    return this;
  }

  /**
   * Get markups
   * 
   * @return markups
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_MARKUPS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getMarkups() {
    return markups;
  }

  @JsonProperty(JSON_PROPERTY_MARKUPS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMarkups(JsonApiRelationshipsLinksOnlyBim markups) {
    this.markups = markups;
  }

  public ProjectDataRelationships checklists(JsonApiRelationshipsLinksOnlyBim checklists) {

    this.checklists = checklists;
    return this;
  }

  /**
   * Get checklists
   * 
   * @return checklists
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CHECKLISTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getChecklists() {
    return checklists;
  }

  @JsonProperty(JSON_PROPERTY_CHECKLISTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setChecklists(JsonApiRelationshipsLinksOnlyBim checklists) {
    this.checklists = checklists;
  }

  public ProjectDataRelationships cost(JsonApiRelationshipsLinksOnlyBim cost) {

    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * 
   * @return cost
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_COST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getCost() {
    return cost;
  }

  @JsonProperty(JSON_PROPERTY_COST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCost(JsonApiRelationshipsLinksOnlyBim cost) {
    this.cost = cost;
  }

  public ProjectDataRelationships locations(JsonApiRelationshipsLinksOnlyBim locations) {

    this.locations = locations;
    return this;
  }

  /**
   * Get locations
   * 
   * @return locations
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LOCATIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiRelationshipsLinksOnlyBim getLocations() {
    return locations;
  }

  @JsonProperty(JSON_PROPERTY_LOCATIONS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLocations(JsonApiRelationshipsLinksOnlyBim locations) {
    this.locations = locations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectDataRelationships projectDataRelationships = (ProjectDataRelationships) o;
    return Objects.equals(this.hub, projectDataRelationships.hub) &&
        Objects.equals(this.rootFolder, projectDataRelationships.rootFolder) &&
        Objects.equals(this.topFolders, projectDataRelationships.topFolders) &&
        Objects.equals(this.issues, projectDataRelationships.issues) &&
        Objects.equals(this.submittals, projectDataRelationships.submittals) &&
        Objects.equals(this.rfis, projectDataRelationships.rfis) &&
        Objects.equals(this.markups, projectDataRelationships.markups) &&
        Objects.equals(this.checklists, projectDataRelationships.checklists) &&
        Objects.equals(this.cost, projectDataRelationships.cost) &&
        Objects.equals(this.locations, projectDataRelationships.locations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hub, rootFolder, topFolders, issues, submittals, rfis, markups, checklists, cost, locations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectDataRelationships {\n");
    sb.append("    hub: ").append(toIndentedString(hub)).append("\n");
    sb.append("    rootFolder: ").append(toIndentedString(rootFolder)).append("\n");
    sb.append("    topFolders: ").append(toIndentedString(topFolders)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
    sb.append("    submittals: ").append(toIndentedString(submittals)).append("\n");
    sb.append("    rfis: ").append(toIndentedString(rfis)).append("\n");
    sb.append("    markups: ").append(toIndentedString(markups)).append("\n");
    sb.append("    checklists: ").append(toIndentedString(checklists)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
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
