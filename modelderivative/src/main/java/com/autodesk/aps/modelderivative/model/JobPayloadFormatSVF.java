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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Describes the options for translation jobs producing SVF outputs.
 */
@Schema(description = "Describes the options for translation jobs producing SVF outputs.")
@JsonPropertyOrder({
    JobPayloadFormatSVF.JSON_PROPERTY_VIEWS,
    JobPayloadFormatSVF.JSON_PROPERTY_TYPE,
    JobPayloadFormatSVF.JSON_PROPERTY_ADVANCED
})
@JsonTypeName("JobPayloadFormatSVF")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSVF implements JobPayloadFormat {
  public static final String JSON_PROPERTY_VIEWS = "views";
  private List<View> views = null;

  public static final String JSON_PROPERTY_TYPE = "type";
  private OutputType type;

  public static final String JSON_PROPERTY_ADVANCED = "advanced";
  private JobPayloadFormatSVFAdvanced advanced;

  public JobPayloadFormatSVF views(List<View> views) {

    this.views = views;
    return this;
  }

  public JobPayloadFormatSVF addviewsItem(View viewsItem) {
    if (this.views == null) {
      this.views = new ArrayList<>();
    }
    this.views.add(viewsItem);
    return this;
  }

  /**
   * Specifies the type of view to generate. Possible values are &#x60;2d&#x60;
   * and &#x60;3d&#x60;.
   * 
   * @return views
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies the type of view to generate. Possible values are `2d` and `3d`.")
  @JsonProperty(JSON_PROPERTY_VIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<View> getViews() {
    return views;
  }

  @JsonProperty(JSON_PROPERTY_VIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setViews(List<View> views) {
    this.views = views;
  }

  public JobPayloadFormatSVF type(OutputType type) {

    this.type = type;
    return this;
  }

  /**
   * Get type
   * 
   * @return type
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public OutputType getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setType(OutputType type) {
    this.type = type;
  }

  public JobPayloadFormatSVF advanced(JobPayloadFormatSVFAdvanced advanced) {

    this.advanced = advanced;
    return this;
  }

  /**
   * Get advanced
   * 
   * @return advanced
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ADVANCED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public JobPayloadFormatSVFAdvanced getAdvanced() {
    return advanced;
  }

  @JsonProperty(JSON_PROPERTY_ADVANCED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAdvanced(JobPayloadFormatSVFAdvanced advanced) {
    this.advanced = advanced;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSVF jobPayloadFormatSVF = (JobPayloadFormatSVF) o;
    return Objects.equals(this.views, jobPayloadFormatSVF.views) &&
        Objects.equals(this.type, jobPayloadFormatSVF.type) &&
        Objects.equals(this.advanced, jobPayloadFormatSVF.advanced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(views, type, advanced);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSVF {\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    advanced: ").append(toIndentedString(advanced)).append("\n");
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
