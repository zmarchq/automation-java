import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

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
        File file = new File("src/main/resources/test_data/Screenshot_3.png");
        open("/automation-practice-form");
        $("#firstName").setValue("Tester");
        $("#lastName").setValue("Tester");
        $("#userEmail").setValue("tester@mail.com");
        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue("8913555555");
        $("#subjectsInput").setValue("c");
        $("#react-select-2-option-0").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Novosibirsk, Akadem 32/1");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        Assertions.assertTrue($("#example-modal-sizes-title-lg").isDisplayed(), "Modal-dialog is not displayed");
    }
}
