package tests;

import com.codeborne.pdftest.assertj.Assertions;
import models.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;
import static specs.Specifications.*;
import static testData.UserTestData.*;

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
       UserResponse userResponse =  given()
                .spec(request)
                .get("/user/2")
                .then()
                .spec(response200)
               .extract().body().as(UserResponse.class);


       assertThat(userResponse.getSupport().getText())
               .isEqualTo
                       ("To keep ReqRes free, " +
                               "contributions towards server " +
                               "costs are appreciated!");
    }

    @Test
    @Tag("homework")
    void createUserTest() {
        UserData userData = new UserData();
        userData.setJob("guru");
        userData.setName("zhanna");
        UserData response = given()
                .spec(request)
                .body(userData)
                .post("/users")
                .then()
                .spec(response201)
                .extract().body().as(UserData.class);

        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDate = simpleDateFormat.format(new Date());
        Assertions.assertThat(response.getCreatedAt()).contains(expectedDate);
    }

    @Test
    void updateUserTest() {
        UserData userData = new UserData();
        userData.setName(fullname);
        userData.setJob(hobby);
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
