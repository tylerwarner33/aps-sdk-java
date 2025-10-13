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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Metadata on the resources referenced by this resource.
 */
@Schema(description = "Metadata on the resources referenced by this resource.")
@JsonPropertyOrder({
    MetaRefs.JSON_PROPERTY_REF_TYPE,
    MetaRefs.JSON_PROPERTY_DIRECTION,
    MetaRefs.JSON_PROPERTY_FROM_ID,
    MetaRefs.JSON_PROPERTY_FROM_TYPE,
    MetaRefs.JSON_PROPERTY_TO_ID,
    MetaRefs.JSON_PROPERTY_TO_TYPE,
    MetaRefs.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("MetaRefs")
@JsonIgnoreProperties(ignoreUnknown = true)

public class MetaRefs {
  public static final String JSON_PROPERTY_REF_TYPE = "refType";
  private TypeRef refType;

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  private MetarefsDirection direction;

  public static final String JSON_PROPERTY_FROM_ID = "fromId";
  private String fromId;

  public static final String JSON_PROPERTY_FROM_TYPE = "fromType";
  private TypeEntity fromType;

  public static final String JSON_PROPERTY_TO_ID = "toId";
  private String toId;

  public static final String JSON_PROPERTY_TO_TYPE = "toType";
  private TypeEntity toType;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private BaseAttributesExtensionObjectWithSchemaLink extension;

  public MetaRefs refType(TypeRef refType) {

    this.refType = refType;
    return this;
  }

  /**
   * Get refType
   * 
   * @return refType
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_REF_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public TypeRef getRefType() {
    return refType;
  }

  @JsonProperty(JSON_PROPERTY_REF_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRefType(TypeRef refType) {
    this.refType = refType;
  }

  public MetaRefs direction(MetarefsDirection direction) {

    this.direction = direction;
    return this;
  }

  /**
   * Get direction
   * 
   * @return direction
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public MetarefsDirection getDirection() {
    return direction;
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDirection(MetarefsDirection direction) {
    this.direction = direction;
  }

  public MetaRefs fromId(String fromId) {

    this.fromId = fromId;
    return this;
  }

  /**
   * The ID of the resource from where data flows.
   * 
   * @return fromId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the resource from where data flows.")
  @JsonProperty(JSON_PROPERTY_FROM_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getFromId() {
    return fromId;
  }

  @JsonProperty(JSON_PROPERTY_FROM_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFromId(String fromId) {
    this.fromId = fromId;
  }

  public MetaRefs fromType(TypeEntity fromType) {

    this.fromType = fromType;
    return this;
  }

  /**
   * Get fromType
   * 
   * @return fromType
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FROM_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public TypeEntity getFromType() {
    return fromType;
  }

  @JsonProperty(JSON_PROPERTY_FROM_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFromType(TypeEntity fromType) {
    this.fromType = fromType;
  }

  public MetaRefs toId(String toId) {

    this.toId = toId;
    return this;
  }

  /**
   * The ID of the resource to where the data flows.
   * 
   * @return toId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the resource to where the data flows.")
  @JsonProperty(JSON_PROPERTY_TO_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getToId() {
    return toId;
  }

  @JsonProperty(JSON_PROPERTY_TO_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setToId(String toId) {
    this.toId = toId;
  }

  public MetaRefs toType(TypeEntity toType) {

    this.toType = toType;
    return this;
  }

  /**
   * Get toType
   * 
   * @return toType
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TO_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public TypeEntity getToType() {
    return toType;
  }

  @JsonProperty(JSON_PROPERTY_TO_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setToType(TypeEntity toType) {
    this.toType = toType;
  }

  public MetaRefs extension(BaseAttributesExtensionObjectWithSchemaLink extension) {

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

  public BaseAttributesExtensionObjectWithSchemaLink getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExtension(BaseAttributesExtensionObjectWithSchemaLink extension) {
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
    MetaRefs metaRefs = (MetaRefs) o;
    return Objects.equals(this.refType, metaRefs.refType) &&
        Objects.equals(this.direction, metaRefs.direction) &&
        Objects.equals(this.fromId, metaRefs.fromId) &&
        Objects.equals(this.fromType, metaRefs.fromType) &&
        Objects.equals(this.toId, metaRefs.toId) &&
        Objects.equals(this.toType, metaRefs.toType) &&
        Objects.equals(this.extension, metaRefs.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refType, direction, fromId, fromType, toId, toType, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaRefs {\n");
    sb.append("    refType: ").append(toIndentedString(refType)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    fromId: ").append(toIndentedString(fromId)).append("\n");
    sb.append("    fromType: ").append(toIndentedString(fromType)).append("\n");
    sb.append("    toId: ").append(toIndentedString(toId)).append("\n");
    sb.append("    toType: ").append(toIndentedString(toType)).append("\n");
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
