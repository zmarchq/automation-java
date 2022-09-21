package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    final static String VNC = "enableVNC";
    final static String VIDEO = "enableVideo";

    @BeforeAll
    static void tearUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(VNC, Boolean.valueOf(System.getProperty(VNC)));
        capabilities.setCapability(VIDEO, System.getProperty(VIDEO));

        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 10000; //10 sec
        Configuration.browserSize = System.getProperty("browserSize"); //Submit btn is not clickable without this configuration
        Configuration.remote = System.getProperty("remote"); //"https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserVersion = System.getProperty("browserVersion");
    }

    @AfterEach
    void addAttach() {
        Attach.screenshotAs("LastScreenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
