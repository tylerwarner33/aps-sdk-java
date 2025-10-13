package com.autodesk.aps.sdkmanager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hc.core5.http.Header;
/**
 * API response returned by API call.
 *
 * @param <T> The type of data that is deserialized from response body
 */
public class ApiResponse<T> {
    final private int statusCode;
    final private Map<String, List<String>> headers;
    final private T data;
    /**
     * @param statusCode The status code of HTTP response
     * @param headers The headers of HTTP response
     */
    public ApiResponse(int statusCode, Header[] headers) {
        this(statusCode, headers, null);
    }
    /**
     * @param statusCode The status code of HTTP response
     * @param headers The headers of HTTP response
     * @param data The object deserialized from response body
     */
    public ApiResponse(int statusCode, Header[] headers, T data) {
        this.statusCode = statusCode;
        this.headers = convertHeadersToMap(headers);
        this.data = data;
    }
    private Map<String, List<String>> convertHeadersToMap(Header[] headers) {
        Map<String, List<String>> headerMap = new HashMap<>();
        for (Header header : headers) {
            String headerName = header.getName();
            String headerValue = header.getValue();
            if (headerMap.containsKey(headerName)) {
                headerMap.get(headerName).add(headerValue);
            } else {
                List<String> values = new ArrayList<>();
                values.add(headerValue);
                headerMap.put(headerName, values);
            }
        }
        return headerMap;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public Map<String, List<String>> getHeaders() {
        return headers;
    }
    public T getData() {
        return data;
    }
}