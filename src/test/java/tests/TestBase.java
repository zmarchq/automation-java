package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void tearUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //10 sec
        Configuration.browserSize = "1920x1080"; //Submit btn is not clickable without this configuration
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    static void addAttach() {
        Attach.screenshotAs("LastScreenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
}
