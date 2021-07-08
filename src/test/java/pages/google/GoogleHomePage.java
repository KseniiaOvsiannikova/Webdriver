package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static service.URLCreator.fromPropertyGOOGLE_URL;

public class GoogleHomePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleHomePage openPage() {
        driver.get(fromPropertyGOOGLE_URL());
        waitForPageLoad(driver);

        return this;
    }

    public GoogleSearchResultsPage searchForText() {
        String searchValue = "wikipedia";
        searchInput.sendKeys(searchValue);
        waitForElementIsPresent(searchButton);
        searchButton.click();

        return new GoogleSearchResultsPage(driver);
    }
}
