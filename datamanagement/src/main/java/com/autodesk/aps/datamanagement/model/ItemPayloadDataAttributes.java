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
 * The properties of the item to be created.
 */
@Schema(description = "The properties of the item to be created.")
@JsonPropertyOrder({
    ItemPayloadDataAttributes.JSON_PROPERTY_DISPLAY_NAME,
    ItemPayloadDataAttributes.JSON_PROPERTY_EXTENSION
})
@JsonTypeName("ItemPayload_data_attributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPayloadDataAttributes {
  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private ItemPayloadDataAttributesExtension extension;

  public ItemPayloadDataAttributes displayName(String displayName) {

    this.displayName = displayName;
    return this;
  }

  /**
   * The name of the new item (1-255 characters).
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
   * &#x60;&#x60;™&#x60;&#x60;, &#x60;&#x60;$&#x60;&#x60;,
   * &#x60;&#x60;®&#x60;&#x60;.
   * 
   * @return displayName
   **/
  @javax.annotation.Nullable
  @Schema(description = "The name of the new item (1-255 characters).  Avoid using the following reserved characters in the name: ``<``, ``>``, ``:``, ``\"``, ``/``, ``\\``, ``|``, ``?``, ``*``, ``'``, ``\\n``, ``\\r``, ``\\t``, ``\\0``, ``\\f``, ``¢``, ``™``, ``$``, ``®``. ")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ItemPayloadDataAttributes extension(ItemPayloadDataAttributesExtension extension) {

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

  public ItemPayloadDataAttributesExtension getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExtension(ItemPayloadDataAttributesExtension extension) {
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
    ItemPayloadDataAttributes itemPayloadDataAttributes = (ItemPayloadDataAttributes) o;
    return Objects.equals(this.displayName, itemPayloadDataAttributes.displayName) &&
        Objects.equals(this.extension, itemPayloadDataAttributes.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPayloadDataAttributes {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
