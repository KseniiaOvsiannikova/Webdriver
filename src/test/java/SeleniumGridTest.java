import baseTest.BaseTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest extends BaseTest {

    @Test
    public void seleniumRemoteTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), capabilities);

        driver.get("https://mail.google.com");
    }
}
