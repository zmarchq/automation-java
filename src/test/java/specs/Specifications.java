package specs;

import helpers.CustomApiListener;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specifications {
    private static final String BASE_URI = "https://reqres.in/api";
    private static final Filter customAllureFilter = CustomApiListener.withCustomTemplates();

    public static RequestSpecification request = with()
            .filter(customAllureFilter)
            .baseUri(BASE_URI)
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification response200 = with()
            .filter(customAllureFilter)
            .log().all()
            .expect().statusCode(200);


    public static ResponseSpecification response201 = with()
            .filter(customAllureFilter)
            .expect().statusCode(201)
            .log().all();

    public static ResponseSpecification response400 = with()
            .filter(customAllureFilter)
            .expect().statusCode(400)
            .log().all();
}
