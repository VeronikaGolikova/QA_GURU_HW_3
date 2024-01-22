package toolsqatests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class FillTextBoxTests extends TestBase {

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
