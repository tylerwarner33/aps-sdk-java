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
 * Contains advanced configuration settings for translation jobs producing IFC
 * outputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs producing IFC outputs.")
@JsonPropertyOrder({
    JobPayloadFormatAdvancedIFC.JSON_PROPERTY_EXPORT_SETTING_NAME
})
@JsonTypeName("JobPayloadFormatAdvancedIFC")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatAdvancedIFC {
  public static final String JSON_PROPERTY_EXPORT_SETTING_NAME = "exportSettingName";
  private String exportSettingName;

  public JobPayloadFormatAdvancedIFC exportSettingName(String exportSettingName) {

    this.exportSettingName = exportSettingName;
    return this;
  }

  /**
   * The export settings should be one of the IFC Export settings pre-saved in the
   * source design.
   * 
   * @return exportSettingName
   **/
  @javax.annotation.Nullable
  @Schema(description = "The export settings should be one of the IFC Export settings pre-saved in the source design.")
  @JsonProperty(JSON_PROPERTY_EXPORT_SETTING_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getExportSettingName() {
    return exportSettingName;
  }

  @JsonProperty(JSON_PROPERTY_EXPORT_SETTING_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExportSettingName(String exportSettingName) {
    this.exportSettingName = exportSettingName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatAdvancedIFC jobPayloadFormatAdvancedIFC = (JobPayloadFormatAdvancedIFC) o;
    return Objects.equals(this.exportSettingName, jobPayloadFormatAdvancedIFC.exportSettingName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exportSettingName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatAdvancedIFC {\n");
    sb.append("    exportSettingName: ").append(toIndentedString(exportSettingName)).append("\n");
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
