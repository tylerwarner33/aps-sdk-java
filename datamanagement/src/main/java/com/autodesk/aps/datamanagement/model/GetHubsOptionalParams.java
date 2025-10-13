/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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
package com.autodesk.aps.datamanagement.model;

import java.util.List;

/**
 * Represents optional parameters for the `getHubs` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */
public class GetHubsOptionalParams {
    private String xUserId;
    private List<String> filterId;
    private List<String> filterName;
    private List<String> filterExtensionType;
    private String accessToken;

    private GetHubsOptionalParams(Builder builder) {
        this.xUserId = builder.xUserId;
        this.filterId = builder.filterId;
        this.filterName = builder.filterName;
        this.filterExtensionType = builder.filterExtensionType;
        this.accessToken = builder.accessToken;
    }

    /**
     * Builder class for constructing instances of GetHubsOptionalParams.
     */
    public static class Builder {
        private String xUserId;
        private List<String> filterId;
        private List<String> filterName;
        private List<String> filterExtensionType;
        private String accessToken;

        /**
         * @param xUserId In a two-legged authentication context, an app has access to
         *                all users specified by the administrator in the SaaS
         *                integrations UI. By providing this header, the API call will
         *                be limited to act only on behalf of the specified user.
         *
         * @return The Builder instance for chaining.
         */
        public Builder xUserId(String xUserId) {
            this.xUserId = xUserId;
            return this;
        }

        /**
         * @param filterId Filter by the &#x60;&#x60;id&#x60;&#x60; of the
         *                 &#x60;&#x60;ref&#x60;&#x60; target.
         *
         * @return The Builder instance for chaining.
         */
        public Builder filterId(List<String> filterId) {
            this.filterId = filterId;
            return this;
        }

        /**
         * @param filterName Filter by the &#x60;&#x60;name&#x60;&#x60; of the
         *                   &#x60;&#x60;ref&#x60;&#x60; target.
         *
         * @return The Builder instance for chaining.
         */
        public Builder filterName(List<String> filterName) {
            this.filterName = filterName;
            return this;
        }

        /**
         * @param filterExtensionType Filter by the extension type.
         * 
         *
         * @return The Builder instance for chaining.
         */
        public Builder filterExtensionType(List<String> filterExtensionType) {
            this.filterExtensionType = filterExtensionType;
            return this;
        }

        /**
         * @param accessToken The access token string.
         *
         * @return The Builder instance for chaining.
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Builds and returns an instance of GetHubsOptionalParams.
         * 
         * @return GetHubsOptionalParams object.
         */
        public GetHubsOptionalParams build() {
            return new GetHubsOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the xUserId value.
     *
     * @return String
     */
    public String getXUserId() {
        return xUserId;
    }

    /**
     * Gets the filterId value.
     *
     * @return List&lt;String&gt;
     */
    public List<String> getFilterId() {
        return filterId;
    }

    /**
     * Gets the filterName value.
     *
     * @return List&lt;String&gt;
     */
    public List<String> getFilterName() {
        return filterName;
    }

    /**
     * Gets the filterExtensionType value.
     *
     * @return List&lt;String&gt;
     */
    public List<String> getFilterExtensionType() {
        return filterExtensionType;
    }

    /**
     * Gets the access token for authentication.
     *
     * @return String.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token for authentication.
     * 
     * @param accessToken The access token string.
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
