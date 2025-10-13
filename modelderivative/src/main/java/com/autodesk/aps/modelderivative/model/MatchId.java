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
 * Describes a query for retrieving objects having the specified Object IDs or
 * External IDs.
 */
@Schema(description = "Describes a query for retrieving objects having the specified Object IDs or External IDs.")
@JsonPropertyOrder({
    MatchId.JSON_PROPERTY_$_IN
})
@JsonTypeName("MatchId")
@JsonIgnoreProperties(ignoreUnknown = true)

public class MatchId implements SpecificPropertiesPayloadQuery {
  public static final String JSON_PROPERTY_$_IN = "$in";
  private List<Object> $in = null;

  public MatchId $in(List<Object> $in) {

    this.$in = $in;
    return this;
  }

  public MatchId add$inItem(Object $inItem) {
    if (this.$in == null) {
      this.$in = new ArrayList<>();
    }
    this.$in.add($inItem);
    return this;
  }

  /**
   * Returns only the objects with their &#x60;&#x60;objectid&#x60;&#x60; or
   * &#x60;&#x60;externalId&#x60;&#x60; attribute exactly matching one of the
   * values specified in the array.
   * 
   * The first element of the array contains the name of the attribute to match
   * (&#x60;&#x60;objectid&#x60;&#x60; or &#x60;&#x60;externalId&#x60;&#x60;).
   * Subsequent elements contain the values to match.
   * 
   * For example, if you specify an array as:
   * &#x60;&#x60;&quot;$in&quot;:[&quot;objectid&quot;,1,2]&#x60;&#x60;, the
   * request will only return the properties of the objects with
   * &#x60;&#x60;objectid&#x60;&#x60; &#x3D; &#x60;&#x60;1&#x60;&#x60; and
   * &#x60;&#x60;2&#x60;&#x60;. If you specify an array as
   * &#x60;&#x60;&quot;$in&quot;:[&quot;externalId&quot;,&quot;doc_982afc8a&quot;,&quot;doc_afd75233&quot;
   * ]&#x60;&#x60; the request will only return the properties of the objects with
   * &#x60;&#x60;externalId&#x60;&#x60; &#x3D;
   * &#x60;&#x60;doc_982afc8a&#x60;&#x60; and
   * &#x60;&#x60;doc_afd75233&#x60;&#x60;.
   * 
   * @return $in
   **/
  @javax.annotation.Nullable
  @Schema(description = "Returns only the objects with their ``objectid`` or ``externalId`` attribute exactly matching one of the values specified in the array.  The first element of the array contains the name of the attribute to match (``objectid`` or ``externalId``). Subsequent elements contain the values to match.  For example, if you specify an array as: ``\"$in\":[\"objectid\",1,2]``, the request will only return the properties of the objects with ``objectid`` = ``1`` and ``2``. If you specify an array as ``\"$in\":[\"externalId\",\"doc_982afc8a\",\"doc_afd75233\" ]`` the request will only return the properties of the objects with ``externalId`` = ``doc_982afc8a`` and ``doc_afd75233``. ")
  @JsonProperty(JSON_PROPERTY_$_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<Object> get$In() {
    return $in;
  }

  @JsonProperty(JSON_PROPERTY_$_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set$In(List<Object> $in) {
    this.$in = $in;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchId matchId = (MatchId) o;
    return Objects.equals(this.$in, matchId.$in);
  }

  @Override
  public int hashCode() {
    return Objects.hash($in);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchId {\n");
    sb.append("    $in: ").append(toIndentedString($in)).append("\n");
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
