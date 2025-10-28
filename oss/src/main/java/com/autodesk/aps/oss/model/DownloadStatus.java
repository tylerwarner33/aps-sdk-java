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
 * Indicates the upload status of the requested object. Possible values are: -
 * &#x60;&#x60;complete&#x60;&#x60; - The upload process is finished. If the
 * object was uploaded in chunks, assembly of chunks into the final object is
 * also complete. - &#x60;&#x60;chunked&#x60;&#x60; - The object was uploaded in
 * chunks, but assembly of chunks into the final object is still pending.
 * &#x60;public-resource-fallback&#x60;&#x60; &#x3D;
 * &#x60;&#x60;false&#x60;&#x60; - &#x60;&#x60;fallback&#x60;&#x60; - The object
 * was uploaded in chunks, but assembly of chunks into the final object is still
 * pending. &#x60;public-resource-fallback&#x60;&#x60; &#x3D;
 * &#x60;&#x60;true&#x60;&#x60;
 */
public enum DownloadStatus {

  COMPLETE("complete"),

  CHUNKED("chunked"),

  FALLBACK("fallback");

  private String value;

  DownloadStatus(String value) {
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
  public static DownloadStatus fromValue(String value) {
    for (DownloadStatus b : DownloadStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
