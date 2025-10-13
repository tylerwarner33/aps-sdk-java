package com.autodesk.aps.sdkmanager;
import java.time.Duration;
import java.util.*;
import org.apache.hc.core5.http.HttpResponse;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

public class ResiliencyConfiguration implements IResiliencyConfiguration {
    private int retryCount;
    private long backoffInterval;
    private long timeOutValue;

    // Resilience4j specific configurations
    private ThreadPoolBulkheadConfig bulkheadConfig;
    private RetryConfig retryConfig;
    private CircuitBreakerConfig circuitBreakerConfig;
    private TimeLimiterConfig timeLimiterConfig;
    private final List<Integer> RETRYABLE_STATUS_CODES;

    public ResiliencyConfiguration() {
        this(5, 500,30000); // Default values
    }
    public ResiliencyConfiguration(int retryCount,
            long backoffInterval,
            long timeOutValue) {
        this.retryCount = retryCount;
        this.backoffInterval = backoffInterval;
        this.timeOutValue = timeOutValue;
        this.RETRYABLE_STATUS_CODES = Arrays.asList(408, 500, 429, 501, 502, 503, 504, 507, 509, 511);
        initializeConfigs();
    }

    private void initializeConfigs() {
        // Initialize Configuration
        this.bulkheadConfig = ThreadPoolBulkheadConfig.ofDefaults();

        this.retryConfig = RetryConfig.<HttpResponse>custom()
                .maxAttempts(this.retryCount)
                .intervalFunction(IntervalFunction.ofExponentialBackoff(
                        Duration.ofMillis(backoffInterval),
                        2.0,
                        Duration.ofSeconds(30)))
                .retryOnResult(response -> {
                    boolean shouldRetry = response != null && RETRYABLE_STATUS_CODES.contains(response.getCode());
                    return shouldRetry;
                })
                .build();

        // Initialize Circuit Breaker Configuration
        this.circuitBreakerConfig = CircuitBreakerConfig.ofDefaults();
        // Initialize Time Limiter Configuration
        this.timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(timeOutValue))
                .cancelRunningFuture(true) // 10 seconds timeout
                .build();
    }

    @Override
    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
        initializeConfigs();
    }

    @Override
    public long getBackoffInterval() {
        return backoffInterval;
    }

    @Override
    public void setBackoffInterval(long backoffInterval) {
        this.backoffInterval = backoffInterval;
        initializeConfigs();
    }

    @Override
    public long getTimeOutValue() {
        return timeOutValue;
    }

    @Override
    public void setTimeOutValue(long timeOutValue) {
        this.timeOutValue = timeOutValue;
        initializeConfigs();
    }
    @Override
    public long getTimeLimiterTimeoutMillis() {
        return timeLimiterConfig.getTimeoutDuration().toMillis();
    }


    // Getters for Resilience4j specific configurations
    public RetryConfig getRetryConfig() {
        return retryConfig;
    }

    public CircuitBreakerConfig getCircuitBreakerConfig() {
        return circuitBreakerConfig;
    }

    public TimeLimiterConfig getTimeLimiterConfig() {
        return timeLimiterConfig;
    }

    public ThreadPoolBulkheadConfig getBulkheadConfig() {
        return bulkheadConfig;
    }

    @Override
    public String toString() {
        return String.format("ResiliencyConfiguration (TimeOutValue: %d) (RetryCount: %d) " +
                        "(BackoffInterval: %d))",
                timeOutValue, retryCount, backoffInterval);
    }
    @Override
    public int getRetryCount() {
        return retryCount;
    }

}