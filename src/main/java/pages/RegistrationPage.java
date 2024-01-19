package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateButton = $("#state"),
            stateCityList = $("#stateCity-wrapper"),
            cityButton = $("#city"),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            modalData = $(".table-responsive"),
            userForm = $("#userForm");

    Calendar calendar = new Calendar();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userPhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage openCalendar(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbieInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city) {
        stateButton.click();
        stateCityList.$(byText(state)).click();
        cityButton.click();
        stateCityList.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage modalAppear(String text) {
        modalDialog.should(appear);
        modalTitle.shouldHave(text(text));
        return this;
    }

    public RegistrationPage modalNotAppear() {
        modalDialog.shouldNot(appear);
        return this;
    }

    public RegistrationPage userFormWasValidated(String cssClass) {
        userForm.shouldHave(cssClass(cssClass));
        return this;
    }

    public RegistrationPage minValueAssertion(String name, String lastname, String phoneNumber, String gender,
                                              String birthday) {
        modalData.shouldHave(text(name), text(lastname),  text(phoneNumber), text(gender), text(birthday));
        return this;
    }

    public RegistrationPage secondaryValueAssertion(String email, String subject, String hobbie, String address,
                                              String location) {
        modalData.shouldHave(text(email), text(subject),  text(hobbie), text(address), text(location));
        return this;
    }
}
