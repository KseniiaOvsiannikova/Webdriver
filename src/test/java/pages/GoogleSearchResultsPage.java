package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GoogleSearchResultsPage extends AbstractPage{

    @FindAll({@FindBy(xpath = "//cite[contains(text(), 'wikipedia')]")})
    private List<WebElement> generalSearchResults;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int countSearchResults() {
        waitForPageLoad(driver);
        waitForPageLoad(driver);
        return generalSearchResults.size();
    }

    public GoogleSearchResultsPage openPage() {
        return this;
    }
}
