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

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Container for the attributes that define how the response paginated.
 */
@Schema(description = "Container for the attributes that define how the response paginated.")
@JsonPropertyOrder({
    SpecificPropertiesPagination.JSON_PROPERTY_LIMIT,
    SpecificPropertiesPagination.JSON_PROPERTY_OFFSET,
    SpecificPropertiesPagination.JSON_PROPERTY_TOTAL_RESULTS
})
@JsonTypeName("SpecificProperties_pagination")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SpecificPropertiesPagination {
  public static final String JSON_PROPERTY_LIMIT = "limit";
  private BigDecimal limit;

  public static final String JSON_PROPERTY_OFFSET = "offset";
  private BigDecimal offset;

  public static final String JSON_PROPERTY_TOTAL_RESULTS = "totalResults";
  private BigDecimal totalResults;

  public SpecificPropertiesPagination limit(BigDecimal limit) {

    this.limit = limit;
    return this;
  }

  /**
   * The maximum number of properties you requested for this page.
   * 
   * @return limit
   **/
  @Schema(required = true, description = "The maximum number of properties you requested for this page.")
  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getLimit() {
    return limit;
  }

  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLimit(BigDecimal limit) {
    this.limit = limit;
  }

  public SpecificPropertiesPagination offset(BigDecimal offset) {

    this.offset = offset;
    return this;
  }

  /**
   * The number of items skipped (because they were returned in previous pages)
   * when returning this page.
   * 
   * @return offset
   **/
  @Schema(required = true, description = "The number of items skipped (because they were returned in previous pages) when returning this page.")
  @JsonProperty(JSON_PROPERTY_OFFSET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getOffset() {
    return offset;
  }

  @JsonProperty(JSON_PROPERTY_OFFSET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOffset(BigDecimal offset) {
    this.offset = offset;
  }

  public SpecificPropertiesPagination totalResults(BigDecimal totalResults) {

    this.totalResults = totalResults;
    return this;
  }

  /**
   * The total number of properties to be returned.
   * 
   * @return totalResults
   **/
  @Schema(required = true, description = "The total number of properties to be returned.")
  @JsonProperty(JSON_PROPERTY_TOTAL_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getTotalResults() {
    return totalResults;
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalResults(BigDecimal totalResults) {
    this.totalResults = totalResults;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPropertiesPagination specificPropertiesPagination = (SpecificPropertiesPagination) o;
    return Objects.equals(this.limit, specificPropertiesPagination.limit) &&
        Objects.equals(this.offset, specificPropertiesPagination.offset) &&
        Objects.equals(this.totalResults, specificPropertiesPagination.totalResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limit, offset, totalResults);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPropertiesPagination {\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
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
