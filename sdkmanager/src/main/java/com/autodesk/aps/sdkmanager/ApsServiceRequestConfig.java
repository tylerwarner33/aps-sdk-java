package com.autodesk.aps.sdkmanager;
import java.util.HashMap;
import java.util.Map;

public class ApsServiceRequestConfig {
    private String url;
    private String method = "GET";  // default to GET
    private Map<String, String> headers = new HashMap<>();
    private Object body;  // request body
    private int timeout;  // timeout in milliseconds
    private Map<String, String> params = new HashMap<>();  // query parameters

    // Getters and setters
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    
    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }
    
    public Object getBody() { return body; }
    public void setBody(Object data) { this.body = data; }
    
    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }
    
    public Map<String, String> getQueryParams() { return params; }
    public void setQueryParams(Map<String, String> params) { this.params = params; }
}

