package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage typeInSearchFieldInput(String text) {
        typeScrollWithJS(searchBox, text, 300);
        return this;
    }

    @FindBy(css= ".mr-2>a")
    WebElement searchResult;

    public BookStorePage verifyText(String expectedText) {
        String actualText = searchResult.getText();
        Assert.assertTrue(actualText.contains(expectedText),
        "Ожидлось: [" +expectedText + "], но было получено: [" + actualText + "]");
        //assert searchResult.getText().contains(text);
        return this;
    }
}
