package pages;

import components.DatePicker;
import components.Table;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPage {

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setMobile(String mobile) {
        $("#userNumber").setValue(mobile);
        return this;
    }

    public PracticeFormPage setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        new DatePicker().setDate(year, month, day);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage setPicture(File picture) {
        $("#uploadPicture").uploadFile(picture);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public PracticeFormPage setState(String state) {
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    public PracticeFormPage setCity(String city) {
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public Table submit() {
        $("#submit").click();
        return new Table();
    }
}
