package test.toolsqatests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

import static utils.RandomUtils.*;

public class FillToolsQaFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("ru"));
    Faker enFaker = new Faker();
    RandomUtils randomUtils = new RandomUtils();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = enFaker.internet().emailAddress(),
            address = faker.address().streetAddress(),
            gender = randomUtils.getRandomGender(),
            phoneNumber = randomUtils.getRandomPhoneNumber(10),
            month = randomUtils.getRandomMonth(),
            date = getRandomDate(),
            year = String.valueOf(getRandomInt(1950, 2010)),
            subject = randomUtils.getRandomLetterForSubj(),
            hobbie = randomUtils.getRandomHobbie(),
            state = randomUtils.getRandomState(),
            city = randomUtils.getRandomCity(state),
            picture = "1.png",
            message = "Thanks for submitting the form",
            validated = "was-validated";

    @Test
    void fillToolsQaFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .openCalendar(date, month, year)
                .setSubject(subject)
                .setHobbie(hobbie)
                .uploadPicture(picture)
                .setAddress(address)
                .selectStateAndCity(state, city)
                .submit()
                .modalAppear(message)
                .minValueAssertion(firstName, lastName, phoneNumber, gender,
                        date + " " + month + "," + year)
                .secondaryValueAssertion(email, hobbie,
                        address,state + " " + city);
    }

    @Test
    void fillToolsQaFormWithMinDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .openCalendar(date, month, year)
                .submit()
                .modalAppear(message)
                .minValueAssertion(firstName, lastName, phoneNumber, gender,
                        date + " " + month + "," + year);
    }

    @Test
    void fillToolsQaFormNegativeTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .submit()
                .modalNotAppear()
                .userFormWasValidated(validated);
    }
}
