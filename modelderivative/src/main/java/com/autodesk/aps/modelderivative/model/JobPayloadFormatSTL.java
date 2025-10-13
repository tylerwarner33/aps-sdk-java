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
 * Describes the options for translation jobs producing STL outputs.
 */
@Schema(description = "Describes the options for translation jobs producing  STL outputs.")
@JsonPropertyOrder({
    JobPayloadFormatSTL.JSON_PROPERTY_TYPE,
    JobPayloadFormatSTL.JSON_PROPERTY_ADVANCED
})
@JsonTypeName("JobPayloadFormatSTL")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSTL implements JobPayloadFormat {
  public static final String JSON_PROPERTY_TYPE = "type";
  private OutputType type;

  public static final String JSON_PROPERTY_ADVANCED = "advanced";
  private JobPayloadFormatAdvancedSTL advanced;

  public JobPayloadFormatSTL type(OutputType type) {

    this.type = type;
    return this;
  }

  /**
   * Get type
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public OutputType getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(OutputType type) {
    this.type = type;
  }

  public JobPayloadFormatSTL advanced(JobPayloadFormatAdvancedSTL advanced) {

    this.advanced = advanced;
    return this;
  }

  /**
   * Get advanced
   * 
   * @return advanced
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ADVANCED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JobPayloadFormatAdvancedSTL getAdvanced() {
    return advanced;
  }

  @JsonProperty(JSON_PROPERTY_ADVANCED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAdvanced(JobPayloadFormatAdvancedSTL advanced) {
    this.advanced = advanced;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSTL jobPayloadFormatSTL = (JobPayloadFormatSTL) o;
    return Objects.equals(this.type, jobPayloadFormatSTL.type) &&
        Objects.equals(this.advanced, jobPayloadFormatSTL.advanced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, advanced);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSTL {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    advanced: ").append(toIndentedString(advanced)).append("\n");
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
