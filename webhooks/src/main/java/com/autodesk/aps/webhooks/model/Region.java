/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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

package com.autodesk.aps.webhooks.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the geographical location (region) of the server a request must be
 * executed on. This also corresponds to the region where the Webhook data is
 * stored. It is also the location of the server that will make requests to your
 * callback URL. Possible values: - &#x60;&#x60;US&#x60;&#x60; - (Default) Data
 * center dedicated to serve the United States region. -
 * &#x60;&#x60;EMEA&#x60;&#x60; - Data center dedicated to serve the European
 * Union, Middle East, and Africa regions. - &#x60;&#x60;AUS&#x60;&#x60; -
 * (Beta) Data center dedicated to serve the Australia region. -
 * &#x60;&#x60;CAN&#x60;&#x60; - Data center dedicated to serve the Canada
 * region. - &#x60;&#x60;DEU&#x60;&#x60; - Data center dedicated to serve the
 * Germany region. - &#x60;&#x60;IND&#x60;&#x60; - Data center dedicated to
 * serve the India region. - &#x60;&#x60;JPN&#x60;&#x60; - Data center dedicated
 * to serve the Japan region. - &#x60;&#x60;GBR&#x60;&#x60; - Data center
 * dedicated to serve the United Kingdom region. **Note:** Beta features are
 * subject to change. Please avoid using them in production environments.
 */
public enum Region {

  US("US"),

  EMEA("EMEA"),

  AUS("AUS"),

  CAN("CAN"),

  DEU("DEU"),

  IND("IND"),

  JPN("JPN"),

  GBR("GBR");

  private String value;

  Region(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Region fromValue(String value) {
    for (Region b : Region.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
