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
 * Represents a derivative generated for the source design.
 */
@Schema(description = "Represents a derivative generated for the source design.")
@JsonPropertyOrder({
    ManifestDerivative.JSON_PROPERTY_NAME,
    ManifestDerivative.JSON_PROPERTY_HAS_THUMBNAIL,
    ManifestDerivative.JSON_PROPERTY_PROGRESS,
    ManifestDerivative.JSON_PROPERTY_OUTPUT_TYPE,
    ManifestDerivative.JSON_PROPERTY_PROPERTIES,
    ManifestDerivative.JSON_PROPERTY_STATUS,
    ManifestDerivative.JSON_PROPERTY_MESSAGES,
    ManifestDerivative.JSON_PROPERTY_CHILDREN
})
@JsonTypeName("ManifestDerivative")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ManifestDerivative {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_HAS_THUMBNAIL = "hasThumbnail";
  private String hasThumbnail;

  public static final String JSON_PROPERTY_PROGRESS = "progress";
  private String progress;

  public static final String JSON_PROPERTY_OUTPUT_TYPE = "outputType";
  private String outputType;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  private Object properties;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_MESSAGES = "messages";
  private List<Messages> messages = null;

  public static final String JSON_PROPERTY_CHILDREN = "children";
  private List<ManifestResources> children = null;

  public ManifestDerivative name(String name) {

    this.name = name;
    return this;
  }

  /**
   * The name of the source design.
   * 
   * @return name
   **/
  @Schema(required = true, description = "The name of the source design.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }

  public ManifestDerivative hasThumbnail(String hasThumbnail) {

    this.hasThumbnail = hasThumbnail;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60;: The derivative has a thumbnail.
   * - &#x60;&#x60;false&#x60;&#x60;: The derivative does not have a thumbnail.
   * 
   * @return hasThumbnail
   **/
  @Schema(required = true, description = "- ``true``: The derivative has a thumbnail. - ``false``: The derivative does not have a thumbnail. ")
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

  public ManifestDerivative progress(String progress) {

    this.progress = progress;
    return this;
  }

  /**
   * Indicates the progress of the process generating this derivative, as a
   * percentage. Once complete, the value changes to
   * &#x60;&#x60;complete&#x60;&#x60;.
   * 
   * @return progress
   **/
  @Schema(required = true, description = "Indicates the progress of the process generating this derivative, as a percentage. Once complete, the value changes to ``complete``.")
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

  public ManifestDerivative outputType(String outputType) {

    this.outputType = outputType;
    return this;
  }

  /**
   * The file type/format of the derivative. Possible values are:
   * &#x60;&#x60;dwg&#x60;&#x60;, &#x60;&#x60;fbx&#x60;&#x60;,
   * &#x60;&#x60;ifc&#x60;&#x60;, &#x60;&#x60;iges&#x60;&#x60;,
   * &#x60;&#x60;obj&#x60;&#x60; , &#x60;&#x60;step&#x60;&#x60;,
   * &#x60;&#x60;stl&#x60;&#x60;, &#x60;&#x60;svf&#x60;&#x60;,
   * &#x60;&#x60;svf2&#x60;&#x60;, &#x60;&#x60;thumbnail&#x60;&#x60;.
   * 
   * @return outputType
   **/
  @Schema(required = true, description = "The file type/format of the derivative. Possible values are: ``dwg``, ``fbx``, ``ifc``, ``iges``, ``obj`` , ``step``, ``stl``, ``svf``, ``svf2``,  ``thumbnail``.")
  @JsonProperty(JSON_PROPERTY_OUTPUT_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOutputType() {
    return outputType;
  }

  @JsonProperty(JSON_PROPERTY_OUTPUT_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOutputType(String outputType) {
    this.outputType = outputType;
  }

  public ManifestDerivative properties(Object properties) {

    this.properties = properties;
    return this;
  }

  /**
   * A JSON object containing metadata extracted from the source design. This
   * metadata provides valuable information about the model, such as its author,
   * client name, project status, and other relevant details.
   ** 
   * Note:** This metadata is currently returned for the following source design
   * types:
   * 
   * - RVT - Revit models
   * - NWD - Navisworks models
   * - DWG - AutoCAD models
   * 
   * @return properties
   **/
  @javax.annotation.Nullable
  @Schema(description = "A JSON object containing metadata extracted from the source design. This metadata provides valuable information about the model, such as its author, client name, project status, and other relevant details.  **Note:** This metadata is currently returned for the following source design types:  - RVT - Revit models - NWD - Navisworks models - DWG - AutoCAD models")
  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getProperties() {
    return properties;
  }

  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProperties(Object properties) {
    this.properties = properties;
  }

  public ManifestDerivative status(String status) {

    this.status = status;
    return this;
  }

  /**
   * Status of the task generating this derivative. Possible values are:
   * &#x60;&#x60;pending&#x60;&#x60;, &#x60;&#x60;inprogress&#x60;&#x60;,
   * &#x60;&#x60;success&#x60;&#x60;, &#x60;&#x60;failed&#x60;&#x60;,
   * &#x60;&#x60;timeout&#x60;&#x60;.
   * 
   * @return status
   **/
  @Schema(required = true, description = "Status of the task generating this derivative. Possible values are: ``pending``, ``inprogress``, ``success``, ``failed``, ``timeout``.")
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

  public ManifestDerivative messages(List<Messages> messages) {

    this.messages = messages;
    return this;
  }

  public ManifestDerivative addmessagesItem(Messages messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * An array of objects where each object represents a message logged to the
   * manifest during translation. For example, error messages and warning
   * messages.
   * 
   * @return messages
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects where each object represents a message logged to the manifest during translation. For example, error messages and warning messages.")
  @JsonProperty(JSON_PROPERTY_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Messages> getMessages() {
    return messages;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMessages(List<Messages> messages) {
    this.messages = messages;
  }

  public ManifestDerivative children(List<ManifestResources> children) {

    this.children = children;
    return this;
  }

  public ManifestDerivative addchildrenItem(ManifestResources childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a resource generated for
   * the derivative. For example, a Model View (Viewable) of the source design.
   * 
   * @return children
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object represents a resource generated for the derivative. For example, a Model View (Viewable) of the source design.")
  @JsonProperty(JSON_PROPERTY_CHILDREN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<ManifestResources> getChildren() {
    return children;
  }

  @JsonProperty(JSON_PROPERTY_CHILDREN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setChildren(List<ManifestResources> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManifestDerivative manifestDerivative = (ManifestDerivative) o;
    return Objects.equals(this.name, manifestDerivative.name) &&
        Objects.equals(this.hasThumbnail, manifestDerivative.hasThumbnail) &&
        Objects.equals(this.progress, manifestDerivative.progress) &&
        Objects.equals(this.outputType, manifestDerivative.outputType) &&
        Objects.equals(this.properties, manifestDerivative.properties) &&
        Objects.equals(this.status, manifestDerivative.status) &&
        Objects.equals(this.messages, manifestDerivative.messages) &&
        Objects.equals(this.children, manifestDerivative.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hasThumbnail, progress, outputType, properties, status, messages, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestDerivative {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hasThumbnail: ").append(toIndentedString(hasThumbnail)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    outputType: ").append(toIndentedString(outputType)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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
