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
 * &#x60;stl&#x60; outputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs producing `stl` outputs.")
@JsonPropertyOrder({
    JobPayloadFormatAdvancedSTLAdvanced.JSON_PROPERTY_FORMAT,
    JobPayloadFormatAdvancedSTLAdvanced.JSON_PROPERTY_EXPORT_COLOR,
    JobPayloadFormatAdvancedSTLAdvanced.JSON_PROPERTY_EXPORT_FILE_STRUCTURE
})
@JsonTypeName("JobPayloadFormatAdvancedSTL_advanced")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatAdvancedSTLAdvanced {
  public static final String JSON_PROPERTY_FORMAT = "format";
  private Format format = Format.BINARY;

  public static final String JSON_PROPERTY_EXPORT_COLOR = "exportColor";
  private Boolean exportColor = true;

  public static final String JSON_PROPERTY_EXPORT_FILE_STRUCTURE = "exportFileStructure";
  private ExportFileStructure exportFileStructure = ExportFileStructure.SINGLE;

  public JobPayloadFormatAdvancedSTLAdvanced format(Format format) {

    this.format = format;
    return this;
  }

  /**
   * Get format
   * 
   * @return format
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Format getFormat() {
    return format;
  }

  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFormat(Format format) {
    this.format = format;
  }

  public JobPayloadFormatAdvancedSTLAdvanced exportColor(Boolean exportColor) {

    this.exportColor = exportColor;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60;- (Default) Exports color.
   * - &#x60;&#x60;false&#x60;&#x60; - Does not export color.
   * 
   * @return exportColor
   **/
  @javax.annotation.Nullable
  @Schema(description = "- ``true``- (Default) Exports color. - ``false`` - Does not export color. ")
  @JsonProperty(JSON_PROPERTY_EXPORT_COLOR)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getExportColor() {
    return exportColor;
  }

  @JsonProperty(JSON_PROPERTY_EXPORT_COLOR)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExportColor(Boolean exportColor) {
    this.exportColor = exportColor;
  }

  public JobPayloadFormatAdvancedSTLAdvanced exportFileStructure(ExportFileStructure exportFileStructure) {

    this.exportFileStructure = exportFileStructure;
    return this;
  }

  /**
   * Get exportFileStructure
   * 
   * @return exportFileStructure
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EXPORT_FILE_STRUCTURE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public ExportFileStructure getExportFileStructure() {
    return exportFileStructure;
  }

  @JsonProperty(JSON_PROPERTY_EXPORT_FILE_STRUCTURE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExportFileStructure(ExportFileStructure exportFileStructure) {
    this.exportFileStructure = exportFileStructure;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatAdvancedSTLAdvanced jobPayloadFormatAdvancedSTLAdvanced = (JobPayloadFormatAdvancedSTLAdvanced) o;
    return Objects.equals(this.format, jobPayloadFormatAdvancedSTLAdvanced.format) &&
        Objects.equals(this.exportColor, jobPayloadFormatAdvancedSTLAdvanced.exportColor) &&
        Objects.equals(this.exportFileStructure, jobPayloadFormatAdvancedSTLAdvanced.exportFileStructure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(format, exportColor, exportFileStructure);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatAdvancedSTLAdvanced {\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    exportColor: ").append(toIndentedString(exportColor)).append("\n");
    sb.append("    exportFileStructure: ").append(toIndentedString(exportFileStructure)).append("\n");
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
