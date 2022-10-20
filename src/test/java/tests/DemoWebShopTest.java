package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DemoShopPage;

public class DemoWebShopTest extends TestBase{
    DemoShopPage demoShopPage = new DemoShopPage();
    Faker faker = new Faker();


    @Test
    @Tag("demoTest")
    @DisplayName("Обновление электронной почты пользователя через личный кабинет")
    void loginDemoShopUser() {
        String newEmail = faker.internet().emailAddress();
        String email = demoShopPage
                .setCookie()
                .openUserPage()
                .updateUserEmail(newEmail)
                .getCurrentEmail();
        Assertions.assertEquals(newEmail, email);
    }
}
