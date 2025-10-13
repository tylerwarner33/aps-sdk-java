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
 * Contains information about the error that occurred.
 */
@Schema(description = "Contains information about the error that occurred.")
@JsonPropertyOrder({
    GetHubs403ResponseMeta.JSON_PROPERTY_WARNINGS
})
@JsonTypeName("getHubs_403_response_meta")
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetHubs403ResponseMeta {
  public static final String JSON_PROPERTY_WARNINGS = "warnings";
  private List<GetHubs403ResponseMetaWarnings> warnings = null;

  public GetHubs403ResponseMeta warnings(List<GetHubs403ResponseMetaWarnings> warnings) {

    this.warnings = warnings;
    return this;
  }

  public GetHubs403ResponseMeta addwarningsItem(GetHubs403ResponseMetaWarnings warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

  /**
   * An array of objects, where each element of the array represents a warning.
   * 
   * @return warnings
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each element of the array represents a warning.")
  @JsonProperty(JSON_PROPERTY_WARNINGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<GetHubs403ResponseMetaWarnings> getWarnings() {
    return warnings;
  }

  @JsonProperty(JSON_PROPERTY_WARNINGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setWarnings(List<GetHubs403ResponseMetaWarnings> warnings) {
    this.warnings = warnings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetHubs403ResponseMeta getHubs403ResponseMeta = (GetHubs403ResponseMeta) o;
    return Objects.equals(this.warnings, getHubs403ResponseMeta.warnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(warnings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetHubs403ResponseMeta {\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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
