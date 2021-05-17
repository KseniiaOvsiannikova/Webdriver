import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public class HelloWebDriver {

        public static void main(String[] args)  {

            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://google.com");
            driver.quit();

            System.setProperty("webdriver.edge.driver", "src\\test\\resources\\webdrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.get("http://google.com");
            driver.quit();

            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("http://google.com");
            driver.quit();
        }
    }
