package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private static final long WAIT_TIMEOUT_SECONDS = 50;
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    //protected final int WAIT_TEMEOUT_SECONDS = 10;

    protected void waitForPageLoad(WebDriver driver) {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(pageLoadCondition);
    }
//    ExpectedCondition<Boolean> pageLoadCondition = new
//            ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//                }
//            };
//    WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
//wait.until(pageLoadCondition);

    protected AbstractPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
