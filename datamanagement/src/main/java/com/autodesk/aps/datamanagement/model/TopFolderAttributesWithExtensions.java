/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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

package com.autodesk.aps.datamanagement.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The properties of a folder.
 */
@Schema(description = "The properties of a folder.")
@JsonPropertyOrder({
    TopFolderAttributesWithExtensions.JSON_PROPERTY_NAME,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_DISPLAY_NAME,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_OBJECT_COUNT,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_CREATE_TIME,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_CREATE_USER_ID,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_CREATE_USER_NAME,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_LAST_MODIFIED_TIME,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_LAST_MODIFIED_USER_ID,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_LAST_MODIFIED_USER_NAME,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_LAST_MODIFIED_TIME_ROLLUP,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_HIDDEN,
    TopFolderAttributesWithExtensions.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("TopFolderAttributesWithExtensions")
@JsonIgnoreProperties(ignoreUnknown = true)

public class TopFolderAttributesWithExtensions {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_OBJECT_COUNT = "objectCount";
  private BigDecimal objectCount;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private OffsetDateTime createTime;

  public static final String JSON_PROPERTY_CREATE_USER_ID = "createUserId";
  private String createUserId;

  public static final String JSON_PROPERTY_CREATE_USER_NAME = "createUserName";
  private String createUserName;

  public static final String JSON_PROPERTY_LAST_MODIFIED_TIME = "lastModifiedTime";
  private OffsetDateTime lastModifiedTime;

  public static final String JSON_PROPERTY_LAST_MODIFIED_USER_ID = "lastModifiedUserId";
  private String lastModifiedUserId;

  public static final String JSON_PROPERTY_LAST_MODIFIED_USER_NAME = "lastModifiedUserName";
  private String lastModifiedUserName;

  public static final String JSON_PROPERTY_LAST_MODIFIED_TIME_ROLLUP = "lastModifiedTimeRollup";
  private String lastModifiedTimeRollup;

  public static final String JSON_PROPERTY_HIDDEN = "hidden";
  private Boolean hidden;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private TopFolderExtensionWithSchemaLink extension;

  public TopFolderAttributesWithExtensions name(String name) {

    this.name = name;
    return this;
  }

  /**
   * The name of the folder.
   * 
   * @return name
   **/
  @Schema(required = true, description = "The name of the folder.")
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

  public TopFolderAttributesWithExtensions displayName(String displayName) {

    this.displayName = displayName;
    return this;
  }

  /**
   * Reserved for future Use. Do not use. Use
   * &#x60;&#x60;attributes.name&#x60;&#x60; for the folder name.
   * 
   * @return displayName
   **/
  @Schema(required = true, description = "Reserved for future Use. Do not use. Use ``attributes.name`` for the folder name.")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public TopFolderAttributesWithExtensions objectCount(BigDecimal objectCount) {

    this.objectCount = objectCount;
    return this;
  }

  /**
   * The number of objects inside the folder.
   * 
   * @return objectCount
   **/
  @Schema(required = true, description = "The number of objects inside the folder.")
  @JsonProperty(JSON_PROPERTY_OBJECT_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getObjectCount() {
    return objectCount;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObjectCount(BigDecimal objectCount) {
    this.objectCount = objectCount;
  }

  public TopFolderAttributesWithExtensions createTime(OffsetDateTime createTime) {

    this.createTime = createTime;
    return this;
  }

  /**
   * The time the folder was created, in the following format:
   * &#x60;&#x60;YYYY-MM-DDThh:mm:ss.sz&#x60;&#x60;.
   * 
   * @return createTime
   **/
  @Schema(required = true, description = "The time the folder was created, in the following format: ``YYYY-MM-DDThh:mm:ss.sz``.")
  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCreateTime() {
    return createTime;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateTime(OffsetDateTime createTime) {
    this.createTime = createTime;
  }

  public TopFolderAttributesWithExtensions createUserId(String createUserId) {

    this.createUserId = createUserId;
    return this;
  }

  /**
   * The unique identifier of the user who created the folder.
   * 
   * @return createUserId
   **/
  @Schema(required = true, description = "The unique identifier of the user who created the folder.")
  @JsonProperty(JSON_PROPERTY_CREATE_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreateUserId() {
    return createUserId;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  public TopFolderAttributesWithExtensions createUserName(String createUserName) {

    this.createUserName = createUserName;
    return this;
  }

  /**
   * The name of the user who created the folder.
   * 
   * @return createUserName
   **/
  @Schema(required = true, description = "The name of the user who created the folder.")
  @JsonProperty(JSON_PROPERTY_CREATE_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreateUserName() {
    return createUserName;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public TopFolderAttributesWithExtensions lastModifiedTime(OffsetDateTime lastModifiedTime) {

    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

  /**
   * The last time the folder was modified, in the following format:
   * &#x60;&#x60;YYYY-MM-DDThh:mm:ss.sz&#x60;&#x60;.
   * 
   * @return lastModifiedTime
   **/
  @Schema(required = true, description = "The last time the folder was modified, in the following format: ``YYYY-MM-DDThh:mm:ss.sz``.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getLastModifiedTime() {
    return lastModifiedTime;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastModifiedTime(OffsetDateTime lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public TopFolderAttributesWithExtensions lastModifiedUserId(String lastModifiedUserId) {

    this.lastModifiedUserId = lastModifiedUserId;
    return this;
  }

  /**
   * The last time the folder was modified, in the following format:
   * &#x60;&#x60;YYYY-MM-DDThh:mm:ss.sz&#x60;&#x60;.
   * 
   * @return lastModifiedUserId
   **/
  @Schema(required = true, description = "The last time the folder was modified, in the following format: ``YYYY-MM-DDThh:mm:ss.sz``.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastModifiedUserId() {
    return lastModifiedUserId;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastModifiedUserId(String lastModifiedUserId) {
    this.lastModifiedUserId = lastModifiedUserId;
  }

  public TopFolderAttributesWithExtensions lastModifiedUserName(String lastModifiedUserName) {

    this.lastModifiedUserName = lastModifiedUserName;
    return this;
  }

  /**
   * The name of the user who last modified the folder.
   * 
   * @return lastModifiedUserName
   **/
  @Schema(required = true, description = "The name of the user who last modified the folder.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastModifiedUserName() {
    return lastModifiedUserName;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastModifiedUserName(String lastModifiedUserName) {
    this.lastModifiedUserName = lastModifiedUserName;
  }

  public TopFolderAttributesWithExtensions lastModifiedTimeRollup(String lastModifiedTimeRollup) {

    this.lastModifiedTimeRollup = lastModifiedTimeRollup;
    return this;
  }

  /**
   * The date and time the folder or any of its children were last updated.
   * 
   * @return lastModifiedTimeRollup
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time the folder or any of its children were last updated.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIME_ROLLUP)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLastModifiedTimeRollup() {
    return lastModifiedTimeRollup;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIME_ROLLUP)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLastModifiedTimeRollup(String lastModifiedTimeRollup) {
    this.lastModifiedTimeRollup = lastModifiedTimeRollup;
  }

  public TopFolderAttributesWithExtensions hidden(Boolean hidden) {

    this.hidden = hidden;
    return this;
  }

  /**
   * The folder’s current visibility state.
   * 
   * @return hidden
   **/
  @Schema(required = true, description = "The folder’s current visibility state.")
  @JsonProperty(JSON_PROPERTY_HIDDEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getHidden() {
    return hidden;
  }

  @JsonProperty(JSON_PROPERTY_HIDDEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public TopFolderAttributesWithExtensions extension(TopFolderExtensionWithSchemaLink extension) {

    this.extension = extension;
    return this;
  }

  /**
   * Get extension
   * 
   * @return extension
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public TopFolderExtensionWithSchemaLink getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExtension(TopFolderExtensionWithSchemaLink extension) {
    this.extension = extension;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopFolderAttributesWithExtensions topFolderAttributesWithExtensions = (TopFolderAttributesWithExtensions) o;
    return Objects.equals(this.name, topFolderAttributesWithExtensions.name) &&
        Objects.equals(this.displayName, topFolderAttributesWithExtensions.displayName) &&
        Objects.equals(this.objectCount, topFolderAttributesWithExtensions.objectCount) &&
        Objects.equals(this.createTime, topFolderAttributesWithExtensions.createTime) &&
        Objects.equals(this.createUserId, topFolderAttributesWithExtensions.createUserId) &&
        Objects.equals(this.createUserName, topFolderAttributesWithExtensions.createUserName) &&
        Objects.equals(this.lastModifiedTime, topFolderAttributesWithExtensions.lastModifiedTime) &&
        Objects.equals(this.lastModifiedUserId, topFolderAttributesWithExtensions.lastModifiedUserId) &&
        Objects.equals(this.lastModifiedUserName, topFolderAttributesWithExtensions.lastModifiedUserName) &&
        Objects.equals(this.lastModifiedTimeRollup, topFolderAttributesWithExtensions.lastModifiedTimeRollup) &&
        Objects.equals(this.hidden, topFolderAttributesWithExtensions.hidden) &&
        Objects.equals(this.extension, topFolderAttributesWithExtensions.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, displayName, objectCount, createTime, createUserId, createUserName, lastModifiedTime,
        lastModifiedUserId, lastModifiedUserName, lastModifiedTimeRollup, hidden, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopFolderAttributesWithExtensions {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    objectCount: ").append(toIndentedString(objectCount)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUserId: ").append(toIndentedString(createUserId)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
    sb.append("    lastModifiedUserId: ").append(toIndentedString(lastModifiedUserId)).append("\n");
    sb.append("    lastModifiedUserName: ").append(toIndentedString(lastModifiedUserName)).append("\n");
    sb.append("    lastModifiedTimeRollup: ").append(toIndentedString(lastModifiedTimeRollup)).append("\n");
    sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
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
