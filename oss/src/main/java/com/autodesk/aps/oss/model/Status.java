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
 * Indicates whether this particular part uploaded to S3 is valid. Possible
 * values are: - &#x60;&#x60;Pending&#x60;&#x60; - No such part was uploaded to
 * S3 for this index. - &#x60;&#x60;Unexpected&#x60;&#x60; - The eTag of the
 * part in S3 does not match the one provided in the request. -
 * &#x60;&#x60;TooSmall&#x60;&#x60; - A chunk uploaded to S3 is smaller than
 * 5MB. Only the final chunk can be smaller than 5MB. -
 * &#x60;&#x60;Unexpected+TooSmall&#x60;&#x60; - The chunk is both too small and
 * has an eTag mismatch. - &#x60;&#x60;Ok&#x60;&#x60; - The chunk has no
 * issues.&#39;
 */
public enum Status {

  PENDING("Pending"),

  UNEXPECTED("Unexpected"),

  TOOSMALL("TooSmall"),

  UNEXPECTED_TOOSMALL("Unexpected+TooSmall"),

  OK("Ok");

  private String value;

  Status(String value) {
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
  public static Status fromValue(String value) {
    for (Status b : Status.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
