package com.autodesk.aps.samples;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.autodesk.aps.modelderivative.ModelDerivativeClient;
import com.autodesk.aps.modelderivative.model.*;
import com.autodesk.aps.sdkmanager.StaticAuthenticationProvider;

import io.github.cdimascio.dotenv.Dotenv;

public class ModelDerivativeSample {
    public static ModelDerivativeClient client;

    Dotenv dotenv = Dotenv.load();

    String accessToken = dotenv.get("ACCESS_TOKEN");
    String designUrn = dotenv.get("DESIGN_URN");                                                                                                                                                                                                                                                    // URN
    String derivativeUrn = dotenv.get("DERIVATIVE_URN");
    String modelGuid = dotenv.get("MODEL_GUID");

    void Initialize() {
        StaticAuthenticationProvider staticAuthenticationProvider = new StaticAuthenticationProvider(accessToken);
        client = new ModelDerivativeClient(staticAuthenticationProvider);
    }

    // Jobs API - Translation and Job Management

    /**
     * Create a translation job to convert a source design to SVF2 format
     */
    public void createTranslationJob() {
        try {
            // Create input configuration
            JobPayloadInput input = new JobPayloadInput();
            input.setUrn(designUrn);

            // Create SVF2 output format
            JobPayloadFormatSVF2 svf2Format = new JobPayloadFormatSVF2();
            svf2Format.setType(OutputType.SVF2);

            // Set required views parameter - specify 2D and 3D views
            List<View> views = new ArrayList<>();
            views.add(View._2D);
            views.add(View._3D);
            svf2Format.setViews(views);

            List<JobPayloadFormat> formats = new ArrayList<>();
            formats.add(svf2Format);

            // Create output configuration
            JobPayloadOutput output = new JobPayloadOutput();
            output.setFormats(formats);

            // Create job payload
            JobPayload jobPayload = new JobPayload();
            jobPayload.setInput(input);
            jobPayload.setOutput(output);

            // Optional parameters
            StartJobOptionalParams params = new StartJobOptionalParams.Builder()
                    .xAdsForce(false)
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            Job job = client.startJob(jobPayload, params);
            System.out.println("Translation job created successfully");
            System.out.println("Job ID: " + job.getResult());
            System.out.println("Job URN: " + job.getUrn());
            if (job.getAcceptedJobs() != null) {
                System.out.println("Accepted jobs: " + job.getAcceptedJobs());
            }

        } catch (Exception e) {
            System.err.println("Error creating translation job: " + e.getMessage());
        }
    }

    /**
     * Create a translation job with thumbnail generation
     */
    public void createTranslationJobWithThumbnails() {
        try {
            // Create input configuration
            JobPayloadInput input = new JobPayloadInput();
            input.setUrn(designUrn);

            // Create SVF2 format
            JobPayloadFormatSVF2 svf2Format = new JobPayloadFormatSVF2();
            svf2Format.setType(OutputType.SVF2);

            // Set required views parameter - specify 2D and 3D views
            List<View> views = new ArrayList<>();
            views.add(View._2D);
            views.add(View._3D);
            svf2Format.setViews(views);

            // Create thumbnail format
            JobPayloadFormatThumbnail thumbnailFormat = new JobPayloadFormatThumbnail();
            thumbnailFormat.setType(OutputType.THUMBNAIL);

            // Set thumbnail advanced options
            JobPayloadFormatAdvancedThumbnail thumbnailAdvanced = new JobPayloadFormatAdvancedThumbnail();
            thumbnailAdvanced.setWidth(Width.NUMBER_400);
            thumbnailAdvanced.setHeight(Height.NUMBER_200);
            thumbnailFormat.setAdvanced(thumbnailAdvanced);

            List<JobPayloadFormat> formats = new ArrayList<>();
            formats.add(svf2Format);
            formats.add(thumbnailFormat);

            // Create output configuration
            JobPayloadOutput output = new JobPayloadOutput();
            output.setFormats(formats);

            // Create job payload
            JobPayload jobPayload = new JobPayload();
            jobPayload.setInput(input);
            jobPayload.setOutput(output);

            Job job = client.startJob(jobPayload);
            System.out.println("Translation job with thumbnails created successfully");
            System.out.println("Job ID: " + job.getResult());
            System.out.println("Job URN: " + job.getUrn());

        } catch (Exception e) {
            System.err.println("Error creating translation job with thumbnails: " + e.getMessage());
        }
    }

    /**
     * Specify references for a design (used when design has external file
     * dependencies)
     */
    public void specifyReferences() {
        try {
            SpecifyReferencesOptionalParams params = new SpecifyReferencesOptionalParams.Builder()
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            SpecifyReferencesPayload payload = new SpecifyReferencesPayload();
            payload.setUrn("urn");
            payload.setRegion(Region.US);
            payload.setFilename("file name");

            List<SpecifyReferencesPayloadReferences> references = new ArrayList<>();

            SpecifyReferencesPayloadReferences reference1 = new SpecifyReferencesPayloadReferences();
            reference1.setUrn("urn");
            reference1.setRelativePath("relative path");
            reference1.setFilename("file name");
            references.add(reference1);

            SpecifyReferences result = client.specifyReferences(designUrn, payload, params);
            System.out.println("References specified successfully");
            System.out.println("Result: " + result.getResult());
            System.out.println(
                    "Note: Use this when your design has external file dependencies that need to be resolved before translation");

        } catch (Exception e) {
            System.err.println("Error specifying references: " + e.getMessage());
        }
    }

    // Manifest API

    /**
     * Get the manifest for a translated design
     */
    public void getManifest() {
        try {
            GetManifestOptionalParams params = new GetManifestOptionalParams.Builder()
                    .acceptEncoding("application/json")
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            Manifest manifest = client.getManifest(designUrn, params);
            System.out.println("Manifest retrieved successfully");
            System.out.println("Type: " + manifest.getType());
            System.out.println("Version: " + manifest.getVersion());
            System.out.println("URN: " + manifest.getUrn());
            System.out.println("Progress: " + manifest.getProgress());
            System.out.println("Status: " + manifest.getStatus());
            System.out.println("DR: " + manifest.getDerivatives());

            if (manifest.getDerivatives() != null) {
                System.out.println("Number of derivatives: " + manifest.getDerivatives().size());
                for (ManifestDerivative derivative : manifest.getDerivatives()) {
                    System.out.println("- Derivative name: " + derivative.getName());
                    System.out.println("  Status: " + derivative.getStatus());
                    System.out.println("  Progress: " + derivative.getProgress());
                    if (derivative.getChildren() != null) {
                        System.out.println("  Children count: " + derivative.getChildren().size());
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Error getting manifest: " + e.getMessage());
        }
    }

    /**
     * Delete a manifest and all its derivatives
     */
    public void deleteManifest() {
        try {
            DeleteManifestOptionalParams params = new DeleteManifestOptionalParams.Builder()
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            DeleteManifest result = client.deleteManifest(designUrn, params);
            System.out.println("Manifest deleted successfully");
            System.out.println("Result: " + result.getResult());

        } catch (Exception e) {
            System.err.println("Error deleting manifest: " + e.getMessage());
        }
    }

    // Derivatives API

    /**
     * Get download URL for a derivative
     */
    public void getDerivativeDownloadUrl() {
        try {
            GetDerivativeUrlOptionalParams params = new GetDerivativeUrlOptionalParams.Builder()
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            DerivativeDownload download = client.getDerivativeUrl(derivativeUrn, designUrn, params);
            System.out.println("Derivative download URL retrieved successfully");
            System.out.println("URL: " + download.getUrl());

        } catch (Exception e) {
            System.err.println("Error getting derivative download URL: " + e.getMessage());
        }
    }

    /**
     * Check derivative details (HEAD request) - useful for getting content length
     * before download
     */
    public void headCheckDerivative() {
        try {
            HeadCheckDerivativeOptionalParams params = new HeadCheckDerivativeOptionalParams.Builder()
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            client.headCheckDerivative(designUrn, derivativeUrn, params);
            System.out.println("Derivative HEAD check completed successfully");
            System.out.println("Use this method to check derivative availability and get metadata before downloading");

        } catch (Exception e) {
            System.err.println("Error checking derivative: " + e.getMessage());
        }
    }

    // Metadata API

    /**
     * Get model views (viewables) for a design
     */
    public void getModelViews() {
        try {
            GetModelViewsOptionalParams params = new GetModelViewsOptionalParams.Builder()
                    .acceptEncoding("application/json")
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            ModelViews modelViews = client.getModelViews(designUrn, params);
            System.out.println("Model views retrieved successfully");

            if (modelViews.getData() != null && modelViews.getData().getMetadata() != null) {
                System.out.println("Number of metadata entries: " + modelViews.getData().getMetadata().size());
                modelViews.getData().getMetadata().forEach(metadata -> {
                    System.out.println("- Name: " + metadata.getName());
                    System.out.println("  GUID: " + metadata.getGuid());
                    System.out.println("  Role: " + metadata.getRole());
                });
            }

        } catch (Exception e) {
            System.err.println("Error getting model views: " + e.getMessage());
        }
    }

    /**
     * Get object tree for a specific model view
     */
    public void getObjectTree() {
        try {
            GetObjectTreeOptionalParams params = new GetObjectTreeOptionalParams.Builder()
                    .acceptEncoding("application/json")
                    .region(Region.US)
                    .forceget("false")
                    // .objectid(12345) // Optional: specify specific object ID
                    // .accessToken("your-access-token")
                    .build();

            ObjectTree objectTree = client.getObjectTree(designUrn, modelGuid, params);
            System.out.println("Object tree retrieved successfully");

            if (objectTree.getData() != null && objectTree.getData().getObjects() != null) {
                System.out.println("Number of objects: " + objectTree.getData().getObjects().size());
                objectTree.getData().getObjects().stream().limit(5).forEach(obj -> {
                    System.out.println("- Object ID: " + obj.getObjectid());
                    System.out.println("  Name: " + obj.getName());
                    // System.out.println(" Type: " + obj.getType()); // Type info if available
                });
                if (objectTree.getData().getObjects().size() > 5) {
                    System.out.println("... and " + (objectTree.getData().getObjects().size() - 5) + " more objects");
                }
            }

        } catch (Exception e) {
            System.err.println("Error getting object tree: " + e.getMessage());
        }
    }

    /**
     * Get all properties for objects in a model view
     */
    public void getAllProperties() {
        try {
            GetAllPropertiesOptionalParams params = new GetAllPropertiesOptionalParams.Builder()
                    .acceptEncoding("application/json")
                    .region(Region.US)
                    .forceget("false")
                    // .objectid(12345) // Optional: get properties for specific object
                    // .accessToken("your-access-token")
                    .build();

            Properties properties = client.getAllProperties(designUrn, modelGuid, params);
            System.out.println("All properties retrieved successfully");

            if (properties.getData() != null && properties.getData().getCollection() != null) {
                System.out.println("Number of property sets: " + properties.getData().getCollection().size());
                properties.getData().getCollection().stream().limit(3).forEach(collection -> {
                    System.out.println("- Object ID: " + collection.getObjectid());
                    System.out.println("  Name: " + collection.getName());
                    if (collection.getProperties() != null) {
                        System.out.println("  Number of properties: " + collection.getProperties().size());
                    }
                });
                if (properties.getData().getCollection().size() > 3) {
                    System.out.println(
                            "... and " + (properties.getData().getCollection().size() - 3) + " more property sets");
                }
            }

        } catch (Exception e) {
            System.err.println("Error getting all properties: " + e.getMessage());
        }
    }

    /**
     * Fetch specific properties for objects in a model view using a query
     */
    public void fetchSpecificProperties() {
        try {
            FetchSpecificPropertiesOptionalParams params = new FetchSpecificPropertiesOptionalParams.Builder()
                    .acceptEncoding("application/json")
                    .region(Region.US)
                    // .accessToken("your-access-token")
                    .build();

            SpecificPropertiesPayload payload = new SpecificPropertiesPayload();

            SpecificPropertiesPayloadPagination pagination = new SpecificPropertiesPayloadPagination();
            pagination.setOffset(new BigDecimal(0)); // Start from beginning
            pagination.setLimit(new BigDecimal(2)); // Return up to 100 objects
            payload.setPagination(pagination);

            // Create MatchId query - equivalent to .NET version
            // This matches the .NET pattern:
            // Query = new MatchId() { In = new List<object> { MatchIdType.ObjectId, 4088 }
            // }

            MatchId matchIdQuery = new MatchId();
            matchIdQuery.set$In(Arrays.asList(MatchIdType.OBJECTID, 4273, 3334, 1164));
            payload.setQuery(matchIdQuery);

            // Alternative examples:
            // 1. Match multiple object IDs:
            // matchIdQuery.set$In(Arrays.asList(MatchIdType.OBJECTID, 4088, 4089, 4090));

            // 2. Match by external ID:
            // matchIdQuery.set$In(Arrays.asList(MatchIdType.EXTERNALID, "doc_982afc8a",
            // "doc_afd75233"));

            // 3. Match single external ID:
            // matchIdQuery.set$In(Arrays.asList(MatchIdType.EXTERNALID,
            // "some-external-id"));

            List<String> fields = Arrays.asList(
                    "objectid",
                    "externalId");
            payload.setFields(fields);

            SpecificProperties specificProperties = client.fetchSpecificProperties(designUrn, modelGuid, payload, params);
            System.out.println("Specific properties retrieved successfully");
            System.out.println("Query executed - check the SpecificProperties object for results");
            System.out.println("Response type: " + specificProperties.getClass().getSimpleName());

            // Note: The exact structure depends on your query and the model
            // Access the data using the appropriate getters based on your model structure

        } catch (Exception e) {
            System.err.println("Error fetching specific properties: " + e.getMessage());
        }
    }

    // Thumbnails API

    /**
     * Get thumbnail for a design
     */
    public void getThumbnail() {
        try {
            // Get the thumbnail for the specified URN
            InputStream thumbnail = client.getThumbnail(designUrn);
            if (thumbnail != null) {
                System.out.println("Thumbnail retrieved successfully");

                System.out.println("InputStream is available and ready to use");
                // You can now read from the InputStream directly
                // For example: byte[] data = thumbnail.readAllBytes();
                System.out.println("InputStream available: " + thumbnail.available() + " bytes");
                System.out.println("Thumbnail data ready for use as InputStream");

                thumbnail.close(); // Don't forget to close the stream
            } else {
                System.out.println("No thumbnail available for the specified URN.");
            }
        } catch (Exception e) {
            // Check if thumbnail is still being generated
            if (e.getMessage().contains("The thumbnail generating for this graph node is pending")) {
                System.out.println("Thumbnail is still being generated. Please wait and try again later.");
                System.out.println(
                        "Tip: Generate thumbnails during translation by using createTranslationJobWithThumbnails()");
            } else {
                System.out.println("Error getting thumbnail: " + e.getMessage());
            }
        }
    }

    // Informational API

    /**
     * Get supported formats for translation
     */
    public void getSupportedFormats() {
        try {
            GetFormatsOptionalParams params = new GetFormatsOptionalParams.Builder()
                    .ifModifiedSince("Wed, 21 Oct 2015 07:28:00 GMT")
                    // .accessToken("your-access-token")
                    .build();

            SupportedFormats formats = client.getFormats(params);
            System.out.println("Supported formats retrieved successfully");
            if (formats.getFormats() != null) {
                System.out.println("Number of supported formats: " + formats.getFormats().size());
                formats.getFormats().forEach((key, value) -> {
                    System.out.println("- Target format: " + key);
                    System.out.println("  Supported source formats: " + value);
                });
            }

        } catch (Exception e) {
            System.err.println("Error getting supported formats: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting Model Derivative Client Sample...");

        ModelDerivativeSample sample = new ModelDerivativeSample();

        // Jobs - Translation
        sample.createTranslationJob();
        sample.createTranslationJobWithThumbnails();
        sample.specifyReferences();

        // Manifest
        sample.getManifest();
        sample.deleteManifest();

        // Derivatives
        sample.getDerivativeDownloadUrl();
        sample.headCheckDerivative();

        // Metadata API (requires design to be translated to SVF/SVF2 first)
        sample.getModelViews();
        sample.getObjectTree();
        sample.getAllProperties();
        sample.fetchSpecificProperties();

        // Thumbnails
        sample.getThumbnail();

        // Informational
        sample.getSupportedFormats();

        System.out.println("Sample execution completed.");
    }
}