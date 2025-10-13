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
 * The requested output types. Possible values include &#x60;svf&#x60;,
 * &#x60;svf2&#x60;, &#x60;thumbnail&#x60;, &#x60;stl&#x60;, &#x60;step&#x60;,
 * &#x60;iges&#x60;, &#x60;obj&#x60;, &#x60;ifc&#x60; or &#x60;dwg&#x60;. For a
 * list of supported types, call [List Supported
 * Formats](/en/docs/model-derivative/v2/reference/http/formats-GET).
 */
public enum OutputType {

  SVF("svf"),

  SVF2("svf2"),

  THUMBNAIL("thumbnail"),

  STL("stl"),

  STEP("step"),

  IGES("iges"),

  OBJ("obj"),

  IFC("ifc"),

  DWG("dwg"),

  FBX("fbx");

  private String value;

  OutputType(String value) {
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
  public static OutputType fromValue(String value) {
    for (OutputType b : OutputType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
