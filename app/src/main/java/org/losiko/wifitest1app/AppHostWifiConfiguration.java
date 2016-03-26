package org.losiko.wifitest1app;

import android.net.wifi.WifiConfiguration;

/**
 * Created by admin on 26.03.2016.
 */
public class AppHostWifiConfiguration extends WifiConfiguration {
    public AppHostWifiConfiguration() {
        SSID = "TestAp1";
        allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
        allowedProtocols.set(WifiConfiguration.Protocol.RSN);
        allowedProtocols.set(WifiConfiguration.Protocol.WPA);
        allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
    }
}
