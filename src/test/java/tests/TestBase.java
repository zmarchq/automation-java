package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import testData.UserTestData;

public class TestBase {

    @BeforeAll
    static void tearUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //10 sec
        Configuration.browserSize = "1920x1080"; //Submit btn is not clickable without this configuration
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
