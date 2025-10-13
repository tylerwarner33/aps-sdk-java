package com.autodesk.aps.sdkmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class ApsLogger implements IApsLogger {

    private static final Logger logger = LoggerFactory.getLogger(ApsLogger.class);
    private static final Logger loggerR = LoggerFactory.getLogger("io.github.resilience4j");
    private static final Logger httpClientLogger = LoggerFactory.getLogger("org.apache.hc.client5.http");
    private boolean isEnable = true;

    public ApsLogger() {
        setLevel(Level.ERROR);
    }

    public ApsLogger(Level level) {
        setLevel(level);
    }

    public void setEnabled(boolean enable) {
        this.isEnable = enable;
    }

    @Override
    public void info(String message) {
        if (isEnable) {
            logger.info(message);
        }
    }

    @Override
    public void error(String message) {
        if (isEnable) {
            logger.error(message);
        }
    }

    @Override
    public void warn(String message) {
        if (isEnable) {
            logger.warn(message);
        }
    }

    @Override
    public void debug(String message, Object... args) {
        if (isEnable) {
            logger.debug(message);
        }
    }

    @Override
    public void error(String message, Throwable error) {
        if (isEnable) {
            logger.error(message, error);
        }
    }
     private void disableHttpClientDebugLogs() {
        if (httpClientLogger instanceof ch.qos.logback.classic.Logger) {
            ((ch.qos.logback.classic.Logger) httpClientLogger).setLevel(ch.qos.logback.classic.Level.ERROR);
        }
    }
    private void setLevel(Level level) {
        ((ch.qos.logback.classic.Logger) logger).setLevel(ch.qos.logback.classic.Level.toLevel(level.toString()));
        ((ch.qos.logback.classic.Logger) loggerR).setLevel(ch.qos.logback.classic.Level.toLevel(level.toString()));
        disableHttpClientDebugLogs();

    }
}