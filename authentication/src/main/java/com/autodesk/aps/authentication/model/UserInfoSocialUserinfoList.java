/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Authentication
 * OAuth2 token management APIs.
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

package com.autodesk.aps.authentication.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UserInfoSocialUserinfoList
 */
@JsonPropertyOrder({
    UserInfoSocialUserinfoList.JSON_PROPERTY_SOCIAL_USER_ID,
    UserInfoSocialUserinfoList.JSON_PROPERTY_PROVIDER_ID,
    UserInfoSocialUserinfoList.JSON_PROPERTY_PROVIDER_NAME
})
@JsonTypeName("UserInfo_social_userinfo_list")
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserInfoSocialUserinfoList {
  public static final String JSON_PROPERTY_SOCIAL_USER_ID = "socialUserId";
  private String socialUserId;

  public static final String JSON_PROPERTY_PROVIDER_ID = "providerId";
  private String providerId;

  public static final String JSON_PROPERTY_PROVIDER_NAME = "providerName";
  private String providerName;

  public UserInfoSocialUserinfoList socialUserId(String socialUserId) {

    this.socialUserId = socialUserId;
    return this;
  }

  /**
   * The ID of the user within the social media platform.
   * 
   * @return socialUserId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the user within the social media platform.")
  @JsonProperty(JSON_PROPERTY_SOCIAL_USER_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getSocialUserId() {
    return socialUserId;
  }

  @JsonProperty(JSON_PROPERTY_SOCIAL_USER_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSocialUserId(String socialUserId) {
    this.socialUserId = socialUserId;
  }

  public UserInfoSocialUserinfoList providerId(String providerId) {

    this.providerId = providerId;
    return this;
  }

  /**
   * The ID of the social media platform.
   * 
   * @return providerId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the social media platform.")
  @JsonProperty(JSON_PROPERTY_PROVIDER_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getProviderId() {
    return providerId;
  }

  @JsonProperty(JSON_PROPERTY_PROVIDER_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public UserInfoSocialUserinfoList providerName(String providerName) {

    this.providerName = providerName;
    return this;
  }

  /**
   * The name of the social media platform.
   * 
   * @return providerName
   **/
  @javax.annotation.Nullable
  @Schema(description = "The name of the social media platform.")
  @JsonProperty(JSON_PROPERTY_PROVIDER_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getProviderName() {
    return providerName;
  }

  @JsonProperty(JSON_PROPERTY_PROVIDER_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfoSocialUserinfoList userInfoSocialUserinfoList = (UserInfoSocialUserinfoList) o;
    return Objects.equals(this.socialUserId, userInfoSocialUserinfoList.socialUserId) &&
        Objects.equals(this.providerId, userInfoSocialUserinfoList.providerId) &&
        Objects.equals(this.providerName, userInfoSocialUserinfoList.providerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(socialUserId, providerId, providerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfoSocialUserinfoList {\n");
    sb.append("    socialUserId: ").append(toIndentedString(socialUserId)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    providerName: ").append(toIndentedString(providerName)).append("\n");
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
