package test.remotewebtests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

@Owner("golikovavi")
@Feature("Проверка формы Text Box")
@Tag("regress")
public class FillTextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение всех полей формы Text Box")
    void fillTextBoxWithAllDataTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение полей имя и email в форме Text Box")
    void fillTextBoxWithNameEmailTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        textBoxPage.openPage()
                .setName("Veronika")
                .setEmail("someEmail@mail.ru")
                .submit()
                .outputAppear()
                .nameHasValue("Veronika")
                .emailHasValue("someEmail@mail.ru");
    }

}
