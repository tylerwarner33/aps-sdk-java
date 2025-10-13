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
 * Specifies how openings are translated. Applicable only when the source design
 * is of type IFC. Possible values are: - &#x60;&#x60;hide&#x60;&#x60; -
 * (Default) Openings are translated but are not visible by default. -
 * &#x60;&#x60;show&#x60;&#x60; - Openings are translated and are visible by
 * default. - &#x60;&#x60;skip&#x60;&#x60; - Openings are not translated.
 * **Note:** These options are applicable only when conversionMethod is set to
 * &#x60;&#x60;modern&#x60;&#x60; or &#x60;&#x60;v3&#x60;&#x60;.
 */
public enum OpeningElements {

  HIDE("hide"),

  SHOW("show"),

  SKIP("skip");

  private String value;

  OpeningElements(String value) {
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
  public static OpeningElements fromValue(String value) {
    for (OpeningElements b : OpeningElements.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
