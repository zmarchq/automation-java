package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static testData.UserTestData.*;

public class PracticeFormTest extends TestBase {
    PracticeFormPage formPage = new PracticeFormPage();

    @Test
    @DisplayName("Submit practice form")
    void firstTest() {
        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(year, month, day)
                .setSubject(subject).setHobby(hobby)
                .setPicture(avatar)
                .setAddress(address)
                .setState(state).setCity(city)
                .submit()
                .checkTitle("Thanks for submitting the form")
                .checkValues("Student Name", fullname)
                .checkValues("Student Email", email)
                .checkValues("Gender", gender)
                .checkValues("Mobile", mobile)
                .checkValues("Date of Birth", birthday)
                .checkValues("Subjects", subject)
                .checkValues("Hobbies", hobby)
                .checkValues("Picture", avatar.getName())
                .checkValues("Address", address)
                .checkValues("State and City", stateAndCity);
    }
}