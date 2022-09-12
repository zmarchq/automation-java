package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureReportsTest {

    @Test
    public void listenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        IssuesPage issuesPage = new IssuesPage();

        issuesPage.openMainPage();
        issuesPage.searchForRepository("eroshenkoam/allure-example");
        issuesPage.clickOnRepositoryLink("eroshenkoam/allure-example");
        issuesPage.openIssuesTab();
        issuesPage.takeScreenshot();
        issuesPage.shouldSeeIssueWithNumber("С Новым Годом (2022)");
    }
}
