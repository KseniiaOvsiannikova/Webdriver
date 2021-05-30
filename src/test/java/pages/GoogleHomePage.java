package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        return new GoogleSearchResultsPage(driver);
    }
}
