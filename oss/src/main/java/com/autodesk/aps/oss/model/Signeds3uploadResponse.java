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
 * The response payload to a Generate Signed S3 Upload URL operation.
 */
@Schema(description = "The response payload to a Generate Signed S3 Upload URL operation.")
@JsonPropertyOrder({
    Signeds3uploadResponse.JSON_PROPERTY_UPLOAD_KEY,
    Signeds3uploadResponse.JSON_PROPERTY_URLS,
    Signeds3uploadResponse.JSON_PROPERTY_URL_EXPIRATION,
    Signeds3uploadResponse.JSON_PROPERTY_UPLOAD_EXPIRATION
})
@JsonTypeName("signeds3upload_response")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Signeds3uploadResponse {
  public static final String JSON_PROPERTY_UPLOAD_KEY = "uploadKey";
  private String uploadKey;

  public static final String JSON_PROPERTY_URLS = "urls";
  private List<String> urls = new ArrayList<>();

  public static final String JSON_PROPERTY_URL_EXPIRATION = "urlExpiration";
  private String urlExpiration;

  public static final String JSON_PROPERTY_UPLOAD_EXPIRATION = "uploadExpiration";
  private String uploadExpiration;

  public Signeds3uploadResponse uploadKey(String uploadKey) {

    this.uploadKey = uploadKey;
    return this;
  }

  /**
   * An ID that uniquely identifies the upload session. It allows OSS to
   * differentiate between fresh upload attempts from attempts to resume uploading
   * data for an active upload session, in case of network interruptions. You must
   * provide this value when:
   * 
   * - Re-requesting chunk URLs for an active upload session.
   * - When calling the [Complete Upload to S3 Signed
   * URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/)
   * operation to end an active upload session.
   * 
   * @return uploadKey
   **/
  @Schema(required = true, description = "An ID that uniquely identifies the upload session. It allows OSS to differentiate between fresh upload attempts from attempts to resume uploading data for an active upload session, in case of network interruptions. You must provide this value when:  - Re-requesting chunk URLs for an active upload session.  - When calling the [Complete Upload to S3 Signed URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/) operation to end an active upload session. ")
  @JsonProperty(JSON_PROPERTY_UPLOAD_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUploadKey() {
    return uploadKey;
  }

  @JsonProperty(JSON_PROPERTY_UPLOAD_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUploadKey(String uploadKey) {
    this.uploadKey = uploadKey;
  }

  public Signeds3uploadResponse urls(List<String> urls) {

    this.urls = urls;
    return this;
  }

  public Signeds3uploadResponse addurlsItem(String urlsItem) {
    this.urls.add(urlsItem);
    return this;
  }

  /**
   * An array of signed URLs. For a single-part upload, this will contain only one
   * URL. For a multipart upload, there will be one for each chunk of a multipart
   * upload; the index of the URL in the array corresponds to the part number of
   * the chunk.
   * 
   * @return urls
   **/
  @Schema(required = true, description = "An array of signed URLs. For a single-part upload, this will contain only one URL. For a multipart upload, there will be one for each chunk of a multipart upload; the index of the URL in the array corresponds to the part number of the chunk.")
  @JsonProperty(JSON_PROPERTY_URLS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getUrls() {
    return urls;
  }

  @JsonProperty(JSON_PROPERTY_URLS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrls(List<String> urls) {
    this.urls = urls;
  }

  public Signeds3uploadResponse urlExpiration(String urlExpiration) {

    this.urlExpiration = urlExpiration;
    return this;
  }

  /**
   * The date and time, in the ISO 8601 format, indicating when the signed URLs
   * will expire.
   * 
   * @return urlExpiration
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time, in the ISO 8601 format, indicating when the signed URLs will expire.")
  @JsonProperty(JSON_PROPERTY_URL_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUrlExpiration() {
    return urlExpiration;
  }

  @JsonProperty(JSON_PROPERTY_URL_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUrlExpiration(String urlExpiration) {
    this.urlExpiration = urlExpiration;
  }

  public Signeds3uploadResponse uploadExpiration(String uploadExpiration) {

    this.uploadExpiration = uploadExpiration;
    return this;
  }

  /**
   * The deadline to call [Complete Upload to S3 Signed
   * URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/)
   * for the object. If not completed by this time, all uploaded data for this
   * session will be discarded.
   * 
   * @return uploadExpiration
   **/
  @javax.annotation.Nullable
  @Schema(description = "The deadline to call [Complete Upload to S3 Signed URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/) for the object. If not completed by this time, all uploaded data for this session will be discarded.")
  @JsonProperty(JSON_PROPERTY_UPLOAD_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUploadExpiration() {
    return uploadExpiration;
  }

  @JsonProperty(JSON_PROPERTY_UPLOAD_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUploadExpiration(String uploadExpiration) {
    this.uploadExpiration = uploadExpiration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Signeds3uploadResponse signeds3uploadResponse = (Signeds3uploadResponse) o;
    return Objects.equals(this.uploadKey, signeds3uploadResponse.uploadKey) &&
        Objects.equals(this.urls, signeds3uploadResponse.urls) &&
        Objects.equals(this.urlExpiration, signeds3uploadResponse.urlExpiration) &&
        Objects.equals(this.uploadExpiration, signeds3uploadResponse.uploadExpiration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uploadKey, urls, urlExpiration, uploadExpiration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Signeds3uploadResponse {\n");
    sb.append("    uploadKey: ").append(toIndentedString(uploadKey)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
    sb.append("    urlExpiration: ").append(toIndentedString(urlExpiration)).append("\n");
    sb.append("    uploadExpiration: ").append(toIndentedString(uploadExpiration)).append("\n");
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
