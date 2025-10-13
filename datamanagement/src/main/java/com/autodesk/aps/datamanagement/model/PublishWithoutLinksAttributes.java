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
 * Contains the properties of the response
 * to the PublishWithoutLinks command.
 */
@Schema(description = "Contains the properties of the response to the PublishWithoutLinks command.")
@JsonPropertyOrder({
    PublishWithoutLinksAttributes.JSON_PROPERTY_EXTENSION,
    PublishWithoutLinksAttributes.JSON_PROPERTY_STATUS
})
@JsonTypeName("PublishWithoutLinks_attributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class PublishWithoutLinksAttributes {
  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private PublishWithoutLinksAttributesExtension extension;

  public static final String JSON_PROPERTY_STATUS = "status";
  private CommandExecutionStatus status;

  public PublishWithoutLinksAttributes extension(PublishWithoutLinksAttributesExtension extension) {

    this.extension = extension;
    return this;
  }

  /**
   * Get extension
   * 
   * @return extension
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public PublishWithoutLinksAttributesExtension getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExtension(PublishWithoutLinksAttributesExtension extension) {
    this.extension = extension;
  }

  public PublishWithoutLinksAttributes status(CommandExecutionStatus status) {

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

  public CommandExecutionStatus getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(CommandExecutionStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublishWithoutLinksAttributes publishWithoutLinksAttributes = (PublishWithoutLinksAttributes) o;
    return Objects.equals(this.extension, publishWithoutLinksAttributes.extension) &&
        Objects.equals(this.status, publishWithoutLinksAttributes.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extension, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublishWithoutLinksAttributes {\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
