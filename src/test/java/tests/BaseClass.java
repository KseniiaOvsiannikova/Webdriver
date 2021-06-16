package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.sql.DriverManager;
import java.util.logging.LogManager;
import java.util.logging.Logger;

//@Listeners({TestListener.class})
public class BaseClass {

    protected WebDriver driver;
    protected Logger logger = Logger.getGlobal();
    //protected final Logger logger = LogManager.getRootLogger();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void browsersSetup(@Optional("chrome") String browser) throws Exception {
        //driver = DriverManager.browsersSetup();
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
