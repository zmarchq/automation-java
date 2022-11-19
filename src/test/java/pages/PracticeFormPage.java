package pages;

import entities.components.DatePicker;
import collections.Table;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPage {

    @Step("Открыть страницу automation-practice-form")
    public PracticeFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Ввести имя пользователя")
    public PracticeFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию пользователя")
    public PracticeFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step("Ввести email")
    public PracticeFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Ввести пол")
    public PracticeFormPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    @Step("Ввести номер телефона")
    public PracticeFormPage setMobile(String mobile) {
        $("#userNumber").setValue(mobile);
        return this;
    }

    @Step("Ввести дату рождения")
    public PracticeFormPage setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        new DatePicker().setDate(year, month, day);
        return this;
    }

    @Step("Ввести предмет")
    public PracticeFormPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    @Step("Ввести хобби")
    public PracticeFormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузить аватар")
    public PracticeFormPage setPicture(File picture) {
        $("#uploadPicture").uploadFile(picture);
        return this;
    }

    @Step("Ввести адрес")
    public PracticeFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }
    @Step("Ввести штат")
    public PracticeFormPage setState(String state) {
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    @Step("Ввести город")
    public PracticeFormPage setCity(String city) {
        $("#city").click();
        $(byText(city)).click();
        return this;
    }
    @Step("Нажать Принять")
    public Table submit() {
        $("#submit").click();
        return new Table($("table"));
    }
}
