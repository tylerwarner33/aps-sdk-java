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
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * Batchsigneds3uploadResponseResultsValue
 */
@JsonPropertyOrder({
  Batchsigneds3uploadResponseResultsValue.JSON_PROPERTY_REASON,
  Batchsigneds3uploadResponseResultsValue.JSON_PROPERTY_STATUS,
  Batchsigneds3uploadResponseResultsValue.JSON_PROPERTY_UPLOAD_EXPIRATION,
  Batchsigneds3uploadResponseResultsValue.JSON_PROPERTY_UPLOAD_KEY,
  Batchsigneds3uploadResponseResultsValue.JSON_PROPERTY_URL_EXPIRATION,
  Batchsigneds3uploadResponseResultsValue.JSON_PROPERTY_URLS
})
@JsonTypeName("batchsigneds3upload_response_results_value")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Batchsigneds3uploadResponseResultsValue {
  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_UPLOAD_EXPIRATION = "uploadExpiration";
  private String uploadExpiration;

  public static final String JSON_PROPERTY_UPLOAD_KEY = "uploadKey";
  private String uploadKey;

  public static final String JSON_PROPERTY_URL_EXPIRATION = "urlExpiration";
  private String urlExpiration;

  public static final String JSON_PROPERTY_URLS = "urls";
  private List<String> urls = new ArrayList<>();


  public Batchsigneds3uploadResponseResultsValue reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * Describes an error that was encountered. Returned only if the signed URL request for that object failed.
   * @return reason
  **/
  @javax.annotation.Nullable
  @Schema(description = "Describes an error that was encountered. Returned only if the signed URL request for that object failed.")
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getReason() {
    return reason;
  }


  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setReason(String reason) {
    this.reason = reason;
  }


  public Batchsigneds3uploadResponseResultsValue status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * Returned only if the signed URL request for that object failed.
   * @return status
  **/
  @javax.annotation.Nullable
  @Schema(description = "Returned only if the signed URL request for that object failed.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(String status) {
    this.status = status;
  }


  public Batchsigneds3uploadResponseResultsValue uploadExpiration(String uploadExpiration) {
    
    this.uploadExpiration = uploadExpiration;
    return this;
  }

   /**
   * The deadline to call [Complete Batch Upload to S3 Signed URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/) for the object. If not completed by this time, all uploaded data for this session will be discarded.
   * @return uploadExpiration
  **/
  @javax.annotation.Nullable
  @Schema(description = "The deadline to call [Complete Batch Upload to S3 Signed URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/) for the object. If not completed by this time, all uploaded data for this session will be discarded.")
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


  public Batchsigneds3uploadResponseResultsValue uploadKey(String uploadKey) {
    
    this.uploadKey = uploadKey;
    return this;
  }

   /**
   * An ID that uniquely identifies the upload session. It allows OSS to differentiate between fresh upload attempts from attempts to resume uploading data for an active upload session, in case of network interruptions. You must provide this value when:

- Re-requesting chunk URLs for an active upload session. 
- When calling the [Complete Batch Upload to S3 Signed URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/) operation to end an active upload session.

   * @return uploadKey
  **/
  @Schema(required = true, description = "An ID that uniquely identifies the upload session. It allows OSS to differentiate between fresh upload attempts from attempts to resume uploading data for an active upload session, in case of network interruptions. You must provide this value when:  - Re-requesting chunk URLs for an active upload session.  - When calling the [Complete Batch Upload to S3 Signed URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/) operation to end an active upload session. ")
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


  public Batchsigneds3uploadResponseResultsValue urlExpiration(String urlExpiration) {
    
    this.urlExpiration = urlExpiration;
    return this;
  }

   /**
   * The date and time, in the ISO 8601 format, indicating when the signed URLs will expire.
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


  public Batchsigneds3uploadResponseResultsValue urls(List<String> urls) {
    
    this.urls = urls;
    return this;
  }

  public Batchsigneds3uploadResponseResultsValue addurlsItem(String urlsItem) {
    this.urls.add(urlsItem);
    return this;
  }

   /**
   * An array of signed URLs. For a single-part upload, this will only include a single URL. For a multipart upload, there will be one for each chunk of a multipart upload; the index of the URL in the array corresponds to the part number of the chunk.
   * @return urls
  **/
  @Schema(required = true, description = "An array of signed URLs. For a single-part upload, this will only include a single URL. For a multipart upload, there will be one for each chunk of a multipart upload; the index of the URL in the array corresponds to the part number of the chunk.")
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Batchsigneds3uploadResponseResultsValue batchsigneds3uploadResponseResultsValue = (Batchsigneds3uploadResponseResultsValue) o;
    return Objects.equals(this.reason, batchsigneds3uploadResponseResultsValue.reason) &&
        Objects.equals(this.status, batchsigneds3uploadResponseResultsValue.status) &&
        Objects.equals(this.uploadExpiration, batchsigneds3uploadResponseResultsValue.uploadExpiration) &&
        Objects.equals(this.uploadKey, batchsigneds3uploadResponseResultsValue.uploadKey) &&
        Objects.equals(this.urlExpiration, batchsigneds3uploadResponseResultsValue.urlExpiration) &&
        Objects.equals(this.urls, batchsigneds3uploadResponseResultsValue.urls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, status, uploadExpiration, uploadKey, urlExpiration, urls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Batchsigneds3uploadResponseResultsValue {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    uploadExpiration: ").append(toIndentedString(uploadExpiration)).append("\n");
    sb.append("    uploadKey: ").append(toIndentedString(uploadKey)).append("\n");
    sb.append("    urlExpiration: ").append(toIndentedString(urlExpiration)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
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

