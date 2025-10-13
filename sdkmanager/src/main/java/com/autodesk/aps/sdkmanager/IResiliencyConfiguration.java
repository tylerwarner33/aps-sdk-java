package com.autodesk.aps.sdkmanager;

import io.github.resilience4j.bulkhead.ThreadPoolBulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;

public interface IResiliencyConfiguration {
    ThreadPoolBulkheadConfig getBulkheadConfig();
    RetryConfig getRetryConfig();
    void setRetryCount(int retryCount);
    int getRetryCount();
    long getBackoffInterval();
    void setBackoffInterval(long backoffInterval);
    CircuitBreakerConfig getCircuitBreakerConfig();
    long getTimeOutValue();
    void setTimeOutValue(long timeOutValue);

    // Returns timeout duration in milliseconds
    long getTimeLimiterTimeoutMillis();
}
