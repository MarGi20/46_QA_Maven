package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getForms().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();
    }

    @Test
    public void PracticeFormTest() {
        new PracticeFormPage(app.driver)
                .enterPersonalData("Gal", "Mar", "adming@gmail.com", "123456789")
                .selectGender("Female")
                .chooseDateAsString("04 October 2005")
                //.chooseDate("4", "Oktober", "2005")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHoobies(new String[]{"Sport", "Music"})
                .uploadPicture("/C://Users//march//Pictures//election.jpg/")
                .enterCurrentAdreess("Hauptstrasse, Düsseldorf, DE")
                .enterState("NRC")
                .enterCity("Düsseldorf")
                .submitForm()
                .veritySuccessRegistration("Thanks for submitting the form")
        ;
    }

    @Test
    @Parameters({"firstName", "lastName", "email", "phone" })
    //"Gal", "Mar", "adming@gmail.com", "123456789"
    public void PracticeFormParametersTest(String firstName, String lastName, String email, String phone) {
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName, lastName, email, phone)
                .selectGender("Female")
                .chooseDateAsString("04 October 2005")
                //.chooseDate("4", "Oktober", "2005")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHoobies(new String[]{"Sport", "Music"})
                .uploadPicture("/C://Users//march//Pictures//election.jpg/")
                .enterCurrentAdreess("Hauptstrasse, Düsseldorf, DE")
                .enterState("NRC")
                .enterCity("Düsseldorf")
                .submitForm()
                .veritySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
