package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://google.com";

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    public GoogleHomePage(WebDriver driver) {super(driver);}

    public GoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        waitForPageLoad(driver);
        return this;
    }

    public GoogleSearchResultsPage searchForText () {
        searchInput.sendKeys("wikipedia");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new GoogleSearchResultsPage(driver);
    }

}
