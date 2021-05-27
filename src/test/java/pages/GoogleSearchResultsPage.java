package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchResultsPage extends AbstractPage {

    @FindAll({@FindBy(xpath = "//cite[contains(text(), 'wikipedia')]")})
    private List<WebElement> generalSearchResults;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int countSearchResults() {
        waitForPageLoad(driver);
        return generalSearchResults.size();
    }

    public WikipediaPage openFirstEnglishWikipediaLink() {
        return new WikipediaPage(driver);
    }

//    public GoogleSearchResultsPage openPage() {
//        return this;
//    }

//    public GoogleSearchResultsPage openFirstEnglishWikipediaLink() {
//        return this;
//    }
}
