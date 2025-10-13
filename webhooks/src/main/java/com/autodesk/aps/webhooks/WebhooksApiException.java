/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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
package com.autodesk.aps.webhooks;


public class WebhooksApiException extends RuntimeException {
    private int statusCode;
    private String responseBody;

    /**
     * Initializes a new instance of the WebhooksApiException class with a specified cause.
     * @param cause The cause of the exception.
     */
    public WebhooksApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Initializes a new instance of the WebhooksApiException class with a specified error message.
     * @param message The error message.
     */
    public WebhooksApiException(String message) {
        super(message);
    }
    
    /**
     * Initializes a new instance of the WebhooksApiException class with a specified HTTP status code and error message.
     * @param statusCode The HTTP status code.
     * @param message The error message.
     */
    public WebhooksApiException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Initializes a new instance of the WebhooksApiException class with a specified error message, HTTP status code, and response body.
     * @param message The error message.
     * @param statusCode The HTTP status code.
     * @param responseBody The HTTP response body.
     */
    public WebhooksApiException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Initializes a new instance of the WebhooksApiException class with a specified error message, HTTP status code, response body, and a reference to the inner exception that is the cause of this exception.
     * @param message The error message.
     * @param statusCode The HTTP status code.
     * @param responseBody The HTTP response body.
     * @param cause The exception that is the cause of the current exception.
     */
    public WebhooksApiException(String message, int statusCode, String responseBody, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Gets the HTTP status code.
     * @return The HTTP status code.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the HTTP response body.
     * @return The HTTP response body.
     */
    public String getResponseBody() {
        return responseBody;
    }
}