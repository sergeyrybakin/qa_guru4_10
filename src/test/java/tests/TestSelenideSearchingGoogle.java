package tests;

import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestSelenideSearchingGoogle {

        @BeforeAll
        static void setup() {
            addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.startMaximized = true;

            if(System.getProperty("remote_driver") != null) {
                //config for Java + Selenide
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                Configuration.browserCapabilities = capabilities;
//                Configuration.remote = System
//                        .getProperty("remote_driver"); //"https://user1:1234@selenoid.autotests.cloud:4444/wd/hub";
                Configuration.remote = ConfigHelper.getWebdriverRemote();
            }
        }

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
