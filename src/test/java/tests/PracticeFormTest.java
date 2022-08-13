package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.io.File;

public class PracticeFormTest {
    PracticeFormPage formPage = new PracticeFormPage();

    @BeforeAll
    static void tearUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //10 sec
        Configuration.browserSize = "1920x1080"; //Submit btn is not clickable without this configuration
    }

    @Test
    @DisplayName("Submit practice form")
    void firstTest() {
        File file = new File("src/main/resources/test_data/Screenshot_3.png");
        formPage.openPage()
                .setFirstName("Tester").setLastName("Tester")
                .setEmail("tester@mail.com")
                .setGender("Male")
                .setMobile("9835559988")
                .setBirthDate("1992", "February", "26")
                .setSubject("Arts").setHobby("Sports")
                .setPicture(file)
                .setAddress("Novosibirsk, Akadem 23/2, 31")
                .setState("Rajasthan").setCity("Jaipur")
                .submit()
                .checkTitle("Thanks for submitting the form")
                .checkValues("Student Name", "Tester Tester")
                .checkValues("Student Email", "tester@mail.com")
                .checkValues("Gender", "Male")
                .checkValues("Mobile", "9835559988")
                .checkValues("Date of Birth", "26 February,1992")
                .checkValues("Subjects", "Arts")
                .checkValues("Hobbies", "Sports")
                .checkValues("Picture", file.getName())
                .checkValues("Address", "Novosibirsk, Akadem 23/2, 31")
                .checkValues("State and City", "Rajasthan Jaipur");
    }
}
