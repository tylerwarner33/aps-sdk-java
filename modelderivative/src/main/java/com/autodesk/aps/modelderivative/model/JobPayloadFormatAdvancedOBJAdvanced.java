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

import java.util.ArrayList;
import java.util.List;
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
    JobPayloadFormatAdvancedOBJAdvanced.JSON_PROPERTY_EXPORT_FILE_STRUCTURE,
    JobPayloadFormatAdvancedOBJAdvanced.JSON_PROPERTY_UNIT,
    JobPayloadFormatAdvancedOBJAdvanced.JSON_PROPERTY_MODEL_GUID,
    JobPayloadFormatAdvancedOBJAdvanced.JSON_PROPERTY_OBJECT_IDS
})
@JsonTypeName("JobPayloadFormatAdvancedOBJ_advanced")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatAdvancedOBJAdvanced {
  public static final String JSON_PROPERTY_EXPORT_FILE_STRUCTURE = "exportFileStructure";
  private ExportFileStructure exportFileStructure = ExportFileStructure.SINGLE;

  public static final String JSON_PROPERTY_UNIT = "unit";
  private Unit unit;

  public static final String JSON_PROPERTY_MODEL_GUID = "modelGuid";
  private String modelGuid;

  public static final String JSON_PROPERTY_OBJECT_IDS = "objectIds";
  private List<Integer> objectIds = null;

  public JobPayloadFormatAdvancedOBJAdvanced exportFileStructure(ExportFileStructure exportFileStructure) {

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

  public JobPayloadFormatAdvancedOBJAdvanced unit(Unit unit) {

    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * 
   * @return unit
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Unit getUnit() {
    return unit;
  }

  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  public JobPayloadFormatAdvancedOBJAdvanced modelGuid(String modelGuid) {

    this.modelGuid = modelGuid;
    return this;
  }

  /**
   * Required for geometry extractions. Specifies the ID of the Model View that
   * contains the geometry to extract.
   * 
   * @return modelGuid
   **/
  @javax.annotation.Nullable
  @Schema(description = "Required for geometry extractions. Specifies the ID of the Model View that contains the geometry to extract.")
  @JsonProperty(JSON_PROPERTY_MODEL_GUID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getModelGuid() {
    return modelGuid;
  }

  @JsonProperty(JSON_PROPERTY_MODEL_GUID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setModelGuid(String modelGuid) {
    this.modelGuid = modelGuid;
  }

  public JobPayloadFormatAdvancedOBJAdvanced objectIds(List<Integer> objectIds) {

    this.objectIds = objectIds;
    return this;
  }

  public JobPayloadFormatAdvancedOBJAdvanced addobjectIdsItem(Integer objectIdsItem) {
    if (this.objectIds == null) {
      this.objectIds = new ArrayList<>();
    }
    this.objectIds.add(objectIdsItem);
    return this;
  }

  /**
   * Required for geometry extractions. Specifies the IDs of the objects
   * (&#x60;&#x60;objectID) to extract. -1 will extract the entire model.
   * 
   * @return objectIds
   **/
  @javax.annotation.Nullable
  @Schema(description = "Required for geometry extractions. Specifies the IDs of the objects (``objectID) to extract. -1 will extract the entire model. ")
  @JsonProperty(JSON_PROPERTY_OBJECT_IDS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Integer> getObjectIds() {
    return objectIds;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT_IDS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setObjectIds(List<Integer> objectIds) {
    this.objectIds = objectIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatAdvancedOBJAdvanced jobPayloadFormatAdvancedOBJAdvanced = (JobPayloadFormatAdvancedOBJAdvanced) o;
    return Objects.equals(this.exportFileStructure, jobPayloadFormatAdvancedOBJAdvanced.exportFileStructure) &&
        Objects.equals(this.unit, jobPayloadFormatAdvancedOBJAdvanced.unit) &&
        Objects.equals(this.modelGuid, jobPayloadFormatAdvancedOBJAdvanced.modelGuid) &&
        Objects.equals(this.objectIds, jobPayloadFormatAdvancedOBJAdvanced.objectIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exportFileStructure, unit, modelGuid, objectIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatAdvancedOBJAdvanced {\n");
    sb.append("    exportFileStructure: ").append(toIndentedString(exportFileStructure)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    modelGuid: ").append(toIndentedString(modelGuid)).append("\n");
    sb.append("    objectIds: ").append(toIndentedString(objectIds)).append("\n");
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
