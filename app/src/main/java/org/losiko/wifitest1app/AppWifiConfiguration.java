package org.losiko.wifitest1app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.widget.Toast;

/**
 * Created by admin on 26.03.2016.
 */
@SuppressLint("ParcelCreator")
public class AppWifiConfiguration extends WifiConfiguration {
    public AppWifiConfiguration() {
        SSID = generateSSID();
        allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
        allowedProtocols.set(WifiConfiguration.Protocol.RSN);
        allowedProtocols.set(WifiConfiguration.Protocol.WPA);
        allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
    }

    public static String generateSSID() {
        return "TestAp" + (int) (Math.random() * 1000);
    }
}
