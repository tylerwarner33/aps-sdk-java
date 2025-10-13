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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Information on links to this resource.
 */
@Schema(description = "Information on links to this resource.")
@JsonPropertyOrder({
    JsonApiLinksSelfAndWebView.JSON_PROPERTY_SELF,
    JsonApiLinksSelfAndWebView.JSON_PROPERTY_WEB_VIEW
})
@JsonTypeName("json_api_links_self_and_web_view")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonApiLinksSelfAndWebView {
  public static final String JSON_PROPERTY_SELF = "self";
  private JsonApiLink self;

  public static final String JSON_PROPERTY_WEB_VIEW = "webView";
  private WebViewLink webView;

  public JsonApiLinksSelfAndWebView self(JsonApiLink self) {

    this.self = self;
    return this;
  }

  /**
   * Get self
   * 
   * @return self
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public JsonApiLink getSelf() {
    return self;
  }

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSelf(JsonApiLink self) {
    this.self = self;
  }

  public JsonApiLinksSelfAndWebView webView(WebViewLink webView) {

    this.webView = webView;
    return this;
  }

  /**
   * Get webView
   * 
   * @return webView
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_WEB_VIEW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public WebViewLink getWebView() {
    return webView;
  }

  @JsonProperty(JSON_PROPERTY_WEB_VIEW)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setWebView(WebViewLink webView) {
    this.webView = webView;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiLinksSelfAndWebView jsonApiLinksSelfAndWebView = (JsonApiLinksSelfAndWebView) o;
    return Objects.equals(this.self, jsonApiLinksSelfAndWebView.self) &&
        Objects.equals(this.webView, jsonApiLinksSelfAndWebView.webView);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, webView);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiLinksSelfAndWebView {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    webView: ").append(toIndentedString(webView)).append("\n");
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
