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
 * Specifies what IFC loader to use during translation. Applicable only when the
 * source design is of type IFC. Possible values are: -
 * &#x60;&#x60;legacy&#x60;&#x60; - Use IFC loader version 1, which is based on
 * the Navisworks IFC loader. - &#x60;&#x60;modern&#x60;&#x60; - Use IFC loader
 * version 2, which is based on the Revit IFC loader. -
 * &#x60;&#x60;v3&#x60;&#x60; - Use IFC loader version 3, which is based on the
 * Revit IFC loader. - &#x60;&#x60;v4&#x60;&#x60; - **(Recommended)** Use IFC
 * loader version 4, which is a native solution specifically designed for
 * Autodesk Platform Services (APS). It does not depend on Navisworks or Revit.
 */
public enum ConversionMethod {

  LEGACY("legacy"),

  MODERN("modern"),

  V3("v3"),

  V4("v4");

  private String value;

  ConversionMethod(String value) {
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
  public static ConversionMethod fromValue(String value) {
    for (ConversionMethod b : ConversionMethod.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
