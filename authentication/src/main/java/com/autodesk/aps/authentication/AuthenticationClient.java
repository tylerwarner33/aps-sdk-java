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
package com.autodesk.aps.authentication;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import com.autodesk.aps.authentication.api.TokenApi;
import com.autodesk.aps.authentication.api.UsersApi;
import com.autodesk.aps.authentication.model.AuthorizeOptionalParams;
import com.autodesk.aps.authentication.model.GrantType;
import com.autodesk.aps.authentication.model.IntrospectToken;
import com.autodesk.aps.authentication.model.IntrospectTokenOptionalParams;
import com.autodesk.aps.authentication.model.Jwks;
import com.autodesk.aps.authentication.model.OidcSpec;
import com.autodesk.aps.authentication.model.RefreshTokenOptionalParams;
import com.autodesk.aps.authentication.model.ResponseType;
import com.autodesk.aps.authentication.model.RevokeOptionalParams;
import com.autodesk.aps.authentication.model.Scopes;
import com.autodesk.aps.authentication.model.ThreeLeggedOptionalParams;
import com.autodesk.aps.authentication.model.ThreeLeggedToken;
import com.autodesk.aps.authentication.model.TokenTypeHint;
import com.autodesk.aps.authentication.model.TwoLeggedToken;
import com.autodesk.aps.authentication.model.UserInfo;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;
import com.fasterxml.jackson.core.type.TypeReference;

public class AuthenticationClient {
    private final TokenApi tokenApi;
    private final UsersApi usersApi;

    /**
     * Initializes a new instance of the AuthenticationClient class.
     * 
     * @param sdkManager The SDK manager instance.
     */
    public AuthenticationClient(SdkManager sdkManager) {
        if (sdkManager == null) {
            sdkManager = SdkManagerBuilder.create().build();
        }
        this.tokenApi = new TokenApi(sdkManager);
        this.usersApi = new UsersApi(sdkManager);
    }
     /**
     * Initializes a new instance of the AuthenticationClient class.
     * 
     */
    public AuthenticationClient() {
       this(null);

    }

    /**
     * Closes the underlying connection.
     */
    public void close() {
        this.tokenApi.close();
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
     * @param clientId     The Client ID of the calling application, as registered
     *                     with APS. (required)
     * @param responseType The type of response you want to receive. Possible values
     *                     are: - &#x60;&#x60;code&#x60;&#x60; - Authorization code
     *                     grant. - &#x60;&#x60;id_token&#x60;&#x60; - OpenID
     *                     Connect ID token. (required)
     * @param redirectUri  The URI that APS redirects users to after they grant or
     *                     deny access permission to the application. Must match the
     *                     Callback URL for the application as registered with APS.
     *                     Must be specified as a URL-safe string. It can include
     *                     query parameters or any other valid URL construct.
     *                     (required)
     * @param scopes       A URL-encoded space-delimited list of requested scopes.
     *                     See the &#x60;Developer&#39;s Guide documentation on
     *                     scopes
     *                     &lt;/en/docs/oauth/v2/developers_guide/scopes/&gt;&#x60;_
     *                     for a list of valid values you can provide. The string
     *                     you specify for this parameter must not exceed 2000
     *                     characters and it cannot contain more than 50 scopes.
     *                     (required)
     */

    public String authorize(String clientId, ResponseType responseType, String redirectUri, Scopes[] scopes)
            throws AuthenticationApiException {
        return authorize(clientId, responseType, redirectUri, scopes, null);
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
     * @param clientId               The Client ID of the calling application, as
     *                               registered with APS. (required)
     * @param responseType           The type of response you want to receive.
     *                               Possible values are: -
     *                               &#x60;&#x60;code&#x60;&#x60; - Authorization
     *                               code grant. - &#x60;&#x60;id_token&#x60;&#x60;
     *                               - OpenID Connect ID token. (required)
     * @param redirectUri            The URI that APS redirects users to after they
     *                               grant or deny access permission to the
     *                               application. Must match the Callback URL for
     *                               the application as registered with APS. Must be
     *                               specified as a URL-safe string. It can include
     *                               query parameters or any other valid URL
     *                               construct. (required)
     * @param scopes                 A URL-encoded space-delimited list of requested
     *                               scopes. See the &#x60;Developer&#39;s Guide
     *                               documentation on scopes
     *                               &lt;/en/docs/oauth/v2/developers_guide/scopes/&gt;&#x60;_
     *                               for a list of valid values you can provide. The
     *                               string you specify for this parameter must not
     *                               exceed 2000 characters and it cannot contain
     *                               more than 50 scopes. (required)
     * @param authorizeOptionaParams class containing all optional parameters for
     *                               the authorize method.
     */

    public String authorize(String clientId, ResponseType responseType, String redirectUri, Scopes[] scopes,
            AuthorizeOptionalParams authorizeOptionalParams) throws AuthenticationApiException {
        try {
            if (authorizeOptionalParams == null) {
                authorizeOptionalParams = new AuthorizeOptionalParams.Builder().build();
            }
            return tokenApi.authorize(clientId, responseType, redirectUri, scopes, authorizeOptionalParams.getNonce(),
                    authorizeOptionalParams.getState(), authorizeOptionalParams.getResponseMode(),
                    authorizeOptionalParams.getPrompt(), authorizeOptionalParams.getAuthoptions(),
                    authorizeOptionalParams.getCodeChallenge(), authorizeOptionalParams.getCodeChallengeMethod());
        } catch (Exception e) {
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
     */

    public Jwks getKeys() {
        try {
            return tokenApi.getKeys().getData();
        } catch (Exception e) {
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
     */

    public OidcSpec getOidcSpec() throws AuthenticationApiException {
        try {
            return tokenApi.getOidcSpec().getData();
        } catch (AuthenticationApiException e) {
            throw e;
        } catch (Exception e) {
            throw new AuthenticationApiException(e);
        }
    }

    /**
     * Get User Info
     * Retrieves information about the authenticated user.
     * 
     * @return UserInfo
     * @throws AuthenticationApiException when an API call fails.
     */

    public UserInfo getUserInfo(String accessToken) {
        try {
            if (accessToken == null) {
                throw new AuthenticationApiException("Please provide a valid access token!");
            }
            return usersApi.getUserInfo(accessToken).getData();
        } catch (Exception e) {
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
     * @return IntrospectToken
     */

    public IntrospectToken introspectToken(String token, String clientId) {
    
        return introspectToken(token, clientId, null);
    }

    /**
     * Introspect Token
     * Returns metadata about the specified access token or reference token.
     * 
     * An application can only introspect its own tokens.
     * 
     * This operation has a rate limit of 500 calls per minute.
     * 
     * @return IntrospectToken
     */

    public IntrospectToken introspectToken(String token, String clientId,
            IntrospectTokenOptionalParams introspectTokenOptionalParams) {
        try {
            if (introspectTokenOptionalParams == null) {
                introspectTokenOptionalParams = new IntrospectTokenOptionalParams.Builder().build();
            }
            if (introspectTokenOptionalParams.getClientSecret() != null) {

                String credentials = clientId + ":" + introspectTokenOptionalParams.getClientSecret();
                String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes("UTF-8"));
                String clientIdSecret = "Basic " + encodedCredentials;
                return tokenApi.introspectToken(token, null, clientIdSecret).getData();
            } else {
                return tokenApi.introspectToken(token, clientId, null).getData();
            }
        } catch (Exception e) {
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
     */

    public String logout() throws AuthenticationApiException {
        return logout(null);
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
     * @param postLogoutRedirectUri The URI to redirect the user to after logout.
     */

    public String logout(String postLogoutRedirectUri) {
        try {
            return tokenApi.logout(postLogoutRedirectUri);
        } catch (Exception e) {
            throw new AuthenticationApiException(e);
        }
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
     * @return Object
     */

    public ApiResponse<?> revoke(String token, String clientId, TokenTypeHint tokenTypeHint) {
        return revoke(token, clientId, tokenTypeHint, null);
    }

    /**
     * Revoke Token
     * Revokes an active access token or refresh token.
     * 
     * An application can only revoke its own tokens.
     * 
     * This operation has a rate limit of 100 calls per minute.
     * 
     * @param token               The token to be revoked. (required)
     * @param tokenTypeHint       (required)
     * @param revokeOptionaParams class containing all optional parameters for the
     *                            revoke method.
     * @return Object
     */

    public ApiResponse<?> revoke(String token, String clientId, TokenTypeHint tokenTypeHint,
            RevokeOptionalParams revokeOptionalParams) {
        ApiResponse<?> response;
        try {
            if (revokeOptionalParams == null) {
                revokeOptionalParams = new RevokeOptionalParams.Builder().build();
            }
            if (revokeOptionalParams.getClientSecret() != null) { // request is for private client
                String credentials = clientId + ":" + revokeOptionalParams.getClientSecret();
                String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes("UTF-8"));
                String clientIdSecret = "Basic " + encodedCredentials;
                response = tokenApi.revoke(token, tokenTypeHint, clientIdSecret,
                        null);

            } else {
                response = tokenApi.revoke(token, tokenTypeHint, null,
                        clientId);
            }

            return response;

        } catch (Exception e) {
            throw new AuthenticationApiException(e);
        }
    }

    /**
     * Get Two-Legged Token
     * Acquires a two-legged access token using client credentials grant.
     * 
     * @param clientId     The Client ID of the calling application, as
     *                     registered with APS. (required)
     * @param clientSecret The Client Secret of the calling application,
     *                     as registered with APS. (required)
     * @param scopes       The requested scopes. (required)
     * @return Two legged access token.
     */
    public TwoLeggedToken getTwoLeggedToken(String clientId, String clientSecret, Scopes[] scopes) {
        try {

            // Create Basic Auth header
            String credentials = clientId + ":" + clientSecret;
            String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes("UTF-8"));
            String clientIdSecret = "Basic " + encodedCredentials;

            ClassicHttpResponse response = tokenApi.fetchToken(clientIdSecret, GrantType.CLIENT_CREDENTIALS, null, null,
                    null, null, scopes,
                    null);
            HttpEntity entity = response.getEntity();
            TwoLeggedToken _object = tokenApi.deserialize(entity, new TypeReference<TwoLeggedToken>() {
            });
            return _object;
        } catch (Exception e) {
            throw new AuthenticationApiException(e);
        }
    }

    /**
     * Refresh Token
     * Refreshes an access token using the refresh token.
     * 
     * @param refreshToken The refresh token to use for acquiring a new access
     *                     token. (required)
     * @param clientId     The Client ID of the calling application, as registered
     *                     with APS. (required)
     * @param clientSecret             The Client Secret of the calling application,
     *                                 as registered with APS. (optional)
     * @param scopes                   The requested scopes. (optional)
     * @param fetchTokenOptionalParams class containing all optional parameters for
     *                                 the refreshToken method.
     * @return Refreshed three legged access token.
     */
    public ThreeLeggedToken refreshToken(String refreshToken, String clientId) {
        return refreshToken(refreshToken, clientId, null);
    }

    /**
     * Refresh Token
     * Refreshes an access token using the refresh token.
     * 
     * @param refreshToken             The refresh token to use for acquiring a new
     *                                 access token. (required)
     * @param clientId                 The Client ID of the calling application, as
     *                                 registered with APS. (required)
     * @param clientSecret             The Client Secret of the calling application,
     *                                 as registered with APS. (optional)
     * @param scopes                   The requested scopes. (optional)
     * @param fetchTokenOptionalParams class containing all optional parameters for
     *                                 the refreshToken method.
     * @return Refreshed three legged access token.
     */
    public ThreeLeggedToken refreshToken(String refreshToken, String clientId,
            RefreshTokenOptionalParams refreshTokenOptionalParams) {
        try {
            if (refreshTokenOptionalParams == null) {
                refreshTokenOptionalParams = new RefreshTokenOptionalParams.Builder().build();
            }

            if (refreshTokenOptionalParams.getClientSecret() != null
                    && !refreshTokenOptionalParams.getClientSecret().isEmpty()) {
                // For private clients - use Basic Auth with client credentials
                String credentials = clientId + ":" + refreshTokenOptionalParams.getClientSecret();
                String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes("UTF-8"));
                String clientIdSecret = "Basic " + encodedCredentials;
                ClassicHttpResponse response = tokenApi.fetchToken(clientIdSecret, GrantType.REFRESH_TOKEN, null, null,
                        null, refreshToken, refreshTokenOptionalParams.getScopes(), null);
                HttpEntity entity = response.getEntity();
                ThreeLeggedToken _object = tokenApi.deserialize(entity, new TypeReference<ThreeLeggedToken>() {
                });
                return _object;
            } else {
                // For public clients - use client_id in form body
                ClassicHttpResponse response = tokenApi.fetchToken(null, GrantType.REFRESH_TOKEN, null, null, null,
                        refreshToken, refreshTokenOptionalParams.getScopes(), clientId);
                HttpEntity entity = response.getEntity();
                ThreeLeggedToken _object = tokenApi.deserialize(entity, new TypeReference<ThreeLeggedToken>() {
                });
                return _object;
            }
        } catch (AuthenticationApiException e) {
            throw e;
        } catch (Exception e) {
            throw new AuthenticationApiException(e);
        }
    }

    /**
     * Get Three-Legged Token
     * Returns a three-legged access token.
     * For Private clients specify the client secret along with the Client ID.
     * For Public clients only Client ID needs to be specified.
     * 
     * @param clientId     The Client ID of the application making the request.
     *                     (required)
     * @param code         The authorization code that was passed to your
     *                     application when the user granted access permission to
     *                     your application. (required)
     * @param redirectUri  The URI that APS redirects users to after they grant or
     *                     deny access permission to the application. (required)
     * @param clientSecret The Client secret of the application making the request.
     *                     Required only for private clients. (optional)
     * @param codeVerifier A random URL-encoded string between 43 characters and 128
     *                     characters. (optional)
     * @return ThreeLeggedToken
     */

    public ThreeLeggedToken getThreeLeggedToken(String clientId, String code, String redirectUri)
            throws AuthenticationApiException {
        return getThreeLeggedToken(clientId, code, redirectUri, null);
    }

    /**
     * Get Three-Legged Token
     * Returns a three-legged access token.
     * For Private clients specify the client secret along with the Client ID.
     * For Public clients only Client ID needs to be specified.
     * 
     * @param clientId                 The Client ID of the application making the
     *                                 request. (required)
     * @param code                     The authorization code that was passed to
     *                                 your application when the user granted access
     *                                 permission to your application. (required)
     * @param redirectUri              The URI that APS redirects users to after
     *                                 they grant or deny access permission to the
     *                                 application. (required)
     * @param clientSecret             The Client secret of the application making
     *                                 the request. Required only for private
     *                                 clients. (optional)
     * @param codeVerifier             A random URL-encoded string between 43
     *                                 characters and 128 characters. (optional)
     * @param ThreeLeggedOptionalParams class containing all optional parameters for
     *                                 the getThreeLeggedToken method.
     * @return ThreeLeggedToken.
     */
    public ThreeLeggedToken getThreeLeggedToken(String clientId, String code, String redirectUri,
            ThreeLeggedOptionalParams threeLeggedOptionalParams) throws AuthenticationApiException {
        try {
            if (threeLeggedOptionalParams == null) {
                threeLeggedOptionalParams = new ThreeLeggedOptionalParams.Builder().build();
            }

            if (threeLeggedOptionalParams.getClientSecret() != null
                    && !threeLeggedOptionalParams.getClientSecret().isEmpty()) {
                // For private clients - use Basic Auth with client credentials
                String credentials = clientId + ":" + threeLeggedOptionalParams.getClientSecret();
                String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes("UTF-8"));
                String clientIdSecret = "Basic " + encodedCredentials;

                ClassicHttpResponse response = tokenApi.fetchToken(clientIdSecret, GrantType.AUTHORIZATION_CODE, code,
                        redirectUri, threeLeggedOptionalParams.getCodeVerifier(),
                        null, null, null);
                HttpEntity entity = response.getEntity();
                ThreeLeggedToken _object = tokenApi.deserialize(entity, new TypeReference<ThreeLeggedToken>() {
                });
                return _object;
            } else {
                // For public clients - use client_id in form body
                ClassicHttpResponse response = tokenApi.fetchToken(null, GrantType.AUTHORIZATION_CODE, code,
                        redirectUri, threeLeggedOptionalParams.getCodeVerifier(),
                        null, null, clientId);
                HttpEntity entity = response.getEntity();
                ThreeLeggedToken _object = tokenApi.deserialize(entity, new TypeReference<ThreeLeggedToken>() {
                });
                return _object;
            }
        } catch (AuthenticationApiException e) {
            throw e;
        } catch (Exception e) {
            throw new AuthenticationApiException(e);
        }
    }

}