package toolsqatests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TextBoxPage;

public class FillTextBoxTests {

    @BeforeEach
    void baseSteps() {
        textBoxPage.openPage()
                .setName("Veronika")
                .setEmail("someEmail@mail.ru");
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillTextBoxWithAllDataTest() {
        textBoxPage
                .setCurrentAddress("Чертановская 41")
                .setPermanentAddress("Чертановская 42")
                .submit()
                .outputAppear()
                .nameHasValue("Veronika")
                .emailHasValue("someEmail@mail.ru")
                .currentAddressHasValue("Чертановская 41")
                .permanentAddressHasValue("Чертановская 42");
    }

    @Test
    void fillTextBoxWithNameEmailTest() {
        textBoxPage
                .submit()
                .outputAppear()
                .nameHasValue("Veronika")
                .emailHasValue("someEmail@mail.ru");
    }

}
