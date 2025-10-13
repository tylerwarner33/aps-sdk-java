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
 * Contains advanced configuration settings for translation jobs producing
 * &#x60;obj&#x60; outputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs producing `obj` outputs.")
@JsonPropertyOrder({
    JobPayloadFormatAdvancedOBJ.JSON_PROPERTY_TYPE,
    JobPayloadFormatAdvancedOBJ.JSON_PROPERTY_ADVANCED
})
@JsonTypeName("JobPayloadFormatAdvancedOBJ")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatAdvancedOBJ {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_ADVANCED = "advanced";
  private JobPayloadFormatAdvancedOBJAdvanced advanced;

  public JobPayloadFormatAdvancedOBJ type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The requested output type. &#x60;&#x60;obj&#x60;&#x60; in this case.
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "The requested output type. ``obj`` in this case.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(String type) {
    this.type = type;
  }

  public JobPayloadFormatAdvancedOBJ advanced(JobPayloadFormatAdvancedOBJAdvanced advanced) {

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

  public JobPayloadFormatAdvancedOBJAdvanced getAdvanced() {
    return advanced;
  }

  @JsonProperty(JSON_PROPERTY_ADVANCED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAdvanced(JobPayloadFormatAdvancedOBJAdvanced advanced) {
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
    JobPayloadFormatAdvancedOBJ jobPayloadFormatAdvancedOBJ = (JobPayloadFormatAdvancedOBJ) o;
    return Objects.equals(this.type, jobPayloadFormatAdvancedOBJ.type) &&
        Objects.equals(this.advanced, jobPayloadFormatAdvancedOBJ.advanced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, advanced);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatAdvancedOBJ {\n");
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
