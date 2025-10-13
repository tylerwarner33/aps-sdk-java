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
 * The meta-information of the links of this resource.
 */
@Schema(description = "The meta-information of the links of this resource.")
@JsonPropertyOrder({
    RelationshipLinksDataMeta.JSON_PROPERTY_LINK,
    RelationshipLinksDataMeta.JSON_PROPERTY_DATA,
    RelationshipLinksDataMeta.JSON_PROPERTY_MIME_TYPE,
    RelationshipLinksDataMeta.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("RelationshipLinks_data_meta")
@JsonIgnoreProperties(ignoreUnknown = true)

public class RelationshipLinksDataMeta {
  public static final String JSON_PROPERTY_LINK = "link";
  private JsonApiLink link;

  public static final String JSON_PROPERTY_DATA = "data";
  private RelationshipLinksDataMetaData data;

  public static final String JSON_PROPERTY_MIME_TYPE = "mimeType";
  private String mimeType;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private BaseAttributesExtensionObjectWithSchemaLink extension;

  public RelationshipLinksDataMeta link(JsonApiLink link) {

    this.link = link;
    return this;
  }

  /**
   * Get link
   * 
   * @return link
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JsonApiLink getLink() {
    return link;
  }

  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLink(JsonApiLink link) {
    this.link = link;
  }

  public RelationshipLinksDataMeta data(RelationshipLinksDataMetaData data) {

    this.data = data;
    return this;
  }

  /**
   * Get data
   * 
   * @return data
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public RelationshipLinksDataMetaData getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setData(RelationshipLinksDataMetaData data) {
    this.data = data;
  }

  public RelationshipLinksDataMeta mimeType(String mimeType) {

    this.mimeType = mimeType;
    return this;
  }

  /**
   * The MIME type of the content of the resource.
   * 
   * @return mimeType
   **/
  @javax.annotation.Nullable
  @Schema(description = "The MIME type of the content of the resource.")
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

  public RelationshipLinksDataMeta extension(BaseAttributesExtensionObjectWithSchemaLink extension) {

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
    RelationshipLinksDataMeta relationshipLinksDataMeta = (RelationshipLinksDataMeta) o;
    return Objects.equals(this.link, relationshipLinksDataMeta.link) &&
        Objects.equals(this.data, relationshipLinksDataMeta.data) &&
        Objects.equals(this.mimeType, relationshipLinksDataMeta.mimeType) &&
        Objects.equals(this.extension, relationshipLinksDataMeta.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(link, data, mimeType, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationshipLinksDataMeta {\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
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
