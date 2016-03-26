package org.losiko.wifitest1app.component;

import android.content.res.XmlResourceParser;
import android.util.Log;
import android.widget.Toast;

import org.losiko.wifitest1app.MainActivity;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by admin on 26.03.2016.
 */
public class ComponentUtils {
    public static String getLocalSid(Component component, String globalSid) {
        return globalSid.substring(component.getIndexFrom(), component.getIndexTo() + 1);
    }

    public static String getValueFromXmlDictionary(int dictionary, String localSid) {
        String VALUE_TAG_NAME = "pair";
        String SID_ATTR_NAME = "sid";

        try {
            XmlResourceParser xrp = MainActivity.context.getResources().getXml(dictionary);

            xrp.next();
            int eventType = xrp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                boolean isValueTag = eventType == XmlPullParser.START_TAG
                        && xrp.getName().equalsIgnoreCase(VALUE_TAG_NAME);

                if (isValueTag) {
                    String attrValue = xrp.getAttributeValue(null, SID_ATTR_NAME);
                    if (localSid.equals(attrValue)) {
                        String value = xrp.nextText();
                        return value;
                    }
                }

                eventType = xrp.next();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static void alert(String text) {
        Toast.makeText(MainActivity.context, text, Toast.LENGTH_SHORT).show();
    }
}
