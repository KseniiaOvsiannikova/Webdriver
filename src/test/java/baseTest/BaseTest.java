package baseTest;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public void browsersSetup() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.closeDriver();
    }
}
