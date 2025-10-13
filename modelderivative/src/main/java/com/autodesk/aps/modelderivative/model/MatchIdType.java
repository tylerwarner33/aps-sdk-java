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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The first element of the array contains the name of the attribute to match
 * (&#x60;objectid&#x60; or &#x60;externalId&#x60;). Subsequent elements contain
 * the values to match. For example, if you specify an array as:
 * &#x60;\&quot;$in\&quot;:[\&quot;objectid\&quot;,1,2]&#x60;, the request will
 * only return the properties of the objects with &#x60;objectid&#x60; &#x3D;
 * &#x60;1&#x60; and &#x60;2&#x60;. If you specify an array as
 * &#x60;\&quot;$in\&quot;:[\&quot;externalId\&quot;,\&quot;doc_982afc8a\&quot;,\&quot;doc_afd75233\&quot;
 * ]&#x60; the request will only return the properties of the objects with
 * &#x60;externalId&#x60; &#x3D; &#x60;doc_982afc8a&#x60; and
 * &#x60;doc_afd75233&#x60;.
 */
public enum MatchIdType {

  OBJECTID("objectid"),

  EXTERNALID("externalId");

  private String value;

  MatchIdType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MatchIdType fromValue(String value) {
    for (MatchIdType b : MatchIdType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
