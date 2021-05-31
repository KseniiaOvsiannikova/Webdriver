package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StackoverflowPage extends AbstractPage {

    private static final String STACKOVERFLOW_URL = "https://stackoverflow.com/";

    @FindBy(xpath = "//input[contains(@class, 's-input')]")
    private WebElement searchInputArea;

    @FindBy(xpath = "//label[@id = 'recaptcha-anchor-label']")
    private WebElement captcha;

    @FindBy(xpath = "//div[contains (text(), 'results')]")
    private WebElement searchResults;

    public StackoverflowPage(WebDriver driver) {
        super(driver);
    }

    public StackoverflowPage openPage() {
        driver.get(STACKOVERFLOW_URL);
        driver.manage().window().maximize();
        waitForPageLoad(driver);

        return this;
    }

    public StackoverflowPage searchForPhrase() {
        String searchValue = "submit() vs click()";
        searchInputArea.sendKeys(searchValue, Keys.ENTER);

        return new StackoverflowPage(driver);
    }

    public StackoverflowPage clickOnCaptcha() {
        waitForPageLoad(driver);
        captcha.click();
        return this;
    }

    public int countStackoverflowSearchResults() {
        waitForPageLoad(driver);
        return Integer.parseInt(searchResults.getText());
    }

}
