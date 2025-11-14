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
package com.autodesk.aps.modelderivative;

import java.io.InputStream;

import com.autodesk.aps.modelderivative.api.DerivativesApi;
import com.autodesk.aps.modelderivative.api.InformationalApi;
import com.autodesk.aps.modelderivative.api.JobsApi;
import com.autodesk.aps.modelderivative.api.ManifestApi;
import com.autodesk.aps.modelderivative.api.MetadataApi;
import com.autodesk.aps.modelderivative.api.ThumbnailsApi;
import com.autodesk.aps.modelderivative.model.DeleteManifest;
import com.autodesk.aps.modelderivative.model.DeleteManifestOptionalParams;
import com.autodesk.aps.modelderivative.model.DerivativeDownload;
import com.autodesk.aps.modelderivative.model.FetchSpecificPropertiesOptionalParams;
import com.autodesk.aps.modelderivative.model.GetAllPropertiesOptionalParams;
import com.autodesk.aps.modelderivative.model.GetDerivativeUrlOptionalParams;
import com.autodesk.aps.modelderivative.model.GetFormatsOptionalParams;
import com.autodesk.aps.modelderivative.model.GetManifestOptionalParams;
import com.autodesk.aps.modelderivative.model.GetModelViewsOptionalParams;
import com.autodesk.aps.modelderivative.model.GetObjectTreeOptionalParams;
import com.autodesk.aps.modelderivative.model.GetThumbnailOptionalParams;
import com.autodesk.aps.modelderivative.model.HeadCheckDerivativeOptionalParams;
import com.autodesk.aps.modelderivative.model.Job;
import com.autodesk.aps.modelderivative.model.JobPayload;
import com.autodesk.aps.modelderivative.model.Manifest;
import com.autodesk.aps.modelderivative.model.ModelViews;
import com.autodesk.aps.modelderivative.model.ObjectTree;
import com.autodesk.aps.modelderivative.model.Properties;
import com.autodesk.aps.modelderivative.model.SpecificProperties;
import com.autodesk.aps.modelderivative.model.SpecificPropertiesPayload;
import com.autodesk.aps.modelderivative.model.SpecifyReferences;
import com.autodesk.aps.modelderivative.model.SpecifyReferencesOptionalParams;
import com.autodesk.aps.modelderivative.model.SpecifyReferencesPayload;
import com.autodesk.aps.modelderivative.model.StartJobOptionalParams;
import com.autodesk.aps.modelderivative.model.SupportedFormats;
import com.autodesk.aps.sdkmanager.BaseClient;
import com.autodesk.aps.sdkmanager.IAuthenticationProvider;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;

public class ModelDerivativeClient extends BaseClient {
    private final DerivativesApi derivativesApi;
    private final InformationalApi informationalApi;
    private final ManifestApi manifestApi;
    private final MetadataApi metadataApi;
    private final ThumbnailsApi thumbnailsApi;
    private final JobsApi jobsApi;

    /**
     * Initializes a new instance of the ModelDerivativeClient class.
     * 
     * @param sdkManager             The SDK manager instance.
     * @param authenticationProvider The authentication provider.
     */
    public ModelDerivativeClient(SdkManager sdkManager, IAuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
        if (sdkManager == null) {
            sdkManager = SdkManagerBuilder.create().build();
        }
        this.derivativesApi = new DerivativesApi(sdkManager);
        this.informationalApi = new InformationalApi(sdkManager);
        this.manifestApi = new ManifestApi(sdkManager);
        this.metadataApi = new MetadataApi(sdkManager);
        this.thumbnailsApi = new ThumbnailsApi(sdkManager);
        this.jobsApi = new JobsApi(sdkManager);

    }

    /**
     * Initializes a new instance of the ModelDerivativeClient class with a default
     * SDK manager.
     * 
     * @param authenticationProvider The authentication provider.
     */
    public ModelDerivativeClient(IAuthenticationProvider authenticationProvider) {
        this(SdkManagerBuilder.create().build(), authenticationProvider);
    }

    /**
     * Initializes a new instance of the ModelDerivativeClient class without an
     * authentication provider.
     * 
     * @param sdkManager
     */

    public ModelDerivativeClient(SdkManager sdkManager) {
        this(sdkManager, null);
    }

    /**
     * Initializes a new instance of the ModelDerivativeClient class with a default
     * SDK manager and without an authentication provider.
     */
    public ModelDerivativeClient() {
        this(SdkManagerBuilder.create().build(), null);
    }

    /**
     * Closes the underlying connection.
     */
    public void close() {
        this.informationalApi.close();
    }

    /**
     * Delete Manifest
     * Deletes the manifest of the specified source design. It also deletes all
     * derivatives (translated output files) generated from the source design.
     * However, it does not delete the source design.
     * 
     * **Note:** This operation is idempotent. So, if you call it multiple times,
     * even when no manifest exists, will still return a successful response (200).
     * 
     * @param urn The URL-safe Base64 encoded URN of the source design. (required)
     * @return DeleteManifest
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public DeleteManifest deleteManifest(String urn) throws ModelDerivativeApiException {
        return deleteManifest(urn, null);
    }

    /**
     * Delete Manifest
     * Deletes the manifest of the specified source design. It also deletes all
     * derivatives (translated output files) generated from the source design.
     * However, it does not delete the source design.
     * 
     * **Note:** This operation is idempotent. So, if you call it multiple times,
     * even when no manifest exists, will still return a successful response (200).
     * 
     * @param urn                          The URL-safe Base64 encoded URN of the
     *                                     source design. (required)
     * @param deleteManifestOptionalParams class containing all optional parameters
     *                                     for the deleteManifest method.
     * @return DeleteManifest
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public DeleteManifest deleteManifest(String urn, DeleteManifestOptionalParams deleteManifestOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (deleteManifestOptionalParams == null) {
                deleteManifestOptionalParams = new DeleteManifestOptionalParams.Builder().build();
            }
            if (deleteManifestOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (deleteManifestOptionalParams.getAccessToken() == null) {
                deleteManifestOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return manifestApi.deleteManifest(urn, deleteManifestOptionalParams.getRegion(),
                    deleteManifestOptionalParams.getAccessToken()).getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Fetch Specific Properties
     * Queries the objects in the Model View (Viewable) specified by the
     * &#x60;&#x60;modelGuid&#x60;&#x60; parameter and returns the specified
     * properties in a paginated list. You can limit the number of objects to be
     * queried by specifying a filter using the &#x60;&#x60;query&#x60;&#x60;
     * attribute in the request body.
     * 
     * **Note:** A design file must be translated to SVF or SVF2 before you can
     * query object properties.
     * 
     * Before you call this operation:
     * 
     * - Use the &#x60;List Model Views
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
     * operation to obtain the list of Model Views in the source design.
     * - Pick the ID of the Model View you want to query and specify that ID as the
     * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * @param urn                       The URL-safe Base64 encoded URN of the
     *                                  source design. (required)
     * @param modelGuid                 The ID of the Model View you are querying.
     *                                  Use the &#x60;List Model Views
     *                                  &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
     *                                  operation to get the IDs of the Model Views
     *                                  in the source design. (required)
     * @param specificPropertiesPayload (required)
     * @return SpecificProperties
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public SpecificProperties fetchSpecificProperties(String urn, String modelGuid,
            SpecificPropertiesPayload specificPropertiesPayload) throws ModelDerivativeApiException {
        return fetchSpecificProperties(urn, modelGuid, specificPropertiesPayload, null);
    }

    /**
     * Fetch Specific Properties
     * Queries the objects in the Model View (Viewable) specified by the
     * &#x60;&#x60;modelGuid&#x60;&#x60; parameter and returns the specified
     * properties in a paginated list. You can limit the number of objects to be
     * queried by specifying a filter using the &#x60;&#x60;query&#x60;&#x60;
     * attribute in the request body.
     * 
     * **Note:** A design file must be translated to SVF or SVF2 before you can
     * query object properties.
     * 
     * Before you call this operation:
     * 
     * - Use the &#x60;List Model Views
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
     * operation to obtain the list of Model Views in the source design.
     * - Pick the ID of the Model View you want to query and specify that ID as the
     * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * @param urn                                   The URL-safe Base64 encoded URN
     *                                              of the source design. (required)
     * @param modelGuid                             The ID of the Model View you are
     *                                              querying. Use the &#x60;List
     *                                              Model Views
     *                                              &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
     *                                              operation to get the IDs of the
     *                                              Model Views in the source
     *                                              design. (required)
     * @param specificPropertiesPayload             (required)
     * @param fetchSpecificPropertiesOptionalParams class containing all optional
     *                                              parameters for the
     *                                              fetchSpecificProperties method.
     * @return SpecificProperties
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public SpecificProperties fetchSpecificProperties(String urn, String modelGuid,
            SpecificPropertiesPayload specificPropertiesPayload,
            FetchSpecificPropertiesOptionalParams fetchSpecificPropertiesOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (fetchSpecificPropertiesOptionalParams == null) {
                fetchSpecificPropertiesOptionalParams = new FetchSpecificPropertiesOptionalParams.Builder().build();
            }
            if (fetchSpecificPropertiesOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (fetchSpecificPropertiesOptionalParams.getAccessToken() == null) {
                fetchSpecificPropertiesOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return metadataApi.fetchSpecificProperties(urn, modelGuid, specificPropertiesPayload,
                    fetchSpecificPropertiesOptionalParams.getAcceptEncoding(),
                    fetchSpecificPropertiesOptionalParams.getRegion(),
                    fetchSpecificPropertiesOptionalParams.getXAdsDerivativeFormat(),
                    fetchSpecificPropertiesOptionalParams.getAccessToken()).getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Fetch All Properties
     * Returns a list of properties of all objects in the Model View specified by
     * the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * This operation returns properties of all objects by default. However, you can
     * restrict the results to a specific object by specifying its ID as the
     * &#x60;&#x60;objectid&#x60;&#x60; parameter.
     * 
     * Properties are returned as a flat list, ordered, by their
     * &#x60;&#x60;objectid&#x60;&#x60;. The &#x60;&#x60;objectid&#x60;&#x60; is a
     * non-persistent ID assigned to an object when the source design is translated
     * to the SVF or SVF2 format. This means that:
     * 
     * - A design file must be translated to SVF or SVF2 before you can retrieve
     * properties.
     * - The &#x60;&#x60;objectid&#x60;&#x60; of an object can change if the design
     * is translated to SVF or SVF2 again. If you require a persistent ID across
     * translations, use &#x60;&#x60;externalId&#x60;&#x60; to reference objects,
     * instead of &#x60;&#x60;objectid&#x60;&#x60;.
     * 
     * Before you call this operation:
     * 
     * - Use the &#x60;List Model Views
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
     * operation to obtain the list of Model Views (Viewables) in the source design.
     * - Pick the ID of the Model View you want to query and specify that ID as the
     * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * **Tip**: Use &#x60;Fetch Specific Properties
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-guid-properties-query-POST/&gt;&#x60;_
     * to retrieve only the objects and properties of interest. What’s more, the
     * response is paginated. So, when the number of properties returned is large,
     * responses start arriving more promptly.
     * 
     * @param urn       The URL-safe Base64 encoded URN of the source design.
     *                  (required)
     * @param modelGuid The ID of the Model View you are querying. Use the
     *                  &#x60;List Model Views
     *                  &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
     *                  operation to get the IDs of the Model Views in the source
     *                  design. (required)
     * @return Properties
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public Properties getAllProperties(String urn, String modelGuid) throws ModelDerivativeApiException {
        return getAllProperties(urn, modelGuid, null);
    }

    /**
     * Fetch All Properties
     * Returns a list of properties of all objects in the Model View specified by
     * the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * This operation returns properties of all objects by default. However, you can
     * restrict the results to a specific object by specifying its ID as the
     * &#x60;&#x60;objectid&#x60;&#x60; parameter.
     * 
     * Properties are returned as a flat list, ordered, by their
     * &#x60;&#x60;objectid&#x60;&#x60;. The &#x60;&#x60;objectid&#x60;&#x60; is a
     * non-persistent ID assigned to an object when the source design is translated
     * to the SVF or SVF2 format. This means that:
     * 
     * - A design file must be translated to SVF or SVF2 before you can retrieve
     * properties.
     * - The &#x60;&#x60;objectid&#x60;&#x60; of an object can change if the design
     * is translated to SVF or SVF2 again. If you require a persistent ID across
     * translations, use &#x60;&#x60;externalId&#x60;&#x60; to reference objects,
     * instead of &#x60;&#x60;objectid&#x60;&#x60;.
     * 
     * Before you call this operation:
     * 
     * - Use the &#x60;List Model Views
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
     * operation to obtain the list of Model Views (Viewables) in the source design.
     * - Pick the ID of the Model View you want to query and specify that ID as the
     * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * **Tip**: Use &#x60;Fetch Specific Properties
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-guid-properties-query-POST/&gt;&#x60;_
     * to retrieve only the objects and properties of interest. What's more, the
     * response is paginated. So, when the number of properties returned is large,
     * responses start arriving more promptly.
     * 
     * @param urn                            The URL-safe Base64 encoded URN of the
     *                                       source design. (required)
     * @param modelGuid                      The ID of the Model View you are
     *                                       querying. Use the &#x60;List Model
     *                                       Views
     *                                       &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
     *                                       operation to get the IDs of the Model
     *                                       Views in the source design. (required)
     * @param getAllPropertiesOptionalParams class containing all optional
     *                                       parameters for the getAllProperties
     *                                       method.
     * @return Properties
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public Properties getAllProperties(String urn, String modelGuid,
            GetAllPropertiesOptionalParams getAllPropertiesOptionalParams) throws ModelDerivativeApiException {
        try {
            if (getAllPropertiesOptionalParams == null) {
                getAllPropertiesOptionalParams = new GetAllPropertiesOptionalParams.Builder().build();
            }
            if (getAllPropertiesOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getAllPropertiesOptionalParams.getAccessToken() == null) {
                getAllPropertiesOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return metadataApi.getAllProperties(urn, modelGuid, getAllPropertiesOptionalParams.getAcceptEncoding(),
                    getAllPropertiesOptionalParams.getXAdsForce(),
                    getAllPropertiesOptionalParams.getXAdsDerivativeFormat(),
                    getAllPropertiesOptionalParams.getRegion(), getAllPropertiesOptionalParams.getObjectid(),
                    getAllPropertiesOptionalParams.getForceget(), getAllPropertiesOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Fetch Derivative Download URL
     * Returns a download URL and a set of signed cookies, which lets you securely
     * download the derivative specified by the
     * &#x60;&#x60;derivativeUrn&#x60;&#x60; URI parameter. The signed cookies have
     * a lifetime of 6 hours. You can use range headers with the returned download
     * URL to download the derivative in chunks, in parallel.
     * 
     * @param derivativeUrn The URL-encoded URN of the derivative. Use the
     *                      &#x60;Fetch Manifest operation
     *                      &lt;/en/docs/model-derivative/v2/reference/http/manifest/urn-manifest-GET/&gt;&#x60;_to
     *                      obtain the URNs of derivatives for the specified source
     *                      design. (required)
     * @param urn           The URL-safe Base64 encoded URN of the source design.
     *                      (required)
     * @return DerivativeDownload
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public DerivativeDownload getDerivativeUrl(String derivativeUrn, String urn) throws ModelDerivativeApiException {
        return getDerivativeUrl(derivativeUrn, urn, null);
    }

    /**
     * Fetch Derivative Download URL
     * Returns a download URL and a set of signed cookies, which lets you securely
     * download the derivative specified by the
     * &#x60;&#x60;derivativeUrn&#x60;&#x60; URI parameter. The signed cookies have
     * a lifetime of 6 hours. You can use range headers with the returned download
     * URL to download the derivative in chunks, in parallel.
     * 
     * @param derivativeUrn                  The URL-encoded URN of the derivative.
     *                                       Use the &#x60;Fetch Manifest operation
     *                                       &lt;/en/docs/model-derivative/v2/reference/http/manifest/urn-manifest-GET/&gt;&#x60;_to
     *                                       obtain the URNs of derivatives for the
     *                                       specified source design. (required)
     * @param urn                            The URL-safe Base64 encoded URN of the
     *                                       source design. (required)
     * @param getDerivativeUrlOptionalParams class containing all optional
     *                                       parameters for the getDerivativeUrl
     *                                       method.
     * @return DerivativeDownload
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public DerivativeDownload getDerivativeUrl(String derivativeUrn, String urn,
            GetDerivativeUrlOptionalParams getDerivativeUrlOptionalParams) throws ModelDerivativeApiException {
        try {
            if (getDerivativeUrlOptionalParams == null) {
                getDerivativeUrlOptionalParams = new GetDerivativeUrlOptionalParams.Builder().build();
            }
            if (getDerivativeUrlOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getDerivativeUrlOptionalParams.getAccessToken() == null) {
                getDerivativeUrlOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return derivativesApi
                    .getDerivativeUrl(derivativeUrn, urn, getDerivativeUrlOptionalParams.getMinutesExpiration(),
                            getDerivativeUrlOptionalParams.getResponseContentDisposition(),
                            getDerivativeUrlOptionalParams.getRegion(), getDerivativeUrlOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * List Supported Formats
     * Returns an up-to-date list of supported translations. This operation also
     * provides information on the types of derivatives that can be generated for
     * each source design file type. Furthermore, it allows you to obtain a list of
     * translations that have changed since a specified date.
     * 
     * See the [Supported Translation Formats
     * table](/en/docs/model-derivative/v2/overview/supported-translations/) for
     * more details.
     * 
     * **Note:** We keep adding new file formats to our supported translations list,
     * constantly.
     * 
     * @return SupportedFormats
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public SupportedFormats getFormats() throws ModelDerivativeApiException {
        return getFormats(null);
    }

    /**
     * List Supported Formats
     * Returns an up-to-date list of supported translations. This operation also
     * provides information on the types of derivatives that can be generated for
     * each source design file type. Furthermore, it allows you to obtain a list of
     * translations that have changed since a specified date.
     * 
     * See the [Supported Translation Formats
     * table](/en/docs/model-derivative/v2/overview/supported-translations/) for
     * more details.
     * 
     * **Note:** We keep adding new file formats to our supported translations list,
     * constantly.
     * 
     * @param getFormatsOptionalParams class containing all optional parameters for
     *                                 the getFormats method.
     * @return SupportedFormats
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public SupportedFormats getFormats(GetFormatsOptionalParams getFormatsOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (getFormatsOptionalParams == null) {
                getFormatsOptionalParams = new GetFormatsOptionalParams.Builder().build();
            }
            if (getFormatsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getFormatsOptionalParams.getAccessToken() == null) {
                getFormatsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return informationalApi
                    .getFormats(getFormatsOptionalParams.getIfModifiedSince(),
                            getFormatsOptionalParams.getAcceptEncoding(), getFormatsOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Fetch Manifest
     * Retrieves the manifest of the specified source design.
     * 
     * The manifest is a JSON file containing information about all the derivatives
     * translated from the specified source design. It contains information such as
     * the URNs of the derivatives, the translation status of each derivative, and
     * much more.
     * 
     * The first time you translate a source design, the Model Derivative service
     * creates a manifest for that design. Thereafter, every time you translate that
     * source design, even to a different format, the Model Derivative service
     * updates the same manifest. It does not create a new manifest. Instead, the
     * manifest acts like a central registry for all the derivatives of your source
     * design created through the Model Derivative service.
     * 
     * When the Model Derivative service starts a translation job (as a result of a
     * request you make using &#x60;Create Translation Job
     * &lt;/en/docs/model-derivative/v2/reference/http/jobs/job-POST/&gt;&#x60;_),
     * it keeps on updating the manifest at regular intervals. So, you can use the
     * manifest to check the status and progress of each derivative that is being
     * generated. When multiple derivatives have been requested each derivative may
     * complete at a different time. So, each derivative has its own
     * &#x60;&#x60;status&#x60;&#x60; attribute. The manifest also contains an
     * overall &#x60;&#x60;status&#x60;&#x60; attribute. The overall
     * &#x60;&#x60;status&#x60;&#x60; becomes &#x60;&#x60;complete&#x60;&#x60; when
     * the &#x60;&#x60;status&#x60;&#x60; of all individual derivatives become
     * complete.
     * 
     * Once the translation status of a derivative is
     * &#x60;&#x60;complete&#x60;&#x60; you can download the derivative.
     * 
     * **Note:** You cannot download 3D SVF2 derivatives.
     * 
     * @param urn The URL-safe Base64 encoded URN of the source design. (required)
     * @return Manifest
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public Manifest getManifest(String urn) throws ModelDerivativeApiException {
        return getManifest(urn, null);
    }

    /**
     * Fetch Manifest
     * Retrieves the manifest of the specified source design.
     * 
     * The manifest is a JSON file containing information about all the derivatives
     * translated from the specified source design. It contains information such as
     * the URNs of the derivatives, the translation status of each derivative, and
     * much more.
     * 
     * The first time you translate a source design, the Model Derivative service
     * creates a manifest for that design. Thereafter, every time you translate that
     * source design, even to a different format, the Model Derivative service
     * updates the same manifest. It does not create a new manifest. Instead, the
     * manifest acts like a central registry for all the derivatives of your source
     * design created through the Model Derivative service.
     * 
     * When the Model Derivative service starts a translation job (as a result of a
     * request you make using &#x60;Create Translation Job
     * &lt;/en/docs/model-derivative/v2/reference/http/jobs/job-POST/&gt;&#x60;_),
     * it keeps on updating the manifest at regular intervals. So, you can use the
     * manifest to check the status and progress of each derivative that is being
     * generated. When multiple derivatives have been requested each derivative may
     * complete at a different time. So, each derivative has its own
     * &#x60;&#x60;status&#x60;&#x60; attribute. The manifest also contains an
     * overall &#x60;&#x60;status&#x60;&#x60; attribute. The overall
     * &#x60;&#x60;status&#x60;&#x60; becomes &#x60;&#x60;complete&#x60;&#x60; when
     * the &#x60;&#x60;status&#x60;&#x60; of all individual derivatives become
     * complete.
     * 
     * Once the translation status of a derivative is
     * &#x60;&#x60;complete&#x60;&#x60; you can download the derivative.
     * 
     * **Note:** You cannot download 3D SVF2 derivatives.
     * 
     * @param urn                       The URL-safe Base64 encoded URN of the
     *                                  source design. (required)
     * @param getManifestOptionalParams class containing all optional parameters for
     *                                  the getManifest method.
     * @return Manifest
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public Manifest getManifest(String urn, GetManifestOptionalParams getManifestOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (getManifestOptionalParams == null) {
                getManifestOptionalParams = new GetManifestOptionalParams.Builder().build();
            }
            if (getManifestOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getManifestOptionalParams.getAccessToken() == null) {
                getManifestOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return manifestApi
                    .getManifest(urn, getManifestOptionalParams.getAcceptEncoding(),
                            getManifestOptionalParams.getRegion(), getManifestOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * List Model Views
     * Returns a list of Model Views (Viewables) in the source design specified by
     * the &#x60;&#x60;urn&#x60;&#x60; parameter. It also returns an ID that
     * uniquely identifies the Model View. You can use these IDs with other metadata
     * operations to obtain information about the objects within those Model Views.
     * 
     * Designs created with applications like Fusion 360 and Inventor contain only
     * one Model View per design. Applications like Revit allow multiple Model Views
     * per design.
     * 
     * **Note:** You can retrieve metadata only from a design that has already been
     * translated to SVF or SVF2.
     * 
     * @param urn The URL-safe Base64 encoded URN of the source design. (required)
     * @return ModelViews
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public ModelViews getModelViews(String urn) throws ModelDerivativeApiException {
        return getModelViews(urn, null);
    }

    /**
     * List Model Views
     * Returns a list of Model Views (Viewables) in the source design specified by
     * the &#x60;&#x60;urn&#x60;&#x60; parameter. It also returns an ID that
     * uniquely identifies the Model View. You can use these IDs with other metadata
     * operations to obtain information about the objects within those Model Views.
     * 
     * Designs created with applications like Fusion 360 and Inventor contain only
     * one Model View per design. Applications like Revit allow multiple Model Views
     * per design.
     * 
     * **Note:** You can retrieve metadata only from a design that has already been
     * translated to SVF or SVF2.
     * 
     * @param urn                         The URL-safe Base64 encoded URN of the
     *                                    source design. (required)
     * @param getModelViewsOptionalParams class containing all optional parameters
     *                                    for the getModelViews method.
     * @return ModelViews
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public ModelViews getModelViews(String urn, GetModelViewsOptionalParams getModelViewsOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (getModelViewsOptionalParams == null) {
                getModelViewsOptionalParams = new GetModelViewsOptionalParams.Builder().build();
            }
            if (getModelViewsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getModelViewsOptionalParams.getAccessToken() == null) {
                getModelViewsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return metadataApi
                    .getModelViews(urn, getModelViewsOptionalParams.getAcceptEncoding(),
                            getModelViewsOptionalParams.getRegion(), getModelViewsOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Fetch Object tree
     * Retrieves the structured hierarchy of objects, known as an object tree, from
     * the specified Model View (Viewable) within the specified source design. The
     * object tree represents the arrangement and relationships of various objects
     * present in that Model View.
     * 
     * **Note:** A design file must be translated to SVF or SVF2 before you can
     * retrieve its object tree.
     * 
     * Before you call this operation:
     * 
     * - Use the &#x60;List Model Views
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
     * operation to obtain the list of Model Views in the source design.
     * - Pick the ID of the Model View you want to query and specify that ID as the
     * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * @param urn       The URL-safe Base64 encoded URN of the source design.
     *                  (required)
     * @param modelGuid The ID of the Model View you are extracting the object tree
     *                  from. Use the &#x60;List Model Views
     *                  &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
     *                  operation to get the IDs of the Model Views in the source
     *                  design. (required)
     * @return ObjectTree
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public ObjectTree getObjectTree(String urn, String modelGuid) throws ModelDerivativeApiException {
        return getObjectTree(urn, modelGuid, null);
    }

    /**
     * Fetch Object tree
     * Retrieves the structured hierarchy of objects, known as an object tree, from
     * the specified Model View (Viewable) within the specified source design. The
     * object tree represents the arrangement and relationships of various objects
     * present in that Model View.
     * 
     * **Note:** A design file must be translated to SVF or SVF2 before you can
     * retrieve its object tree.
     * 
     * Before you call this operation:
     * 
     * - Use the &#x60;List Model Views
     * &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET/&gt;&#x60;_
     * operation to obtain the list of Model Views in the source design.
     * - Pick the ID of the Model View you want to query and specify that ID as the
     * value for the &#x60;&#x60;modelGuid&#x60;&#x60; parameter.
     * 
     * @param urn                         The URL-safe Base64 encoded URN of the
     *                                    source design. (required)
     * @param modelGuid                   The ID of the Model View you are
     *                                    extracting the object tree from. Use the
     *                                    &#x60;List Model Views
     *                                    &lt;/en/docs/model-derivative/v2/reference/http/metadata/urn-metadata-GET&gt;&#x60;_
     *                                    operation to get the IDs of the Model
     *                                    Views in the source design. (required)
     * @param getObjectTreeOptionalParams class containing all optional parameters
     *                                    for the getObjectTree method.
     * @return ObjectTree
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public ObjectTree getObjectTree(String urn, String modelGuid,
            GetObjectTreeOptionalParams getObjectTreeOptionalParams) throws ModelDerivativeApiException {
        try {
            if (getObjectTreeOptionalParams == null) {
                getObjectTreeOptionalParams = new GetObjectTreeOptionalParams.Builder().build();
            }
            if (getObjectTreeOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getObjectTreeOptionalParams.getAccessToken() == null) {
                getObjectTreeOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return metadataApi
                    .getObjectTree(urn, modelGuid, getObjectTreeOptionalParams.getAcceptEncoding(),
                            getObjectTreeOptionalParams.getRegion(), getObjectTreeOptionalParams.getXAdsForce(),
                            getObjectTreeOptionalParams.getXAdsDerivativeFormat(),
                            getObjectTreeOptionalParams.getForceget(), getObjectTreeOptionalParams.getObjectid(),
                            getObjectTreeOptionalParams.getLevel(), getObjectTreeOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Fetch Thumbnail
     * Downloads a thumbnail of the specified source design.
     * 
     * @param urn The URL-safe Base64 encoded URN of the source design. (required)
     * @return InputStream
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public InputStream getThumbnail(String urn) throws ModelDerivativeApiException {
        return getThumbnail(urn, null);
    }

    /**
     * Fetch Thumbnail
     * Downloads a thumbnail of the specified source design.
     * 
     * @param urn                        The URL-safe Base64 encoded URN of the
     *                                   source design. (required)
     * @param getThumbnailOptionalParams class containing all optional parameters
     *                                   for the getThumbnail method.
     * @return InputStream
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public InputStream getThumbnail(String urn, GetThumbnailOptionalParams getThumbnailOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (getThumbnailOptionalParams == null) {
                getThumbnailOptionalParams = new GetThumbnailOptionalParams.Builder().build();
            }
            if (getThumbnailOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (getThumbnailOptionalParams.getAccessToken() == null) {
                getThumbnailOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return thumbnailsApi
                    .getThumbnail(urn, getThumbnailOptionalParams.getRegion(), getThumbnailOptionalParams.getWidth(),
                            getThumbnailOptionalParams.getHeight(), getThumbnailOptionalParams.getAccessToken())
                    .getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Check Derivative Details
     * Returns information about the specified derivative.
     * 
     * Use this operation to determine the total content length of a derivative
     * before you download it. If the derivative is large, you can choose to
     * download the derivative in chunks, by specifying a chunk size using the
     * &#x60;&#x60;Range&#x60;&#x60; header parameter.
     * 
     * @param urn           The URL-safe Base64 encoded URN of the source design.
     *                      (required)
     * @param derivativeUrn The URL-encoded URN of the derivative. Check the
     *                      manifest of the source design to get the URNs of the
     *                      derivatives available for download. (required)
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public void headCheckDerivative(String urn, String derivativeUrn) throws ModelDerivativeApiException {
        headCheckDerivative(urn, derivativeUrn, null);
    }

    /**
     * Check Derivative Details
     * Returns information about the specified derivative.
     * 
     * Use this operation to determine the total content length of a derivative
     * before you download it. If the derivative is large, you can choose to
     * download the derivative in chunks, by specifying a chunk size using the
     * &#x60;&#x60;Range&#x60;&#x60; header parameter.
     * 
     * @param urn                               The URL-safe Base64 encoded URN of
     *                                          the source design. (required)
     * @param derivativeUrn                     The URL-encoded URN of the
     *                                          derivative. Check the manifest of
     *                                          the source design to get the URNs of
     *                                          the derivatives available for
     *                                          download. (required)
     * @param headCheckDerivativeOptionalParams class containing all optional
     *                                          parameters for the
     *                                          headCheckDerivative method.
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public void headCheckDerivative(String urn, String derivativeUrn,
            HeadCheckDerivativeOptionalParams headCheckDerivativeOptionalParams) throws ModelDerivativeApiException {
        try {
            if (headCheckDerivativeOptionalParams == null) {
                headCheckDerivativeOptionalParams = new HeadCheckDerivativeOptionalParams.Builder().build();
            }
            if (headCheckDerivativeOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (headCheckDerivativeOptionalParams.getAccessToken() == null) {
                headCheckDerivativeOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            derivativesApi.headCheckDerivative(urn, derivativeUrn, headCheckDerivativeOptionalParams.getRegion(),
                    headCheckDerivativeOptionalParams.getAccessToken()).getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Specify References
     * Specifies the location of the files referenced by the specified source
     * design.
     * 
     * When you call &#x60;Create Translation Job
     * &lt;/en/docs/model-derivative/v2/reference/http/job-POST&gt;&#x60;_, set
     * &#x60;&#x60;checkReferences&#x60;&#x60; to &#x60;&#x60;true&#x60;&#x60;. The
     * Model Derivative service will then use the details you specify in this
     * operation to locate and download the referenced files.
     * 
     * @param urn                      The Base64 (URL Safe) encoded design URN.
     *                                 (required)
     * @param specifyReferencesPayload (required)
     * @return SpecifyReferences
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public SpecifyReferences specifyReferences(String urn, SpecifyReferencesPayload specifyReferencesPayload)
            throws ModelDerivativeApiException {
        return specifyReferences(urn, specifyReferencesPayload, null);
    }

    /**
     * Specify References
     * Specifies the location of the files referenced by the specified source
     * design.
     * 
     * When you call &#x60;Create Translation Job
     * &lt;/en/docs/model-derivative/v2/reference/http/job-POST&gt;&#x60;_, set
     * &#x60;&#x60;checkReferences&#x60;&#x60; to &#x60;&#x60;true&#x60;&#x60;. The
     * Model Derivative service will then use the details you specify in this
     * operation to locate and download the referenced files.
     * 
     * @param urn                             The Base64 (URL Safe) encoded design
     *                                        URN. (required)
     * @param specifyReferencesPayload        (required)
     * @param specifyReferencesOptionalParams class containing all optional
     *                                        parameters for the specifyReferences
     *                                        method.
     * @return SpecifyReferences
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public SpecifyReferences specifyReferences(String urn, SpecifyReferencesPayload specifyReferencesPayload,
            SpecifyReferencesOptionalParams specifyReferencesOptionalParams) throws ModelDerivativeApiException {
        try {
            if (specifyReferencesOptionalParams == null) {
                specifyReferencesOptionalParams = new SpecifyReferencesOptionalParams.Builder().build();
            }
            if (specifyReferencesOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (specifyReferencesOptionalParams.getAccessToken() == null) {
                specifyReferencesOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return jobsApi.specifyReferences(urn, specifyReferencesPayload, specifyReferencesOptionalParams.getRegion(),
                    specifyReferencesOptionalParams.getAccessToken()).getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

    /**
     * Create Translation Job
     * Creates a job to translate the specified source design to another format,
     * generating derivatives of the source design. You can optionally:
     * 
     * - Extract selected parts of a design and export the set of geometries in OBJ
     * format.
     * - Generate different-sized thumbnails.
     * 
     * When the translation job runs, details about the process and generated
     * derivatives are logged to a JSON file known as a manifest. This manifest is
     * typically created during the first translation of a source design.
     * Subsequently, the system updates the same manifest whenever a translation is
     * performed for that design.
     * 
     * If necessary, you can set the &#x60;&#x60;x-ads-force&#x60;&#x60; parameter
     * to &#x60;&#x60;true&#x60;&#x60;. Then, the system will delete the existing
     * manifest and create a new one. However, be aware that doing so will also
     * delete all previously generated derivatives.
     * 
     * @param jobPayload (required)
     * @return Job
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public Job startJob(JobPayload jobPayload) throws ModelDerivativeApiException {
        return startJob(jobPayload, null);
    }

    /**
     * Create Translation Job
     * Creates a job to translate the specified source design to another format,
     * generating derivatives of the source design. You can optionally:
     * 
     * - Extract selected parts of a design and export the set of geometries in OBJ
     * format.
     * - Generate different-sized thumbnails.
     * 
     * When the translation job runs, details about the process and generated
     * derivatives are logged to a JSON file known as a manifest. This manifest is
     * typically created during the first translation of a source design.
     * Subsequently, the system updates the same manifest whenever a translation is
     * performed for that design.
     * 
     * If necessary, you can set the &#x60;&#x60;x-ads-force&#x60;&#x60; parameter
     * to &#x60;&#x60;true&#x60;&#x60;. Then, the system will delete the existing
     * manifest and create a new one. However, be aware that doing so will also
     * delete all previously generated derivatives.
     * 
     * @param jobPayload             (required)
     * @param startJobOptionalParams class containing all optional parameters for
     *                               the startJob method.
     * @return Job
     * @throws ModelDerivativeApiException when an API call fails.
     */

    public Job startJob(JobPayload jobPayload, StartJobOptionalParams startJobOptionalParams)
            throws ModelDerivativeApiException {
        try {
            if (startJobOptionalParams == null) {
                startJobOptionalParams = new StartJobOptionalParams.Builder().build();
            }
            if (startJobOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new ModelDerivativeApiException("Please provide a valid access token!");
            } else if (startJobOptionalParams.getAccessToken() == null) {
                startJobOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return jobsApi.startJob(jobPayload, startJobOptionalParams.getXAdsForce(),
                    startJobOptionalParams.getXAdsDerivativeFormat(), startJobOptionalParams.getRegion(),
                    startJobOptionalParams.getAccessToken()).getData();
        } catch (ModelDerivativeApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelDerivativeApiException(e);
        }
    }

}