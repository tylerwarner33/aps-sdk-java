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
 * Specifies the scope for the token you are requesting. See the
 * &#x60;Developer&#39;s Guide documentation on scopes
 * &lt;/en/docs/oauth/v2/developers_guide/scopes/&gt;&#x60;_ for a complete list
 * of possible values.
 */
public enum Scopes {

  USER_READ("user:read"),

  USER_WRITE("user:write"),

  USER_PROFILE_READ("user-profile:read"),

  VIEWABLES_READ("viewables:read"),

  DATA_READ("data:read"),

  DATA_READ_URN_OF_RESOURCE_("data:read:<URN_OF_RESOURCE>"),

  DATA_WRITE("data:write"),

  DATA_CREATE("data:create"),

  DATA_SEARCH("data:search"),

  BUCKET_CREATE("bucket:create"),

  BUCKET_READ("bucket:read"),

  BUCKET_UPDATE("bucket:update"),

  BUCKET_DELETE("bucket:delete"),

  CODE_ALL("code:all"),

  ACCOUNT_READ("account:read"),

  ACCOUNT_WRITE("account:write"),

  OPENID("openid");

  private String value;

  Scopes(String value) {
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
  public static Scopes fromValue(String value) {
    for (Scopes b : Scopes.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
