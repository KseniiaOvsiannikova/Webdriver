package pages.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

import static java.lang.String.format;
import static service.URLCreator.fromPropertyCUCUMBER_URL;

public class CucumberHomePage extends AbstractPage {

    private static final String TEXT_PATTERN = "%s[contains(text(),'%s')]";
    private static final String MENU_SECTION = "//*[contains(@class,'nav-link')]";
    private static final String CHILD_MENU_ITEM = "//*[contains(@class,'dropdown')]//*[contains(@class,'item')]";

    public CucumberHomePage (WebDriver driver) {
        super(driver);
    }

    public CucumberHomePage openPage() {
        driver.get(fromPropertyCUCUMBER_URL());
        waitForPageLoad(driver);

        return this;
    }

    public WebElement menuSection(String linkText) {
        return driver.findElement(By.xpath(format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }

    public WebElement menuItem(String linkText) {
        return driver.findElement(By.xpath(format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
    }
}
