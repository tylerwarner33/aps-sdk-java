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
 * is less than or equal to a specified value.
 */
@Schema(description = "Describes a query for retrieving objects where a specified numeric property is less than or equal to a specified value.")
@JsonPropertyOrder({
    LessThan.JSON_PROPERTY_$_LE
})
@JsonTypeName("LessThan")
@JsonIgnoreProperties(ignoreUnknown = true)

public class LessThan implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_LE = "$le";
  private List<Object> $le = null;

  public LessThan $le(List<Object> $le) {

    this.$le = $le;
    return this;
  }

  public LessThan add$leItem(Object $leItem) {
    if (this.$le == null) {
      this.$le = new ArrayList<>();
    }
    this.$le.add($leItem);
    return this;
  }

  /**
   * Returns only the objects where the value of the specified numeric property is
   * less than or equal to the specified value.
   * 
   * The first element of the array contains the name of the property. The next
   * element specifies the values that the property must be less than or equal to.
   * The array can only be two elements long.
   * 
   * For example, if you specify an array as:
   * &#x60;&#x60;&quot;$le&quot;:[&quot;properties.Dimensions.Width1&quot;,10]&#x60;&#x60;,
   * the request returns the properties of all objects whose
   * &#x60;&#x60;properties.Dimensions.Width1&#x60;&#x60; property is less than or
   * equal to &#x60;&#x60;10&#x60;&#x60;.
   ** 
   * Note:** The Model Derivative service converts numeric values from their
   * native units to metric base units for comparison. So, the value to compare
   * with must be specified in metric base units. For example, if the property you
   * are comparing is a length measurement, you must specify the value in
   * &#x60;&#x60;m&#x60;&#x60;. Not in &#x60;&#x60;cm&#x60;&#x60;,
   * &#x60;&#x60;mm&#x60;&#x60;, or &#x60;&#x60;ft&#x60;&#x60;.
   * 
   * @return $le
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects where the value of the specified numeric property is less than or equal to the specified value.  The first element of the array contains the name of the property. The next element specifies the values that the property must be less than or equal to. The array can only be two elements long.  For example, if you specify an array as: ``\"$le\":[\"properties.Dimensions.Width1\",10]``, the request returns the properties of all objects whose ``properties.Dimensions.Width1`` property is less than or equal to ``10``.  **Note:** The Model Derivative service converts numeric values from their native units to metric base units for comparison. So, the value to compare with must be specified in metric base units. For example, if the property you are comparing is a length measurement, you must specify the value  in ``m``.  Not in ``cm``, ``mm``, or ``ft``.")
  @JsonProperty(JSON_PROPERTY_$_LE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> get$Le() {
    return $le;
  }

  @JsonProperty(JSON_PROPERTY_$_LE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$Le(List<Object> $le) {
    this.$le = $le;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LessThan lessThan = (LessThan) o;
    return Objects.equals(this.$le, lessThan.$le);
  }

  @Override
  public int hashCode() {
    return Objects.hash($le);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LessThan {\n");
    sb.append("    $le: ").append(toIndentedString($le)).append("\n");
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
