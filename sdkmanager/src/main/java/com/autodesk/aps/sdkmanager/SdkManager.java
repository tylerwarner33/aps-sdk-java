package com.autodesk.aps.sdkmanager;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.slf4j.event.Level;

public class SdkManager {
    private IApsClient apsClient;
    private IApsLogger logger;
    private IApsConfiguration apsConfiguration;
    private IResiliencyConfiguration resiliencyConfiguration;

    private static SdkManager instance;

    private SdkManager(IApsConfiguration apsConfiguration,IResiliencyConfiguration resiliencyConfiguration,IApsLogger logger) throws MalformedURLException, URISyntaxException {
        this.logger = (logger != null) ? logger : new ApsLogger(Level.ERROR);
        this.apsConfiguration = (apsConfiguration != null) ? apsConfiguration : new ApsConfiguration();
        this.resiliencyConfiguration = (resiliencyConfiguration != null) ? resiliencyConfiguration : new ResiliencyConfiguration();
        this.apsClient = new ApsClient(this.resiliencyConfiguration, this.logger);
    }

    public static SdkManager getInstance(
            IApsConfiguration apsConfiguration,
            IResiliencyConfiguration resiliencyConfiguration,
            IApsLogger logger) {
        if (instance == null) {
            try {
                instance = new SdkManager(apsConfiguration, 
                                        resiliencyConfiguration,
                                        logger);
            } catch (MalformedURLException | URISyntaxException e) {
                e.printStackTrace();

            }
        }
        return instance;
    }

    public void setLogger(IApsLogger logger) {
        this.logger = logger;
    }

    public IApsLogger getLogger() {
        return logger;
    }

    public IApsClient getApsClient() {
        return apsClient;
    }
    public IApsConfiguration getApsConfiguration() {
        return apsConfiguration;
    }

    public void setApsConfiguration(IApsConfiguration apsConfiguration) {
        this.apsConfiguration = apsConfiguration;
    }

    public void toggleLogging(boolean enabled) {
        this.logger.setEnabled(enabled);
    }
}