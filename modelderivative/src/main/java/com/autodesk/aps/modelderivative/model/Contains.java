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
 * Describes a query for retrieving objects where a specified property contains
 * one or more words in a specified string.
 */
@Schema(description = "Describes a query for retrieving objects where a specified property contains one or more words in a specified string.")
@JsonPropertyOrder({
    Contains.JSON_PROPERTY_$_CONTAINS
})
@JsonTypeName("Contains")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Contains implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_CONTAINS = "$contains";
  private List<String> $contains = null;

  public Contains $contains(List<String> $contains) {

    this.$contains = $contains;
    return this;
  }

  public Contains add$containsItem(String $containsItem) {
    if (this.$contains == null) {
      this.$contains = new ArrayList<>();
    }
    this.$contains.add($containsItem);
    return this;
  }

  /**
   * Returns only the objects where the value of the specified property contains
   * the words specified in a string.
   * 
   * The first element of the array contains the name of the property. The second
   * element contains a string containing the words to match. The array can only
   * be two elements long.
   * 
   * For example, if you specify an array as:
   * &#x60;&#x60;&quot;$contains&quot;:[&quot;properties.Materials and
   * Finishes.Structural Material&quot;,&quot;Concrete Situ&quot;]&#x60;&#x60;,
   * the request returns the properties of all objects whose
   * &#x60;&#x60;properties.Materials and Finishes.Structural Material&#x60;&#x60;
   * property contains the words &#x60;&#x60;Concrete&#x60;&#x60; and
   * &#x60;&#x60;Situ&#x60;&#x60;. You can specify up to 50 words.
   * 
   * @return $contains
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects where the value of the specified property contains the words specified in a string.  The first element of the array contains the name of the property. The second element contains a string containing the words to match. The array can only be two elements long.  For example, if you specify an array as: ``\"$contains\":[\"properties.Materials and Finishes.Structural Material\",\"Concrete Situ\"]``, the request returns the properties of all objects whose ``properties.Materials and Finishes.Structural Material`` property contains the words  ``Concrete`` and ``Situ``. You can specify up to 50 words.")
  @JsonProperty(JSON_PROPERTY_$_CONTAINS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> get$Contains() {
    return $contains;
  }

  @JsonProperty(JSON_PROPERTY_$_CONTAINS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$Contains(List<String> $contains) {
    this.$contains = $contains;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contains contains = (Contains) o;
    return Objects.equals(this.$contains, contains.$contains);
  }

  @Override
  public int hashCode() {
    return Objects.hash($contains);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contains {\n");
    sb.append("    $contains: ").append(toIndentedString($contains)).append("\n");
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
