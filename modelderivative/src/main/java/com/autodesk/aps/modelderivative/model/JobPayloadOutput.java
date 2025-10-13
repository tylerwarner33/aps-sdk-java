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
 * Describes the attributes of the requested derivatives.
 */
@Schema(description = "Describes the attributes of the requested derivatives.")
@JsonPropertyOrder({
    JobPayloadOutput.JSON_PROPERTY_DESTINATION,
    JobPayloadOutput.JSON_PROPERTY_FORMATS
})
@JsonTypeName("JobPayload_output")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadOutput {
  public static final String JSON_PROPERTY_DESTINATION = "destination";
  private JobPayloadOutputDestination destination;

  public static final String JSON_PROPERTY_FORMATS = "formats";
  private List<JobPayloadFormat> formats = new ArrayList<>();

  public JobPayloadOutput destination(JobPayloadOutputDestination destination) {

    this.destination = destination;
    return this;
  }

  /**
   * Get destination
   * 
   * @return destination
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JobPayloadOutputDestination getDestination() {
    return destination;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDestination(JobPayloadOutputDestination destination) {
    this.destination = destination;
  }

  public JobPayloadOutput formats(List<JobPayloadFormat> formats) {

    this.formats = formats;
    return this;
  }

  public JobPayloadOutput addformatsItem(JobPayloadFormat formatsItem) {
    this.formats.add(formatsItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a requested derivative
   * format. You can request multiple derivatives.
   * 
   * @return formats
   **/
  @Schema(required = true, description = "An array of objects, where each object represents a requested derivative format. You can request multiple derivatives.")
  @JsonProperty(JSON_PROPERTY_FORMATS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<JobPayloadFormat> getFormats() {
    return formats;
  }

  @JsonProperty(JSON_PROPERTY_FORMATS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFormats(List<JobPayloadFormat> formats) {
    this.formats = formats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadOutput jobPayloadOutput = (JobPayloadOutput) o;
    return Objects.equals(this.destination, jobPayloadOutput.destination) &&
        Objects.equals(this.formats, jobPayloadOutput.formats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destination, formats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadOutput {\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    formats: ").append(toIndentedString(formats)).append("\n");
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
