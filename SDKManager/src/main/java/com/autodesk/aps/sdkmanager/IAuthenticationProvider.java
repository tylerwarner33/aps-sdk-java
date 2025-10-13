package com.autodesk.aps.sdkmanager;

public interface IAuthenticationProvider {
    // Primary method taking a collection of scopes.
    String getAccessToken(Iterable<String> scopes);

    // Overloaded method with no scopes provided.
    default String getAccessToken() {
        return getAccessToken(null);
    }
}
