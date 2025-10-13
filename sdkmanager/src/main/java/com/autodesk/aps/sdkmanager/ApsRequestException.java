package com.autodesk.aps.sdkmanager;
public class ApsRequestException extends RuntimeException {
    private final int statusCode;
    private final String responseBody;

    public ApsRequestException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = 0;
        this.responseBody = null;
    }

    public ApsRequestException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}