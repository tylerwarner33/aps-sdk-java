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
 * The request payload for a Generate OSS Signed URL operation.
 */
@Schema(description = "The request payload for a Generate OSS Signed URL operation.")
@JsonPropertyOrder({
  CreateSignedResource.JSON_PROPERTY_MINUTES_EXPIRATION,
  CreateSignedResource.JSON_PROPERTY_SINGLE_USE
})
@JsonTypeName("create_signed_resource")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateSignedResource {
  public static final String JSON_PROPERTY_MINUTES_EXPIRATION = "minutesExpiration";
  private Integer minutesExpiration;

  public static final String JSON_PROPERTY_SINGLE_USE = "singleUse";
  private Boolean singleUse;


  public CreateSignedResource minutesExpiration(Integer minutesExpiration) {
    
    this.minutesExpiration = minutesExpiration;
    return this;
  }

   /**
   * The time window (in minutes) the signed URL will remain usable. Acceptable values &#x3D; 1-60 minutes. Default &#x3D; 2 minutes.

**Tip:** Use the smallest possible time window to minimize exposure of the signed URL.

   * @return minutesExpiration
  **/
  @javax.annotation.Nullable
  @Schema(description = "The time window (in minutes) the signed URL will remain usable. Acceptable values = 1-60 minutes. Default = 2 minutes.  **Tip:** Use the smallest possible time window to minimize exposure of the signed URL. ")
  @JsonProperty(JSON_PROPERTY_MINUTES_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getMinutesExpiration() {
    return minutesExpiration;
  }


  @JsonProperty(JSON_PROPERTY_MINUTES_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMinutesExpiration(Integer minutesExpiration) {
    this.minutesExpiration = minutesExpiration;
  }


  public CreateSignedResource singleUse(Boolean singleUse) {
    
    this.singleUse = singleUse;
    return this;
  }

   /**
   * &#x60;&#x60;true&#x60;&#x60; : The signed URL will expire immediately after use. For example, when downloading an object, URL will expire once the download is complete.

&#x60;&#x60;false&#x60;&#x60; : (Default) The signed URL will remain usable for the entire time window specified by &#x60;&#x60;minutesExpiration&#x60;&#x60;. 

   * @return singleUse
  **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` : The signed URL will expire immediately after use. For example, when downloading an object, URL will expire once the download is complete.  ``false`` : (Default) The signed URL will remain usable for the entire time window specified by ``minutesExpiration``.  ")
  @JsonProperty(JSON_PROPERTY_SINGLE_USE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getSingleUse() {
    return singleUse;
  }


  @JsonProperty(JSON_PROPERTY_SINGLE_USE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSingleUse(Boolean singleUse) {
    this.singleUse = singleUse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSignedResource createSignedResource = (CreateSignedResource) o;
    return Objects.equals(this.minutesExpiration, createSignedResource.minutesExpiration) &&
        Objects.equals(this.singleUse, createSignedResource.singleUse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minutesExpiration, singleUse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSignedResource {\n");
    sb.append("    minutesExpiration: ").append(toIndentedString(minutesExpiration)).append("\n");
    sb.append("    singleUse: ").append(toIndentedString(singleUse)).append("\n");
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

