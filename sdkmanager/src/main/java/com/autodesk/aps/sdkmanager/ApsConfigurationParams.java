package com.autodesk.aps.sdkmanager;

public class ApsConfigurationParams {
    private AdskEnvironment environment;
    
    public ApsConfigurationParams(AdskEnvironment environment) {
        this.environment = environment;
    }

    public AdskEnvironment getEnvironment() {
        return environment;
    }

    public void setEnvironment(AdskEnvironment environment) {
        this.environment = environment;
    }
}