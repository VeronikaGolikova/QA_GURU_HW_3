package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
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
            permanentAddressOutput = $("#permanentAddress");

    public TextBoxPage openPage() {
        open("text-box");
        return this;
    }

    public TextBoxPage setName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage outputAppear() {
        output.should(appear);
        return this;
    }

    public TextBoxPage nameHasValue(String value) {
        nameOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage emailHasValue(String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage currentAddressHasValue(String value) {
        currentAddressOutput.shouldHave(value(value));
        return this;
    }

    public TextBoxPage permanentAddressHasValue(String value) {
        permanentAddressOutput.shouldHave(value(value));
        return this;
    }
}
