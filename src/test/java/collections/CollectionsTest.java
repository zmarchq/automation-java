package collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.PracticeFormPage;

import java.util.stream.Stream;

import static testdata.UserTestData.*;
import static testdata.UserTestData.city;

public class CollectionsTest {
    PracticeFormPage formPage = new PracticeFormPage();

    @Test
    void checkTableMap() {
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
                .checkValueFromCell(0, "Values", fullname)
                .checkValueFromCell(1, 1, email);
    }


    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Student Name", fullname),
                Arguments.of("Student Email", email),
                Arguments.of("Date of Birth", birthday)
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "В строке {0} содержится значение {1}")
    void checkTable(String rowName, String value) {
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
                .checkRowsByName(rowName, value);
    }

    @Test
    void storeTest() {
        Dress simpleDress = new Dress("Blue", "42", "sundress");

        ChristianDior christianDior = new ChristianDior();
        AliExpress aliExpress = new AliExpress();

        christianDior.addNewDress(simpleDress);
        aliExpress.addNewDress(simpleDress);

        christianDior.printColor();
        aliExpress.printSize();
    }
}
