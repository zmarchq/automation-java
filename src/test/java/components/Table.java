package components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Table {
    public Table checkTitle(String title) {
        $("#example-modal-sizes-title-lg").shouldHave(text(title));
        return this;
    }

    public Table checkValues(String key, String value) {
        $(".table").$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }
}
