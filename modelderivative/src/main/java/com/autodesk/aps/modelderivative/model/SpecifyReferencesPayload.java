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
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the request body of a Specify References operation.
 */
@Schema(description = "Represents the request body of a Specify References operation.")
@JsonPropertyOrder({
    SpecifyReferencesPayload.JSON_PROPERTY_URN,
    SpecifyReferencesPayload.JSON_PROPERTY_REGION,
    SpecifyReferencesPayload.JSON_PROPERTY_FILENAME,
    SpecifyReferencesPayload.JSON_PROPERTY_REFERENCES
})
@JsonTypeName("SpecifyReferencesPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SpecifyReferencesPayload {
  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_REGION = "region";
  private Region region;

  public static final String JSON_PROPERTY_FILENAME = "filename";
  private String filename;

  public static final String JSON_PROPERTY_REFERENCES = "references";
  private List<SpecifyReferencesPayloadReferences> references = new ArrayList<>();

  public SpecifyReferencesPayload urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URL safe Base64 encoded URN of the source design. Mandatory if the Base64
   * encoded urn in the request URL is a logical URN.
   * 
   * @return urn
   **/
  @Schema(required = true, description = "The URL safe Base64 encoded URN of the source design. Mandatory if the Base64 encoded urn in the request URL is a logical URN.")
  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrn() {
    return urn;
  }

  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrn(String urn) {
    this.urn = urn;
  }

  public SpecifyReferencesPayload region(Region region) {

    this.region = region;
    return this;
  }

  /**
   * Get region
   * 
   * @return region
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Region getRegion() {
    return region;
  }

  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRegion(Region region) {
    this.region = region;
  }

  public SpecifyReferencesPayload filename(String filename) {

    this.filename = filename;
    return this;
  }

  /**
   * The file name of the top level component. By default, it is set to
   * &#x60;&#x60;&quot;&quot;&#x60;&#x60; and the file will be download with its
   * &#x60;&#x60;urn&#x60;&#x60;.
   * 
   * @return filename
   **/
  @Schema(required = true, description = "The file name of the top level component. By default, it is set to ``\"\"`` and the file will be download with its ``urn``.")
  @JsonProperty(JSON_PROPERTY_FILENAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFilename() {
    return filename;
  }

  @JsonProperty(JSON_PROPERTY_FILENAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFilename(String filename) {
    this.filename = filename;
  }

  public SpecifyReferencesPayload references(List<SpecifyReferencesPayloadReferences> references) {

    this.references = references;
    return this;
  }

  public SpecifyReferencesPayload addreferencesItem(SpecifyReferencesPayloadReferences referencesItem) {
    this.references.add(referencesItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a referenced file.
   * 
   * @return references
   **/
  @Schema(required = true, description = "An array of objects, where each object represents a referenced file.")
  @JsonProperty(JSON_PROPERTY_REFERENCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SpecifyReferencesPayloadReferences> getReferences() {
    return references;
  }

  @JsonProperty(JSON_PROPERTY_REFERENCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReferences(List<SpecifyReferencesPayloadReferences> references) {
    this.references = references;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecifyReferencesPayload specifyReferencesPayload = (SpecifyReferencesPayload) o;
    return Objects.equals(this.urn, specifyReferencesPayload.urn) &&
        Objects.equals(this.region, specifyReferencesPayload.region) &&
        Objects.equals(this.filename, specifyReferencesPayload.filename) &&
        Objects.equals(this.references, specifyReferencesPayload.references);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urn, region, filename, references);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecifyReferencesPayload {\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    references: ").append(toIndentedString(references)).append("\n");
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
