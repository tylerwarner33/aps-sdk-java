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
 * Represents the payload returned for an introspect token request.
 */
@Schema(description = "Represents the payload returned for an introspect token request.")
@JsonPropertyOrder({
    IntrospectToken.JSON_PROPERTY_ACTIVE,
    IntrospectToken.JSON_PROPERTY_SCOPE,
    IntrospectToken.JSON_PROPERTY_CLIENT_ID,
    IntrospectToken.JSON_PROPERTY_EXP,
    IntrospectToken.JSON_PROPERTY_USERID
})
@JsonTypeName("introspectToken")
@JsonIgnoreProperties(ignoreUnknown = true)

public class IntrospectToken {
  public static final String JSON_PROPERTY_ACTIVE = "active";
  private Boolean active;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private String scope;

  public static final String JSON_PROPERTY_CLIENT_ID = "client_id";
  private String clientId;

  public static final String JSON_PROPERTY_EXP = "exp";
  private Integer exp;

  public static final String JSON_PROPERTY_USERID = "userid";
  private String userid;

  public IntrospectToken active(Boolean active) {

    this.active = active;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60;: The token is active.
   * 
   * &#x60;&#x60;false&#x60;&#x60;: The token is expired, invalid, or revoked.
   * 
   * @return active
   **/
  @Schema(required = true, description = "``true``: The token is active.  ``false``: The token is expired, invalid, or revoked. ")
  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getActive() {
    return active;
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setActive(Boolean active) {
    this.active = active;
  }

  public IntrospectToken scope(String scope) {

    this.scope = scope;
    return this;
  }

  /**
   * A URL-encoded, space separated list of scopes associated with the token.
   * 
   * @return scope
   **/
  @Schema(required = true, description = "A URL-encoded, space separated list of scopes associated with the token.")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getScope() {
    return scope;
  }

  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setScope(String scope) {
    this.scope = scope;
  }

  public IntrospectToken clientId(String clientId) {

    this.clientId = clientId;
    return this;
  }

  /**
   * The Client ID of the application associated with the token.
   * 
   * @return clientId
   **/
  @Schema(required = true, description = "The Client ID of the application associated with the token.")
  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getClientId() {
    return clientId;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public IntrospectToken exp(Integer exp) {

    this.exp = exp;
    return this;
  }

  /**
   * The expiration time of the token, represented as a Unix timestamp.
   * 
   * @return exp
   **/
  @Schema(required = true, description = "The expiration time of the token, represented as a Unix timestamp.")
  @JsonProperty(JSON_PROPERTY_EXP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getExp() {
    return exp;
  }

  @JsonProperty(JSON_PROPERTY_EXP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExp(Integer exp) {
    this.exp = exp;
  }

  public IntrospectToken userid(String userid) {

    this.userid = userid;
    return this;
  }

  /**
   * The ID of the user who authorized the token.
   * 
   * @return userid
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the user who authorized the token.")
  @JsonProperty(JSON_PROPERTY_USERID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUserid() {
    return userid;
  }

  @JsonProperty(JSON_PROPERTY_USERID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUserid(String userid) {
    this.userid = userid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntrospectToken introspectToken = (IntrospectToken) o;
    return Objects.equals(this.active, introspectToken.active) &&
        Objects.equals(this.scope, introspectToken.scope) &&
        Objects.equals(this.clientId, introspectToken.clientId) &&
        Objects.equals(this.exp, introspectToken.exp) &&
        Objects.equals(this.userid, introspectToken.userid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, scope, clientId, exp, userid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IntrospectToken {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    exp: ").append(toIndentedString(exp)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
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
