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
 * The request payload for a Complete Upload to S3 Signed URL operation.
 */
@Schema(description = "The request payload for a Complete Upload to S3 Signed URL operation.")
@JsonPropertyOrder({
  Completes3uploadBody.JSON_PROPERTY_UPLOAD_KEY,
  Completes3uploadBody.JSON_PROPERTY_SIZE,
  Completes3uploadBody.JSON_PROPERTY_E_TAGS
})
@JsonTypeName("completes3upload_body")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Completes3uploadBody {
  public static final String JSON_PROPERTY_UPLOAD_KEY = "uploadKey";
  private String uploadKey;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_E_TAGS = "eTags";
  private List<String> eTags = null;


  public Completes3uploadBody uploadKey(String uploadKey) {
    
    this.uploadKey = uploadKey;
    return this;
  }

   /**
   * The ID uniquely identifying the upload session that was returned when you called [Get S3 Signed Upload URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/).
   * @return uploadKey
  **/
  @Schema(required = true, description = "The ID uniquely identifying the upload session that was returned when you called [Get S3 Signed Upload URL](/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectKey-signeds3upload-POST/).")
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


  public Completes3uploadBody size(Long size) {
    
    this.size = size;
    return this;
  }

   /**
   * The expected size of the object. If provided, OSS will check this against the object in S3 and return an error if the size does not match.
   * @return size
  **/
  @javax.annotation.Nullable
  @Schema(description = "The expected size of the object. If provided, OSS will check this against the object in S3 and return an error if the size does not match.")
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


  public Completes3uploadBody eTags(List<String> eTags) {
    
    this.eTags = eTags;
    return this;
  }

  public Completes3uploadBody addeTagsItem(String eTagsItem) {
    if (this.eTags == null) {
      this.eTags = new ArrayList<>();
    }
    this.eTags.add(eTagsItem);
    return this;
  }

   /**
   * An array of eTags. S3 returns an eTag to each upload request, be it for a chunk or an entire file. For a single-part upload, this array contains the expected eTag of the entire object. For a multipart upload, this array contains the expected eTag of each part of the upload; the index of an eTag in the array corresponds to its part number in the upload. If provided, OSS will validate these eTags against the content in S3, and return an error if the eTags do not match.
   * @return eTags
  **/
  @javax.annotation.Nullable
  @Schema(description = "An array of eTags. S3 returns an eTag to each upload request, be it for a chunk or an entire file. For a single-part upload, this array contains the expected eTag of the entire object. For a multipart upload, this array contains the expected eTag of each part of the upload; the index of an eTag in the array corresponds to its part number in the upload. If provided, OSS will validate these eTags against the content in S3, and return an error if the eTags do not match.")
  @JsonProperty(JSON_PROPERTY_E_TAGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> geteTags() {
    return eTags;
  }


  @JsonProperty(JSON_PROPERTY_E_TAGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void seteTags(List<String> eTags) {
    this.eTags = eTags;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Completes3uploadBody completes3uploadBody = (Completes3uploadBody) o;
    return Objects.equals(this.uploadKey, completes3uploadBody.uploadKey) &&
        Objects.equals(this.size, completes3uploadBody.size) &&
        Objects.equals(this.eTags, completes3uploadBody.eTags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uploadKey, size, eTags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Completes3uploadBody {\n");
    sb.append("    uploadKey: ").append(toIndentedString(uploadKey)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    eTags: ").append(toIndentedString(eTags)).append("\n");
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

