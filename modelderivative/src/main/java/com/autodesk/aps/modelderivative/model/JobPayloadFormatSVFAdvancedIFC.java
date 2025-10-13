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
 * Contains advanced configuration settings for translation jobs processing IFC
 * inputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs processing IFC inputs.")
@JsonPropertyOrder({
    JobPayloadFormatSVFAdvancedIFC.JSON_PROPERTY_CONVERSION_METHOD,
    JobPayloadFormatSVFAdvancedIFC.JSON_PROPERTY_BUILDING_STOREYS,
    JobPayloadFormatSVFAdvancedIFC.JSON_PROPERTY_SPACES,
    JobPayloadFormatSVFAdvancedIFC.JSON_PROPERTY_OPENING_ELEMENTS
})
@JsonTypeName("JobPayloadFormatSVFAdvancedIFC")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSVFAdvancedIFC implements JobPayloadFormatSVFAdvanced {
  public static final String JSON_PROPERTY_CONVERSION_METHOD = "conversionMethod";
  private ConversionMethod conversionMethod;

  public static final String JSON_PROPERTY_BUILDING_STOREYS = "buildingStoreys";
  private BuildingStoreys buildingStoreys;

  public static final String JSON_PROPERTY_SPACES = "spaces";
  private Spaces spaces;

  public static final String JSON_PROPERTY_OPENING_ELEMENTS = "openingElements";
  private OpeningElements openingElements;

  public JobPayloadFormatSVFAdvancedIFC conversionMethod(ConversionMethod conversionMethod) {

    this.conversionMethod = conversionMethod;
    return this;
  }

  /**
   * Get conversionMethod
   * 
   * @return conversionMethod
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CONVERSION_METHOD)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public ConversionMethod getConversionMethod() {
    return conversionMethod;
  }

  @JsonProperty(JSON_PROPERTY_CONVERSION_METHOD)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setConversionMethod(ConversionMethod conversionMethod) {
    this.conversionMethod = conversionMethod;
  }

  public JobPayloadFormatSVFAdvancedIFC buildingStoreys(BuildingStoreys buildingStoreys) {

    this.buildingStoreys = buildingStoreys;
    return this;
  }

  /**
   * Get buildingStoreys
   * 
   * @return buildingStoreys
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_BUILDING_STOREYS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public BuildingStoreys getBuildingStoreys() {
    return buildingStoreys;
  }

  @JsonProperty(JSON_PROPERTY_BUILDING_STOREYS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setBuildingStoreys(BuildingStoreys buildingStoreys) {
    this.buildingStoreys = buildingStoreys;
  }

  public JobPayloadFormatSVFAdvancedIFC spaces(Spaces spaces) {

    this.spaces = spaces;
    return this;
  }

  /**
   * Get spaces
   * 
   * @return spaces
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SPACES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Spaces getSpaces() {
    return spaces;
  }

  @JsonProperty(JSON_PROPERTY_SPACES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSpaces(Spaces spaces) {
    this.spaces = spaces;
  }

  public JobPayloadFormatSVFAdvancedIFC openingElements(OpeningElements openingElements) {

    this.openingElements = openingElements;
    return this;
  }

  /**
   * Get openingElements
   * 
   * @return openingElements
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_OPENING_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public OpeningElements getOpeningElements() {
    return openingElements;
  }

  @JsonProperty(JSON_PROPERTY_OPENING_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setOpeningElements(OpeningElements openingElements) {
    this.openingElements = openingElements;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSVFAdvancedIFC jobPayloadFormatSVFAdvancedIFC = (JobPayloadFormatSVFAdvancedIFC) o;
    return Objects.equals(this.conversionMethod, jobPayloadFormatSVFAdvancedIFC.conversionMethod) &&
        Objects.equals(this.buildingStoreys, jobPayloadFormatSVFAdvancedIFC.buildingStoreys) &&
        Objects.equals(this.spaces, jobPayloadFormatSVFAdvancedIFC.spaces) &&
        Objects.equals(this.openingElements, jobPayloadFormatSVFAdvancedIFC.openingElements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversionMethod, buildingStoreys, spaces, openingElements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSVFAdvancedIFC {\n");
    sb.append("    conversionMethod: ").append(toIndentedString(conversionMethod)).append("\n");
    sb.append("    buildingStoreys: ").append(toIndentedString(buildingStoreys)).append("\n");
    sb.append("    spaces: ").append(toIndentedString(spaces)).append("\n");
    sb.append("    openingElements: ").append(toIndentedString(openingElements)).append("\n");
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
