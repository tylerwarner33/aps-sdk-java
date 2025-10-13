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
 * Specifies where the referenced files are stored. Possible values are: -
 * &#x60;&#x60;US&#x60;&#x60; - Data center for the US region. -
 * &#x60;&#x60;EMEA&#x60;&#x60; - Data center for the European Union, Middle
 * East, and Africa. - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Data center for the
 * Australia region. - &#x60;&#x60;CAN&#x60;&#x60; - Data center for the Canada
 * region. - &#x60;&#x60;DEU&#x60;&#x60; - Data center for the Germany region. -
 * &#x60;&#x60;IND&#x60;&#x60; - Data center for the India region. -
 * &#x60;&#x60;JPN&#x60;&#x60; - Data center for the Japan region. -
 * &#x60;&#x60;GBR&#x60;&#x60; - Data center for the United Kingdom region.
 */
public enum Region {

  US("US"),

  EMEA("EMEA"),

  AUS("AUS"),

  CAN("CAN"),

  DEU("DEU"),

  IND("IND"),

  JPN("JPN"),

  GBR("GBR");

  private String value;

  Region(String value) {
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
  public static Region fromValue(String value) {
    for (Region b : Region.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
