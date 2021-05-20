import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import java.util.logging.Logger;

public class SearchResultsTest {

    private WebDriver driver;
    Logger logger = Logger.getGlobal();

    @BeforeMethod(alwaysRun = true)
    public void browsersSetup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void commonFlow() {

        int expectedSearchResultsNumber = new GoogleHomePage(driver)
                .openPage()
                .searchForText()
                .countSearchResults();

        logger.info(String.format("Search results number for requested text: %s", expectedSearchResultsNumber));
        Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

