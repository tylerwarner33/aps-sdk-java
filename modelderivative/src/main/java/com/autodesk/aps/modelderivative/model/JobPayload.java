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
 * Represents the request body of a Create Translation Job operation.
 */
@Schema(description = "Represents the request body of a Create Translation Job operation.")
@JsonPropertyOrder({
    JobPayload.JSON_PROPERTY_INPUT,
    JobPayload.JSON_PROPERTY_OUTPUT,
    JobPayload.JSON_PROPERTY_MISC
})
@JsonTypeName("JobPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayload {
  public static final String JSON_PROPERTY_INPUT = "input";
  private JobPayloadInput input;

  public static final String JSON_PROPERTY_OUTPUT = "output";
  private JobPayloadOutput output;

  public static final String JSON_PROPERTY_MISC = "misc";
  private JobPayloadMisc misc;

  public JobPayload input(JobPayloadInput input) {

    this.input = input;
    return this;
  }

  /**
   * Get input
   * 
   * @return input
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_INPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JobPayloadInput getInput() {
    return input;
  }

  @JsonProperty(JSON_PROPERTY_INPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInput(JobPayloadInput input) {
    this.input = input;
  }

  public JobPayload output(JobPayloadOutput output) {

    this.output = output;
    return this;
  }

  /**
   * Get output
   * 
   * @return output
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JobPayloadOutput getOutput() {
    return output;
  }

  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOutput(JobPayloadOutput output) {
    this.output = output;
  }

  public JobPayload misc(JobPayloadMisc misc) {

    this.misc = misc;
    return this;
  }

  /**
   * Get misc
   * 
   * @return misc
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_MISC)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JobPayloadMisc getMisc() {
    return misc;
  }

  @JsonProperty(JSON_PROPERTY_MISC)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMisc(JobPayloadMisc misc) {
    this.misc = misc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayload jobPayload = (JobPayload) o;
    return Objects.equals(this.input, jobPayload.input) &&
        Objects.equals(this.output, jobPayload.output) &&
        Objects.equals(this.misc, jobPayload.misc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output, misc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayload {\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    misc: ").append(toIndentedString(misc)).append("\n");
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
