package test.remotewebtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Tag("regress")
public class FillTextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillTextBoxWithAllDataTest() {
        textBoxPage.openPage()
                .setName("Veronika")
                .setEmail("someEmail@mail.ru")
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
        textBoxPage.openPage()
                .setName("Veronika")
                .setEmail("someEmail@mail.ru")
                .submit()
                .outputAppear()
                .nameHasValue("Veronika")
                .emailHasValue("someEmail@mail.ru");
    }

}
