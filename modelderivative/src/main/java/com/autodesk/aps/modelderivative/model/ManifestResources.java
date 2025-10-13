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

import java.math.BigDecimal;
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
 * Represents a resource generated for a derivative.
 */
@Schema(description = "Represents a resource generated for a derivative.")
@JsonPropertyOrder({
    ManifestResources.JSON_PROPERTY_GUID,
    ManifestResources.JSON_PROPERTY_TYPE,
    ManifestResources.JSON_PROPERTY_URN,
    ManifestResources.JSON_PROPERTY_ROLE,
    ManifestResources.JSON_PROPERTY_MIME,
    ManifestResources.JSON_PROPERTY_VIEWABLE_I_D,
    ManifestResources.JSON_PROPERTY_NAME,
    ManifestResources.JSON_PROPERTY_STATUS,
    ManifestResources.JSON_PROPERTY_HAS_THUMBNAIL,
    ManifestResources.JSON_PROPERTY_PROGRESS,
    ManifestResources.JSON_PROPERTY_PHASE_NAMES,
    ManifestResources.JSON_PROPERTY_PHASE_IDS,
    ManifestResources.JSON_PROPERTY_CAMERA,
    ManifestResources.JSON_PROPERTY_RESOLUTION,
    ManifestResources.JSON_PROPERTY_MESSAGES,
    ManifestResources.JSON_PROPERTY_CHILDREN
})
@JsonTypeName("ManifestResources")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ManifestResources {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_ROLE = "role";
  private String role;

  public static final String JSON_PROPERTY_MIME = "mime";
  private String mime;

  public static final String JSON_PROPERTY_VIEWABLE_I_D = "viewableID";
  private String viewableID;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_HAS_THUMBNAIL = "hasThumbnail";
  private String hasThumbnail;

  public static final String JSON_PROPERTY_PROGRESS = "progress";
  private String progress;

  public static final String JSON_PROPERTY_PHASE_NAMES = "phaseNames";
  private Object phaseNames;

  public static final String JSON_PROPERTY_PHASE_IDS = "phaseIds";
  private Object phaseIds;

  public static final String JSON_PROPERTY_CAMERA = "camera";
  private List<BigDecimal> camera = null;

  public static final String JSON_PROPERTY_RESOLUTION = "resolution";
  private List<Integer> resolution = null;

  public static final String JSON_PROPERTY_MESSAGES = "messages";
  private List<Messages> messages = null;

  public static final String JSON_PROPERTY_CHILDREN = "children";
  private List<ManifestResources> children = null;

  public ManifestResources guid(String guid) {

    this.guid = guid;
    return this;
  }

  /**
   * An ID that uniquely identifies the resource.
   * 
   * @return guid
   **/
  @Schema(required = true, description = "An ID that uniquely identifies the resource.")
  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGuid() {
    return guid;
  }

  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGuid(String guid) {
    this.guid = guid;
  }

  public ManifestResources type(String type) {

    this.type = type;
    return this;
  }

  /**
   * Type of resource this JSON object represents.
   * 
   * @return type
   **/
  @Schema(required = true, description = "Type of resource this JSON object represents.")
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

  public ManifestResources urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URN that you can use to access the resource.
   * 
   * @return urn
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URN that you can use to access the resource.")
  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUrn() {
    return urn;
  }

  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUrn(String urn) {
    this.urn = urn;
  }

  public ManifestResources role(String role) {

    this.role = role;
    return this;
  }

  /**
   * File type of the resource.
   * 
   * @return role
   **/
  @Schema(required = true, description = "File type of the resource.")
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRole() {
    return role;
  }

  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRole(String role) {
    this.role = role;
  }

  public ManifestResources mime(String mime) {

    this.mime = mime;
    return this;
  }

  /**
   * MIME type of the content of the resource.
   * 
   * @return mime
   **/
  @javax.annotation.Nullable
  @Schema(description = "MIME type of the content of the resource.")
  @JsonProperty(JSON_PROPERTY_MIME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getMime() {
    return mime;
  }

  @JsonProperty(JSON_PROPERTY_MIME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMime(String mime) {
    this.mime = mime;
  }

  public ManifestResources viewableID(String viewableID) {

    this.viewableID = viewableID;
    return this;
  }

  /**
   * An ID assigned to a resource that can be displayed in a viewer.
   * 
   * @return viewableID
   **/
  @javax.annotation.Nullable
  @Schema(description = "An ID assigned to a resource that can be displayed in a viewer.")
  @JsonProperty(JSON_PROPERTY_VIEWABLE_I_D)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getViewableID() {
    return viewableID;
  }

  @JsonProperty(JSON_PROPERTY_VIEWABLE_I_D)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setViewableID(String viewableID) {
    this.viewableID = viewableID;
  }

  public ManifestResources name(String name) {

    this.name = name;
    return this;
  }

  /**
   * The name of the resource.
   * 
   * @return name
   **/
  @javax.annotation.Nullable
  @Schema(description = "The name of the resource.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setName(String name) {
    this.name = name;
  }

  public ManifestResources status(String status) {

    this.status = status;
    return this;
  }

  /**
   * Status of the task generating this resource; Possible values are:
   * &#x60;&#x60;pending&#x60;&#x60;, &#x60;&#x60;inprogress&#x60;&#x60;,
   * &#x60;&#x60;success&#x60;&#x60;, &#x60;&#x60;failed&#x60;&#x60;,
   * &#x60;&#x60;timeout&#x60;&#x60;
   * 
   * @return status
   **/
  @Schema(required = true, description = "Status of the task generating this resource; Possible values are:  ``pending``, ``inprogress``, ``success``, ``failed``, ``timeout``")
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

  public ManifestResources hasThumbnail(String hasThumbnail) {

    this.hasThumbnail = hasThumbnail;
    return this;
  }

  /**
   * - &#x60;&#x60;true&#x60;&#x60;: There is a thumbnail for the resource.
   * - &#x60;&#x60;false&#x60;&#x60;: There is no thumbnail for the resource.
   * 
   * @return hasThumbnail
   **/
  @javax.annotation.Nullable
  @Schema(description = "- ``true``: There is a thumbnail for the resource. - ``false``: There is no thumbnail for the resource. ")
  @JsonProperty(JSON_PROPERTY_HAS_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getHasThumbnail() {
    return hasThumbnail;
  }

  @JsonProperty(JSON_PROPERTY_HAS_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHasThumbnail(String hasThumbnail) {
    this.hasThumbnail = hasThumbnail;
  }

  public ManifestResources progress(String progress) {

    this.progress = progress;
    return this;
  }

  /**
   * Indicates the progress of the process generating this resource, as a
   * percentage. Once complete, the value changes to
   * &#x60;&#x60;complete&#x60;&#x60;.
   * 
   * @return progress
   **/
  @javax.annotation.Nullable
  @Schema(description = "Indicates the progress of the process generating this resource, as a percentage. Once complete, the value changes to ``complete``.")
  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getProgress() {
    return progress;
  }

  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProgress(String progress) {
    this.progress = progress;
  }

  public ManifestResources phaseNames(Object phaseNames) {

    this.phaseNames = phaseNames;
    return this;
  }

  /**
   * The name of the phase the resource file was generated from. This attribute is
   * present only on Model Views (Viewables) generated from a Revit source design.
   * This attribute can be a string (for Revit non-sheet 2D or 3D views) or an
   * array of strings (for Revit sheet views).
   * 
   * @return phaseNames
   **/
  @javax.annotation.Nullable
  @Schema(description = "The name of the phase the resource file was generated from. This attribute is present only on Model Views (Viewables) generated from a Revit source design. This attribute can be a string (for Revit non-sheet 2D or 3D views) or an array of strings (for Revit sheet views).")
  @JsonProperty(JSON_PROPERTY_PHASE_NAMES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getPhaseNames() {
    return phaseNames;
  }

  @JsonProperty(JSON_PROPERTY_PHASE_NAMES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPhaseNames(Object phaseNames) {
    this.phaseNames = phaseNames;
  }

  public ManifestResources phaseIds(Object phaseIds) {

    this.phaseIds = phaseIds;
    return this;
  }

  /**
   * The unique ID of the phase the resource file was generated from. This
   * attribute is present only on Model Views (Viewables) generated from a Revit
   * source design. This attribute can be a string (for Revit non-sheet 2D or 3D
   * views) or an array of strings (for Revit sheet views).
   * 
   * @return phaseIds
   **/
  @javax.annotation.Nullable
  @Schema(description = "The unique ID of the phase the resource file was generated from. This attribute is present only on Model Views (Viewables) generated from a Revit source design. This attribute can be a string (for Revit non-sheet 2D or 3D views) or an array of strings (for Revit sheet views).")
  @JsonProperty(JSON_PROPERTY_PHASE_IDS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getPhaseIds() {
    return phaseIds;
  }

  @JsonProperty(JSON_PROPERTY_PHASE_IDS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPhaseIds(Object phaseIds) {
    this.phaseIds = phaseIds;
  }

  public ManifestResources camera(List<BigDecimal> camera) {

    this.camera = camera;
    return this;
  }

  public ManifestResources addcameraItem(BigDecimal cameraItem) {
    if (this.camera == null) {
      this.camera = new ArrayList<>();
    }
    this.camera.add(cameraItem);
    return this;
  }

  /**
   * The default viewpoint of a viewable 3D resource.
   * 
   * @return camera
   **/
  @javax.annotation.Nullable
  @Schema(description = "The default viewpoint of a viewable 3D resource.")
  @JsonProperty(JSON_PROPERTY_CAMERA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<BigDecimal> getCamera() {
    return camera;
  }

  @JsonProperty(JSON_PROPERTY_CAMERA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCamera(List<BigDecimal> camera) {
    this.camera = camera;
  }

  public ManifestResources resolution(List<Integer> resolution) {

    this.resolution = resolution;
    return this;
  }

  public ManifestResources addresolutionItem(Integer resolutionItem) {
    if (this.resolution == null) {
      this.resolution = new ArrayList<>();
    }
    this.resolution.add(resolutionItem);
    return this;
  }

  /**
   * An array of two integers where the first number represents the width of a
   * thumbnail in pixels, and the second the height. Available only for thumbnail
   * resources.
   * 
   * @return resolution
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of two integers where the first number represents the width of a thumbnail in pixels, and the second the height. Available only for thumbnail resources.")
  @JsonProperty(JSON_PROPERTY_RESOLUTION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Integer> getResolution() {
    return resolution;
  }

  @JsonProperty(JSON_PROPERTY_RESOLUTION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResolution(List<Integer> resolution) {
    this.resolution = resolution;
  }

  public ManifestResources messages(List<Messages> messages) {

    this.messages = messages;
    return this;
  }

  public ManifestResources addmessagesItem(Messages messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Get messages
   * 
   * @return messages
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
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

  public ManifestResources children(List<ManifestResources> children) {

    this.children = children;
    return this;
  }

  public ManifestResources addchildrenItem(ManifestResources childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * An optional array of objects, where each object (of type
   * &#x60;&#x60;children&#x60;&#x60;) represents another resource generated for
   * this resource.
   * 
   * @return children
   **/
  @javax.annotation.Nullable
  @Schema(description = "An optional array of objects, where each object (of type ``children``) represents another resource generated for this resource.")
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
    ManifestResources manifestResources = (ManifestResources) o;
    return Objects.equals(this.guid, manifestResources.guid) &&
        Objects.equals(this.type, manifestResources.type) &&
        Objects.equals(this.urn, manifestResources.urn) &&
        Objects.equals(this.role, manifestResources.role) &&
        Objects.equals(this.mime, manifestResources.mime) &&
        Objects.equals(this.viewableID, manifestResources.viewableID) &&
        Objects.equals(this.name, manifestResources.name) &&
        Objects.equals(this.status, manifestResources.status) &&
        Objects.equals(this.hasThumbnail, manifestResources.hasThumbnail) &&
        Objects.equals(this.progress, manifestResources.progress) &&
        Objects.equals(this.phaseNames, manifestResources.phaseNames) &&
        Objects.equals(this.phaseIds, manifestResources.phaseIds) &&
        Objects.equals(this.camera, manifestResources.camera) &&
        Objects.equals(this.resolution, manifestResources.resolution) &&
        Objects.equals(this.messages, manifestResources.messages) &&
        Objects.equals(this.children, manifestResources.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, type, urn, role, mime, viewableID, name, status, hasThumbnail, progress, phaseNames,
        phaseIds, camera, resolution, messages, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestResources {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    mime: ").append(toIndentedString(mime)).append("\n");
    sb.append("    viewableID: ").append(toIndentedString(viewableID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    hasThumbnail: ").append(toIndentedString(hasThumbnail)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    phaseNames: ").append(toIndentedString(phaseNames)).append("\n");
    sb.append("    phaseIds: ").append(toIndentedString(phaseIds)).append("\n");
    sb.append("    camera: ").append(toIndentedString(camera)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
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
