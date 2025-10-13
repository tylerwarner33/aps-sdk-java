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
 * GetHubs403ResponseMetaWarnings
 */
@JsonPropertyOrder({
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_ID,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_HTTP_STATUS_CODE,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_ERROR_CODE,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_TITLE,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_DETAIL,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_ABOUT_LINK,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_SOURCE,
    GetHubs403ResponseMetaWarnings.JSON_PROPERTY_META
})
@JsonTypeName("getHubs_403_response_meta_warnings")
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetHubs403ResponseMetaWarnings {
  public static final String JSON_PROPERTY_ID = "Id";
  private Object id = null;

  public static final String JSON_PROPERTY_HTTP_STATUS_CODE = "HttpStatusCode";
  private String httpStatusCode;

  public static final String JSON_PROPERTY_ERROR_CODE = "ErrorCode";
  private String errorCode;

  public static final String JSON_PROPERTY_TITLE = "Title";
  private String title;

  public static final String JSON_PROPERTY_DETAIL = "Detail";
  private String detail;

  public static final String JSON_PROPERTY_ABOUT_LINK = "AboutLink";
  private Object aboutLink = null;

  public static final String JSON_PROPERTY_SOURCE = "Source";
  private Object source = null;

  public static final String JSON_PROPERTY_META = "meta";
  private Object meta = null;

  public GetHubs403ResponseMetaWarnings id(Object id) {

    this.id = id;
    return this;
  }

  /**
   * An ID assigned to the warning.
   * 
   * @return id
   **/
  @javax.annotation.Nullable
  @Schema(description = "An ID assigned to the warning.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setId(Object id) {
    this.id = id;
  }

  public GetHubs403ResponseMetaWarnings httpStatusCode(String httpStatusCode) {

    this.httpStatusCode = httpStatusCode;
    return this;
  }

  /**
   * The HTTP status code returned in response to the request.
   * 
   * @return httpStatusCode
   **/
  @javax.annotation.Nullable
  @Schema(description = "The HTTP status code returned in response to the request.")
  @JsonProperty(JSON_PROPERTY_HTTP_STATUS_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getHttpStatusCode() {
    return httpStatusCode;
  }

  @JsonProperty(JSON_PROPERTY_HTTP_STATUS_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHttpStatusCode(String httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public GetHubs403ResponseMetaWarnings errorCode(String errorCode) {

    this.errorCode = errorCode;
    return this;
  }

  /**
   * A code that indicates what went wrong.
   * 
   * @return errorCode
   **/
  @javax.annotation.Nullable
  @Schema(description = "A code that indicates what went wrong.")
  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getErrorCode() {
    return errorCode;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public GetHubs403ResponseMetaWarnings title(String title) {

    this.title = title;
    return this;
  }

  /**
   * A quick summary of the issue, at a glance.
   * 
   * @return title
   **/
  @javax.annotation.Nullable
  @Schema(description = "A quick summary of the issue, at a glance.")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getTitle() {
    return title;
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTitle(String title) {
    this.title = title;
  }

  public GetHubs403ResponseMetaWarnings detail(String detail) {

    this.detail = detail;
    return this;
  }

  /**
   * A more comprehensive explanation of the issue, providing specific information
   * and potential solutions, if any.
   * 
   * @return detail
   **/
  @javax.annotation.Nullable
  @Schema(description = "A more comprehensive explanation of the issue, providing specific information and potential solutions, if any.")
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getDetail() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setDetail(String detail) {
    this.detail = detail;
  }

  public GetHubs403ResponseMetaWarnings aboutLink(Object aboutLink) {

    this.aboutLink = aboutLink;
    return this;
  }

  /**
   * A hyperlink to documentation about the issue.
   * 
   * @return aboutLink
   **/
  @javax.annotation.Nullable
  @Schema(description = "A hyperlink to documentation about the issue.")
  @JsonProperty(JSON_PROPERTY_ABOUT_LINK)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getAboutLink() {
    return aboutLink;
  }

  @JsonProperty(JSON_PROPERTY_ABOUT_LINK)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAboutLink(Object aboutLink) {
    this.aboutLink = aboutLink;
  }

  public GetHubs403ResponseMetaWarnings source(Object source) {

    this.source = source;
    return this;
  }

  /**
   * Information about the service that detected the issue.
   * 
   * @return source
   **/
  @javax.annotation.Nullable
  @Schema(description = "Information about the service that detected the issue.")
  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getSource() {
    return source;
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSource(Object source) {
    this.source = source;
  }

  public GetHubs403ResponseMetaWarnings meta(Object meta) {

    this.meta = meta;
    return this;
  }

  /**
   * Additional information about the issue.
   * 
   * @return meta
   **/
  @javax.annotation.Nullable
  @Schema(description = "Additional information about the issue.")
  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getMeta() {
    return meta;
  }

  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMeta(Object meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetHubs403ResponseMetaWarnings getHubs403ResponseMetaWarnings = (GetHubs403ResponseMetaWarnings) o;
    return Objects.equals(this.id, getHubs403ResponseMetaWarnings.id) &&
        Objects.equals(this.httpStatusCode, getHubs403ResponseMetaWarnings.httpStatusCode) &&
        Objects.equals(this.errorCode, getHubs403ResponseMetaWarnings.errorCode) &&
        Objects.equals(this.title, getHubs403ResponseMetaWarnings.title) &&
        Objects.equals(this.detail, getHubs403ResponseMetaWarnings.detail) &&
        Objects.equals(this.aboutLink, getHubs403ResponseMetaWarnings.aboutLink) &&
        Objects.equals(this.source, getHubs403ResponseMetaWarnings.source) &&
        Objects.equals(this.meta, getHubs403ResponseMetaWarnings.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, httpStatusCode, errorCode, title, detail, aboutLink, source, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetHubs403ResponseMetaWarnings {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    aboutLink: ").append(toIndentedString(aboutLink)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
