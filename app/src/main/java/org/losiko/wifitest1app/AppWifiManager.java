package org.losiko.wifitest1app;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 26.03.2016.
 */
public class AppWifiManager {
    WifiManager wifiManager;
    WifiConfiguration wifiConfiguration;

    Method methodSetWifiApEnabled;
    Method methodIsWifiApEnabled;
    Method methodGetWifiApState;
    Method methodGetWifiApConfiguration;

    public AppWifiManager(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        this.wifiManager = wifiManager;
        this.wifiConfiguration = wifiConfiguration;

        tryToInitMethods(wifiManager);
    }

    private void tryToInitMethods(WifiManager wifiManager) {
        try {
            methodSetWifiApEnabled = wifiManager.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, boolean.class);
            methodIsWifiApEnabled = wifiManager.getClass().getMethod("isWifiApEnabled");
            methodGetWifiApState = wifiManager.getClass().getMethod("getWifiApState");
            methodGetWifiApConfiguration = wifiManager.getClass().getMethod("getWifiApConfiguration");
        } catch (NoSuchMethodException e) {
            Log.e("wifi", e.getMessage());
        }
    }

    public void setWifiDisable() {
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }
    public void setWifiEnable() {
        wifiManager.setWifiEnabled(true);
    }
    public boolean isWifiApEnabled() {
        try {
            return (Boolean) methodIsWifiApEnabled.invoke(wifiManager);
        } catch (Exception e) {
            methodCallError(e);
            return false;
        }
    }
    public boolean setWifiApEnabled() {
        try {
            return (Boolean) methodSetWifiApEnabled.invoke(wifiManager, wifiConfiguration, true);
        } catch (Exception e) {
            methodCallError(e);
            return false;
        }
    }
    public boolean setWifiApDisabled() {
        try {
            return (Boolean) methodSetWifiApEnabled.invoke(wifiManager, wifiConfiguration, false);
        } catch (Exception e) {
            methodCallError(e);
            return false;
        }
    }

    public WifiConfiguration getWifiApConfiguration() {
        try {
            return (WifiConfiguration) methodGetWifiApConfiguration.invoke(wifiManager);
        } catch (Exception e) {
            methodCallError(e);
            return null;
        }
    }

    private void methodCallError(Exception e) {
        Log.e("wifi", "Can't invoke method. " + e.getMessage());
    }
}
