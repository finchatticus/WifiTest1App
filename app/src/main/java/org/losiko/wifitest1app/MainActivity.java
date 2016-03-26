package org.losiko.wifitest1app;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    WifiConfiguration wifiConfiguration;
    AppWifiManager appWifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        wifiManager =  (WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE);
        wifiConfiguration =  new AppHostWifiConfiguration();
        appWifiManager = new AppWifiManager(wifiManager, wifiConfiguration);
    }

    public void tryToStartHostSpot(View view) {
        try{
            appWifiManager.setWifiDisable();
            appWifiManager.setWifiApEnabled();

            Log.e("CLIENT", "\nSSID:" + wifiConfiguration.SSID + "\nPassword:" + wifiConfiguration.preSharedKey + "\n");
        } catch (Exception e) {
            Log.e(this.getClass().toString(), "", e);
        }
    }
    public void tryToStopHostSpot(View view) {
        try{
            appWifiManager.setWifiApDisabled();
        } catch (Exception e) {
            Log.e(this.getClass().toString(), "", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
