package com.autodesk.aps.sdkmanager;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ApsConfiguration implements IApsConfiguration {
    private URL baseAddress;

    public ApsConfiguration(ApsConfigurationParams apsConfigurationParams) throws Exception {
        baseAddress = new URI("https://developer.api.autodesk.com").toURL();
        switch (apsConfigurationParams.getEnvironment()) {
            case LOCAL:
                baseAddress = new URI("http://localhost:1234").toURL();
                break;
            case DEV:
                baseAddress = new URI("https://developer-dev.api.autodesk.com").toURL();
                break;
            case STG:
                baseAddress = new URI("https://developer-stg.api.autodesk.com").toURL();
                break;
            default:
                baseAddress = new URI("https://developer.api.autodesk.com").toURL();
                break;
        }
    }

    public ApsConfiguration() throws MalformedURLException, URISyntaxException {
        baseAddress = new URI("https://developer.api.autodesk.com").toURL();
    }
    public URL getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(URL baseAddress) {
        this.baseAddress = baseAddress;
    }
}