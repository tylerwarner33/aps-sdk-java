/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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

package com.autodesk.aps.datamanagement.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A status indicating whether this version conforms to its parent folder&#39;s
 * file naming standard. Possible values: - &#x60;&#x60;NONE&#x60;&#x60;: The
 * conforming status is not applicable for the version. -
 * &#x60;&#x60;CONFORMING&#x60;&#x60;: The version conforms to its parent
 * folder&#39;s file naming standard. - &#x60;&#x60;NON_CONFORMING&#x60;&#x60;:
 * The version does not conform to its parent folder&#39;s file naming standard.
 * In the event of a &#x60;&#x60;NON_CONFORMING&#x60;&#x60; status, use the [Get
 * a
 * Folder](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-GET)
 * operation to get the file naming standards IDs that have been applied to the
 * version&#39;s parent folder. Then use the ID to call [GET
 * naming-standards](/en/docs/bim360/v1/reference/http/document-management-naming-standards-id-GET/)
 * to get the details of the file naming standard. Note that this feature is
 * only available for BIM 360 projects. To learn more about the file naming
 * standard feature, see the [BIM 360 File Naming
 * Standard](https://help.autodesk.com/view/BIM360D/ENU/?guid&#x3D;Common_Data_Environment)
 * help documentation.
 */
public enum ConformingStatus {

  NONE("NONE"),

  CONFORMING("CONFORMING"),

  NON_CONFORMING("NON_CONFORMING");

  private String value;

  ConformingStatus(String value) {
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
  public static ConformingStatus fromValue(String value) {
    for (ConformingStatus b : ConformingStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
