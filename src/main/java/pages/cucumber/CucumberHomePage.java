package pages.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static service.URLCreator.fromPropertyCUCUMBER_URL;

public class CucumberHomePage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'nav-link')]")
    public WebElement menuDropdownSection;

    @FindBy(xpath = "//a[contains(@href,'/tools/cucumber-open')]")
    public WebElement dropdownItem;

    public CucumberHomePage(WebDriver driver) {
        super(driver);
    }

    public CucumberHomePage openPage() {
        driver.get(fromPropertyCUCUMBER_URL());
        waitForPageLoad(driver);

        return this;
    }
}
