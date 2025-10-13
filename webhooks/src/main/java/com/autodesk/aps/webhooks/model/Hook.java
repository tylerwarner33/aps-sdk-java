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

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains the response to a Create Webhooks for All Events request.
 */
@Schema(description = "Contains the response to a Create Webhooks for All Events request.")
@JsonPropertyOrder({
    Hook.JSON_PROPERTY_HOOKS
})
@JsonTypeName("Hook")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Hook {
  public static final String JSON_PROPERTY_HOOKS = "hooks";
  private List<HookDetails> hooks = null;

  public Hook hooks(List<HookDetails> hooks) {

    this.hooks = hooks;
    return this;
  }

  public Hook addhooksItem(HookDetails hooksItem) {
    if (this.hooks == null) {
      this.hooks = new ArrayList<>();
    }
    this.hooks.add(hooksItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a webhook that was created.
   * 
   * @return hooks
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object represents a webhook that was created.")
  @JsonProperty(JSON_PROPERTY_HOOKS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<HookDetails> getHooks() {
    return hooks;
  }

  @JsonProperty(JSON_PROPERTY_HOOKS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHooks(List<HookDetails> hooks) {
    this.hooks = hooks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hook hook = (Hook) o;
    return Objects.equals(this.hooks, hook.hooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hooks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Hook {\n");
    sb.append("    hooks: ").append(toIndentedString(hooks)).append("\n");
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
