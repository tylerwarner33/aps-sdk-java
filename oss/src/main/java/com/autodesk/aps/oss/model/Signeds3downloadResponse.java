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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * An object representing the response payload on successful execution of a
 * Generate Signed S3 Download URL operation.
 */
@Schema(description = "An object representing the response payload on successful execution of a Generate Signed S3 Download URL operation.")
@JsonPropertyOrder({
    Signeds3downloadResponse.JSON_PROPERTY_STATUS,
    Signeds3downloadResponse.JSON_PROPERTY_URL,
    Signeds3downloadResponse.JSON_PROPERTY_URLS,
    Signeds3downloadResponse.JSON_PROPERTY_PARAMS,
    Signeds3downloadResponse.JSON_PROPERTY_SIZE,
    Signeds3downloadResponse.JSON_PROPERTY_SHA1
})
@JsonTypeName("signeds3download_response")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Signeds3downloadResponse {
  public static final String JSON_PROPERTY_STATUS = "status";
  private DownloadStatus status;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_URLS = "urls";
  private Object urls;

  public static final String JSON_PROPERTY_PARAMS = "params";
  private Object params;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_SHA1 = "sha1";
  private String sha1;

  public Signeds3downloadResponse status(DownloadStatus status) {

    this.status = status;
    return this;
  }

  /**
   * Get status
   * 
   * @return status
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DownloadStatus getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(DownloadStatus status) {
    this.status = status;
  }

  public Signeds3downloadResponse url(String url) {

    this.url = url;
    return this;
  }

  /**
   * A S3 signed URL with which to download the object. This attribute is returned
   * when &#x60;&#x60;status&#x60;&#x60; is &#x60;&#x60;complete&#x60;&#x60; or
   * &#x60;&#x60;fallback&#x60;&#x60;; in the latter case, this will return an OSS
   * signed URL, not an S3 signed URL.
   * 
   * @return url
   **/
  @javax.annotation.Nullable
  @Schema(description = "A S3 signed URL with which to download the object. This attribute is returned when ``status`` is ``complete`` or ``fallback``; in the latter case, this will return an OSS signed URL, not an S3 signed URL.")
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

  public Signeds3downloadResponse urls(Object urls) {

    this.urls = urls;
    return this;
  }

  /**
   * A map of S3 signed URLs, one for each chunk of an unmerged resumable upload.
   * This attribute is returned when &#x60;&#x60;status&#x60;&#x60; is
   * &#x60;&#x60;chunked&#x60;&#x60;. The key of each entry is the byte range of
   * the total file which the chunk comprises.
   * 
   * @return urls
   **/
  @javax.annotation.Nullable
  @Schema(description = "A map of S3 signed URLs, one for each chunk of an unmerged resumable upload. This attribute is returned when ``status`` is ``chunked``. The key of each entry is the byte range of the total file which the chunk comprises.")
  @JsonProperty(JSON_PROPERTY_URLS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getUrls() {
    return urls;
  }

  @JsonProperty(JSON_PROPERTY_URLS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUrls(Object urls) {
    this.urls = urls;
  }

  public Signeds3downloadResponse params(Object params) {

    this.params = params;
    return this;
  }

  /**
   * The values that were requested for the following parameters when requesting
   * the S3 signed URL.
   * 
   * - &#x60;&#x60;Content-Type&#x60;&#x60;
   * - &#x60;&#x60;Content-Disposition&#x60;&#x60;
   * - &#x60;&#x60;Cache-Control&#x60;&#x60;.
   * 
   * @return params
   **/
  @Schema(required = true, description = "The values that were requested for the following parameters when requesting the S3 signed URL.  - ``Content-Type`` - ``Content-Disposition`` - ``Cache-Control``. ")
  @JsonProperty(JSON_PROPERTY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getParams() {
    return params;
  }

  @JsonProperty(JSON_PROPERTY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setParams(Object params) {
    this.params = params;
  }

  public Signeds3downloadResponse size(Long size) {

    this.size = size;
    return this;
  }

  /**
   * The total amount of storage space occupied by the object, in bytes.
   * 
   * @return size
   **/
  @Schema(required = true, description = "The total amount of storage space occupied by the object, in bytes.")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getSize() {
    return size;
  }

  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSize(Long size) {
    this.size = size;
  }

  public Signeds3downloadResponse sha1(String sha1) {

    this.sha1 = sha1;
    return this;
  }

  /**
   * A hash value computed from the data of the object, if available.
   * 
   * @return sha1
   **/
  @javax.annotation.Nullable
  @Schema(description = "A hash value computed from the data of the object, if available.")
  @JsonProperty(JSON_PROPERTY_SHA1)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getSha1() {
    return sha1;
  }

  @JsonProperty(JSON_PROPERTY_SHA1)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSha1(String sha1) {
    this.sha1 = sha1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Signeds3downloadResponse signeds3downloadResponse = (Signeds3downloadResponse) o;
    return Objects.equals(this.status, signeds3downloadResponse.status) &&
        Objects.equals(this.url, signeds3downloadResponse.url) &&
        Objects.equals(this.urls, signeds3downloadResponse.urls) &&
        Objects.equals(this.params, signeds3downloadResponse.params) &&
        Objects.equals(this.size, signeds3downloadResponse.size) &&
        Objects.equals(this.sha1, signeds3downloadResponse.sha1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, url, urls, params, size, sha1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Signeds3downloadResponse {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
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
