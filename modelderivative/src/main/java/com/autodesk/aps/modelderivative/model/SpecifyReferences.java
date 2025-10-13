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
 * Represents the successful response of a Specify References operation.
 */
@Schema(description = "Represents the successful response of a Specify References operation. ")
@JsonPropertyOrder({
    SpecifyReferences.JSON_PROPERTY_RESULT,
    SpecifyReferences.JSON_PROPERTY_URN
})
@JsonTypeName("SpecifyReferences")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SpecifyReferences {
  public static final String JSON_PROPERTY_RESULT = "result";
  private String result;

  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public SpecifyReferences result(String result) {

    this.result = result;
    return this;
  }

  /**
   * The result of the operation. Always &#x60;&#x60;success&#x60;&#x60; for
   * status &#x60;&#x60;200&#x60;&#x60;.
   * 
   * @return result
   **/
  @javax.annotation.Nullable
  @Schema(description = "The result of the operation. Always ``success`` for status ``200``.")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getResult() {
    return result;
  }

  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResult(String result) {
    this.result = result;
  }

  public SpecifyReferences urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URN of the top level component.
   * 
   * @return urn
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URN of the top level component.")
  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUrn() {
    return urn;
  }

  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUrn(String urn) {
    this.urn = urn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecifyReferences specifyReferences = (SpecifyReferences) o;
    return Objects.equals(this.result, specifyReferences.result) &&
        Objects.equals(this.urn, specifyReferences.urn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, urn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecifyReferences {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
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
