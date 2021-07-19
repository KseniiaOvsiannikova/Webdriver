package decorator;

import baseTest.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import static service.URLCreator.fromPropertyGOOGLE_URL;

public class WebdriverDecoratorGoogleTest extends BaseTest {


    @Test
    public void webdriverDecoratorTest() {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);
        driver = new WebdriverDecorator(driver);
        driver.navigate().to(fromPropertyGOOGLE_URL());
        String actualGoogleTitle = driver.getTitle();
        logger.info(String.format("Actual title of Gooqle Page is %s", actualGoogleTitle));
        Assert.assertEquals(actualGoogleTitle, "Google", "Title is unexpected.");
        driver.quit();
    }
}
