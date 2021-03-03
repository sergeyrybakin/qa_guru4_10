package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    public static String getSearchSite() {
        return getConfig().searchSite();
    }
    public static String getSearchItem() {
        return getConfig().searchItem();
    }

    public static String getSearchExpectation() {
        return getConfig().searchExpectation();
    }

    public static String getWebdriverRemote() {
        return getConfig().webdriverRemote();
    }

    private static WebConfig getConfig() {
        if (System.getProperty("environment") == null) System.getProperty("environment","example");

        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

}