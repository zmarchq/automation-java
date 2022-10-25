package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import owner.WebDriverConfig;

import java.util.function.Supplier;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

    private final WebDriverConfig config;

    public TestBase() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @BeforeAll
    void tearUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        if (config.getRemoteUrl() != null) {
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;//"https://user1:1234@selenoid.autotests.cloud/wd/hub";
        }

        Configuration.timeout = config.timeout(); //10 sec
        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
    }

    @AfterEach
    void addAttach() {
        Attach.screenshotAs("LastScreenshot");
        Attach.pageSource();
    //    Attach.browserConsoleLogs(); //Не работает с firefox!
        Attach.addVideo();
    }
}
