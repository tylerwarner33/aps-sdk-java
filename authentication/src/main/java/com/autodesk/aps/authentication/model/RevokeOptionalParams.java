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
 * Represents optional parameters for the `revoke` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class RevokeOptionalParams {
    private String clientSecret;
    private RevokeOptionalParams(Builder builder) {
        this.clientSecret = builder.clientSecret    ;
    }

    /**
     * Builder class for constructing instances of RevokeOptionalParams.
     */
    public static class Builder {
        private String clientSecret;


        /**
         * @param authorization Must be &#x60;&#x60;Bearer
         *                      &lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; where
         *                      &#x60;&#x60;&lt;BASE64_ENCODED_STRING&gt;&#x60;&#x60; is
         *                      the Base64 encoding of the concatenated string
         *                      &#x60;&#x60;&lt;CLIENT_ID&gt;:&lt;CLIENT_SECRET&gt;&#x60;&#x60;.&#39;
         * 
         *                      **Note** This header is required only for Traditional
         *                      Web Apps and Server-to-Server Apps. It is not required
         *                      for Desktop, Mobile, and Single-Page Apps.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }


        /**
         * Builds and returns an instance of RevokeOptionalParams.
         * 
         * @return RevokeOptionalParams object.
         */
        public RevokeOptionalParams build() {
            return new RevokeOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the authorization value.
     *
     * @return String
     */
    public String getClientSecret() {
        return clientSecret;
    }

}
