package tests;

import models.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static specs.Specifications.*;
import static testdata.UserTestData.*;

public class SelenoidApiTest {
    @Test
    @Tag("homework")
    void listUsersTest() {
        UserListResponse userListResponse = given()
                .spec(request)
                .get("/users")
                .then()
                .spec(response200)
                .extract().body().as(UserListResponse.class);

        assertThatList(userListResponse.getData()).doesNotContainNull();
    }

    @Test
    @Tag("homework")
    void singleUserTest() {
        given()
                .spec(request)
                .get("/user/2")
                .then().log().all()
                .spec(response200)
                .body("support.text", comparesEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    @Test
    @Tag("homework")
    void createUserTest() {
        UserData userData = UserData.builder().job("guru").name("zhanna").build();
        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDate = simpleDateFormat.format(new Date());
        given()
                .spec(request)
                .body(userData)
                .post("/users")
                .then()
                .spec(response201)
                .body("createdAt", Matchers.stringContainsInOrder(expectedDate));

    }

    @Test
    void updateUserTest() {
        UserData userData = UserData.builder().name(fullname).job(hobby).build();
        UserData response = given()
                .spec(request)
                .body(userData)
                .put("/user/2")
                .then()
                .spec(response200)
                .extract().body().as(UserData.class);

        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDate = simpleDateFormat.format(new Date());
        assertThat(response.getUpdatedAt()).contains(expectedDate);
    }

    @Test
    void unsuccessfulRegisterTest() {
        AuthBody authBody = new AuthBody();
        authBody.setEmail(email);
        authBody.setPassword(password);
        AuthResponse response = given()
                .spec(request)
                .body(authBody)
                .when()
                .post("/register")
                .then()
                .spec(response400)
                .extract().response().as(AuthResponse.class);

        assertThat(
                response.getError())
                .isEqualTo(
                        "Note: Only defined users " +
                                "succeed registration");
    }
}
