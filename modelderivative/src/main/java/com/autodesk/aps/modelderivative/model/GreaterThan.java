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
 * Use this to retrieve only the properties of objects where a specified
 * property is greater than a specified value.
 */
@Schema(description = "Use this to retrieve only the properties of objects where a specified property is greater than a specified value. ")
@JsonPropertyOrder({
    GreaterThan.JSON_PROPERTY_$_GE
})
@JsonTypeName("GreaterThan")
@JsonIgnoreProperties(ignoreUnknown = true)

public class GreaterThan implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_GE = "$ge";
  private List<Object> $ge = null;

  public GreaterThan $ge(List<Object> $ge) {

    this.$ge = $ge;
    return this;
  }

  public GreaterThan add$geItem(Object $geItem) {
    if (this.$ge == null) {
      this.$ge = new ArrayList<>();
    }
    this.$ge.add($geItem);
    return this;
  }

  /**
   * Returns only the objects where the value of the specified numerical property
   * is greater than or equal to the specified value.
   * 
   * The first element of the array contains the name of the property. The next
   * element specifies the values that the property must be greater than or equal
   * to. The array can only be two elements long.
   * 
   * For example, if you specify an array as:
   * &#x60;&#x60;&quot;$ge&quot;:[&quot;properties.Dimensions.Width1&quot;,0.1]&#x60;&#x60;,
   * the request returns the properties of all objects whose
   * &#x60;&#x60;properties.Dimensions.Width1&#x60;&#x60; property is greater than
   * or equal to &#x60;&#x60;0.1&#x60;&#x60;.
   ** 
   * Note:** The Model Derivative service converts numeric values from their
   * native units to metric base units for comparison. So, the value to compare
   * with must be specified in metric base units. For example, if the property you
   * are comparing is a length measurement, you must specify the value in
   * &#x60;&#x60;m&#x60;&#x60;. Not in &#x60;&#x60;cm&#x60;&#x60;,
   * &#x60;&#x60;mm&#x60;&#x60;, or &#x60;&#x60;ft&#x60;&#x60;.
   * 
   * @return $ge
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects where the value of the specified numerical property is greater than or equal to the specified value.  The first element of the array contains the name of the property. The next element specifies the values that the property must be greater than or equal to. The array can only be two elements long.  For example, if you specify an array as: ``\"$ge\":[\"properties.Dimensions.Width1\",0.1]``, the request returns the properties of all objects whose ``properties.Dimensions.Width1`` property is greater than or equal to  ``0.1``.  **Note:** The Model Derivative service converts numeric values from their native units to metric base units for comparison. So, the value to compare with must be specified in metric base units. For example, if the property you are comparing is a length measurement, you must specify the value  in ``m``.  Not in ``cm``, ``mm``, or ``ft``. ")
  @JsonProperty(JSON_PROPERTY_$_GE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> get$Ge() {
    return $ge;
  }

  @JsonProperty(JSON_PROPERTY_$_GE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$Ge(List<Object> $ge) {
    this.$ge = $ge;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GreaterThan greaterThan = (GreaterThan) o;
    return Objects.equals(this.$ge, greaterThan.$ge);
  }

  @Override
  public int hashCode() {
    return Objects.hash($ge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GreaterThan {\n");
    sb.append("    $ge: ").append(toIndentedString($ge)).append("\n");
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
