package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    protected WebDriver driver;
    protected int WAIT_TIMEOUT_SECONDS;
    Logger logger = Logger.getGlobal();

    protected void waitForPageLoad(WebDriver driver) {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(pageLoadCondition);
    }

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void browsersSetup(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver", "src\\test\\resources\\webdrivers\\msedgedriver.exe");
            //create Edge instance
            driver = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //    @BeforeMethod(alwaysRun = true)
//    public void browsersSetup() {
//        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//    }
//
    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
