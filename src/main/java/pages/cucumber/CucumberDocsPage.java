package pages.cucumber;

import org.openqa.selenium.By;
import pages.AbstractPage;

import static java.lang.String.format;

public class CucumberDocsPage extends AbstractPage {

    private static final String PAGE_TITLE_PATTERN = "//*[@class='page-header']/*[contains(@class,'title') and contains(text(),'%s')]";

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE_PATTERN,title)));
    }
}
