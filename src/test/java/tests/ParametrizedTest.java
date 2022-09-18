package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ParametrizedTest {
    @BeforeAll
    static void tearUp() {
        Configuration.timeout = 10000; //10 sec
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {"standard_user", "problem_user", "performance_glitch_user"})
    @ParameterizedTest(name = "Авторизация пользователя с имененем {0}")
    void authTest(String name) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(name);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(".title").shouldHave(Condition.text("Products"));
    }

    @CsvSource(value = {
            "Diana    | diana_test@mail.ru | (434) 729-5285, 441 North Ave, Brodnax, Virginia(VA), 23920",
            "John Doe | john.doe1@mail.ru  | (740) 852-5043, 1710 E Choctaw Dr, London, Ohio(OH), 43140"
    },
    delimiter = '|')
    @ParameterizedTest(name = "Поле результата содержит имя {0}, почту {1}, адрес {2}")
    void textBoxTest(String name, String mail, String address){
        open("https://demoqa.com/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#userName").setValue(name);
        $("#userEmail").setValue(mail);
        $("#currentAddress").setValue(address);
        $("#submit").click();
        $("#name").shouldHave(Condition.text(name));
        $("#email").shouldHave(Condition.text(mail));
        $("#currentAddress").shouldHave(Condition.value(address));
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of($("button[data-target='0']"), "Объединение ручных и автотестов в одном интерфейсе"),
                Arguments.of($("button[data-target='1']"), "Создание и управление автотестами на любом языке программирования"),
                Arguments.of($("button[data-target='2']"), "Обеспечение прозрачности работы QA-отдела")
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "Выбранной вкладке соответствует заголовок {1}")
    void test(SelenideElement tab, String title) {
        open("https://testit.software/product");
        tab.click();
        $(".ctrl-tabs__item:not(.is-hidden)").shouldHave(Condition.text(title));
    }
}
