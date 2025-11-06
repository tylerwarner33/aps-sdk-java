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
  * A container of data describing a version.
  */
 @Schema(description = "A container of data describing a version.")
 @JsonPropertyOrder({
     VersionData.JSON_PROPERTY_TYPE,
     VersionData.JSON_PROPERTY_ID,
     VersionData.JSON_PROPERTY_ATTRIBUTES,
     VersionData.JSON_PROPERTY_RELATIONSHIPS,
     VersionData.JSON_PROPERTY_LINKS
 })
 @JsonTypeName("VersionData")
 @JsonIgnoreProperties(ignoreUnknown = true)
 
 public class VersionData implements FolderRefsData, ListRefsIncluded, RefsData, RelationshipRefsIncluded {
   public static final String JSON_PROPERTY_TYPE = "type";
   private TypeVersion type;
 
   public static final String JSON_PROPERTY_ID = "id";
   private String id;
 
   public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
   private VersionAttributes attributes;
 
   public static final String JSON_PROPERTY_RELATIONSHIPS = "relationships";
   private VersionDataRelationships relationships;
 
   public static final String JSON_PROPERTY_LINKS = "links";
   private JsonApiLinksSelfAndWebView links;
 
   public VersionData type(TypeVersion type) {
 
     this.type = type;
     return this;
   }
 
   /**
    * Get type
    * 
    * @return type
    **/
   @Schema(required = true, description = "")
   @JsonProperty(JSON_PROPERTY_TYPE)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
 
   public TypeVersion getTypeEnum() {
     return type;
   }
 
   @Override
   public String getType() {
     return type != null ? type.getValue() : null;
   }
 
   @JsonProperty(JSON_PROPERTY_TYPE)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setType(TypeVersion type) {
     this.type = type;
   }
 
   public VersionData id(String id) {
 
     this.id = id;
     return this;
   }
 
   /**
    * URN of the version object.
    * 
    * @return id
    **/
   @Schema(required = true, description = "URN of the version object.")
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
 
   public VersionData attributes(VersionAttributes attributes) {
 
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
 
   public VersionAttributes getAttributes() {
     return attributes;
   }
 
   @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setAttributes(VersionAttributes attributes) {
     this.attributes = attributes;
   }
 
   public VersionData relationships(VersionDataRelationships relationships) {
 
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
 
   public VersionDataRelationships getRelationships() {
     return relationships;
   }
 
   @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)
   public void setRelationships(VersionDataRelationships relationships) {
     this.relationships = relationships;
   }
 
   public VersionData links(JsonApiLinksSelfAndWebView links) {
 
     this.links = links;
     return this;
   }
 
   /**
    * Get links
    * 
    * @return links
    **/
   @javax.annotation.Nullable
   @Schema(description = "")
   @JsonProperty(JSON_PROPERTY_LINKS)
   @JsonInclude(value = JsonInclude.Include.NON_NULL)
 
   public JsonApiLinksSelfAndWebView getLinks() {
     return links;
   }
 
   @JsonProperty(JSON_PROPERTY_LINKS)
   @JsonInclude(value = JsonInclude.Include.NON_NULL)
   public void setLinks(JsonApiLinksSelfAndWebView links) {
     this.links = links;
   }
 
   @Override
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     VersionData versionData = (VersionData) o;
     return Objects.equals(this.type, versionData.type) &&
         Objects.equals(this.id, versionData.id) &&
         Objects.equals(this.attributes, versionData.attributes) &&
         Objects.equals(this.relationships, versionData.relationships) &&
         Objects.equals(this.links, versionData.links);
   }
 
   @Override
   public int hashCode() {
     return Objects.hash(type, id, attributes, relationships, links);
   }
 
   @Override
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class VersionData {\n");
     sb.append("    type: ").append(toIndentedString(type)).append("\n");
     sb.append("    id: ").append(toIndentedString(id)).append("\n");
     sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
     sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
     sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
 