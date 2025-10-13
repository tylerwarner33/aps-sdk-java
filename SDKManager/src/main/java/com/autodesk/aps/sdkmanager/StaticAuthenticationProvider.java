package com.autodesk.aps.sdkmanager;

public class StaticAuthenticationProvider implements IAuthenticationProvider {
    private final String accessToken;

    public StaticAuthenticationProvider(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String getAccessToken(Iterable<String> scopes) {
        return accessToken;
    }  
}
