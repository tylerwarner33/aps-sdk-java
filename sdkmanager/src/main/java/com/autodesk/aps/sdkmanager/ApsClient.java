package com.autodesk.aps.sdkmanager;

public class ApsClient implements IApsClient {
    private IResiliencyConfiguration resiliencyConfig;
    private IApsLogger logger;
    private ApsService apsService;

    public ApsClient(IResiliencyConfiguration resiliencyConfig, IApsLogger logger) {
        this.resiliencyConfig = resiliencyConfig;
        this.apsService = new ApsService(this.resiliencyConfig, this.logger);
        this.logger = logger;
        this.logger.debug("Initializing resiliency config: " + this.resiliencyConfig.toString());
    }

    public ApsService getApsService() {
        return apsService;
    }
}
