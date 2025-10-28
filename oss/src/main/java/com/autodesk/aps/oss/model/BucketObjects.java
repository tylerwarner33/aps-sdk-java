/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * oss
 * The Object Storage Service (OSS) allows your application to download and upload raw files (such as PDF, XLS, DWG, or RVT) that are managed by the Data service.
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

package com.autodesk.aps.oss.model;

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
 * An array where each element represents an object in the bucket.
 */
@Schema(description = "An array where each element represents an object in the bucket.")
@JsonPropertyOrder({
    BucketObjects.JSON_PROPERTY_ITEMS,
    BucketObjects.JSON_PROPERTY_NEXT
})
@JsonTypeName("bucket_objects")
@JsonIgnoreProperties(ignoreUnknown = true)

public class BucketObjects {
  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<ObjectDetails> items = null;

  public static final String JSON_PROPERTY_NEXT = "next";
  private String next;

  public BucketObjects items(List<ObjectDetails> items) {

    this.items = items;
    return this;
  }

  public BucketObjects additemsItem(ObjectDetails itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * 
   * @return items
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<ObjectDetails> getItems() {
    return items;
  }

  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setItems(List<ObjectDetails> items) {
    this.items = items;
  }

  public BucketObjects next(String next) {

    this.next = next;
    return this;
  }

  /**
   * The URL to be used to retrieve the next page of results, if available. It
   * will be present only when there are more items to be retrieved after the
   * current set.
   * 
   * @return next
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URL to be used to retrieve the next page of results, if available. It will be present only when there are more items to be retrieved after the current set.")
  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getNext() {
    return next;
  }

  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setNext(String next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BucketObjects bucketObjects = (BucketObjects) o;
    return Objects.equals(this.items, bucketObjects.items) &&
        Objects.equals(this.next, bucketObjects.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, next);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BucketObjects {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
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
