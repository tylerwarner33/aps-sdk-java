package com.autodesk.aps.sdkmanager;

public class SdkManagerBuilder {
    private IResiliencyConfiguration resiliencyConfiguration;
    private IApsConfiguration apsConfiguration;
    private IApsLogger logger;

    private SdkManagerBuilder() {}

    public static SdkManagerBuilder create() {
        return new SdkManagerBuilder();
    }

    public SdkManagerBuilder addResiliencyConfiguration(
            IResiliencyConfiguration resiliencyConfiguration) {
        this.resiliencyConfiguration = resiliencyConfiguration;
        return this;
    }

    public SdkManagerBuilder addApsConfiguration(
            IApsConfiguration apsConfiguration) {
        this.apsConfiguration = apsConfiguration;
        return this;
    }

    public SdkManagerBuilder addLogger(IApsLogger logger) {
        this.logger = logger;
        return this;
    }

    public SdkManager build() {
        return SdkManager.getInstance(apsConfiguration, resiliencyConfiguration,logger);
    }
}