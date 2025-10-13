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
 * Specifies the details of a webhook to be updated.
 */
@Schema(description = "Specifies the details of a webhook to be updated. ")
@JsonPropertyOrder({
    ModifyHookPayload.JSON_PROPERTY_STATUS,
    ModifyHookPayload.JSON_PROPERTY_AUTO_REACTIVATE_HOOK,
    ModifyHookPayload.JSON_PROPERTY_FILTER,
    ModifyHookPayload.JSON_PROPERTY_HOOK_ATTRIBUTE,
    ModifyHookPayload.JSON_PROPERTY_TOKEN,
    ModifyHookPayload.JSON_PROPERTY_HOOK_EXPIRY
})
@JsonTypeName("ModifyHookPayload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ModifyHookPayload {
  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusRequest status;

  public static final String JSON_PROPERTY_AUTO_REACTIVATE_HOOK = "autoReactivateHook";
  private Boolean autoReactivateHook;

  public static final String JSON_PROPERTY_FILTER = "filter";
  private String filter;

  public static final String JSON_PROPERTY_HOOK_ATTRIBUTE = "hookAttribute";
  private Object hookAttribute;

  public static final String JSON_PROPERTY_TOKEN = "token";
  private String token;

  public static final String JSON_PROPERTY_HOOK_EXPIRY = "hookExpiry";
  private String hookExpiry;

  public ModifyHookPayload status(StatusRequest status) {

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

  public StatusRequest getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(StatusRequest status) {
    this.status = status;
  }

  public ModifyHookPayload autoReactivateHook(Boolean autoReactivateHook) {

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

  public ModifyHookPayload filter(String filter) {

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

  public ModifyHookPayload hookAttribute(Object hookAttribute) {

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

  public ModifyHookPayload token(String token) {

    this.token = token;
    return this;
  }

  /**
   * A secret token that is used to generate a hash signature, which is passed
   * along with notification requests to the callback URL.
   * 
   * See the [Secret
   * Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in
   * API Basics for more information.
   * 
   * @return token
   **/
  @javax.annotation.Nullable
  @Schema(description = "A secret token that is used to generate a hash signature, which is passed along with notification requests to the callback URL.  See the [Secret Token](/en/docs/webhooks/v1/developers_guide/basics/#secret-token) section in API Basics for more information.")
  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getToken() {
    return token;
  }

  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setToken(String token) {
    this.token = token;
  }

  public ModifyHookPayload hookExpiry(String hookExpiry) {

    this.hookExpiry = hookExpiry;
    return this;
  }

  /**
   * The date and time the webhook will expire, formatted as an ISO 8601 date/time
   * string. If you set this to null, the webhook will never expire.
   * 
   * @return hookExpiry
   **/
  @javax.annotation.Nullable
  @Schema(description = "The date and time the webhook will expire, formatted as an ISO 8601 date/time string. If you set this to null, the webhook will never expire.")
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyHookPayload modifyHookPayload = (ModifyHookPayload) o;
    return Objects.equals(this.status, modifyHookPayload.status) &&
        Objects.equals(this.autoReactivateHook, modifyHookPayload.autoReactivateHook) &&
        Objects.equals(this.filter, modifyHookPayload.filter) &&
        Objects.equals(this.hookAttribute, modifyHookPayload.hookAttribute) &&
        Objects.equals(this.token, modifyHookPayload.token) &&
        Objects.equals(this.hookExpiry, modifyHookPayload.hookExpiry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, autoReactivateHook, filter, hookAttribute, token, hookExpiry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyHookPayload {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    autoReactivateHook: ").append(toIndentedString(autoReactivateHook)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    hookAttribute: ").append(toIndentedString(hookAttribute)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    hookExpiry: ").append(toIndentedString(hookExpiry)).append("\n");
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
