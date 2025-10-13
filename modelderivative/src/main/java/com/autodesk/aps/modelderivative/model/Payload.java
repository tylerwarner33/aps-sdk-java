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
 * Specifies the format for numeric values in the response body. Possible
 * values: - &#x60;&#x60;text&#x60;&#x60; - (Default) Returns all properties
 * requested in &#x60;&#x60;fields&#x60;&#x60; without applying any special
 * formatting. - &#x60;&#x60;unit&#x60;&#x60; - Applies a filter and returns
 * only the properties that contain numerical values. Additionally, it formats
 * property values as
 * &#x60;&#x60;##&lt;VALUE_OF_PROPERTY&gt;&lt;UNIT_OF_VALUE&gt;&lt;PRECISION&gt;&lt;SYSTEM_UNIT&gt;&#x60;&#x60;.
 * For example &#x60;&#x60;##94.172{mm}[3]{m}&#x60;&#x60;, where
 * &#x60;&#x60;94.172&#x60;&#x60; is the value of the property,
 * &#x60;&#x60;{mm}&#x60;&#x60; is the unit of the value,
 * &#x60;&#x60;[3]&#x60;&#x60; is the precision, and &#x60;&#x60;{m}&#x60;&#x60;
 * is the metric base unit for the measurement.
 */
public enum Payload {

  TEXT("text"),

  UNIT("unit");

  private String value;

  Payload(String value) {
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
  public static Payload fromValue(String value) {
    for (Payload b : Payload.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
