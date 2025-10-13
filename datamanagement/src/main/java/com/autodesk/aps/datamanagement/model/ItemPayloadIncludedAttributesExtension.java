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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A container of additional properties that extends the default properties of
 * this resource.
 */
@Schema(description = "A container of additional properties that extends the default properties of this resource.")
@JsonPropertyOrder({
    ItemPayloadIncludedAttributesExtension.JSON_PROPERTY_TYPE,
    ItemPayloadIncludedAttributesExtension.JSON_PROPERTY_VERSION,
    ItemPayloadIncludedAttributesExtension.JSON_PROPERTY_DATA
})
@JsonTypeName("ItemPayload_included_attributes_extension")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPayloadIncludedAttributesExtension {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_DATA = "data";
  private Map<String, Object> data = null;

  public ItemPayloadIncludedAttributesExtension type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The type of the extension.
   * 
   * For BIM 360 Docs files, use
   * &#x60;&#x60;versions:autodesk.bim360:File&#x60;&#x60;.
   * 
   * For A360 composite design files, use
   * &#x60;&#x60;versions:autodesk.a360:CompositeDesign&#x60;&#x60;.
   * 
   * For A360 Personal, Fusion Team, or BIM 360 Team files, use
   * &#x60;&#x60;versions:autodesk.core:File&#x60;&#x60;.
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "The type of the extension.  For BIM 360 Docs files, use ``versions:autodesk.bim360:File``.  For A360 composite design files, use ``versions:autodesk.a360:CompositeDesign``.  For A360 Personal, Fusion Team, or BIM 360 Team files, use ``versions:autodesk.core:File``. ")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(String type) {
    this.type = type;
  }

  public ItemPayloadIncludedAttributesExtension version(String version) {

    this.version = version;
    return this;
  }

  /**
   * The version of the extension type
   * (&#x60;&#x60;included[i].attributes.extension.type&#x60;&#x60;). The current
   * version is &#x60;&#x60;1.0&#x60;&#x60;.
   * 
   * @return version
   **/
  @javax.annotation.Nullable
  @Schema(description = "The version of the extension type (``included[i].attributes.extension.type``). The current version is ``1.0``.")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getVersion() {
    return version;
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setVersion(String version) {
    this.version = version;
  }

  public ItemPayloadIncludedAttributesExtension data(Map<String, Object> data) {

    this.data = data;
    return this;
  }

  public ItemPayloadIncludedAttributesExtension putdataItem(String key, Object dataItem) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, dataItem);
    return this;
  }

  /**
   * The container of the additional properties.
   * 
   * The additional properties must follow the schema specified by
   * &#x60;&#x60;extensions.type&#x60;&#x60; and
   * &#x60;&#x60;extensions.version&#x60;&#x60;. Properties that don&#39;t follow
   * the schema will be ignored.
   * 
   * @return data
   **/
  @javax.annotation.Nullable
  @Schema(description = "The container of the additional properties.  The additional properties must follow the schema specified by ``extensions.type`` and ``extensions.version``. Properties that don't follow the schema will be ignored.")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Map<String, Object> getData() {
    return data;
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemPayloadIncludedAttributesExtension itemPayloadIncludedAttributesExtension = (ItemPayloadIncludedAttributesExtension) o;
    return Objects.equals(this.type, itemPayloadIncludedAttributesExtension.type) &&
        Objects.equals(this.version, itemPayloadIncludedAttributesExtension.version) &&
        Objects.equals(this.data, itemPayloadIncludedAttributesExtension.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, version, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPayloadIncludedAttributesExtension {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
