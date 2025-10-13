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
 * Specifies how to split the response into multiple pages, and return the
 * response one page at a time.
 */
@Schema(description = "Specifies how to split the response into multiple pages, and return the response one page at a time.")
@JsonPropertyOrder({
    SpecificPropertiesPayloadPagination.JSON_PROPERTY_OFFSET,
    SpecificPropertiesPayloadPagination.JSON_PROPERTY_LIMIT
})
@JsonTypeName("SpecificPropertiesPayload_pagination")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SpecificPropertiesPayloadPagination {
  public static final String JSON_PROPERTY_OFFSET = "offset";
  private BigDecimal offset;

  public static final String JSON_PROPERTY_LIMIT = "limit";
  private BigDecimal limit;

  public SpecificPropertiesPayloadPagination offset(BigDecimal offset) {

    this.offset = offset;
    return this;
  }

  /**
   * The number of properties to skip. Use this attribute with the
   * &#x60;&#x60;limit&#x60;&#x60; attribute to split the properties into multiple
   * pages. To fetch the first page, specify &#x60;&#x60;offset&#x60;&#x60;
   * &#x3D;0 (do not skip any properties). To fetch the second page, specify
   * &#x60;&#x60;offset&#x60;&#x60; &#x3D; value of &#x60;&#x60;limit&#x60;&#x60;
   * you specified for the first page. So, the server skips the properties
   * returned on the first page. In general, &#x60;&#x60;offset&#x60;&#x60; &#x3D;
   * &#x60;&#x60;previous_offset&#x60;&#x60; +
   * &#x60;&#x60;previous_limit&#x60;&#x60;. This attribute is 0 by default. The
   * minimum value is 0.
   * 
   * @return offset
   **/
  @Schema(required = true, description = "The number of properties to skip. Use this attribute with the ``limit`` attribute to split the properties into multiple pages. To fetch the first page, specify ``offset`` =0 (do not skip any properties). To fetch the second page, specify ``offset`` = value of ``limit`` you specified for the first page. So, the server skips the properties returned on the first page. In general, ``offset`` = ``previous_offset`` + ``previous_limit``. This attribute is 0 by default. The minimum value is 0.")
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

  public SpecificPropertiesPayloadPagination limit(BigDecimal limit) {

    this.limit = limit;
    return this;
  }

  /**
   * The maximum number of properties to return in a single page. Use this
   * attribute with the &#x60;&#x60;offset&#x60;&#x60; attribute to split the
   * properties into multiple pages. To fetch the first page, specify
   * &#x60;&#x60;offset&#x60;&#x60; &#x3D;0 (do not skip any properties). To fetch
   * the second page, specify &#x60;&#x60;offset&#x60;&#x60; &#x3D; value of
   * &#x60;&#x60;limit&#x60;&#x60; you specified for the first page. So, the
   * server skips the search results returned on the first page. In general,
   * &#x60;&#x60;offset&#x60;&#x60; &#x3D; &#x60;&#x60;previous_offset&#x60;&#x60;
   * + &#x60;&#x60;previous_limit&#x60;&#x60;. This attribute is 20 by default.
   * The minimum value is 1 and the maximum is 1000.
   * 
   * @return limit
   **/
  @Schema(required = true, description = "The maximum number of properties to return in a single page. Use this attribute with the ``offset`` attribute to split the properties into multiple pages. To fetch the first page, specify ``offset`` =0 (do not skip any properties). To fetch the second page, specify ``offset`` = value of ``limit`` you specified for the first page. So, the server skips the search results returned on the first page. In general, ``offset`` = ``previous_offset`` + ``previous_limit``. This attribute is 20 by default. The minimum value is 1 and the maximum is 1000.")
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPropertiesPayloadPagination specificPropertiesPayloadPagination = (SpecificPropertiesPayloadPagination) o;
    return Objects.equals(this.offset, specificPropertiesPayloadPagination.offset) &&
        Objects.equals(this.limit, specificPropertiesPayloadPagination.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPropertiesPayloadPagination {\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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
