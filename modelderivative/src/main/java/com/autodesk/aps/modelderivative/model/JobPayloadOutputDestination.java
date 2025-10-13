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
 * (Deprecated) Specifies where to store generated derivatives.
 ** 
 * Note:** Please use the &#x60;&#x60;region&#x60;&#x60; header instead of this
 * attribute.
 */
@Schema(description = "(Deprecated) Specifies where to store generated derivatives.  **Note:** Please use the ``region`` header instead of this attribute.")
@JsonPropertyOrder({
    JobPayloadOutputDestination.JSON_PROPERTY_REGION
})
@JsonTypeName("JobPayload_output_destination")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JobPayloadOutputDestination {
  public static final String JSON_PROPERTY_REGION = "region";
  private String region;

  public JobPayloadOutputDestination region(String region) {

    this.region = region;
    return this;
  }

  /**
   * Specifies where to store generated derivatives. Possible values are:
   * 
   * - &#x60;&#x60;US&#x60;&#x60; - (Default) Store derivatives at a data center
   * for the United States of America.
   * - &#x60;&#x60;EMEA&#x60;&#x60; - Store derivatives at a data center for the
   * European Union.
   * - &#x60;&#x60;AUS&#x60;&#x60; - (Beta) Store derivatives at a data center for
   * the Australia region.
   * - &#x60;&#x60;CAN&#x60;&#x60; - Data center for the Canada region.
   * - &#x60;&#x60;DEU&#x60;&#x60; - Data center for the Germany region.
   * - &#x60;&#x60;IND&#x60;&#x60; - Data center for the India region.
   * - &#x60;&#x60;JPN&#x60;&#x60; - Data center for the Japan region.
   * - &#x60;&#x60;GBR&#x60;&#x60; - Data center for the United Kingdom region.
   ** 
   * Note**:
   * 
   * - Please use the &#x60;&#x60;region&#x60;&#x60; header instead of this
   * attribute.
   * 
   * @return region
   **/
  @javax.annotation.Nullable
  @Schema(description = "Specifies where to store generated derivatives. Possible values are:  - ``US`` - (Default) Store derivatives at a data center for the United States of America. - ``EMEA`` - Store derivatives at a data center for the European Union.  - ``AUS`` - (Beta) Store derivatives at a data center for the Australia region. - ``CAN`` - Data center for the Canada region. - ``DEU`` - Data center for the Germany region. - ``IND`` - Data center for the India region. - ``JPN`` - Data center for the Japan region. - ``GBR``  - Data center for the United Kingdom region.  **Note**:   - Please use the ``region`` header instead of this attribute. ")
  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getRegion() {
    return region;
  }

  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setRegion(String region) {
    this.region = region;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadOutputDestination jobPayloadOutputDestination = (JobPayloadOutputDestination) o;
    return Objects.equals(this.region, jobPayloadOutputDestination.region);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadOutputDestination {\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
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
