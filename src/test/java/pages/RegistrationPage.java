package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Calendar;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
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
            userForm = $("#userForm"),
            bannerRoot = $(".fc-consent-root");

    Calendar calendar = new Calendar();
    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("automation-practice-form");
            bannerRoot.$(byText("Consent")).click();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Заполнить поле имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Заполнить поле фамилия")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Заполнить поле email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбрать пол")
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    @Step("Заполнить поле номер телефона")
    public RegistrationPage setPhoneNumber(String value) {
        userPhoneInput.setValue(value);
        return this;
    }
    @Step("Выбрать дату рождения")
    public RegistrationPage openCalendar(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Выбрать предмет")
    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }
    @Step("Заполнить поле хобби")
    public RegistrationPage setHobbie(String value) {
        hobbieInput.$(byText(value)).click();
        return this;
    }
    @Step("Загрузить изображение")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    @Step("Ввести адрес")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    @Step("Выбрать штат и город")
    public RegistrationPage selectStateAndCity(String state, String city) {
        stateButton.click();
        stateCityList.$(byText(state)).click();
        cityButton.click();
        stateCityList.$(byText(city)).click();
        return this;
    }
    @Step("Завершить заполнение формы")
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }
    @Step("Модальное окно появилось")
    public RegistrationPage modalAppear(String text) {
        modalDialog.should(appear);
        modalTitle.shouldHave(text(text));
        return this;
    }
    @Step("Модальное окно не появилось")
    public RegistrationPage modalNotAppear() {
        modalDialog.shouldNot(appear);
        return this;
    }
    @Step("Успешная валидация заполненной формы")
    public RegistrationPage userFormWasValidated(String cssClass) {
        userForm.shouldHave(cssClass(cssClass));
        return this;
    }
    @Step("Проверка валидации формы, заполненной обязательными полями")
    public RegistrationPage minValueAssertion(String name, String lastname, String phoneNumber, String gender,
                                              String birthday) {
        modalData.shouldHave(text(name), text(lastname),  text(phoneNumber), text(gender), text(birthday));
        return this;
    }
    @Step("Проверка валидации формы, заполненной необязательными полями")
    public RegistrationPage secondaryValueAssertion(String email, String hobbie, String address,
                                              String location) {
        modalData.shouldHave(text(email), text(hobbie), text(address), text(location));
        return this;
    }
}
