package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})

public interface WebConfig extends Config {
    @Key("search.item")
    String searchItem();

    @Key("search.expectation")
    String searchExpectation();

    @Key("search.site")
    String searchSite();
}