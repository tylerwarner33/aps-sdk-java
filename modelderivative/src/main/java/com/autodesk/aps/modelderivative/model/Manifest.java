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
 * Represents the successful response of a Fetch Manifest operation.
 */
@Schema(description = "Represents the successful response of a Fetch Manifest operation.")
@JsonPropertyOrder({
    Manifest.JSON_PROPERTY_URN,
    Manifest.JSON_PROPERTY_DERIVATIVES,
    Manifest.JSON_PROPERTY_HAS_THUMBNAIL,
    Manifest.JSON_PROPERTY_PROGRESS,
    Manifest.JSON_PROPERTY_TYPE,
    Manifest.JSON_PROPERTY_REGION,
    Manifest.JSON_PROPERTY_VERSION,
    Manifest.JSON_PROPERTY_STATUS
})
@JsonTypeName("Manifest")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Manifest {
  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_DERIVATIVES = "derivatives";
  private List<ManifestDerivative> derivatives = new ArrayList<>();

  public static final String JSON_PROPERTY_HAS_THUMBNAIL = "hasThumbnail";
  private String hasThumbnail;

  public static final String JSON_PROPERTY_PROGRESS = "progress";
  private String progress;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_REGION = "region";
  private String region;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public Manifest urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URL-safe Base64 encoded URN of the source design.
   * 
   * @return urn
   **/
  @Schema(required = true, description = "The URL-safe Base64 encoded URN of the source design.")
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

  public Manifest derivatives(List<ManifestDerivative> derivatives) {

    this.derivatives = derivatives;
    return this;
  }

  public Manifest addderivativesItem(ManifestDerivative derivativesItem) {
    this.derivatives.add(derivativesItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a derivative of the source
   * design.
   * 
   * @return derivatives
   **/
  @Schema(required = true, description = "An array of objects, where each object represents a derivative of the source design.")
  @JsonProperty(JSON_PROPERTY_DERIVATIVES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ManifestDerivative> getDerivatives() {
    return derivatives;
  }

  @JsonProperty(JSON_PROPERTY_DERIVATIVES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDerivatives(List<ManifestDerivative> derivatives) {
    this.derivatives = derivatives;
  }

  public Manifest hasThumbnail(String hasThumbnail) {

    this.hasThumbnail = hasThumbnail;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60;: There is a thumbnail for the source design.
   * - &#x60;&#x60;false&#x60;&#x60;: There is no thumbnail for the source design.
   * 
   * @return hasThumbnail
   **/
  @Schema(required = true, description = "- ``true``: There is a thumbnail for the source design. - ``false``: There is no thumbnail for the source design. ")
  @JsonProperty(JSON_PROPERTY_HAS_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHasThumbnail() {
    return hasThumbnail;
  }

  @JsonProperty(JSON_PROPERTY_HAS_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHasThumbnail(String hasThumbnail) {
    this.hasThumbnail = hasThumbnail;
  }

  public Manifest progress(String progress) {

    this.progress = progress;
    return this;
  }

  /**
   * Indicates the overall progress of all translation jobs, as a percentage. Once
   * all requested derivatives are generated, the value changes to
   * &#x60;&#x60;complete&#x60;&#x60;.
   * 
   * @return progress
   **/
  @Schema(required = true, description = "Indicates the overall progress of all translation jobs, as a percentage. Once all requested derivatives are generated, the value changes to ``complete``.")
  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProgress() {
    return progress;
  }

  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProgress(String progress) {
    this.progress = progress;
  }

  public Manifest type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The type of data that is returned. Always &#x60;&#x60;manifest&#x60;&#x60;.
   * 
   * @return type
   **/
  @Schema(required = true, description = "The type of data that is returned. Always ``manifest``.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }

  public Manifest region(String region) {

    this.region = region;
    return this;
  }

  /**
   * Specifies the data center where the manifest, derivatives, and references are
   * stored. Possible values are:
   * 
   * - &#x60;&#x60;US&#x60;&#x60; - Data center for the US region.
   * - &#x60;&#x60;EMEA&#x60;&#x60; - Data center for European Union, Middle East,
   * and Africa.
   * - &#x60;&#x60;AUS&#x60;&#x60; - Data center for the Australia region.
   * - &#x60;&#x60;CAN&#x60;&#x60; - Data center for the Canada region.
   * - &#x60;&#x60;DEU&#x60;&#x60; - Data center for the Germany region.
   * - &#x60;&#x60;IND&#x60;&#x60; - Data center for the India region.
   * - &#x60;&#x60;JPN&#x60;&#x60; - Data center for the Japan region.
   * - &#x60;&#x60;GBR&#x60;&#x60; - Data center for the United Kingdom region.
   * 
   * @return region
   **/
  @Schema(required = true, description = "Specifies the data center where the manifest, derivatives, and references are stored. Possible values are:   - ``US`` - Data center for the US region. - ``EMEA`` - Data center for European Union, Middle East, and Africa.  - ``AUS`` - Data center for the Australia region. - ``CAN`` - Data center for the Canada region. - ``DEU`` - Data center for the Germany region. - ``IND`` - Data center for the India region. - ``JPN`` - Data center for the Japan region. - ``GBR``  - Data center for the United Kingdom region. ")
  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRegion() {
    return region;
  }

  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRegion(String region) {
    this.region = region;
  }

  public Manifest version(String version) {

    this.version = version;
    return this;
  }

  /**
   * Indicates the version of the schema that the manifest is based on.
   * 
   * @return version
   **/
  @Schema(required = true, description = "Indicates the version of the schema that the manifest is based on.")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getVersion() {
    return version;
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVersion(String version) {
    this.version = version;
  }

  public Manifest status(String status) {

    this.status = status;
    return this;
  }

  /**
   * Overall status of all translation jobs for the source design. Possible values
   * are: &#x60;&#x60;pending&#x60;&#x60;, &#x60;&#x60;success&#x60;&#x60;,
   * &#x60;&#x60;inprogress&#x60;&#x60;, &#x60;&#x60;failed&#x60;&#x60;,
   * &#x60;&#x60;timeout&#x60;&#x60;.
   * 
   * @return status
   **/
  @Schema(required = true, description = "Overall status of all translation jobs for the source design. Possible values are: ``pending``, ``success``, ``inprogress``, ``failed``, ``timeout``.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Manifest manifest = (Manifest) o;
    return Objects.equals(this.urn, manifest.urn) &&
        Objects.equals(this.derivatives, manifest.derivatives) &&
        Objects.equals(this.hasThumbnail, manifest.hasThumbnail) &&
        Objects.equals(this.progress, manifest.progress) &&
        Objects.equals(this.type, manifest.type) &&
        Objects.equals(this.region, manifest.region) &&
        Objects.equals(this.version, manifest.version) &&
        Objects.equals(this.status, manifest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urn, derivatives, hasThumbnail, progress, type, region, version, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Manifest {\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    derivatives: ").append(toIndentedString(derivatives)).append("\n");
    sb.append("    hasThumbnail: ").append(toIndentedString(hasThumbnail)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
