/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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
package com.autodesk.aps.datamanagement;

import com.autodesk.aps.datamanagement.api.CommandsApi;
import com.autodesk.aps.datamanagement.api.FoldersApi;
import com.autodesk.aps.datamanagement.api.HubsApi;
import com.autodesk.aps.datamanagement.api.ItemsApi;
import com.autodesk.aps.datamanagement.api.ProjectsApi;
import com.autodesk.aps.datamanagement.api.VersionsApi;
import com.autodesk.aps.datamanagement.model.Command;
import com.autodesk.aps.datamanagement.model.CommandPayload;
import com.autodesk.aps.datamanagement.model.CreateDownloadOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateFolderOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateFolderRelationshipsRefOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateItemOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateItemRelationshipsRefOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateStorageOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateVersionOptionalParams;
import com.autodesk.aps.datamanagement.model.CreateVersionRelationshipsRefOptionalParams;
import com.autodesk.aps.datamanagement.model.CreatedDownload;
import com.autodesk.aps.datamanagement.model.CreatedItem;
import com.autodesk.aps.datamanagement.model.CreatedVersion;
import com.autodesk.aps.datamanagement.model.Download;
import com.autodesk.aps.datamanagement.model.DownloadFormats;
import com.autodesk.aps.datamanagement.model.DownloadPayload;
import com.autodesk.aps.datamanagement.model.Downloads;
import com.autodesk.aps.datamanagement.model.ExecuteCommandOptionalParams;
import com.autodesk.aps.datamanagement.model.Folder;
import com.autodesk.aps.datamanagement.model.FolderContents;
import com.autodesk.aps.datamanagement.model.FolderPayload;
import com.autodesk.aps.datamanagement.model.FolderRefs;
import com.autodesk.aps.datamanagement.model.GetDownloadJobOptionalParams;
import com.autodesk.aps.datamanagement.model.GetDownloadOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderContentsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderParentOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderRefsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderRelationshipsLinksOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderRelationshipsRefsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetFolderSearchOptionalParams;
import com.autodesk.aps.datamanagement.model.GetHubOptionalParams;
import com.autodesk.aps.datamanagement.model.GetHubProjectsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetHubsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemParentFolderOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemRefsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemRelationshipsLinksOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemRelationshipsRefsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemTipOptionalParams;
import com.autodesk.aps.datamanagement.model.GetItemVersionsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetProjectHubOptionalParams;
import com.autodesk.aps.datamanagement.model.GetProjectOptionalParams;
import com.autodesk.aps.datamanagement.model.GetProjectTopFoldersOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionDownloadFormatsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionDownloadsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionItemOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionRefsOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionRelationshipsLinksOptionalParams;
import com.autodesk.aps.datamanagement.model.GetVersionRelationshipsRefsOptionalParams;
import com.autodesk.aps.datamanagement.model.Hub;
import com.autodesk.aps.datamanagement.model.Hubs;
import com.autodesk.aps.datamanagement.model.Item;
import com.autodesk.aps.datamanagement.model.ItemPayload;
import com.autodesk.aps.datamanagement.model.ItemTip;
import com.autodesk.aps.datamanagement.model.Job;
import com.autodesk.aps.datamanagement.model.ModifyFolderPayload;
import com.autodesk.aps.datamanagement.model.ModifyItemPayload;
import com.autodesk.aps.datamanagement.model.ModifyVersionPayload;
import com.autodesk.aps.datamanagement.model.PatchFolderOptionalParams;
import com.autodesk.aps.datamanagement.model.PatchItemOptionalParams;
import com.autodesk.aps.datamanagement.model.PatchVersionOptionalParams;
import com.autodesk.aps.datamanagement.model.Project;
import com.autodesk.aps.datamanagement.model.Projects;
import com.autodesk.aps.datamanagement.model.Refs;
import com.autodesk.aps.datamanagement.model.RelationshipLinks;
import com.autodesk.aps.datamanagement.model.RelationshipRefs;
import com.autodesk.aps.datamanagement.model.RelationshipRefsPayload;
import com.autodesk.aps.datamanagement.model.Search;
import com.autodesk.aps.datamanagement.model.Storage;
import com.autodesk.aps.datamanagement.model.StoragePayload;
import com.autodesk.aps.datamanagement.model.TopFolders;
import com.autodesk.aps.datamanagement.model.Version;
import com.autodesk.aps.datamanagement.model.VersionPayload;
import com.autodesk.aps.datamanagement.model.Versions;
import com.autodesk.aps.sdkmanager.BaseClient;
import com.autodesk.aps.sdkmanager.IAuthenticationProvider;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;

public class DataManagementClient extends BaseClient {
    private final CommandsApi commandsApi;
    private final FoldersApi foldersApi;
    private final ProjectsApi projectsApi;
    private final HubsApi hubsApi;
    private final ItemsApi itemsApi;
    private final VersionsApi versionsApi;

    /**
     * Initializes a new instance of the DataManagementClient class.
     * 
     * @param sdkManager             The SDK manager instance.
     * @param authenticationProvider The authentication provider.
     */
    public DataManagementClient(SdkManager sdkManager, IAuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
        if (sdkManager == null) {
            sdkManager = SdkManagerBuilder.create().build();
        }
        this.commandsApi = new CommandsApi(sdkManager);
        this.foldersApi = new FoldersApi(sdkManager);
        this.projectsApi = new ProjectsApi(sdkManager);
        this.hubsApi = new HubsApi(sdkManager);
        this.itemsApi = new ItemsApi(sdkManager);
        this.versionsApi = new VersionsApi(sdkManager);

    }

    /**
     * Initializes a new instance of the DataManagementClient class with a default
     * SDK manager.
     * 
     * @param authenticationProvider The authentication provider.
     */
    public DataManagementClient(IAuthenticationProvider authenticationProvider) {
        this(SdkManagerBuilder.create().build(), authenticationProvider);
    }

    /**
     * Initializes a new instance of the DataManagementClient class without an
     * authentication provider.
     * 
     * @param sdkManager
     */

    public DataManagementClient(SdkManager sdkManager) {
        this(sdkManager, null);
    }

    /**
     * Initializes a new instance of the DataManagementClient class with a default
     * SDK manager and without an authentication provider.
     */
    public DataManagementClient() {
        this(SdkManagerBuilder.create().build(), null);
    }

    /**
     * Closes the underlying connection.
     */
    public void close() {
        this.hubsApi.close();
    }

    /**
     * Create Download
     * Kicks off a job to generate the specified download format of the version.
     * Once the job completes, the specified format becomes available for download.
     * 
     * @param projectId       The unique identifier of a project. For BIM 360 Docs
     *                        and ACC Docs, a hub ID corresponds to an Account ID.
     *                        To convert a BIM 360 or ACC Account ID to a hub ID,
     *                        prefix the Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                        For example, an Account ID of
     *                        &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                        translates to a hub ID of
     *                        &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                        convert an ACC or BIM 360 project ID to a Data
     *                        Management project ID prefix the ACC or BIM 360
     *                        project ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                        example, a project ID of
     *                        &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                        project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                        (required)
     * @param downloadPayload (required)
     * @return CreatedDownload
     * @throws DataManagementApiException when an API call fails.
     */

    public CreatedDownload createDownload(String projectId, DownloadPayload downloadPayload)
            throws DataManagementApiException {
        return createDownload(projectId, downloadPayload, null);
    }

    /**
     * Create Download
     * Kicks off a job to generate the specified download format of the version.
     * Once the job completes, the specified format becomes available for download.
     * 
     * @param projectId                   The unique identifier of a project. For
     *                                    BIM 360 Docs and ACC Docs, a hub ID
     *                                    corresponds to an Account ID. To convert a
     *                                    BIM 360 or ACC Account ID to a hub ID,
     *                                    prefix the Account ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                    an Account ID of
     *                                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                    translates to a hub ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    Similarly, to convert an ACC or BIM 360
     *                                    project ID to a Data Management project ID
     *                                    prefix the ACC or BIM 360 project ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                    project ID of
     *                                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                    translates to a project ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    (required)
     * @param downloadPayload             (required)
     * @param createDownloadOptionalParams class containing all optional parameters
     *                                    for the createDownload method.
     * @return CreatedDownload
     * @throws DataManagementApiException when an API call fails.
     */

    public CreatedDownload createDownload(String projectId, DownloadPayload downloadPayload,
            CreateDownloadOptionalParams createDownloadOptionalParams) throws DataManagementApiException {
        try {
            if (createDownloadOptionalParams == null) {
                createDownloadOptionalParams = new CreateDownloadOptionalParams.Builder().build();
            }
            if (createDownloadOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createDownloadOptionalParams.getAccessToken() == null) {
                createDownloadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.createDownload(projectId, downloadPayload, createDownloadOptionalParams.getXUserId(),
                    createDownloadOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create a Folder
     * Creates a new folder in the specified project. Use the
     * &#x60;&#x60;parent&#x60;&#x60; attribute in the request body to specify where
     * in the hierarchy the new folder should be located. Folders can be nested up
     * to 25 levels deep.
     * 
     * Use the &#x60;Modify a Folder
     * &lt;/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-PATCH/&gt;&#x60;_
     * operation to delete and restore folders.
     * 
     * Before you use the Data Management API to access BIM 360 Docs folders,
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId     The unique identifier of a project. For BIM 360 Docs and
     *                      ACC Docs, a hub ID corresponds to an Account ID. To
     *                      convert a BIM 360 or ACC Account ID to a hub ID, prefix
     *                      the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                      example, an Account ID of
     *                      &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                      translates to a hub ID of
     *                      &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                      convert an ACC or BIM 360 project ID to a Data
     *                      Management project ID prefix the ACC or BIM 360 project
     *                      ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                      project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                      translates to a project ID of
     *                      &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
     * @param folderPayload (required)
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder createFolder(String projectId, FolderPayload folderPayload) throws DataManagementApiException {
        return createFolder(projectId, folderPayload, null);
    }

    /**
     * Create a Folder
     * Creates a new folder in the specified project. Use the
     * &#x60;&#x60;parent&#x60;&#x60; attribute in the request body to specify where
     * in the hierarchy the new folder should be located. Folders can be nested up
     * to 25 levels deep.
     * 
     * Use the &#x60;Modify a Folder
     * &lt;/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-PATCH/&gt;&#x60;_
     * operation to delete and restore folders.
     * 
     * Before you use the Data Management API to access BIM 360 Docs folders,
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                 The unique identifier of a project. For BIM
     *                                  360 Docs and ACC Docs, a hub ID corresponds
     *                                  to an Account ID. To convert a BIM 360 or
     *                                  ACC Account ID to a hub ID, prefix the
     *                                  Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                                  For example, an Account ID of
     *                                  &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                  translates to a hub ID of
     *                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                  Similarly, to convert an ACC or BIM 360
     *                                  project ID to a Data Management project ID
     *                                  prefix the ACC or BIM 360 project ID with
     *                                  &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                  project ID of
     *                                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                  translates to a project ID of
     *                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                  (required)
     * @param folderPayload             (required)
     * @param createFolderOptionalParams class containing all optional parameters for
     *                                  the createFolder method.
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder createFolder(String projectId, FolderPayload folderPayload,
            CreateFolderOptionalParams createFolderOptionalParams) throws DataManagementApiException {
        try {
            if (createFolderOptionalParams == null) {
                createFolderOptionalParams = new CreateFolderOptionalParams.Builder().build();
            }
            if (createFolderOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createFolderOptionalParams.getAccessToken() == null) {
                createFolderOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.createFolder(projectId, folderPayload, createFolderOptionalParams.getXUserId(),
                    createFolderOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create a Custom Relationship for a Folder
     * Creates a custom relationship between a folder and another resource within
     * the data domain service (folder, item, or version).
     * 
     * @param folderId                The unique identifier of a folder. (required)
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param relationshipRefsPayload (required)
     * @throws DataManagementApiException when an API call fails.
     */

    public void createFolderRelationshipsRef(String folderId, String projectId,
            RelationshipRefsPayload relationshipRefsPayload) throws DataManagementApiException {
        createFolderRelationshipsRef(folderId, projectId, relationshipRefsPayload, null);
    }

    /**
     * Create a Custom Relationship for a Folder
     * Creates a custom relationship between a folder and another resource within
     * the data domain service (folder, item, or version).
     * 
     * @param folderId                                  The unique identifier of a
     *                                                  folder. (required)
     * @param projectId                                 The unique identifier of a
     *                                                  project. For BIM 360 Docs
     *                                                  and ACC Docs, a hub ID
     *                                                  corresponds to an Account
     *                                                  ID. To convert a BIM 360 or
     *                                                  ACC Account ID to a hub ID,
     *                                                  prefix the Account ID with
     *                                                  &#x60;&#x60;b.&#x60;&#x60;.
     *                                                  For example, an Account ID
     *                                                  of
     *                                                  &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                  translates to a hub ID of
     *                                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                  Similarly, to convert an ACC
     *                                                  or BIM 360 project ID to a
     *                                                  Data Management project ID
     *                                                  prefix the ACC or BIM 360
     *                                                  project ID with
     *                                                  &#x60;&#x60;b.&#x60;&#x60;.
     *                                                  For example, a project ID of
     *                                                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                  translates to a project ID
     *                                                  of
     *                                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                  (required)
     * @param relationshipRefsPayload                   (required)
     * @param createFolderRelationshipsRefOptionalParams class containing all
     *                                                  optional parameters for the
     *                                                  createFolderRelationshipsRef
     *                                                  method.
     * @throws DataManagementApiException when an API call fails.
     */

    public void createFolderRelationshipsRef(String folderId, String projectId,
            RelationshipRefsPayload relationshipRefsPayload,
            CreateFolderRelationshipsRefOptionalParams createFolderRelationshipsRefOptionalParams)
            throws DataManagementApiException {
        try {
            if (createFolderRelationshipsRefOptionalParams == null) {
                createFolderRelationshipsRefOptionalParams = new CreateFolderRelationshipsRefOptionalParams.Builder()
                        .build();
            }
            if (createFolderRelationshipsRefOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createFolderRelationshipsRefOptionalParams.getAccessToken() == null) {
                createFolderRelationshipsRefOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            foldersApi.createFolderRelationshipsRef(folderId, projectId, relationshipRefsPayload,
                    createFolderRelationshipsRefOptionalParams.getXUserId(),
                    createFolderRelationshipsRefOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create an Item
     * Creates the first version of a file (item). To create additional versions of
     * an item, use POST versions.
     * 
     * Before you create the first version of an item, you must create a placeholder
     * for the file, and upload the file to the placeholder. For more details about
     * the workflow, see the tutorial on uploading a file.
     * 
     * This operation also allows you to create a new item by copying a specific
     * version of an existing item to another folder. The copied version becomes the
     * first version of the new item in the target folder.
     * 
     * **Note:** You cannot copy versions of items across different projects and
     * accounts.
     * 
     * Use the [Create
     * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-POST/)
     * operation with the &#x60;&#x60;copyFrom&#x60;&#x60; parameter if you want to
     * create a new version of an item by copying a specific version of another
     * item.
     * 
     * Before you use the Data Management API to access BIM 360 Docs files, you must
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId   The unique identifier of a project. For BIM 360 Docs and
     *                    ACC Docs, a hub ID corresponds to an Account ID. To
     *                    convert a BIM 360 or ACC Account ID to a hub ID, prefix
     *                    the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                    example, an Account ID of
     *                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                    translates to a hub ID of
     *                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                    convert an ACC or BIM 360 project ID to a Data Management
     *                    project ID prefix the ACC or BIM 360 project ID with
     *                    &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                    project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                    (required)
     * @param itemPayload (required)
     * @return CreatedItem
     * @throws DataManagementApiException when an API call fails.
     */

    public CreatedItem createItem(String projectId, ItemPayload itemPayload) throws DataManagementApiException {
        return createItem(projectId, itemPayload, null);
    }

    /**
     * Create an Item
     * Creates the first version of a file (item). To create additional versions of
     * an item, use POST versions.
     * 
     * Before you create the first version of an item, you must create a placeholder
     * for the file, and upload the file to the placeholder. For more details about
     * the workflow, see the tutorial on uploading a file.
     * 
     * This operation also allows you to create a new item by copying a specific
     * version of an existing item to another folder. The copied version becomes the
     * first version of the new item in the target folder.
     * 
     * **Note:** You cannot copy versions of items across different projects and
     * accounts.
     * 
     * Use the [Create
     * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-POST/)
     * operation with the &#x60;&#x60;copyFrom&#x60;&#x60; parameter if you want to
     * create a new version of an item by copying a specific version of another
     * item.
     * 
     * Before you use the Data Management API to access BIM 360 Docs files, you must
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param itemPayload             (required)
     * @param createItemOptionalParams class containing all optional parameters for
     *                                the createItem method.
     * @return CreatedItem
     * @throws DataManagementApiException when an API call fails.
     */

    public CreatedItem createItem(String projectId, ItemPayload itemPayload,
            CreateItemOptionalParams createItemOptionalParams) throws DataManagementApiException {
        try {
            if (createItemOptionalParams == null) {
                createItemOptionalParams = new CreateItemOptionalParams.Builder().build();
            }
            if (createItemOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createItemOptionalParams.getAccessToken() == null) {
                createItemOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi.createItem(projectId, itemPayload, createItemOptionalParams.getCopyFrom(),
                    createItemOptionalParams.getXUserId(), createItemOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create a Custom Relationship for an Item
     * Creates a custom relationship between an item and another resource within the
     * data domain service (folder, item, or version).
     * 
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param itemId                  The unique identifier of an item. (required)
     * @param relationshipRefsPayload (required)
     * @throws DataManagementApiException when an API call fails.
     */

    public void createItemRelationshipsRef(String projectId, String itemId,
            RelationshipRefsPayload relationshipRefsPayload) throws DataManagementApiException {
        createItemRelationshipsRef(projectId, itemId, relationshipRefsPayload, null);
    }

    /**
     * Create a Custom Relationship for an Item
     * Creates a custom relationship between an item and another resource within the
     * data domain service (folder, item, or version).
     * 
     * @param projectId                               The unique identifier of a
     *                                                project. For BIM 360 Docs and
     *                                                ACC Docs, a hub ID corresponds
     *                                                to an Account ID. To convert a
     *                                                BIM 360 or ACC Account ID to a
     *                                                hub ID, prefix the Account ID
     *                                                with
     *                                                &#x60;&#x60;b.&#x60;&#x60;.
     *                                                For example, an Account ID of
     *                                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                translates to a hub ID of
     *                                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                Similarly, to convert an ACC
     *                                                or BIM 360 project ID to a
     *                                                Data Management project ID
     *                                                prefix the ACC or BIM 360
     *                                                project ID with
     *                                                &#x60;&#x60;b.&#x60;&#x60;.
     *                                                For example, a project ID of
     *                                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                translates to a project ID of
     *                                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                (required)
     * @param itemId                                  The unique identifier of an
     *                                                item. (required)
     * @param relationshipRefsPayload                 (required)
     * @param createItemRelationshipsRefOptionalParams class containing all optional
     *                                                parameters for the
     *                                                createItemRelationshipsRef
     *                                                method.
     * @throws DataManagementApiException when an API call fails.
     */

    public void createItemRelationshipsRef(String projectId, String itemId,
            RelationshipRefsPayload relationshipRefsPayload,
            CreateItemRelationshipsRefOptionalParams createItemRelationshipsRefOptionalParams)
            throws DataManagementApiException {
        try {
            if (createItemRelationshipsRefOptionalParams == null) {
                createItemRelationshipsRefOptionalParams = new CreateItemRelationshipsRefOptionalParams.Builder()
                        .build();
            }
            if (createItemRelationshipsRefOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createItemRelationshipsRefOptionalParams.getAccessToken() == null) {
                createItemRelationshipsRefOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            itemsApi.createItemRelationshipsRef(projectId, itemId, relationshipRefsPayload,
                    createItemRelationshipsRefOptionalParams.getXUserId(),
                    createItemRelationshipsRefOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create a Storage Location in OSS
     * Creates a placeholder for an item or a version of an item in the OSS. Later,
     * you can upload the binary content for the item or version to this storage
     * location.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId      The unique identifier of a project. For BIM 360 Docs
     *                       and ACC Docs, a hub ID corresponds to an Account ID. To
     *                       convert a BIM 360 or ACC Account ID to a hub ID, prefix
     *                       the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                       example, an Account ID of
     *                       &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                       translates to a hub ID of
     *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                       convert an ACC or BIM 360 project ID to a Data
     *                       Management project ID prefix the ACC or BIM 360 project
     *                       ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                       project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                       translates to a project ID of
     *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
     * @param storagePayload (required)
     * @return Storage
     * @throws DataManagementApiException when an API call fails.
     */

    public Storage createStorage(String projectId, StoragePayload storagePayload) throws DataManagementApiException {
        return createStorage(projectId, storagePayload, null);
    }

    /**
     * Create a Storage Location in OSS
     * Creates a placeholder for an item or a version of an item in the OSS. Later,
     * you can upload the binary content for the item or version to this storage
     * location.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                  The unique identifier of a project. For BIM
     *                                   360 Docs and ACC Docs, a hub ID corresponds
     *                                   to an Account ID. To convert a BIM 360 or
     *                                   ACC Account ID to a hub ID, prefix the
     *                                   Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                                   For example, an Account ID of
     *                                   &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                   translates to a hub ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   Similarly, to convert an ACC or BIM 360
     *                                   project ID to a Data Management project ID
     *                                   prefix the ACC or BIM 360 project ID with
     *                                   &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                   project ID of
     *                                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                   translates to a project ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   (required)
     * @param storagePayload             (required)
     * @param createStorageOptionalParams class containing all optional parameters
     *                                   for the createStorage method.
     * @return Storage
     * @throws DataManagementApiException when an API call fails.
     */

    public Storage createStorage(String projectId, StoragePayload storagePayload,
            CreateStorageOptionalParams createStorageOptionalParams) throws DataManagementApiException {
        try {
            if (createStorageOptionalParams == null) {
                createStorageOptionalParams = new CreateStorageOptionalParams.Builder().build();
            }
            if (createStorageOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createStorageOptionalParams.getAccessToken() == null) {
                createStorageOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.createStorage(projectId, storagePayload, createStorageOptionalParams.getXUserId(),
                    createStorageOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create a Version
     * Creates a new versions of an existing item.
     * 
     * Before creating a new version you must create a storage location for the
     * version in OSS, and upload the file to that location. For more details about
     * the workflow, see the tutorial on uploading a file.
     * 
     * This operation also allows you to create a new version of an item by copying
     * a specific version of an existing item from another folder within the
     * project. The new version becomes the tip version of the item.
     * 
     * Use the [Create an
     * Item](/en/docs/data/v2/reference/http/projects-project_id-items-POST/)
     * operation to copy a specific version of an existing item as a new item in
     * another folder.
     * 
     * This operation can also be used to delete files on BIM360 Document
     * Management. For more information, please refer to the delete and restore a
     * file tutorial.
     * 
     * Before you use the Data Management API to access BIM 360 Docs files, you must
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId      The unique identifier of a project. For BIM 360 Docs
     *                       and ACC Docs, a hub ID corresponds to an Account ID. To
     *                       convert a BIM 360 or ACC Account ID to a hub ID, prefix
     *                       the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                       example, an Account ID of
     *                       &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                       translates to a hub ID of
     *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                       convert an ACC or BIM 360 project ID to a Data
     *                       Management project ID prefix the ACC or BIM 360 project
     *                       ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                       project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                       translates to a project ID of
     *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
     * @param versionPayload (required)
     * @return CreatedVersion
     * @throws DataManagementApiException when an API call fails.
     */

    public CreatedVersion createVersion(String projectId, VersionPayload versionPayload)
            throws DataManagementApiException {
        return createVersion(projectId, versionPayload, null);
    }

    /**
     * Create a Version
     * Creates a new versions of an existing item.
     * 
     * Before creating a new version you must create a storage location for the
     * version in OSS, and upload the file to that location. For more details about
     * the workflow, see the tutorial on uploading a file.
     * 
     * This operation also allows you to create a new version of an item by copying
     * a specific version of an existing item from another folder within the
     * project. The new version becomes the tip version of the item.
     * 
     * Use the [Create an
     * Item](/en/docs/data/v2/reference/http/projects-project_id-items-POST/)
     * operation to copy a specific version of an existing item as a new item in
     * another folder.
     * 
     * This operation can also be used to delete files on BIM360 Document
     * Management. For more information, please refer to the delete and restore a
     * file tutorial.
     * 
     * Before you use the Data Management API to access BIM 360 Docs files, you must
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                  The unique identifier of a project. For BIM
     *                                   360 Docs and ACC Docs, a hub ID corresponds
     *                                   to an Account ID. To convert a BIM 360 or
     *                                   ACC Account ID to a hub ID, prefix the
     *                                   Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                                   For example, an Account ID of
     *                                   &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                   translates to a hub ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   Similarly, to convert an ACC or BIM 360
     *                                   project ID to a Data Management project ID
     *                                   prefix the ACC or BIM 360 project ID with
     *                                   &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                   project ID of
     *                                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                   translates to a project ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   (required)
     * @param versionPayload             (required)
     * @param createVersionOptionalParams class containing all optional parameters
     *                                   for the createVersion method.
     * @return CreatedVersion
     * @throws DataManagementApiException when an API call fails.
     */

    public CreatedVersion createVersion(String projectId, VersionPayload versionPayload,
            CreateVersionOptionalParams createVersionOptionalParams) throws DataManagementApiException {
        try {
            if (createVersionOptionalParams == null) {
                createVersionOptionalParams = new CreateVersionOptionalParams.Builder().build();
            }
            if (createVersionOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createVersionOptionalParams.getAccessToken() == null) {
                createVersionOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi
                    .createVersion(projectId, versionPayload, createVersionOptionalParams.getXUserId(),
                            createVersionOptionalParams.getCopyFrom(), createVersionOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Create a Custom Relationship for a Version
     * Creates a custom relationship between a version of an item and another
     * resource within the data domain service (folder, item, or version).
     * 
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param versionId               The URL encoded unique identifier of a
     *                                version. (required)
     * @param relationshipRefsPayload (required)
     * @throws DataManagementApiException when an API call fails.
     */

    public void createVersionRelationshipsRef(String projectId, String versionId,
            RelationshipRefsPayload relationshipRefsPayload) throws DataManagementApiException {
        createVersionRelationshipsRef(projectId, versionId, relationshipRefsPayload, null);
    }

    /**
     * Create a Custom Relationship for a Version
     * Creates a custom relationship between a version of an item and another
     * resource within the data domain service (folder, item, or version).
     * 
     * @param projectId                                  The unique identifier of a
     *                                                   project. For BIM 360 Docs
     *                                                   and ACC Docs, a hub ID
     *                                                   corresponds to an Account
     *                                                   ID. To convert a BIM 360 or
     *                                                   ACC Account ID to a hub ID,
     *                                                   prefix the Account ID with
     *                                                   &#x60;&#x60;b.&#x60;&#x60;.
     *                                                   For example, an Account ID
     *                                                   of
     *                                                   &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                   translates to a hub ID of
     *                                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                   Similarly, to convert an
     *                                                   ACC or BIM 360 project ID
     *                                                   to a Data Management
     *                                                   project ID prefix the ACC
     *                                                   or BIM 360 project ID with
     *                                                   &#x60;&#x60;b.&#x60;&#x60;.
     *                                                   For example, a project ID
     *                                                   of
     *                                                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                   translates to a project ID
     *                                                   of
     *                                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                   (required)
     * @param versionId                                  The URL encoded unique
     *                                                   identifier of a version.
     *                                                   (required)
     * @param relationshipRefsPayload                    (required)
     * @param createVersionRelationshipsRefOptionalParams class containing all
     *                                                   optional parameters for the
     *                                                   createVersionRelationshipsRef
     *                                                   method.
     * @throws DataManagementApiException when an API call fails.
     */

    public void createVersionRelationshipsRef(String projectId, String versionId,
            RelationshipRefsPayload relationshipRefsPayload,
            CreateVersionRelationshipsRefOptionalParams createVersionRelationshipsRefOptionalParams)
            throws DataManagementApiException {
        try {
            if (createVersionRelationshipsRefOptionalParams == null) {
                createVersionRelationshipsRefOptionalParams = new CreateVersionRelationshipsRefOptionalParams.Builder()
                        .build();
            }
            if (createVersionRelationshipsRefOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (createVersionRelationshipsRefOptionalParams.getAccessToken() == null) {
                createVersionRelationshipsRefOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            versionsApi.createVersionRelationshipsRef(projectId, versionId, relationshipRefsPayload,
                    createVersionRelationshipsRefOptionalParams.getXUserId(),
                    createVersionRelationshipsRefOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Execute a Command
     * Executes the command that you specify in the request body. Commands enable
     * you to perform general operations on multiple resources.
     * 
     * For example, you can check whether a user has permission to delete a
     * collection of versions, items, and folders.
     * 
     * The command as well as the input data for the command are specified using the
     * &#x60;&#x60;data&#x60;&#x60; object of the request body.
     * 
     * For more information about commands see the
     * [Commands](/en/docs/data/v2/overview/commands/) section in the
     * Developer&#39;s Guide.
     * 
     * @param projectId      The unique identifier of a project. For BIM 360 Docs
     *                       and ACC Docs, a hub ID corresponds to an Account ID. To
     *                       convert a BIM 360 or ACC Account ID to a hub ID, prefix
     *                       the Account ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                       example, an Account ID of
     *                       &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                       translates to a hub ID of
     *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                       convert an ACC or BIM 360 project ID to a Data
     *                       Management project ID prefix the ACC or BIM 360 project
     *                       ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                       project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                       translates to a project ID of
     *                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
     * @param commandPayload The request body&#39;s &#x60;&#x60;data&#x60;&#x60;
     *                       object defines the command to execute and contains any
     *                       required input data. (required)
     * @return Command
     * @throws DataManagementApiException when an API call fails.
     */

    public Command executeCommand(String projectId, CommandPayload commandPayload) throws DataManagementApiException {
        return executeCommand(projectId, commandPayload, null);
    }

    /**
     * Execute a Command
     * Executes the command that you specify in the request body. Commands enable
     * you to perform general operations on multiple resources.
     * 
     * For example, you can check whether a user has permission to delete a
     * collection of versions, items, and folders.
     * 
     * The command as well as the input data for the command are specified using the
     * &#x60;&#x60;data&#x60;&#x60; object of the request body.
     * 
     * For more information about commands see the
     * [Commands](/en/docs/data/v2/overview/commands/) section in the
     * Developer&#39;s Guide.
     * 
     * @param projectId                   The unique identifier of a project. For
     *                                    BIM 360 Docs and ACC Docs, a hub ID
     *                                    corresponds to an Account ID. To convert a
     *                                    BIM 360 or ACC Account ID to a hub ID,
     *                                    prefix the Account ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                    an Account ID of
     *                                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                    translates to a hub ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    Similarly, to convert an ACC or BIM 360
     *                                    project ID to a Data Management project ID
     *                                    prefix the ACC or BIM 360 project ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                    project ID of
     *                                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                    translates to a project ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    (required)
     * @param commandPayload              The request body&#39;s
     *                                    &#x60;&#x60;data&#x60;&#x60; object
     *                                    defines the command to execute and
     *                                    contains any required input data.
     *                                    (required)
     * @param executeCommandOptionalParams class containing all optional parameters
     *                                    for the executeCommand method.
     * @return Command
     * @throws DataManagementApiException when an API call fails.
     */

    public Command executeCommand(String projectId, CommandPayload commandPayload,
            ExecuteCommandOptionalParams executeCommandOptionalParams) throws DataManagementApiException {
        try {
            if (executeCommandOptionalParams == null) {
                executeCommandOptionalParams = new ExecuteCommandOptionalParams.Builder().build();
            }
            if (executeCommandOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (executeCommandOptionalParams.getAccessToken() == null) {
                executeCommandOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return commandsApi.executeCommand(projectId, commandPayload, executeCommandOptionalParams.getXUserId(),
                    executeCommandOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Download Details
     * Returns the details of a downloadable format of a version of an item.
     * 
     * @param projectId  The unique identifier of a project. For BIM 360 Docs and
     *                   ACC Docs, a hub ID corresponds to an Account ID. To convert
     *                   a BIM 360 or ACC Account ID to a hub ID, prefix the Account
     *                   ID with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account
     *                   ID of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                   translates to a hub ID of
     *                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                   convert an ACC or BIM 360 project ID to a Data Management
     *                   project ID prefix the ACC or BIM 360 project ID with
     *                   &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                   project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                   (required)
     * @param downloadId The Job ID of the job used to generate the download.
     *                   (required)
     * @return Download
     * @throws DataManagementApiException when an API call fails.
     */

    public Download getDownload(String projectId, String downloadId) throws DataManagementApiException {
        return getDownload(projectId, downloadId, null);
    }

    /**
     * Get Download Details
     * Returns the details of a downloadable format of a version of an item.
     * 
     * @param projectId                The unique identifier of a project. For BIM
     *                                 360 Docs and ACC Docs, a hub ID corresponds
     *                                 to an Account ID. To convert a BIM 360 or ACC
     *                                 Account ID to a hub ID, prefix the Account ID
     *                                 with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                 an Account ID of
     *                                 &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                 translates to a hub ID of
     *                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                 Similarly, to convert an ACC or BIM 360
     *                                 project ID to a Data Management project ID
     *                                 prefix the ACC or BIM 360 project ID with
     *                                 &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                 project ID of
     *                                 &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                 translates to a project ID of
     *                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                 (required)
     * @param downloadId               The Job ID of the job used to generate the
     *                                 download. (required)
     * @param getDownloadOptionalParams class containing all optional parameters for
     *                                 the getDownload method.
     * @return Download
     * @throws DataManagementApiException when an API call fails.
     */

    public Download getDownload(String projectId, String downloadId,
            GetDownloadOptionalParams getDownloadOptionalParams) throws DataManagementApiException {
        try {
            if (getDownloadOptionalParams == null) {
                getDownloadOptionalParams = new GetDownloadOptionalParams.Builder().build();
            }
            if (getDownloadOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getDownloadOptionalParams.getAccessToken() == null) {
                getDownloadOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.getDownload(projectId, downloadId, getDownloadOptionalParams.getXUserId(),
                    getDownloadOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Check Download Creation Progress
     * Checks the status of a job that generates a downloadable format of a version
     * of an item.
     * 
     * **Note**: If the job has finished, this operation returns a HTTP status 303,
     * with the &#x60;&#x60;location&#x60;&#x60; return header set to the URI that
     * returns the details of the download.
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param jobId     The unique identifier of a job. (required)
     * @return Job
     * @throws DataManagementApiException when an API call fails.
     */

    public Job getDownloadJob(String projectId, String jobId) throws DataManagementApiException {
        return getDownloadJob(projectId, jobId, null);
    }

    /**
     * Check Download Creation Progress
     * Checks the status of a job that generates a downloadable format of a version
     * of an item.
     * 
     * **Note**: If the job has finished, this operation returns a HTTP status 303,
     * with the &#x60;&#x60;location&#x60;&#x60; return header set to the URI that
     * returns the details of the download.
     * 
     * @param projectId                   The unique identifier of a project. For
     *                                    BIM 360 Docs and ACC Docs, a hub ID
     *                                    corresponds to an Account ID. To convert a
     *                                    BIM 360 or ACC Account ID to a hub ID,
     *                                    prefix the Account ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                    an Account ID of
     *                                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                    translates to a hub ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    Similarly, to convert an ACC or BIM 360
     *                                    project ID to a Data Management project ID
     *                                    prefix the ACC or BIM 360 project ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                    project ID of
     *                                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                    translates to a project ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    (required)
     * @param jobId                       The unique identifier of a job. (required)
     * @param getDownloadJobOptionalParams class containing all optional parameters
     *                                    for the getDownloadJob method.
     * @return Job
     * @throws DataManagementApiException when an API call fails.
     */

    public Job getDownloadJob(String projectId, String jobId, GetDownloadJobOptionalParams getDownloadJobOptionalParams)
            throws DataManagementApiException {
        try {
            if (getDownloadJobOptionalParams == null) {
                getDownloadJobOptionalParams = new GetDownloadJobOptionalParams.Builder().build();
            }
            if (getDownloadJobOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getDownloadJobOptionalParams.getAccessToken() == null) {
                getDownloadJobOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.getDownloadJob(projectId, jobId, getDownloadJobOptionalParams.getXUserId(),
                    getDownloadJobOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get a Folder
     * Returns the folder specified by the &#x60;&#x60;folder_id&#x60;&#x60;
     * parameter from within the project identified by the
     * &#x60;&#x60;project_id&#x60;&#x60; parameter. All folders and subfolders
     * within a project (including the root folder) have a unique ID.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param folderId  The unique identifier of a folder. (required)
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder getFolder(String projectId, String folderId) throws DataManagementApiException {
        return getFolder(projectId, folderId, null);
    }

    /**
     * Get a Folder
     * Returns the folder specified by the &#x60;&#x60;folder_id&#x60;&#x60;
     * parameter from within the project identified by the
     * &#x60;&#x60;project_id&#x60;&#x60; parameter. All folders and subfolders
     * within a project (including the root folder) have a unique ID.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId              The unique identifier of a project. For BIM 360
     *                               Docs and ACC Docs, a hub ID corresponds to an
     *                               Account ID. To convert a BIM 360 or ACC Account
     *                               ID to a hub ID, prefix the Account ID with
     *                               &#x60;&#x60;b.&#x60;&#x60;. For example, an
     *                               Account ID of
     *                               &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                               translates to a hub ID of
     *                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                               Similarly, to convert an ACC or BIM 360 project
     *                               ID to a Data Management project ID prefix the
     *                               ACC or BIM 360 project ID with
     *                               &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                               project ID of
     *                               &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                               translates to a project ID of
     *                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                               (required)
     * @param folderId               The unique identifier of a folder. (required)
     * @param getFolderOptionalParams class containing all optional parameters for
     *                               the getFolder method.
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder getFolder(String projectId, String folderId, GetFolderOptionalParams getFolderOptionalParams)
            throws DataManagementApiException {
        try {
            if (getFolderOptionalParams == null) {
                getFolderOptionalParams = new GetFolderOptionalParams.Builder().build();
            }
            if (getFolderOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderOptionalParams.getAccessToken() == null) {
                getFolderOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolder(projectId, folderId, getFolderOptionalParams.getIfModifiedSince(),
                    getFolderOptionalParams.getXUserId(), getFolderOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Folder Contents
     * Returns a list of items and folders within the specified folder. Items
     * represent word documents, fusion design files, drawings, spreadsheets, etc.
     * 
     * The resources contained in the &#x60;&#x60;included&#x60;&#x60; array of the
     * response are their tip versions.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param folderId  The unique identifier of a folder. (required)
     * @return FolderContents
     * @throws DataManagementApiException when an API call fails.
     */

    public FolderContents getFolderContents(String projectId, String folderId) throws DataManagementApiException {
        return getFolderContents(projectId, folderId, null);
    }

    /**
     * List Folder Contents
     * Returns a list of items and folders within the specified folder. Items
     * represent word documents, fusion design files, drawings, spreadsheets, etc.
     * 
     * The resources contained in the &#x60;&#x60;included&#x60;&#x60; array of the
     * response are their tip versions.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                      The unique identifier of a project. For
     *                                       BIM 360 Docs and ACC Docs, a hub ID
     *                                       corresponds to an Account ID. To
     *                                       convert a BIM 360 or ACC Account ID to
     *                                       a hub ID, prefix the Account ID with
     *                                       &#x60;&#x60;b.&#x60;&#x60;. For
     *                                       example, an Account ID of
     *                                       &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                       translates to a hub ID of
     *                                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                       Similarly, to convert an ACC or BIM 360
     *                                       project ID to a Data Management project
     *                                       ID prefix the ACC or BIM 360 project ID
     *                                       with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                       example, a project ID of
     *                                       &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                       translates to a project ID of
     *                                       &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                       (required)
     * @param folderId                       The unique identifier of a folder.
     *                                       (required)
     * @param getFolderContentsOptionalParams class containing all optional
     *                                       parameters for the getFolderContents
     *                                       method.
     * @return FolderContents
     * @throws DataManagementApiException when an API call fails.
     */

    public FolderContents getFolderContents(String projectId, String folderId,
            GetFolderContentsOptionalParams getFolderContentsOptionalParams) throws DataManagementApiException {
        try {
            if (getFolderContentsOptionalParams == null) {
                getFolderContentsOptionalParams = new GetFolderContentsOptionalParams.Builder().build();
            }
            if (getFolderContentsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderContentsOptionalParams.getAccessToken() == null) {
                getFolderContentsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolderContents(projectId, folderId, getFolderContentsOptionalParams.getXUserId(),
                    getFolderContentsOptionalParams.getFilterType(), getFolderContentsOptionalParams.getFilterId(),
                    getFolderContentsOptionalParams.getFilterExtensionType(),
                    getFolderContentsOptionalParams.getFilterLastModifiedTimeRollup(),
                    getFolderContentsOptionalParams.getPageNumber(), getFolderContentsOptionalParams.getPageLimit(),
                    getFolderContentsOptionalParams.getIncludeHidden(),
                    getFolderContentsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Parent of a Folder
     * Returns the parent folder of the specified folder. In a project, folders are
     * organized in a hierarchy. Each folder except for the root folder has a parent
     * folder.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param folderId  The unique identifier of a folder. (required)
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder getFolderParent(String projectId, String folderId) throws DataManagementApiException {
        return getFolderParent(projectId, folderId, null);
    }

    /**
     * Get Parent of a Folder
     * Returns the parent folder of the specified folder. In a project, folders are
     * organized in a hierarchy. Each folder except for the root folder has a parent
     * folder.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                    The unique identifier of a project. For
     *                                     BIM 360 Docs and ACC Docs, a hub ID
     *                                     corresponds to an Account ID. To convert
     *                                     a BIM 360 or ACC Account ID to a hub ID,
     *                                     prefix the Account ID with
     *                                     &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                     an Account ID of
     *                                     &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                     translates to a hub ID of
     *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                     Similarly, to convert an ACC or BIM 360
     *                                     project ID to a Data Management project
     *                                     ID prefix the ACC or BIM 360 project ID
     *                                     with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                     example, a project ID of
     *                                     &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                     translates to a project ID of
     *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                     (required)
     * @param folderId                     The unique identifier of a folder.
     *                                     (required)
     * @param getFolderParentOptionalParams class containing all optional parameters
     *                                     for the getFolderParent method.
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder getFolderParent(String projectId, String folderId,
            GetFolderParentOptionalParams getFolderParentOptionalParams) throws DataManagementApiException {
        try {
            if (getFolderParentOptionalParams == null) {
                getFolderParentOptionalParams = new GetFolderParentOptionalParams.Builder().build();
            }
            if (getFolderParentOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderParentOptionalParams.getAccessToken() == null) {
                getFolderParentOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolderParent(projectId, folderId, getFolderParentOptionalParams.getXUserId(),
                    getFolderParentOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Related Resources for a Folder
     * Returns the resources (items, folders, and versions) that have a custom
     * relationship with the specified folder. Custom relationships can be
     * established between a folder and other resources within the data domain
     * service (folders, items, and versions).
     * 
     * Each relationship is defined by the id of the object at the other end of the
     * relationship, together with type, attributes, and relationships links.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param folderId  The unique identifier of a folder. (required)
     * @return FolderRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public FolderRefs getFolderRefs(String projectId, String folderId) throws DataManagementApiException {
        return getFolderRefs(projectId, folderId, null);
    }

    /**
     * List Related Resources for a Folder
     * Returns the resources (items, folders, and versions) that have a custom
     * relationship with the specified folder. Custom relationships can be
     * established between a folder and other resources within the data domain
     * service (folders, items, and versions).
     * 
     * Each relationship is defined by the id of the object at the other end of the
     * relationship, together with type, attributes, and relationships links.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                  The unique identifier of a project. For BIM
     *                                   360 Docs and ACC Docs, a hub ID corresponds
     *                                   to an Account ID. To convert a BIM 360 or
     *                                   ACC Account ID to a hub ID, prefix the
     *                                   Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                                   For example, an Account ID of
     *                                   &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                   translates to a hub ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   Similarly, to convert an ACC or BIM 360
     *                                   project ID to a Data Management project ID
     *                                   prefix the ACC or BIM 360 project ID with
     *                                   &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                   project ID of
     *                                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                   translates to a project ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   (required)
     * @param folderId                   The unique identifier of a folder.
     *                                   (required)
     * @param getFolderRefsOptionalParams class containing all optional parameters
     *                                   for the getFolderRefs method.
     * @return FolderRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public FolderRefs getFolderRefs(String projectId, String folderId,
            GetFolderRefsOptionalParams getFolderRefsOptionalParams) throws DataManagementApiException {
        try {
            if (getFolderRefsOptionalParams == null) {
                getFolderRefsOptionalParams = new GetFolderRefsOptionalParams.Builder().build();
            }
            if (getFolderRefsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderRefsOptionalParams.getAccessToken() == null) {
                getFolderRefsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolderRefs(projectId, folderId, getFolderRefsOptionalParams.getXUserId(),
                    getFolderRefsOptionalParams.getFilterType(), getFolderRefsOptionalParams.getFilterId(),
                    getFolderRefsOptionalParams.getFilterExtensionType(), getFolderRefsOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Relationship Links for a Folder
     * Returns a list of links for the specified folder.
     * 
     * Custom relationships can be established between a folder and other external
     * resources residing outside the data domain service. A link’s
     * &#x60;&#x60;href&#x60;&#x60; attribute defines the target URI to access a
     * resource.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param folderId  The unique identifier of a folder. (required)
     * @return RelationshipLinks
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipLinks getFolderRelationshipsLinks(String projectId, String folderId)
            throws DataManagementApiException {
        return getFolderRelationshipsLinks(projectId, folderId, null);
    }

    /**
     * List Relationship Links for a Folder
     * Returns a list of links for the specified folder.
     * 
     * Custom relationships can be established between a folder and other external
     * resources residing outside the data domain service. A link’s
     * &#x60;&#x60;href&#x60;&#x60; attribute defines the target URI to access a
     * resource.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                                The unique identifier of a
     *                                                 project. For BIM 360 Docs and
     *                                                 ACC Docs, a hub ID
     *                                                 corresponds to an Account ID.
     *                                                 To convert a BIM 360 or ACC
     *                                                 Account ID to a hub ID,
     *                                                 prefix the Account ID with
     *                                                 &#x60;&#x60;b.&#x60;&#x60;.
     *                                                 For example, an Account ID of
     *                                                 &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                 translates to a hub ID of
     *                                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                 Similarly, to convert an ACC
     *                                                 or BIM 360 project ID to a
     *                                                 Data Management project ID
     *                                                 prefix the ACC or BIM 360
     *                                                 project ID with
     *                                                 &#x60;&#x60;b.&#x60;&#x60;.
     *                                                 For example, a project ID of
     *                                                 &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                 translates to a project ID of
     *                                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                 (required)
     * @param folderId                                 The unique identifier of a
     *                                                 folder. (required)
     * @param getFolderRelationshipsLinksOptionalParams class containing all optional
     *                                                 parameters for the
     *                                                 getFolderRelationshipsLinks
     *                                                 method.
     * @return RelationshipLinks
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipLinks getFolderRelationshipsLinks(String projectId, String folderId,
            GetFolderRelationshipsLinksOptionalParams getFolderRelationshipsLinksOptionalParams)
            throws DataManagementApiException {
        try {
            if (getFolderRelationshipsLinksOptionalParams == null) {
                getFolderRelationshipsLinksOptionalParams = new GetFolderRelationshipsLinksOptionalParams.Builder()
                        .build();
            }
            if (getFolderRelationshipsLinksOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderRelationshipsLinksOptionalParams.getAccessToken() == null) {
                getFolderRelationshipsLinksOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolderRelationshipsLinks(projectId, folderId,
                    getFolderRelationshipsLinksOptionalParams.getXUserId(),
                    getFolderRelationshipsLinksOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Custom Relationships for a Folder
     * Returns the custom relationships associated with the specified folder. Custom
     * relationships can be established between a folder and other resources within
     * the data domain service (folders, items, and versions).
     * 
     * Each relationship is defined by the ID of the object at the other end of the
     * relationship, together with type, specific reference meta including extension
     * data.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * The response body will have an included array that contains the resources in
     * the relationship, which is essentially what is returned by the [List Related
     * Resources for a
     * Folder](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-refs-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param folderId  The unique identifier of a folder. (required)
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @return RelationshipRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipRefs getFolderRelationshipsRefs(String folderId, String projectId)
            throws DataManagementApiException {
        return getFolderRelationshipsRefs(folderId, projectId, null);
    }

    /**
     * List Custom Relationships for a Folder
     * Returns the custom relationships associated with the specified folder. Custom
     * relationships can be established between a folder and other resources within
     * the data domain service (folders, items, and versions).
     * 
     * Each relationship is defined by the ID of the object at the other end of the
     * relationship, together with type, specific reference meta including extension
     * data.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * The response body will have an included array that contains the resources in
     * the relationship, which is essentially what is returned by the [List Related
     * Resources for a
     * Folder](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-refs-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param folderId                                The unique identifier of a
     *                                                folder. (required)
     * @param projectId                               The unique identifier of a
     *                                                project. For BIM 360 Docs and
     *                                                ACC Docs, a hub ID corresponds
     *                                                to an Account ID. To convert a
     *                                                BIM 360 or ACC Account ID to a
     *                                                hub ID, prefix the Account ID
     *                                                with
     *                                                &#x60;&#x60;b.&#x60;&#x60;.
     *                                                For example, an Account ID of
     *                                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                translates to a hub ID of
     *                                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                Similarly, to convert an ACC
     *                                                or BIM 360 project ID to a
     *                                                Data Management project ID
     *                                                prefix the ACC or BIM 360
     *                                                project ID with
     *                                                &#x60;&#x60;b.&#x60;&#x60;.
     *                                                For example, a project ID of
     *                                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                translates to a project ID of
     *                                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                (required)
     * @param getFolderRelationshipsRefsOptionalParams class containing all optional
     *                                                parameters for the
     *                                                getFolderRelationshipsRefs
     *                                                method.
     * @return RelationshipRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipRefs getFolderRelationshipsRefs(String folderId, String projectId,
            GetFolderRelationshipsRefsOptionalParams getFolderRelationshipsRefsOptionalParams)
            throws DataManagementApiException {
        try {
            if (getFolderRelationshipsRefsOptionalParams == null) {
                getFolderRelationshipsRefsOptionalParams = new GetFolderRelationshipsRefsOptionalParams.Builder()
                        .build();
            }
            if (getFolderRelationshipsRefsOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderRelationshipsRefsOptionalParams.getAccessToken() == null) {
                getFolderRelationshipsRefsOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolderRelationshipsRefs(folderId, projectId,
                    getFolderRelationshipsRefsOptionalParams.getXUserId(),
                    getFolderRelationshipsRefsOptionalParams.getFilterType(),
                    getFolderRelationshipsRefsOptionalParams.getFilterId(),
                    getFolderRelationshipsRefsOptionalParams.getFilterRefType(),
                    getFolderRelationshipsRefsOptionalParams.getFilterDirection(),
                    getFolderRelationshipsRefsOptionalParams.getFilterExtensionType(),
                    getFolderRelationshipsRefsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Folder and Subfolder Contents
     * Searches the specified folder and its subfolders and returns a list of the
     * latest versions of the items you can access.
     * 
     * 
     * Use the &#x60;&#x60;filter&#x60;&#x60; query string parameter to narrow down
     * the list as appropriate. You can filter by the following properties of the
     * version payload:
     * 
     * - &#x60;&#x60;type&#x60;&#x60; property,
     * - &#x60;&#x60;id&#x60;&#x60; property,
     * - any of the attributes object properties.
     * 
     * For example, you can filter by &#x60;&#x60;createTime&#x60;&#x60; and
     * &#x60;&#x60;mimeType&#x60;&#x60;. It returns tip versions (latest versions)
     * of properties where the filter conditions are satisfied. To verify the
     * properties of the attributes object for a specific version, use the [Get a
     * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-GET/)
     * operation.
     * 
     * To list the immediate contents of the folder without parsing subfolders, use
     * the [List Folder
     * Contents](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-contents-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param folderId  The unique identifier of a folder. (required)
     * @return Search
     * @throws DataManagementApiException when an API call fails.
     */

    public Search getFolderSearch(String projectId, String folderId) throws DataManagementApiException {
        return getFolderSearch(projectId, folderId, null);
    }

    /**
     * List Folder and Subfolder Contents
     * Searches the specified folder and its subfolders and returns a list of the
     * latest versions of the items you can access.
     * 
     * 
     * Use the &#x60;&#x60;filter&#x60;&#x60; query string parameter to narrow down
     * the list as appropriate. You can filter by the following properties of the
     * version payload:
     * 
     * - &#x60;&#x60;type&#x60;&#x60; property,
     * - &#x60;&#x60;id&#x60;&#x60; property,
     * - any of the attributes object properties.
     * 
     * For example, you can filter by &#x60;&#x60;createTime&#x60;&#x60; and
     * &#x60;&#x60;mimeType&#x60;&#x60;. It returns tip versions (latest versions)
     * of properties where the filter conditions are satisfied. To verify the
     * properties of the attributes object for a specific version, use the [Get a
     * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-GET/)
     * operation.
     * 
     * To list the immediate contents of the folder without parsing subfolders, use
     * the [List Folder
     * Contents](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-contents-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                    The unique identifier of a project. For
     *                                     BIM 360 Docs and ACC Docs, a hub ID
     *                                     corresponds to an Account ID. To convert
     *                                     a BIM 360 or ACC Account ID to a hub ID,
     *                                     prefix the Account ID with
     *                                     &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                     an Account ID of
     *                                     &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                     translates to a hub ID of
     *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                     Similarly, to convert an ACC or BIM 360
     *                                     project ID to a Data Management project
     *                                     ID prefix the ACC or BIM 360 project ID
     *                                     with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                     example, a project ID of
     *                                     &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                     translates to a project ID of
     *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                     (required)
     * @param folderId                     The unique identifier of a folder.
     *                                     (required)
     * @param getFolderSearchOptionalParams class containing all optional parameters
     *                                     for the getFolderSearch method.
     * @return Search
     * @throws DataManagementApiException when an API call fails.
     */

    public Search getFolderSearch(String projectId, String folderId,
            GetFolderSearchOptionalParams getFolderSearchOptionalParams) throws DataManagementApiException {
        try {
            if (getFolderSearchOptionalParams == null) {
                getFolderSearchOptionalParams = new GetFolderSearchOptionalParams.Builder().build();
            }
            if (getFolderSearchOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getFolderSearchOptionalParams.getAccessToken() == null) {
                getFolderSearchOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.getFolderSearch(projectId, folderId, getFolderSearchOptionalParams.getFilters(),
                    getFolderSearchOptionalParams.getPageNumber(), getFolderSearchOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get a Hub
     * Returns the hub specified by the &#x60;&#x60;hub_id&#x60;&#x60; parameter.
     * 
     * For BIM 360 Docs, a hub ID corresponds to a BIM 360 account ID. To convert a
     * BIM 360 account ID to a hub ID, prefix the account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, an account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId The unique identifier of a hub. (required)
     * @return Hub
     * @throws DataManagementApiException when an API call fails.
     */

    public Hub getHub(String hubId) throws DataManagementApiException {
        return getHub(hubId, null);
    }

    /**
     * Get a Hub
     * Returns the hub specified by the &#x60;&#x60;hub_id&#x60;&#x60; parameter.
     * 
     * For BIM 360 Docs, a hub ID corresponds to a BIM 360 account ID. To convert a
     * BIM 360 account ID to a hub ID, prefix the account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, an account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId               The unique identifier of a hub. (required)
     * @param getHubOptionalParams class containing all optional parameters for the
     *                            getHub method.
     * @return Hub
     * @throws DataManagementApiException when an API call fails.
     */

    public Hub getHub(String hubId, GetHubOptionalParams getHubOptionalParams) throws DataManagementApiException {
        try {
            if (getHubOptionalParams == null) {
                getHubOptionalParams = new GetHubOptionalParams.Builder().build();
            }
            if (getHubOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getHubOptionalParams.getAccessToken() == null) {
                getHubOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return hubsApi.getHub(hubId, getHubOptionalParams.getXUserId(), getHubOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Projects
     * Returns a collection of active projects within the specified hub. The
     * returned projects can be Autodesk Construction Cloud (ACC), BIM 360, BIM 360
     * Team, Fusion Team, and A360 Personal projects.
     * 
     * For BIM 360 and ACC projects a hub ID corresponds to an Account ID. To
     * convert an Account ID to a hub ID, prefix the account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, a BIM 360 account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * Similarly, to convert a BIM 360 and ACC project IDs to Data Management
     * project IDs prefix the BIM 360 or ACC Project ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     * &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId The unique identifier of a hub. (required)
     * @return Projects
     * @throws DataManagementApiException when an API call fails.
     */

    public Projects getHubProjects(String hubId) throws DataManagementApiException {
        return getHubProjects(hubId, null);
    }

    /**
     * Get Projects
     * Returns a collection of active projects within the specified hub. The
     * returned projects can be Autodesk Construction Cloud (ACC), BIM 360, BIM 360
     * Team, Fusion Team, and A360 Personal projects.
     * 
     * For BIM 360 and ACC projects a hub ID corresponds to an Account ID. To
     * convert an Account ID to a hub ID, prefix the account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, a BIM 360 account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * Similarly, to convert a BIM 360 and ACC project IDs to Data Management
     * project IDs prefix the BIM 360 or ACC Project ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     * &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId                       The unique identifier of a hub. (required)
     * @param getHubProjectsOptionalParams class containing all optional parameters
     *                                    for the getHubProjects method.
     * @return Projects
     * @throws DataManagementApiException when an API call fails.
     */

    public Projects getHubProjects(String hubId, GetHubProjectsOptionalParams getHubProjectsOptionalParams)
            throws DataManagementApiException {
        try {
            if (getHubProjectsOptionalParams == null) {
                getHubProjectsOptionalParams = new GetHubProjectsOptionalParams.Builder().build();
            }
            if (getHubProjectsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getHubProjectsOptionalParams.getAccessToken() == null) {
                getHubProjectsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.getHubProjects(hubId, getHubProjectsOptionalParams.getXUserId(),
                    getHubProjectsOptionalParams.getFilterId(), getHubProjectsOptionalParams.getFilterExtensionType(),
                    getHubProjectsOptionalParams.getPageNumber(), getHubProjectsOptionalParams.getPageLimit(),
                    getHubProjectsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Hubs
     * Returns a collection of hubs that the user of your app can access.
     * 
     * The returned hubs can be BIM 360 Team hubs, Fusion Team hubs (formerly known
     * as A360 Team hubs), A360 Personal hubs, ACC Docs (Autodesk Docs) accounts, or
     * BIM 360 Docs accounts. Only active hubs are returned.
     * 
     * For BIM 360 Docs and ACC Docs, a hub ID corresponds to an Account ID. To
     * convert a BIM 360 or ACC Account ID to a hub ID, prefix the Account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @return Hubs
     * @throws DataManagementApiException when an API call fails.
     */

    public Hubs getHubs() throws DataManagementApiException {
        return getHubs(null);
    }

    /**
     * List Hubs
     * Returns a collection of hubs that the user of your app can access.
     * 
     * The returned hubs can be BIM 360 Team hubs, Fusion Team hubs (formerly known
     * as A360 Team hubs), A360 Personal hubs, ACC Docs (Autodesk Docs) accounts, or
     * BIM 360 Docs accounts. Only active hubs are returned.
     * 
     * For BIM 360 Docs and ACC Docs, a hub ID corresponds to an Account ID. To
     * convert a BIM 360 or ACC Account ID to a hub ID, prefix the Account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param getHubsOptionalParams class containing all optional parameters for the
     *                             getHubs method.
     * @return Hubs
     * @throws DataManagementApiException when an API call fails.
     */

    public Hubs getHubs(GetHubsOptionalParams getHubsOptionalParams) throws DataManagementApiException {
        try {
            if (getHubsOptionalParams == null) {
                getHubsOptionalParams = new GetHubsOptionalParams.Builder().build();
            }
            if (getHubsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getHubsOptionalParams.getAccessToken() == null) {
                getHubsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return hubsApi.getHubs(getHubsOptionalParams.getXUserId(), getHubsOptionalParams.getFilterId(),
                    getHubsOptionalParams.getFilterName(), getHubsOptionalParams.getFilterExtensionType(),
                    getHubsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get an Item
     * Retrieves an item. Items represent Word documents, Fusion 360 design files,
     * drawings, spreadsheets, etc.
     * 
     * The tip version for the item is included in the included array of the
     * payload.
     * To retrieve multiple items, see the ListItems command.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return Item
     * @throws DataManagementApiException when an API call fails.
     */

    public Item getItem(String projectId, String itemId) throws DataManagementApiException {
        return getItem(projectId, itemId, null);
    }

    /**
     * Get an Item
     * Retrieves an item. Items represent Word documents, Fusion 360 design files,
     * drawings, spreadsheets, etc.
     * 
     * The tip version for the item is included in the included array of the
     * payload.
     * To retrieve multiple items, see the ListItems command.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId            The unique identifier of a project. For BIM 360
     *                             Docs and ACC Docs, a hub ID corresponds to an
     *                             Account ID. To convert a BIM 360 or ACC Account
     *                             ID to a hub ID, prefix the Account ID with
     *                             &#x60;&#x60;b.&#x60;&#x60;. For example, an
     *                             Account ID of
     *                             &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                             translates to a hub ID of
     *                             &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                             Similarly, to convert an ACC or BIM 360 project
     *                             ID to a Data Management project ID prefix the ACC
     *                             or BIM 360 project ID with
     *                             &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                             project ID of
     *                             &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates
     *                             to a project ID of
     *                             &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                             (required)
     * @param itemId               The unique identifier of an item. (required)
     * @param getItemOptionalParams class containing all optional parameters for the
     *                             getItem method.
     * @return Item
     * @throws DataManagementApiException when an API call fails.
     */

    public Item getItem(String projectId, String itemId, GetItemOptionalParams getItemOptionalParams)
            throws DataManagementApiException {
        try {
            if (getItemOptionalParams == null) {
                getItemOptionalParams = new GetItemOptionalParams.Builder().build();
            }
            if (getItemOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemOptionalParams.getAccessToken() == null) {
                getItemOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi
                    .getItem(projectId, itemId, getItemOptionalParams.getXUserId(),
                            getItemOptionalParams.getIncludePathInProject(), getItemOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Parent of an Item
     * Returns the parent folder of the specified item.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder getItemParentFolder(String projectId, String itemId) throws DataManagementApiException {
        return getItemParentFolder(projectId, itemId, null);
    }

    /**
     * Get Parent of an Item
     * Returns the parent folder of the specified item.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                        The unique identifier of a project.
     *                                         For BIM 360 Docs and ACC Docs, a hub
     *                                         ID corresponds to an Account ID. To
     *                                         convert a BIM 360 or ACC Account ID
     *                                         to a hub ID, prefix the Account ID
     *                                         with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                         example, an Account ID of
     *                                         &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                         translates to a hub ID of
     *                                         &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                         Similarly, to convert an ACC or BIM
     *                                         360 project ID to a Data Management
     *                                         project ID prefix the ACC or BIM 360
     *                                         project ID with
     *                                         &#x60;&#x60;b.&#x60;&#x60;. For
     *                                         example, a project ID of
     *                                         &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                         translates to a project ID of
     *                                         &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                         (required)
     * @param itemId                           The unique identifier of an item.
     *                                         (required)
     * @param getItemParentFolderOptionalParams class containing all optional
     *                                         parameters for the
     *                                         getItemParentFolder method.
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder getItemParentFolder(String projectId, String itemId,
            GetItemParentFolderOptionalParams getItemParentFolderOptionalParams) throws DataManagementApiException {
        try {
            if (getItemParentFolderOptionalParams == null) {
                getItemParentFolderOptionalParams = new GetItemParentFolderOptionalParams.Builder().build();
            }
            if (getItemParentFolderOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemParentFolderOptionalParams.getAccessToken() == null) {
                getItemParentFolderOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi.getItemParentFolder(projectId, itemId, getItemParentFolderOptionalParams.getXUserId(),
                    getItemParentFolderOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Related Resources for an Item
     * Returns the resources (items, folders, and versions) that have a custom
     * relationship with the specified item. Custom relationships can be established
     * between an item and other resources within the data domain service (folders,
     * items, and versions).
     * 
     * 
     * Each relationship is defined by the ID of the object at the other end of the
     * relationship, together with type, attributes, and relationships links.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * 
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return Refs
     * @throws DataManagementApiException when an API call fails.
     */

    public Refs getItemRefs(String projectId, String itemId) throws DataManagementApiException {
        return getItemRefs(projectId, itemId, null);
    }

    /**
     * List Related Resources for an Item
     * Returns the resources (items, folders, and versions) that have a custom
     * relationship with the specified item. Custom relationships can be established
     * between an item and other resources within the data domain service (folders,
     * items, and versions).
     * 
     * 
     * Each relationship is defined by the ID of the object at the other end of the
     * relationship, together with type, attributes, and relationships links.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * 
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                The unique identifier of a project. For BIM
     *                                 360 Docs and ACC Docs, a hub ID corresponds
     *                                 to an Account ID. To convert a BIM 360 or ACC
     *                                 Account ID to a hub ID, prefix the Account ID
     *                                 with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                 an Account ID of
     *                                 &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                 translates to a hub ID of
     *                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                 Similarly, to convert an ACC or BIM 360
     *                                 project ID to a Data Management project ID
     *                                 prefix the ACC or BIM 360 project ID with
     *                                 &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                 project ID of
     *                                 &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                 translates to a project ID of
     *                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                 (required)
     * @param itemId                   The unique identifier of an item. (required)
     * @param getItemRefsOptionalParams class containing all optional parameters for
     *                                 the getItemRefs method.
     * @return Refs
     * @throws DataManagementApiException when an API call fails.
     */

    public Refs getItemRefs(String projectId, String itemId, GetItemRefsOptionalParams getItemRefsOptionalParams)
            throws DataManagementApiException {
        try {
            if (getItemRefsOptionalParams == null) {
                getItemRefsOptionalParams = new GetItemRefsOptionalParams.Builder().build();
            }
            if (getItemRefsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemRefsOptionalParams.getAccessToken() == null) {
                getItemRefsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi.getItemRefs(projectId, itemId, getItemRefsOptionalParams.getXUserId(),
                    getItemRefsOptionalParams.getFilterType(), getItemRefsOptionalParams.getFilterId(),
                    getItemRefsOptionalParams.getFilterExtensionType(), getItemRefsOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Relationship Links for an Item
     * Returns a list of links for the specified item.
     * 
     * Custom relationships can be established between an item and other external
     * resources residing outside the data domain service. A link’s
     * &#x60;&#x60;href&#x60;&#x60; attribute defines the target URI to access a
     * resource.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return RelationshipLinks
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipLinks getItemRelationshipsLinks(String projectId, String itemId)
            throws DataManagementApiException {
        return getItemRelationshipsLinks(projectId, itemId, null);
    }

    /**
     * List Relationship Links for an Item
     * Returns a list of links for the specified item.
     * 
     * Custom relationships can be established between an item and other external
     * resources residing outside the data domain service. A link’s
     * &#x60;&#x60;href&#x60;&#x60; attribute defines the target URI to access a
     * resource.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                              The unique identifier of a
     *                                               project. For BIM 360 Docs and
     *                                               ACC Docs, a hub ID corresponds
     *                                               to an Account ID. To convert a
     *                                               BIM 360 or ACC Account ID to a
     *                                               hub ID, prefix the Account ID
     *                                               with
     *                                               &#x60;&#x60;b.&#x60;&#x60;. For
     *                                               example, an Account ID of
     *                                               &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                               translates to a hub ID of
     *                                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                               Similarly, to convert an ACC or
     *                                               BIM 360 project ID to a Data
     *                                               Management project ID prefix
     *                                               the ACC or BIM 360 project ID
     *                                               with
     *                                               &#x60;&#x60;b.&#x60;&#x60;. For
     *                                               example, a project ID of
     *                                               &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                               translates to a project ID of
     *                                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                               (required)
     * @param itemId                                 The unique identifier of an
     *                                               item. (required)
     * @param getItemRelationshipsLinksOptionalParams class containing all optional
     *                                               parameters for the
     *                                               getItemRelationshipsLinks
     *                                               method.
     * @return RelationshipLinks
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipLinks getItemRelationshipsLinks(String projectId, String itemId,
            GetItemRelationshipsLinksOptionalParams getItemRelationshipsLinksOptionalParams)
            throws DataManagementApiException {
        try {
            if (getItemRelationshipsLinksOptionalParams == null) {
                getItemRelationshipsLinksOptionalParams = new GetItemRelationshipsLinksOptionalParams.Builder().build();
            }
            if (getItemRelationshipsLinksOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemRelationshipsLinksOptionalParams.getAccessToken() == null) {
                getItemRelationshipsLinksOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi
                    .getItemRelationshipsLinks(projectId, itemId, getItemRelationshipsLinksOptionalParams.getXUserId(),
                            getItemRelationshipsLinksOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Custom Relationships for an Item
     * Returns the custom relationships that are associated with the specified item.
     * Custom relationships can be established between an item and other resources
     * within the &#x60;&#x60;data&#x60;&#x60; domain service (folders, items, and
     * versions).
     * 
     * Each relationship is defined by the ID of the object at the other end of the
     * relationship, together with type, specific reference meta including extension
     * data.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * The response body will have an included array that contains the resources in
     * the relationship, which is essentially what is returned by the [List Related
     * Resources for an
     * Item](/en/docs/data/v2/reference/http/projects-project_id-items-item_id-refs-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return RelationshipRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipRefs getItemRelationshipsRefs(String projectId, String itemId)
            throws DataManagementApiException {
        return getItemRelationshipsRefs(projectId, itemId, null);
    }

    /**
     * List Custom Relationships for an Item
     * Returns the custom relationships that are associated with the specified item.
     * Custom relationships can be established between an item and other resources
     * within the &#x60;&#x60;data&#x60;&#x60; domain service (folders, items, and
     * versions).
     * 
     * Each relationship is defined by the ID of the object at the other end of the
     * relationship, together with type, specific reference meta including extension
     * data.
     * Callers will typically use a filter parameter to restrict the response to the
     * custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;) they
     * are interested in.
     * The response body will have an included array that contains the resources in
     * the relationship, which is essentially what is returned by the [List Related
     * Resources for an
     * Item](/en/docs/data/v2/reference/http/projects-project_id-items-item_id-refs-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                             The unique identifier of a
     *                                              project. For BIM 360 Docs and
     *                                              ACC Docs, a hub ID corresponds
     *                                              to an Account ID. To convert a
     *                                              BIM 360 or ACC Account ID to a
     *                                              hub ID, prefix the Account ID
     *                                              with &#x60;&#x60;b.&#x60;&#x60;.
     *                                              For example, an Account ID of
     *                                              &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                              translates to a hub ID of
     *                                              &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                              Similarly, to convert an ACC or
     *                                              BIM 360 project ID to a Data
     *                                              Management project ID prefix the
     *                                              ACC or BIM 360 project ID with
     *                                              &#x60;&#x60;b.&#x60;&#x60;. For
     *                                              example, a project ID of
     *                                              &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                              translates to a project ID of
     *                                              &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                              (required)
     * @param itemId                                The unique identifier of an
     *                                              item. (required)
     * @param getItemRelationshipsRefsOptionalParams class containing all optional
     *                                              parameters for the
     *                                              getItemRelationshipsRefs method.
     * @return RelationshipRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipRefs getItemRelationshipsRefs(String projectId, String itemId,
            GetItemRelationshipsRefsOptionalParams getItemRelationshipsRefsOptionalParams)
            throws DataManagementApiException {
        try {
            if (getItemRelationshipsRefsOptionalParams == null) {
                getItemRelationshipsRefsOptionalParams = new GetItemRelationshipsRefsOptionalParams.Builder().build();
            }
            if (getItemRelationshipsRefsOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemRelationshipsRefsOptionalParams.getAccessToken() == null) {
                getItemRelationshipsRefsOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi
                    .getItemRelationshipsRefs(projectId, itemId, getItemRelationshipsRefsOptionalParams.getXUserId(),
                            getItemRelationshipsRefsOptionalParams.getFilterType(),
                            getItemRelationshipsRefsOptionalParams.getFilterId(),
                            getItemRelationshipsRefsOptionalParams.getFilterRefType(),
                            getItemRelationshipsRefsOptionalParams.getFilterDirection(),
                            getItemRelationshipsRefsOptionalParams.getFilterExtensionType(),
                            getItemRelationshipsRefsOptionalParams.getAccessToken())
                    .getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Tip Version of an Item
     * Returns the latest version of the specified item. A project can contain
     * multiple versions of a resource item. The latest version is referred to as
     * the tip version, which is returned by this operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return ItemTip
     * @throws DataManagementApiException when an API call fails.
     */

    public ItemTip getItemTip(String projectId, String itemId) throws DataManagementApiException {
        return getItemTip(projectId, itemId, null);
    }

    /**
     * Get Tip Version of an Item
     * Returns the latest version of the specified item. A project can contain
     * multiple versions of a resource item. The latest version is referred to as
     * the tip version, which is returned by this operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param itemId                  The unique identifier of an item. (required)
     * @param getItemTipOptionalParams class containing all optional parameters for
     *                                the getItemTip method.
     * @return ItemTip
     * @throws DataManagementApiException when an API call fails.
     */

    public ItemTip getItemTip(String projectId, String itemId, GetItemTipOptionalParams getItemTipOptionalParams)
            throws DataManagementApiException {
        try {
            if (getItemTipOptionalParams == null) {
                getItemTipOptionalParams = new GetItemTipOptionalParams.Builder().build();
            }
            if (getItemTipOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemTipOptionalParams.getAccessToken() == null) {
                getItemTipOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi.getItemTip(projectId, itemId, getItemTipOptionalParams.getXUserId(),
                    getItemTipOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List all Versions of an Item
     * Lists all versions of the specified item. A project can contain multiple
     * versions of a resource item.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param itemId    The unique identifier of an item. (required)
     * @return Versions
     * @throws DataManagementApiException when an API call fails.
     */

    public Versions getItemVersions(String projectId, String itemId) throws DataManagementApiException {
        return getItemVersions(projectId, itemId, null);
    }

    /**
     * List all Versions of an Item
     * Lists all versions of the specified item. A project can contain multiple
     * versions of a resource item.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                    The unique identifier of a project. For
     *                                     BIM 360 Docs and ACC Docs, a hub ID
     *                                     corresponds to an Account ID. To convert
     *                                     a BIM 360 or ACC Account ID to a hub ID,
     *                                     prefix the Account ID with
     *                                     &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                     an Account ID of
     *                                     &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                     translates to a hub ID of
     *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                     Similarly, to convert an ACC or BIM 360
     *                                     project ID to a Data Management project
     *                                     ID prefix the ACC or BIM 360 project ID
     *                                     with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                     example, a project ID of
     *                                     &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                     translates to a project ID of
     *                                     &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                     (required)
     * @param itemId                       The unique identifier of an item.
     *                                     (required)
     * @param getItemVersionsOptionalParams class containing all optional parameters
     *                                     for the getItemVersions method.
     * @return Versions
     * @throws DataManagementApiException when an API call fails.
     */

    public Versions getItemVersions(String projectId, String itemId,
            GetItemVersionsOptionalParams getItemVersionsOptionalParams) throws DataManagementApiException {
        try {
            if (getItemVersionsOptionalParams == null) {
                getItemVersionsOptionalParams = new GetItemVersionsOptionalParams.Builder().build();
            }
            if (getItemVersionsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getItemVersionsOptionalParams.getAccessToken() == null) {
                getItemVersionsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi.getItemVersions(projectId, itemId, getItemVersionsOptionalParams.getXUserId(),
                    getItemVersionsOptionalParams.getFilterId(), getItemVersionsOptionalParams.getFilterExtensionType(),
                    getItemVersionsOptionalParams.getFilterVersionNumber(),
                    getItemVersionsOptionalParams.getPageNumber(), getItemVersionsOptionalParams.getPageLimit(),
                    getItemVersionsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get a Project
     * Returns the specified project from within the specified hub.
     * 
     * For BIM 360 Docs, a hub ID corresponds to a BIM 360 account ID. To convert a
     * BIM 360 account ID to a hub ID, prefix the account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, an account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * Similarly, to convert a BIM 360 project ID to a Data Management project ID
     * prefix the BIM 360 Project ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
     * project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project
     * ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId     The unique identifier of a hub. (required)
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @return Project
     * @throws DataManagementApiException when an API call fails.
     */

    public Project getProject(String hubId, String projectId) throws DataManagementApiException {
        return getProject(hubId, projectId, null);
    }

    /**
     * Get a Project
     * Returns the specified project from within the specified hub.
     * 
     * For BIM 360 Docs, a hub ID corresponds to a BIM 360 account ID. To convert a
     * BIM 360 account ID to a hub ID, prefix the account ID with
     * &#x60;&#x60;b.&#x60;&#x60;. For example, an account ID of
     * &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60; translates to a hub ID of
     * &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * Similarly, to convert a BIM 360 project ID to a Data Management project ID
     * prefix the BIM 360 Project ID with &#x60;&#x60;b.&#x60;&#x60;. For example, a
     * project ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a project
     * ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId                   The unique identifier of a hub. (required)
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param getProjectOptionalParams class containing all optional parameters for
     *                                the getProject method.
     * @return Project
     * @throws DataManagementApiException when an API call fails.
     */

    public Project getProject(String hubId, String projectId, GetProjectOptionalParams getProjectOptionalParams)
            throws DataManagementApiException {
        try {
            if (getProjectOptionalParams == null) {
                getProjectOptionalParams = new GetProjectOptionalParams.Builder().build();
            }
            if (getProjectOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getProjectOptionalParams.getAccessToken() == null) {
                getProjectOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.getProject(hubId, projectId, getProjectOptionalParams.getXUserId(),
                    getProjectOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Hub for Project
     * Returns the hub that contains the project specified by the
     * &#x60;&#x60;project_id&#x60;&#x60; parameter.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId     The unique identifier of a hub. (required)
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @return Hub
     * @throws DataManagementApiException when an API call fails.
     */

    public Hub getProjectHub(String hubId, String projectId) throws DataManagementApiException {
        return getProjectHub(hubId, projectId, null);
    }

    /**
     * Get Hub for Project
     * Returns the hub that contains the project specified by the
     * &#x60;&#x60;project_id&#x60;&#x60; parameter.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId                      The unique identifier of a hub. (required)
     * @param projectId                  The unique identifier of a project. For BIM
     *                                   360 Docs and ACC Docs, a hub ID corresponds
     *                                   to an Account ID. To convert a BIM 360 or
     *                                   ACC Account ID to a hub ID, prefix the
     *                                   Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                                   For example, an Account ID of
     *                                   &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                   translates to a hub ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   Similarly, to convert an ACC or BIM 360
     *                                   project ID to a Data Management project ID
     *                                   prefix the ACC or BIM 360 project ID with
     *                                   &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                   project ID of
     *                                   &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                   translates to a project ID of
     *                                   &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                   (required)
     * @param getProjectHubOptionalParams class containing all optional parameters
     *                                   for the getProjectHub method.
     * @return Hub
     * @throws DataManagementApiException when an API call fails.
     */

    public Hub getProjectHub(String hubId, String projectId, GetProjectHubOptionalParams getProjectHubOptionalParams)
            throws DataManagementApiException {
        try {
            if (getProjectHubOptionalParams == null) {
                getProjectHubOptionalParams = new GetProjectHubOptionalParams.Builder().build();
            }
            if (getProjectHubOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getProjectHubOptionalParams.getAccessToken() == null) {
                getProjectHubOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.getProjectHub(hubId, projectId, getProjectHubOptionalParams.getXUserId(),
                    getProjectHubOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Top-level Project Folders
     * Returns the details of the highest level folders within a project that the
     * user calling this operation has access to. The user must have at least read
     * access to the folders.
     * 
     * If the user is a Project Admin, it returns all top-level folders in the
     * project. Otherwise, it returns all the highest level folders in the folder
     * hierarchy the user has access to.
     * 
     * Users with access permission to a folder has access permission to all its
     * subfolders.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId     The unique identifier of a hub. (required)
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @return TopFolders
     * @throws DataManagementApiException when an API call fails.
     */

    public TopFolders getProjectTopFolders(String hubId, String projectId) throws DataManagementApiException {
        return getProjectTopFolders(hubId, projectId, null);
    }

    /**
     * List Top-level Project Folders
     * Returns the details of the highest level folders within a project that the
     * user calling this operation has access to. The user must have at least read
     * access to the folders.
     * 
     * If the user is a Project Admin, it returns all top-level folders in the
     * project. Otherwise, it returns all the highest level folders in the folder
     * hierarchy the user has access to.
     * 
     * Users with access permission to a folder has access permission to all its
     * subfolders.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param hubId                             The unique identifier of a hub.
     *                                          (required)
     * @param projectId                         The unique identifier of a project.
     *                                          For BIM 360 Docs and ACC Docs, a hub
     *                                          ID corresponds to an Account ID. To
     *                                          convert a BIM 360 or ACC Account ID
     *                                          to a hub ID, prefix the Account ID
     *                                          with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                          example, an Account ID of
     *                                          &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                          translates to a hub ID of
     *                                          &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                          Similarly, to convert an ACC or BIM
     *                                          360 project ID to a Data Management
     *                                          project ID prefix the ACC or BIM 360
     *                                          project ID with
     *                                          &#x60;&#x60;b.&#x60;&#x60;. For
     *                                          example, a project ID of
     *                                          &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                          translates to a project ID of
     *                                          &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                          (required)
     * @param getProjectTopFoldersOptionalParams class containing all optional
     *                                          parameters for the
     *                                          getProjectTopFolders method.
     * @return TopFolders
     * @throws DataManagementApiException when an API call fails.
     */

    public TopFolders getProjectTopFolders(String hubId, String projectId,
            GetProjectTopFoldersOptionalParams getProjectTopFoldersOptionalParams) throws DataManagementApiException {
        try {
            if (getProjectTopFoldersOptionalParams == null) {
                getProjectTopFoldersOptionalParams = new GetProjectTopFoldersOptionalParams.Builder().build();
            }
            if (getProjectTopFoldersOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getProjectTopFoldersOptionalParams.getAccessToken() == null) {
                getProjectTopFoldersOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return projectsApi.getProjectTopFolders(hubId, projectId, getProjectTopFoldersOptionalParams.getXUserId(),
                    getProjectTopFoldersOptionalParams.getExcludeDeleted(),
                    getProjectTopFoldersOptionalParams.getProjectFilesOnly(),
                    getProjectTopFoldersOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get a Version
     * Returns the specified version of an item.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return Version
     * @throws DataManagementApiException when an API call fails.
     */

    public Version getVersion(String projectId, String versionId) throws DataManagementApiException {
        return getVersion(projectId, versionId, null);
    }

    /**
     * Get a Version
     * Returns the specified version of an item.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId               The unique identifier of a project. For BIM
     *                                360 Docs and ACC Docs, a hub ID corresponds to
     *                                an Account ID. To convert a BIM 360 or ACC
     *                                Account ID to a hub ID, prefix the Account ID
     *                                with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                an Account ID of
     *                                &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                translates to a hub ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                Similarly, to convert an ACC or BIM 360
     *                                project ID to a Data Management project ID
     *                                prefix the ACC or BIM 360 project ID with
     *                                &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                project ID of
     *                                &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                translates to a project ID of
     *                                &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                (required)
     * @param versionId               The URL encoded unique identifier of a
     *                                version. (required)
     * @param getVersionOptionalParams class containing all optional parameters for
     *                                the getVersion method.
     * @return Version
     * @throws DataManagementApiException when an API call fails.
     */

    public Version getVersion(String projectId, String versionId, GetVersionOptionalParams getVersionOptionalParams)
            throws DataManagementApiException {
        try {
            if (getVersionOptionalParams == null) {
                getVersionOptionalParams = new GetVersionOptionalParams.Builder().build();
            }
            if (getVersionOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionOptionalParams.getAccessToken() == null) {
                getVersionOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersion(projectId, versionId, getVersionOptionalParams.getXUserId(),
                    getVersionOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Supported Download Formats
     * Returns a list of file formats the specified version of an item can be
     * downloaded as.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return DownloadFormats
     * @throws DataManagementApiException when an API call fails.
     */

    public DownloadFormats getVersionDownloadFormats(String projectId, String versionId)
            throws DataManagementApiException {
        return getVersionDownloadFormats(projectId, versionId, null);
    }

    /**
     * List Supported Download Formats
     * Returns a list of file formats the specified version of an item can be
     * downloaded as.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                              The unique identifier of a
     *                                               project. For BIM 360 Docs and
     *                                               ACC Docs, a hub ID corresponds
     *                                               to an Account ID. To convert a
     *                                               BIM 360 or ACC Account ID to a
     *                                               hub ID, prefix the Account ID
     *                                               with
     *                                               &#x60;&#x60;b.&#x60;&#x60;. For
     *                                               example, an Account ID of
     *                                               &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                               translates to a hub ID of
     *                                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                               Similarly, to convert an ACC or
     *                                               BIM 360 project ID to a Data
     *                                               Management project ID prefix
     *                                               the ACC or BIM 360 project ID
     *                                               with
     *                                               &#x60;&#x60;b.&#x60;&#x60;. For
     *                                               example, a project ID of
     *                                               &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                               translates to a project ID of
     *                                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                               (required)
     * @param versionId                              The URL encoded unique
     *                                               identifier of a version.
     *                                               (required)
     * @param getVersionDownloadFormatsOptionalParams class containing all optional
     *                                               parameters for the
     *                                               getVersionDownloadFormats
     *                                               method.
     * @return DownloadFormats
     * @throws DataManagementApiException when an API call fails.
     */

    public DownloadFormats getVersionDownloadFormats(String projectId, String versionId,
            GetVersionDownloadFormatsOptionalParams getVersionDownloadFormatsOptionalParams)
            throws DataManagementApiException {
        try {
            if (getVersionDownloadFormatsOptionalParams == null) {
                getVersionDownloadFormatsOptionalParams = new GetVersionDownloadFormatsOptionalParams.Builder().build();
            }
            if (getVersionDownloadFormatsOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionDownloadFormatsOptionalParams.getAccessToken() == null) {
                getVersionDownloadFormatsOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersionDownloadFormats(projectId, versionId,
                    getVersionDownloadFormatsOptionalParams.getXUserId(),
                    getVersionDownloadFormatsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Available Download Formats
     * Returns the list of file formats of the specified version of an item
     * currently available for download.
     * 
     * **Note:** This operation is not fully implemented as yet. It currently
     * returns an empty data object.
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return Downloads
     * @throws DataManagementApiException when an API call fails.
     */

    public Downloads getVersionDownloads(String projectId, String versionId) throws DataManagementApiException {
        return getVersionDownloads(projectId, versionId, null);
    }

    /**
     * List Available Download Formats
     * Returns the list of file formats of the specified version of an item
     * currently available for download.
     * 
     * **Note:** This operation is not fully implemented as yet. It currently
     * returns an empty data object.
     * 
     * @param projectId                        The unique identifier of a project.
     *                                         For BIM 360 Docs and ACC Docs, a hub
     *                                         ID corresponds to an Account ID. To
     *                                         convert a BIM 360 or ACC Account ID
     *                                         to a hub ID, prefix the Account ID
     *                                         with &#x60;&#x60;b.&#x60;&#x60;. For
     *                                         example, an Account ID of
     *                                         &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                         translates to a hub ID of
     *                                         &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                         Similarly, to convert an ACC or BIM
     *                                         360 project ID to a Data Management
     *                                         project ID prefix the ACC or BIM 360
     *                                         project ID with
     *                                         &#x60;&#x60;b.&#x60;&#x60;. For
     *                                         example, a project ID of
     *                                         &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                         translates to a project ID of
     *                                         &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                         (required)
     * @param versionId                        The URL encoded unique identifier of
     *                                         a version. (required)
     * @param getVersionDownloadsOptionalParams class containing all optional
     *                                         parameters for the
     *                                         getVersionDownloads method.
     * @return Downloads
     * @throws DataManagementApiException when an API call fails.
     */

    public Downloads getVersionDownloads(String projectId, String versionId,
            GetVersionDownloadsOptionalParams getVersionDownloadsOptionalParams) throws DataManagementApiException {
        try {
            if (getVersionDownloadsOptionalParams == null) {
                getVersionDownloadsOptionalParams = new GetVersionDownloadsOptionalParams.Builder().build();
            }
            if (getVersionDownloadsOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionDownloadsOptionalParams.getAccessToken() == null) {
                getVersionDownloadsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersionDownloads(projectId, versionId, getVersionDownloadsOptionalParams.getXUserId(),
                    getVersionDownloadsOptionalParams.getFilterFormatFileType(),
                    getVersionDownloadsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Get Item by Version
     * Returns the item corresponding to the specified version.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return Item
     * @throws DataManagementApiException when an API call fails.
     */

    public Item getVersionItem(String projectId, String versionId) throws DataManagementApiException {
        return getVersionItem(projectId, versionId, null);
    }

    /**
     * Get Item by Version
     * Returns the item corresponding to the specified version.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                   The unique identifier of a project. For
     *                                    BIM 360 Docs and ACC Docs, a hub ID
     *                                    corresponds to an Account ID. To convert a
     *                                    BIM 360 or ACC Account ID to a hub ID,
     *                                    prefix the Account ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                    an Account ID of
     *                                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                    translates to a hub ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    Similarly, to convert an ACC or BIM 360
     *                                    project ID to a Data Management project ID
     *                                    prefix the ACC or BIM 360 project ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                    project ID of
     *                                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                    translates to a project ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    (required)
     * @param versionId                   The URL encoded unique identifier of a
     *                                    version. (required)
     * @param getVersionItemOptionalParams class containing all optional parameters
     *                                    for the getVersionItem method.
     * @return Item
     * @throws DataManagementApiException when an API call fails.
     */

    public Item getVersionItem(String projectId, String versionId,
            GetVersionItemOptionalParams getVersionItemOptionalParams) throws DataManagementApiException {
        try {
            if (getVersionItemOptionalParams == null) {
                getVersionItemOptionalParams = new GetVersionItemOptionalParams.Builder().build();
            }
            if (getVersionItemOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionItemOptionalParams.getAccessToken() == null) {
                getVersionItemOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersionItem(projectId, versionId, getVersionItemOptionalParams.getXUserId(),
                    getVersionItemOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Related Resources for a Version
     * Returns the resources (items, folders, and versions) that have a custom
     * relationship with the specified version.
     * 
     * Custom relationships can be established between a version of an item and
     * other resources within the data domain service (folders, items, and
     * versions).
     * 
     * - Each relationship is defined by the id of the object at the other end of
     * the relationship, together with type, attributes, and relationships links.
     * - Callers will typically use a filter parameter to restrict the response to
     * the custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;)
     * they are interested in.
     * - The response body will have an included array that contains the ref
     * resources that are involved in the relationship, which is essentially the
     * response to the [List Custom Relationships for a
     * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-relationships-refs-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return Refs
     * @throws DataManagementApiException when an API call fails.
     */

    public Refs getVersionRefs(String projectId, String versionId) throws DataManagementApiException {
        return getVersionRefs(projectId, versionId, null);
    }

    /**
     * List Related Resources for a Version
     * Returns the resources (items, folders, and versions) that have a custom
     * relationship with the specified version.
     * 
     * Custom relationships can be established between a version of an item and
     * other resources within the data domain service (folders, items, and
     * versions).
     * 
     * - Each relationship is defined by the id of the object at the other end of
     * the relationship, together with type, attributes, and relationships links.
     * - Callers will typically use a filter parameter to restrict the response to
     * the custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;)
     * they are interested in.
     * - The response body will have an included array that contains the ref
     * resources that are involved in the relationship, which is essentially the
     * response to the [List Custom Relationships for a
     * Version](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-relationships-refs-GET/)
     * operation.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                   The unique identifier of a project. For
     *                                    BIM 360 Docs and ACC Docs, a hub ID
     *                                    corresponds to an Account ID. To convert a
     *                                    BIM 360 or ACC Account ID to a hub ID,
     *                                    prefix the Account ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                    an Account ID of
     *                                    &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                    translates to a hub ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    Similarly, to convert an ACC or BIM 360
     *                                    project ID to a Data Management project ID
     *                                    prefix the ACC or BIM 360 project ID with
     *                                    &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                    project ID of
     *                                    &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                    translates to a project ID of
     *                                    &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                    (required)
     * @param versionId                   The URL encoded unique identifier of a
     *                                    version. (required)
     * @param getVersionRefsOptionalParams class containing all optional parameters
     *                                    for the getVersionRefs method.
     * @return Refs
     * @throws DataManagementApiException when an API call fails.
     */

    public Refs getVersionRefs(String projectId, String versionId,
            GetVersionRefsOptionalParams getVersionRefsOptionalParams) throws DataManagementApiException {
        try {
            if (getVersionRefsOptionalParams == null) {
                getVersionRefsOptionalParams = new GetVersionRefsOptionalParams.Builder().build();
            }
            if (getVersionRefsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionRefsOptionalParams.getAccessToken() == null) {
                getVersionRefsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersionRefs(projectId, versionId, getVersionRefsOptionalParams.getXUserId(),
                    getVersionRefsOptionalParams.getFilterType(), getVersionRefsOptionalParams.getFilterId(),
                    getVersionRefsOptionalParams.getFilterExtensionType(),
                    getVersionRefsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Links for a Version
     * Returns a collection of links for the specified version of an item. Custom
     * relationships can be established between a version of an item and other
     * external resources residing outside the data domain service. A link’s href
     * defines the target URI to access the resource.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return RelationshipLinks
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipLinks getVersionRelationshipsLinks(String projectId, String versionId)
            throws DataManagementApiException {
        return getVersionRelationshipsLinks(projectId, versionId, null);
    }

    /**
     * List Links for a Version
     * Returns a collection of links for the specified version of an item. Custom
     * relationships can be established between a version of an item and other
     * external resources residing outside the data domain service. A link’s href
     * defines the target URI to access the resource.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                                 The unique identifier of a
     *                                                  project. For BIM 360 Docs
     *                                                  and ACC Docs, a hub ID
     *                                                  corresponds to an Account
     *                                                  ID. To convert a BIM 360 or
     *                                                  ACC Account ID to a hub ID,
     *                                                  prefix the Account ID with
     *                                                  &#x60;&#x60;b.&#x60;&#x60;.
     *                                                  For example, an Account ID
     *                                                  of
     *                                                  &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                  translates to a hub ID of
     *                                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                  Similarly, to convert an ACC
     *                                                  or BIM 360 project ID to a
     *                                                  Data Management project ID
     *                                                  prefix the ACC or BIM 360
     *                                                  project ID with
     *                                                  &#x60;&#x60;b.&#x60;&#x60;.
     *                                                  For example, a project ID of
     *                                                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                  translates to a project ID
     *                                                  of
     *                                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                  (required)
     * @param versionId                                 The URL encoded unique
     *                                                  identifier of a version.
     *                                                  (required)
     * @param getVersionRelationshipsLinksOptionalParams class containing all
     *                                                  optional parameters for the
     *                                                  getVersionRelationshipsLinks
     *                                                  method.
     * @return RelationshipLinks
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipLinks getVersionRelationshipsLinks(String projectId, String versionId,
            GetVersionRelationshipsLinksOptionalParams getVersionRelationshipsLinksOptionalParams)
            throws DataManagementApiException {
        try {
            if (getVersionRelationshipsLinksOptionalParams == null) {
                getVersionRelationshipsLinksOptionalParams = new GetVersionRelationshipsLinksOptionalParams.Builder()
                        .build();
            }
            if (getVersionRelationshipsLinksOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionRelationshipsLinksOptionalParams.getAccessToken() == null) {
                getVersionRelationshipsLinksOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersionRelationshipsLinks(projectId, versionId,
                    getVersionRelationshipsLinksOptionalParams.getXUserId(),
                    getVersionRelationshipsLinksOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * List Custom Relationships for a Version
     * Returns the custom relationships for the specified version.
     * 
     * Custom relationships can be established between a version of an item and
     * other resources within the data domain service (folders, items, and
     * versions).
     * 
     * - Each relationship is defined by the id of the object at the other end of
     * the relationship, together with type, specific reference meta including
     * extension data.
     * - Callers will typically use a filter parameter to restrict the response to
     * the custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;)
     * they are interested in.
     * - The response body will have an included array that contains the resources
     * in the relationship, which is essentially the response to the [List Related
     * Resources
     * operation](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-relationships-refs-POST/).
     * - To get custom relationships for multiple versions, see the ListRefs
     * command.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId The unique identifier of a project. For BIM 360 Docs and ACC
     *                  Docs, a hub ID corresponds to an Account ID. To convert a
     *                  BIM 360 or ACC Account ID to a hub ID, prefix the Account ID
     *                  with &#x60;&#x60;b.&#x60;&#x60;. For example, an Account ID
     *                  of &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                  translates to a hub ID of
     *                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly, to
     *                  convert an ACC or BIM 360 project ID to a Data Management
     *                  project ID prefix the ACC or BIM 360 project ID with
     *                  &#x60;&#x60;b.&#x60;&#x60;. For example, a project ID of
     *                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to a
     *                  project ID of &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                  (required)
     * @param versionId The URL encoded unique identifier of a version. (required)
     * @return RelationshipRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipRefs getVersionRelationshipsRefs(String projectId, String versionId)
            throws DataManagementApiException {
        return getVersionRelationshipsRefs(projectId, versionId, null);
    }

    /**
     * List Custom Relationships for a Version
     * Returns the custom relationships for the specified version.
     * 
     * Custom relationships can be established between a version of an item and
     * other resources within the data domain service (folders, items, and
     * versions).
     * 
     * - Each relationship is defined by the id of the object at the other end of
     * the relationship, together with type, specific reference meta including
     * extension data.
     * - Callers will typically use a filter parameter to restrict the response to
     * the custom relationship types (&#x60;&#x60;filter[meta.refType]&#x60;&#x60;)
     * they are interested in.
     * - The response body will have an included array that contains the resources
     * in the relationship, which is essentially the response to the [List Related
     * Resources
     * operation](/en/docs/data/v2/reference/http/projects-project_id-versions-version_id-relationships-refs-POST/).
     * - To get custom relationships for multiple versions, see the ListRefs
     * command.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                                The unique identifier of a
     *                                                 project. For BIM 360 Docs and
     *                                                 ACC Docs, a hub ID
     *                                                 corresponds to an Account ID.
     *                                                 To convert a BIM 360 or ACC
     *                                                 Account ID to a hub ID,
     *                                                 prefix the Account ID with
     *                                                 &#x60;&#x60;b.&#x60;&#x60;.
     *                                                 For example, an Account ID of
     *                                                 &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                                 translates to a hub ID of
     *                                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                 Similarly, to convert an ACC
     *                                                 or BIM 360 project ID to a
     *                                                 Data Management project ID
     *                                                 prefix the ACC or BIM 360
     *                                                 project ID with
     *                                                 &#x60;&#x60;b.&#x60;&#x60;.
     *                                                 For example, a project ID of
     *                                                 &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                                 translates to a project ID of
     *                                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                                 (required)
     * @param versionId                                The URL encoded unique
     *                                                 identifier of a version.
     *                                                 (required)
     * @param getVersionRelationshipsRefsOptionalParams class containing all optional
     *                                                 parameters for the
     *                                                 getVersionRelationshipsRefs
     *                                                 method.
     * @return RelationshipRefs
     * @throws DataManagementApiException when an API call fails.
     */

    public RelationshipRefs getVersionRelationshipsRefs(String projectId, String versionId,
            GetVersionRelationshipsRefsOptionalParams getVersionRelationshipsRefsOptionalParams)
            throws DataManagementApiException {
        try {
            if (getVersionRelationshipsRefsOptionalParams == null) {
                getVersionRelationshipsRefsOptionalParams = new GetVersionRelationshipsRefsOptionalParams.Builder()
                        .build();
            }
            if (getVersionRelationshipsRefsOptionalParams.getAccessToken() == null
                    && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (getVersionRelationshipsRefsOptionalParams.getAccessToken() == null) {
                getVersionRelationshipsRefsOptionalParams
                        .setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.getVersionRelationshipsRefs(projectId, versionId,
                    getVersionRelationshipsRefsOptionalParams.getXUserId(),
                    getVersionRelationshipsRefsOptionalParams.getFilterType(),
                    getVersionRelationshipsRefsOptionalParams.getFilterId(),
                    getVersionRelationshipsRefsOptionalParams.getFilterRefType(),
                    getVersionRelationshipsRefsOptionalParams.getFilterDirection(),
                    getVersionRelationshipsRefsOptionalParams.getFilterExtensionType(),
                    getVersionRelationshipsRefsOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Modify a Folder
     * Renames, moves, hides, or unhides a folder. Marking a BIM 360 Docs folder as
     * hidden effectively deletes it. You can restore it by changing its
     * &#x60;&#x60;hidden&#x60;&#x60; attribute. You can also move BIM 360 Docs
     * folders by changing their parent folder.
     * 
     * You cannot permanently delete BIM 360 Docs folders. They are tagged as hidden
     * folders and are removed from the BIM 360 Docs UI and from regular Data
     * Management API responses. You can use the hidden filter
     * (&#x60;&#x60;filter[hidden]&#x3D;true&#x60;&#x60;) to get a list of deleted
     * folders with the [List Folder
     * Contents](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-contents-GET/)
     * operation.
     * 
     * Before you use the Data Management API to access BIM 360 Docs folders,
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](/en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId           The unique identifier of a project. For BIM 360
     *                            Docs and ACC Docs, a hub ID corresponds to an
     *                            Account ID. To convert a BIM 360 or ACC Account ID
     *                            to a hub ID, prefix the Account ID with
     *                            &#x60;&#x60;b.&#x60;&#x60;. For example, an
     *                            Account ID of
     *                            &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                            translates to a hub ID of
     *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                            Similarly, to convert an ACC or BIM 360 project ID
     *                            to a Data Management project ID prefix the ACC or
     *                            BIM 360 project ID with
     *                            &#x60;&#x60;b.&#x60;&#x60;. For example, a project
     *                            ID of &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                            translates to a project ID of
     *                            &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                            (required)
     * @param folderId            The unique identifier of a folder. (required)
     * @param modifyFolderPayload Describe the folder to be patched. (required)
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder patchFolder(String projectId, String folderId, ModifyFolderPayload modifyFolderPayload)
            throws DataManagementApiException {
        return patchFolder(projectId, folderId, modifyFolderPayload, null);
    }

    /**
     * Modify a Folder
     * Renames, moves, hides, or unhides a folder. Marking a BIM 360 Docs folder as
     * hidden effectively deletes it. You can restore it by changing its
     * &#x60;&#x60;hidden&#x60;&#x60; attribute. You can also move BIM 360 Docs
     * folders by changing their parent folder.
     * 
     * You cannot permanently delete BIM 360 Docs folders. They are tagged as hidden
     * folders and are removed from the BIM 360 Docs UI and from regular Data
     * Management API responses. You can use the hidden filter
     * (&#x60;&#x60;filter[hidden]&#x3D;true&#x60;&#x60;) to get a list of deleted
     * folders with the [List Folder
     * Contents](/en/docs/data/v2/reference/http/projects-project_id-folders-folder_id-contents-GET/)
     * operation.
     * 
     * Before you use the Data Management API to access BIM 360 Docs folders,
     * provision your app through the BIM 360 Account Administrator portal. For
     * details, see the [Manage Access to Docs
     * tutorial](/en/docs/bim360/v1/tutorials/getting-started/manage-access-to-docs/).
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](/en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId                The unique identifier of a project. For BIM
     *                                 360 Docs and ACC Docs, a hub ID corresponds
     *                                 to an Account ID. To convert a BIM 360 or ACC
     *                                 Account ID to a hub ID, prefix the Account ID
     *                                 with &#x60;&#x60;b.&#x60;&#x60;. For example,
     *                                 an Account ID of
     *                                 &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                 translates to a hub ID of
     *                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                 Similarly, to convert an ACC or BIM 360
     *                                 project ID to a Data Management project ID
     *                                 prefix the ACC or BIM 360 project ID with
     *                                 &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                 project ID of
     *                                 &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                 translates to a project ID of
     *                                 &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                 (required)
     * @param folderId                 The unique identifier of a folder. (required)
     * @param modifyFolderPayload      Describe the folder to be patched. (required)
     * @param patchFolderOptionalParams class containing all optional parameters for
     *                                 the patchFolder method.
     * @return Folder
     * @throws DataManagementApiException when an API call fails.
     */

    public Folder patchFolder(String projectId, String folderId, ModifyFolderPayload modifyFolderPayload,
            PatchFolderOptionalParams patchFolderOptionalParams) throws DataManagementApiException {
        try {
            if (patchFolderOptionalParams == null) {
                patchFolderOptionalParams = new PatchFolderOptionalParams.Builder().build();
            }
            if (patchFolderOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (patchFolderOptionalParams.getAccessToken() == null) {
                patchFolderOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return foldersApi.patchFolder(projectId, folderId, modifyFolderPayload,
                    patchFolderOptionalParams.getXUserId(), patchFolderOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Update an Item
     * Updates the &#x60;&#x60;displayName&#x60;&#x60; of the specified item. Note
     * that updating the &#x60;&#x60;displayName&#x60;&#x60; of an item is not
     * supported for BIM 360 Docs or ACC items.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId         The unique identifier of a project. For BIM 360 Docs
     *                          and ACC Docs, a hub ID corresponds to an Account ID.
     *                          To convert a BIM 360 or ACC Account ID to a hub ID,
     *                          prefix the Account ID with
     *                          &#x60;&#x60;b.&#x60;&#x60;. For example, an Account
     *                          ID of
     *                          &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                          translates to a hub ID of
     *                          &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. Similarly,
     *                          to convert an ACC or BIM 360 project ID to a Data
     *                          Management project ID prefix the ACC or BIM 360
     *                          project ID with &#x60;&#x60;b.&#x60;&#x60;. For
     *                          example, a project ID of
     *                          &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates to
     *                          a project ID of
     *                          &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;. (required)
     * @param itemId            The unique identifier of an item. (required)
     * @param modifyItemPayload Describe the item to be patched. (required)
     * @return Item
     * @throws DataManagementApiException when an API call fails.
     */

    public Item patchItem(String projectId, String itemId, ModifyItemPayload modifyItemPayload)
            throws DataManagementApiException {
        return patchItem(projectId, itemId, modifyItemPayload, null);
    }

    /**
     * Update an Item
     * Updates the &#x60;&#x60;displayName&#x60;&#x60; of the specified item. Note
     * that updating the &#x60;&#x60;displayName&#x60;&#x60; of an item is not
     * supported for BIM 360 Docs or ACC items.
     * 
     * **Note:** This operation supports Autodesk Construction Cloud (ACC) Projects.
     * For more information, see the [ACC Platform API
     * documentation](https://en.docs.acc.v1/overview/introduction/).
     * 
     * @param projectId              The unique identifier of a project. For BIM 360
     *                               Docs and ACC Docs, a hub ID corresponds to an
     *                               Account ID. To convert a BIM 360 or ACC Account
     *                               ID to a hub ID, prefix the Account ID with
     *                               &#x60;&#x60;b.&#x60;&#x60;. For example, an
     *                               Account ID of
     *                               &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                               translates to a hub ID of
     *                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                               Similarly, to convert an ACC or BIM 360 project
     *                               ID to a Data Management project ID prefix the
     *                               ACC or BIM 360 project ID with
     *                               &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                               project ID of
     *                               &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                               translates to a project ID of
     *                               &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                               (required)
     * @param itemId                 The unique identifier of an item. (required)
     * @param modifyItemPayload      Describe the item to be patched. (required)
     * @param patchItemOptionalParams class containing all optional parameters for
     *                               the patchItem method.
     * @return Item
     * @throws DataManagementApiException when an API call fails.
     */

    public Item patchItem(String projectId, String itemId, ModifyItemPayload modifyItemPayload,
            PatchItemOptionalParams patchItemOptionalParams) throws DataManagementApiException {
        try {
            if (patchItemOptionalParams == null) {
                patchItemOptionalParams = new PatchItemOptionalParams.Builder().build();
            }
            if (patchItemOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (patchItemOptionalParams.getAccessToken() == null) {
                patchItemOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return itemsApi.patchItem(projectId, itemId, modifyItemPayload, patchItemOptionalParams.getXUserId(),
                    patchItemOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

    /**
     * Update a Version
     * Updates the properties of the specified version of an item. Currently, you
     * can only change the name of the version.
     * 
     * **Note:** This operation is not supported for BIM 360 and ACC. If you want to
     * rename a version, create a new version with a new name.
     * 
     * @param projectId            The unique identifier of a project. For BIM 360
     *                             Docs and ACC Docs, a hub ID corresponds to an
     *                             Account ID. To convert a BIM 360 or ACC Account
     *                             ID to a hub ID, prefix the Account ID with
     *                             &#x60;&#x60;b.&#x60;&#x60;. For example, an
     *                             Account ID of
     *                             &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                             translates to a hub ID of
     *                             &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                             Similarly, to convert an ACC or BIM 360 project
     *                             ID to a Data Management project ID prefix the ACC
     *                             or BIM 360 project ID with
     *                             &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                             project ID of
     *                             &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60; translates
     *                             to a project ID of
     *                             &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                             (required)
     * @param versionId            The URL encoded unique identifier of a version.
     *                             (required)
     * @param modifyVersionPayload (required)
     * @return Version
     * @throws DataManagementApiException when an API call fails.
     */

    public Version patchVersion(String projectId, String versionId, ModifyVersionPayload modifyVersionPayload)
            throws DataManagementApiException {
        return patchVersion(projectId, versionId, modifyVersionPayload, null);
    }

    /**
     * Update a Version
     * Updates the properties of the specified version of an item. Currently, you
     * can only change the name of the version.
     * 
     * **Note:** This operation is not supported for BIM 360 and ACC. If you want to
     * rename a version, create a new version with a new name.
     * 
     * @param projectId                 The unique identifier of a project. For BIM
     *                                  360 Docs and ACC Docs, a hub ID corresponds
     *                                  to an Account ID. To convert a BIM 360 or
     *                                  ACC Account ID to a hub ID, prefix the
     *                                  Account ID with &#x60;&#x60;b.&#x60;&#x60;.
     *                                  For example, an Account ID of
     *                                  &#x60;&#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;&#x60;
     *                                  translates to a hub ID of
     *                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                  Similarly, to convert an ACC or BIM 360
     *                                  project ID to a Data Management project ID
     *                                  prefix the ACC or BIM 360 project ID with
     *                                  &#x60;&#x60;b.&#x60;&#x60;. For example, a
     *                                  project ID of
     *                                  &#x60;&#x60;c8b0c73d-3ae9&#x60;&#x60;
     *                                  translates to a project ID of
     *                                  &#x60;&#x60;b.c8b0c73d-3ae9&#x60;&#x60;.
     *                                  (required)
     * @param versionId                 The URL encoded unique identifier of a
     *                                  version. (required)
     * @param modifyVersionPayload      (required)
     * @param patchVersionOptionalParams class containing all optional parameters for
     *                                  the patchVersion method.
     * @return Version
     * @throws DataManagementApiException when an API call fails.
     */

    public Version patchVersion(String projectId, String versionId, ModifyVersionPayload modifyVersionPayload,
            PatchVersionOptionalParams patchVersionOptionalParams) throws DataManagementApiException {
        try {
            if (patchVersionOptionalParams == null) {
                patchVersionOptionalParams = new PatchVersionOptionalParams.Builder().build();
            }
            if (patchVersionOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new DataManagementApiException("Please provide a valid access token!");
            } else if (patchVersionOptionalParams.getAccessToken() == null) {
                patchVersionOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
            }
            return versionsApi.patchVersion(projectId, versionId, modifyVersionPayload,
                    patchVersionOptionalParams.getAccessToken()).getData();
        } catch (DataManagementApiException e) {
            throw e;
        } catch (Exception e) {
            throw new DataManagementApiException(e);
        }
    }

}