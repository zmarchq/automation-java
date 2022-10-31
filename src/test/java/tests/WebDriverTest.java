package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class WebDriverTest extends TestBase {

    @BeforeEach
    void openPage() {
        open("https://github.com/");
    }


    @Test
    @Tag("Owner")
    void testGitHub() {
        String title = step("Получить заголовок страницы", () -> WebDriverRunner.getWebDriver().getTitle());
        Assertions.assertEquals("GitHub: Where the world builds software · GitHub", title, "Заголовки не совпадают!");
    }
}
