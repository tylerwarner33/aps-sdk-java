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
 * Contains advanced configuration settings for translation jobs producing a
 * STEP output.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs producing a STEP output.")
@JsonPropertyOrder({
    JobPayloadFormatAdvancedSTEP.JSON_PROPERTY_APPLICATION_PROTOCOL,
    JobPayloadFormatAdvancedSTEP.JSON_PROPERTY_TOLERANCE
})
@JsonTypeName("JobPayloadFormatAdvancedSTEP")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatAdvancedSTEP {
  public static final String JSON_PROPERTY_APPLICATION_PROTOCOL = "applicationProtocol";
  private ApplicationProtocol applicationProtocol = ApplicationProtocol._214;

  public static final String JSON_PROPERTY_TOLERANCE = "tolerance";
  private Float tolerance = 0.001f;

  public JobPayloadFormatAdvancedSTEP applicationProtocol(ApplicationProtocol applicationProtocol) {

    this.applicationProtocol = applicationProtocol;
    return this;
  }

  /**
   * Get applicationProtocol
   * 
   * @return applicationProtocol
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_APPLICATION_PROTOCOL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public ApplicationProtocol getApplicationProtocol() {
    return applicationProtocol;
  }

  @JsonProperty(JSON_PROPERTY_APPLICATION_PROTOCOL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setApplicationProtocol(ApplicationProtocol applicationProtocol) {
    this.applicationProtocol = applicationProtocol;
  }

  public JobPayloadFormatAdvancedSTEP tolerance(Float tolerance) {

    this.tolerance = tolerance;
    return this;
  }

  /**
   * Possible values are between &#x60;0&#x60; and &#x60;1&#x60;. By default it is
   * set at 0.001.
   * 
   * @return tolerance
   **/
  @javax.annotation.Nullable
  @Schema(description = "Possible values are between `0` and `1`. By default it is set at 0.001.")
  @JsonProperty(JSON_PROPERTY_TOLERANCE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Float getTolerance() {
    return tolerance;
  }

  @JsonProperty(JSON_PROPERTY_TOLERANCE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTolerance(Float tolerance) {
    this.tolerance = tolerance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatAdvancedSTEP jobPayloadFormatAdvancedSTEP = (JobPayloadFormatAdvancedSTEP) o;
    return Objects.equals(this.applicationProtocol, jobPayloadFormatAdvancedSTEP.applicationProtocol) &&
        Objects.equals(this.tolerance, jobPayloadFormatAdvancedSTEP.tolerance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationProtocol, tolerance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatAdvancedSTEP {\n");
    sb.append("    applicationProtocol: ").append(toIndentedString(applicationProtocol)).append("\n");
    sb.append("    tolerance: ").append(toIndentedString(tolerance)).append("\n");
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
