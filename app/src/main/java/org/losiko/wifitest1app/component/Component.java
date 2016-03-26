package org.losiko.wifitest1app.component;

import org.losiko.wifitest1app.R;

/**
 * Created by admin on 26.03.2016.
 */
public interface Component {
    String getComponentName();
    String getValue();
    void setValue(String value);

    int getIndexFrom();
    int getIndexTo();

    void fromSid(String globalSid);
    String getComponentSid();

    String getDictionary();
}
