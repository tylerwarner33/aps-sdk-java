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
 * Envelope that contains the returned data.
 */
@Schema(description = "Envelope that contains the returned data.")
@JsonPropertyOrder({
    ObjectTreeData.JSON_PROPERTY_TYPE,
    ObjectTreeData.JSON_PROPERTY_OBJECTS
})
@JsonTypeName("ObjectTree_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ObjectTreeData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_OBJECTS = "objects";
  private List<ObjectTreeDataObjects> objects = new ArrayList<>();

  public ObjectTreeData type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The type of data that is returned. Always &#x60;&#x60;objects&#x60;&#x60;.
   * 
   * @return type
   **/
  @Schema(required = true, description = "The type of data that is returned. Always ``objects``.")
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

  public ObjectTreeData objects(List<ObjectTreeDataObjects> objects) {

    this.objects = objects;
    return this;
  }

  public ObjectTreeData addobjectsItem(ObjectTreeDataObjects objectsItem) {
    this.objects.add(objectsItem);
    return this;
  }

  /**
   * Collection of &quot;objects&quot; that constitute the nodes of the object
   * tree.
   * 
   * @return objects
   **/
  @Schema(required = true, description = "Collection of \"objects\" that constitute the nodes of the object tree.")
  @JsonProperty(JSON_PROPERTY_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ObjectTreeDataObjects> getObjects() {
    return objects;
  }

  @JsonProperty(JSON_PROPERTY_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObjects(List<ObjectTreeDataObjects> objects) {
    this.objects = objects;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectTreeData objectTreeData = (ObjectTreeData) o;
    return Objects.equals(this.type, objectTreeData.type) &&
        Objects.equals(this.objects, objectTreeData.objects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, objects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectTreeData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    objects: ").append(toIndentedString(objects)).append("\n");
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
