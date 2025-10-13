/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Model Derivative
 * Use the Model Derivative API to translate designs from one CAD format to another. You can also use this API to extract metadata from a model.
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

package com.autodesk.aps.modelderivative.model;

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
 * Contains advanced configuration settings for translation jobs processing DGN
 * inputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs processing  DGN inputs.")
@JsonPropertyOrder({
    JobPayloadFormatSVF2AdvancedDGN.JSON_PROPERTY_REQUESTED_LINKAGE_I_DS
})
@JsonTypeName("JobPayloadFormatSVF2AdvancedDGN")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSVF2AdvancedDGN implements JobPayloadFormatSVF2Advanced {
  public static final String JSON_PROPERTY_REQUESTED_LINKAGE_I_DS = "requestedLinkageIDs";
  private List<Integer> requestedLinkageIDs = null;

  public JobPayloadFormatSVF2AdvancedDGN requestedLinkageIDs(List<Integer> requestedLinkageIDs) {

    this.requestedLinkageIDs = requestedLinkageIDs;
    return this;
  }

  public JobPayloadFormatSVF2AdvancedDGN addrequestedLinkageIDsItem(Integer requestedLinkageIDsItem) {
    if (this.requestedLinkageIDs == null) {
      this.requestedLinkageIDs = new ArrayList<>();
    }
    this.requestedLinkageIDs.add(requestedLinkageIDsItem);
    return this;
  }

  /**
   * An array containing user data linkage IDs of the linkage data to be extracted
   * from the DGN file. Linkage data is not extracted if you do not specify this
   * attribute.
   * 
   * @return requestedLinkageIDs
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array containing user data linkage IDs of the linkage data to be extracted from the DGN file. Linkage data is not extracted if you do not specify this attribute.")
  @JsonProperty(JSON_PROPERTY_REQUESTED_LINKAGE_I_DS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Integer> getRequestedLinkageIDs() {
    return requestedLinkageIDs;
  }

  @JsonProperty(JSON_PROPERTY_REQUESTED_LINKAGE_I_DS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRequestedLinkageIDs(List<Integer> requestedLinkageIDs) {
    this.requestedLinkageIDs = requestedLinkageIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSVF2AdvancedDGN jobPayloadFormatSVF2AdvancedDGN = (JobPayloadFormatSVF2AdvancedDGN) o;
    return Objects.equals(this.requestedLinkageIDs, jobPayloadFormatSVF2AdvancedDGN.requestedLinkageIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestedLinkageIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSVF2AdvancedDGN {\n");
    sb.append("    requestedLinkageIDs: ").append(toIndentedString(requestedLinkageIDs)).append("\n");
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
