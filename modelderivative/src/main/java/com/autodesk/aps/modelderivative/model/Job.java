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
 * Represents the successful response of a Create Translation Job operation.
 */
@Schema(description = "Represents the successful response of a Create Translation Job operation.")
@JsonPropertyOrder({
    Job.JSON_PROPERTY_RESULT,
    Job.JSON_PROPERTY_URN,
    Job.JSON_PROPERTY_ACCEPTED_JOBS
})
@JsonTypeName("Job")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Job {
  public static final String JSON_PROPERTY_RESULT = "result";
  private String result;

  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_ACCEPTED_JOBS = "acceptedJobs";
  private JobAcceptedJobs acceptedJobs;

  public Job result(String result) {

    this.result = result;
    return this;
  }

  /**
   * reporting success status
   * 
   * @return result
   **/
  @Schema(required = true, description = "reporting success status")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResult() {
    return result;
  }

  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResult(String result) {
    this.result = result;
  }

  public Job urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * the urn identifier of the source file
   * 
   * @return urn
   **/
  @Schema(required = true, description = "the urn identifier of the source file")
  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrn() {
    return urn;
  }

  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrn(String urn) {
    this.urn = urn;
  }

  public Job acceptedJobs(JobAcceptedJobs acceptedJobs) {

    this.acceptedJobs = acceptedJobs;
    return this;
  }

  /**
   * Get acceptedJobs
   * 
   * @return acceptedJobs
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_ACCEPTED_JOBS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JobAcceptedJobs getAcceptedJobs() {
    return acceptedJobs;
  }

  @JsonProperty(JSON_PROPERTY_ACCEPTED_JOBS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAcceptedJobs(JobAcceptedJobs acceptedJobs) {
    this.acceptedJobs = acceptedJobs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Job job = (Job) o;
    return Objects.equals(this.result, job.result) &&
        Objects.equals(this.urn, job.urn) &&
        Objects.equals(this.acceptedJobs, job.acceptedJobs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, urn, acceptedJobs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Job {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    acceptedJobs: ").append(toIndentedString(acceptedJobs)).append("\n");
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
