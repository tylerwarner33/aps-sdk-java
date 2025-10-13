/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * oss
 * The Object Storage Service (OSS) allows your application to download and upload raw files (such as PDF, XLS, DWG, or RVT) that are managed by the Data service.
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
package com.autodesk.aps.oss;


public class OssApiException extends RuntimeException {
    private int statusCode;
    private String responseBody;

    /**
     * Initializes a new instance of the OssApiException class with a specified cause.
     * @param cause The cause of the exception.
     */
    public OssApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Initializes a new instance of the OssApiException class with a specified error message.
     * @param message The error message.
     */
    public OssApiException(String message) {
        super(message);
    }
    
    /**
     * Initializes a new instance of the OssApiException class with a specified HTTP status code and error message.
     * @param statusCode The HTTP status code.
     * @param message The error message.
     */
    public OssApiException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Initializes a new instance of the OssApiException class with a specified error message, HTTP status code, and response body.
     * @param message The error message.
     * @param statusCode The HTTP status code.
     * @param responseBody The HTTP response body.
     */
    public OssApiException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Initializes a new instance of the OssApiException class with a specified error message, HTTP status code, response body, and a reference to the inner exception that is the cause of this exception.
     * @param message The error message.
     * @param statusCode The HTTP status code.
     * @param responseBody The HTTP response body.
     * @param cause The exception that is the cause of the current exception.
     */
    public OssApiException(String message, int statusCode, String responseBody, Throwable cause) {
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