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
 * Contains advanced configuration settings for translation jobs producing IGES
 * outputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs producing IGES outputs.")
@JsonPropertyOrder({
    JobPayloadFormatAdvancedIGES.JSON_PROPERTY_TOLERANCE,
    JobPayloadFormatAdvancedIGES.JSON_PROPERTY_SURFACE_TYPE,
    JobPayloadFormatAdvancedIGES.JSON_PROPERTY_SHEET_TYPE,
    JobPayloadFormatAdvancedIGES.JSON_PROPERTY_SOLID_TYPE
})
@JsonTypeName("JobPayloadFormatAdvancedIGES")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatAdvancedIGES {
  public static final String JSON_PROPERTY_TOLERANCE = "tolerance";
  private Float tolerance = 0.001f;

  public static final String JSON_PROPERTY_SURFACE_TYPE = "surfaceType";
  private SurfaceType surfaceType = SurfaceType.BOUNDED;

  public static final String JSON_PROPERTY_SHEET_TYPE = "sheetType";
  private SheetType sheetType = SheetType.SURFACE;

  public static final String JSON_PROPERTY_SOLID_TYPE = "solidType";
  private SolidType solidType = SolidType.SOLID;

  public JobPayloadFormatAdvancedIGES tolerance(Float tolerance) {

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

  public JobPayloadFormatAdvancedIGES surfaceType(SurfaceType surfaceType) {

    this.surfaceType = surfaceType;
    return this;
  }

  /**
   * Get surfaceType
   * 
   * @return surfaceType
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SURFACE_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public SurfaceType getSurfaceType() {
    return surfaceType;
  }

  @JsonProperty(JSON_PROPERTY_SURFACE_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSurfaceType(SurfaceType surfaceType) {
    this.surfaceType = surfaceType;
  }

  public JobPayloadFormatAdvancedIGES sheetType(SheetType sheetType) {

    this.sheetType = sheetType;
    return this;
  }

  /**
   * Get sheetType
   * 
   * @return sheetType
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SHEET_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public SheetType getSheetType() {
    return sheetType;
  }

  @JsonProperty(JSON_PROPERTY_SHEET_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSheetType(SheetType sheetType) {
    this.sheetType = sheetType;
  }

  public JobPayloadFormatAdvancedIGES solidType(SolidType solidType) {

    this.solidType = solidType;
    return this;
  }

  /**
   * Get solidType
   * 
   * @return solidType
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SOLID_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public SolidType getSolidType() {
    return solidType;
  }

  @JsonProperty(JSON_PROPERTY_SOLID_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSolidType(SolidType solidType) {
    this.solidType = solidType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatAdvancedIGES jobPayloadFormatAdvancedIGES = (JobPayloadFormatAdvancedIGES) o;
    return Objects.equals(this.tolerance, jobPayloadFormatAdvancedIGES.tolerance) &&
        Objects.equals(this.surfaceType, jobPayloadFormatAdvancedIGES.surfaceType) &&
        Objects.equals(this.sheetType, jobPayloadFormatAdvancedIGES.sheetType) &&
        Objects.equals(this.solidType, jobPayloadFormatAdvancedIGES.solidType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tolerance, surfaceType, sheetType, solidType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatAdvancedIGES {\n");
    sb.append("    tolerance: ").append(toIndentedString(tolerance)).append("\n");
    sb.append("    surfaceType: ").append(toIndentedString(surfaceType)).append("\n");
    sb.append("    sheetType: ").append(toIndentedString(sheetType)).append("\n");
    sb.append("    solidType: ").append(toIndentedString(solidType)).append("\n");
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
