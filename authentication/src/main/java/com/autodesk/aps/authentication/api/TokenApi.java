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
package com.autodesk.aps.authentication.api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import com.autodesk.aps.authentication.AuthenticationApiException;
import com.autodesk.aps.authentication.BaseApi;
import com.autodesk.aps.authentication.model.GrantType;
import com.autodesk.aps.authentication.model.IntrospectToken;
import com.autodesk.aps.authentication.model.Jwks;
import com.autodesk.aps.authentication.model.OidcSpec;
import com.autodesk.aps.authentication.model.ResponseType;
import com.autodesk.aps.authentication.model.Scopes;
import com.autodesk.aps.authentication.model.TokenTypeHint;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class TokenApi extends BaseApi {

  public TokenApi(SdkManager sdkManager) {
    super(sdkManager, sdkManager.getLogger());
  }

  /**
   * Authorize User
   * Returns a browser URL to redirect an end user in order to acquire the user’s
   * consent to authorize the application to access resources on their behalf.
   * 
   * Invoking this operation is the first step in authenticating users and
   * retrieving an authorization code grant. The authorization code that is
   * generated remains valid for 5 minutes, while the ID token stays valid for 60
   * minutes. Any access tokens you obtain are valid for 60 minutes, and refresh
   * tokens remain valid for 15 days.
   * 
   * This operation has a rate limit of 500 calls per minute.
   * 
   * **Note:** This operation is intended for use with client-side applications
   * only. It is not suitable for server-side applications.
   * 
   * @param clientId            The Client ID of the calling application, as
   *                            registered with APS. (required)
   * @param responseType        The type of response you want to receive. Possible
   *                            values are: - &#x60;&#x60;code&#x60;&#x60; -
   *                            Authorization code grant. -
   *                            &#x60;&#x60;id_token&#x60;&#x60; - OpenID Connect
   *                            ID token. (required)
   * @param redirectUri         The URI that APS redirects users to after they
   *                            grant or deny access permission to the
   *                            application. Must match the Callback URL for the
   *                            application as registered with APS. Must be
   *                            specified as a URL-safe string. It can include
   *                            query parameters or any other valid URL construct.
   *                            (required)
   * @param scope               A URL-encoded space-delimited list of requested
   *                            scopes. See the &#x60;Developer&#39;s Guide
   *                            documentation on scopes
   *                            &lt;/en/docs/oauth/v2/developers_guide/scopes/&gt;&#x60;_
   *                            for a list of valid values you can provide. The
   *                            string you specify for this parameter must not
   *                            exceed 2000 characters and it cannot contain more
   *                            than 50 scopes. (required)
   * @param nonce               A random string that is sent with the request. APS
   *                            passes back the same string to you so that you can
   *                            verify whether you received the same string that
   *                            you sent. This check mitigates token replay
   *                            attacks (optional)
   * @param state               A URL-encoded random string. The authorization
   *                            flow will pass the same string back to the
   *                            Callback URL using the
   *                            &#x60;&#x60;state&#x60;&#x60; query string
   *                            parameter. This process helps ensure that the
   *                            callback you receive is a response to what you
   *                            originally requested. It prevents malicious actors
   *                            from forging requests. The string can only contain
   *                            alphanumeric characters, commas, periods,
   *                            underscores, and hyphens. (optional)
   * @param responseMode        Specifies how the authorization response should be
   *                            returned. Valid values are: -
   *                            &#x60;&#x60;fragment&#x60;&#x60; - Encode the
   *                            response parameters in the fragment of the
   *                            redirect URI. A fragment in a URI is the optional
   *                            part of the URI that appears after a
   *                            &#x60;&#x60;#&#x60;&#x60; symbol, which refers to
   *                            a specific section within a resource. For example,
   *                            &#x60;&#x60;section&#x60;&#x60; in
   *                            &#x60;&#x60;https://www.mysite.org/myresource#section&#x60;&#x60;.
   *                            - &#x60;&#x60;form_post&#x60;&#x60; - Embed the
   *                            authorization response parameter in an HTML form.
   *                            - &#x60;&#x60;query&#x60;&#x60; - Embed the
   *                            authorization response as a query string parameter
   *                            of the redirect URI. If
   *                            &#x60;&#x60;id_token&#x60;&#x60; is stated as
   *                            &#x60;&#x60;response_type&#x60;&#x60;, only
   *                            &#x60;&#x60;form_post&#x60;&#x60; is allowed as
   *                            &#x60;&#x60;response_mode&#x60;&#x60;.&#39;
   *                            (optional)
   * @param prompt              Specifies how to prompt users for authentication.
   *                            Possible values are: -
   *                            &#x60;&#x60;login&#x60;&#x60; : Always prompt the
   *                            user for authentication, regardless of the state
   *                            of the login session. **Note:** If you do not
   *                            specify this parameter, the system will not prompt
   *                            the user for authentication as long as a login
   *                            session is active. If a login session is not
   *                            active, the system will prompt the user for
   *                            authentication. (optional)
   * @param authoptions         A JSON object containing options that specify how
   *                            to display the sign-in page. Refer the
   *                            &#x60;Developer&#39;s Guide documentation on
   *                            AuthOptions
   *                            &lt;/en/docs/oauth/v2/developers_guide/authoptions/&gt;&#x60;_
   *                            for supported values. (optional)
   * @param codeChallenge       A URL-encoded string derived from the code
   *                            verifier sent in the authorization request with
   *                            the Proof Key for Code Exchange (PKCE) grant flow.
   *                            (optional)
   * @param codeChallengeMethod The method used to derive the code challenge for
   *                            the PKCE grant flow. Possible value is: -
   *                            &#x60;&#x60;S256&#x60;&#x60;- Hashes the code
   *                            verifier using the SHA-256 algorithm and then
   *                            applies Base64 URL encoding. (optional)
   * @throws AuthenticationApiException if fails to make API call
   * @throws URISyntaxException
   * @throws MalformedURLException
   */
  public String authorize(String clientId, ResponseType responseType, String redirectUri, Scopes[] scope,
      String nonce, String state, String responseMode, String prompt, String authoptions, String codeChallenge,
      String codeChallengeMethod) throws AuthenticationApiException, MalformedURLException, URISyntaxException {
    this.logger.info("Entered into authorize ");

    // verify the required parameter 'clientId' is set
    if (clientId == null) {
      throw new AuthenticationApiException(400, "Missing the required parameter 'clientId' when calling authorize");
    }

    // verify the required parameter 'responseType' is set
    if (responseType == null) {
      throw new AuthenticationApiException(400, "Missing the required parameter 'responseType' when calling authorize");
    }

    // verify the required parameter 'redirectUri' is set
    if (redirectUri == null) {
      throw new AuthenticationApiException(400, "Missing the required parameter 'redirectUri' when calling authorize");
    }

    // verify the required parameter 'scope' is set
    if (scope == null) {
      throw new AuthenticationApiException(400, "Missing the required parameter 'scope' when calling authorize");
    }

    // create path and map variables
    String localVarPath = "/authentication/v2/authorize";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    String scopeString = parameterToString(scope);
    if (clientId != null) {
      localVarQueryParams.put("client_id", parameterToString(clientId));
    }
    if (responseType != null) {
      localVarQueryParams.put("response_type", parameterToString(responseType));
    }
    if (redirectUri != null) {
      localVarQueryParams.put("redirect_uri", parameterToString(redirectUri));
    }
    if (nonce != null) {
      localVarQueryParams.put("nonce", parameterToString(nonce));
    }
    if (state != null) {
      localVarQueryParams.put("state", parameterToString(state));
    }
    if (scopeString != null) {
      localVarQueryParams.put("scope", parameterToString(scopeString));
    }
    if (responseMode != null) {
      localVarQueryParams.put("response_mode", parameterToString(responseMode));
    }
    if (prompt != null) {
      localVarQueryParams.put("prompt", parameterToString(prompt));
    }
    if (authoptions != null) {
      localVarQueryParams.put("authoptions", parameterToString(authoptions));
    }
    if (codeChallenge != null) {
      localVarQueryParams.put("code_challenge", parameterToString(codeChallenge));
    }
    if (codeChallengeMethod != null) {
      localVarQueryParams.put("code_challenge_method", parameterToString(codeChallengeMethod));
    }
    URI localVarUrlObj = new URI(this.sdkManager.getApsConfiguration().getBaseAddress() + localVarPath);
    URIBuilder uriBuilder = new URIBuilder(localVarUrlObj);
    localVarQueryParams.forEach(uriBuilder::addParameter);
    return uriBuilder.build().toString();

  }

  /**
   * Acquire Token
   * Returns an access token or refresh token.
   * 
   * * If &#x60;grant_type&#x60; is &#x60;authorization_code&#x60;, returns a
   * 3-legged access token for authorization code grant.
   * * If &#x60;grant_type&#x60; is &#x60;client_credentials&#x60;, returns a
   * 2-legged access token for client credentials grant.
   * * If &#x60;grant_type&#x60; is &#x60;refresh_token&#x60;, returns new access
   * token using the refresh token provided in the request.
   * 
   * Traditional Web Apps and Server-to-Server Apps should use the
   * &#x60;&#x60;Authorization&#x60;&#x60; header with Basic Authentication for
   * this operation. Desktop, Mobile, and Single-Page Apps should use
   * &#x60;&#x60;client_id&#x60;&#x60; in the form body instead.
   * 
   * This operation has a rate limit of 500 calls per minute.
   * 
   * @param authorization Must be &#x60;&#x60;Bearer
   *                      &lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; where
   *                      &#x60;&#x60;&lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; is
   *                      the Base64 encoding of the concatenated string
   *                      &#x60;&#x60;&lt;CLIENT_ID&gt;:&lt;CLIENT_SECRET&gt;&#x60;&#x60;.&#39;
   *                      **Note** This header is required only for Traditional
   *                      Web Apps and Server-to-Server Apps. It is not required
   *                      for Desktop, Mobile, and Single-Page Apps. (optional)
   * @param grantType     (optional)
   * @param code          The authorization code that was passed to your
   *                      application when the user granted access permission to
   *                      your application. It was passed as the
   *                      &#x60;&#x60;code&#x60;&#x60; query parameter to the
   *                      redirect URI when you called &#x60;Authorize User
   *                      &lt;/en/docs/oauth/v2/reference/http/authorize-GET/&gt;&#x60;_.
   *                      Required if &#x60;grant_type&#x60; is
   *                      &#x60;&#x60;authorization_code&#x60;&#x60;. (optional)
   * @param redirectUri   The URI that APS redirects users to after they grant or
   *                      deny access permission to the application. Must match
   *                      the Callback URL for the application registered with
   *                      APS. Required if &#x60;grant_type&#x60; is
   *                      &#x60;&#x60;authorization_code&#x60;&#x60;. (optional)
   * @param codeVerifier  A random URL-encoded string between 43 characters and
   *                      128 characters. In a PKCE grant flow, the authentication
   *                      server uses this string to verify the code challenge
   *                      that was passed when you called &#x60;Authorize User
   *                      &lt;/en/docs/oauth/v2/reference/http/authorize-GET/&gt;&#x60;_.
   *                      Required if &#x60;&#x60;grant_type&#x60;&#x60; is
   *                      &#x60;authorization_code&#x60; and
   *                      &#x60;&#x60;code_challenge&#x60;&#x60; was specified
   *                      when you called &#x60;Authorize User
   *                      &lt;/en/docs/oauth/v2/reference/http/authorize-GET/&gt;&#x60;_.
   *                      (optional)
   * @param refreshToken  The refresh token used to acquire a new access token and
   *                      a refresh token. Required if
   *                      &#x60;&#x60;grant_type&#x60;&#x60; is
   *                      &#x60;&#x60;refresh_token&#x60;&#x60;. (optional)
   * @param scope         (optional)
   * @param clientId      The Client ID of the application making the request.
   *                      **Note** This is required only for Traditional Web Apps
   *                      and Server-to-Server Apps. It is not required for
   *                      Desktop, Mobile, and Single-Page Apps. (optional)
   * @return Object
   * @throws AuthenticationApiException if fails to make API call
   */
  public ClassicHttpResponse fetchToken(String authorization, GrantType grantType, String code, String redirectUri,
      String codeVerifier, String refreshToken, Scopes[] scope, String clientId)
      throws AuthenticationApiException {
    this.logger.info("Entered into fetchToken ");

    // create path and map variables
    String localVarPath = "/authentication/v2/token";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarPostBody = new HashMap<String, Object>();

    if (authorization != null) {
      localVarHeaderParams.put("Authorization", parameterToString(authorization));
    }
    if (grantType != null) {
      localVarPostBody.put("grant_type", grantType);
    }
    if (code != null) {
      localVarPostBody.put("code", code);
    }
    if (redirectUri != null) {
      localVarPostBody.put("redirect_uri", redirectUri);
    }
    if (codeVerifier != null) {
      localVarPostBody.put("code_verifier", codeVerifier);
    }
    if (refreshToken != null) {
      localVarPostBody.put("refresh_token", refreshToken);
    }
    if (scope != null) {
      String scopeString = parameterToString(scope);
      localVarPostBody.put("scope", scopeString);
    }

    if (clientId != null) {
      localVarPostBody.put("client_id", clientId);
    }

    localVarHeaderParams.put("Content-Type", "application/x-www-form-urlencoded");
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Post",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          null);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new AuthenticationApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("fetchToken Request completed successfully with status " + statusCode);

      return response;

    } catch (AuthenticationApiException e) {
      this.logger.error("fetchToken Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("fetchToken Request failed with exception: " + e.getMessage());
      throw new AuthenticationApiException(e);
    }
  }

  /**
   * Get JWKS
   * Returns a set of public keys in the JSON Web Key Set (JWKS) format.
   * 
   * Public keys returned by this operation can be used to validate the asymmetric
   * JWT signature of an access token without making network calls. It can be used
   * to validate both two-legged access tokens and three-legged access tokens.
   * 
   * See the Developer&#39;s Guide topic on &#x60;Asymmetric Signing
   * &lt;/en/docs/oauth/v2/developers_guide/asymmetric-encryption/&gt;&#x60;_ for
   * more information.
   * 
   * @return Jwks
   * @throws AuthenticationApiException if fails to make API call
   */
  public ApiResponse<Jwks> getKeys() throws AuthenticationApiException {
    this.logger.info("Entered into getKeys ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/authentication/v2/keys";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new AuthenticationApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getKeys Request completed successfully with status " + statusCode);
      Jwks jwks = deserialize(entity, new TypeReference<Jwks>() {
      });
      return new ApiResponse<Jwks>(statusCode, response.getHeaders(), jwks);
    } catch (AuthenticationApiException e) {
      this.logger.error("getKeys Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getKeys Request failed with exception: " + e.getMessage());
      throw new AuthenticationApiException(e);
    }
  }

  /**
   * Get OIDC Specification
   * Returns an OpenID Connect Discovery Specification compliant JSON document. It
   * contains a list of the OpenID/OAuth endpoints, supported scopes, claims,
   * public keys used to sign the tokens, and other details.
   * 
   * @return OidcSpec
   * @throws AuthenticationApiException if fails to make API call
   */
  public ApiResponse<OidcSpec> getOidcSpec() throws AuthenticationApiException {
    this.logger.info("Entered into getOidcSpec ");

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/.well-known/openid-configuration";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Get",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          localVarFormParams);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new AuthenticationApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("getOidcSpec Request completed successfully with status " + statusCode);
      OidcSpec oidcSpec = deserialize(entity, new TypeReference<OidcSpec>() {
      });
      return new ApiResponse<OidcSpec>(statusCode, response.getHeaders(), oidcSpec);
    } catch (AuthenticationApiException e) {
      this.logger.error("getOidcSpec Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getOidcSpec Request failed with exception: " + e.getMessage());
      throw new AuthenticationApiException(e);
    }
  }

  /**
   * Introspect Token
   * Returns metadata about the specified access token or reference token.
   * 
   * An application can only introspect its own tokens.
   * 
   * This operation has a rate limit of 500 calls per minute.
   * 
   * @param authorization Must be &#x60;&#x60;Bearer
   *                      &lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; where
   *                      &#x60;&#x60;&lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; is
   *                      the Base64 encoding of the concatenated string
   *                      &#x60;&#x60;&lt;CLIENT_ID&gt;:&lt;CLIENT_SECRET&gt;&#x60;&#x60;.&#39;
   *                      **Note** This header is required only for Traditional
   *                      Web Apps and Server-to-Server Apps. It is not required
   *                      for Desktop, Mobile, and Single-Page Apps. (optional)
   * @param token         The token to be introspected. (optional)
   * @param clientId      The Client ID of the application making the request.
   *                      **Note** This is required only for Traditional Web Apps
   *                      and Server-to-Server Apps. It is not required for
   *                      Desktop, Mobile, and Single-Page Apps. (optional)
   * @return IntrospectToken
   * @throws AuthenticationApiException if fails to make API call
   */
  public ApiResponse<IntrospectToken> introspectToken(String token, String clientId, String authorization)
      throws AuthenticationApiException {
    this.logger.info("Entered into introspectToken ");

    // create path and map variables
    String localVarPath = "/authentication/v2/introspect";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarPostBody = new HashMap<String, Object>();

    if (authorization != null) {
      localVarHeaderParams.put("Authorization", parameterToString(authorization));
    }
    if (token != null) {
      localVarPostBody.put("token", token);
    }
    if (clientId != null) {
      localVarPostBody.put("client_id", clientId);
    }

    localVarHeaderParams.put("Content-Type", "application/x-www-form-urlencoded");

    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Post",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          null);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new AuthenticationApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("introspectToken Request completed successfully with status " + statusCode);
      IntrospectToken introspectToken = deserialize(entity, new TypeReference<IntrospectToken>() {
      });
      return new ApiResponse<IntrospectToken>(statusCode, response.getHeaders(), introspectToken);
    } catch (AuthenticationApiException e) {
      this.logger.error("introspectToken Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("introspectToken Request failed with exception: " + e.getMessage());
      throw new AuthenticationApiException(e);
    }
  }

  /**
   * Logout
   * Signs out the currently authenticated user from the APS authorization server.
   * Thereafter, this operation redirects the user to the
   * &#x60;&#x60;post_logout_redirect_uri&#x60;&#x60;, or to the Autodesk Sign-in
   * page when no &#x60;&#x60;post_logout_redirect_uri&#x60;&#x60; is provided.
   * 
   * This operation has a rate limit of 500 calls per minute.
   * 
   * @param postLogoutRedirectUri The URI to redirect your users to once logout is
   *                              performed. If you do not specify this parameter
   *                              your users are redirected to the Autodesk
   *                              Sign-in page. **Note:** You must provide a
   *                              redirect URI that is pre-registered with APS.
   *                              This precaution is taken to prevent unauthorized
   *                              applications from hijacking the logout process.
   *                              (optional)
   * @throws AuthenticationApiException if fails to make API call
   * @throws URISyntaxException         if fails to create URI
   */
  public String logout(String postLogoutRedirectUri) throws AuthenticationApiException, URISyntaxException {
    this.logger.info("Entered into logout ");

    // create path and map variables
    String localVarPath = "/authentication/v2/logout";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();

    if (postLogoutRedirectUri != null) {
      localVarQueryParams.put("post_logout_redirect_uri", parameterToString(postLogoutRedirectUri));
    }

    URI localVarUrlObj = new URI(this.sdkManager.getApsConfiguration().getBaseAddress() + localVarPath);
    URIBuilder uriBuilder = new URIBuilder(localVarUrlObj);
    localVarQueryParams.forEach(uriBuilder::addParameter);
    return uriBuilder.build().toString();
  }

  /**
   * Revoke Token
   * Revokes an active access token or refresh token.
   * 
   * An application can only revoke its own tokens.
   * 
   * This operation has a rate limit of 100 calls per minute.
   * 
   * @param token         The token to be revoked. (required)
   * @param tokenTypeHint (required)
   * @param authorization Must be &#x60;&#x60;Bearer
   *                      &lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; where
   *                      &#x60;&#x60;&lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; is
   *                      the Base64 encoding of the concatenated string
   *                      &#x60;&#x60;&lt;CLIENT_ID&gt;:&lt;CLIENT_SECRET&gt;&#x60;&#x60;.&#39;
   *                      **Note** This header is required only for Traditional
   *                      Web Apps and Server-to-Server Apps. It is not required
   *                      for Desktop, Mobile, and Single-Page Apps. (optional)
   * @param clientId      The Client ID of the application making the request.
   *                      **Note** This is required only for Traditional Web Apps
   *                      and Server-to-Server Apps. It is not required for
   *                      Desktop, Mobile, and Single-Page Apps. (optional)
   * @return ApiResponse&lt;?&gt;
   */
  public ApiResponse<?> revoke(String token, TokenTypeHint tokenTypeHint, String authorization, String clientId)
      throws AuthenticationApiException {
    this.logger.info("Entered into revoke ");

    // verify the required parameter 'token' is set
    if (token == null) {
      throw new AuthenticationApiException(400, "Missing the required parameter 'token' when calling revoke");
    }

    // verify the required parameter 'tokenTypeHint' is set
    if (tokenTypeHint == null) {
      throw new AuthenticationApiException(400, "Missing the required parameter 'tokenTypeHint' when calling revoke");
    }

    // create path and map variables
    String localVarPath = "/authentication/v2/revoke";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarPostBody = new HashMap<String, Object>();

    if (authorization != null) {
      localVarHeaderParams.put("Authorization", parameterToString(authorization));
    }
    if (token != null) {
      localVarPostBody.put("token", token);
    }
    if (tokenTypeHint != null) {
      localVarPostBody.put("token_type_hint", tokenTypeHint);
    }
    if (clientId != null) {
      localVarPostBody.put("client_id", clientId);
    }
    localVarHeaderParams.put("Content-Type", "application/x-www-form-urlencoded");
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
          localVarPath,
          "Post",
          localVarQueryParams,
          localVarPostBody,
          localVarHeaderParams,
          null);
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
        String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        throw new AuthenticationApiException(
            "Request failed with status: " + statusCode + " and response: " + responseString,
            statusCode, responseString);
      }
      this.logger.info("revoke Request completed successfully with status " + statusCode);

      return new ApiResponse<Object>(response.getCode(), response.getHeaders(), response.getEntity());
    } catch (AuthenticationApiException e) {
      this.logger.error("revoke Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("revoke Request failed with exception: " + e.getMessage());
      throw new AuthenticationApiException(e);
    }
  }

}
