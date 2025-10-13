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

package com.autodesk.aps.webhooks.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Specifies the details of a webhook to be created.
 */
@Schema(description = "Specifies the details of a webhook to be created. ")
@JsonPropertyOrder({
    HookPayload.JSON_PROPERTY_CALLBACK_URL,
    HookPayload.JSON_PROPERTY_AUTO_REACTIVATE_HOOK,
    HookPayload.JSON_PROPERTY_SCOPE,
    HookPayload.JSON_PROPERTY_HOOK_ATTRIBUTE,
    HookPayload.JSON_PROPERTY_HOOK_EXPIRY,
    HookPayload.JSON_PROPERTY_FILTER,
    HookPayload.JSON_PROPERTY_HUB_ID,
    HookPayload.JSON_PROPERTY_PROJECT_ID,
    HookPayload.JSON_PROPERTY_TENANT,
    HookPayload.JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY
})
@JsonTypeName("HookPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class HookPayload {
  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";
  private String callbackUrl;

  public static final String JSON_PROPERTY_AUTO_REACTIVATE_HOOK = "autoReactivateHook";
  private Boolean autoReactivateHook;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private Object scope;

  public static final String JSON_PROPERTY_HOOK_ATTRIBUTE = "hookAttribute";
  private Object hookAttribute;

  public static final String JSON_PROPERTY_HOOK_EXPIRY = "hookExpiry";
  private String hookExpiry;

  public static final String JSON_PROPERTY_FILTER = "filter";
  private String filter;

  public static final String JSON_PROPERTY_HUB_ID = "hubId";
  private String hubId;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";
  private String projectId;

  public static final String JSON_PROPERTY_TENANT = "tenant";
  private String tenant;

  public static final String JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY = "callbackWithEventPayloadOnly";
  private Boolean callbackWithEventPayloadOnly;

  public HookPayload callbackUrl(String callbackUrl) {

    this.callbackUrl = callbackUrl;
    return this;
  }

  /**
   * The URL to send notifications to when the
   * event is triggered.
   * 
   * @return callbackUrl
   **/
  @Schema(required = true, description = "The URL to send notifications to when the  event is triggered. ")
  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCallbackUrl() {
    return callbackUrl;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  public HookPayload autoReactivateHook(Boolean autoReactivateHook) {

    this.autoReactivateHook = autoReactivateHook;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; - Automatically reactivate the webhook if it
   * becomes &#x60;&#x60;inactive&#x60;&#x60;.
   * 
   * &#x60;&#x60;false&#x60;&#x60; - (Default) Do not reactivate the webhook if it
   * becomes &#x60;&#x60;inactive&#x60;&#x60;.
   * 
   * See [Event Delivery
   * Guarantees](/en/docs/webhooks/v1/developers_guide/event-delivery-guarantees/)
   * for more information on how the webhooks service handles reactivation.
   * 
   * @return autoReactivateHook
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` - Automatically reactivate the webhook if it becomes ``inactive``.  ``false`` - (Default) Do not reactivate the webhook if it becomes ``inactive``.  See [Event Delivery Guarantees](/en/docs/webhooks/v1/developers_guide/event-delivery-guarantees/) for more information on how the webhooks service handles reactivation.")
  @JsonProperty(JSON_PROPERTY_AUTO_REACTIVATE_HOOK)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getAutoReactivateHook() {
    return autoReactivateHook;
  }

  @JsonProperty(JSON_PROPERTY_AUTO_REACTIVATE_HOOK)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAutoReactivateHook(Boolean autoReactivateHook) {
    this.autoReactivateHook = autoReactivateHook;
  }

  public HookPayload scope(Object scope) {

    this.scope = scope;
    return this;
  }

  /**
   * Specifies the extent to which the event is monitored. For example, if the
   * scope is folder, the webhooks service generates a notification for the
   * specified event occurring in any sub folder or item within that folder.
   * 
   * @return scope
   **/
  @Schema(required = true, description = "Specifies the extent to which the event is monitored. For example, if the scope is folder, the webhooks service generates a notification for the specified event occurring in any sub folder or item within that folder.")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getScope() {
    return scope;
  }

  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setScope(Object scope) {
    this.scope = scope;
  }

  public HookPayload hookAttribute(Object hookAttribute) {

    this.hookAttribute = hookAttribute;
    return this;
  }

  /**
   * Specifies the extent to which the event is monitored. For example, if the
   * scope is folder, the webhooks service generates a notification for the
   * specified event occurring in any sub folder or item within that folder.
   * 
   * @return hookAttribute
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies the extent to which the event is monitored. For example, if the scope is folder, the webhooks service generates a notification for the specified event occurring in any sub folder or item within that folder.")
  @JsonProperty(JSON_PROPERTY_HOOK_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getHookAttribute() {
    return hookAttribute;
  }

  @JsonProperty(JSON_PROPERTY_HOOK_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHookAttribute(Object hookAttribute) {
    this.hookAttribute = hookAttribute;
  }

  public HookPayload hookExpiry(String hookExpiry) {

    this.hookExpiry = hookExpiry;
    return this;
  }

  /**
   * The date and time the webhook will expire, formatted as an ISO 8601 date/time
   * string. If you do not specify this attribute or set it to null, the webhook
   * will never expire.
   * 
   * @return hookExpiry
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time the webhook will expire, formatted as an ISO 8601 date/time string. If you do not specify this attribute or set it to null, the webhook will never expire.")
  @JsonProperty(JSON_PROPERTY_HOOK_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getHookExpiry() {
    return hookExpiry;
  }

  @JsonProperty(JSON_PROPERTY_HOOK_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHookExpiry(String hookExpiry) {
    this.hookExpiry = hookExpiry;
  }

  public HookPayload filter(String filter) {

    this.filter = filter;
    return this;
  }

  /**
   * A Jsonpath expression that you can use to filter the callbacks you receive.
   * 
   * See [Callback
   * Filtering](/en/docs/webhooks/v1/developers_guide/callback-filtering/) for
   * more information.
   * 
   * @return filter
   **/
  @javax.annotation.Nullable
  @Schema(description = "A Jsonpath expression that you can use to filter the callbacks you receive.  See [Callback Filtering](/en/docs/webhooks/v1/developers_guide/callback-filtering/) for more information.")
  @JsonProperty(JSON_PROPERTY_FILTER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getFilter() {
    return filter;
  }

  @JsonProperty(JSON_PROPERTY_FILTER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFilter(String filter) {
    this.filter = filter;
  }

  public HookPayload hubId(String hubId) {

    this.hubId = hubId;
    return this;
  }

  /**
   * The ID of the hub that contains the entity that you want to monitor. Specify
   * this attribute if the user calling this operation is a member of a large
   * number of projects.
   * 
   * For BIM 360 Docs and ACC Docs, a hub ID corresponds to an Account ID. To
   * convert a BIM 360 or ACC Account ID to a hub ID, prefix the Account ID with
   * &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID of
   * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
   * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * @return hubId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the hub that contains the entity that you want to monitor. Specify this attribute if the user calling this operation is a member of a large number of projects.  For BIM 360 Docs and ACC Docs, a hub ID corresponds to an Account ID. To convert a BIM 360 or ACC Account ID to a hub ID, prefix the Account ID with ``b.``. For example, an Account ID of ```c8b0c73d-3ae9``` translates to a hub ID of ``b.c8b0c73d-3ae9``.")
  @JsonProperty(JSON_PROPERTY_HUB_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getHubId() {
    return hubId;
  }

  @JsonProperty(JSON_PROPERTY_HUB_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHubId(String hubId) {
    this.hubId = hubId;
  }

  public HookPayload projectId(String projectId) {

    this.projectId = projectId;
    return this;
  }

  /**
   * The ID of the project that contains the entity that you want to monitor
   * Specify this attribute if the user calling this operation is a member of a
   * large number of projects.
   * 
   * BIM 360 and ACC project IDs are different to Data Management project IDs. To
   * convert a BIM 360 and ACC project IDs to Data Management project IDs, prefix
   * the BIM 360 or ACC Project ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
   * project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project
   * ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
   * 
   * @return projectId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the project that contains the entity that you want to monitor Specify this attribute if the user calling this operation is a member of a large number of projects.  BIM 360 and ACC project IDs are different to Data Management project IDs. To convert a BIM 360 and ACC project IDs to  Data Management project IDs, prefix the BIM 360 or ACC Project ID with ``b.``. For example, a project ID of ``c8b0c73d-3ae9`` translates to a project ID of ``b.c8b0c73d-3ae9``.")
  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getProjectId() {
    return projectId;
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public HookPayload tenant(String tenant) {

    this.tenant = tenant;
    return this;
  }

  /**
   * The tenant associated with the event. If specified on the webhook, the
   * event&#39;s tenant must match the webhook&#39;s tenant.
   * 
   * @return tenant
   **/
  @javax.annotation.Nullable
  @Schema(description = "The tenant associated with the event. If specified on the webhook, the event's tenant must match the webhook's tenant.")
  @JsonProperty(JSON_PROPERTY_TENANT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getTenant() {
    return tenant;
  }

  @JsonProperty(JSON_PROPERTY_TENANT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public HookPayload callbackWithEventPayloadOnly(Boolean callbackWithEventPayloadOnly) {

    this.callbackWithEventPayloadOnly = callbackWithEventPayloadOnly;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; - The callback request payload must only contain
   * information about the event. It must not contain any information about the
   * webhook.
   * 
   * &#x60;&#x60;false&#x60;&#x60; - (Default) The callback request payload must
   * contain information about the event as well as the webhook.
   * 
   * @return callbackWithEventPayloadOnly
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` - The callback request payload must only contain information about the event. It must not contain any information about the webhook.  ``false`` - (Default) The callback request payload must contain information about the event as well as the webhook.")
  @JsonProperty(JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getCallbackWithEventPayloadOnly() {
    return callbackWithEventPayloadOnly;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCallbackWithEventPayloadOnly(Boolean callbackWithEventPayloadOnly) {
    this.callbackWithEventPayloadOnly = callbackWithEventPayloadOnly;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HookPayload hookPayload = (HookPayload) o;
    return Objects.equals(this.callbackUrl, hookPayload.callbackUrl) &&
        Objects.equals(this.autoReactivateHook, hookPayload.autoReactivateHook) &&
        Objects.equals(this.scope, hookPayload.scope) &&
        Objects.equals(this.hookAttribute, hookPayload.hookAttribute) &&
        Objects.equals(this.hookExpiry, hookPayload.hookExpiry) &&
        Objects.equals(this.filter, hookPayload.filter) &&
        Objects.equals(this.hubId, hookPayload.hubId) &&
        Objects.equals(this.projectId, hookPayload.projectId) &&
        Objects.equals(this.tenant, hookPayload.tenant) &&
        Objects.equals(this.callbackWithEventPayloadOnly, hookPayload.callbackWithEventPayloadOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackUrl, autoReactivateHook, scope, hookAttribute, hookExpiry, filter, hubId, projectId,
        tenant, callbackWithEventPayloadOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HookPayload {\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    autoReactivateHook: ").append(toIndentedString(autoReactivateHook)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    hookAttribute: ").append(toIndentedString(hookAttribute)).append("\n");
    sb.append("    hookExpiry: ").append(toIndentedString(hookExpiry)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    hubId: ").append(toIndentedString(hubId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
    sb.append("    callbackWithEventPayloadOnly: ").append(toIndentedString(callbackWithEventPayloadOnly)).append("\n");
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
