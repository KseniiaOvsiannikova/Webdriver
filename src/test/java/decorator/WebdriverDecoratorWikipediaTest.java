package decorator;

import baseTest.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WikipediaPage;

public class WebdriverDecoratorWikipediaTest extends BaseTest {

    @Test
    public void webdriverDecoratorTest() {

        System.getProperty("browser");
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);
        driver = new WebdriverDecorator(driver);
        String actualWikipediaTitle = new WikipediaPage(driver)
                .openPage()
                .getPageTitle();
        logger.info(String.format("Actual title of Wikipedia Page is %s", actualWikipediaTitle));
        Assert.assertEquals(actualWikipediaTitle, "Wikipedia, the free encyclopedia", "Title is unexpected.");

    }
}
