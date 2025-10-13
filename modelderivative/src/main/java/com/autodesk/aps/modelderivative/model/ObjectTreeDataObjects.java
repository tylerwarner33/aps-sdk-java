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
 * ObjectTreeDataObjects
 */
@JsonPropertyOrder({
    ObjectTreeDataObjects.JSON_PROPERTY_OBJECTID,
    ObjectTreeDataObjects.JSON_PROPERTY_NAME,
    ObjectTreeDataObjects.JSON_PROPERTY_OBJECTS
})
@JsonTypeName("ObjectTree_data_objects")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ObjectTreeDataObjects {
  public static final String JSON_PROPERTY_OBJECTID = "objectid";
  private BigDecimal objectid;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_OBJECTS = "objects";
  private List<Object> objects = null;

  public ObjectTreeDataObjects objectid(BigDecimal objectid) {

    this.objectid = objectid;
    return this;
  }

  /**
   * A non-persistent ID that is assigned to an object at translation time.
   * 
   * @return objectid
   **/
  @Schema(required = true, description = "A non-persistent ID that is assigned to an object at translation time.")
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

  public ObjectTreeDataObjects name(String name) {

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

  public ObjectTreeDataObjects objects(List<Object> objects) {

    this.objects = objects;
    return this;
  }

  public ObjectTreeDataObjects addobjectsItem(Object objectsItem) {
    if (this.objects == null) {
      this.objects = new ArrayList<>();
    }
    this.objects.add(objectsItem);
    return this;
  }

  /**
   * An optional array of objects of type &#x60;&#x60;object&#x60;&#x60; where
   * each object represents a child of the current node on the object tree.
   * 
   * @return objects
   **/
  @javax.annotation.Nullable
  @Schema(description = "An optional array of objects of type ``object`` where each object represents a child of the current node on the object tree.")
  @JsonProperty(JSON_PROPERTY_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> getObjects() {
    return objects;
  }

  @JsonProperty(JSON_PROPERTY_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setObjects(List<Object> objects) {
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
    ObjectTreeDataObjects objectTreeDataObjects = (ObjectTreeDataObjects) o;
    return Objects.equals(this.objectid, objectTreeDataObjects.objectid) &&
        Objects.equals(this.name, objectTreeDataObjects.name) &&
        Objects.equals(this.objects, objectTreeDataObjects.objects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectid, name, objects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectTreeDataObjects {\n");
    sb.append("    objectid: ").append(toIndentedString(objectid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
