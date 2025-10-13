package com.autodesk.aps.samples;

import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;

import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.StaticAuthenticationProvider;
import com.autodesk.aps.webhooks.WebhooksClient;
import com.autodesk.aps.webhooks.model.CreateSystemHookOptionalParams;
import com.autodesk.aps.webhooks.model.CreateTokenOptionalParams;
import com.autodesk.aps.webhooks.model.Events;
import com.autodesk.aps.webhooks.model.GetAppHooksOptionalParams;
import com.autodesk.aps.webhooks.model.GetHooksOptionalParams;
import com.autodesk.aps.webhooks.model.Hook;
import com.autodesk.aps.webhooks.model.HookDetails;
import com.autodesk.aps.webhooks.model.HookPayload;
import com.autodesk.aps.webhooks.model.Hooks;
import com.autodesk.aps.webhooks.model.Region;
import com.autodesk.aps.webhooks.model.Sort;
import com.autodesk.aps.webhooks.model.StatusFilter;
import com.autodesk.aps.webhooks.model.Systems;
import com.autodesk.aps.webhooks.model.Token;
import com.autodesk.aps.webhooks.model.TokenPayload;

import io.github.cdimascio.dotenv.Dotenv;

public class WebhooksSample {
    public static WebhooksClient webhooksClient;
    Dotenv dotenv = Dotenv.load();
    String accessToken = dotenv.get("ACCESS_TOKEN");
    String folderId = dotenv.get("FOLDER_ID");
    void Initialize() {
        StaticAuthenticationProvider staticAuthenticationProvider = new StaticAuthenticationProvider(accessToken);
        webhooksClient = new WebhooksClient(staticAuthenticationProvider);
    }

    void getHooks() {
        try {
            GetHooksOptionalParams params = new GetHooksOptionalParams.Builder()
                    .region(Region.US)
                    // .accessToken(accessToken)
                    .build();

            Hooks response = webhooksClient.getHooks();

            System.out.println(response);
            for (HookDetails hook : response.getData()) {
                System.out.println("Hook Id: " + hook.getHookId());
                System.out.println("Callback URL: " + hook.getCallbackUrl());
                System.out.println("Status: " + hook.getStatus());
                System.out.println("Created At: " + hook.getCreatedDate());
                System.out.println("Updated At: " + hook.getLastUpdatedDate());
                System.out.println("Scope: " + hook.getScope());
                System.out.println("Events: " + hook.getEvent());
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void getHookDetails() {
        String hookId = "your_hook_id_here"; // Replace with your actual hook ID
        try {
            HookDetails response = webhooksClient.getHookDetails(Systems.DATA, Events.DM_VERSION_MODIFIED, hookId);
            System.out.println("Hook Id: " + response.getHookId());
            System.out.println("Callback URL: " + response.getCallbackUrl());
            System.out.println("Status: " + response.getStatus());
            System.out.println("Created At: " + response.getCreatedDate());
            System.out.println("Updated At: " + response.getLastUpdatedDate());
            System.out.println("Scope: " + response.getScope());
            System.out.println("Events: " + response.getEvent());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    void getAppHooks(){
        
        try {
            GetAppHooksOptionalParams getAppHooksOptionalParams = new
            GetAppHooksOptionalParams.Builder()
            .region(Region.US)
            .status(StatusFilter.ACTIVE)
            .sort(Sort.ASC)
            .build();

            Hooks response = webhooksClient.getAppHooks(getAppHooksOptionalParams);
            System.out.println(response);
        }
        catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    void createSystemEventHook() {
        try {
            HookPayload hookPayload = new HookPayload();
            hookPayload.setAutoReactivateHook(false);
            Map<String, String> scope = new HashMap<>();
            scope.put("folder", folderId);
            hookPayload.setScope(scope);
            hookPayload.setHookExpiry("2025-10-21T17:04:10.444Z");
            hookPayload.setCallbackUrl("https://example.com/webhook");
            ApiResponse<ClassicHttpResponse> response = webhooksClient.createSystemEventHook(Systems.DATA,
                    Events.DM_FOLDER_MOVED, hookPayload);
            System.out.println(
                    response.getStatusCode() + " " + response.getHeaders() + "\nWebhook created successfully.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    void createSystemHook() {
        try {
            HookPayload hookPayload = new HookPayload();
            hookPayload.setAutoReactivateHook(false);
            Map<String, String> scope = new HashMap<>();
            scope.put("folder", folderId);
            hookPayload.setScope(scope);
            hookPayload.setHookExpiry("2025-10-21T17:04:10.444Z");
            hookPayload.setCallbackUrl("https://example.com/webhook");

            CreateSystemHookOptionalParams params = new CreateSystemHookOptionalParams.Builder()
                    .region(Region.US)
                    .build();
            Hook response = webhooksClient.createSystemHook(Systems.DATA, hookPayload, params);
            System.out.println("Webhook created successfully. Hook ID: " + response.getHooks());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }
    
    void deleteHook() {

        try {
            String hookId = "your_hook_id_here"; // Replace with your actual hook ID
            webhooksClient.deleteSystemEventHook(Systems.DATA, Events.DM_VERSION_MODIFIED, hookId);
            System.out.println("Webhook deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    void createToken(){
        try{
            TokenPayload tokenPayload = new TokenPayload();
            tokenPayload.token("awffbvdb3trf4fvdfbUyt39suHnbe5Mnrks4");
            Token createdToken = webhooksClient.createToken(tokenPayload);
            System.out.println("Token created successfully. Token: " + createdToken.getDetail());

        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    void deleteToken(){
        try{
            webhooksClient.deleteToken();
            System.out.println("Token deleted successfully.");
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            WebhooksSample webhooksSample = new WebhooksSample();
            // Initialize the Webhooks sample class
            webhooksSample.Initialize();
            // Get a webhook
            webhooksSample.getHooks();
            // Get details of a specific webhook
            webhooksSample.getHookDetails();
            // Get App Webhooks
            webhooksSample.getAppHooks();
            // Create a System Event webhook
            webhooksSample.createSystemEventHook();
            // Create a System webhook
            webhooksSample.createSystemHook();
            // Delete a webhook
            webhooksSample.deleteHook();
            // Create a token
            webhooksSample.createToken();
            // Delete a token
            webhooksSample.deleteToken();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            // Close the webhooks client
            webhooksClient.close();
        }

    }
}