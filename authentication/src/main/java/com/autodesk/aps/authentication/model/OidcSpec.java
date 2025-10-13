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
 * Represents a successful response to a Get OIDC Specification operation.
 */
@Schema(description = "Represents a successful response to a Get OIDC Specification operation.")
@JsonPropertyOrder({
    OidcSpec.JSON_PROPERTY_ISSUER,
    OidcSpec.JSON_PROPERTY_AUTHORIZATION_ENDPOINT,
    OidcSpec.JSON_PROPERTY_TOKEN_ENDPOINT,
    OidcSpec.JSON_PROPERTY_USERINFO_ENDPOINT,
    OidcSpec.JSON_PROPERTY_JWKS_URI,
    OidcSpec.JSON_PROPERTY_REVOKE_ENDPOINT,
    OidcSpec.JSON_PROPERTY_INTROSPECTION_ENDPOINT,
    OidcSpec.JSON_PROPERTY_SCOPES_SUPPORTED,
    OidcSpec.JSON_PROPERTY_RESPONSE_TYPES_SUPPORTED,
    OidcSpec.JSON_PROPERTY_RESPONSE_MODES_SUPPORTED,
    OidcSpec.JSON_PROPERTY_GRANT_TYPES_SUPPORTED,
    OidcSpec.JSON_PROPERTY_SUBJECT_TYPES_SUPPORTED,
    OidcSpec.JSON_PROPERTY_ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED
})
@JsonTypeName("OidcSpec")
@JsonIgnoreProperties(ignoreUnknown = true)

public class OidcSpec {
  public static final String JSON_PROPERTY_ISSUER = "issuer";
  private String issuer;

  public static final String JSON_PROPERTY_AUTHORIZATION_ENDPOINT = "authorization_endpoint";
  private String authorizationEndpoint;

  public static final String JSON_PROPERTY_TOKEN_ENDPOINT = "token_endpoint";
  private String tokenEndpoint;

  public static final String JSON_PROPERTY_USERINFO_ENDPOINT = "userinfo_endpoint";
  private String userinfoEndpoint;

  public static final String JSON_PROPERTY_JWKS_URI = "jwks_uri";
  private String jwksUri;

  public static final String JSON_PROPERTY_REVOKE_ENDPOINT = "revoke_endpoint";
  private String revokeEndpoint;

  public static final String JSON_PROPERTY_INTROSPECTION_ENDPOINT = "introspection_endpoint";
  private String introspectionEndpoint;

  public static final String JSON_PROPERTY_SCOPES_SUPPORTED = "scopes_supported";
  private List<String> scopesSupported = null;

  public static final String JSON_PROPERTY_RESPONSE_TYPES_SUPPORTED = "response_types_supported";
  private List<String> responseTypesSupported = null;

  public static final String JSON_PROPERTY_RESPONSE_MODES_SUPPORTED = "response_modes_supported";
  private List<String> responseModesSupported = null;

  public static final String JSON_PROPERTY_GRANT_TYPES_SUPPORTED = "grant_types_supported";
  private List<String> grantTypesSupported = null;

  public static final String JSON_PROPERTY_SUBJECT_TYPES_SUPPORTED = "subject_types_supported";
  private List<String> subjectTypesSupported = null;

  public static final String JSON_PROPERTY_ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED = "id_token_signing_alg_values_supported";
  private List<String> idTokenSigningAlgValuesSupported = null;

  public OidcSpec issuer(String issuer) {

    this.issuer = issuer;
    return this;
  }

  /**
   * The base URL of the openID Provider. Always
   * &#x60;&#x60;https://developer.api.autodesk.com&#x60;&#x60; for APS.
   * 
   * @return issuer
   **/
  @javax.annotation.Nullable
  @Schema(description = "The base URL of the openID Provider. Always ``https://developer.api.autodesk.com`` for APS.")
  @JsonProperty(JSON_PROPERTY_ISSUER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIssuer() {
    return issuer;
  }

  @JsonProperty(JSON_PROPERTY_ISSUER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public OidcSpec authorizationEndpoint(String authorizationEndpoint) {

    this.authorizationEndpoint = authorizationEndpoint;
    return this;
  }

  /**
   * The endpoint for authorizing users. It initiates the user authentication
   * process in obtaining an authorization code grant.
   * 
   * @return authorizationEndpoint
   **/
  @javax.annotation.Nullable
  @Schema(description = "The endpoint for authorizing users. It initiates the user authentication process in obtaining an authorization code grant.")
  @JsonProperty(JSON_PROPERTY_AUTHORIZATION_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getAuthorizationEndpoint() {
    return authorizationEndpoint;
  }

  @JsonProperty(JSON_PROPERTY_AUTHORIZATION_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAuthorizationEndpoint(String authorizationEndpoint) {
    this.authorizationEndpoint = authorizationEndpoint;
  }

  public OidcSpec tokenEndpoint(String tokenEndpoint) {

    this.tokenEndpoint = tokenEndpoint;
    return this;
  }

  /**
   * The endpoint for acquiring access tokens and refresh tokens.
   * 
   * @return tokenEndpoint
   **/
  @javax.annotation.Nullable
  @Schema(description = "The endpoint for acquiring access tokens and refresh tokens.")
  @JsonProperty(JSON_PROPERTY_TOKEN_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getTokenEndpoint() {
    return tokenEndpoint;
  }

  @JsonProperty(JSON_PROPERTY_TOKEN_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTokenEndpoint(String tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
  }

  public OidcSpec userinfoEndpoint(String userinfoEndpoint) {

    this.userinfoEndpoint = userinfoEndpoint;
    return this;
  }

  /**
   * The endpoint for querying information about the authenticated user.
   * 
   * @return userinfoEndpoint
   **/
  @javax.annotation.Nullable
  @Schema(description = "The endpoint for querying information about the authenticated user.")
  @JsonProperty(JSON_PROPERTY_USERINFO_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUserinfoEndpoint() {
    return userinfoEndpoint;
  }

  @JsonProperty(JSON_PROPERTY_USERINFO_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUserinfoEndpoint(String userinfoEndpoint) {
    this.userinfoEndpoint = userinfoEndpoint;
  }

  public OidcSpec jwksUri(String jwksUri) {

    this.jwksUri = jwksUri;
    return this;
  }

  /**
   * The endpoint for retrieving public keys used by APS, in the JWKS format.
   * 
   * @return jwksUri
   **/
  @javax.annotation.Nullable
  @Schema(description = "The endpoint for retrieving public keys used by APS, in the JWKS format.")
  @JsonProperty(JSON_PROPERTY_JWKS_URI)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getJwksUri() {
    return jwksUri;
  }

  @JsonProperty(JSON_PROPERTY_JWKS_URI)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setJwksUri(String jwksUri) {
    this.jwksUri = jwksUri;
  }

  public OidcSpec revokeEndpoint(String revokeEndpoint) {

    this.revokeEndpoint = revokeEndpoint;
    return this;
  }

  /**
   * The endpoint for revoking an access token or refresh token.
   * 
   * @return revokeEndpoint
   **/
  @javax.annotation.Nullable
  @Schema(description = "The endpoint for revoking an access token or refresh token.")
  @JsonProperty(JSON_PROPERTY_REVOKE_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getRevokeEndpoint() {
    return revokeEndpoint;
  }

  @JsonProperty(JSON_PROPERTY_REVOKE_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRevokeEndpoint(String revokeEndpoint) {
    this.revokeEndpoint = revokeEndpoint;
  }

  public OidcSpec introspectionEndpoint(String introspectionEndpoint) {

    this.introspectionEndpoint = introspectionEndpoint;
    return this;
  }

  /**
   * The endpoint for obtaining metadata about an access token or refresh token.
   * 
   * @return introspectionEndpoint
   **/
  @javax.annotation.Nullable
  @Schema(description = "The endpoint for obtaining metadata about an access token or refresh token.")
  @JsonProperty(JSON_PROPERTY_INTROSPECTION_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIntrospectionEndpoint() {
    return introspectionEndpoint;
  }

  @JsonProperty(JSON_PROPERTY_INTROSPECTION_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIntrospectionEndpoint(String introspectionEndpoint) {
    this.introspectionEndpoint = introspectionEndpoint;
  }

  public OidcSpec scopesSupported(List<String> scopesSupported) {

    this.scopesSupported = scopesSupported;
    return this;
  }

  public OidcSpec addscopesSupportedItem(String scopesSupportedItem) {
    if (this.scopesSupported == null) {
      this.scopesSupported = new ArrayList<>();
    }
    this.scopesSupported.add(scopesSupportedItem);
    return this;
  }

  /**
   * A list of supported scopes.
   * 
   * @return scopesSupported
   **/
  @javax.annotation.Nullable
  @Schema(description = "A list of supported scopes.")
  @JsonProperty(JSON_PROPERTY_SCOPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getScopesSupported() {
    return scopesSupported;
  }

  @JsonProperty(JSON_PROPERTY_SCOPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setScopesSupported(List<String> scopesSupported) {
    this.scopesSupported = scopesSupported;
  }

  public OidcSpec responseTypesSupported(List<String> responseTypesSupported) {

    this.responseTypesSupported = responseTypesSupported;
    return this;
  }

  public OidcSpec addresponseTypesSupportedItem(String responseTypesSupportedItem) {
    if (this.responseTypesSupported == null) {
      this.responseTypesSupported = new ArrayList<>();
    }
    this.responseTypesSupported.add(responseTypesSupportedItem);
    return this;
  }

  /**
   * A list of the response types supported by APS. Each response type represent a
   * different flow.
   * 
   * @return responseTypesSupported
   **/
  @javax.annotation.Nullable
  @Schema(description = "A list of the response types supported by APS. Each response type represent a different flow.")
  @JsonProperty(JSON_PROPERTY_RESPONSE_TYPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getResponseTypesSupported() {
    return responseTypesSupported;
  }

  @JsonProperty(JSON_PROPERTY_RESPONSE_TYPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResponseTypesSupported(List<String> responseTypesSupported) {
    this.responseTypesSupported = responseTypesSupported;
  }

  public OidcSpec responseModesSupported(List<String> responseModesSupported) {

    this.responseModesSupported = responseModesSupported;
    return this;
  }

  public OidcSpec addresponseModesSupportedItem(String responseModesSupportedItem) {
    if (this.responseModesSupported == null) {
      this.responseModesSupported = new ArrayList<>();
    }
    this.responseModesSupported.add(responseModesSupportedItem);
    return this;
  }

  /**
   * A list of response modes supported by APS. Each response mode defines a
   * different way of delivering an authorization response.
   * 
   * @return responseModesSupported
   **/
  @javax.annotation.Nullable
  @Schema(description = "A list of response modes supported by APS. Each response mode defines a different way of delivering an authorization response.")
  @JsonProperty(JSON_PROPERTY_RESPONSE_MODES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getResponseModesSupported() {
    return responseModesSupported;
  }

  @JsonProperty(JSON_PROPERTY_RESPONSE_MODES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setResponseModesSupported(List<String> responseModesSupported) {
    this.responseModesSupported = responseModesSupported;
  }

  public OidcSpec grantTypesSupported(List<String> grantTypesSupported) {

    this.grantTypesSupported = grantTypesSupported;
    return this;
  }

  public OidcSpec addgrantTypesSupportedItem(String grantTypesSupportedItem) {
    if (this.grantTypesSupported == null) {
      this.grantTypesSupported = new ArrayList<>();
    }
    this.grantTypesSupported.add(grantTypesSupportedItem);
    return this;
  }

  /**
   * A list of grant types supported by APS. Each grant type represents a
   * different way an application can obtain an access token.
   * 
   * @return grantTypesSupported
   **/
  @javax.annotation.Nullable
  @Schema(description = "A list of grant types supported by APS. Each grant type represents a different way an application can obtain an access token.")
  @JsonProperty(JSON_PROPERTY_GRANT_TYPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getGrantTypesSupported() {
    return grantTypesSupported;
  }

  @JsonProperty(JSON_PROPERTY_GRANT_TYPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setGrantTypesSupported(List<String> grantTypesSupported) {
    this.grantTypesSupported = grantTypesSupported;
  }

  public OidcSpec subjectTypesSupported(List<String> subjectTypesSupported) {

    this.subjectTypesSupported = subjectTypesSupported;
    return this;
  }

  public OidcSpec addsubjectTypesSupportedItem(String subjectTypesSupportedItem) {
    if (this.subjectTypesSupported == null) {
      this.subjectTypesSupported = new ArrayList<>();
    }
    this.subjectTypesSupported.add(subjectTypesSupportedItem);
    return this;
  }

  /**
   * A list of subject identifier types supported by APS.
   * 
   * @return subjectTypesSupported
   **/
  @javax.annotation.Nullable
  @Schema(description = "A list of subject identifier types supported by APS.")
  @JsonProperty(JSON_PROPERTY_SUBJECT_TYPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getSubjectTypesSupported() {
    return subjectTypesSupported;
  }

  @JsonProperty(JSON_PROPERTY_SUBJECT_TYPES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSubjectTypesSupported(List<String> subjectTypesSupported) {
    this.subjectTypesSupported = subjectTypesSupported;
  }

  public OidcSpec idTokenSigningAlgValuesSupported(List<String> idTokenSigningAlgValuesSupported) {

    this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
    return this;
  }

  public OidcSpec addidTokenSigningAlgValuesSupportedItem(String idTokenSigningAlgValuesSupportedItem) {
    if (this.idTokenSigningAlgValuesSupported == null) {
      this.idTokenSigningAlgValuesSupported = new ArrayList<>();
    }
    this.idTokenSigningAlgValuesSupported.add(idTokenSigningAlgValuesSupportedItem);
    return this;
  }

  /**
   * A list of all the token signing algorithms supported by APS.
   * 
   * @return idTokenSigningAlgValuesSupported
   **/
  @javax.annotation.Nullable
  @Schema(description = "A list of all the token signing algorithms supported by APS.")
  @JsonProperty(JSON_PROPERTY_ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<String> getIdTokenSigningAlgValuesSupported() {
    return idTokenSigningAlgValuesSupported;
  }

  @JsonProperty(JSON_PROPERTY_ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIdTokenSigningAlgValuesSupported(List<String> idTokenSigningAlgValuesSupported) {
    this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OidcSpec oidcSpec = (OidcSpec) o;
    return Objects.equals(this.issuer, oidcSpec.issuer) &&
        Objects.equals(this.authorizationEndpoint, oidcSpec.authorizationEndpoint) &&
        Objects.equals(this.tokenEndpoint, oidcSpec.tokenEndpoint) &&
        Objects.equals(this.userinfoEndpoint, oidcSpec.userinfoEndpoint) &&
        Objects.equals(this.jwksUri, oidcSpec.jwksUri) &&
        Objects.equals(this.revokeEndpoint, oidcSpec.revokeEndpoint) &&
        Objects.equals(this.introspectionEndpoint, oidcSpec.introspectionEndpoint) &&
        Objects.equals(this.scopesSupported, oidcSpec.scopesSupported) &&
        Objects.equals(this.responseTypesSupported, oidcSpec.responseTypesSupported) &&
        Objects.equals(this.responseModesSupported, oidcSpec.responseModesSupported) &&
        Objects.equals(this.grantTypesSupported, oidcSpec.grantTypesSupported) &&
        Objects.equals(this.subjectTypesSupported, oidcSpec.subjectTypesSupported) &&
        Objects.equals(this.idTokenSigningAlgValuesSupported, oidcSpec.idTokenSigningAlgValuesSupported);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issuer, authorizationEndpoint, tokenEndpoint, userinfoEndpoint, jwksUri, revokeEndpoint,
        introspectionEndpoint, scopesSupported, responseTypesSupported, responseModesSupported, grantTypesSupported,
        subjectTypesSupported, idTokenSigningAlgValuesSupported);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OidcSpec {\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    authorizationEndpoint: ").append(toIndentedString(authorizationEndpoint)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
    sb.append("    userinfoEndpoint: ").append(toIndentedString(userinfoEndpoint)).append("\n");
    sb.append("    jwksUri: ").append(toIndentedString(jwksUri)).append("\n");
    sb.append("    revokeEndpoint: ").append(toIndentedString(revokeEndpoint)).append("\n");
    sb.append("    introspectionEndpoint: ").append(toIndentedString(introspectionEndpoint)).append("\n");
    sb.append("    scopesSupported: ").append(toIndentedString(scopesSupported)).append("\n");
    sb.append("    responseTypesSupported: ").append(toIndentedString(responseTypesSupported)).append("\n");
    sb.append("    responseModesSupported: ").append(toIndentedString(responseModesSupported)).append("\n");
    sb.append("    grantTypesSupported: ").append(toIndentedString(grantTypesSupported)).append("\n");
    sb.append("    subjectTypesSupported: ").append(toIndentedString(subjectTypesSupported)).append("\n");
    sb.append("    idTokenSigningAlgValuesSupported: ").append(toIndentedString(idTokenSigningAlgValuesSupported))
        .append("\n");
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
