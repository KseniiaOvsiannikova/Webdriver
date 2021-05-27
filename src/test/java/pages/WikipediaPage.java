package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaPage extends AbstractPage {

        @FindBy(xpath = "//cite[text()='https://en.wikipedia.org']")
        private WebElement firstEnglishWikipediaLink;

        @Override
        protected AbstractPage openPage() {
        return null;
    }

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public WikipediaPage openFirstEnglishWikipediaLink() {
        firstEnglishWikipediaLink.click();
        waitForPageLoad(driver);
        return this;
    }
    public String contentOfFirstEnglishWikipediaLink(){
        waitForPageLoad(driver);
        return firstEnglishWikipediaLink.getText();
    }

}


