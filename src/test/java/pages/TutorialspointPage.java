package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TutorialspointPage extends AbstractPage {

    private static final String TUTORIALSPOINT_URL = "https://www.tutorialspoint.com/";

    @FindBy(id = "gsc-i-id1")
    private WebElement searchInputArea;

    @FindBy(xpath = ".//div[contains(@id, 'resInfo')]")
    private WebElement searchResults;

    public TutorialspointPage(WebDriver driver) {
        super(driver);
    }

    public TutorialspointPage openPage() {
        waitForPageLoad(driver);

        return this;
    }

    public TutorialspointPage searchForPhrase() {
        String searchValue = "submit() vs click()";
        waitForPageLoad(driver);
        searchInputArea.sendKeys(searchValue, Keys.ENTER);

        return new TutorialspointPage(driver);
    }

    public int countTutorialspointSearchResults() {
        waitForPageLoad(driver);
        waitForElementIsPresent(searchResults);

        return Integer.parseInt(searchResults.getText().split(" ")[1].replaceAll("[\\D]", ""));
    }
}
