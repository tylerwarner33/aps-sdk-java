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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * Batchsigneds3downloadObjectRequests
 */
@JsonPropertyOrder({
  Batchsigneds3downloadObjectRequests.JSON_PROPERTY_OBJECT_KEY,
  Batchsigneds3downloadObjectRequests.JSON_PROPERTY_RESPONSE_CONTENT_TYPE,
  Batchsigneds3downloadObjectRequests.JSON_PROPERTY_RESPONSE_CONTENT_DISPOSITION,
  Batchsigneds3downloadObjectRequests.JSON_PROPERTY_RESPONSE_CACHE_CONTROL,
  Batchsigneds3downloadObjectRequests.JSON_PROPERTY_IF_NONE_MATCH,
  Batchsigneds3downloadObjectRequests.JSON_PROPERTY_IF_MODIFIED_SINCE
})
@JsonTypeName("batchsigneds3download_object_requests")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Batchsigneds3downloadObjectRequests {
  public static final String JSON_PROPERTY_OBJECT_KEY = "objectKey";
  private String objectKey;

  public static final String JSON_PROPERTY_RESPONSE_CONTENT_TYPE = "response-content-type";
  private String responseContentType;

  public static final String JSON_PROPERTY_RESPONSE_CONTENT_DISPOSITION = "response-content-disposition";
  private String responseContentDisposition;

  public static final String JSON_PROPERTY_RESPONSE_CACHE_CONTROL = "response-cache-control";
  private String responseCacheControl;

  public static final String JSON_PROPERTY_IF_NONE_MATCH = "If-None-Match";
  private String ifNoneMatch;

  public static final String JSON_PROPERTY_IF_MODIFIED_SINCE = "If-Modified-Since";
  private String ifModifiedSince;


  public Batchsigneds3downloadObjectRequests objectKey(String objectKey) {
    
    this.objectKey = objectKey;
    return this;
  }

   /**
   * The URL-encoded human friendly name of the object to download.
   * @return objectKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "The URL-encoded human friendly name of the object to download.")
  @JsonProperty(JSON_PROPERTY_OBJECT_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getObjectKey() {
    return objectKey;
  }


  @JsonProperty(JSON_PROPERTY_OBJECT_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }


  public Batchsigneds3downloadObjectRequests responseContentType(String responseContentType) {
    
    this.responseContentType = responseContentType;
    return this;
  }

   /**
   * The value of the Content-Type header you want to receive when you download the object using the signed URL. If you do not specify a value, the Content-Type header defaults to the value stored with OSS.
   * @return responseContentType
  **/
  @javax.annotation.Nullable
  @Schema(description = "The value of the Content-Type header you want to receive when you download the object using the signed URL. If you do not specify a value, the Content-Type header defaults to the value stored with OSS.")
  @JsonProperty(JSON_PROPERTY_RESPONSE_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getResponseContentType() {
    return responseContentType;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSE_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResponseContentType(String responseContentType) {
    this.responseContentType = responseContentType;
  }


  public Batchsigneds3downloadObjectRequests responseContentDisposition(String responseContentDisposition) {
    
    this.responseContentDisposition = responseContentDisposition;
    return this;
  }

   /**
   * The value of the Content-Disposition header you want to receive when you download the object using the signed URL. If you do not specify a value, the Content-Disposition header defaults to the value stored with OSS.
   * @return responseContentDisposition
  **/
  @javax.annotation.Nullable
  @Schema(description = "The value of the Content-Disposition header you want to receive when you download the object using the signed URL. If you do not specify a value, the Content-Disposition header defaults to the value stored with OSS.")
  @JsonProperty(JSON_PROPERTY_RESPONSE_CONTENT_DISPOSITION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getResponseContentDisposition() {
    return responseContentDisposition;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSE_CONTENT_DISPOSITION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResponseContentDisposition(String responseContentDisposition) {
    this.responseContentDisposition = responseContentDisposition;
  }


  public Batchsigneds3downloadObjectRequests responseCacheControl(String responseCacheControl) {
    
    this.responseCacheControl = responseCacheControl;
    return this;
  }

   /**
   * The value of the Cache-Control header you want to receive when you download the object using the signed URL. If you do not specify a value, the Cache-Control header defaults to the value stored with OSS.
   * @return responseCacheControl
  **/
  @javax.annotation.Nullable
  @Schema(description = "The value of the Cache-Control header you want to receive when you download the object using the signed URL. If you do not specify a value, the Cache-Control header defaults to the value stored with OSS.")
  @JsonProperty(JSON_PROPERTY_RESPONSE_CACHE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getResponseCacheControl() {
    return responseCacheControl;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSE_CACHE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResponseCacheControl(String responseCacheControl) {
    this.responseCacheControl = responseCacheControl;
  }


  public Batchsigneds3downloadObjectRequests ifNoneMatch(String ifNoneMatch) {
    
    this.ifNoneMatch = ifNoneMatch;
    return this;
  }

   /**
   * The last known ETag value of the object. OSS returns the signed URL only if the &#x60;&#x60;If-None-Match&#x60;&#x60; header differs from the ETag value of the object on S3. If not, it returns a 304 &quot;Not Modified&quot; HTTP status.
   * @return ifNoneMatch
  **/
  @javax.annotation.Nullable
  @Schema(description = "The last known ETag value of the object. OSS returns the signed URL only if the ``If-None-Match`` header differs from the ETag value of the object on S3. If not, it returns a 304 \"Not Modified\" HTTP status.")
  @JsonProperty(JSON_PROPERTY_IF_NONE_MATCH)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIfNoneMatch() {
    return ifNoneMatch;
  }


  @JsonProperty(JSON_PROPERTY_IF_NONE_MATCH)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIfNoneMatch(String ifNoneMatch) {
    this.ifNoneMatch = ifNoneMatch;
  }


  public Batchsigneds3downloadObjectRequests ifModifiedSince(String ifModifiedSince) {
    
    this.ifModifiedSince = ifModifiedSince;
    return this;
  }

   /**
   * A timestamp in the HTTP date format (Mon, DD Month YYYY HH:MM:SS GMT). A signed URL is returned only if the object has been modified since the specified timestamp. If not, a 304 (Not Modified) HTTP status is returned.
   * @return ifModifiedSince
  **/
  @javax.annotation.Nullable
  @Schema(description = "A timestamp in the HTTP date format (Mon, DD Month YYYY HH:MM:SS GMT). A signed URL is returned only if the object has been modified since the specified timestamp. If not, a 304 (Not Modified) HTTP status is returned.")
  @JsonProperty(JSON_PROPERTY_IF_MODIFIED_SINCE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIfModifiedSince() {
    return ifModifiedSince;
  }


  @JsonProperty(JSON_PROPERTY_IF_MODIFIED_SINCE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIfModifiedSince(String ifModifiedSince) {
    this.ifModifiedSince = ifModifiedSince;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Batchsigneds3downloadObjectRequests batchsigneds3downloadObjectRequests = (Batchsigneds3downloadObjectRequests) o;
    return Objects.equals(this.objectKey, batchsigneds3downloadObjectRequests.objectKey) &&
        Objects.equals(this.responseContentType, batchsigneds3downloadObjectRequests.responseContentType) &&
        Objects.equals(this.responseContentDisposition, batchsigneds3downloadObjectRequests.responseContentDisposition) &&
        Objects.equals(this.responseCacheControl, batchsigneds3downloadObjectRequests.responseCacheControl) &&
        Objects.equals(this.ifNoneMatch, batchsigneds3downloadObjectRequests.ifNoneMatch) &&
        Objects.equals(this.ifModifiedSince, batchsigneds3downloadObjectRequests.ifModifiedSince);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectKey, responseContentType, responseContentDisposition, responseCacheControl, ifNoneMatch, ifModifiedSince);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Batchsigneds3downloadObjectRequests {\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    responseContentType: ").append(toIndentedString(responseContentType)).append("\n");
    sb.append("    responseContentDisposition: ").append(toIndentedString(responseContentDisposition)).append("\n");
    sb.append("    responseCacheControl: ").append(toIndentedString(responseCacheControl)).append("\n");
    sb.append("    ifNoneMatch: ").append(toIndentedString(ifNoneMatch)).append("\n");
    sb.append("    ifModifiedSince: ").append(toIndentedString(ifModifiedSince)).append("\n");
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

