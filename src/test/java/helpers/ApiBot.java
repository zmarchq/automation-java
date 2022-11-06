package helpers;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import testdata.UserTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiBot {
    private final Map<String, String> params = new HashMap<>();
    private final String TOKEN = "__RequestVerificationToken";
    private final String TOKEN_VALUE = "10QcxkN4-Gk5PEeZlTrtVTuN7xtnRi_RY4ssN4Kd1kn--wsjFIdx3MtZG3cs6EsIYcWSCd3dIikpNcaAeVkJyMaRx50q_u84GfmcWQFqcqw1";
    private final String COOKIE_VALUE = "at9THwDl4iOCtU40qL9aL87W4x6vnP7C7vDFXJ6VVruf0QlYjJGo4vKOOZ37as2KBsbYUCMAENIXnFqvW6QHp-85oL4JZadn5TQu5MPCDv41";

    private Map<String, String> initParams() {
        params.put(TOKEN, TOKEN_VALUE);
        params.put("FirstName", UserTestData.firstName);
        params.put("LastName", UserTestData.lastname);
        params.put("Email", UserTestData.email);
        params.put("Password", UserTestData.password);
        params.put("ConfirmPassword", UserTestData.password);
        return params;
    }

    @Step("Регистрация нового пользователя через АПИ")
    public String registerDemoShopUser() {
        return given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParams(initParams())
                .cookie(TOKEN, COOKIE_VALUE)
                .post("https://demowebshop.tricentis.com/register")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookie("NOPCOMMERCE.AUTH");
    }

}
