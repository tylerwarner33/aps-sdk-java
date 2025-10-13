package com.autodesk.aps.sdkmanager;

public class BaseClient {
    private IAuthenticationProvider authenticationProvider;

    public IAuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }

    public void setAuthenticationProvider(IAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    public BaseClient(IAuthenticationProvider authenticationProvider) {
        if (authenticationProvider != null) {
            this.authenticationProvider = authenticationProvider;
        }
    }
}
