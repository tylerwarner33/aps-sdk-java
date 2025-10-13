/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Model Derivative
 * Use the Model Derivative API to translate designs from one CAD format to another. You can also use this API to extract metadata from a model.
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

package com.autodesk.aps.modelderivative.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * An array of objects where each object represents a message logged to the
 * manifest during translation. For example, error messages and warning
 * messages.
 */
@Schema(description = "An array of objects where each object represents a message logged to the manifest during translation. For example, error messages and warning messages.")
@JsonPropertyOrder({
    Messages.JSON_PROPERTY_TYPE,
    Messages.JSON_PROPERTY_CODE,
    Messages.JSON_PROPERTY_MESSAGE
})
@JsonTypeName("Messages")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Messages {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private Object message;

  public Messages type(String type) {

    this.type = type;
    return this;
  }

  /**
   * Indicates the type of the message. For example, warning indicates a warning
   * message and error indicates an error message.
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "Indicates the type of the message. For example, warning indicates a warning message and error indicates an error message.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(String type) {
    this.type = type;
  }

  public Messages code(String code) {

    this.code = code;
    return this;
  }

  /**
   * The ID of the message. For example, the error code reported by an error
   * message.
   * 
   * @return code
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the message. For example, the error code reported by an error message.")
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCode() {
    return code;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCode(String code) {
    this.code = code;
  }

  public Messages message(Object message) {

    this.message = message;
    return this;
  }

  /**
   * A human-readable explanation of the event being reported. Can be a string or
   * an array of string.
   * 
   * @return message
   **/
  @javax.annotation.Nullable
  @Schema(description = "A human-readable explanation of the event being reported. Can be a string or an array of string.")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Object getMessage() {
    return message;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setMessage(Object message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Messages messages = (Messages) o;
    return Objects.equals(this.type, messages.type) &&
        Objects.equals(this.code, messages.code) &&
        Objects.equals(this.message, messages.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Messages {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
