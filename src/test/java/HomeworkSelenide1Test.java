import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkSelenide1Test {
    /**
     * h1 div найдёт все элементы, совпадающие с данным локатором и вернёт первый подходящий
     * $("h1").$("div") найдет первый h1 и в нём будет искать div.
     * Если первый h1 в DOM не будет иметь div, то будет разный результат: во втором случае элемент не будет найден.
     */

    @BeforeAll
    static void tearUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.timeout = 10000; //10 sec
    }

    @Test
    @DisplayName("Check Selenide Github")
    void selenideTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }
}
