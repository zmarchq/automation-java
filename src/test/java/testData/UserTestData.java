package testData;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class UserTestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastname = faker.name().lastName(),
            fullname = firstName + " " + lastname,
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress(),
            year = String.valueOf(faker.random().nextInt(1900, 2022)),
            month = Month.of(faker.random().nextInt(1, 12)).getDisplayName(TextStyle.FULL, Locale.UK),
            day = String.valueOf(faker.random().nextInt(10, 28)),
            birthday = String.format("%s %s,%s", day, month, year),
            subject = setSubject(),
            hobby = setHobby(),
            state = setState(),
            city = setCity(),
            stateAndCity = state + " " + city;


    public static File avatar = new File("src/main/resources/test_data/Screenshot_3.png");

    static String setSubject() {
        int random = faker.random().nextInt(0, 3);
        switch (random) {
            case 0:
                return "Physics";
            case 1:
                return "Chemistry";
            case 2:
                return "Commerce";
            case 3:
                return "Accounting";
            default:
                return "English";
        }
    }

    static String setHobby() {
        int random = faker.random().nextInt(0, 2);
        switch (random) {
            case 0:
                return "Sports";
            case 1:
                return "Reading";
            default:
                return "Music";
        }
    }

    static String setState() {
        int random = faker.random().nextInt(0, 3);
        switch (random) {
            case 0:
                return "NCR";
            case 1:
                return "Uttar Pradesh";
            case 2:
                return "Haryana";
            default:
                return "Rajasthan";
        }
    }

    static String setCity() {
        switch (state) {
            case "NCR":
                return "Delhi";
            case "Uttar Pradesh":
                return "Agra";
            case "Haryana":
                return "Karnal";
            default:
                return "Jaipur";
        }
    }
}