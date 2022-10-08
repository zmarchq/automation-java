package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureReportsTest extends TestBase {
    final String ISSUE = "С Новым Годом (2022)";

    @Test
    public void listenerTest() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("С Новым Годом (2022)")).should(Condition.exist);
    }

    @Test
    @Feature("Issue в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void tagsTest() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("С Новым Годом (2022)")).should(Condition.exist);
    }

    @Test
    void stepsTest() {
        IssuesPage issuesPage = new IssuesPage();

        issuesPage.openMainPage();
        issuesPage.searchForRepository("eroshenkoam/allure-example");
        issuesPage.clickOnRepositoryLink("eroshenkoam/allure-example");
        issuesPage.openIssuesTab();
        issuesPage.takeScreenshot();
        issuesPage.shouldSeeIssueWithNumber("С Новым Годом (2022)");
    }

    @Test
    @Tag("property")
    void lambdaTest() {
        step("Открыть главную страницу", () -> open("https://github.com"));
        step("Открыть проект", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        });
        step("Открыть таб Issues", () -> {
            $(linkText("eroshenkoam/allure-example")).click();
            $("#issues-tab").click();
        });
        step("Проверить наличие issue с текстом " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }
}
