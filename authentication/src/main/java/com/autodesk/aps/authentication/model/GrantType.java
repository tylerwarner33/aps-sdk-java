/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Authentication
 * OAuth2 token management APIs.
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

package com.autodesk.aps.authentication.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the grant type you are requesting the code for. Possible values
 * are: - &#x60;&#x60;client_credentials&#x60;&#x60; - For a 2-legged access
 * token. - &#x60;&#x60;authorization_code&#x60;&#x60; - For a 3-legged access
 * token. - &#x60;&#x60;refresh_token&#x60;&#x60; - For a refresh token.
 */
public enum GrantType {

  CLIENT_CREDENTIALS("client_credentials"),

  AUTHORIZATION_CODE("authorization_code"),

  REFRESH_TOKEN("refresh_token");

  private String value;

  GrantType(String value) {
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
  public static GrantType fromValue(String value) {
    for (GrantType b : GrantType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
