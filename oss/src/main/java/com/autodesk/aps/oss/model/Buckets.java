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

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.autodesk.aps.oss.model.BucketsItems;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * An object that represents a collection of buckets.
 */
@Schema(description = "An object that represents a collection of buckets.")
@JsonPropertyOrder({
  Buckets.JSON_PROPERTY_ITEMS,
  Buckets.JSON_PROPERTY_NEXT
})
@JsonTypeName("buckets")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Buckets {
  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<BucketsItems> items = new ArrayList<>();

  public static final String JSON_PROPERTY_NEXT = "next";
  private String next;


  public Buckets items(List<BucketsItems> items) {
    
    this.items = items;
    return this;
  }

  public Buckets additemsItem(BucketsItems itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Array of objects, where each object represents a bucket.
   * @return items
  **/
  @Schema(required = true, description = "Array of objects, where each object represents a bucket.")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<BucketsItems> getItems() {
    return items;
  }


  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setItems(List<BucketsItems> items) {
    this.items = items;
  }


  public Buckets next(String next) {
    
    this.next = next;
    return this;
  }

   /**
   * The URL to be used to retrieve the next page of results, if available. It will be present only when there are more items to be retrieved after the current set.
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
    Buckets buckets = (Buckets) o;
    return Objects.equals(this.items, buckets.items) &&
        Objects.equals(this.next, buckets.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, next);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Buckets {\n");
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

