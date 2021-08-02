package pages.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class CucumberToolsPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(),'Cucumber Open')]")
    private WebElement actualPageTitle;

    public CucumberToolsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageWithTitleDisplayed() {
        return actualPageTitle.isDisplayed();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
