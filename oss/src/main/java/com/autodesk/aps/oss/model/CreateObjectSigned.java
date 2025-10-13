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
 * The request payload for a Generate OSS Signed URL operation.
 */
@Schema(description = "The request payload for a Generate OSS Signed URL operation.")
@JsonPropertyOrder({
  CreateObjectSigned.JSON_PROPERTY_SIGNED_URL,
  CreateObjectSigned.JSON_PROPERTY_EXPIRATION,
  CreateObjectSigned.JSON_PROPERTY_ALLOWED_IP_ADDRESSES
})
@JsonTypeName("create_object_signed")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateObjectSigned {
  public static final String JSON_PROPERTY_SIGNED_URL = "signedUrl";
  private String signedUrl;

  public static final String JSON_PROPERTY_EXPIRATION = "expiration";
  private Long expiration;

  public static final String JSON_PROPERTY_ALLOWED_IP_ADDRESSES = "allowedIpAddresses";
  private List<String> allowedIpAddresses = null;


  public CreateObjectSigned signedUrl(String signedUrl) {
    
    this.signedUrl = signedUrl;
    return this;
  }

   /**
   * URL created for downloading the object
   * @return signedUrl
  **/
  @Schema(required = true, description = "URL created for downloading the object")
  @JsonProperty(JSON_PROPERTY_SIGNED_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSignedUrl() {
    return signedUrl;
  }


  @JsonProperty(JSON_PROPERTY_SIGNED_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignedUrl(String signedUrl) {
    this.signedUrl = signedUrl;
  }


  public CreateObjectSigned expiration(Long expiration) {
    
    this.expiration = expiration;
    return this;
  }

   /**
   * Value for expiration in minutes
   * @return expiration
  **/
  @Schema(required = true, description = "Value for expiration in minutes")
  @JsonProperty(JSON_PROPERTY_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getExpiration() {
    return expiration;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiration(Long expiration) {
    this.expiration = expiration;
  }


  public CreateObjectSigned allowedIpAddresses(List<String> allowedIpAddresses) {
    
    this.allowedIpAddresses = allowedIpAddresses;
    return this;
  }

  public CreateObjectSigned addallowedIpAddressesItem(String allowedIpAddressesItem) {
    if (this.allowedIpAddresses == null) {
      this.allowedIpAddresses = new ArrayList<>();
    }
    this.allowedIpAddresses.add(allowedIpAddressesItem);
    return this;
  }

   /**
   * IP addresses that can make a request to this URL.
   * @return allowedIpAddresses
  **/
  @javax.annotation.Nullable
  @Schema(description = "IP addresses that can make a request to this URL.")
  @JsonProperty(JSON_PROPERTY_ALLOWED_IP_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getAllowedIpAddresses() {
    return allowedIpAddresses;
  }


  @JsonProperty(JSON_PROPERTY_ALLOWED_IP_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAllowedIpAddresses(List<String> allowedIpAddresses) {
    this.allowedIpAddresses = allowedIpAddresses;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateObjectSigned createObjectSigned = (CreateObjectSigned) o;
    return Objects.equals(this.signedUrl, createObjectSigned.signedUrl) &&
        Objects.equals(this.expiration, createObjectSigned.expiration) &&
        Objects.equals(this.allowedIpAddresses, createObjectSigned.allowedIpAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signedUrl, expiration, allowedIpAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateObjectSigned {\n");
    sb.append("    signedUrl: ").append(toIndentedString(signedUrl)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    allowedIpAddresses: ").append(toIndentedString(allowedIpAddresses)).append("\n");
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

