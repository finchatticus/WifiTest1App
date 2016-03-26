package org.losiko.wifitest1app.component;

/**
 * Created by admin on 26.03.2016.
 */
public interface Component {
    String getComponentName();

    int getIndexFrom();
    int getIndexTo();

    void fromSid(String sid);
    String getComponentSid();
}
