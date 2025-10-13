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
import com.autodesk.aps.oss.model.Batchsigneds3uploadResponseResultsValue;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * The response to a Batch Generate Signed S3 Upload URLs operation.
 */
@Schema(description = "The response to a Batch Generate Signed S3 Upload URLs operation.")
@JsonPropertyOrder({
  Batchsigneds3uploadResponse.JSON_PROPERTY_RESULTS
})
@JsonTypeName("batchsigneds3upload_response")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Batchsigneds3uploadResponse {
  public static final String JSON_PROPERTY_RESULTS = "results";
  private Map<String, Batchsigneds3uploadResponseResultsValue> results = new HashMap<>();


  public Batchsigneds3uploadResponse results(Map<String, Batchsigneds3uploadResponseResultsValue> results) {
    
    this.results = results;
    return this;
  }

  public Batchsigneds3uploadResponse putresultsItem(String key, Batchsigneds3uploadResponseResultsValue resultsItem) {
    this.results.put(key, resultsItem);
    return this;
  }

   /**
   * A map of the returned results; each key in the map corresponds to an object key in the batch, and the value includes the results for that object.
   * @return results
  **/
  @Schema(required = true, description = "A map of the returned results; each key in the map corresponds to an object key in the batch, and the value includes the results for that object.")
  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Map<String, Batchsigneds3uploadResponseResultsValue> getResults() {
    return results;
  }


  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResults(Map<String, Batchsigneds3uploadResponseResultsValue> results) {
    this.results = results;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Batchsigneds3uploadResponse batchsigneds3uploadResponse = (Batchsigneds3uploadResponse) o;
    return Objects.equals(this.results, batchsigneds3uploadResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Batchsigneds3uploadResponse {\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

