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
 * Meta information required for webhooks.
 */
@Schema(description = "Meta information required for webhooks.")
@JsonPropertyOrder({
    MetaForWebhooks.JSON_PROPERTY_WORKFLOW,
    MetaForWebhooks.JSON_PROPERTY_WORKFLOW_ATTRIBUTE
})
@JsonTypeName("metaForWebhooks")
@JsonIgnoreProperties(ignoreUnknown = true)

public class MetaForWebhooks {
  public static final String JSON_PROPERTY_WORKFLOW = "workflow";
  private String workflow;

  public static final String JSON_PROPERTY_WORKFLOW_ATTRIBUTE = "workflowAttribute";
  private String workflowAttribute;

  public MetaForWebhooks workflow(String workflow) {

    this.workflow = workflow;
    return this;
  }

  /**
   * The Workflow ID of a webhook that listens to Model Derivative events. Must be
   * less than 36 characters.
   * Only ASCII characters (a-z, A-Z, 0-9), periods (.), and hyphens (-) are
   * accepted.
   * See the [Creating a Webhook and Listening to
   * Events](/en/docs/webhooks/v1/tutorials/create-a-hook-model-derivative)
   * tutorial for more information.
   ** 
   * Note**: This attribute applies to BIM 360 Docs only.
   * 
   * @return workflow
   **/
  @Schema(required = true, description = "The Workflow ID of a webhook that listens to Model Derivative events. Must be less than 36 characters.  Only ASCII characters (a-z, A-Z, 0-9), periods (.), and hyphens (-) are accepted. See the [Creating a Webhook and Listening to Events](/en/docs/webhooks/v1/tutorials/create-a-hook-model-derivative) tutorial for more information.  **Note**: This attribute applies to BIM 360 Docs only. ")
  @JsonProperty(JSON_PROPERTY_WORKFLOW)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getWorkflow() {
    return workflow;
  }

  @JsonProperty(JSON_PROPERTY_WORKFLOW)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setWorkflow(String workflow) {
    this.workflow = workflow;
  }

  public MetaForWebhooks workflowAttribute(String workflowAttribute) {

    this.workflowAttribute = workflowAttribute;
    return this;
  }

  /**
   * A user defined JSON object containing custom workflow information for the
   * specified webhook event. Must be less than 1KB.
   ** 
   * Note**: Applicable only if a valid value has been specified for
   * &#x60;&#x60;meta.workflow&#x60;&#x60;.
   * 
   * @return workflowAttribute
   **/
  @javax.annotation.Nullable
  @Schema(description = "A user defined JSON object containing custom workflow information for the specified webhook event. Must be less than 1KB.  **Note**: Applicable only if a valid value has been specified for ``meta.workflow``.  ")
  @JsonProperty(JSON_PROPERTY_WORKFLOW_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getWorkflowAttribute() {
    return workflowAttribute;
  }

  @JsonProperty(JSON_PROPERTY_WORKFLOW_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setWorkflowAttribute(String workflowAttribute) {
    this.workflowAttribute = workflowAttribute;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaForWebhooks metaForWebhooks = (MetaForWebhooks) o;
    return Objects.equals(this.workflow, metaForWebhooks.workflow) &&
        Objects.equals(this.workflowAttribute, metaForWebhooks.workflowAttribute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflow, workflowAttribute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaForWebhooks {\n");
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
    sb.append("    workflowAttribute: ").append(toIndentedString(workflowAttribute)).append("\n");
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
