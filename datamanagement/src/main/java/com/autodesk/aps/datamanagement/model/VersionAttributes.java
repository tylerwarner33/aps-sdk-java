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

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The properties of a version.
 */
@Schema(description = "The properties of a version.")
@JsonPropertyOrder({
    VersionAttributes.JSON_PROPERTY_NAME,
    VersionAttributes.JSON_PROPERTY_DISPLAY_NAME,
    VersionAttributes.JSON_PROPERTY_MIME_TYPE,
    VersionAttributes.JSON_PROPERTY_VERSION_NUMBER,
    VersionAttributes.JSON_PROPERTY_FILE_TYPE,
    VersionAttributes.JSON_PROPERTY_STORAGE_SIZE,
    VersionAttributes.JSON_PROPERTY_CREATE_TIME,
    VersionAttributes.JSON_PROPERTY_CREATE_USER_ID,
    VersionAttributes.JSON_PROPERTY_CREATE_USER_NAME,
    VersionAttributes.JSON_PROPERTY_LAST_MODIFIED_TIME,
    VersionAttributes.JSON_PROPERTY_LAST_MODIFIED_USER_ID,
    VersionAttributes.JSON_PROPERTY_LAST_MODIFIED_USER_NAME,
    VersionAttributes.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("VersionAttributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class VersionAttributes {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_MIME_TYPE = "mimeType";
  private String mimeType;

  public static final String JSON_PROPERTY_VERSION_NUMBER = "versionNumber";
  private Integer versionNumber;

  public static final String JSON_PROPERTY_FILE_TYPE = "fileType";
  private String fileType;

  public static final String JSON_PROPERTY_STORAGE_SIZE = "storageSize";
  private Long storageSize;

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

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private VersionExtensionWithSchemaLink extension;

  public VersionAttributes name(String name) {

    this.name = name;
    return this;
  }

  /**
   * The file name to be used when synced to local disk.
   * 
   * @return name
   **/
  @Schema(required = true, description = "The file name to be used when synced to local disk.")
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

  public VersionAttributes displayName(String displayName) {

    this.displayName = displayName;
    return this;
  }

  /**
   * A human friendly name to identify the version. Note that for BIM 360
   * projects, this field is reserved for future releases and should not be used.
   * Use a version&#39;s &#x60;&#x60;attributes.name&#x60;&#x60; for the file
   * name.
   * 
   * @return displayName
   **/
  @Schema(required = true, description = "A human friendly name to identify the version. Note that for BIM 360 projects, this field is reserved for future releases and should not be used. Use a version's ``attributes.name`` for the file name.")
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

  public VersionAttributes mimeType(String mimeType) {

    this.mimeType = mimeType;
    return this;
  }

  /**
   * The MIME type of the content of the version.
   * 
   * @return mimeType
   **/
  @javax.annotation.Nullable
  @Schema(description = "The MIME type of the content of the version.")
  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getMimeType() {
    return mimeType;
  }

  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public VersionAttributes versionNumber(Integer versionNumber) {

    this.versionNumber = versionNumber;
    return this;
  }

  /**
   * Version number of this versioned file.
   * 
   * @return versionNumber
   **/
  @Schema(required = true, description = "Version number of this versioned file.")
  @JsonProperty(JSON_PROPERTY_VERSION_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getVersionNumber() {
    return versionNumber;
  }

  @JsonProperty(JSON_PROPERTY_VERSION_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVersionNumber(Integer versionNumber) {
    this.versionNumber = versionNumber;
  }

  public VersionAttributes fileType(String fileType) {

    this.fileType = fileType;
    return this;
  }

  /**
   * File type, only present if this version represents a file.
   * 
   * @return fileType
   **/
  @javax.annotation.Nullable
  @Schema(description = "File type, only present if this version represents a file.")
  @JsonProperty(JSON_PROPERTY_FILE_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getFileType() {
    return fileType;
  }

  @JsonProperty(JSON_PROPERTY_FILE_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public VersionAttributes storageSize(Long storageSize) {

    this.storageSize = storageSize;
    return this;
  }

  /**
   * File size in bytes, only present if this version represents a file.
   * 
   * @return storageSize
   **/
  @javax.annotation.Nullable
  @Schema(description = "File size in bytes, only present if this version represents a file.")
  @JsonProperty(JSON_PROPERTY_STORAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getStorageSize() {
    return storageSize;
  }

  @JsonProperty(JSON_PROPERTY_STORAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStorageSize(Long storageSize) {
    this.storageSize = storageSize;
  }

  public VersionAttributes createTime(OffsetDateTime createTime) {

    this.createTime = createTime;
    return this;
  }

  /**
   * The time that the resource was created at.
   * 
   * @return createTime
   **/
  @Schema(required = true, description = "The time that the resource was created at.")
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

  public VersionAttributes createUserId(String createUserId) {

    this.createUserId = createUserId;
    return this;
  }

  /**
   * The ID of the user that created the version.
   * 
   * @return createUserId
   **/
  @Schema(required = true, description = "The ID of the user that created the version.")
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

  public VersionAttributes createUserName(String createUserName) {

    this.createUserName = createUserName;
    return this;
  }

  /**
   * The user name of the user that created the version.
   * 
   * @return createUserName
   **/
  @Schema(required = true, description = "The user name of the user that created the version.")
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

  public VersionAttributes lastModifiedTime(OffsetDateTime lastModifiedTime) {

    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

  /**
   * The time that the version was last modified.
   * 
   * @return lastModifiedTime
   **/
  @Schema(required = true, description = "The time that the version was last modified.")
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

  public VersionAttributes lastModifiedUserId(String lastModifiedUserId) {

    this.lastModifiedUserId = lastModifiedUserId;
    return this;
  }

  /**
   * The ID of the user that last modified the version.
   * 
   * @return lastModifiedUserId
   **/
  @Schema(required = true, description = "The ID of the user that last modified the version.")
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

  public VersionAttributes lastModifiedUserName(String lastModifiedUserName) {

    this.lastModifiedUserName = lastModifiedUserName;
    return this;
  }

  /**
   * The user name of the user that last modified the version.
   * 
   * @return lastModifiedUserName
   **/
  @Schema(required = true, description = "The user name of the user that last modified the version.")
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

  public VersionAttributes extension(VersionExtensionWithSchemaLink extension) {

    this.extension = extension;
    return this;
  }

  /**
   * Get extension
   * 
   * @return extension
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VersionExtensionWithSchemaLink getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExtension(VersionExtensionWithSchemaLink extension) {
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
    VersionAttributes versionAttributes = (VersionAttributes) o;
    return Objects.equals(this.name, versionAttributes.name) &&
        Objects.equals(this.displayName, versionAttributes.displayName) &&
        Objects.equals(this.mimeType, versionAttributes.mimeType) &&
        Objects.equals(this.versionNumber, versionAttributes.versionNumber) &&
        Objects.equals(this.fileType, versionAttributes.fileType) &&
        Objects.equals(this.storageSize, versionAttributes.storageSize) &&
        Objects.equals(this.createTime, versionAttributes.createTime) &&
        Objects.equals(this.createUserId, versionAttributes.createUserId) &&
        Objects.equals(this.createUserName, versionAttributes.createUserName) &&
        Objects.equals(this.lastModifiedTime, versionAttributes.lastModifiedTime) &&
        Objects.equals(this.lastModifiedUserId, versionAttributes.lastModifiedUserId) &&
        Objects.equals(this.lastModifiedUserName, versionAttributes.lastModifiedUserName) &&
        Objects.equals(this.extension, versionAttributes.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, displayName, mimeType, versionNumber, fileType, storageSize, createTime, createUserId,
        createUserName, lastModifiedTime, lastModifiedUserId, lastModifiedUserName, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionAttributes {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    versionNumber: ").append(toIndentedString(versionNumber)).append("\n");
    sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
    sb.append("    storageSize: ").append(toIndentedString(storageSize)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUserId: ").append(toIndentedString(createUserId)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
    sb.append("    lastModifiedUserId: ").append(toIndentedString(lastModifiedUserId)).append("\n");
    sb.append("    lastModifiedUserName: ").append(toIndentedString(lastModifiedUserName)).append("\n");
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
