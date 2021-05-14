import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


public class WebDriverScenarioWithTests {

        private WebDriver driver;
        Logger logger = Logger.getGlobal();

        @BeforeMethod(alwaysRun = true)
        public void browserSetup() {
        driver = new ChromeDriver();
    }

        @Test(description = "JIRA binding can be here")
        public void commonFlow() throws IOException {

            ExpectedCondition<Boolean> pageLoadCondition = new
                    ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                        }
                    };
            WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://google.com");
        driver.manage().window().maximize();
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("wikipedia");
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@name='btnK']"))).click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//cite[contains(text(),'wikipedia')]"));
        logger.info(String.format("Search results number for requested text: %s", searchResults.size()));

        //3. Validation
        WebElement firstElementOfSearchResults = driver.findElement(By.xpath("//cite[@class='iUh30 Zu0yb qLRx3b tjvcx']"));
        String contentOfFirstSearchResult = firstElementOfSearchResults.getText();
        new WebDriverWait(driver, 50).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//cite[contains(text(),'wikipedia')]")));
        logger.info(String.format("First element of search results is %s", contentOfFirstSearchResult));
            wait.until(pageLoadCondition);
        Assert.assertTrue(contentOfFirstSearchResult.contains("wikipedia"), "First element of search results do not contain expected text.");

        //4. Navigate to https://en.wikipedia.org via first found link
        WebElement firstEnglishWikipediaLink = driver.findElement(By.xpath("//cite[text()='https://en.wikipedia.org']"));
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//cite[text()='https://en.wikipedia.org']")));
        String contentOfFirstEnglishWikipediaLink = firstEnglishWikipediaLink.getText();
        firstEnglishWikipediaLink.click();
            wait.until(pageLoadCondition);

        //5. Assert that we are currently on wikipedia page;
        logger.info(String.format("The link clicked is %s", contentOfFirstEnglishWikipediaLink));

        Assert.assertTrue(contentOfFirstEnglishWikipediaLink.contains("wikipedia"), "The element is clicked do not contains expected text.");

        //6. Get Page Title name and Title length -> Print Page Title and Title length on the Console via logger;
        String titleOfClickedEnglishWikipediaLink = driver.getTitle();
        int titleLength = titleOfClickedEnglishWikipediaLink.length();
        logger.info("The title of clicked link is " + titleOfClickedEnglishWikipediaLink
                + ".\n Title length is " + titleLength + " symbols.");

        //7. Get Page URL and verify if the it is a correct page opened;
        String clickedURL = driver.getCurrentUrl();

        Assert.assertTrue(clickedURL.contains("wikipedia"), "The opened link do not content expected text.");

        //8. Print Page Length on Console via logger;
        long clickedURLLength = clickedURL.length();
        logger.info("The full page URL is clicked contains " + clickedURLLength + " symbols.");

        //9. Take Screenshot of the first Image  in the “Did you know...” container

            wait.until(pageLoadCondition);

        WebElement didYouKnowImage = driver.findElement(By.xpath(".//div[contains(@id,'dyk')]//img"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, didYouKnowImage);
        ImageIO.write(screenshot.getImage(), "jpg", new File("target\\DidYouKnow.jpg"));

            Assert.assertTrue (new File("target\\DidYouKnow.jpg")
                    .exists(), "Screenshot not found by specified path.");

        //10. Via wikipedia search, find 'Test Automation' and verify if search result is correct
        WebElement wikipediaSearchInput = driver.findElement(By.name("search"));
        wikipediaSearchInput.sendKeys("Test Automation");
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .elementToBeClickable(By.name("go"))).click();

        WebElement wikipediaSearchResult = driver.findElement(By.xpath("//h1[@id='firstHeading']"));
        logger.info(String.format("Wikipedia Search Result is %s", wikipediaSearchResult));
        String contentOfWikipediaSearchResult = wikipediaSearchResult.getText();
        logger.info("Wikipedia Search Result is " + contentOfWikipediaSearchResult);

        Assert.assertFalse(contentOfWikipediaSearchResult.contains("Test Automation"), "The search result do not content expected text.");
    }

        @AfterMethod(alwaysRun = true)
        public void browserTearDown() {
            driver.quit();
            driver = null;
    }
}

