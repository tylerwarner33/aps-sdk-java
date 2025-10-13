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
 * Contains advanced configuration settings for translation jobs processing DWG
 * inputs.
 */
@Schema(description = "Contains advanced configuration settings for translation jobs processing DWG inputs.")
@JsonPropertyOrder({
    JobPayloadFormatSVF2AdvancedDWG.JSON_PROPERTY_2DVIEWS
})
@JsonTypeName("JobPayloadFormatSVF2AdvancedDWG")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadFormatSVF2AdvancedDWG implements JobPayloadFormatSVF2Advanced {
  public static final String JSON_PROPERTY_2DVIEWS = "2dviews";
  private Model2dView _2dviews;

  public JobPayloadFormatSVF2AdvancedDWG _2dviews(Model2dView _2dviews) {

    this._2dviews = _2dviews;
    return this;
  }

  /**
   * Get _2dviews
   * 
   * @return _2dviews
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_2DVIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Model2dView get2dviews() {
    return _2dviews;
  }

  @JsonProperty(JSON_PROPERTY_2DVIEWS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void set2dviews(Model2dView _2dviews) {
    this._2dviews = _2dviews;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadFormatSVF2AdvancedDWG jobPayloadFormatSVF2AdvancedDWG = (JobPayloadFormatSVF2AdvancedDWG) o;
    return Objects.equals(this._2dviews, jobPayloadFormatSVF2AdvancedDWG._2dviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_2dviews);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadFormatSVF2AdvancedDWG {\n");
    sb.append("    _2dviews: ").append(toIndentedString(_2dviews)).append("\n");
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
