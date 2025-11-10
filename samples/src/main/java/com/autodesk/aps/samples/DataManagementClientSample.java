package com.autodesk.aps.samples;

import java.util.ArrayList;
import java.util.List;

import com.autodesk.aps.datamanagement.DataManagementClient;
import com.autodesk.aps.datamanagement.model.*;
import com.autodesk.aps.sdkmanager.StaticAuthenticationProvider;

import io.github.cdimascio.dotenv.Dotenv;

public class DataManagementClientSample {
    public static DataManagementClient client;

    Dotenv dotenv = Dotenv.load();

    String accessToken = dotenv.get("ACCESS_TOKEN");
    String hubId = dotenv.get("HUB_ID");
    String projectId = dotenv.get("PROJECT_ID");
    String downloadId = "";
    String jobId = dotenv.get("JOB_ID");
    String folderId = dotenv.get("FOLDER_ID");
    String itemId = dotenv.get("ITEM_ID");
    String versionId = dotenv.get("VERSION_ID");
    String xUserId = dotenv.get("X_USER_ID");

    void Initialize() {
        StaticAuthenticationProvider staticAuthenticationProvider = new StaticAuthenticationProvider(accessToken);
        client = new DataManagementClient(staticAuthenticationProvider);
    }

    // Hubs

    public void listHubs() {
        try {
            GetHubsOptionalParams params = new GetHubsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterId(java.util.Arrays.asList(hubId))
                    .filterName(java.util.Arrays.asList("aps-sdk-japan", "aps-sdk-india"))
                    .filterExtensionType(java.util.Arrays.asList("hubs:autodesk.bim360:Account"))
                    // .accessToken("Your access token here")
                    .build();

            Hubs hubs = client.getHubs(params);
            for (HubData hub : hubs.getData()) {
                System.out.println("Hub ID: " + hub.getId());
                System.out.println("Hub Name: " + hub.getAttributes().getName());
                System.out.println("Hub Extension Type: " + hub.getAttributes().getExtension().getType());
            }
        } catch (Exception e) {
            System.err.println("Error listing hubs: " + e.getMessage());
        }
    }

    public void getHub() {
        try {
            GetHubOptionalParams params = new GetHubOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Hub hub = client.getHub(hubId, params);
            System.out.println("Hub ID: " + hub.getData().getId());
            System.out.println("Hub Name: " + hub.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting hub: " + e.getMessage());
        }
    }

    // Projects

    public void listProjects() {
        try {
            GetHubProjectsOptionalParams params = new GetHubProjectsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterId(java.util.Arrays.asList(projectId))
                    .filterExtensionType(java.util.Arrays.asList("projects:autodesk.bim360:Project"))
                    .pageNumber(0)
                    .pageLimit(2)
                    // .accessToken("Your access token here")
                    .build();

            Projects projects = client.getHubProjects(hubId, params);
            for (ProjectData project : projects.getData()) {
                System.out.println("Project ID: " + project.getId());
                System.out.println("Project Name: " + project.getAttributes().getName());
                System.out.println("Project Extension Type: " + project.getAttributes().getExtension().getType());
            }
        } catch (Exception e) {
            System.err.println("Error listing projects: " + e.getMessage());
        }
    }

    public void getProject() {
        try {
            GetProjectOptionalParams params = new GetProjectOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Project project = client.getProject(hubId, projectId, params);
            System.out.println("Project ID: " + project.getData().getId());
            System.out.println("Project Name: " +
                    project.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting project: " + e.getMessage());
        }
    }

    public void getProjectHub() {
        try {
            GetProjectHubOptionalParams params = new GetProjectHubOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Hub hub = client.getProjectHub(hubId, projectId, params);
            System.out.println("Hub ID: " + hub.getData().getId());
            System.out.println("Hub Name: " + hub.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting project hub: " + e.getMessage());
        }
    }

    public void listTopFolders() {
        try {
            GetProjectTopFoldersOptionalParams params = new GetProjectTopFoldersOptionalParams.Builder()
                    .xUserId(xUserId)
                    .excludeDeleted(true)
                    .projectFilesOnly(true)
                    // .accessToken("Your access token here")
                    .build();

            TopFolders folders = client.getProjectTopFolders(hubId, projectId, params);
            for (TopFolderData folder : folders.getData()) {
                System.out.println("Folder ID: " + folder.getId());
                System.out.println("Folder Name: " + folder.getAttributes().getName());
            }
        } catch (Exception e) {
            System.err.println("Error listing top folders: " + e.getMessage());
        }
    }

    public void getDownload() {
        try {
            GetDownloadOptionalParams params = new GetDownloadOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Download download = client.getDownload(projectId, downloadId, params);
            System.out.println("Download ID: " + download.getData().getId());
        } catch (Exception e) {
            System.err.println("Error getting download: " + e.getMessage());
        }
    }

    public void getDownloadJob() {
        try {
            GetDownloadJobOptionalParams params = new GetDownloadJobOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Job downloadJob = client.getDownloadJob(projectId, jobId, params);
            System.out.println("Download Job ID: " + downloadJob.getData().getId());
        } catch (Exception e) {
            System.err.println("Error getting download job: " + e.getMessage());
        }
    }

    public void createDownload() {
        try {
            DownloadPayload payload = new DownloadPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            DownloadPayloadData data = new DownloadPayloadData();
            data.setType(TypeDownloads.DOWNLOADS);

            DownloadPayloadDataAttributes attributes = new DownloadPayloadDataAttributes();
            DownloadPayloadDataAttributesFormat format = new DownloadPayloadDataAttributesFormat();
            format.setFileType("dwg");
            data.setAttributes(attributes);

            DownloadPayloadDataRelationships relationships = new DownloadPayloadDataRelationships();
            DownloadPayloadDataRelationshipsSource source = new DownloadPayloadDataRelationshipsSource();
            DownloadPayloadDataRelationshipsSourceData sourceData = new DownloadPayloadDataRelationshipsSourceData();
            sourceData.setType(TypeVersion.VERSIONS);
            sourceData.setId("urn:adsk.wipprod:fs.version:co.NvC2t9dgSTqmw0zGQWTpXA");
            source.setData(sourceData);
            relationships.setSource(source);
            data.setRelationships(relationships);

            payload.setData(data);

            CreatedDownload download = client.createDownload(projectId, payload);
            for (CreatedDownloadData downloadData : download.getData()) {
                System.out.println("Download ID: " + downloadData.getId());
                System.out.println("Download Type: " + downloadData.getType());
            }
        } catch (Exception e) {
            System.err.println("Error creating download: " + e.getMessage());
        }
    }

    public void createStorage() {
        try {
            StoragePayload payload = new StoragePayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            StoragePayloadData data = new StoragePayloadData();
            data.setType(TypeObject.OBJECTS);
            StoragePayloadDataAttributes attributes = new StoragePayloadDataAttributes();
            attributes.setName("New Java SDK Test");
            data.setAttributes(attributes);

            StoragePayloadDataRelationships relationships = new StoragePayloadDataRelationships();
            StoragePayloadDataRelationshipsTarget target = new StoragePayloadDataRelationshipsTarget();
            StoragePayloadDataRelationshipsTargetData targetData = new StoragePayloadDataRelationshipsTargetData();
            targetData.setType(TypeFolderItemsForStorage.FOLDERS);
            targetData.setId("urn:adsk.wipprod:fs.folder:co.NvC2t9dgSTqmw0zGQWTpXA");
            target.setData(targetData);
            relationships.setTarget(target);
            data.setRelationships(relationships);

            payload.setData(data);
            Storage storage = client.createStorage(projectId, payload);
            System.out.println("Created Storage ID: " + storage.getData().getId());
            System.out.println("Storage Name: " +
                    storage.getData().getType());
        } catch (Exception e) {
            System.err.println("Error creating storage: " + e.getMessage());
        }
    }

    // Folders

    public void getFolder() {
        try {
            GetFolderOptionalParams params = new GetFolderOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .ifModifiedSince(null)
                    // .accessToken("Your access token here")
                    .build();

            Folder folder = client.getFolder(projectId, folderId, params);
            System.out.println("Folder ID: " + folder.getData().getId());
            System.out.println("Folder Name: " +
                    folder.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting folder: " + e.getMessage());
        }
    }

    public void getFolderContents() {
        try {
            GetFolderContentsOptionalParams params = new GetFolderContentsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterType.FOLDERS, FilterType.ITEMS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterExtensionType(
                            java.util.Arrays.asList("folders:autodesk.bim360:Folder", "items:autodesk.bim360:Item"))
                    .filterLastModifiedTimeRollup(java.util.Arrays.asList("2025-06-17T13:39:41.0000000Z"))
                    .pageNumber(0)
                    .pageLimit(1)
                    .includeHidden(true)
                    // .accessToken("Your access token here")
                    .build();

            FolderContents contents = client.getFolderContents(projectId, folderId, params);
            List<FolderContentsData> folderContents = contents.getData();
            for (FolderContentsData data : folderContents) {
                if (data instanceof FolderData) {
                    FolderData folder = (FolderData) data;
                    System.out.println("Folder Type: " + folder.getType());
                    System.out.println("Folder ID: " + folder.getId());
                    System.out.println("Folder Name: " + folder.getAttributes().getName());
                    System.out.println("Folder Extension Type: " + folder.getAttributes().getExtension().getType());
                    System.out.println(
                            "Folder Last Modified Time Rollup: " + folder.getAttributes().getLastModifiedTimeRollup());
                } else if (data instanceof ItemData) {
                    ItemData item = (ItemData) data;
                    System.out.println("Item Type: " + item.getType());
                    System.out.println("Item ID: " + item.getId());
                    System.out.println("Item Name: " + item.getAttributes().getDisplayName());
                }
            }
        } catch (Exception e) {
            System.err.println("Error getting folder contents: " + e.getMessage());
        }
    }

    public void getFolderParent() {
        try {
            GetFolderParentOptionalParams params = new GetFolderParentOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Folder parent = client.getFolderParent(projectId, folderId, params);
            System.out.println("Parent Folder ID: " + parent.getData().getId());
            System.out.println("Parent Folder Name: " +
                    parent.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting folder parent: " + e.getMessage());
        }
    }

    public void getFolderRefs() {
        try {
            GetFolderRefsOptionalParams params = new GetFolderRefsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterTypeVersion.FOLDERS, FilterTypeVersion.ITEMS,
                            FilterTypeVersion.VERSIONS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterExtensionType(java.util.Arrays.asList("folders:autodesk.bim360:Folder",
                            "items:autodesk.bim360:Item", "versions:autodesk.bim360:Version"))
                    // .accessToken("Your access token here")
                    .build();

            FolderRefs refs = client.getFolderRefs(projectId, folderId, params);
            System.out.println("Folder Refs: " + refs);
        } catch (Exception e) {
            System.err.println("Error getting folder refs: " + e.getMessage());
        }
    }

    public void getFolderRelationshipsLinks() {
        try {
            GetFolderRelationshipsLinksOptionalParams params = new GetFolderRelationshipsLinksOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            RelationshipLinks links = client.getFolderRelationshipsLinks(projectId, folderId, params);
            System.out.println("Folder Relationships Links: " + links);
        } catch (Exception e) {
            System.err.println("Error getting folder relationships links: " + e.getMessage());
        }
    }

    public void getFolderRelationshipsRefs() {
        try {
            GetFolderRelationshipsRefsOptionalParams params = new GetFolderRelationshipsRefsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterTypeVersion.FOLDERS, FilterTypeVersion.ITEMS,
                            FilterTypeVersion.VERSIONS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterRefType(FilterRefType.XREFS)
                    .filterDirection(FilterDirection.FROM)
                    .filterExtensionType(java.util.Arrays.asList("xrefs:my.custom:Xref",
                            "items:autodesk.bim360:Item", "versions:autodesk.bim360:Version"))
                    // .accessToken("Your access token here")
                    .build();

            RelationshipRefs refs = client.getFolderRelationshipsRefs(projectId, folderId, params);
            System.out.println("Folder Relationships Refs: " + refs);
        } catch (Exception e) {
            System.err.println("Error getting folder relationships refs: " + e.getMessage());
        }
    }

    public void getFolderSearch() {
        try {
            // Create a list of filters
            List<GetFolderSearchOptionalParams.Filter> filters = new ArrayList<>();
            filters.add(new GetFolderSearchOptionalParams.Filter("attributes.displayName", ComparisonTypes.EQUAL_TO,
                    java.util.Arrays.asList("sample.txt")));

            GetFolderSearchOptionalParams params = new GetFolderSearchOptionalParams.Builder()
                    // .filters(filters)
                    .pageNumber(0)
                    // .accessToken("Your access token here")
                    .build();

            Search search = client.getFolderSearch(projectId, folderId, params);
            System.out.println("Folder Search: " + search);
        } catch (Exception e) {
            System.err.println("Error getting folder search: " + e.getMessage());
        }
    }

    public void createFolder() {
        try {
            FolderPayload payload = new FolderPayload();

            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);

            FolderPayloadData data = new FolderPayloadData();
            data.setType(TypeFolder.FOLDERS);

            FolderPayloadDataAttributes attributes = new FolderPayloadDataAttributes();
            attributes.setName("New Java SDK Test");

            FolderPayloadDataAttributesExtension extension = new FolderPayloadDataAttributesExtension();
            extension.setType("folders:autodesk.bim360:Folder");
            extension.setVersion("1.0");
            ;

            attributes.setExtension(extension);
            data.setAttributes(attributes);

            FolderPayloadDataRelationships relationships = new FolderPayloadDataRelationships();
            FolderPayloadDataRelationshipsParent parent = new FolderPayloadDataRelationshipsParent();

            FolderPayloadDataRelationshipsParentData parentData = new FolderPayloadDataRelationshipsParentData();
            parentData.setType(TypeFolder.FOLDERS);
            parentData.setId("urn:adsk.wipprod:fs.folder:co.NvC2t9dgSTqmw0zGQWTpXA");

            parent.setData(parentData);
            relationships.setParent(parent);
            data.setRelationships(relationships);
            payload.setJsonapi(version);
            payload.setData(data);

            System.out.println("Payload: " + payload);

            Folder createdFolder = client.createFolder(projectId, payload);
            System.out.println("Created Folder ID: " + createdFolder.getData().getId());
            System.out.println("Created Folder Name: " +
                    createdFolder.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error creating folder: " + e.getMessage());
        }
    }

    public void createFolderRelationshipsRef() {
        try {
            RelationshipRefsPayload payload = new RelationshipRefsPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);

            RelationshipRefsPayloadData data = new RelationshipRefsPayloadData();
            data.setType(TypeEntity.FOLDERS);
            data.setId(folderId);

            RelationshipRefsPayloadDataMeta meta = new RelationshipRefsPayloadDataMeta();
            BaseAttributesExtensionObjectWithoutSchemaLink extension = new BaseAttributesExtensionObjectWithoutSchemaLink();
            extension.setType("folders:autodesk.bim360:Folder");
            extension.setVersion("1.0");
            meta.setExtension(extension);
            data.setMeta(meta);

            payload.setJsonapi(version);
            payload.setData(data);

            client.createFolderRelationshipsRef(folderId, projectId, payload);

            System.out.println("Folder Relationships Ref: " + payload);
        } catch (Exception e) {
            System.err.println("Error creating folder relationships ref: " + e.getMessage());
        }
    }

    public void patchFolder() {
        try {
            ModifyFolderPayload payload = new ModifyFolderPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            ModifyFolderPayloadData data = new ModifyFolderPayloadData();
            data.setType(TypeFolder.FOLDERS);
            data.setId(folderId);
            ModifyFolderPayloadDataAttributes attributes = new ModifyFolderPayloadDataAttributes();
            attributes.setName("newName");
            data.setAttributes(attributes);
            payload.setData(data);

            Folder updatedFolder = client.patchFolder(projectId, folderId,
                    payload);
            System.out.println("Updated Folder ID: " + updatedFolder.getData().getId());
            System.out.println("Updated Folder Name: " +
                    updatedFolder.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error updating folder: " + e.getMessage());
        }
    }

    // Items

    public void getItem() {
        try {
            GetItemOptionalParams params = new GetItemOptionalParams.Builder()
                    .xUserId(xUserId)
                    .includePathInProject(true)
                    // .accessToken("Your access token here")
                    .build();

            Item item = client.getItem(projectId, itemId, params);
            System.out.println("Item ID: " + item.getData().getId());
            System.out.println("Item Name: " +
                    item.getData().getAttributes().getDisplayName());
        } catch (Exception e) {
            System.err.println("Error getting item: " + e.getMessage());
        }
    }

    public void getItemParentFolder() {
        try {
            GetItemParentFolderOptionalParams params = new GetItemParentFolderOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Folder parent = client.getItemParentFolder(projectId, itemId, params);
            System.out.println("Parent Folder ID: " + parent.getData().getId());
            System.out.println("Parent Folder Name: " +
                    parent.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting item parent folder: " + e.getMessage());
        }
    }

    public void getItemRefs() {
        try {
            GetItemRefsOptionalParams params = new GetItemRefsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterTypeVersion.FOLDERS, FilterTypeVersion.ITEMS,
                            FilterTypeVersion.VERSIONS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterExtensionType(
                            java.util.Arrays.asList("items:autodesk.bim360:Item", "versions:autodesk.bim360:Version"))
                    // .accessToken("Your access token here")
                    .build();

            Refs refs = client.getItemRefs(projectId, itemId, params);
            System.out.println("Item Refs: " + refs);
        } catch (Exception e) {
            System.err.println("Error getting item refs: " + e.getMessage());
        }
    }

    public void getItemRelationshipsLinks() {
        try {
            GetItemRelationshipsLinksOptionalParams params = new GetItemRelationshipsLinksOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            RelationshipLinks links = client.getItemRelationshipsLinks(projectId, itemId, params);
            System.out.println("Item Relationships Links: " + links);
        } catch (Exception e) {
            System.err.println("Error getting item relationships links: " + e.getMessage());
        }
    }

    public void getItemRelationshipsRefs() {
        try {
            GetItemRelationshipsRefsOptionalParams params = new GetItemRelationshipsRefsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterTypeVersion.FOLDERS, FilterTypeVersion.ITEMS,
                            FilterTypeVersion.VERSIONS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterRefType(FilterRefType.XREFS)
                    .filterDirection(FilterDirection.FROM)
                    .filterExtensionType(java.util.Arrays.asList("xrefs:my.custom:Xref",
                            "items:autodesk.bim360:Item", "versions:autodesk.bim360:Version"))
                    // .accessToken("Your access token here")
                    .build();

            RelationshipRefs refs = client.getItemRelationshipsRefs(projectId, itemId, params);
            System.out.println("Item Relationships Refs: " + refs);
        } catch (Exception e) {
            System.err.println("Error getting item relationships refs: " + e.getMessage());
        }
    }

    public void getItemTip() {
        try {
            GetItemTipOptionalParams params = new GetItemTipOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            ItemTip tip = client.getItemTip(projectId, itemId);
            System.out.println("Item Tip Id: " + tip.getData().getId());
            System.out.println("Item Tip Type: " + tip.getData().getType());
        } catch (Exception e) {
            System.err.println("Error getting item tip: " + e.getMessage());
        }
    }

    public void getItemVersions() {
        try {
            GetItemVersionsOptionalParams params = new GetItemVersionsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterId(java.util.Arrays.asList(itemId))
                    .filterExtensionType(java.util.Arrays.asList("versions:autodesk.bim360:File"))
                    .filterVersionNumber(java.util.Arrays.asList(5, 3))
                    .pageNumber(0)
                    .pageLimit(1)
                    // .accessToken("Your access token here")
                    .build();

            Versions versions = client.getItemVersions(projectId, itemId, params);
            for (VersionData version : versions.getData()) {
                System.out.println("Version ID: " + version.getId());
                System.out.println("Version Type: " + version.getType());
                System.out.println("Version Number: " + version.getAttributes().getVersionNumber());
                System.out.println("Version Extension Type: " + version.getAttributes().getExtension().getType());
            }
        } catch (Exception e) {
            System.err.println("Error getting item versions: " + e.getMessage());
        }
    }

    public void createItem() {
        try {
            ItemPayload payload = new ItemPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            ItemPayloadData data = new ItemPayloadData();
            data.setType(TypeItem.ITEMS);

            ItemPayloadDataAttributes attributes = new ItemPayloadDataAttributes();
            attributes.setDisplayName("fileName");
            ItemPayloadDataAttributesExtension extension = new ItemPayloadDataAttributesExtension();
            extension.setType("items:autodesk.bim360:Item");
            extension.setVersion("1.0");
            attributes.setExtension(extension);
            data.setAttributes(attributes);

            ItemPayloadDataRelationships relationships = new ItemPayloadDataRelationships();
            ItemPayloadDataRelationshipsTip tip = new ItemPayloadDataRelationshipsTip();
            ItemPayloadDataRelationshipsTipData tipData = new ItemPayloadDataRelationshipsTipData();
            tipData.setId("1");
            tipData.setType(TypeVersion.VERSIONS);
            tip.setData(tipData);
            relationships.setTip(tip);

            ItemPayloadDataRelationshipsParent parent = new ItemPayloadDataRelationshipsParent();
            ItemPayloadDataRelationshipsParentData parentData = new ItemPayloadDataRelationshipsParentData();
            parentData.setId("urn:adsk.wipprod:fs.folder:co.NvC2t9dgSTqmw0zGQWTpXA");
            parentData.setType(TypeFolder.FOLDERS);
            parent.setData(parentData);
            relationships.setParent(parent);

            data.setRelationships(relationships);
            payload.setData(data);

            ItemPayloadIncluded included = new ItemPayloadIncluded();
            included.setType(TypeVersion.VERSIONS);
            included.setId("1");

            ItemPayloadIncludedAttributes attributesIncluded = new ItemPayloadIncludedAttributes();
            attributesIncluded.setName("drawing.dwg");
            ItemPayloadIncludedAttributesExtension extensionIncluded = new ItemPayloadIncludedAttributesExtension();
            extensionIncluded.setType("versions:autodesk.core:File");
            extensionIncluded.setVersion("1.0");
            attributesIncluded.setExtension(extensionIncluded);
            included.setAttributes(attributesIncluded);

            ItemPayloadIncludedRelationships relationshipsIncluded = new ItemPayloadIncludedRelationships();
            ItemPayloadIncludedRelationshipsStorage storage = new ItemPayloadIncludedRelationshipsStorage();
            ItemPayloadIncludedRelationshipsStorageData storageData = new ItemPayloadIncludedRelationshipsStorageData();
            storageData.setType(TypeObject.OBJECTS);
            storageData.setId("urn:adsk.objects:os.object:wip.dm.prod/2a6d61f2-49df-4d7b-9aed-439586d61df7.dwg");
            storage.setData(storageData);
            relationshipsIncluded.setStorage(storage);
            included.setRelationships(relationshipsIncluded);

            // Add to included list
            List<ItemPayloadIncluded> includedSet = new ArrayList<>();
            includedSet.add(included);
            payload.setIncluded(includedSet);

            CreatedItem item = client.createItem(projectId, payload);
            System.out.println("Created Item ID: " + item.getData().getId());
            System.out.println("Created Item Name: " +
                    item.getData().getAttributes().getDisplayName());
        } catch (Exception e) {
            System.err.println("Error creating item: " + e.getMessage());
        }
    }

    public void createItemRelationshipsRef() {
        try {
            RelationshipRefsPayload payload = new RelationshipRefsPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);

            RelationshipRefsPayloadData data = new RelationshipRefsPayloadData();
            data.setType(TypeEntity.VERSIONS);
            data.setId("urn:adsk.wipprod:fs.file:vf.ooWjwAQJR0uEoPRyfEnvew?version=1");

            RelationshipRefsPayloadDataMeta meta = new RelationshipRefsPayloadDataMeta();
            BaseAttributesExtensionObjectWithoutSchemaLink extension = new BaseAttributesExtensionObjectWithoutSchemaLink();
            extension.setType("auxiliary:autodesk.core:Attachment");
            extension.setVersion("1.0");
            meta.setExtension(extension);
            data.setMeta(meta);

            payload.setJsonapi(version);
            payload.setData(data);

            client.createItemRelationshipsRef(projectId, itemId, payload);

            System.out.println("Item Relationships Ref: " + payload);
        } catch (Exception e) {
            System.err.println("Error creating item relationships ref: " + e.getMessage());
        }
    }

    public void patchItem() {
        try {
            ModifyItemPayload payload = new ModifyItemPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            ModifyItemPayloadData data = new ModifyItemPayloadData();
            data.setType(TypeItem.ITEMS);
            data.setId(itemId);
            ModifyItemPayloadDataAttributes attributes = new ModifyItemPayloadDataAttributes();
            attributes.setDisplayName("newName");
            data.setAttributes(attributes);
            payload.setData(data);

            Item updatedItem = client.patchItem(projectId, itemId, payload);
            System.out.println("Updated Item ID: " + updatedItem.getData().getId());
            System.out.println("Updated Item Name: " +
                    updatedItem.getData().getAttributes().getDisplayName());
        } catch (Exception e) {
            System.err.println("Error updating item: " + e.getMessage());
        }
    }

    // Versions

    public void getVersion() {
        try {
            GetVersionOptionalParams params = new GetVersionOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Version version = client.getVersion(projectId, versionId, params);
            System.out.println("Version ID: " + version.getData().getId());
            System.out.println("Version Name: " +
                    version.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error getting version: " + e.getMessage());
        }
    }

    public void getVersionDownloadFormats() {
        try {
            GetVersionDownloadFormatsOptionalParams params = new GetVersionDownloadFormatsOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            DownloadFormats formats = client.getVersionDownloadFormats(projectId,
                    versionId, params);
            DownloadFormatsData data = formats.getData();
            System.out.println("Download Formats: " + data);
        } catch (Exception e) {
            System.err.println("Error getting version download formats: " +
                    e.getMessage());
        }
    }

    public void getVersionDownloads() {
        try {
            GetVersionDownloadsOptionalParams params = new GetVersionDownloadsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterFormatFileType(java.util.Arrays.asList("dwg", "pdf"))
                    // .accessToken("Your access token here")
                    .build();

            Downloads downloads = client.getVersionDownloads(projectId, versionId, params);
            System.out.println("Version Downloads: " + downloads);
        } catch (Exception e) {
            System.err.println("Error getting version downloads: " + e.getMessage());
        }
    }

    public void getVersionItem() {
        try {
            GetVersionItemOptionalParams params = new GetVersionItemOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            Item item = client.getVersionItem(projectId, versionId, params);
            System.out.println("Version Item: " + item);
        } catch (Exception e) {
            System.err.println("Error getting version item: " + e.getMessage());
        }
    }

    public void getVersionRefs() {
        try {
            GetVersionRefsOptionalParams params = new GetVersionRefsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterTypeVersion.FOLDERS, FilterTypeVersion.ITEMS,
                            FilterTypeVersion.VERSIONS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterExtensionType(java.util.Arrays.asList("items:autodesk.bim360:Item",
                            "versions:autodesk.bim360:Version"))
                    // .accessToken("Your access token here")
                    .build();

            Refs refs = client.getVersionRefs(projectId, versionId, params);
            System.out.println("Version Refs: " + refs);
        } catch (Exception e) {
            System.err.println("Error getting version refs: " + e.getMessage());
        }
    }

    public void getVersionRelationshipsLinks() {
        try {
            GetVersionRelationshipsLinksOptionalParams params = new GetVersionRelationshipsLinksOptionalParams.Builder()
                    .xUserId(xUserId)
                    // .accessToken("Your access token here")
                    .build();

            RelationshipLinks links = client.getVersionRelationshipsLinks(projectId, versionId, params);
            System.out.println("Version Relationships Links: " + links);
        } catch (Exception e) {
            System.err.println("Error getting version relationships links: " + e.getMessage());
        }
    }

    public void getVersionRelationshipsRefs() {
        try {
            GetVersionRelationshipsRefsOptionalParams params = new GetVersionRelationshipsRefsOptionalParams.Builder()
                    .xUserId(xUserId)
                    .filterType(java.util.Arrays.asList(FilterTypeVersion.FOLDERS, FilterTypeVersion.ITEMS,
                            FilterTypeVersion.VERSIONS))
                    .filterId(java.util.Arrays.asList(folderId))
                    .filterRefType(FilterRefType.XREFS)
                    .filterDirection(FilterDirection.FROM)
                    .filterExtensionType(java.util.Arrays.asList("xrefs:my.custom:Xref",
                            "items:autodesk.bim360:Item", "versions:autodesk.bim360:Version"))
                    // .accessToken("Your access token here")
                    .build();

            RelationshipRefs refs = client.getVersionRelationshipsRefs(projectId, versionId, params);
            System.out.println("Version Relationships Refs: " + refs);
        } catch (Exception e) {
            System.err.println("Error getting version relationships refs: " + e.getMessage());
        }
    }

    public void createVersion() {
        try {
            VersionPayload payload = new VersionPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            VersionPayloadData data = new VersionPayloadData();
            data.setType(TypeVersion.VERSIONS);

            VersionPayloadDataAttributes attributes = new VersionPayloadDataAttributes();
            attributes.setName("fileName");
            VersionPayloadDataAttributesExtension extension = new VersionPayloadDataAttributesExtension();
            extension.setType("versions:autodesk.core:File");
            extension.setVersion("1.0");
            attributes.setExtension(extension);
            data.setAttributes(attributes);

            VersionPayloadDataRelationships relationships = new VersionPayloadDataRelationships();
            VersionPayloadDataRelationshipsItem item = new VersionPayloadDataRelationshipsItem();
            VersionPayloadDataRelationshipsItemData itemData = new VersionPayloadDataRelationshipsItemData();
            itemData.setId("itemId");
            itemData.setType(TypeItem.ITEMS);
            item.setData(itemData);
            relationships.setItem(item);

            VersionPayloadDataRelationshipsStorage storage = new VersionPayloadDataRelationshipsStorage();
            VersionPayloadDataRelationshipsStorageData storageData = new VersionPayloadDataRelationshipsStorageData();
            storageData.setType(TypeObject.OBJECTS);
            storageData.setId("urn:adsk.objects:os.object:wip.dm.prod/2a6d61f2-49df-4d7b-9aed-439586d61df7.dwg");
            storage.setData(storageData);
            relationships.setStorage(storage);

            data.setRelationships(relationships);
            payload.setData(data);

            CreatedVersion createdVersion = client.createVersion(projectId, payload);
            System.out.println("Created Version ID: " + createdVersion.getData().getId());
            System.out.println("Created Version Name: " +
                    createdVersion.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error creating version: " + e.getMessage());
        }
    }

    public void createVersionRelationshipsRef() {
        try {
            RelationshipRefsPayload payload = new RelationshipRefsPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);

            RelationshipRefsPayloadData data = new RelationshipRefsPayloadData();
            data.setType(TypeEntity.VERSIONS);
            data.setId("urn:adsk.wipprod:fs.file:vf.ooWjwAQJR0uEoPRyfEnvew?version=1");

            RelationshipRefsPayloadDataMeta meta = new RelationshipRefsPayloadDataMeta();
            BaseAttributesExtensionObjectWithoutSchemaLink extension = new BaseAttributesExtensionObjectWithoutSchemaLink();
            extension.setType("auxiliary:autodesk.core:Attachment");
            extension.setVersion("1.0");
            meta.setExtension(extension);
            data.setMeta(meta);

            payload.setJsonapi(version);
            payload.setData(data);

            client.createVersionRelationshipsRef(projectId, versionId, payload);

            System.out.println("Version Relationships Ref: " + payload);
        } catch (Exception e) {
            System.err.println("Error creating version relationships ref: " + e.getMessage());
        }

    }

    public void patchVersion() {
        try {
            ModifyVersionPayload payload = new ModifyVersionPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            ModifyVersionPayloadData data = new ModifyVersionPayloadData();
            data.setType(TypeVersion.VERSIONS);
            data.setId(versionId);
            ModifyVersionPayloadDataAttributes attributes = new ModifyVersionPayloadDataAttributes();
            attributes.setName("newName");
            data.setAttributes(attributes);
            payload.setData(data);

            Version updatedVersion = client.patchVersion(projectId, versionId,
                    payload);
            System.out.println("Updated Version ID: " +
                    updatedVersion.getData().getId());
            System.out.println("Updated Version Name: " +
                    updatedVersion.getData().getAttributes().getName());
        } catch (Exception e) {
            System.err.println("Error updating version: " + e.getMessage());
        }
    }

    // Commands

    public void executeCheckPermissionCommand() {
        try {
            CommandPayload payload = new CommandPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            CheckPermissionPayload data = new CheckPermissionPayload();
            data.setType(TypeCommands.COMMANDS);

            // Minimal attributes (expand as needed)
            CheckPermissionPayloadAttributes attributes = new CheckPermissionPayloadAttributes();
            data.setAttributes(attributes);

            CheckPermissionPayloadAttributesExtension extension = new CheckPermissionPayloadAttributesExtension();
            extension.setType(TypeCommandtypeCheckPermission.COMMANDS_AUTODESK_CORE_CHECKPERMISSION);
            extension.setVersion("1.0.0");
            attributes.setExtension(extension);

            CheckPermissionPayloadAttributesExtensionData dataExtension = new CheckPermissionPayloadAttributesExtensionData();
            List<String> requiredActions = new ArrayList<>(); // Create an empty list
            requiredActions.add("download");
            requiredActions.add("view");
            requiredActions.add("read");
            dataExtension.setRequiredActions(requiredActions);
            extension.setData(dataExtension);

            // Minimal relationships (expand as needed)
            CheckPermissionPayloadRelationships relationships = new CheckPermissionPayloadRelationships();
            CheckPermissionPayloadRelationshipsResources resources = new CheckPermissionPayloadRelationshipsResources();
            CheckPermissionPayloadRelationshipsResourcesData resourcesData = new CheckPermissionPayloadRelationshipsResourcesData();
            resourcesData.setType(TypeEntity.FOLDERS);
            resourcesData.setId("urn:adsk.wipprod:fs.folder:co.NvC2t9dgSTqmw0zGQWTpXA");

            List<CheckPermissionPayloadRelationshipsResourcesData> resourcesDataSet = new ArrayList<>();
            resourcesDataSet.add(resourcesData);
            resources.setData(resourcesDataSet);

            relationships.setResources(resources);
            data.setRelationships(relationships);

            payload.setData(data);
            Command command = client.executeCommand(projectId, payload);
            CommandData commandData = command.getData();
            CheckPermission checkPermission = (CheckPermission) commandData;
            System.out.println("Command Id: " + checkPermission.getId());
            System.out.println("Command Type: " + checkPermission.getType());
        } catch (Exception e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }

    public void executeListRefsCommand() {
        try {
            CommandPayload payload = new CommandPayload();
            JsonApiVersion version = new JsonApiVersion();
            version.setVersion(JsonApiVersionValue._1_0);
            payload.setJsonapi(version);

            ListRefsPayload data = new ListRefsPayload();
            data.setType(TypeCommands.COMMANDS);

            // Minimal attributes (expand as needed)
            ListRefsPayloadAttributes attributes = new ListRefsPayloadAttributes();
            data.setAttributes(attributes);

            ListRefsPayloadAttributesExtension extension = new ListRefsPayloadAttributesExtension();
            extension.setType(TypeCommandtypeListRefs.COMMANDS_AUTODESK_CORE_LISTREFS);
            extension.setVersion("1.0.0");
            attributes.setExtension(extension);

            // Minimal relationships (expand as needed)
            ListRefsPayloadRelationships relationships = new ListRefsPayloadRelationships();
            ListRefsPayloadRelationshipsResources resources = new ListRefsPayloadRelationshipsResources();
            ListRefsPayloadRelationshipsResourcesData resourcesData = new ListRefsPayloadRelationshipsResourcesData();
            resourcesData.setType(TypeVersion.VERSIONS);
            resourcesData.setId("urn:adsk.wipprod:fs.file:vf.DixLrxYDQv-rXovqKhFLWQ?version=3");

            List<ListRefsPayloadRelationshipsResourcesData> resourcesDataSet = new ArrayList<>();
            resourcesDataSet.add(resourcesData);
            resources.setData(resourcesDataSet);

            relationships.setResources(resources);
            data.setRelationships(relationships);

            payload.setData(data);
            Command command = client.executeCommand(projectId, payload);
            CommandData commandData = command.getData();
            ListRefs listRefs = (ListRefs) commandData;
            System.out.println("Command Id: " + listRefs.getId());
            System.out.println("Command Type: " + listRefs.getType());

            List<ListRefsIncluded> included = listRefs.getIncluded();
            for (ListRefsIncluded includedData : included) {
                System.out.println("Included Data: " + includedData);
            }

        } catch (Exception e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting DataManagementClientSample...");

        DataManagementClientSample sample = new DataManagementClientSample();
        sample.Initialize();

        // Hubs
        // sample.listHubs();
        // sample.getHub();

        // // Projects
        // sample.listProjects();
        // sample.getProject();
        // sample.getProjectHub();
        // sample.listTopFolders();
        // sample.getDownload();
        // sample.getDownloadJob();
        // sample.createDownload();
        // sample.createStorage();

        // // Folders
        // sample.getFolder();
        sample.getFolderContents();
        // sample.getFolderParent();
        // sample.getFolderRefs();
        // sample.getFolderRelationshipsLinks();
        // sample.getFolderRelationshipsRefs();
        // sample.getFolderSearch();
        // sample.createFolder();
        // sample.createFolderRelationshipsRef();
        // sample.patchFolder();

        // // Items
        // sample.getItem();
        // sample.getItemParentFolder();
        // sample.getItemRefs();
        // sample.getItemRelationshipsLinks();
        // sample.getItemRelationshipsRefs();
        // sample.getItemTip();
        // sample.getItemVersions();
        // sample.createItem();
        // sample.createItemRelationshipsRef();
        // sample.patchItem();

        // // Versions
        // sample.getVersion();
        // sample.getVersionDownloadFormats();
        // sample.getVersionDownloads();
        // sample.getVersionItem();
        // sample.getVersionRefs();
        // sample.getVersionRelationshipsLinks();
        // sample.getVersionRelationshipsRefs();
        // sample.createVersion();
        // sample.createVersionRelationshipsRef();
        // sample.patchVersion();

        // // Commands
        // sample.executeCheckPermissionCommand();
        // sample.executeListRefsCommand();
    }
}