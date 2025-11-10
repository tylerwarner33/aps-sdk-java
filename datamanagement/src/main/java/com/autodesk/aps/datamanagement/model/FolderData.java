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

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
 
 /**
  * A container of data describing a folder.
  */
 @Schema(description = "A container of data describing a folder.")
 @JsonPropertyOrder({
     FolderData.JSON_PROPERTY_TYPE,
     FolderData.JSON_PROPERTY_ID,
     FolderData.JSON_PROPERTY_ATTRIBUTES,
     FolderData.JSON_PROPERTY_LINKS,
     FolderData.JSON_PROPERTY_RELATIONSHIPS
 })
 @JsonTypeName("FolderData")
 @JsonIgnoreProperties(ignoreUnknown = true)
 
 public class FolderData implements FolderContentsData, FolderRefsData, RefsData, RelationshipRefsIncluded {
   public static final String JSON_PROPERTY_TYPE = "type";
   private TypeFolder type;
 
   public static final String JSON_PROPERTY_ID = "id";
   private String id;
 
   public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
   private FolderAttributesWithExtensions attributes;
 
   public static final String JSON_PROPERTY_LINKS = "links";
   private JsonApiLinksSelfAndWebView links;
 
   public static final String JSON_PROPERTY_RELATIONSHIPS = "relationships";
   private FolderDataRelationships relationships;
 
   public FolderData type(TypeFolder type) {
 
     this.type = type;
     return this;
   }
 
  /**
   * Get type
   * 
   * @return type
   **/
  @Schema(required = true, description = "")
  @JsonIgnore

 public TypeFolder getType() {
   return type;
 }

  @JsonGetter(JSON_PROPERTY_TYPE)
  @Override
  public String getTypeValue() {
    return type != null ? type.getValue() : null;
  }
 
   @JsonProperty(JSON_PROPERTY_TYPE)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setType(TypeFolder type) {
     this.type = type;
   }
 
   public FolderData id(String id) {
 
     this.id = id;
     return this;
   }
 
   /**
    * The unique identifier of the folder.
    * 
    * @return id
    **/
   @Schema(required = true, description = "The unique identifier of the folder.")
   @JsonProperty(JSON_PROPERTY_ID)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
 
   public String getId() {
     return id;
   }
 
   @JsonProperty(JSON_PROPERTY_ID)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setId(String id) {
     this.id = id;
   }
 
   public FolderData attributes(FolderAttributesWithExtensions attributes) {
 
     this.attributes = attributes;
     return this;
   }
 
   /**
    * Get attributes
    * 
    * @return attributes
    **/
   @Schema(required = true, description = "")
   @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
 
   public FolderAttributesWithExtensions getAttributes() {
     return attributes;
   }
 
   @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setAttributes(FolderAttributesWithExtensions attributes) {
     this.attributes = attributes;
   }
 
   public FolderData links(JsonApiLinksSelfAndWebView links) {
 
     this.links = links;
     return this;
   }
 
   /**
    * Get links
    * 
    * @return links
    **/
   @Schema(required = true, description = "")
   @JsonProperty(JSON_PROPERTY_LINKS)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
 
   public JsonApiLinksSelfAndWebView getLinks() {
     return links;
   }
 
   @JsonProperty(JSON_PROPERTY_LINKS)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setLinks(JsonApiLinksSelfAndWebView links) {
     this.links = links;
   }
 
   public FolderData relationships(FolderDataRelationships relationships) {
 
     this.relationships = relationships;
     return this;
   }
 
   /**
    * Get relationships
    * 
    * @return relationships
    **/
   @Schema(required = true, description = "")
   @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
 
   public FolderDataRelationships getRelationships() {
     return relationships;
   }
 
   @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setRelationships(FolderDataRelationships relationships) {
     this.relationships = relationships;
   }
 
   @Override
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     FolderData folderData = (FolderData) o;
     return Objects.equals(this.type, folderData.type) &&
         Objects.equals(this.id, folderData.id) &&
         Objects.equals(this.attributes, folderData.attributes) &&
         Objects.equals(this.links, folderData.links) &&
         Objects.equals(this.relationships, folderData.relationships);
   }
 
   @Override
   public int hashCode() {
     return Objects.hash(type, id, attributes, links, relationships);
   }
 
   @Override
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class FolderData {\n");
     sb.append("    type: ").append(toIndentedString(type)).append("\n");
     sb.append("    id: ").append(toIndentedString(id)).append("\n");
     sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
     sb.append("    links: ").append(toIndentedString(links)).append("\n");
     sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
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
 