package org.losiko.wifitest1app.component;

import org.losiko.wifitest1app.R;

/**
 * Created by admin on 26.03.2016.
 */
public class GenderComponent extends ComponentBase {
    private static final String componentName = "Gender";
    private static final int indexFrom = 6;
    private static final int indexTo = 6;

    private String value;

    @Override
    public String getComponentName() { return componentName; }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int getIndexFrom() { return indexFrom; }

    @Override
    public int getIndexTo() { return indexTo; }

    @Override
    public String getDictionary() {
        return String.valueOf(R.xml.gender);
    }

}
