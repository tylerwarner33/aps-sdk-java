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
 * Represents optional parameters for the `fetchToken` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class ThreeLeggedOptionalParams {
    private String codeVerifier;

    private String clientSecret;

    private ThreeLeggedOptionalParams(Builder builder) {
        this.codeVerifier = builder.codeVerifier;
        this.clientSecret = builder.clientSecret;
    }

    /**
     * Builder class for constructing instances of ThreeLeggedOptionalParams.
     */
    public static class Builder {
        private String codeVerifier;
        private String clientSecret;

        /**
         * @param codeVerifier A random URL-encoded string between 43 characters and 128
         *                     characters. In a PKCE grant flow, the authentication
         *                     server uses this string to verify the code challenge that
         *                     was passed when you called &#x60;Authorize User
         *                     &lt;/en/docs/oauth/v2/reference/http/authorize-GET/&gt;&#x60;_.
         *                     Required if &#x60;&#x60;grant_type&#x60;&#x60; is
         *                     &#x60;authorization_code&#x60; and
         *                     &#x60;&#x60;code_challenge&#x60;&#x60; was specified when
         *                     you called &#x60;Authorize User
         *                     &lt;/en/docs/oauth/v2/reference/http/authorize-GET/&gt;&#x60;_.
         *
         * @return The Builder instance for chaining.
         */
        public Builder codeVerifier(String codeVerifier) {
            this.codeVerifier = codeVerifier;
            return this;
        }


        /**
         * @param clientSecret The Client ID of the application making the request. **Note**
         *                 This is required only for Traditional Web Apps and
         *                 Server-to-Server Apps. It is not required for Desktop,
         *                 Mobile, and Single-Page Apps.
         *
         * @return The Builder instance for chaining.
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        /**
         * Builds and returns an instance of FetchTokenOptionalParams.
         * 
         * @return FetchTokenOptionalParams object.
         */
        public ThreeLeggedOptionalParams build() {
            return new ThreeLeggedOptionalParams(this);
        }
    }
    /**
     * Gets the codeVerifier value.
     *
     * @return String
     */
    public String getCodeVerifier() {
        return codeVerifier;
    }

    /**
     * Gets the clientSecret value.
     *
     * @return String
     */
    public String getClientSecret() {
        return clientSecret;
    }
}
