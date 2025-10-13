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
 * Contains advanced configuration settings for translation jobs processing
 * Revit inputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs processing Revit inputs.")
@JsonPropertyOrder({
    JobPayloadFormatSVFAdvancedRVT.JSON_PROPERTY_2DVIEWS,
    JobPayloadFormatSVFAdvancedRVT.JSON_PROPERTY_EXTRACTOR_VERSION,
    JobPayloadFormatSVFAdvancedRVT.JSON_PROPERTY_GENERATE_MASTER_VIEWS,
    JobPayloadFormatSVFAdvancedRVT.JSON_PROPERTY_MATERIAL_MODE
})
@JsonTypeName("JobPayloadFormatSVFAdvancedRVT")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSVFAdvancedRVT implements JobPayloadFormatSVFAdvanced {
  public static final String JSON_PROPERTY_2DVIEWS = "2dviews";
  private Model2dView _2dviews;

  public static final String JSON_PROPERTY_EXTRACTOR_VERSION = "extractorVersion";
  private ExtractorVersion extractorVersion;

  public static final String JSON_PROPERTY_GENERATE_MASTER_VIEWS = "generateMasterViews";
  private Boolean generateMasterViews;

  public static final String JSON_PROPERTY_MATERIAL_MODE = "materialMode";
  private MaterialMode materialMode;

  public JobPayloadFormatSVFAdvancedRVT _2dviews(Model2dView _2dviews) {

    this._2dviews = _2dviews;
    return this;
  }

  /**
   * Get _2dviews
   * 
   * @return _2dviews
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_2DVIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Model2dView get2dviews() {
    return _2dviews;
  }

  @JsonProperty(JSON_PROPERTY_2DVIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set2dviews(Model2dView _2dviews) {
    this._2dviews = _2dviews;
  }

  public JobPayloadFormatSVFAdvancedRVT extractorVersion(ExtractorVersion extractorVersion) {

    this.extractorVersion = extractorVersion;
    return this;
  }

  /**
   * Get extractorVersion
   * 
   * @return extractorVersion
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EXTRACTOR_VERSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public ExtractorVersion getExtractorVersion() {
    return extractorVersion;
  }

  @JsonProperty(JSON_PROPERTY_EXTRACTOR_VERSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExtractorVersion(ExtractorVersion extractorVersion) {
    this.extractorVersion = extractorVersion;
  }

  public JobPayloadFormatSVFAdvancedRVT generateMasterViews(Boolean generateMasterViews) {

    this.generateMasterViews = generateMasterViews;
    return this;
  }

  /**
   * Generates master views when translating from the Revit input format to SVF.
   * This option is ignored for all other input formats. This attribute defaults
   * to false.
   * 
   * Master views are 3D views that are generated for each phase of the Revit
   * model. A master view contains all elements (including “room” elements)
   * present in the host model for that phase. The display name of a master view
   * defaults to the name of the phase it is generated from. However, if a view
   * with that name already exists, the Model Derivative service appends a suffix
   * to the default display name.
   ** 
   * Notes:**
   * 
   * 1. Master views do not contain elements from linked models.
   * 2. Enabling this option can increase the time it takes to translate the
   * model.
   * 
   * @return generateMasterViews
   **/
  @javax.annotation.Nullable
  @Schema(description = "Generates master views when translating from the Revit input format to SVF. This option is ignored for all other input formats. This attribute defaults to false.  Master views are 3D views that are generated for each phase of the Revit model. A master view contains all elements (including “room” elements) present in the host model for that phase. The display name of a master view defaults to the name of the phase it is generated from. However, if a view with that name already exists, the Model Derivative service appends a suffix to the default display name.  **Notes:**  1. Master views do not contain elements from linked models. 2. Enabling this option can increase the time it takes to translate the model.")
  @JsonProperty(JSON_PROPERTY_GENERATE_MASTER_VIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getGenerateMasterViews() {
    return generateMasterViews;
  }

  @JsonProperty(JSON_PROPERTY_GENERATE_MASTER_VIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setGenerateMasterViews(Boolean generateMasterViews) {
    this.generateMasterViews = generateMasterViews;
  }

  public JobPayloadFormatSVFAdvancedRVT materialMode(MaterialMode materialMode) {

    this.materialMode = materialMode;
    return this;
  }

  /**
   * Get materialMode
   * 
   * @return materialMode
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_MATERIAL_MODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public MaterialMode getMaterialMode() {
    return materialMode;
  }

  @JsonProperty(JSON_PROPERTY_MATERIAL_MODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMaterialMode(MaterialMode materialMode) {
    this.materialMode = materialMode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSVFAdvancedRVT jobPayloadFormatSVFAdvancedRVT = (JobPayloadFormatSVFAdvancedRVT) o;
    return Objects.equals(this._2dviews, jobPayloadFormatSVFAdvancedRVT._2dviews) &&
        Objects.equals(this.extractorVersion, jobPayloadFormatSVFAdvancedRVT.extractorVersion) &&
        Objects.equals(this.generateMasterViews, jobPayloadFormatSVFAdvancedRVT.generateMasterViews) &&
        Objects.equals(this.materialMode, jobPayloadFormatSVFAdvancedRVT.materialMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_2dviews, extractorVersion, generateMasterViews, materialMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSVFAdvancedRVT {\n");
    sb.append("    _2dviews: ").append(toIndentedString(_2dviews)).append("\n");
    sb.append("    extractorVersion: ").append(toIndentedString(extractorVersion)).append("\n");
    sb.append("    generateMasterViews: ").append(toIndentedString(generateMasterViews)).append("\n");
    sb.append("    materialMode: ").append(toIndentedString(materialMode)).append("\n");
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
