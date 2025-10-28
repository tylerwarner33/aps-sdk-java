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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The request payload for a Batch Generate Signed S3 Upload URLs operation.
 */
@Schema(description = "The request payload for a Batch Generate Signed S3 Upload URLs operation.")
@JsonPropertyOrder({
    Batchsigneds3uploadObject.JSON_PROPERTY_REQUESTS
})
@JsonTypeName("batchsigneds3upload_object")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Batchsigneds3uploadObject {
  public static final String JSON_PROPERTY_REQUESTS = "requests";
  private List<Batchsigneds3uploadObjectRequests> requests = new ArrayList<>();

  public Batchsigneds3uploadObject requests(List<Batchsigneds3uploadObjectRequests> requests) {

    this.requests = requests;
    return this;
  }

  public Batchsigneds3uploadObject addrequestsItem(Batchsigneds3uploadObjectRequests requestsItem) {
    this.requests.add(requestsItem);
    return this;
  }

  /**
   * An array where each element is an object containing information needed to
   * generate a signed S3 upload URL.
   * 
   * @return requests
   **/
  @Schema(required = true, description = "An array where each element is an object containing information needed to generate a signed S3 upload URL.")
  @JsonProperty(JSON_PROPERTY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Batchsigneds3uploadObjectRequests> getRequests() {
    return requests;
  }

  @JsonProperty(JSON_PROPERTY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequests(List<Batchsigneds3uploadObjectRequests> requests) {
    this.requests = requests;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Batchsigneds3uploadObject batchsigneds3uploadObject = (Batchsigneds3uploadObject) o;
    return Objects.equals(this.requests, batchsigneds3uploadObject.requests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Batchsigneds3uploadObject {\n");
    sb.append("    requests: ").append(toIndentedString(requests)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
