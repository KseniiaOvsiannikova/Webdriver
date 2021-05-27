package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WikipediaPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='rso']/div[2]//cite")//(xpath = "//cite[text()='https://en.wikipedia.org']")
    private WebElement firstEnglishWikipediaLink;

    @FindBy(xpath = "//div[@id='mp-dyk']//img")
    private WebElement didYouKnowImage;

    //@Override
    protected AbstractPage openPage() {
        return null;
    }

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

//    public WikipediaPage openFirstEnglishWikipediaLink() {
//        firstEnglishWikipediaLink.click();
//        waitForPageLoad(driver);
//        return this;
//    }

    public String contentOfFirstEnglishWikipediaLink() {
        waitForPageLoad(driver);
        return firstEnglishWikipediaLink.getText();
    }

    public WikipediaPage makeScreenshot() {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, didYouKnowImage);
        try {
            ImageIO.write(screenshot.getImage(), "jpg", new File("target\\DidYouKnow.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
//    WebElement didYouKnowImage = driver.findElement(By.xpath(".//div[contains(@id,'dyk')]//img"));
//        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, didYouKnowImage);
//        ImageIO.write(screenshot.getImage(), "jpg", new File("target\\DidYouKnow.jpg"));
}


