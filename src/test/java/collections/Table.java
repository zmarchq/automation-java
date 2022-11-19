package collections;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Table {
    private SelenideElement _tableElement;
    private final String CELL = "td";
    public Table(SelenideElement tableElement) {
        _tableElement = tableElement;
    }

    public List<SelenideElement> getAllRows() {
        return _tableElement.$$("tbody tr");
    }

    public List<SelenideElement> getHeaders() {
        return _tableElement.$$("th");
    }

    public List<List<SelenideElement>> getListOfRows() {
        List<SelenideElement> rows = getAllRows();
        ArrayList<List<SelenideElement>> listOfRows = new ArrayList<>();
        for (var row : rows) {
            listOfRows.add(row.$$("td"));
        }
        return listOfRows;
    }

    public List<Map<String, SelenideElement>> getColumnsWithValues() {
        List<Map<String, SelenideElement>> result = new ArrayList<>(); //array
        Map<String, SelenideElement> rowsAndHeaders;
        List<List<SelenideElement>> rowsList = getListOfRows();
        List<SelenideElement> headers = getHeaders();
        for (List<SelenideElement> row : rowsList) { //foreach
            rowsAndHeaders = new HashMap<>(); //map
            for (int i = 0; i < headers.size(); i++) { //for
                String header = headers.get(i).getText();
                SelenideElement cell = row.get(i);
                rowsAndHeaders.put(header, cell);
            }
            result.add(rowsAndHeaders); //add element
        }
        return result;
    }

    public Table checkRowsByName(String key, String value) {
        Map<String, String> result = new HashMap<>();
        int i = 0;
        while (i < getAllRows().size()) { //while
            String actualKey = getAllRows().get(i).$(CELL, 0).getText();
            String actualValue = getAllRows().get(i).$(CELL, 1).getText();
            result.put(actualKey, actualValue);
            i++;
        }
        assertThat(result.get(key)).isEqualTo(value);
        return this;
    }

    public Table checkValueFromCell(int row, int column, String expected) {
        getListOfRows().get(row).get(column).shouldHave(text(expected)); //search element
        return this;
    }

    public Table checkValueFromCell(int row, String column, String expected) {
        getColumnsWithValues().get(row).get(column).shouldHave(text(expected));
        return this;
    }

    @Step("Проверить заголовок таблицы")
    public Table checkTitle(String title) {
        $("#example-modal-sizes-title-lg").shouldHave(text(title));
        return this;
    }

    @Step("Проверить, что значение в поле {key} равно {value}")
    public Table checkValues(String key, String value) {
        $(".table").$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }
}
