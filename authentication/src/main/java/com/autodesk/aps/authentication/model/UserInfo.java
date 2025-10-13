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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a successful response to a Get User Info operation.
 */
@Schema(description = "Represents a successful response to a Get User Info operation.")
@JsonPropertyOrder({
    UserInfo.JSON_PROPERTY_SUB,
    UserInfo.JSON_PROPERTY_NAME,
    UserInfo.JSON_PROPERTY_GIVEN_NAME,
    UserInfo.JSON_PROPERTY_FAMILY_NAME,
    UserInfo.JSON_PROPERTY_PREFERRED_USERNAME,
    UserInfo.JSON_PROPERTY_EMAIL,
    UserInfo.JSON_PROPERTY_EMAIL_VERIFIED,
    UserInfo.JSON_PROPERTY_PROFILE,
    UserInfo.JSON_PROPERTY_PICTURE,
    UserInfo.JSON_PROPERTY_LOCALE,
    UserInfo.JSON_PROPERTY_UPDATED_AT,
    UserInfo.JSON_PROPERTY_IS2FA_ENABLED,
    UserInfo.JSON_PROPERTY_COUNTRY_CODE,
    UserInfo.JSON_PROPERTY_ADDRESS,
    UserInfo.JSON_PROPERTY_PHONE_NUMBER,
    UserInfo.JSON_PROPERTY_PHONE_NUMBER_VERIFIED,
    UserInfo.JSON_PROPERTY_LDAP_ENABLED,
    UserInfo.JSON_PROPERTY_LDAP_DOMAIN,
    UserInfo.JSON_PROPERTY_JOB_TITLE,
    UserInfo.JSON_PROPERTY_INDUSTRY,
    UserInfo.JSON_PROPERTY_INDUSTRY_CODE,
    UserInfo.JSON_PROPERTY_ABOUT_ME,
    UserInfo.JSON_PROPERTY_LANGUAGE,
    UserInfo.JSON_PROPERTY_COMPANY,
    UserInfo.JSON_PROPERTY_CREATED_DATE,
    UserInfo.JSON_PROPERTY_LAST_LOGIN_DATE,
    UserInfo.JSON_PROPERTY_EIDM_GUID,
    UserInfo.JSON_PROPERTY_OPT_IN,
    UserInfo.JSON_PROPERTY_SOCIAL_USERINFO_LIST,
    UserInfo.JSON_PROPERTY_THUMBNAILS
})
@JsonTypeName("UserInfo")
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserInfo {
  public static final String JSON_PROPERTY_SUB = "sub";
  private String sub;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_GIVEN_NAME = "given_name";
  private String givenName;

  public static final String JSON_PROPERTY_FAMILY_NAME = "family_name";
  private String familyName;

  public static final String JSON_PROPERTY_PREFERRED_USERNAME = "preferred_username";
  private String preferredUsername;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_EMAIL_VERIFIED = "email_verified";
  private Boolean emailVerified;

  public static final String JSON_PROPERTY_PROFILE = "profile";
  private String profile;

  public static final String JSON_PROPERTY_PICTURE = "picture";
  private String picture;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;

  public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
  private Integer updatedAt;

  public static final String JSON_PROPERTY_IS2FA_ENABLED = "is_2fa_enabled";
  private Boolean is2faEnabled;

  public static final String JSON_PROPERTY_COUNTRY_CODE = "country_code";
  private String countryCode;

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private UserInfoAddress address;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";
  private String phoneNumber;

  public static final String JSON_PROPERTY_PHONE_NUMBER_VERIFIED = "phone_number_verified";
  private Boolean phoneNumberVerified;

  public static final String JSON_PROPERTY_LDAP_ENABLED = "ldap_enabled";
  private Boolean ldapEnabled;

  public static final String JSON_PROPERTY_LDAP_DOMAIN = "ldap_domain";
  private String ldapDomain;

  public static final String JSON_PROPERTY_JOB_TITLE = "job_title";
  private String jobTitle;

  public static final String JSON_PROPERTY_INDUSTRY = "industry";
  private String industry;

  public static final String JSON_PROPERTY_INDUSTRY_CODE = "industry_code";
  private String industryCode;

  public static final String JSON_PROPERTY_ABOUT_ME = "about_me";
  private String aboutMe;

  public static final String JSON_PROPERTY_LANGUAGE = "language";
  private String language;

  public static final String JSON_PROPERTY_COMPANY = "company";
  private String company;

  public static final String JSON_PROPERTY_CREATED_DATE = "created_date";
  private String createdDate;

  public static final String JSON_PROPERTY_LAST_LOGIN_DATE = "last_login_date";
  private String lastLoginDate;

  public static final String JSON_PROPERTY_EIDM_GUID = "eidm_guid";
  private String eidmGuid;

  public static final String JSON_PROPERTY_OPT_IN = "opt_in";
  private Boolean optIn;

  public static final String JSON_PROPERTY_SOCIAL_USERINFO_LIST = "social_userinfo_list";
  private List<UserInfoSocialUserinfoList> socialUserinfoList = null;

  public static final String JSON_PROPERTY_THUMBNAILS = "thumbnails";
  private Map<String, String> thumbnails = null;

  public UserInfo sub(String sub) {

    this.sub = sub;
    return this;
  }

  /**
   * The ID by which APS uniquely identifies the user.
   * 
   * @return sub
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ID by which APS uniquely identifies the user.")
  @JsonProperty(JSON_PROPERTY_SUB)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getSub() {
    return sub;
  }

  @JsonProperty(JSON_PROPERTY_SUB)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSub(String sub) {
    this.sub = sub;
  }

  public UserInfo name(String name) {

    this.name = name;
    return this;
  }

  /**
   * The full name of the user.
   * 
   * @return name
   **/
  @javax.annotation.Nullable
  @Schema(description = "The full name of the user.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setName(String name) {
    this.name = name;
  }

  public UserInfo givenName(String givenName) {

    this.givenName = givenName;
    return this;
  }

  /**
   * The given name or first name of the user.
   * 
   * @return givenName
   **/
  @javax.annotation.Nullable
  @Schema(description = "The given name or first name of the user.")
  @JsonProperty(JSON_PROPERTY_GIVEN_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getGivenName() {
    return givenName;
  }

  @JsonProperty(JSON_PROPERTY_GIVEN_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public UserInfo familyName(String familyName) {

    this.familyName = familyName;
    return this;
  }

  /**
   * The surname or last name of the user.
   * 
   * @return familyName
   **/
  @javax.annotation.Nullable
  @Schema(description = "The surname or last name of the user.")
  @JsonProperty(JSON_PROPERTY_FAMILY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getFamilyName() {
    return familyName;
  }

  @JsonProperty(JSON_PROPERTY_FAMILY_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public UserInfo preferredUsername(String preferredUsername) {

    this.preferredUsername = preferredUsername;
    return this;
  }

  /**
   * The username by which the user prefers to be addressed.
   * 
   * @return preferredUsername
   **/
  @javax.annotation.Nullable
  @Schema(description = "The username by which the user prefers to be addressed.")
  @JsonProperty(JSON_PROPERTY_PREFERRED_USERNAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getPreferredUsername() {
    return preferredUsername;
  }

  @JsonProperty(JSON_PROPERTY_PREFERRED_USERNAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPreferredUsername(String preferredUsername) {
    this.preferredUsername = preferredUsername;
  }

  public UserInfo email(String email) {

    this.email = email;
    return this;
  }

  /**
   * The email address by which the user prefers to be contacted.
   * 
   * @return email
   **/
  @javax.annotation.Nullable
  @Schema(description = "The email address by which the user prefers to be contacted.")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getEmail() {
    return email;
  }

  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfo emailVerified(Boolean emailVerified) {

    this.emailVerified = emailVerified;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; : The user&#39;s preferred email address is
   * verified.
   * 
   * &#x60;&#x60;false&#x60;&#x60;: The user&#39;s preferred email address is not
   * verified.
   * 
   * @return emailVerified
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` : The user's preferred email address is verified.  ``false``: The user's preferred email address is not verified. ")
  @JsonProperty(JSON_PROPERTY_EMAIL_VERIFIED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getEmailVerified() {
    return emailVerified;
  }

  @JsonProperty(JSON_PROPERTY_EMAIL_VERIFIED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setEmailVerified(Boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public UserInfo profile(String profile) {

    this.profile = profile;
    return this;
  }

  /**
   * The URL of the profile page of the user.
   * 
   * @return profile
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URL of the profile page of the user.")
  @JsonProperty(JSON_PROPERTY_PROFILE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getProfile() {
    return profile;
  }

  @JsonProperty(JSON_PROPERTY_PROFILE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setProfile(String profile) {
    this.profile = profile;
  }

  public UserInfo picture(String picture) {

    this.picture = picture;
    return this;
  }

  /**
   * The URL of the profile picture of the user.
   * 
   * @return picture
   **/
  @javax.annotation.Nullable
  @Schema(description = "The URL of the profile picture of the user.")
  @JsonProperty(JSON_PROPERTY_PICTURE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getPicture() {
    return picture;
  }

  @JsonProperty(JSON_PROPERTY_PICTURE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPicture(String picture) {
    this.picture = picture;
  }

  public UserInfo locale(String locale) {

    this.locale = locale;
    return this;
  }

  /**
   * The preferred language settings of the user. This setting is typically
   * specified as a combination of the ISO 639 language code in lower case, and
   * the ISO 3166 country code in upper case, separated by a dash character. For
   * example &#x60;&#x60;en-US&#x60;&#x60;.
   * 
   * @return locale
   **/
  @javax.annotation.Nullable
  @Schema(description = "The preferred language settings of the user. This setting is typically specified as a combination of the ISO 639 language code in lower case, and the ISO 3166 country code in upper case, separated by a dash character. For example ``en-US``.")
  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLocale() {
    return locale;
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLocale(String locale) {
    this.locale = locale;
  }

  public UserInfo updatedAt(Integer updatedAt) {

    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The time the user&#39;s information was most recently updated, represented as
   * a Unix timestamp.
   * 
   * @return updatedAt
   **/
  @javax.annotation.Nullable
  @Schema(description = "The time the user's information was most recently updated, represented as a Unix timestamp.")
  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setUpdatedAt(Integer updatedAt) {
    this.updatedAt = updatedAt;
  }

  public UserInfo is2faEnabled(Boolean is2faEnabled) {

    this.is2faEnabled = is2faEnabled;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60;: Two-factor authentication is enabled for this
   * user.
   * 
   * &#x60;&#x60;false&#x60;&#x60;: Two-factor authentication is not enabled for
   * this user.
   * 
   * @return is2faEnabled
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true``: Two-factor authentication is enabled for this user.   ``false``: Two-factor authentication is not enabled for this user. ")
  @JsonProperty(JSON_PROPERTY_IS2FA_ENABLED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getIs2faEnabled() {
    return is2faEnabled;
  }

  @JsonProperty(JSON_PROPERTY_IS2FA_ENABLED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIs2faEnabled(Boolean is2faEnabled) {
    this.is2faEnabled = is2faEnabled;
  }

  public UserInfo countryCode(String countryCode) {

    this.countryCode = countryCode;
    return this;
  }

  /**
   * The ISO 3166 country code that was assigned to the user when their profile
   * was created.
   * 
   * @return countryCode
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ISO 3166 country code that was assigned to the user when their profile was created.")
  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCountryCode() {
    return countryCode;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public UserInfo address(UserInfoAddress address) {

    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @javax.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public UserInfoAddress getAddress() {
    return address;
  }

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAddress(UserInfoAddress address) {
    this.address = address;
  }

  public UserInfo phoneNumber(String phoneNumber) {

    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * The phone number by which the user prefers to be contacted.
   * 
   * @return phoneNumber
   **/
  @javax.annotation.Nullable
  @Schema(description = "The phone number by which the user prefers to be contacted.")
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public UserInfo phoneNumberVerified(Boolean phoneNumberVerified) {

    this.phoneNumberVerified = phoneNumberVerified;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; : The phone number is verified.
   * 
   * &#x60;&#x60;false&#x60;&#x60; : The phone number is not verified.
   * 
   * @return phoneNumberVerified
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` : The phone number is verified.  ``false`` : The phone number is not verified. ")
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER_VERIFIED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getPhoneNumberVerified() {
    return phoneNumberVerified;
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER_VERIFIED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPhoneNumberVerified(Boolean phoneNumberVerified) {
    this.phoneNumberVerified = phoneNumberVerified;
  }

  public UserInfo ldapEnabled(Boolean ldapEnabled) {

    this.ldapEnabled = ldapEnabled;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; : Single sign-on using Lightweight Directory
   * Access Protocol (LDAP) is enabled for this user.
   * 
   * &#x60;&#x60;false&#x60;&#x60; : LDAP is not enabled for this user.
   * 
   * @return ldapEnabled
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` :  Single sign-on using Lightweight Directory Access Protocol (LDAP) is enabled for this user.  ``false`` : LDAP is not enabled for this user. ")
  @JsonProperty(JSON_PROPERTY_LDAP_ENABLED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getLdapEnabled() {
    return ldapEnabled;
  }

  @JsonProperty(JSON_PROPERTY_LDAP_ENABLED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLdapEnabled(Boolean ldapEnabled) {
    this.ldapEnabled = ldapEnabled;
  }

  public UserInfo ldapDomain(String ldapDomain) {

    this.ldapDomain = ldapDomain;
    return this;
  }

  /**
   * The domain name used by the LDAP server for user authentication.
   * &#x60;&#x60;null&#x60;&#x60;, if &#x60;&#x60;ldap_enabled&#x60;&#x60; is
   * &#x60;&#x60;false&#x60;&#x60;.
   * 
   * @return ldapDomain
   **/
  @javax.annotation.Nullable
  @Schema(description = "The domain name used by the LDAP server for user authentication. ``null``, if ``ldap_enabled`` is ``false``.")
  @JsonProperty(JSON_PROPERTY_LDAP_DOMAIN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLdapDomain() {
    return ldapDomain;
  }

  @JsonProperty(JSON_PROPERTY_LDAP_DOMAIN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLdapDomain(String ldapDomain) {
    this.ldapDomain = ldapDomain;
  }

  public UserInfo jobTitle(String jobTitle) {

    this.jobTitle = jobTitle;
    return this;
  }

  /**
   * The job title of the user as specified in the user&#39;s profile.
   * 
   * @return jobTitle
   **/
  @javax.annotation.Nullable
  @Schema(description = "The job title of the user as specified in the user's profile.")
  @JsonProperty(JSON_PROPERTY_JOB_TITLE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getJobTitle() {
    return jobTitle;
  }

  @JsonProperty(JSON_PROPERTY_JOB_TITLE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public UserInfo industry(String industry) {

    this.industry = industry;
    return this;
  }

  /**
   * The industry the user works in, as specified in the user&#39;s profile.
   * 
   * @return industry
   **/
  @javax.annotation.Nullable
  @Schema(description = "The industry the user works in, as specified in the user's profile.")
  @JsonProperty(JSON_PROPERTY_INDUSTRY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIndustry() {
    return industry;
  }

  @JsonProperty(JSON_PROPERTY_INDUSTRY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public UserInfo industryCode(String industryCode) {

    this.industryCode = industryCode;
    return this;
  }

  /**
   * A code that corresponds to the industry.
   * 
   * @return industryCode
   **/
  @javax.annotation.Nullable
  @Schema(description = "A code that corresponds to the industry.")
  @JsonProperty(JSON_PROPERTY_INDUSTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getIndustryCode() {
    return industryCode;
  }

  @JsonProperty(JSON_PROPERTY_INDUSTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setIndustryCode(String industryCode) {
    this.industryCode = industryCode;
  }

  public UserInfo aboutMe(String aboutMe) {

    this.aboutMe = aboutMe;
    return this;
  }

  /**
   * A short description written by the user to introduce themselves, as specified
   * in the user&#39;s profile.
   * 
   * @return aboutMe
   **/
  @javax.annotation.Nullable
  @Schema(description = "A short description written by the user to introduce themselves, as specified in the user's profile.")
  @JsonProperty(JSON_PROPERTY_ABOUT_ME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getAboutMe() {
    return aboutMe;
  }

  @JsonProperty(JSON_PROPERTY_ABOUT_ME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public UserInfo language(String language) {

    this.language = language;
    return this;
  }

  /**
   * The ISO 639 language code of the preferred language of the user.
   * 
   * @return language
   **/
  @javax.annotation.Nullable
  @Schema(description = "The ISO 639 language code of the preferred language of the user.")
  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLanguage() {
    return language;
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLanguage(String language) {
    this.language = language;
  }

  public UserInfo company(String company) {

    this.company = company;
    return this;
  }

  /**
   * The company that the user works for, as specified in the user&#39;s profile.
   * 
   * @return company
   **/
  @javax.annotation.Nullable
  @Schema(description = "The company that the user works for, as specified in the user's profile.")
  @JsonProperty(JSON_PROPERTY_COMPANY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCompany() {
    return company;
  }

  @JsonProperty(JSON_PROPERTY_COMPANY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCompany(String company) {
    this.company = company;
  }

  public UserInfo createdDate(String createdDate) {

    this.createdDate = createdDate;
    return this;
  }

  /**
   * The time the user profile was created, represented as a Unix timestamp.
   * 
   * @return createdDate
   **/
  @javax.annotation.Nullable
  @Schema(description = "The time the user profile was created, represented as a Unix timestamp.")
  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCreatedDate() {
    return createdDate;
  }

  @JsonProperty(JSON_PROPERTY_CREATED_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public UserInfo lastLoginDate(String lastLoginDate) {

    this.lastLoginDate = lastLoginDate;
    return this;
  }

  /**
   * The time the user most recently signed-in to APS successfully, represented as
   * a Unix timestamp.
   * 
   * @return lastLoginDate
   **/
  @javax.annotation.Nullable
  @Schema(description = "The time the user most recently signed-in to APS successfully, represented as a Unix timestamp.")
  @JsonProperty(JSON_PROPERTY_LAST_LOGIN_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getLastLoginDate() {
    return lastLoginDate;
  }

  @JsonProperty(JSON_PROPERTY_LAST_LOGIN_DATE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLastLoginDate(String lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public UserInfo eidmGuid(String eidmGuid) {

    this.eidmGuid = eidmGuid;
    return this;
  }

  /**
   * An ID to uniquely identify the user. For most users this will be the same as
   * &#x60;&#x60;sub&#x60;&#x60;. However, for users profiles created on the now
   * retired EIDM system &#x60;&#x60;eidm_guid&#x60;&#x60; will be different from
   * &#x60;&#x60;sub&#x60;&#x60;.
   * 
   * @return eidmGuid
   **/
  @javax.annotation.Nullable
  @Schema(description = "An ID to uniquely identify the user. For most users this will be the same as ``sub``. However, for users profiles created on the now retired EIDM system ``eidm_guid`` will be different from ``sub``.")
  @JsonProperty(JSON_PROPERTY_EIDM_GUID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getEidmGuid() {
    return eidmGuid;
  }

  @JsonProperty(JSON_PROPERTY_EIDM_GUID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setEidmGuid(String eidmGuid) {
    this.eidmGuid = eidmGuid;
  }

  public UserInfo optIn(Boolean optIn) {

    this.optIn = optIn;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60; : The user has agreed to receive marketing
   * information.
   * 
   * &#x60;&#x60;false&#x60;&#x60;: The user does not want to receive marketing
   * information.
   * 
   * @return optIn
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true`` : The user has agreed to receive marketing information.  ``false``: The user does not want to receive marketing information. ")
  @JsonProperty(JSON_PROPERTY_OPT_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getOptIn() {
    return optIn;
  }

  @JsonProperty(JSON_PROPERTY_OPT_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setOptIn(Boolean optIn) {
    this.optIn = optIn;
  }

  public UserInfo socialUserinfoList(List<UserInfoSocialUserinfoList> socialUserinfoList) {

    this.socialUserinfoList = socialUserinfoList;
    return this;
  }

  public UserInfo addsocialUserinfoListItem(UserInfoSocialUserinfoList socialUserinfoListItem) {
    if (this.socialUserinfoList == null) {
      this.socialUserinfoList = new ArrayList<>();
    }
    this.socialUserinfoList.add(socialUserinfoListItem);
    return this;
  }

  /**
   * An array of objects, where each object represents a social media account that
   * can be used to verify the user&#39;s identity.
   * 
   * @return socialUserinfoList
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of objects, where each object represents a social media account that can be used to verify the user's identity.")
  @JsonProperty(JSON_PROPERTY_SOCIAL_USERINFO_LIST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<UserInfoSocialUserinfoList> getSocialUserinfoList() {
    return socialUserinfoList;
  }

  @JsonProperty(JSON_PROPERTY_SOCIAL_USERINFO_LIST)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setSocialUserinfoList(List<UserInfoSocialUserinfoList> socialUserinfoList) {
    this.socialUserinfoList = socialUserinfoList;
  }

  public UserInfo thumbnails(Map<String, String> thumbnails) {

    this.thumbnails = thumbnails;
    return this;
  }

  public UserInfo putthumbnailsItem(String key, String thumbnailsItem) {
    if (this.thumbnails == null) {
      this.thumbnails = new HashMap<>();
    }
    this.thumbnails.put(key, thumbnailsItem);
    return this;
  }

  /**
   * An array of key-value pairs containing image URLs for various thumbnail sizes
   * of the user&#39;s profile picture. The key is named
   * &#x60;&#x60;sizeX&lt;NUMBER&gt;&#x60;&#x60; where
   * &#x60;&#x60;&lt;NUMBER&gt;&#x60;&#x60; is the width and height of the
   * thumbnail, in pixels. The corresponding value is the URL pointing to the
   * thumbnail. For example, &#x60;&#x60;sizeX200&#x60;&#x60; would contain the
   * URL for the 200x200 pixel thumbnail.
   * 
   * @return thumbnails
   **/
  @javax.annotation.Nullable
  @Schema(description = "An array of key-value pairs containing image URLs for various thumbnail sizes of the user's profile picture. The key is named ``sizeX<NUMBER>`` where ``<NUMBER>`` is the width and height of the thumbnail, in pixels. The corresponding value is the URL pointing to the thumbnail. For example, ``sizeX200`` would contain the URL for the 200x200 pixel thumbnail.")
  @JsonProperty(JSON_PROPERTY_THUMBNAILS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Map<String, String> getThumbnails() {
    return thumbnails;
  }

  @JsonProperty(JSON_PROPERTY_THUMBNAILS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setThumbnails(Map<String, String> thumbnails) {
    this.thumbnails = thumbnails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.sub, userInfo.sub) &&
        Objects.equals(this.name, userInfo.name) &&
        Objects.equals(this.givenName, userInfo.givenName) &&
        Objects.equals(this.familyName, userInfo.familyName) &&
        Objects.equals(this.preferredUsername, userInfo.preferredUsername) &&
        Objects.equals(this.email, userInfo.email) &&
        Objects.equals(this.emailVerified, userInfo.emailVerified) &&
        Objects.equals(this.profile, userInfo.profile) &&
        Objects.equals(this.picture, userInfo.picture) &&
        Objects.equals(this.locale, userInfo.locale) &&
        Objects.equals(this.updatedAt, userInfo.updatedAt) &&
        Objects.equals(this.is2faEnabled, userInfo.is2faEnabled) &&
        Objects.equals(this.countryCode, userInfo.countryCode) &&
        Objects.equals(this.address, userInfo.address) &&
        Objects.equals(this.phoneNumber, userInfo.phoneNumber) &&
        Objects.equals(this.phoneNumberVerified, userInfo.phoneNumberVerified) &&
        Objects.equals(this.ldapEnabled, userInfo.ldapEnabled) &&
        Objects.equals(this.ldapDomain, userInfo.ldapDomain) &&
        Objects.equals(this.jobTitle, userInfo.jobTitle) &&
        Objects.equals(this.industry, userInfo.industry) &&
        Objects.equals(this.industryCode, userInfo.industryCode) &&
        Objects.equals(this.aboutMe, userInfo.aboutMe) &&
        Objects.equals(this.language, userInfo.language) &&
        Objects.equals(this.company, userInfo.company) &&
        Objects.equals(this.createdDate, userInfo.createdDate) &&
        Objects.equals(this.lastLoginDate, userInfo.lastLoginDate) &&
        Objects.equals(this.eidmGuid, userInfo.eidmGuid) &&
        Objects.equals(this.optIn, userInfo.optIn) &&
        Objects.equals(this.socialUserinfoList, userInfo.socialUserinfoList) &&
        Objects.equals(this.thumbnails, userInfo.thumbnails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sub, name, givenName, familyName, preferredUsername, email, emailVerified, profile, picture,
        locale, updatedAt, is2faEnabled, countryCode, address, phoneNumber, phoneNumberVerified, ldapEnabled,
        ldapDomain, jobTitle, industry, industryCode, aboutMe, language, company, createdDate, lastLoginDate, eidmGuid,
        optIn, socialUserinfoList, thumbnails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    preferredUsername: ").append(toIndentedString(preferredUsername)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    emailVerified: ").append(toIndentedString(emailVerified)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    is2faEnabled: ").append(toIndentedString(is2faEnabled)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    phoneNumberVerified: ").append(toIndentedString(phoneNumberVerified)).append("\n");
    sb.append("    ldapEnabled: ").append(toIndentedString(ldapEnabled)).append("\n");
    sb.append("    ldapDomain: ").append(toIndentedString(ldapDomain)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    industry: ").append(toIndentedString(industry)).append("\n");
    sb.append("    industryCode: ").append(toIndentedString(industryCode)).append("\n");
    sb.append("    aboutMe: ").append(toIndentedString(aboutMe)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastLoginDate: ").append(toIndentedString(lastLoginDate)).append("\n");
    sb.append("    eidmGuid: ").append(toIndentedString(eidmGuid)).append("\n");
    sb.append("    optIn: ").append(toIndentedString(optIn)).append("\n");
    sb.append("    socialUserinfoList: ").append(toIndentedString(socialUserinfoList)).append("\n");
    sb.append("    thumbnails: ").append(toIndentedString(thumbnails)).append("\n");
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
