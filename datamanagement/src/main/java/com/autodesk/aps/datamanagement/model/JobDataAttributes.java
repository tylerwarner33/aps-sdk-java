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
 * Contains the properties that indicate the current status of the job.
 */
@Schema(description = "Contains the properties that indicate the current status of the job.")
@JsonPropertyOrder({
    JobDataAttributes.JSON_PROPERTY_STATUS
})
@JsonTypeName("Job_data_attributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobDataAttributes {
  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public JobDataAttributes status(String status) {

    this.status = status;
    return this;
  }

  /**
   * Indicates the current status of the job, while the job is
   * &#x60;&#x60;queued&#x60;&#x60;, &#x60;&#x60;processing&#x60;&#x60;, or
   * &#x60;&#x60;failed&#x60;&#x60;. If the job is finished, the server returns a
   * HTTP 303 status with the &#x60;&#x60;location&#x60;&#x60; header set to the
   * URI to use to fetch the details of the download.
   * 
   * @return status
   **/
  @javax.annotation.Nullable
  @Schema(description = "Indicates the current status of the job, while the job is ``queued``, ``processing``, or ``failed``. If the job is finished, the server returns a HTTP 303 status with the ``location`` header set to the URI to use to fetch the details of the download.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobDataAttributes jobDataAttributes = (JobDataAttributes) o;
    return Objects.equals(this.status, jobDataAttributes.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobDataAttributes {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
