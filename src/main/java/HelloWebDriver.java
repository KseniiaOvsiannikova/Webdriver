import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public class HelloWebDriver {

        public static void main(String[] args)  {

            WebDriver driver = new ChromeDriver();
            driver.get("http://google.com");
            driver.quit();

            System.setProperty("webdriver.edge.driver", "C:\\Webdriver\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.get("http://google.com");
            driver.quit();

            driver = new FirefoxDriver();
            driver.get("http://google.com");
            driver.quit();
        }
    }
