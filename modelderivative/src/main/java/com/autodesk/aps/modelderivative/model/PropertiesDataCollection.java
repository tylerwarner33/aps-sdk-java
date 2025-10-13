/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Model Derivative
 * Use the Model Derivative API to translate designs from one CAD format to another. You can also use this API to extract metadata from a model.
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

package com.autodesk.aps.modelderivative.model;

import java.math.BigDecimal;
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
 * PropertiesDataCollection
 */
@JsonPropertyOrder({
    PropertiesDataCollection.JSON_PROPERTY_OBJECTID,
    PropertiesDataCollection.JSON_PROPERTY_NAME,
    PropertiesDataCollection.JSON_PROPERTY_EXTERNAL_ID,
    PropertiesDataCollection.JSON_PROPERTY_PROPERTIES
})
@JsonTypeName("Properties_data_collection")
@JsonIgnoreProperties(ignoreUnknown = true)

public class PropertiesDataCollection {
  public static final String JSON_PROPERTY_OBJECTID = "objectid";
  private BigDecimal objectid;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_EXTERNAL_ID = "externalId";
  private String externalId;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  private Map<String, Object> properties = null;

  public PropertiesDataCollection objectid(BigDecimal objectid) {

    this.objectid = objectid;
    return this;
  }

  /**
   * Unique identifier of the object.
   ** 
   * Note:** The &#x60;&#x60;objectid&#x60;&#x60; is a non-persistent ID assigned
   * to an object when a design file is translated to SVF or SVF2. So:
   * 
   * - The &#x60;&#x60;objectid&#x60;&#x60; of an object can change if the design
   * is translated to SVF or SVF2 again.
   * - If you require a persistent ID to reference an object, use
   * &#x60;&#x60;externalId&#x60;&#x60;.
   * 
   * @return objectid
   **/
  @Schema(required = true, description = "Unique identifier of the object.  **Note:** The ``objectid`` is a non-persistent ID assigned to an object when a design file is translated to SVF or SVF2. So:  - The ``objectid`` of an object can change if the design is translated to SVF or SVF2 again. - If you require a persistent ID to reference an object, use ``externalId``. ")
  @JsonProperty(JSON_PROPERTY_OBJECTID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getObjectid() {
    return objectid;
  }

  @JsonProperty(JSON_PROPERTY_OBJECTID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObjectid(BigDecimal objectid) {
    this.objectid = objectid;
  }

  public PropertiesDataCollection name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Name of the object.
   * 
   * @return name
   **/
  @Schema(required = true, description = "Name of the object.")
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

  public PropertiesDataCollection externalId(String externalId) {

    this.externalId = externalId;
    return this;
  }

  /**
   * A unique identifier of the object as defined in the source design. For
   * example, &#x60;&#x60;UniqueID&#x60;&#x60; in Revit files.
   * 
   * @return externalId
   **/
  @Schema(required = true, description = "A unique identifier of the object as defined in the source design. For example, ``UniqueID`` in Revit files.")
  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExternalId() {
    return externalId;
  }

  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public PropertiesDataCollection properties(Map<String, Object> properties) {

    this.properties = properties;
    return this;
  }

  public PropertiesDataCollection putpropertiesItem(String key, Object propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

  /**
   * A JSON object containing dictionary objects (key value pairs), where the key
   * is the property name and the value is the value of the property.
   * 
   * @return properties
   **/
  @javax.annotation.Nullable
  @Schema(description = "A JSON object containing dictionary objects (key value pairs), where the key is the property name and the value is the value of the property.")
  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Map<String, Object> getProperties() {
    return properties;
  }

  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PropertiesDataCollection propertiesDataCollection = (PropertiesDataCollection) o;
    return Objects.equals(this.objectid, propertiesDataCollection.objectid) &&
        Objects.equals(this.name, propertiesDataCollection.name) &&
        Objects.equals(this.externalId, propertiesDataCollection.externalId) &&
        Objects.equals(this.properties, propertiesDataCollection.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectid, name, externalId, properties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PropertiesDataCollection {\n");
    sb.append("    objectid: ").append(toIndentedString(objectid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
