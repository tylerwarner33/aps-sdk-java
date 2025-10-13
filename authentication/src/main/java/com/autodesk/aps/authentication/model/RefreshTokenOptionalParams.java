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
public class RefreshTokenOptionalParams {
    private Scopes[] scopes;
    private String clientSecret;

    private RefreshTokenOptionalParams(Builder builder) {
        this.scopes = builder.scopes;
        this.clientSecret = builder.clientSecret;
    }

    /**
     * Builder class for constructing instances of RefreshTokenOptionalParams.
     */
    public static class Builder {
        private Scopes[] scopes;
        private String clientSecret;

        public Builder scopes(Scopes[] scopes) {
            this.scopes = scopes;
            return this;
        }

        /**
         * @param clientSecret The Client ID of the application making the request.
         *                     **Note**
         *                     This is required only for Traditional Web Apps and
         *                     Server-to-Server Apps. It is not required for Desktop,
         *                     Mobile, and Single-Page Apps.
         *
         * @return The Builder instance for chaining.
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        /**
         * Builds and returns an instance of RefreshTokenOptionalParams.
         * 
         * @return RefreshTokenOptionalParams object.
         */
        public RefreshTokenOptionalParams build() {
            return new RefreshTokenOptionalParams(this);
        }
    }
    /**
     * Gets the scope value.
     *
     * @return Scopes
     */
    public Scopes[] getScopes() {
        return scopes;
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
