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
 * Describes a query for retrieving objects with names that start with a
 * specified string.
 */
@Schema(description = "Describes a query for retrieving objects with names that start with a specified string.")
@JsonPropertyOrder({
    BeginsWith.JSON_PROPERTY_$_PREFIX
})
@JsonTypeName("BeginsWith")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BeginsWith implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_PREFIX = "$prefix";
  private List<String> $prefix = null;

  public BeginsWith $prefix(List<String> $prefix) {

    this.$prefix = $prefix;
    return this;
  }

  public BeginsWith add$prefixItem(String $prefixItem) {
    if (this.$prefix == null) {
      this.$prefix = new ArrayList<>();
    }
    this.$prefix.add($prefixItem);
    return this;
  }

  /**
   * Returns only the objects with their &#x60;&#x60;name&#x60;&#x60; attribute
   * beginning with the specified string.
   * 
   * The first element of the array contains the name of the attribute to match
   * (&#x60;&#x60;name&#x60;&#x60;). The second element contains the string to
   * match. The array can have only two elements. Only the objects whose name
   * begin with the specified string are returned.
   * 
   * @return $prefix
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects with their ``name`` attribute beginning with the specified string.  The first element of the array contains the name of the attribute to match (``name``). The second element contains the string to match. The array can have only two elements. Only the objects whose name begin with the specified string are returned. ")
  @JsonProperty(JSON_PROPERTY_$_PREFIX)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> get$Prefix() {
    return $prefix;
  }

  @JsonProperty(JSON_PROPERTY_$_PREFIX)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$Prefix(List<String> $prefix) {
    this.$prefix = $prefix;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeginsWith beginsWith = (BeginsWith) o;
    return Objects.equals(this.$prefix, beginsWith.$prefix);
  }

  @Override
  public int hashCode() {
    return Objects.hash($prefix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeginsWith {\n");
    sb.append("    $prefix: ").append(toIndentedString($prefix)).append("\n");
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
