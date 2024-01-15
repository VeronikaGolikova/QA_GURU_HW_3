package toolsqatests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class fillToolsQaFormTests {

    @Test
    void fillToolsQaFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(byId("firstName")).setValue("Veronika");
        $(byId("lastName")).setValue("Golikova");
        $(byId("userEmail")).setValue("someEmail@mail.ru");
        $("#gender-radio-2").sibling(0).click();
        $("#userNumber").setValue("7909111111");
        $(byId("dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--007").click();
        $(byId("subjectsInput")).setValue("math").pressEnter();
        $("#hobbies-checkbox-2").sibling(0).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $(byId("currentAddress")).setValue("Чертановская 41");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Veronika"), text("Golikova"),
                text("someEmail@mail.ru"), text("7909111111"), text("Female"), text("07 July,1990"),
                text("Maths"), text("Reading"), text("Чертановская 41"), text("NCR Noida"));
    }
}
