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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the request body of a Fetch Specific Properties operation.
 */
@Schema(description = "Represents the request body of a Fetch Specific Properties operation.")
@JsonPropertyOrder({
    SpecificPropertiesPayload.JSON_PROPERTY_PAGINATION,
    SpecificPropertiesPayload.JSON_PROPERTY_QUERY,
    SpecificPropertiesPayload.JSON_PROPERTY_FIELDS,
    SpecificPropertiesPayload.JSON_PROPERTY_PAYLOAD
})
@JsonTypeName("SpecificPropertiesPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SpecificPropertiesPayload {
  public static final String JSON_PROPERTY_PAGINATION = "pagination";
  private SpecificPropertiesPayloadPagination pagination;

  public static final String JSON_PROPERTY_QUERY = "query";
  private SpecificPropertiesPayloadQuery query;

  public static final String JSON_PROPERTY_FIELDS = "fields";
  private Object fields;

  public static final String JSON_PROPERTY_PAYLOAD = "payload";
  private Payload payload;

  public SpecificPropertiesPayload pagination(SpecificPropertiesPayloadPagination pagination) {

    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * 
   * @return pagination
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_PAGINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SpecificPropertiesPayloadPagination getPagination() {
    return pagination;
  }

  @JsonProperty(JSON_PROPERTY_PAGINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPagination(SpecificPropertiesPayloadPagination pagination) {
    this.pagination = pagination;
  }

  public SpecificPropertiesPayload query(SpecificPropertiesPayloadQuery query) {

    this.query = query;
    return this;
  }

  /**
   * Get query
   * 
   * @return query
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_QUERY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SpecificPropertiesPayloadQuery getQuery() {
    return query;
  }

  @JsonProperty(JSON_PROPERTY_QUERY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setQuery(SpecificPropertiesPayloadQuery query) {
    this.query = query;
  }

  public SpecificPropertiesPayload fields(Object fields) {

    this.fields = fields;
    return this;
  }

  /**
   * Specifies what properties of the objects to return. If you do not specify
   * this attribute, the response returns all properties.
   * 
   * Possible values are:
   * 
   * - &#x60;&#x60;properties&#x60;&#x60; - Return all properties.
   * - &#x60;&#x60;properties.something&#x60;&#x60;- Return the property named
   * &#x60;&#x60;something&#x60;&#x60; and all its children.
   * - &#x60;&#x60;properties.some*&#x60;&#x60; - Return all properties with names
   * that begin with &#x60;&#x60;some&#x60;&#x60; and all their children.
   * - &#x60;&#x60;properties.category.*&#x60;&#x60; - Return the property named
   * &#x60;&#x60;category&#x60;&#x60; and all its children.
   * - &#x60;&#x60;properties.*.property&#x60;&#x60; - Return any property named
   * &#x60;&#x60;property&#x60;&#x60; regardless of its parent.
   * 
   * @return fields
   **/
  @Schema(required = true, description = "Specifies what properties of the objects to return. If you do not specify this attribute, the response returns all properties.  Possible values are:  - ``properties`` - Return all properties. - ``properties.something``- Return the property named ``something`` and all its children. - ``properties.some*`` - Return all properties with names that begin with ``some`` and all their children. - ``properties.category.*`` - Return the property named ``category`` and all its children. - ``properties.*.property`` - Return any property named ``property`` regardless of its parent. ")
  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getFields() {
    return fields;
  }

  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFields(Object fields) {
    this.fields = fields;
  }

  public SpecificPropertiesPayload payload(Payload payload) {

    this.payload = payload;
    return this;
  }

  /**
   * Get payload
   * 
   * @return payload
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Payload getPayload() {
    return payload;
  }

  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPayload(Payload payload) {
    this.payload = payload;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPropertiesPayload specificPropertiesPayload = (SpecificPropertiesPayload) o;
    return Objects.equals(this.pagination, specificPropertiesPayload.pagination) &&
        Objects.equals(this.query, specificPropertiesPayload.query) &&
        Objects.equals(this.fields, specificPropertiesPayload.fields) &&
        Objects.equals(this.payload, specificPropertiesPayload.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, query, fields, payload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPropertiesPayload {\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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
