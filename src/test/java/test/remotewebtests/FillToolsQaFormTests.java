package test.remotewebtests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

import static utils.RandomUtils.getRandomDate;
import static utils.RandomUtils.getRandomInt;

@Owner("golikovavi")
@Feature("Проверка формы Tools Qa")
@Tag("regress")
public class FillToolsQaFormTests extends TestBase{

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
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Заполнение всех полей формы")
    void fillToolsQaFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение обязательных полей формы")
    void fillToolsQaFormWithMinDataTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации при незаполненных обязательных полях")
    void fillToolsQaFormNegativeTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .submit()
                .modalNotAppear()
                .userFormWasValidated(validated);
    }
}
