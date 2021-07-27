package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    protected static final long WAIT_TIMEOUT_SECONDS = 50;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract AbstractPage openPage();

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected void waitForPageLoad(WebDriver driver) {

        ExpectedCondition<Boolean> pageLoadCondition = (ExpectedCondition) driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(pageLoadCondition);
    }

    protected boolean waitForElementIsPresent(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOf(element));

        return element.isEnabled();
    }

    protected WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    protected boolean isElementDisplayed (By by) {
        return !findElements(by).isEmpty();
    }
}

