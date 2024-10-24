package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class TextBoxTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectTextBox().hideAds();
    }

    @Test
    public void keyboardEventTest() throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData("Name", "email@gmail.com","Germany, Düsseldorf")
                .keyboardEvent()
                .verifyCopyPasteAddress()
        ;
    }
    @Test(dataProvider = "addNewUserFormFromCSVFile", dataProviderClass = DataProvider.class)
    public void keyboardEventDataProviderTest(String name, String email, String phone) throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData(name, email,phone)
                .keyboardEvent()
                .verifyCopyPasteAddress()
        ;
    }
}
