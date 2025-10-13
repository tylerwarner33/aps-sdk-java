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

/**
 * Represents optional parameters for the `authorize` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class AuthorizeOptionalParams {
    private String nonce;
    private String state;
    private String responseMode;
    private String prompt;
    private String authoptions;
    private String codeChallenge;
    private String codeChallengeMethod;

    private AuthorizeOptionalParams(Builder builder) {
        this.nonce = builder.nonce;
        this.state = builder.state;
        this.responseMode = builder.responseMode;
        this.prompt = builder.prompt;
        this.authoptions = builder.authoptions;
        this.codeChallenge = builder.codeChallenge;
        this.codeChallengeMethod = builder.codeChallengeMethod;
    }

    /**
     * Builder class for constructing instances of AuthorizeOptionalParams.
     */
    public static class Builder {
        private String nonce;
        private String state;
        private String responseMode;
        private String prompt;
        private String authoptions;
        private String codeChallenge;
        private String codeChallengeMethod;

        /**
         * @param nonce A random string that is sent with the request. APS passes back
         *              the same string to you so that you can verify whether you
         *              received the same string that you sent. This check mitigates
         *              token replay attacks
         *
         * @return The Builder instance for chaining.
         */
        public Builder nonce(String nonce) {
            this.nonce = nonce;
            return this;
        }

        /**
         * @param state A URL-encoded random string. The authorization flow will pass
         *              the same string back to the Callback URL using the
         *              &#x60;&#x60;state&#x60;&#x60; query string parameter. This
         *              process helps ensure that the callback you receive is a response
         *              to what you originally requested. It prevents malicious actors
         *              from forging requests.
         * 
         *              The string can only contain alphanumeric characters, commas,
         *              periods, underscores, and hyphens.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * @param responseMode Specifies how the authorization response should be
         *                     returned. Valid values are:
         * 
         *                     - &#x60;&#x60;fragment&#x60;&#x60; - Encode the response
         *                     parameters in the fragment of the redirect URI. A
         *                     fragment in a URI is the optional part of the URI that
         *                     appears after a &#x60;&#x60;#&#x60;&#x60; symbol, which
         *                     refers to a specific section within a resource. For
         *                     example, &#x60;&#x60;section&#x60;&#x60; in
         *                     &#x60;&#x60;https://www.mysite.org/myresource#section&#x60;&#x60;.
         *                     - &#x60;&#x60;form_post&#x60;&#x60; - Embed the
         *                     authorization response parameter in an HTML form.
         *                     - &#x60;&#x60;query&#x60;&#x60; - Embed the authorization
         *                     response as a query string parameter of the redirect URI.
         * 
         *                     If &#x60;&#x60;id_token&#x60;&#x60; is stated as
         *                     &#x60;&#x60;response_type&#x60;&#x60;, only
         *                     &#x60;&#x60;form_post&#x60;&#x60; is allowed as
         *                     &#x60;&#x60;response_mode&#x60;&#x60;.&#39;
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder responseMode(String responseMode) {
            this.responseMode = responseMode;
            return this;
        }

        /**
         * @param prompt Specifies how to prompt users for authentication. Possible
         *               values are:
         * 
         *               - &#x60;&#x60;login&#x60;&#x60; : Always prompt the user for
         *               authentication, regardless of the state of the login session.
         * 
         *               **Note:** If you do not specify this parameter, the system will
         *               not prompt the user for authentication as long as a login
         *               session is active. If a login session is not active, the system
         *               will prompt the user for authentication.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        /**
         * @param authoptions A JSON object containing options that specify how to
         *                    display the sign-in page. Refer the &#x60;Developer&#39;s
         *                    Guide documentation on AuthOptions
         *                    &lt;/en/docs/oauth/v2/developers_guide/authoptions/&gt;&#x60;_
         *                    for supported values.
         *
         * @return The Builder instance for chaining.
         */
        public Builder authoptions(String authoptions) {
            this.authoptions = authoptions;
            return this;
        }

        /**
         * @param codeChallenge A URL-encoded string derived from the code verifier sent
         *                      in the authorization request with the Proof Key for Code
         *                      Exchange (PKCE) grant flow.
         *
         * @return The Builder instance for chaining.
         */
        public Builder codeChallenge(String codeChallenge) {
            this.codeChallenge = codeChallenge;
            return this;
        }

        /**
         * @param codeChallengeMethod The method used to derive the code challenge for
         *                            the PKCE grant flow. Possible value is:
         * 
         *                            - &#x60;&#x60;S256&#x60;&#x60;- Hashes the code
         *                            verifier using the SHA-256 algorithm and then
         *                            applies Base64 URL encoding.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder codeChallengeMethod(String codeChallengeMethod) {
            this.codeChallengeMethod = codeChallengeMethod;
            return this;
        }

        /**
         * Builds and returns an instance of AuthorizeOptionalParams.
         * 
         * @return AuthorizeOptionalParams object.
         */
        public AuthorizeOptionalParams build() {
            return new AuthorizeOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the nonce value.
     *
     * @return String
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * Gets the state value.
     *
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the responseMode value.
     *
     * @return String
     */
    public String getResponseMode() {
        return responseMode;
    }

    /**
     * Gets the prompt value.
     *
     * @return String
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Gets the authoptions value.
     *
     * @return String
     */
    public String getAuthoptions() {
        return authoptions;
    }

    /**
     * Gets the codeChallenge value.
     *
     * @return String
     */
    public String getCodeChallenge() {
        return codeChallenge;
    }

    /**
     * Gets the codeChallengeMethod value.
     *
     * @return String
     */
    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }
}
