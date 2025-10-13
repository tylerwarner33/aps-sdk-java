/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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

package com.autodesk.aps.webhooks.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the extent to which the event is monitored. For example, if the
 * scope is folder, the webhooks service generates a notification for the
 * specified event occurring in any sub folder or item within that folder.
 */
@Schema(description = "Represents the extent to which the event is monitored. For example, if the scope is folder, the webhooks service generates a notification for the specified event occurring in any sub folder or item within that folder.")
@JsonPropertyOrder({
    HookDetailsScope.JSON_PROPERTY_FOLDER,
    HookDetailsScope.JSON_PROPERTY_WORKFLOW
})
@JsonTypeName("HookDetails_scope")
@JsonIgnoreProperties(ignoreUnknown = true)

public class HookDetailsScope {
  public static final String JSON_PROPERTY_FOLDER = "folder";
  private String folder;

  public static final String JSON_PROPERTY_WORKFLOW = "workflow";
  private String workflow;

  public HookDetailsScope folder(String folder) {

    this.folder = folder;
    return this;
  }

  /**
   * The URN of the folder the scope is set to. Present only for Data Management
   * events.
   * 
   * See [Creating a Webhook and Listening to Data Management
   * Events](/en/docs/webhooks/v1/tutorials/create-a-hook-data-management/) for
   * more information.
   * 
   * @return folder
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URN of the folder the scope is set to. Present only for Data Management events.   See [Creating a Webhook and Listening to Data Management Events](/en/docs/webhooks/v1/tutorials/create-a-hook-data-management/) for more information.")
  @JsonProperty(JSON_PROPERTY_FOLDER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getFolder() {
    return folder;
  }

  @JsonProperty(JSON_PROPERTY_FOLDER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFolder(String folder) {
    this.folder = folder;
  }

  public HookDetailsScope workflow(String workflow) {

    this.workflow = workflow;
    return this;
  }

  /**
   * The ID of a Model Derivative workflow the scope is set to. Present only for
   * Model Derivative events.
   * 
   * See [Creating a Webhook and Listening to Model Derivative
   * Events](/en/docs/webhooks/v1/tutorials/create-a-hook-model-derivative/) for
   * more information.
   * 
   * @return workflow
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of a Model Derivative workflow the scope is set to. Present only for Model Derivative events.  See [Creating a Webhook and Listening to Model Derivative Events](/en/docs/webhooks/v1/tutorials/create-a-hook-model-derivative/) for more information. ")
  @JsonProperty(JSON_PROPERTY_WORKFLOW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getWorkflow() {
    return workflow;
  }

  @JsonProperty(JSON_PROPERTY_WORKFLOW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setWorkflow(String workflow) {
    this.workflow = workflow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HookDetailsScope hookDetailsScope = (HookDetailsScope) o;
    return Objects.equals(this.folder, hookDetailsScope.folder) &&
        Objects.equals(this.workflow, hookDetailsScope.workflow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(folder, workflow);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HookDetailsScope {\n");
    sb.append("    folder: ").append(toIndentedString(folder)).append("\n");
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
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
