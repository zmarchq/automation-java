import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void tearUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //10 sec
        Configuration.browserSize = "1920x1080"; //Submit btn is not clickable without this configuration
    }

    @Test
    @DisplayName("Submit practice form")
    void firstTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Tester");
        $("#lastName").setValue("Tester");
        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue("8913555555");
        $("#submit").click();
        Assertions.assertTrue($("#example-modal-sizes-title-lg").isDisplayed());
    }
}
