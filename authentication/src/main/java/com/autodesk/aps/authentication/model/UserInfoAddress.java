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
 * A JSON object containing information of the postal address of the user.
 */
@Schema(description = "A JSON object containing information of the postal address of the user.")
@JsonPropertyOrder({
    UserInfoAddress.JSON_PROPERTY_STREET_ADDRESS,
    UserInfoAddress.JSON_PROPERTY_LOCALITY,
    UserInfoAddress.JSON_PROPERTY_REGION,
    UserInfoAddress.JSON_PROPERTY_POSTAL_CODE,
    UserInfoAddress.JSON_PROPERTY_COUNTRY
})
@JsonTypeName("UserInfo_address")
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserInfoAddress {
  public static final String JSON_PROPERTY_STREET_ADDRESS = "street_address";
  private String streetAddress;

  public static final String JSON_PROPERTY_LOCALITY = "locality";
  private String locality;

  public static final String JSON_PROPERTY_REGION = "region";
  private String region;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postal_code";
  private String postalCode;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public UserInfoAddress streetAddress(String streetAddress) {

    this.streetAddress = streetAddress;
    return this;
  }

  /**
   * The street address part of the address. Can contain the house number, street
   * name, postal code, and so on. New lines are represented as
   * &#x60;&#x60;\n&#x60;&#x60;.
   * 
   * @return streetAddress
   **/
  @javax.annotation.Nullable
  @Schema(description = "The street address part of the address. Can contain the house number, street name, postal code, and so on.  New lines are represented as ``\\n``.")
  @JsonProperty(JSON_PROPERTY_STREET_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getStreetAddress() {
    return streetAddress;
  }

  @JsonProperty(JSON_PROPERTY_STREET_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public UserInfoAddress locality(String locality) {

    this.locality = locality;
    return this;
  }

  /**
   * The city or locality part of the address.
   * 
   * @return locality
   **/
  @javax.annotation.Nullable
  @Schema(description = "The city or locality part of the address.")
  @JsonProperty(JSON_PROPERTY_LOCALITY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLocality() {
    return locality;
  }

  @JsonProperty(JSON_PROPERTY_LOCALITY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLocality(String locality) {
    this.locality = locality;
  }

  public UserInfoAddress region(String region) {

    this.region = region;
    return this;
  }

  /**
   * The state, province, prefecture, or region part of the address.
   * 
   * @return region
   **/
  @javax.annotation.Nullable
  @Schema(description = "The state, province, prefecture, or region part of the address.")
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

  public UserInfoAddress postalCode(String postalCode) {

    this.postalCode = postalCode;
    return this;
  }

  /**
   * The zip code or postal code part of the address.
   * 
   * @return postalCode
   **/
  @javax.annotation.Nullable
  @Schema(description = "The zip code or postal code part of the address.")
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getPostalCode() {
    return postalCode;
  }

  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public UserInfoAddress country(String country) {

    this.country = country;
    return this;
  }

  /**
   * The country name part of the address.
   * 
   * @return country
   **/
  @javax.annotation.Nullable
  @Schema(description = "The country name part of the address.")
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCountry() {
    return country;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfoAddress userInfoAddress = (UserInfoAddress) o;
    return Objects.equals(this.streetAddress, userInfoAddress.streetAddress) &&
        Objects.equals(this.locality, userInfoAddress.locality) &&
        Objects.equals(this.region, userInfoAddress.region) &&
        Objects.equals(this.postalCode, userInfoAddress.postalCode) &&
        Objects.equals(this.country, userInfoAddress.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAddress, locality, region, postalCode, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfoAddress {\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
