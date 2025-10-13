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

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.autodesk.aps.oss.model.BatchcompleteuploadObjectRequests;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * The request payload for the Complete Batch Upload to S3 Signed URLs operation.
 */
@Schema(description = "The request payload for the Complete Batch Upload to S3 Signed URLs operation.")
@JsonPropertyOrder({
  BatchcompleteuploadObject.JSON_PROPERTY_REQUESTS
})
@JsonTypeName("batchcompleteupload_object")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BatchcompleteuploadObject {
  public static final String JSON_PROPERTY_REQUESTS = "requests";
  private List<BatchcompleteuploadObjectRequests> requests = new ArrayList<>();


  public BatchcompleteuploadObject requests(List<BatchcompleteuploadObjectRequests> requests) {
    
    this.requests = requests;
    return this;
  }

  public BatchcompleteuploadObject addrequestsItem(BatchcompleteuploadObjectRequests requestsItem) {
    this.requests.add(requestsItem);
    return this;
  }

   /**
   * An array of objects, each of which represents an upload to complete.
   * @return requests
  **/
  @Schema(required = true, description = "An array of objects, each of which represents an upload to complete.")
  @JsonProperty(JSON_PROPERTY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<BatchcompleteuploadObjectRequests> getRequests() {
    return requests;
  }


  @JsonProperty(JSON_PROPERTY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequests(List<BatchcompleteuploadObjectRequests> requests) {
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
    BatchcompleteuploadObject batchcompleteuploadObject = (BatchcompleteuploadObject) o;
    return Objects.equals(this.requests, batchcompleteuploadObject.requests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchcompleteuploadObject {\n");
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

