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
 * Specifies how the hierarchy of items are determined. Applicable only when the
 * source design is of type VUE. - &#x60;&#x60;Classic&#x60;&#x60; - (Default)
 * Uses hardcoded rules to set the hierarchy of items. -
 * &#x60;&#x60;SystemPath&#x60;&#x60; - Uses a linked XML or MDB2 properties
 * file to set hierarchy of items. You can use this option to make the
 * organization of items consistent with SmartPlant 3D. **Notes:** 1. The
 * functioning of the SystemPath depends on the default setting of the property
 * SP3D_SystemPath or System Path. 2. The pathing delimiter must be \\. 3. If
 * you want to customize further, import the VUE file to Navisworks. After that,
 * use POST job on the resulting Navisworks (nwc/nwd) file.
 */
public enum Hierarchy {

  CLASSIC("Classic"),

  SYSTEMPATH("SystemPath");

  private String value;

  Hierarchy(String value) {
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
  public static Hierarchy fromValue(String value) {
    for (Hierarchy b : Hierarchy.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
