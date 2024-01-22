package toolsqatests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillToolsQaFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillToolsQaFormTest() {
        registrationPage.openPage()
                .setFirstName("Veronika")
                .setLastName("Golikova")
                .setEmail("someEmail@mail.ru")
                .setGender("Female")
                .setPhoneNumber("7909111111")
                .openCalendar("07", "July", "1990")
                .setSubject("math")
                .setHobbie("Reading")
                .uploadPicture("1.png")
                .setAddress("Чертановская 41")
                .selectStateAndCity("NCR", "Noida")
                .submit()
                .modalAppear("Thanks for submitting the form")
                .minValueAssertion("Veronika", "Golikova", "7909111111", "Female",
                        "07 July,1990")
                .secondaryValueAssertion("someEmail@mail.ru", "Maths", "Reading",
                        "Чертановская 41","NCR Noida");
    }

    @Test
    void fillToolsQaFormWithMinDataTest() {
        registrationPage.openPage()
                .setFirstName("Veronika")
                .setLastName("Golikova")
                .setGender("Female")
                .setPhoneNumber("7909111111")
                .openCalendar("07", "July", "1990")
                .submit()
                .modalAppear("Thanks for submitting the form")
                .minValueAssertion("Veronika", "Golikova", "7909111111", "Female",
                        "07 July,1990");
    }

    @Test
    void fillToolsQaFormNegativeTest() {
        registrationPage.openPage()
                .setFirstName("Veronika")
                .setLastName("Golikova")
                .setEmail("someEmail@mail.ru")
                .submit()
                .modalNotAppear()
                .userFormWasValidated("was-validated");
    }
}
