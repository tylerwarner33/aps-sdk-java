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
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Describes a query for retrieving objects where a specified attribute exactly
 * matches a specified value.
 */
@Schema(description = "Describes a query for retrieving objects where a specified attribute exactly matches a specified value.")
@JsonPropertyOrder({
    EqualsTo.JSON_PROPERTY_$_EQ
})
@JsonTypeName("EqualsTo")
@JsonIgnoreProperties(ignoreUnknown = true)

public class EqualsTo implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_EQ = "$eq";
  private List<Object> $eq = null;

  public EqualsTo $eq(List<Object> $eq) {

    this.$eq = $eq;
    return this;
  }

  public EqualsTo add$eqItem(Object $eqItem) {
    if (this.$eq == null) {
      this.$eq = new ArrayList<>();
    }
    this.$eq.add($eqItem);
    return this;
  }

  /**
   * Returns only the objects where the value of the specified attribute
   * (&#x60;&#x60;name&#x60;&#x60; attribute or any numerical property) is exactly
   * equal to the specified value.
   * 
   * The first element of the array contains the name of the attribute. This can
   * be the &#x60;&#x60;name&#x60;&#x60; attribute or the name of a numerical
   * property. The second element of the array must be the value to match. If the
   * first element is &#x60;&#x60;name&#x60;&#x60;, must be a string value. If the
   * first element is a numerical property, must be a numeric. The array can only
   * be two elements long.
   * 
   * For example, if you specify an array as:
   * &#x60;&#x60;&quot;$eq&quot;:[&quot;name&quot;,&quot;Rectangular&quot;]&#x60;&#x60;,
   * the request will only return the properties of the object named
   * &#x60;&#x60;Rectangular&#x60;&#x60;. if you specify an array as:
   * &#x60;&#x60;&quot;$eq&quot;:[&quot;properties.Dimensions.Width1&quot;,0.6]&#x60;&#x60;,
   * the request will return the properties of all objects whose
   * &#x60;&#x60;properties.Dimensions.Width1&#x60;&#x60; property is exactly
   * equal to &#x60;&#x60;0.6&#x60;&#x60;.
   ** 
   * Note:** We recommend that you use &#x60;&#x60;$between&#x60;&#x60; instead of
   * &#x60;&#x60;$eq&#x60;&#x60; when testing non-integer numeric values for
   * equality. Using &#x60;&#x60;between&#x60;&#x60; mitigates floating-point
   * errors.
   * 
   * @return $eq
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects where the value of the specified attribute (``name`` attribute or any numerical property) is exactly equal to the specified value.  The first element of the array contains the name of the attribute. This can be the ``name`` attribute or the name of a numerical property. The second element of the array must be the value to match. If the first element is ``name``, must be a string value. If the first element is a numerical property, must be a numeric. The array can only be two elements long.  For example, if you specify an array as: ``\"$eq\":[\"name\",\"Rectangular\"]``, the request will only return the properties of the object named ``Rectangular``. if you specify an array as: ``\"$eq\":[\"properties.Dimensions.Width1\",0.6]``, the request will return the properties of all objects whose ``properties.Dimensions.Width1`` property is exactly equal to ``0.6``.  **Note:** We recommend that you  use ``$between``  instead of ``$eq`` when testing non-integer numeric values for equality. Using ``between`` mitigates floating-point errors.")
  @JsonProperty(JSON_PROPERTY_$_EQ)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> get$Eq() {
    return $eq;
  }

  @JsonProperty(JSON_PROPERTY_$_EQ)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$Eq(List<Object> $eq) {
    this.$eq = $eq;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EqualsTo equalsTo = (EqualsTo) o;
    return Objects.equals(this.$eq, equalsTo.$eq);
  }

  @Override
  public int hashCode() {
    return Objects.hash($eq);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EqualsTo {\n");
    sb.append("    $eq: ").append(toIndentedString($eq)).append("\n");
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
