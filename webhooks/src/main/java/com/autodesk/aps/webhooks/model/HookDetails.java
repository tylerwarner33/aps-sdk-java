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
 * Contains the details of a webhook.
 */
@Schema(description = "Contains the details of a webhook.")
@JsonPropertyOrder({
    HookDetails.JSON_PROPERTY_HOOK_ID,
    HookDetails.JSON_PROPERTY_TENANT,
    HookDetails.JSON_PROPERTY_CALLBACK_URL,
    HookDetails.JSON_PROPERTY_CREATED_BY,
    HookDetails.JSON_PROPERTY_EVENT,
    HookDetails.JSON_PROPERTY_CREATED_DATE,
    HookDetails.JSON_PROPERTY_LAST_UPDATED_DATE,
    HookDetails.JSON_PROPERTY_SYSTEM,
    HookDetails.JSON_PROPERTY_CREATOR_TYPE,
    HookDetails.JSON_PROPERTY_STATUS,
    HookDetails.JSON_PROPERTY_AUTO_REACTIVATE_HOOK,
    HookDetails.JSON_PROPERTY_HOOK_EXPIRY,
    HookDetails.JSON_PROPERTY_HOOK_ATTRIBUTE,
    HookDetails.JSON_PROPERTY_SCOPE,
    HookDetails.JSON_PROPERTY_URN,
    HookDetails.JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY,
    HookDetails.JSON_PROPERTY_SELF
})
@JsonTypeName("HookDetails")
@JsonIgnoreProperties(ignoreUnknown = true)

public class HookDetails {
  public static final String JSON_PROPERTY_HOOK_ID = "hookId";
  private String hookId;

  public static final String JSON_PROPERTY_TENANT = "tenant";
  private String tenant;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";
  private String callbackUrl;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
  private String createdBy;

  public static final String JSON_PROPERTY_EVENT = "event";
  private String event;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  private String createdDate;

  public static final String JSON_PROPERTY_LAST_UPDATED_DATE = "lastUpdatedDate";
  private String lastUpdatedDate;

  public static final String JSON_PROPERTY_SYSTEM = "system";
  private String system;

  public static final String JSON_PROPERTY_CREATOR_TYPE = "creatorType";
  private String creatorType;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Status status;

  public static final String JSON_PROPERTY_AUTO_REACTIVATE_HOOK = "autoReactivateHook";
  private Boolean autoReactivateHook;

  public static final String JSON_PROPERTY_HOOK_EXPIRY = "hookExpiry";
  private String hookExpiry;

  public static final String JSON_PROPERTY_HOOK_ATTRIBUTE = "hookAttribute";
  private Object hookAttribute;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private HookDetailsScope scope;

  public static final String JSON_PROPERTY_URN = "urn";
  private String urn;

  public static final String JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY = "callbackWithEventPayloadOnly";
  private String callbackWithEventPayloadOnly;

  public static final String JSON_PROPERTY_SELF = "__self__";
  private String self;

  public HookDetails hookId(String hookId) {

    this.hookId = hookId;
    return this;
  }

  /**
   * The ID that uniquely identifies the webhook.
   * 
   * @return hookId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID that uniquely identifies the webhook.")
  @JsonProperty(JSON_PROPERTY_HOOK_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getHookId() {
    return hookId;
  }

  @JsonProperty(JSON_PROPERTY_HOOK_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHookId(String hookId) {
    this.hookId = hookId;
  }

  public HookDetails tenant(String tenant) {

    this.tenant = tenant;
    return this;
  }

  /**
   * The ID of the tenant from which the event
   * originates.
   * 
   * @return tenant
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the tenant from which the event  originates.")
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

  public HookDetails callbackUrl(String callbackUrl) {

    this.callbackUrl = callbackUrl;
    return this;
  }

  /**
   * The URL to send notifications to when the
   * event is triggered.
   * 
   * @return callbackUrl
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URL to send notifications to when the  event is triggered. ")
  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCallbackUrl() {
    return callbackUrl;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  public HookDetails createdBy(String createdBy) {

    this.createdBy = createdBy;
    return this;
  }

  /**
   * The ID of the entity that created the webhook. It can be one of the
   * following:
   * 
   * - Client ID of an app: If created using a Client Credentials flow (two-legged
   * OAuth).
   * - User ID of a user: If created using an Authorization Code flow
   * (three-legged OAuth).
   * 
   * @return createdBy
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the entity that created the webhook. It can be one of the following:  - Client ID of an app: If created using a Client Credentials flow (two-legged OAuth).  - User ID of a user: If created using an Authorization Code flow (three-legged OAuth).")
  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCreatedBy() {
    return createdBy;
  }

  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public HookDetails event(String event) {

    this.event = event;
    return this;
  }

  /**
   * The ID of the event the webhook monitors. See [Supported
   * Events](/en/docs/webhooks/v1/reference/events/) for a full list of events and
   * wildcard patterns.
   * 
   * @return event
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the event the webhook monitors.  See [Supported Events](/en/docs/webhooks/v1/reference/events/) for a full list of events and wildcard patterns.")
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getEvent() {
    return event;
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setEvent(String event) {
    this.event = event;
  }

  public HookDetails createdDate(String createdDate) {

    this.createdDate = createdDate;
    return this;
  }

  /**
   * The date and time when the webhook was created, formatted as an ISO 8601
   * date/time string.
   * 
   * @return createdDate
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time when the webhook was created, formatted as an ISO 8601 date/time string.")
  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCreatedDate() {
    return createdDate;
  }

  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public HookDetails lastUpdatedDate(String lastUpdatedDate) {

    this.lastUpdatedDate = lastUpdatedDate;
    return this;
  }

  /**
   * The date and time when the webhook was last modified, formatted as an ISO
   * 8601 date/time string.
   * 
   * @return lastUpdatedDate
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time when the webhook was last modified, formatted as an ISO 8601 date/time string.")
  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLastUpdatedDate(String lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  public HookDetails system(String system) {

    this.system = system;
    return this;
  }

  /**
   * The ID of the system the webhook applies to. For example
   * &#x60;&#x60;data&#x60;&#x60; for Data Management. See [Supported
   * Events](/en/docs/webhooks/v1/reference/events/) for a full list of systems.
   * 
   * @return system
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the system the webhook applies to. For example ``data`` for Data Management. See [Supported Events](/en/docs/webhooks/v1/reference/events/) for a full list of systems.")
  @JsonProperty(JSON_PROPERTY_SYSTEM)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getSystem() {
    return system;
  }

  @JsonProperty(JSON_PROPERTY_SYSTEM)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSystem(String system) {
    this.system = system;
  }

  public HookDetails creatorType(String creatorType) {

    this.creatorType = creatorType;
    return this;
  }

  /**
   * Indicates what type of an entity created the webhooks. Possible values:
   * 
   * - &#x60;&#x60;O2User&#x60;&#x60; - Created by a user through an Authorization
   * Code flow (three-legged OAuth).
   * - &#x60;&#x60;Application&#x60;&#x60; - Created by an application using a
   * Client Credentials flow (two-legged OAuth).
   * 
   * @return creatorType
   **/
  @javax.annotation.Nullable
  @Schema(description = "Indicates what type of an entity created the webhooks. Possible values:  - ``O2User`` - Created by a user through an Authorization Code flow (three-legged OAuth). - ``Application`` - Created by an application using a Client Credentials flow (two-legged OAuth).")
  @JsonProperty(JSON_PROPERTY_CREATOR_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCreatorType() {
    return creatorType;
  }

  @JsonProperty(JSON_PROPERTY_CREATOR_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatorType(String creatorType) {
    this.creatorType = creatorType;
  }

  public HookDetails status(Status status) {

    this.status = status;
    return this;
  }

  /**
   * Get status
   * 
   * @return status
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Status getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(Status status) {
    this.status = status;
  }

  public HookDetails autoReactivateHook(Boolean autoReactivateHook) {

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

  public HookDetails hookExpiry(String hookExpiry) {

    this.hookExpiry = hookExpiry;
    return this;
  }

  /**
   * The date and time when the webhook will expire, formatted as an ISO 8601
   * date/time string. A missing or null value indicates that the webhook will
   * never expire.
   * 
   * &#x60;&#x60;hookExpiry&#x60;&#x60; is returned only if it was specified when
   * the webhook was created.
   * 
   * @return hookExpiry
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time when the webhook will expire, formatted as an ISO 8601 date/time string. A missing or null value indicates that the webhook will never expire.  ``hookExpiry`` is returned only if it was specified when the webhook was created.")
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

  public HookDetails hookAttribute(Object hookAttribute) {

    this.hookAttribute = hookAttribute;
    return this;
  }

  /**
   * Custom metadata which will be less than 1KB in size.
   * 
   * @return hookAttribute
   **/
  @javax.annotation.Nullable
  @Schema(description = "Custom metadata which will be less than 1KB in size.")
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

  public HookDetails scope(HookDetailsScope scope) {

    this.scope = scope;
    return this;
  }

  /**
   * Get scope
   * 
   * @return scope
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public HookDetailsScope getScope() {
    return scope;
  }

  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setScope(HookDetailsScope scope) {
    this.scope = scope;
  }

  public HookDetails urn(String urn) {

    this.urn = urn;
    return this;
  }

  /**
   * The URN of the webhook.
   * 
   * @return urn
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URN of the webhook.")
  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUrn() {
    return urn;
  }

  @JsonProperty(JSON_PROPERTY_URN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUrn(String urn) {
    this.urn = urn;
  }

  public HookDetails callbackWithEventPayloadOnly(String callbackWithEventPayloadOnly) {

    this.callbackWithEventPayloadOnly = callbackWithEventPayloadOnly;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; - The callback request payload will only contain
   * information about the event. It will not contain any information about the
   * webhook.
   * 
   * &#x60;&#x60;false&#x60;&#x60; - The callback request payload will contain
   * information about the event as well as the webhook.
   * 
   * @return callbackWithEventPayloadOnly
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` - The callback request payload will only contain information about the event. It will not contain any information about the webhook.  ``false`` - The callback request payload will contain information about the event as well as the webhook.")
  @JsonProperty(JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCallbackWithEventPayloadOnly() {
    return callbackWithEventPayloadOnly;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_WITH_EVENT_PAYLOAD_ONLY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCallbackWithEventPayloadOnly(String callbackWithEventPayloadOnly) {
    this.callbackWithEventPayloadOnly = callbackWithEventPayloadOnly;
  }

  public HookDetails self(String self) {

    this.self = self;
    return this;
  }

  /**
   * A link to itself.
   * 
   * @return self
   **/
  @javax.annotation.Nullable
  @Schema(description = "A link to itself.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getSelf() {
    return self;
  }

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSelf(String self) {
    this.self = self;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HookDetails hookDetails = (HookDetails) o;
    return Objects.equals(this.hookId, hookDetails.hookId) &&
        Objects.equals(this.tenant, hookDetails.tenant) &&
        Objects.equals(this.callbackUrl, hookDetails.callbackUrl) &&
        Objects.equals(this.createdBy, hookDetails.createdBy) &&
        Objects.equals(this.event, hookDetails.event) &&
        Objects.equals(this.createdDate, hookDetails.createdDate) &&
        Objects.equals(this.lastUpdatedDate, hookDetails.lastUpdatedDate) &&
        Objects.equals(this.system, hookDetails.system) &&
        Objects.equals(this.creatorType, hookDetails.creatorType) &&
        Objects.equals(this.status, hookDetails.status) &&
        Objects.equals(this.autoReactivateHook, hookDetails.autoReactivateHook) &&
        Objects.equals(this.hookExpiry, hookDetails.hookExpiry) &&
        Objects.equals(this.hookAttribute, hookDetails.hookAttribute) &&
        Objects.equals(this.scope, hookDetails.scope) &&
        Objects.equals(this.urn, hookDetails.urn) &&
        Objects.equals(this.callbackWithEventPayloadOnly, hookDetails.callbackWithEventPayloadOnly) &&
        Objects.equals(this.self, hookDetails.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hookId, tenant, callbackUrl, createdBy, event, createdDate, lastUpdatedDate, system,
        creatorType, status, autoReactivateHook, hookExpiry, hookAttribute, scope, urn, callbackWithEventPayloadOnly,
        self);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HookDetails {\n");
    sb.append("    hookId: ").append(toIndentedString(hookId)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastUpdatedDate: ").append(toIndentedString(lastUpdatedDate)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
    sb.append("    creatorType: ").append(toIndentedString(creatorType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    autoReactivateHook: ").append(toIndentedString(autoReactivateHook)).append("\n");
    sb.append("    hookExpiry: ").append(toIndentedString(hookExpiry)).append("\n");
    sb.append("    hookAttribute: ").append(toIndentedString(hookAttribute)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
    sb.append("    callbackWithEventPayloadOnly: ").append(toIndentedString(callbackWithEventPayloadOnly)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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
