/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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
package com.autodesk.aps.webhooks;

import org.apache.hc.core5.http.ClassicHttpResponse;

import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.BaseClient;
import com.autodesk.aps.sdkmanager.IAuthenticationProvider;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;
import com.autodesk.aps.webhooks.api.HooksApi;
import com.autodesk.aps.webhooks.api.TokensApi;
import com.autodesk.aps.webhooks.model.CreateSystemEventHookOptionalParams;
import com.autodesk.aps.webhooks.model.CreateSystemHookOptionalParams;
import com.autodesk.aps.webhooks.model.CreateTokenOptionalParams;
import com.autodesk.aps.webhooks.model.DeleteSystemEventHookOptionalParams;
import com.autodesk.aps.webhooks.model.DeleteTokenOptionalParams;
import com.autodesk.aps.webhooks.model.Events;
import com.autodesk.aps.webhooks.model.GetAppHooksOptionalParams;
import com.autodesk.aps.webhooks.model.GetHookDetailsOptionalParams;
import com.autodesk.aps.webhooks.model.GetHooksOptionalParams;
import com.autodesk.aps.webhooks.model.GetSystemEventHooksOptionalParams;
import com.autodesk.aps.webhooks.model.GetSystemHooksOptionalParams;
import com.autodesk.aps.webhooks.model.Hook;
import com.autodesk.aps.webhooks.model.HookDetails;
import com.autodesk.aps.webhooks.model.HookPayload;
import com.autodesk.aps.webhooks.model.Hooks;
import com.autodesk.aps.webhooks.model.ModifyHookPayload;
import com.autodesk.aps.webhooks.model.PatchSystemEventHookOptionalParams;
import com.autodesk.aps.webhooks.model.PutTokenOptionalParams;
import com.autodesk.aps.webhooks.model.Systems;
import com.autodesk.aps.webhooks.model.Token;
import com.autodesk.aps.webhooks.model.TokenPayload;
import com.autodesk.aps.webhooks.utilities.Utils;

public class WebhooksClient extends BaseClient {
    private final TokensApi tokensApi;
    private final HooksApi hooksApi;

    /**
     * Initializes a new instance of the WebhooksClient class.
     * 
     * @param sdkManager             The SDK manager instance.
     * @param authenticationProvider The authentication provider.
     */
    public WebhooksClient(SdkManager sdkManager, IAuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
        if (sdkManager == null) {
            sdkManager = SdkManagerBuilder.create().build();
        }
        this.tokensApi = new TokensApi(sdkManager);
        this.hooksApi = new HooksApi(sdkManager);

    }

    /**
     * Initializes a new instance of the WebhooksClient class with a default
     * SDK manager.
     * 
     * @param authenticationProvider The authentication provider.
     */
    public WebhooksClient(IAuthenticationProvider authenticationProvider) {
        this(SdkManagerBuilder.create().build(), authenticationProvider);
    }

    /**
     * Initializes a new instance of the WebhooksClient class without an
     * authentication provider.
     * 
     * @param sdkManager
     */

    public WebhooksClient(SdkManager sdkManager) {
        this(sdkManager, null);
    }

    /**
     * Initializes a new instance of the WebhooksClient class with a default
     * SDK manager and without an authentication provider.
     */
    public WebhooksClient() {
        this(SdkManagerBuilder.create().build(), null);
    }

    /**
     * Closes the underlying connection.
     */
    public void close() {
        this.hooksApi.close();
    }

    /**
     * Create a Webhook for an Event
     * Adds a new webhook to receive notifications of the occurrence of a specified
     * event for the specified system.
     * 
     * @param system      The ID of the system the webhook applies to. For example
     *                    data for Data Management. See [Supported
     *                    Events](/en/docs/webhooks/v1/reference/events/) for a full
     *                    list of supported systems and their IDs. (required)
     * @param event       The ID of the event the webhook monitors. See [Supported
     *                    Events](/en/docs/webhooks/v1/reference/events/) for a full
     *                    list of events. (required)
     * @param hookPayload (required)
     * @throws WebhooksApiException when an API call fails.
     */

    public ApiResponse<ClassicHttpResponse> createSystemEventHook(Systems system, Events event, HookPayload hookPayload)
            throws WebhooksApiException {
        return createSystemEventHook(system, event, hookPayload, null);
    }

    /**
     * Create a Webhook for an Event
     * Adds a new webhook to receive notifications of the occurrence of a specified
     * event for the specified system.
     * 
     * @param system                              The ID of the system the webhook
     *                                            applies to. For example data for
     *                                            Data Management. See [Supported
     *                                            Events](/en/docs/webhooks/v1/reference/events/)
     *                                            for a full list of supported
     *                                            systems and their IDs. (required)
     * @param event                               The ID of the event the webhook
     *                                            monitors. See [Supported
     *                                            Events](/en/docs/webhooks/v1/reference/events/)
     *                                            for a full list of events.
     *                                            (required)
     * @param hookPayload                         (required)
     * @param createSystemEventHookOptionalParams class containing all optional
     *                                            parameters for the
     *                                            createSystemEventHook method.
     * @throws WebhooksApiException when an API call fails.
     */

    public ApiResponse<ClassicHttpResponse> createSystemEventHook(Systems system, Events event, HookPayload hookPayload,
            CreateSystemEventHookOptionalParams createSystemEventHookOptionalParams) throws WebhooksApiException {
        try {
            if (createSystemEventHookOptionalParams == null) {
                createSystemEventHookOptionalParams = new CreateSystemEventHookOptionalParams.Builder().build();
            }
            if (createSystemEventHookOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (createSystemEventHookOptionalParams.getAccessToken() == null) {
                createSystemEventHookOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            String eventString = Utils.getEnumString(event);
            return hooksApi.createSystemEventHook(sytemString, eventString, hookPayload,
                    createSystemEventHookOptionalParams.getRegion(),
                    createSystemEventHookOptionalParams.getXAdsRegion(),
                    createSystemEventHookOptionalParams.getAccessToken());
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Create Webhooks for All Events
     * Adds a new webhook to receive notifications of all events for the specified
     * system.
     * 
     * @param system      The ID of the system the webhook applies to. For example
     *                    data for Data Management. See [Supported
     *                    Events](/en/docs/webhooks/v1/reference/events/) for a full
     *                    list of supported systems and their IDs. (required)
     * @param hookPayload (required)
     * @return Hook
     * @throws WebhooksApiException when an API call fails.
     */

    public Hook createSystemHook(Systems system, HookPayload hookPayload) throws WebhooksApiException {
        return createSystemHook(system, hookPayload, null);
    }

    /**
     * Create Webhooks for All Events
     * Adds a new webhook to receive notifications of all events for the specified
     * system.
     * 
     * @param system                         The ID of the system the webhook
     *                                       applies
     *                                       to. For example data for Data
     *                                       Management. See [Supported
     *                                       Events](/en/docs/webhooks/v1/reference/events/)
     *                                       for a full list of supported systems
     *                                       and
     *                                       their IDs. (required)
     * @param hookPayload                    (required)
     * @param createSystemHookOptionalParams class containing all optional
     *                                       parameters
     *                                       for the createSystemHook method.
     * @return Hook
     * @throws WebhooksApiException when an API call fails.
     */

    public Hook createSystemHook(Systems system, HookPayload hookPayload,
            CreateSystemHookOptionalParams createSystemHookOptionalParams) throws WebhooksApiException {
        try {
            if (createSystemHookOptionalParams == null) {
                createSystemHookOptionalParams = new CreateSystemHookOptionalParams.Builder().build();
            }
            if (createSystemHookOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (createSystemHookOptionalParams.getAccessToken() == null) {
                createSystemHookOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            return hooksApi
                    .createSystemHook(sytemString, hookPayload, createSystemHookOptionalParams.getXAdsRegion(),
                            createSystemHookOptionalParams.getRegion(), createSystemHookOptionalParams.getAccessToken())
                    .getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Create Secret Token
     * Sets a secret token to verify the authenticity of webhook payloads.
     * 
     * When a webhook event occurs, the service calculates a hash signature using
     * the token and includes it in the event notification. The receiving
     * application listening at the callback URL can verify the payload&#39;s
     * integrity by comparing the calculated signature to the one received.
     * 
     * The webhooks affected by this operation are determined by the type of access
     * token you use.
     * 
     * - Two-legged Access Token: Sets the secret token for all webhooks owned by
     * calling the app.
     * - Three-legged Access Token: Sets the secret token for all webhooks owned by
     * the calling user
     * 
     * **Note:** Use the [Update Webhook
     * operation](/en/docs/webhooks/v1/reference/http/webhooks/systems-system-events-event-hooks-hook_id-PATCH/)
     * to set a token for a specific webhook.
     * 
     * 
     * See the [Secret
     * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
     * API Basics for more information.
     * 
     * @param tokenPayload The request payload for a Create Secret request
     *                     (required)
     * @return Token
     * @throws WebhooksApiException when an API call fails.
     */

    public Token createToken(TokenPayload tokenPayload) throws WebhooksApiException {
        return createToken(tokenPayload, null);
    }

    /**
     * Create Secret Token
     * Sets a secret token to verify the authenticity of webhook payloads.
     * 
     * When a webhook event occurs, the service calculates a hash signature using
     * the token and includes it in the event notification. The receiving
     * application listening at the callback URL can verify the payload&#39;s
     * integrity by comparing the calculated signature to the one received.
     * 
     * The webhooks affected by this operation are determined by the type of access
     * token you use.
     * 
     * - Two-legged Access Token: Sets the secret token for all webhooks owned by
     * calling the app.
     * - Three-legged Access Token: Sets the secret token for all webhooks owned by
     * the calling user
     * 
     * **Note:** Use the [Update Webhook
     * operation](/en/docs/webhooks/v1/reference/http/webhooks/systems-system-events-event-hooks-hook_id-PATCH/)
     * to set a token for a specific webhook.
     * 
     * 
     * See the [Secret
     * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
     * API Basics for more information.
     * 
     * @param tokenPayload              The request payload for a Create Secret
     *                                  request (required)
     * @param createTokenOptionalParams class containing all optional parameters for
     *                                  the createToken method.
     * @return Token
     * @throws WebhooksApiException when an API call fails.
     */

    public Token createToken(TokenPayload tokenPayload, CreateTokenOptionalParams createTokenOptionalParams)
            throws WebhooksApiException {
        try {
            if (createTokenOptionalParams == null) {
                createTokenOptionalParams = new CreateTokenOptionalParams.Builder().build();
            }
            if (createTokenOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (createTokenOptionalParams.getAccessToken() == null) {
                createTokenOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return tokensApi
                    .createToken(tokenPayload, createTokenOptionalParams.getXAdsRegion(),
                            createTokenOptionalParams.getRegion(), createTokenOptionalParams.getAccessToken())
                    .getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Delete a Webhook
     * Deletes the webhook specified by its ID.
     * 
     * @param system The ID of the system the webhook applies to. For example data
     *               for Data Management. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of supported systems and their IDs. (required)
     * @param event  The ID of the event the webhook monitors. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of events. (required)
     * @param hookId The ID of the webhook to delete. (required)
     * @throws WebhooksApiException when an API call fails.
     */

    public void deleteSystemEventHook(Systems system, Events event, String hookId) throws WebhooksApiException {
        deleteSystemEventHook(system, event, hookId, null);
    }

    /**
     * Delete a Webhook
     * Deletes the webhook specified by its ID.
     * 
     * @param system                              The ID of the system the webhook
     *                                            applies to. For example data for
     *                                            Data Management. See [Supported
     *                                            Events](/en/docs/webhooks/v1/reference/events/)
     *                                            for a full list of supported
     *                                            systems and their IDs. (required)
     * @param event                               The ID of the event the webhook
     *                                            monitors. See [Supported
     *                                            Events](/en/docs/webhooks/v1/reference/events/)
     *                                            for a full list of events.
     *                                            (required)
     * @param hookId                              The ID of the webhook to delete.
     *                                            (required)
     * @param deleteSystemEventHookOptionalParams class containing all optional
     *                                            parameters for the
     *                                            deleteSystemEventHook method.
     * @throws WebhooksApiException when an API call fails.
     */

    public void deleteSystemEventHook(Systems system, Events event, String hookId,
            DeleteSystemEventHookOptionalParams deleteSystemEventHookOptionalParams) throws WebhooksApiException {
        try {
            if (deleteSystemEventHookOptionalParams == null) {
                deleteSystemEventHookOptionalParams = new DeleteSystemEventHookOptionalParams.Builder().build();
            }
            if (deleteSystemEventHookOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (deleteSystemEventHookOptionalParams.getAccessToken() == null) {
                deleteSystemEventHookOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            String eventString = Utils.getEnumString(event);
            hooksApi.deleteSystemEventHook(sytemString, eventString, hookId,
                    deleteSystemEventHookOptionalParams.getXAdsRegion(),
                    deleteSystemEventHookOptionalParams.getRegion(),
                    deleteSystemEventHookOptionalParams.getAccessToken()).getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Delete Secret Token
     * Removes an existing secret token from the webhooks impacted by this
     * operation.
     * 
     * The webhooks affected by this operation are determined by the type of access
     * token you use.
     * 
     * - Two-legged Access Token: Sets the secret token for all webhooks owned by
     * calling the app.
     * - Three-legged Access Token: Sets the secrety token for all webhooks owned by
     * the calling user
     * 
     * Note that there can be a delay of up to 10 minutes while the change takes
     * effect. We recommend that your callback accept both secret token values for a
     * period of time to allow all requests to go through.
     * 
     * See the [Secret
     * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
     * API Basics for more information.
     * 
     * @throws WebhooksApiException when an API call fails.
     */

    public void deleteToken() throws WebhooksApiException {
        deleteToken(null);
    }

    /**
     * Delete Secret Token
     * Removes an existing secret token from the webhooks impacted by this
     * operation.
     * 
     * The webhooks affected by this operation are determined by the type of access
     * token you use.
     * 
     * - Two-legged Access Token: Sets the secret token for all webhooks owned by
     * calling the app.
     * - Three-legged Access Token: Sets the secrety token for all webhooks owned by
     * the calling user
     * 
     * Note that there can be a delay of up to 10 minutes while the change takes
     * effect. We recommend that your callback accept both secret token values for a
     * period of time to allow all requests to go through.
     * 
     * See the [Secret
     * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
     * API Basics for more information.
     * 
     * @param deleteTokenOptionalParams class containing all optional parameters for
     *                                  the deleteToken method.
     * @throws WebhooksApiException when an API call fails.
     */

    public void deleteToken(DeleteTokenOptionalParams deleteTokenOptionalParams) throws WebhooksApiException {
        try {
            if (deleteTokenOptionalParams == null) {
                deleteTokenOptionalParams = new DeleteTokenOptionalParams.Builder().build();
            }
            if (deleteTokenOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (deleteTokenOptionalParams.getAccessToken() == null) {
                deleteTokenOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            tokensApi.deleteToken(deleteTokenOptionalParams.getXAdsRegion(), deleteTokenOptionalParams.getRegion(),
                    deleteTokenOptionalParams.getAccessToken()).getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * List All Webhooks for an App
     * Retrieves a paginated list of webhooks created by the calling application.
     * Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * **Note:** This operation requires an access token through a Client
     * Credentials flow (two-legged OAuth).
     * 
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getAppHooks() throws WebhooksApiException {
        return getAppHooks(null);
    }

    /**
     * List All Webhooks for an App
     * Retrieves a paginated list of webhooks created by the calling application.
     * Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * **Note:** This operation requires an access token through a Client
     * Credentials flow (two-legged OAuth).
     * 
     * @param getAppHooksOptionalParams class containing all optional parameters for
     *                                  the getAppHooks method.
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getAppHooks(GetAppHooksOptionalParams getAppHooksOptionalParams) throws WebhooksApiException {
        try {
            if (getAppHooksOptionalParams == null) {
                getAppHooksOptionalParams = new GetAppHooksOptionalParams.Builder().build();
            }
            if (getAppHooksOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (getAppHooksOptionalParams.getAccessToken() == null) {
                getAppHooksOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return hooksApi
                    .getAppHooks(getAppHooksOptionalParams.getXAdsRegion(), getAppHooksOptionalParams.getPageState(),
                            getAppHooksOptionalParams.getStatus(), getAppHooksOptionalParams.getSort(),
                            getAppHooksOptionalParams.getRegion(), getAppHooksOptionalParams.getAccessToken())
                    .getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Get Webhook Details
     * Retrieves the details of the webhook for the specified event within the
     * specified system.
     * 
     * @param system The ID of the system the webhook applies to. For example data
     *               for Data Management. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of supported systems and their IDs. (required)
     * @param event  The ID of the event the webhook monitors. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of events. (required)
     * @param hookId The ID of the webhook to delete. (required)
     * @return HookDetails
     * @throws WebhooksApiException when an API call fails.
     */

    public HookDetails getHookDetails(Systems system, Events event, String hookId) throws WebhooksApiException {
        return getHookDetails(system, event, hookId, null);
    }

    /**
     * Get Webhook Details
     * Retrieves the details of the webhook for the specified event within the
     * specified system.
     * 
     * @param system                       The ID of the system the webhook applies
     *                                     to. For example data for Data Management.
     *                                     See [Supported
     *                                     Events](/en/docs/webhooks/v1/reference/events/)
     *                                     for a full list of supported systems and
     *                                     their IDs. (required)
     * @param event                        The ID of the event the webhook monitors.
     *                                     See [Supported
     *                                     Events](/en/docs/webhooks/v1/reference/events/)
     *                                     for a full list of events. (required)
     * @param hookId                       The ID of the webhook to delete.
     *                                     (required)
     * @param getHookDetailsOptionalParams class containing all optional parameters
     *                                     for the getHookDetails method.
     * @return HookDetails
     * @throws WebhooksApiException when an API call fails.
     */

    public HookDetails getHookDetails(Systems system, Events event, String hookId,
            GetHookDetailsOptionalParams getHookDetailsOptionalParams) throws WebhooksApiException {
        try {
            if (getHookDetailsOptionalParams == null) {
                getHookDetailsOptionalParams = new GetHookDetailsOptionalParams.Builder().build();
            }
            if (getHookDetailsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (getHookDetailsOptionalParams.getAccessToken() == null) {
                getHookDetailsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            String eventString = Utils.getEnumString(event);
            return hooksApi
                    .getHookDetails(sytemString, eventString, hookId, getHookDetailsOptionalParams.getXAdsRegion(),
                            getHookDetailsOptionalParams.getRegion(), getHookDetailsOptionalParams.getAccessToken())
                    .getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * List All Webhooks
     * Retrieves a paginated list of webhooks available to the provided access token
     * within the specified region. Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getHooks() throws WebhooksApiException {
        return getHooks(null);
    }

    /**
     * List All Webhooks
     * Retrieves a paginated list of webhooks available to the provided access token
     * within the specified region. Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * @param getHooksOptionalParams class containing all optional parameters for
     *                               the
     *                               getHooks method.
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getHooks(GetHooksOptionalParams getHooksOptionalParams) throws WebhooksApiException {
        try {
            if (getHooksOptionalParams == null) {
                getHooksOptionalParams = new GetHooksOptionalParams.Builder().build();
            }
            if (getHooksOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (getHooksOptionalParams.getAccessToken() == null) {
                getHooksOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return hooksApi.getHooks(getHooksOptionalParams.getPageState(), getHooksOptionalParams.getStatus(),
                    getHooksOptionalParams.getRegion(), getHooksOptionalParams.getXAdsRegion(),
                    getHooksOptionalParams.getAccessToken()).getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * List All Webhooks for an Event
     * Retrieves a paginated list of webhooks for the specified event. The returned
     * list contains a subset of webhooks accessible to the provided access token
     * within the specified region. Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * @param system The ID of the system the webhook applies to. For example data
     *               for Data Management. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of supported systems and their IDs. (required)
     * @param event  The ID of the event the webhook monitors. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of events. (required)
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getSystemEventHooks(Systems system, Events event) throws WebhooksApiException {
        return getSystemEventHooks(system, event, null);
    }

    /**
     * List All Webhooks for an Event
     * Retrieves a paginated list of webhooks for the specified event. The returned
     * list contains a subset of webhooks accessible to the provided access token
     * within the specified region. Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * @param system                            The ID of the system the webhook
     *                                          applies to. For example data for
     *                                          Data
     *                                          Management. See [Supported
     *                                          Events](/en/docs/webhooks/v1/reference/events/)
     *                                          for a full list of supported systems
     *                                          and their IDs. (required)
     * @param event                             The ID of the event the webhook
     *                                          monitors. See [Supported
     *                                          Events](/en/docs/webhooks/v1/reference/events/)
     *                                          for a full list of events.
     *                                          (required)
     * @param getSystemEventHooksOptionalParams class containing all optional
     *                                          parameters for the
     *                                          getSystemEventHooks method.
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getSystemEventHooks(Systems system, Events event,
            GetSystemEventHooksOptionalParams getSystemEventHooksOptionalParams) throws WebhooksApiException {
        try {
            if (getSystemEventHooksOptionalParams == null) {
                getSystemEventHooksOptionalParams = new GetSystemEventHooksOptionalParams.Builder().build();
            }
            if (getSystemEventHooksOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (getSystemEventHooksOptionalParams.getAccessToken() == null) {
                getSystemEventHooksOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            String eventString = Utils.getEnumString(event);
            return hooksApi.getSystemEventHooks(sytemString, eventString,
                    getSystemEventHooksOptionalParams.getXAdsRegion(), getSystemEventHooksOptionalParams.getRegion(),
                    getSystemEventHooksOptionalParams.getScopeName(), getSystemEventHooksOptionalParams.getPageState(),
                    getSystemEventHooksOptionalParams.getStatus(), getSystemEventHooksOptionalParams.getAccessToken())
                    .getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * List All Webhooks for a System
     * Retrieves a paginated list of webhooks for the specified system. The returned
     * list contains a subset of webhooks accessible to the provided access token
     * within the specified region. Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * @param system The ID of the system the webhook applies to. For example data
     *               for Data Management. See [Supported
     *               Events](/en/docs/webhooks/v1/reference/events/) for a full list
     *               of supported systems and their IDs. (required)
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getSystemHooks(Systems system) throws WebhooksApiException {
        return getSystemHooks(system, null);
    }

    /**
     * List All Webhooks for a System
     * Retrieves a paginated list of webhooks for the specified system. The returned
     * list contains a subset of webhooks accessible to the provided access token
     * within the specified region. Each page includes up to 200 webhooks.
     * 
     * If the &#x60;&#x60;pageState&#x60;&#x60; query string parameter is not
     * provided, the first page of results is returned. Use the
     * &#x60;&#x60;next&#x60;&#x60; value from the previous response to fetch
     * subsequent pages.
     * 
     * @param system                       The ID of the system the webhook applies
     *                                     to. For example data for Data Management.
     *                                     See [Supported
     *                                     Events](/en/docs/webhooks/v1/reference/events/)
     *                                     for a full list of supported systems and
     *                                     their IDs. (required)
     * @param getSystemHooksOptionalParams class containing all optional parameters
     *                                     for the getSystemHooks method.
     * @return Hooks
     * @throws WebhooksApiException when an API call fails.
     */

    public Hooks getSystemHooks(Systems system, GetSystemHooksOptionalParams getSystemHooksOptionalParams)
            throws WebhooksApiException {
        try {
            if (getSystemHooksOptionalParams == null) {
                getSystemHooksOptionalParams = new GetSystemHooksOptionalParams.Builder().build();
            }
            if (getSystemHooksOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (getSystemHooksOptionalParams.getAccessToken() == null) {
                getSystemHooksOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            return hooksApi
                    .getSystemHooks(sytemString, getSystemHooksOptionalParams.getXAdsRegion(),
                            getSystemHooksOptionalParams.getStatus(), getSystemHooksOptionalParams.getPageState(),
                            getSystemHooksOptionalParams.getRegion(), getSystemHooksOptionalParams.getAccessToken())
                    .getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Update a Webhook
     * Updates the webhook specified by the &#x60;&#x60;hook_id&#x60;&#x60;
     * parameter. Currently the only attributes you can update are:
     * 
     * - filter
     * - status
     * - hook attribute
     * - token
     * - auto-reactivate hook flag
     * - hook expiry
     * - callbackWithEventPaylaod flag
     * 
     * See the request body documentation for more information.
     * 
     * @param system            The ID of the system the webhook applies to. For
     *                          example data for Data Management. See [Supported
     *                          Events](/en/docs/webhooks/v1/reference/events/) for
     *                          a full list of supported systems and their IDs.
     *                          (required)
     * @param event             The ID of the event the webhook monitors. See
     *                          [Supported
     *                          Events](/en/docs/webhooks/v1/reference/events/) for
     *                          a full list of events. (required)
     * @param hookId            The ID of the webhook to delete. (required)
     * @param modifyHookPayload (required)
     * @throws WebhooksApiException when an API call fails.
     */

    public void patchSystemEventHook(Systems system, Events event, String hookId, ModifyHookPayload modifyHookPayload)
            throws WebhooksApiException {
        patchSystemEventHook(system, event, hookId, modifyHookPayload, null);
    }

    /**
     * Update a Webhook
     * Updates the webhook specified by the &#x60;&#x60;hook_id&#x60;&#x60;
     * parameter. Currently the only attributes you can update are:
     * 
     * - filter
     * - status
     * - hook attribute
     * - token
     * - auto-reactivate hook flag
     * - hook expiry
     * - callbackWithEventPaylaod flag
     * 
     * See the request body documentation for more information.
     * 
     * @param system                             The ID of the system the webhook
     *                                           applies to. For example data for
     *                                           Data Management. See [Supported
     *                                           Events](/en/docs/webhooks/v1/reference/events/)
     *                                           for a full list of supported
     *                                           systems
     *                                           and their IDs. (required)
     * @param event                              The ID of the event the webhook
     *                                           monitors. See [Supported
     *                                           Events](/en/docs/webhooks/v1/reference/events/)
     *                                           for a full list of events.
     *                                           (required)
     * @param hookId                             The ID of the webhook to delete.
     *                                           (required)
     * @param modifyHookPayload                  (required)
     * @param patchSystemEventHookOptionalParams class containing all optional
     *                                           parameters for the
     *                                           patchSystemEventHook method.
     * @throws WebhooksApiException when an API call fails.
     */

    public void patchSystemEventHook(Systems system, Events event, String hookId, ModifyHookPayload modifyHookPayload,
            PatchSystemEventHookOptionalParams patchSystemEventHookOptionalParams) throws WebhooksApiException {
        try {
            if (patchSystemEventHookOptionalParams == null) {
                patchSystemEventHookOptionalParams = new PatchSystemEventHookOptionalParams.Builder().build();
            }
            if (patchSystemEventHookOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (patchSystemEventHookOptionalParams.getAccessToken() == null) {
                patchSystemEventHookOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            String sytemString = Utils.getEnumString(system);
            String eventString = Utils.getEnumString(event);
            hooksApi.patchSystemEventHook(sytemString, eventString, hookId, modifyHookPayload,
                    patchSystemEventHookOptionalParams.getXAdsRegion(), patchSystemEventHookOptionalParams.getRegion(),
                    patchSystemEventHookOptionalParams.getAccessToken()).getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

    /**
     * Update Secret Token
     * Replaces an existing secret token with a new one.
     * 
     * Note that there can be a delay of up to 10 minutes while the change takes
     * effect. We recommend that your callback accept both secret token values for a
     * period of time to allow all requests to go through.
     * 
     * The webhooks affected by this operation are determined by the type of access
     * token you use.
     * 
     * - Two-legged Access Token: Sets the secret token for all webhooks owned by
     * calling the app.
     * - Three-legged Access Token: Sets the secrety token for all webhooks owned by
     * the calling user
     * 
     * **Note:** Use the [Update Webhook
     * operation](/en/docs/webhooks/v1/reference/http/webhooks/systems-system-events-event-hooks-hook_id-PATCH/)
     * to set a token for a specific webhook.
     * 
     * 
     * See the [Secret
     * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
     * API Basics for more information.
     * 
     * @param tokenPayload (required)
     * @throws WebhooksApiException when an API call fails.
     */

    public void putToken(TokenPayload tokenPayload) throws WebhooksApiException {
        putToken(tokenPayload, null);
    }

    /**
     * Update Secret Token
     * Replaces an existing secret token with a new one.
     * 
     * Note that there can be a delay of up to 10 minutes while the change takes
     * effect. We recommend that your callback accept both secret token values for a
     * period of time to allow all requests to go through.
     * 
     * The webhooks affected by this operation are determined by the type of access
     * token you use.
     * 
     * - Two-legged Access Token: Sets the secret token for all webhooks owned by
     * calling the app.
     * - Three-legged Access Token: Sets the secrety token for all webhooks owned by
     * the calling user
     * 
     * **Note:** Use the [Update Webhook
     * operation](/en/docs/webhooks/v1/reference/http/webhooks/systems-system-events-event-hooks-hook_id-PATCH/)
     * to set a token for a specific webhook.
     * 
     * 
     * See the [Secret
     * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
     * API Basics for more information.
     * 
     * @param tokenPayload           (required)
     * @param putTokenOptionalParams class containing all optional parameters for
     *                               the
     *                               putToken method.
     * @throws WebhooksApiException when an API call fails.
     */

    public void putToken(TokenPayload tokenPayload, PutTokenOptionalParams putTokenOptionalParams)
            throws WebhooksApiException {
        try {
            if (putTokenOptionalParams == null) {
                putTokenOptionalParams = new PutTokenOptionalParams.Builder().build();
            }
            if (putTokenOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new WebhooksApiException("Please provide a valid access token!");
            } else if (putTokenOptionalParams.getAccessToken() == null) {
                putTokenOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            tokensApi.putToken(tokenPayload, putTokenOptionalParams.getXAdsRegion(), putTokenOptionalParams.getRegion(),
                    putTokenOptionalParams.getAccessToken()).getData();
        } catch (WebhooksApiException e) {
            throw e;
        } catch (Exception e) {
            throw new WebhooksApiException(e);
        }
    }

}