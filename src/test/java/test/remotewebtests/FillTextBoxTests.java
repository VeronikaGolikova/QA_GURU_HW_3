package test.remotewebtests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.DataConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

@Owner("golikovavi")
@Feature("Проверка формы Text Box")
@Tag("regress")
@Tag("owner")
public class FillTextBoxTests extends TestBase{
    DataConfig dataConfig = ConfigFactory.create(DataConfig.class);
    String name = dataConfig.name();
    String email = dataConfig.email();
    String currentAddress = dataConfig.currentAddress();
    String permanentAddress = dataConfig.permanentAddress();

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение всех полей формы Text Box")
    void fillTextBoxWithAllDataTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        textBoxPage.openPage()
                .setName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .outputAppear()
                .nameHasValue(name)
                .emailHasValue(email)
                .currentAddressHasValue(currentAddress)
                .permanentAddressHasValue(permanentAddress);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение полей имя и email в форме Text Box")
    void fillTextBoxWithNameEmailTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        textBoxPage.openPage()
                .setName(name)
                .setEmail(email)
                .submit()
                .outputAppear()
                .nameHasValue(name)
                .emailHasValue(email);
    }

}
