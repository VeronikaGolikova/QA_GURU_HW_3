package toolsqatests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class FillToolsQaFormTests {

    @Test
    void fillToolsQaFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Veronika");
        $("#lastName").setValue("Golikova");
        $("#userEmail").setValue("someEmail@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7909111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--007").click();
        $("#subjectsInput").setValue("math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Чертановская 41");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Veronika"), text("Golikova"), text("someEmail@mail.ru"), text("7909111111"));
        $(".table-responsive").shouldHave(text("Female"), text("07 July,1990"), text("Maths"));
        $(".table-responsive").shouldHave(text("Reading"), text("Чертановская 41"), text("NCR Noida"));
    }
}
