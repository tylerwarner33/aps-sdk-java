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
 * Contains advanced configuration settings for translation jobs processing NWD
 * inputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs processing NWD inputs.")
@JsonPropertyOrder({
    JobPayloadFormatSVFAdvancedNWD.JSON_PROPERTY_HIDDEN_OBJECTS,
    JobPayloadFormatSVFAdvancedNWD.JSON_PROPERTY_BASIC_MATERIAL_PROPERTIES,
    JobPayloadFormatSVFAdvancedNWD.JSON_PROPERTY_AUTODESK_MATERIAL_PROPERTIES,
    JobPayloadFormatSVFAdvancedNWD.JSON_PROPERTY_TIMELINER_PROPERTIES
})
@JsonTypeName("JobPayloadFormatSVFAdvancedNWD")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSVFAdvancedNWD implements JobPayloadFormatSVFAdvanced {
  public static final String JSON_PROPERTY_HIDDEN_OBJECTS = "hiddenObjects";
  private Boolean hiddenObjects;

  public static final String JSON_PROPERTY_BASIC_MATERIAL_PROPERTIES = "basicMaterialProperties";
  private Boolean basicMaterialProperties;

  public static final String JSON_PROPERTY_AUTODESK_MATERIAL_PROPERTIES = "autodeskMaterialProperties";
  private Boolean autodeskMaterialProperties;

  public static final String JSON_PROPERTY_TIMELINER_PROPERTIES = "timelinerProperties";
  private Boolean timelinerProperties;

  public JobPayloadFormatSVFAdvancedNWD hiddenObjects(Boolean hiddenObjects) {

    this.hiddenObjects = hiddenObjects;
    return this;
  }

  /**
   * Specifies whether hidden objects must be extracted or not. Applicable only
   * when the source design type is Navisworks.
   * 
   * - &#x60;&#x60;true&#x60;&#x60;: Extract hidden objects from the input file.
   * - &#x60;&#x60;false&#x60;&#x60;: (Default) Do not extract hidden objects from
   * the input file.
   * 
   * @return hiddenObjects
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies whether hidden objects must be extracted or not. Applicable only when the source design type is Navisworks.  - ``true``: Extract hidden objects from the input file. - ``false``: (Default) Do not extract hidden objects from the input file. ")
  @JsonProperty(JSON_PROPERTY_HIDDEN_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getHiddenObjects() {
    return hiddenObjects;
  }

  @JsonProperty(JSON_PROPERTY_HIDDEN_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHiddenObjects(Boolean hiddenObjects) {
    this.hiddenObjects = hiddenObjects;
  }

  public JobPayloadFormatSVFAdvancedNWD basicMaterialProperties(Boolean basicMaterialProperties) {

    this.basicMaterialProperties = basicMaterialProperties;
    return this;
  }

  /**
   * Specifies whether basic material properties must be extracted or not.
   * Applicable only when the source design type is Navisworks.
   * 
   * - &#x60;&#x60;true&#x60;&#x60;: Extract properties for basic materials.
   * - &#x60;&#x60;false&#x60;&#x60;: (Default) Do not extract properties for
   * basic materials.
   * 
   * @return basicMaterialProperties
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies whether basic material properties must be extracted or not.  Applicable only when the source design type is Navisworks.  - ``true``: Extract properties for basic materials. - ``false``: (Default) Do not extract properties for basic materials. ")
  @JsonProperty(JSON_PROPERTY_BASIC_MATERIAL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getBasicMaterialProperties() {
    return basicMaterialProperties;
  }

  @JsonProperty(JSON_PROPERTY_BASIC_MATERIAL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setBasicMaterialProperties(Boolean basicMaterialProperties) {
    this.basicMaterialProperties = basicMaterialProperties;
  }

  public JobPayloadFormatSVFAdvancedNWD autodeskMaterialProperties(Boolean autodeskMaterialProperties) {

    this.autodeskMaterialProperties = autodeskMaterialProperties;
    return this;
  }

  /**
   * Specifies how to handle Autodesk material properties. Applicable only when
   * the source design type is Navisworks.
   * 
   * - &#x60;&#x60;true&#x60;&#x60;: Extract properties for Autodesk materials.
   * - &#x60;&#x60;false&#x60;&#x60;: (Default) Do not extract properties for
   * Autodesk materials.
   * 
   * @return autodeskMaterialProperties
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies how to handle Autodesk material properties.  Applicable only when the source design type is Navisworks.  - ``true``: Extract properties for Autodesk materials. - ``false``: (Default) Do not extract properties for Autodesk materials. ")
  @JsonProperty(JSON_PROPERTY_AUTODESK_MATERIAL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getAutodeskMaterialProperties() {
    return autodeskMaterialProperties;
  }

  @JsonProperty(JSON_PROPERTY_AUTODESK_MATERIAL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAutodeskMaterialProperties(Boolean autodeskMaterialProperties) {
    this.autodeskMaterialProperties = autodeskMaterialProperties;
  }

  public JobPayloadFormatSVFAdvancedNWD timelinerProperties(Boolean timelinerProperties) {

    this.timelinerProperties = timelinerProperties;
    return this;
  }

  /**
   * Specifies whether timeliner properties must be extracted or not. Applicable
   * only when the source design type is Navisworks.
   * 
   * - &#x60;&#x60;true&#x60;&#x60;: Extract timeliner properties.
   * - &#x60;&#x60;false&#x60;&#x60;: (Default) Do not extract timeliner
   * properties.
   * 
   * @return timelinerProperties
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies whether timeliner properties must be extracted or not.  Applicable only when the source design type is Navisworks.  - ``true``: Extract timeliner properties. - ``false``: (Default) Do not extract timeliner properties. ")
  @JsonProperty(JSON_PROPERTY_TIMELINER_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getTimelinerProperties() {
    return timelinerProperties;
  }

  @JsonProperty(JSON_PROPERTY_TIMELINER_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTimelinerProperties(Boolean timelinerProperties) {
    this.timelinerProperties = timelinerProperties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSVFAdvancedNWD jobPayloadFormatSVFAdvancedNWD = (JobPayloadFormatSVFAdvancedNWD) o;
    return Objects.equals(this.hiddenObjects, jobPayloadFormatSVFAdvancedNWD.hiddenObjects) &&
        Objects.equals(this.basicMaterialProperties, jobPayloadFormatSVFAdvancedNWD.basicMaterialProperties) &&
        Objects.equals(this.autodeskMaterialProperties, jobPayloadFormatSVFAdvancedNWD.autodeskMaterialProperties) &&
        Objects.equals(this.timelinerProperties, jobPayloadFormatSVFAdvancedNWD.timelinerProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hiddenObjects, basicMaterialProperties, autodeskMaterialProperties, timelinerProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSVFAdvancedNWD {\n");
    sb.append("    hiddenObjects: ").append(toIndentedString(hiddenObjects)).append("\n");
    sb.append("    basicMaterialProperties: ").append(toIndentedString(basicMaterialProperties)).append("\n");
    sb.append("    autodeskMaterialProperties: ").append(toIndentedString(autodeskMaterialProperties)).append("\n");
    sb.append("    timelinerProperties: ").append(toIndentedString(timelinerProperties)).append("\n");
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
