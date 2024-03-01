package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            output = $("#output"),
            nameOutput = $("#name"),
            emailOutput = $("#email"),
            currentAddressOutput = $("#currentAddress"),
            permanentAddressOutput = $("#permanentAddress"),
            bannerRoot = $(".fc-consent-root");

    @Step("Открываем TextBoxPage")
    public TextBoxPage openPage() {
        open("text-box");
        bannerRoot.$(byText("Consent")).click();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Заполняем поле имя")
    public TextBoxPage setName(String value) {
        userNameInput.setValue(value);
        return this;
    }
    @Step("Заполняем поле email")
    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Вводим адрес регистрации")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Вводим адрес проживания")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Нажать кнопку продолжить")
    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверить заполненные данные")
    public TextBoxPage outputAppear() {
        output.should(appear);
        return this;
    }

    @Step("Поле имя заполнено значением {value}")
    public TextBoxPage nameHasValue(String value) {
        nameOutput.shouldHave(text(value));
        return this;
    }

    @Step("Поле email заполнено значением {value}")
    public TextBoxPage emailHasValue(String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }
    @Step("Поле адрес регистрации содержит значение {value}")
    public TextBoxPage currentAddressHasValue(String value) {
        currentAddressOutput.shouldHave(value(value));
        return this;
    }
    @Step("Поле адрес проживания содержит значение {value}")
    public TextBoxPage permanentAddressHasValue(String value) {
        permanentAddressOutput.shouldHave(value(value));
        return this;
    }
}
