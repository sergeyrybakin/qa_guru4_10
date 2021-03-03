package tests;

import config.ConfigHelper;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSelenideSearchingGoogle {

        @Test
        void selenideInGoogleTest() {
            String searchSite = ConfigHelper.getSearchSite();
            String searchItem = ConfigHelper.getSearchItem();
            String searchExpectation = ConfigHelper.getSearchExpectation();

            open(searchSite);
            $(byName("q")).setValue(searchItem).pressEnter();
            $("#search").shouldHave(text(searchExpectation));
        }
}
