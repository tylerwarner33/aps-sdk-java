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
 * The object containing the information on the command ID of the command
 * processor.
 */
@Schema(description = "The object containing the information on the command ID of the command processor.")
@JsonPropertyOrder({
    CreatedItemMeta.JSON_PROPERTY_BIM360_DM_COMMAND_ID
})
@JsonTypeName("CreatedItem_meta")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreatedItemMeta {
  public static final String JSON_PROPERTY_BIM360_DM_COMMAND_ID = "bim360DmCommandId";
  private String bim360DmCommandId;

  public CreatedItemMeta bim360DmCommandId(String bim360DmCommandId) {

    this.bim360DmCommandId = bim360DmCommandId;
    return this;
  }

  /**
   * The command id of the command processor. You can use this ID to check the
   * status of processing.
   * 
   * @return bim360DmCommandId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The command id of the command processor. You can use this ID to check the status of processing. ")
  @JsonProperty(JSON_PROPERTY_BIM360_DM_COMMAND_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getBim360DmCommandId() {
    return bim360DmCommandId;
  }

  @JsonProperty(JSON_PROPERTY_BIM360_DM_COMMAND_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setBim360DmCommandId(String bim360DmCommandId) {
    this.bim360DmCommandId = bim360DmCommandId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatedItemMeta createdItemMeta = (CreatedItemMeta) o;
    return Objects.equals(this.bim360DmCommandId, createdItemMeta.bim360DmCommandId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bim360DmCommandId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatedItemMeta {\n");
    sb.append("    bim360DmCommandId: ").append(toIndentedString(bim360DmCommandId)).append("\n");
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
