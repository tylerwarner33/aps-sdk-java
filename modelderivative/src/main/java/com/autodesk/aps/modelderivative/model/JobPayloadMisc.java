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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains webhook configuration settings for notifying external systems about
 * translation job events.
 */
@Schema(description = "Contains webhook configuration settings for notifying external systems about translation job events.")
@JsonPropertyOrder({
    JobPayloadMisc.JSON_PROPERTY_WORKFLOW,
    JobPayloadMisc.JSON_PROPERTY_WORKFLOW_ATTRIBUTE
})
@JsonTypeName("JobPayload_misc")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadMisc {
  public static final String JSON_PROPERTY_WORKFLOW = "workflow";
  private String workflow;

  public static final String JSON_PROPERTY_WORKFLOW_ATTRIBUTE = "workflowAttribute";
  private Object workflowAttribute;

  public JobPayloadMisc workflow(String workflow) {

    this.workflow = workflow;
    return this;
  }

  /**
   * The workflow ID of the webhook that listens to Model Derivative events. It
   * must be 36 characters or less and can only contain alphanumeric characters
   * (A-Z, 0-9) and hyphens (-).
   * 
   * @return workflow
   **/
  @javax.annotation.Nullable
  @Schema(description = "The workflow ID of the webhook that listens to Model Derivative events. It must be 36 characters or less and can only contain alphanumeric characters (A-Z, 0-9) and hyphens (-).")
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

  public JobPayloadMisc workflowAttribute(Object workflowAttribute) {

    this.workflowAttribute = workflowAttribute;
    return this;
  }

  /**
   * A user-defined JSON object, which you can use to set some custom workflow
   * information. It must be less than 1KB and is ignored if
   * &#x60;&#x60;misc.workflow&#x60;&#x60; is not specified.
   * 
   * @return workflowAttribute
   **/
  @javax.annotation.Nullable
  @Schema(description = "A user-defined JSON object, which you can use to set some custom workflow information. It must be less than 1KB and is ignored if ``misc.workflow`` is not specified.")
  @JsonProperty(JSON_PROPERTY_WORKFLOW_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getWorkflowAttribute() {
    return workflowAttribute;
  }

  @JsonProperty(JSON_PROPERTY_WORKFLOW_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setWorkflowAttribute(Object workflowAttribute) {
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
    JobPayloadMisc jobPayloadMisc = (JobPayloadMisc) o;
    return Objects.equals(this.workflow, jobPayloadMisc.workflow) &&
        Objects.equals(this.workflowAttribute, jobPayloadMisc.workflowAttribute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflow, workflowAttribute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadMisc {\n");
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
