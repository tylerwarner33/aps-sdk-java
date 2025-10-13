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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a JSON Web Key Set (JWKS).
 */
@Schema(description = "Represents a JSON Web Key Set (JWKS).")
@JsonPropertyOrder({
    JwksKey.JSON_PROPERTY_KID,
    JwksKey.JSON_PROPERTY_KTY,
    JwksKey.JSON_PROPERTY_USE,
    JwksKey.JSON_PROPERTY_N,
    JwksKey.JSON_PROPERTY_E
})
@JsonTypeName("jwksKey")
@JsonIgnoreProperties(ignoreUnknown = true)

public class JwksKey {
  public static final String JSON_PROPERTY_KID = "kid";
  private String kid;

  public static final String JSON_PROPERTY_KTY = "kty";
  private String kty;

  public static final String JSON_PROPERTY_USE = "use";
  private String use;

  public static final String JSON_PROPERTY_N = "n";
  private String n;

  public static final String JSON_PROPERTY_E = "e";
  private String e;

  public JwksKey kid(String kid) {

    this.kid = kid;
    return this;
  }

  /**
   * The ID of the key. Acts as a unique identifier for a specific key within the
   * JWKS.
   * 
   * @return kid
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the key. Acts as a unique identifier for a specific key within the JWKS.")
  @JsonProperty(JSON_PROPERTY_KID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getKid() {
    return kid;
  }

  @JsonProperty(JSON_PROPERTY_KID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setKid(String kid) {
    this.kid = kid;
  }

  public JwksKey kty(String kty) {

    this.kty = kty;
    return this;
  }

  /**
   * The cryptographic algorithm family used with the key. Currently, always
   * &#x60;&#x60;RSA&#x60;&#x60;.
   * 
   * @return kty
   **/
  @javax.annotation.Nullable
  @Schema(description = "The cryptographic algorithm family used with the key. Currently, always ``RSA``.")
  @JsonProperty(JSON_PROPERTY_KTY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getKty() {
    return kty;
  }

  @JsonProperty(JSON_PROPERTY_KTY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setKty(String kty) {
    this.kty = kty;
  }

  public JwksKey use(String use) {

    this.use = use;
    return this;
  }

  /**
   * The intended use of the public key. Possible values:
   * 
   * - &#x60;&#x60;sig&#x60;&#x60; - Verify the signature on data.
   * 
   * @return use
   **/
  @javax.annotation.Nullable
  @Schema(description = "The intended use of the public key. Possible values:  - ``sig`` - Verify the signature on data. ")
  @JsonProperty(JSON_PROPERTY_USE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getUse() {
    return use;
  }

  @JsonProperty(JSON_PROPERTY_USE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUse(String use) {
    this.use = use;
  }

  public JwksKey n(String n) {

    this.n = n;
    return this;
  }

  /**
   * The RSA modulus value.
   * 
   * @return n
   **/
  @javax.annotation.Nullable
  @Schema(description = "The RSA modulus value.")
  @JsonProperty(JSON_PROPERTY_N)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getN() {
    return n;
  }

  @JsonProperty(JSON_PROPERTY_N)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setN(String n) {
    this.n = n;
  }

  public JwksKey e(String e) {

    this.e = e;
    return this;
  }

  /**
   * The RSA exponent value.
   * 
   * @return e
   **/
  @javax.annotation.Nullable
  @Schema(description = "The RSA exponent value.")
  @JsonProperty(JSON_PROPERTY_E)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getE() {
    return e;
  }

  @JsonProperty(JSON_PROPERTY_E)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setE(String e) {
    this.e = e;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JwksKey jwksKey = (JwksKey) o;
    return Objects.equals(this.kid, jwksKey.kid) &&
        Objects.equals(this.kty, jwksKey.kty) &&
        Objects.equals(this.use, jwksKey.use) &&
        Objects.equals(this.n, jwksKey.n) &&
        Objects.equals(this.e, jwksKey.e);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kid, kty, use, n, e);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JwksKey {\n");
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
    sb.append("    kty: ").append(toIndentedString(kty)).append("\n");
    sb.append("    use: ").append(toIndentedString(use)).append("\n");
    sb.append("    n: ").append(toIndentedString(n)).append("\n");
    sb.append("    e: ").append(toIndentedString(e)).append("\n");
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
