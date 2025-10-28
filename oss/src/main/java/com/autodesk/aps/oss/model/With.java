/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * oss
 * The Object Storage Service (OSS) allows your application to download and upload raw files (such as PDF, XLS, DWG, or RVT) that are managed by the Data service.
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

package com.autodesk.aps.oss.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * **Not applicable for Head operation** The optional information you can
 * request for. To request more than one of the following, specify this
 * parameter multiple times in the request. Possible values: -
 * &#x60;&#x60;createdDate&#x60;&#x60; -
 * &#x60;&#x60;lastAccessedDate&#x60;&#x60; -
 * &#x60;&#x60;lastModifiedDate&#x60;&#x60; -
 * &#x60;&#x60;userDefinedMetadata&#x60;&#x60;
 */
public enum With {

  CREATEDDATE("createdDate"),

  LASTACCESSEDDATE("lastAccessedDate"),

  LASTMODIFIEDDATE("lastModifiedDate"),

  USERDEFINEDMETADATA("userDefinedMetadata");

  private String value;

  With(String value) {
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
  public static With fromValue(String value) {
    for (With b : With.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
