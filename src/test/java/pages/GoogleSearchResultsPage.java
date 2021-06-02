package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchResultsPage extends AbstractPage {

    @FindAll({@FindBy(xpath = "//cite[contains(text(), 'wikipedia')]")})
    private List<WebElement> generalSearchResults;

    @FindBy(xpath = "//div[@id='rso']/div[2]//cite")
    private WebElement firstEnglishWikipediaLink;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    protected GoogleSearchResultsPage openPage() {
        return this;
    }

    public String contentOfFirstEnglishWikipediaLink() {
        waitForPageLoad(driver);

        return firstEnglishWikipediaLink.getText();
    }

    public int countSearchResults() {
        waitForPageLoad(driver);

        return generalSearchResults.size();
    }
}
