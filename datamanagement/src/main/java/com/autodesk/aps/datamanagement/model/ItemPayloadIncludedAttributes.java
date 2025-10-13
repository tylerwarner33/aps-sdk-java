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
 * The properties of the first version of the item to be created.
 */
@Schema(description = "The properties of the first version of the item to be created.")
@JsonPropertyOrder({
    ItemPayloadIncludedAttributes.JSON_PROPERTY_NAME,
    ItemPayloadIncludedAttributes.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("ItemPayload_included_attributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPayloadIncludedAttributes {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private ItemPayloadIncludedAttributesExtension extension;

  public ItemPayloadIncludedAttributes name(String name) {

    this.name = name;
    return this;
  }

  /**
   * The name of the version (1-255 characters).
   * 
   * Avoid using the following reserved characters in the name:
   * &#x60;&#x60;&lt;&#x60;&#x60;, &#x60;&#x60;&gt;&#x60;&#x60;,
   * &#x60;&#x60;:&#x60;&#x60;, &#x60;&#x60;&quot;&#x60;&#x60;,
   * &#x60;&#x60;/&#x60;&#x60;, &#x60;&#x60;\&#x60;&#x60;,
   * &#x60;&#x60;|&#x60;&#x60;, &#x60;&#x60;?&#x60;&#x60;,
   * &#x60;&#x60;*&#x60;&#x60;, &#x60;&#x60;&#39;&#x60;&#x60;,
   * &#x60;&#x60;\n&#x60;&#x60;, &#x60;&#x60;\r&#x60;&#x60;,
   * &#x60;&#x60;\t&#x60;&#x60;, &#x60;&#x60;\0&#x60;&#x60;,
   * &#x60;&#x60;\f&#x60;&#x60;, &#x60;&#x60;¢&#x60;&#x60;,
   * &#x60;&#x60;™&#x60;&#x60;, &#x60;&#x60;$
   * 
   * If you are creating a new item by copying a version of an existing item, the
   * name defaults to the name of the source version.
   * 
   * @return name
   **/
  @Schema(required = true, description = "The name of the version (1-255 characters).  Avoid using the following reserved characters in the name: ``<``, ``>``, ``:``, ``\"``, ``/``, ``\\``, ``|``, ``?``, ``*``, ``'``, ``\\n``, ``\\r``, ``\\t``, ``\\0``, ``\\f``, ``¢``, ``™``, ``$  If you are creating a new item by copying a version of an existing item, the name defaults to the name of the source version.")
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

  public ItemPayloadIncludedAttributes extension(ItemPayloadIncludedAttributesExtension extension) {

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

  public ItemPayloadIncludedAttributesExtension getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExtension(ItemPayloadIncludedAttributesExtension extension) {
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
    ItemPayloadIncludedAttributes itemPayloadIncludedAttributes = (ItemPayloadIncludedAttributes) o;
    return Objects.equals(this.name, itemPayloadIncludedAttributes.name) &&
        Objects.equals(this.extension, itemPayloadIncludedAttributes.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPayloadIncludedAttributes {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
