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
 * An object that represents the response to a Batch Generate Signed S3 Download
 * URLs operation.
 ** 
 * Note**: &#x60;&#x60;objectKeyN&#x60;&#x60; is a placeholder for the first
 * object key for which the client requested a download signed URL. The
 * attributes within contain the success data / error information for the
 * request for that object. &#x60;results&#x60; will contain one such attribute
 * for each requested object in the batch.
 * 
 */
@Schema(description = "An object that represents the response to a Batch Generate Signed S3 Download URLs operation.   **Note**: ``objectKeyN`` is a placeholder for the first object key for which the client requested a download signed URL. The attributes within contain the success data / error information for the request for that object. `results` will contain one such attribute for each requested object in the batch. ")
@JsonPropertyOrder({
    DownloadResults.JSON_PROPERTY_STATUS,
    DownloadResults.JSON_PROPERTY_URL,
    DownloadResults.JSON_PROPERTY_URLS,
    DownloadResults.JSON_PROPERTY_PARAMS,
    DownloadResults.JSON_PROPERTY_SIZE,
    DownloadResults.JSON_PROPERTY_SHA1
})
@JsonTypeName("download_results")
@JsonIgnoreProperties(ignoreUnknown = true)

public class DownloadResults {
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

  public DownloadResults status(DownloadStatus status) {

    this.status = status;
    return this;
  }

  /**
   * Get status
   * 
   * @return status
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public DownloadStatus getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(DownloadStatus status) {
    this.status = status;
  }

  public DownloadResults url(String url) {

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

  public DownloadResults urls(Object urls) {

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

  public DownloadResults params(Object params) {

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
  @javax.annotation.Nullable
  @Schema(description = "The values that were requested for the following parameters when requesting the S3 signed URL.  - ``Content-Type`` - ``Content-Disposition`` - ``Cache-Control``. ")
  @JsonProperty(JSON_PROPERTY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getParams() {
    return params;
  }

  @JsonProperty(JSON_PROPERTY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setParams(Object params) {
    this.params = params;
  }

  public DownloadResults size(Long size) {

    this.size = size;
    return this;
  }

  /**
   * The total amount of storage space occupied by the object, in bytes.
   * 
   * @return size
   **/
  @javax.annotation.Nullable
  @Schema(description = "The total amount of storage space occupied by the object, in bytes.")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getSize() {
    return size;
  }

  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSize(Long size) {
    this.size = size;
  }

  public DownloadResults sha1(String sha1) {

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
    DownloadResults downloadResults = (DownloadResults) o;
    return Objects.equals(this.status, downloadResults.status) &&
        Objects.equals(this.url, downloadResults.url) &&
        Objects.equals(this.urls, downloadResults.urls) &&
        Objects.equals(this.params, downloadResults.params) &&
        Objects.equals(this.size, downloadResults.size) &&
        Objects.equals(this.sha1, downloadResults.sha1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, url, urls, params, size, sha1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadResults {\n");
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
