package tests;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import util.TestListener;

import java.util.logging.Logger;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = Logger.getGlobal();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void browsersSetup(@Optional("chrome") String browser) {
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.closeDriver();
    }
}
