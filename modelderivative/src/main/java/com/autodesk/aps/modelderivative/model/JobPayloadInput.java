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
 * Describes the attributes of the source design.
 */
@Schema(description = "Describes the attributes of the source design.")
@JsonPropertyOrder({
    JobPayloadInput.JSON_PROPERTY_URN,
    JobPayloadInput.JSON_PROPERTY_COMPRESSED_URN,
    JobPayloadInput.JSON_PROPERTY_ROOT_FILENAME,
    JobPayloadInput.JSON_PROPERTY_CHECK_REFERENCES
})
@JsonTypeName("JobPayload_input")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadInput {
  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_COMPRESSED_URN = "compressedUrn";
  private Boolean compressedUrn = false;

  public static final String JSON_PROPERTY_ROOT_FILENAME = "rootFilename";
  private String rootFilename;

  public static final String JSON_PROPERTY_CHECK_REFERENCES = "checkReferences";
  private Boolean checkReferences;

  public JobPayloadInput urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URL safe Base64 encoded URN of the source design.
   ** 
   * Note:** The URN is returned as the &#x60;&#x60;objectID&#x60;&#x60; once you
   * complete uploading the source design to APS. This value must be converted to
   * a &#x60;Base64 (URL Safe) encoded
   * &lt;http://www.freeformatter.com/base64-encoder.html&gt;&#x60;_ string before
   * you can specify it for this attribute.
   * 
   * @return urn
   **/
  @Schema(required = true, description = "The URL safe Base64 encoded URN of the source design.   **Note:** The URN is returned as the ``objectID`` once you complete uploading the source design to APS. This value must be converted to a `Base64 (URL Safe) encoded <http://www.freeformatter.com/base64-encoder.html>`_ string before you can specify it for this attribute. ")
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

  public JobPayloadInput compressedUrn(Boolean compressedUrn) {

    this.compressedUrn = compressedUrn;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60;: The source design is compressed as a zip
   * file. If set to &#x60;&#x60;true&#x60;&#x60;, you need to define the
   * &#x60;rootFilename&#x60;.&#39;
   * - &#x60;&#x60;false&#x60;&#x60;: (Default) The source design is not
   * compressed.
   * 
   * @return compressedUrn
   **/
  @javax.annotation.Nullable
  @Schema(description = "- ``true``: The source design is compressed as a zip file. If set to ``true``, you need to define the `rootFilename`.' - ``false``: (Default) The source design is not compressed. ")
  @JsonProperty(JSON_PROPERTY_COMPRESSED_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getCompressedUrn() {
    return compressedUrn;
  }

  @JsonProperty(JSON_PROPERTY_COMPRESSED_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCompressedUrn(Boolean compressedUrn) {
    this.compressedUrn = compressedUrn;
  }

  public JobPayloadInput rootFilename(String rootFilename) {

    this.rootFilename = rootFilename;
    return this;
  }

  /**
   * The file name of the top-level component of the source design. Mandatory if
   * &#x60;&#x60;compressedUrn&#x60;&#x60; is set to &#x60;&#x60;true&#x60;&#x60;.
   * 
   * @return rootFilename
   **/
  @javax.annotation.Nullable
  @Schema(description = "The file name of the top-level component of the source design.  Mandatory if  ``compressedUrn`` is set to ``true``.")
  @JsonProperty(JSON_PROPERTY_ROOT_FILENAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getRootFilename() {
    return rootFilename;
  }

  @JsonProperty(JSON_PROPERTY_ROOT_FILENAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRootFilename(String rootFilename) {
    this.rootFilename = rootFilename;
  }

  public JobPayloadInput checkReferences(Boolean checkReferences) {

    this.checkReferences = checkReferences;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60; - Instructs the system to check for
   * references, and if any exist, download all referenced files. Setting this
   * parameter to &#x60;&#x60;true&#x60;&#x60; is mandatory when translating
   * source designs consisting of multiple files. For example, Autodesk Inventor
   * assemblies.
   * - &#x60;&#x60;false&#x60;&#x60; - (Default) Instructs the system not to check
   * for references.
   * 
   * @return checkReferences
   **/
  @javax.annotation.Nullable
  @Schema(description = "- ``true`` - Instructs the system to check for references, and if any exist, download all referenced files. Setting this parameter to ``true`` is mandatory when translating source designs consisting of multiple files. For example, Autodesk Inventor assemblies. - ``false`` - (Default) Instructs the system not to check for references.")
  @JsonProperty(JSON_PROPERTY_CHECK_REFERENCES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getCheckReferences() {
    return checkReferences;
  }

  @JsonProperty(JSON_PROPERTY_CHECK_REFERENCES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCheckReferences(Boolean checkReferences) {
    this.checkReferences = checkReferences;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadInput jobPayloadInput = (JobPayloadInput) o;
    return Objects.equals(this.urn, jobPayloadInput.urn) &&
        Objects.equals(this.compressedUrn, jobPayloadInput.compressedUrn) &&
        Objects.equals(this.rootFilename, jobPayloadInput.rootFilename) &&
        Objects.equals(this.checkReferences, jobPayloadInput.checkReferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urn, compressedUrn, rootFilename, checkReferences);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadInput {\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    compressedUrn: ").append(toIndentedString(compressedUrn)).append("\n");
    sb.append("    rootFilename: ").append(toIndentedString(rootFilename)).append("\n");
    sb.append("    checkReferences: ").append(toIndentedString(checkReferences)).append("\n");
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
