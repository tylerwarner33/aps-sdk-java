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
 * The units the models must be translated to, when the output type is OBJ. For
 * example, from millimeters (10, 123, 31) to centimeters (1.0, 12.3, 3.1). If
 * the source unit or the unit you are translating to is not supported, the
 * values remain unchanged. Possible values are: - &#x60;&#x60;meter&#x60;&#x60;
 * - &#x60;&#x60;decimeter&#x60;&#x60; - &#x60;&#x60;centimeter&#x60;&#x60; -
 * &#x60;&#x60;millimeter&#x60;&#x60; - &#x60;&#x60;micrometer&#x60;&#x60; -
 * &#x60;&#x60;nanometer&#x60;&#x60; - &#x60;&#x60;yard&#x60;&#x60; -
 * &#x60;&#x60;foot&#x60;&#x60; - &#x60;&#x60;inch&#x60;&#x60; -
 * &#x60;&#x60;mil&#x60;&#x60; - &#x60;&#x60;microinch&#x60;&#x60; **Note:** Not
 * supported when the source design is F3D.
 */
public enum Unit {

  METER("meter"),

  DECIMETER("decimeter"),

  CENTIMETER("centimeter"),

  MILLIMETER("millimeter"),

  MICROMETER("micrometer"),

  NANOMETER("nanometer"),

  YARD("yard"),

  FOOT("foot"),

  INCH("inch"),

  MIL("mil"),

  MICROINCH("microinch");

  private String value;

  Unit(String value) {
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
  public static Unit fromValue(String value) {
    for (Unit b : Unit.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
