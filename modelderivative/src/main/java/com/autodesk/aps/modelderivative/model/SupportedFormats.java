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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the successful response of a List Supported Formats operation.
 */
@Schema(description = "Represents the successful response of a List Supported Formats operation.")
@JsonPropertyOrder({
    SupportedFormats.JSON_PROPERTY_FORMATS
})
@JsonTypeName("SupportedFormats")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SupportedFormats {
  public static final String JSON_PROPERTY_FORMATS = "formats";
  private Map<String, List<String>> formats = null;

  public SupportedFormats formats(Map<String, List<String>> formats) {

    this.formats = formats;
    return this;
  }

  public SupportedFormats putformatsItem(String key, List<String> formatsItem) {
    if (this.formats == null) {
      this.formats = new HashMap<>();
    }
    this.formats.put(key, formatsItem);
    return this;
  }

  /**
   * A dictionary object that contains a collection of key-value pairs, where each
   * pair represents the target file format and the corresponding source file
   * formats.
   * 
   * @return formats
   **/
  @javax.annotation.Nullable
  @Schema(description = "A dictionary object that contains a collection of key-value pairs, where each pair represents the target file format and the corresponding source file formats.")
  @JsonProperty(JSON_PROPERTY_FORMATS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Map<String, List<String>> getFormats() {
    return formats;
  }

  @JsonProperty(JSON_PROPERTY_FORMATS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFormats(Map<String, List<String>> formats) {
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
    SupportedFormats supportedFormats = (SupportedFormats) o;
    return Objects.equals(this.formats, supportedFormats.formats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupportedFormats {\n");
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
