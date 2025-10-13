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
 * Represents the payload returned in response to an authorization code grant
 * request.
 */
@Schema(description = "Represents the payload returned in response to an authorization code grant request.")
@JsonPropertyOrder({
    ThreeLeggedToken.JSON_PROPERTY_TOKEN_TYPE,
    ThreeLeggedToken.JSON_PROPERTY_EXPIRES_IN,
    ThreeLeggedToken.JSON_PROPERTY_REFRESH_TOKEN,
    ThreeLeggedToken.JSON_PROPERTY_ACCESS_TOKEN,
    ThreeLeggedToken.JSON_PROPERTY_ID_TOKEN,
    ThreeLeggedToken.JSON_PROPERTY_EXPIRES_AT
})
@JsonTypeName("threeLeggedToken")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ThreeLeggedToken {
  public static final String JSON_PROPERTY_TOKEN_TYPE = "token_type";
  private String tokenType = "Bearer";

  public static final String JSON_PROPERTY_EXPIRES_IN = "expires_in";
  private Integer expiresIn;

  public static final String JSON_PROPERTY_REFRESH_TOKEN = "refresh_token";
  private String refreshToken;

  public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
  private String accessToken;

  public static final String JSON_PROPERTY_ID_TOKEN = "id_token";
  private String idToken;

  public static final String JSON_PROPERTY_EXPIRES_AT = "expires_at";
  private Integer expiresAt;

  public ThreeLeggedToken tokenType(String tokenType) {

    this.tokenType = tokenType;
    return this;
  }

  /**
   * Will always be Bearer.
   * 
   * @return tokenType
   **/
  @javax.annotation.Nullable
  @Schema(description = "Will always be Bearer.")
  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getTokenType() {
    return tokenType;
  }

  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public ThreeLeggedToken expiresIn(Integer expiresIn) {

    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Access token expiration time (in seconds).
   * 
   * @return expiresIn
   **/
  @javax.annotation.Nullable
  @Schema(description = "Access token expiration time (in seconds).")
  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getExpiresIn() {
    return expiresIn;
  }

  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  public ThreeLeggedToken refreshToken(String refreshToken) {

    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * The refresh token.
   * 
   * @return refreshToken
   **/
  @Schema(required = true, description = "The refresh token.")
  @JsonProperty(JSON_PROPERTY_REFRESH_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRefreshToken() {
    return refreshToken;
  }

  @JsonProperty(JSON_PROPERTY_REFRESH_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public ThreeLeggedToken accessToken(String accessToken) {

    this.accessToken = accessToken;
    return this;
  }

  /**
   * The access token.
   * 
   * @return accessToken
   **/
  @Schema(required = true, description = "The access token.")
  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccessToken() {
    return accessToken;
  }

  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public ThreeLeggedToken idToken(String idToken) {

    this.idToken = idToken;
    return this;
  }

  /**
   * The ID token, if openid scope was specified in /authorize request.
   * 
   * @return idToken
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID token, if openid scope was specified in /authorize request.")
  @JsonProperty(JSON_PROPERTY_ID_TOKEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIdToken() {
    return idToken;
  }

  @JsonProperty(JSON_PROPERTY_ID_TOKEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIdToken(String idToken) {
    this.idToken = idToken;
  }

  public ThreeLeggedToken expiresAt(Integer expiresAt) {

    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * Access token expiration time (in seconds).
   * 
   * @return expiresAt
   **/
  @javax.annotation.Nullable
  @Schema(description = "Access token expiration time (in seconds).")
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getExpiresAt() {
    return expiresAt;
  }

  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExpiresAt(Integer expiresAt) {
    this.expiresAt = expiresAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreeLeggedToken threeLeggedToken = (ThreeLeggedToken) o;
    return Objects.equals(this.tokenType, threeLeggedToken.tokenType) &&
        Objects.equals(this.expiresIn, threeLeggedToken.expiresIn) &&
        Objects.equals(this.refreshToken, threeLeggedToken.refreshToken) &&
        Objects.equals(this.accessToken, threeLeggedToken.accessToken) &&
        Objects.equals(this.idToken, threeLeggedToken.idToken) &&
        Objects.equals(this.expiresAt, threeLeggedToken.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenType, expiresIn, refreshToken, accessToken, idToken, expiresAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThreeLeggedToken {\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    idToken: ").append(toIndentedString(idToken)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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
