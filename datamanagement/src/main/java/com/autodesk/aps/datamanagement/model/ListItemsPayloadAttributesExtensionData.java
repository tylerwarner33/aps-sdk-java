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
 * Contains the custom properties specific to the
 * ListItems command.
 */
@Schema(description = "Contains the custom properties specific to the  ListItems command.")
@JsonPropertyOrder({
    ListItemsPayloadAttributesExtensionData.JSON_PROPERTY_INCLUDE_PATH_IN_PROJECT
})
@JsonTypeName("ListItemsPayload_attributes_extension_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ListItemsPayloadAttributesExtensionData {
  public static final String JSON_PROPERTY_INCLUDE_PATH_IN_PROJECT = "includePathInProject";
  private Boolean includePathInProject;

  public ListItemsPayloadAttributesExtensionData includePathInProject(Boolean includePathInProject) {

    this.includePathInProject = includePathInProject;
    return this;
  }

  /**
   * Specify whether to return the
   * &#x60;&#x60;pathInProject&#x60;&#x60; attribute in response
   * for BIM 360 Docs projects.
   * &#x60;&#x60;pathInProject&#x60;&#x60; is the path to
   * the item relative to the project’s root folder.
   * 
   * - &#x60;&#x60;true&#x60;&#x60;: Response will contain the
   * &#x60;&#x60;pathInProject&#x60;&#x60; attribute for BIM 360 Docs projects.
   * - &#x60;&#x60;false&#x60;&#x60;: (Default) response will not contain the
   * &#x60;&#x60;pathInProject&#x60;&#x60; attribute for BIM 360 Docs projects.
   * 
   * Setting this parameter to &#x60;&#x60;true&#x60;&#x60; on a
   * non-BIM 360 Docs project results in an error.
   * 
   * @return includePathInProject
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specify whether to return the  ``pathInProject`` attribute in response  for BIM 360 Docs projects.  ``pathInProject`` is the path to  the item relative to the project’s root folder.  - ``true``: Response will contain the ``pathInProject`` attribute for BIM 360 Docs projects. - ``false``: (Default) response will not contain the ``pathInProject`` attribute for BIM 360 Docs projects.  Setting this parameter to ``true`` on a  non-BIM 360 Docs project results in an error.")
  @JsonProperty(JSON_PROPERTY_INCLUDE_PATH_IN_PROJECT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getIncludePathInProject() {
    return includePathInProject;
  }

  @JsonProperty(JSON_PROPERTY_INCLUDE_PATH_IN_PROJECT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIncludePathInProject(Boolean includePathInProject) {
    this.includePathInProject = includePathInProject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListItemsPayloadAttributesExtensionData listItemsPayloadAttributesExtensionData = (ListItemsPayloadAttributesExtensionData) o;
    return Objects.equals(this.includePathInProject, listItemsPayloadAttributesExtensionData.includePathInProject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(includePathInProject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListItemsPayloadAttributesExtensionData {\n");
    sb.append("    includePathInProject: ").append(toIndentedString(includePathInProject)).append("\n");
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
