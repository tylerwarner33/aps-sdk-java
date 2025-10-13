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
 * Represents the successful response of a Fetch Derivative Download operation.
 */
@Schema(description = "Represents the successful response of a Fetch Derivative Download operation.")
@JsonPropertyOrder({
    DerivativeDownload.JSON_PROPERTY_ETAG,
    DerivativeDownload.JSON_PROPERTY_SIZE,
    DerivativeDownload.JSON_PROPERTY_URL,
    DerivativeDownload.JSON_PROPERTY_CONTENT_TYPE,
    DerivativeDownload.JSON_PROPERTY_EXPIRATION
})
@JsonTypeName("DerivativeDownload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class DerivativeDownload {
  public static final String JSON_PROPERTY_ETAG = "etag";
  private String etag;

  public static final String JSON_PROPERTY_SIZE = "size";
  private BigDecimal size;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_CONTENT_TYPE = "content-type";
  private String contentType;

  public static final String JSON_PROPERTY_EXPIRATION = "expiration";
  private BigDecimal expiration;

  public DerivativeDownload etag(String etag) {

    this.etag = etag;
    return this;
  }

  /**
   * The calculated ETag hash of the derivative/file, if available.
   * 
   * @return etag
   **/
  @javax.annotation.Nullable
  @Schema(description = "The calculated ETag hash of the derivative/file, if available.")
  @JsonProperty(JSON_PROPERTY_ETAG)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getEtag() {
    return etag;
  }

  @JsonProperty(JSON_PROPERTY_ETAG)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setEtag(String etag) {
    this.etag = etag;
  }

  public DerivativeDownload size(BigDecimal size) {

    this.size = size;
    return this;
  }

  /**
   * The size of the derivative/file, in bytes.
   * 
   * @return size
   **/
  @javax.annotation.Nullable
  @Schema(description = "The size of the derivative/file, in bytes.")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public BigDecimal getSize() {
    return size;
  }

  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSize(BigDecimal size) {
    this.size = size;
  }

  public DerivativeDownload url(String url) {

    this.url = url;
    return this;
  }

  /**
   * The download URL.
   * 
   * @return url
   **/
  @javax.annotation.Nullable
  @Schema(description = "The download URL.")
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUrl() {
    return url;
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUrl(String url) {
    this.url = url;
  }

  public DerivativeDownload contentType(String contentType) {

    this.contentType = contentType;
    return this;
  }

  /**
   * The content type of the derivative/file.
   * 
   * @return contentType
   **/
  @javax.annotation.Nullable
  @Schema(description = "The content type of the derivative/file.")
  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getContentType() {
    return contentType;
  }

  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public DerivativeDownload expiration(BigDecimal expiration) {

    this.expiration = expiration;
    return this;
  }

  /**
   * The 13-digit epoch time stamp indicating the time the signed cookies expire.
   * 
   * @return expiration
   **/
  @javax.annotation.Nullable
  @Schema(description = "The 13-digit epoch time stamp indicating the time the signed cookies expire.")
  @JsonProperty(JSON_PROPERTY_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public BigDecimal getExpiration() {
    return expiration;
  }

  @JsonProperty(JSON_PROPERTY_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExpiration(BigDecimal expiration) {
    this.expiration = expiration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DerivativeDownload derivativeDownload = (DerivativeDownload) o;
    return Objects.equals(this.etag, derivativeDownload.etag) &&
        Objects.equals(this.size, derivativeDownload.size) &&
        Objects.equals(this.url, derivativeDownload.url) &&
        Objects.equals(this.contentType, derivativeDownload.contentType) &&
        Objects.equals(this.expiration, derivativeDownload.expiration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(etag, size, url, contentType, expiration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DerivativeDownload {\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
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
