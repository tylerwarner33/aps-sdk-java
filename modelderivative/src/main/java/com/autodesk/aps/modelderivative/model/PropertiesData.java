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

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Container for the data returned by the Fetch All Properties operation.
 */
@Schema(description = "Container for the data returned by the Fetch All Properties operation.")
@JsonPropertyOrder({
    PropertiesData.JSON_PROPERTY_TYPE,
    PropertiesData.JSON_PROPERTY_COLLECTION
})
@JsonTypeName("Properties_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class PropertiesData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_COLLECTION = "collection";
  private List<PropertiesDataCollection> collection = new ArrayList<>();

  public PropertiesData type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The type of data that is returned. Always &#x60;&#x60;properties&#x60;&#x60;.
   * 
   * @return type
   **/
  @Schema(required = true, description = "The type of data that is returned. Always ``properties``.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }

  public PropertiesData collection(List<PropertiesDataCollection> collection) {

    this.collection = collection;
    return this;
  }

  public PropertiesData addcollectionItem(PropertiesDataCollection collectionItem) {
    this.collection.add(collectionItem);
    return this;
  }

  /**
   * A non-hierarchical list of objects contained in
   * the specified Model View. Each object has a
   * &#x60;&#x60;properties&#x60;&#x60; attribute, which contains the
   * properties of that object.
   * 
   * @return collection
   **/
  @Schema(required = true, description = "A non-hierarchical list of objects contained in  the specified Model View. Each object has a  ``properties`` attribute, which contains the  properties of that object.")
  @JsonProperty(JSON_PROPERTY_COLLECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<PropertiesDataCollection> getCollection() {
    return collection;
  }

  @JsonProperty(JSON_PROPERTY_COLLECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCollection(List<PropertiesDataCollection> collection) {
    this.collection = collection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PropertiesData propertiesData = (PropertiesData) o;
    return Objects.equals(this.type, propertiesData.type) &&
        Objects.equals(this.collection, propertiesData.collection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, collection);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PropertiesData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
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
