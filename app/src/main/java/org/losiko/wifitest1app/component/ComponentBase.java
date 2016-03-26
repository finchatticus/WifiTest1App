package org.losiko.wifitest1app.component;

import android.content.res.XmlResourceParser;
import android.widget.Toast;

import org.losiko.wifitest1app.MainActivity;
import org.losiko.wifitest1app.R;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by admin on 26.03.2016.
 */
public abstract class ComponentBase implements Component {
    @Override
    public void fromSid(String globalSid) {
        String localSid = ComponentUtils.getLocalSid(this, globalSid);
        ComponentUtils.alert("Global sid "+ globalSid + "; Local seed " + localSid);
        int dictionary = Integer.valueOf(getDictionary());
        setValue(ComponentUtils.getValueFromXmlDictionary(dictionary, localSid));
    }


    @Override
    public String getComponentSid() {
        return null;
    }
}
