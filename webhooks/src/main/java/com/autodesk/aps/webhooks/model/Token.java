/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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

package com.autodesk.aps.webhooks.model;

import java.math.BigDecimal;
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
 * Add a new Webhook secret token.
 */
@Schema(description = "Add a new Webhook secret token.")
@JsonPropertyOrder({
    Token.JSON_PROPERTY_STATUS,
    Token.JSON_PROPERTY_DETAIL
})
@JsonTypeName("Token")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Token {
  public static final String JSON_PROPERTY_STATUS = "status";
  private BigDecimal status;

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private List<String> detail = null;

  public Token status(BigDecimal status) {

    this.status = status;
    return this;
  }

  /**
   * A repetition of the HTTP status code returned in the response headers, which
   * indicates the outcome of the request.
   * 
   * @return status
   **/
  @javax.annotation.Nullable
  @Schema(description = "A repetition of the HTTP status code returned in the response headers, which indicates the outcome of the request.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public BigDecimal getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(BigDecimal status) {
    this.status = status;
  }

  public Token detail(List<String> detail) {

    this.detail = detail;
    return this;
  }

  public Token adddetailItem(String detailItem) {
    if (this.detail == null) {
      this.detail = new ArrayList<>();
    }
    this.detail.add(detailItem);
    return this;
  }

  /**
   * An array of strings, where each string is a human-readable description of the
   * request&#39;s outcome.
   * 
   * @return detail
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of strings, where each string is a human-readable description of the request's outcome.")
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getDetail() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDetail(List<String> detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.status, token.status) &&
        Objects.equals(this.detail, token.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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
