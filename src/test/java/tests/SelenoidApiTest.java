package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

public class SelenoidApiTest {

    @Test
    @Tag("homework")
    void listUsersTest() {
        given()
                .log().all()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Tag("homework")
    void singleUserTest() {
        given()
                .log().all()
                .when()
                .get("https://reqres.in/api/user/2")
                .then()
                .log().all()
                .body("data.id", is(2));
    }

    @Test
    @Tag("homework")
    void createUserTest() {
        given()
                .log().all()
                .body("{\n" +
                        "    \"name\": \"zhanna\",\n" +
                        "    \"job\": \"guru\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    void updateUserTest() {
        given()
                .log().all()
                .body("{\n" +
                        "    \"name\": \"update\",\n" +
                        "    \"job\": \"guru\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/user/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void unsuccessfulRegisterTest() {
        given()
                .log().all()
                .body("{\n" +
                        "    \"email\": \"qa.guru@reqres.in\",\n" +
                        "    \"password\": \"test1111\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }

    @Test
    @Tag("example")
    void checkTotal() {
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .statusCode(200)
                .body("total", is((20)));
    }
}
