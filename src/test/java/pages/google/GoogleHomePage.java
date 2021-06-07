package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class GoogleHomePage extends AbstractPage {

    private static final String GOOGLE_URL = "https://google.com";

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleHomePage openPage() {
        driver.get(GOOGLE_URL);
        driver.manage().window().maximize();
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
