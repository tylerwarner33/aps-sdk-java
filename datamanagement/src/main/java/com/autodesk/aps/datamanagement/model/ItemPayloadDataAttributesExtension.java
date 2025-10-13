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
 * The Type ID of the schema that defines the structure of the
 * &#x60;&#x60;extension.data&#x60;&#x60; object
 */
@Schema(description = "The Type ID of the schema that defines the structure of the ``extension.data`` object")
@JsonPropertyOrder({
    ItemPayloadDataAttributesExtension.JSON_PROPERTY_TYPE,
    ItemPayloadDataAttributesExtension.JSON_PROPERTY_VERSION,
    ItemPayloadDataAttributesExtension.JSON_PROPERTY_DATA
})
@JsonTypeName("ItemPayload_data_attributes_extension")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPayloadDataAttributesExtension {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_DATA = "data";
  private Map<String, Object> data = null;

  public ItemPayloadDataAttributesExtension type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The type of the extension.
   * 
   * For BIM 360 Docs files, use
   * &#x60;&#x60;items:autodesk.bim360:File&#x60;&#x60;.
   * 
   * For all other services, use &#x60;&#x60;items:autodesk.core:File&#x60;&#x60;.
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "The type of the extension.  For BIM 360 Docs files, use ``items:autodesk.bim360:File``.  For all other services, use ``items:autodesk.core:File``. ")
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

  public ItemPayloadDataAttributesExtension version(String version) {

    this.version = version;
    return this;
  }

  /**
   * The version of the schema that applies to the
   * &#x60;&#x60;extension.data&#x60;&#x60; object.
   * 
   * @return version
   **/
  @javax.annotation.Nullable
  @Schema(description = "The version of the schema that applies to the ``extension.data`` object.")
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

  public ItemPayloadDataAttributesExtension data(Map<String, Object> data) {

    this.data = data;
    return this;
  }

  public ItemPayloadDataAttributesExtension putdataItem(String key, Object dataItem) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, dataItem);
    return this;
  }

  /**
   * The container of additional properties.
   * 
   * The additional properties must follow the schema specified by
   * &#x60;&#x60;extensions.type&#x60;&#x60; and
   * &#x60;&#x60;extensions.version&#x60;&#x60;. Properties that don&#39;t follow
   * the schema will be ignored.
   * 
   * @return data
   **/
  @javax.annotation.Nullable
  @Schema(description = "The container of additional properties.  The additional properties must follow the schema specified by ``extensions.type`` and ``extensions.version``. Properties that don't follow the schema will be ignored. ")
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
    ItemPayloadDataAttributesExtension itemPayloadDataAttributesExtension = (ItemPayloadDataAttributesExtension) o;
    return Objects.equals(this.type, itemPayloadDataAttributesExtension.type) &&
        Objects.equals(this.version, itemPayloadDataAttributesExtension.version) &&
        Objects.equals(this.data, itemPayloadDataAttributesExtension.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, version, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPayloadDataAttributesExtension {\n");
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
