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
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SpecifyReferencesPayloadReferences
 */
@JsonPropertyOrder({
    SpecifyReferencesPayloadReferences.JSON_PROPERTY_URN,
    SpecifyReferencesPayloadReferences.JSON_PROPERTY_RELATIVE_PATH,
    SpecifyReferencesPayloadReferences.JSON_PROPERTY_FILENAME,
    SpecifyReferencesPayloadReferences.JSON_PROPERTY_METADATA
})
@JsonTypeName("SpecifyReferencesPayload_references")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SpecifyReferencesPayloadReferences {
  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_RELATIVE_PATH = "relativePath";
  private String relativePath;

  public static final String JSON_PROPERTY_FILENAME = "filename";
  private String filename;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, Object> metadata = null;

  public SpecifyReferencesPayloadReferences urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URN of the referenced file.
   * 
   * @return urn
   **/
  @Schema(required = true, description = "The URN of the referenced file.")
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

  public SpecifyReferencesPayloadReferences relativePath(String relativePath) {

    this.relativePath = relativePath;
    return this;
  }

  /**
   * The path to the referenced file, relative to the top level component. By
   * default, it is set to &#x60;&#x60;&quot;&quot;&#x60;&#x60;, which means that
   * the referenced file and top level component are in the same folder.
   * 
   * @return relativePath
   **/
  @Schema(required = true, description = "The path to the referenced file, relative to the top level component. By default, it is set to ``\"\"``, which means that the referenced file and top level component are in the same folder.")
  @JsonProperty(JSON_PROPERTY_RELATIVE_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRelativePath() {
    return relativePath;
  }

  @JsonProperty(JSON_PROPERTY_RELATIVE_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRelativePath(String relativePath) {
    this.relativePath = relativePath;
  }

  public SpecifyReferencesPayloadReferences filename(String filename) {

    this.filename = filename;
    return this;
  }

  /**
   * The file name of the referenced file. By default, it is set to
   * &#x60;&#x60;&quot;&quot;&#x60;&#x60; and the referenced file will be
   * downloaded by its &#x60;&#x60;urn&#x60;&#x60; and placed relative to the
   * top-level component using &#x60;&#x60;relativePath&#x60;&#x60;.
   * 
   * @return filename
   **/
  @Schema(required = true, description = "The file name of the referenced file. By default, it is set to ``\"\"`` and the referenced file will be downloaded by its ``urn`` and placed relative to the top-level component using ``relativePath``.")
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

  public SpecifyReferencesPayloadReferences metadata(Map<String, Object> metadata) {

    this.metadata = metadata;
    return this;
  }

  public SpecifyReferencesPayloadReferences putmetadataItem(String key, Object metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

  /**
   * An object to hold custom metadata.
   * 
   * @return metadata
   **/
  @javax.annotation.Nullable
  @Schema(description = "An object to hold custom metadata.")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Map<String, Object> getMetadata() {
    return metadata;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecifyReferencesPayloadReferences specifyReferencesPayloadReferences = (SpecifyReferencesPayloadReferences) o;
    return Objects.equals(this.urn, specifyReferencesPayloadReferences.urn) &&
        Objects.equals(this.relativePath, specifyReferencesPayloadReferences.relativePath) &&
        Objects.equals(this.filename, specifyReferencesPayloadReferences.filename) &&
        Objects.equals(this.metadata, specifyReferencesPayloadReferences.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urn, relativePath, filename, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecifyReferencesPayloadReferences {\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    relativePath: ").append(toIndentedString(relativePath)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
