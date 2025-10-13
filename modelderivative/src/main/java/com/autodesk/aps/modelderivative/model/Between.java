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
 * Describes a query for retrieving objects where a specified numeric property
 * falls within a specified range.
 */
@Schema(description = "Describes a query for retrieving objects where a specified numeric property falls within a specified range.")
@JsonPropertyOrder({
    Between.JSON_PROPERTY_$_BETWEEN
})
@JsonTypeName("Between")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Between implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_BETWEEN = "$between";
  private List<Object> $between = null;

  public Between $between(List<Object> $between) {

    this.$between = $between;
    return this;
  }

  public Between add$betweenItem(Object $betweenItem) {
    if (this.$between == null) {
      this.$between = new ArrayList<>();
    }
    this.$between.add($betweenItem);
    return this;
  }

  /**
   * Returns only the objects where the value of the specified numeric property
   * lies between the specified values.
   * 
   * The first element of the array contains the name of the property. The next
   * two elements specify the values that the property must lie between. The array
   * can only be three elements long.
   * 
   * For example, if you specify an array as:
   * &#x60;&#x60;&quot;$between&quot;:[&quot;properties.Dimensions.Width1&quot;,1,10]&#x60;&#x60;,
   * the request returns the properties of all objects whose
   * &#x60;&#x60;properties.Dimensions.Width1&#x60;&#x60; property is between
   * &#x60;&#x60;1&#x60;&#x60; and &#x60;&#x60;10&#x60;&#x60;.
   ** 
   * Note:** The Model Derivative service converts numeric values from their
   * native units to metric base units for comparison. So, you must specify the
   * values to compare with in metric base units. For example, if the property you
   * are comparing is a length measurement, you must specify the values in
   * &#x60;&#x60;m&#x60;&#x60;. Not in &#x60;&#x60;cm&#x60;&#x60;,
   * &#x60;&#x60;mm&#x60;&#x60;, or &#x60;&#x60;ft&#x60;&#x60;.
   * 
   * @return $between
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects where the value of the specified numeric property lies between the specified values.  The first element of the array contains the name of the property. The next two elements specify the values that the property must lie between. The array can only be three elements long.  For example, if you specify an array as: ``\"$between\":[\"properties.Dimensions.Width1\",1,10]``, the request returns the properties of all objects whose ``properties.Dimensions.Width1`` property is between ``1`` and ``10``.  **Note:** The Model Derivative service converts numeric values from their native units to metric base units for comparison. So, you must specify the values to compare with in metric base units. For example, if the property you are comparing is a length measurement, you must specify the values  in ``m``.  Not in ``cm``, ``mm``, or ``ft``.")
  @JsonProperty(JSON_PROPERTY_$_BETWEEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> get$Between() {
    return $between;
  }

  @JsonProperty(JSON_PROPERTY_$_BETWEEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$Between(List<Object> $between) {
    this.$between = $between;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Between between = (Between) o;
    return Objects.equals(this.$between, between.$between);
  }

  @Override
  public int hashCode() {
    return Objects.hash($between);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Between {\n");
    sb.append("    $between: ").append(toIndentedString($between)).append("\n");
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
