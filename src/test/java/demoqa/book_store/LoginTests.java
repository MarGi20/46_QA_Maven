package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import demoqa.utils.RetryAnalyser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // User: margi
    // Pass: qweQwe321$

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getBookStore().hideAds();
        new SidePage(app.driver).selectLogin().hideAds();
    }

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void loginPositivTest() {
        new LoginPage(app.driver)
                .enterPersonalDate("margi", "qweQwe321$")
                .clickOnLoginButton()
                .verifyUserName("margi");
    }
}
