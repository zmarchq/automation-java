package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomeworkSelenide2Test extends TestBase {

    @Test
    void hoverTest() {
        open("https://github.com");
        Selenide.clearBrowserLocalStorage();
        $(".HeaderMenu").$(Selectors.byText("Pricing")).hover();
        $(Selectors.byText("Compare plans")).click();
    }
    
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement a = $("#column-a");
        SelenideElement b = $("#column-b");
        a.dragAndDropTo(b); //it works
        actions().dragAndDrop(b, a); //it doesn't work
    }
}
