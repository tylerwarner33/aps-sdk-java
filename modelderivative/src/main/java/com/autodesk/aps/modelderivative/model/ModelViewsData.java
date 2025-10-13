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
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Container for the data returned by the List Model Views operation.
 */
@Schema(description = "Container for the data returned by the List Model Views operation.")
@JsonPropertyOrder({
    ModelViewsData.JSON_PROPERTY_TYPE,
    ModelViewsData.JSON_PROPERTY_METADATA
})
@JsonTypeName("ModelViews_data")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ModelViewsData {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private List<ModelViewsDataMetadata> metadata = new ArrayList<>();

  public ModelViewsData type(String type) {

    this.type = type;
    return this;
  }

  /**
   * The type of data that is returned.
   * 
   * @return type
   **/
  @Schema(required = true, description = "The type of data that is returned.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }

  public ModelViewsData metadata(List<ModelViewsDataMetadata> metadata) {

    this.metadata = metadata;
    return this;
  }

  public ModelViewsData addmetadataItem(ModelViewsDataMetadata metadataItem) {
    this.metadata.add(metadataItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a Model View.
   * 
   * @return metadata
   **/
  @Schema(required = true, description = "An array of objects, where each object represents a Model View.")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ModelViewsDataMetadata> getMetadata() {
    return metadata;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMetadata(List<ModelViewsDataMetadata> metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelViewsData modelViewsData = (ModelViewsData) o;
    return Objects.equals(this.type, modelViewsData.type) &&
        Objects.equals(this.metadata, modelViewsData.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelViewsData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
