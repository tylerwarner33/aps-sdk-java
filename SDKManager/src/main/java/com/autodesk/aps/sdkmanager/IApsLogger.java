package com.autodesk.aps.sdkmanager;

public interface IApsLogger {

    public void info(String message);

    public void error(String message);

    public void warn(String message);

    public void debug(String message , Object... args);

    public void error(String string, Throwable error);

    public void setEnabled(boolean enabled);
}