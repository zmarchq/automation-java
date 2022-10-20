package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import helpers.ApiBot;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DemoShopPage {
    SelenideElement email = $("#Email");


    @Step("Авторизовать пользователя на сайте")
    public DemoShopPage setCookie() {
        String cookieValue = new ApiBot().registerDemoShopUser();
        Selenide.open("https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie("NOPCOMMERCE.AUTH", cookieValue);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        return this;
    }

    @Step("Открыть страницу пользователя")
    public DemoShopPage openUserPage() {
        Selenide.open("https://demowebshop.tricentis.com/customer/info");
        return this;
    }

    @Step("Изменить Email пользователя")
    public DemoShopPage updateUserEmail(String newEmail) {
        email.clear();
        email.setValue(newEmail);
        $(Selectors.byName("save-info-button")).click();
        return this;
    }

    @Step("Получить текущий Email пользователя")
    public String getCurrentEmail() {
        open("https://demowebshop.tricentis.com/");
        return  $(".account[href = '/customer/info']").getText();
    }


}
