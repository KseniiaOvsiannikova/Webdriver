package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class WikipediaPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='rso']/div[2]//cite")
    private WebElement firstEnglishWikipediaLink;

    @FindBy(xpath = "//div[@id='mp-dyk']//img")
    private WebElement didYouKnowImage;

    protected AbstractPage openPage() {
        return null;
    }

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public String contentOfFirstEnglishWikipediaLink() {
        waitForPageLoad(driver);
        return firstEnglishWikipediaLink.getText();
    }

    public Screenshot makeScreenshot (WebElement element) {
        return new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);
    }

    public WebElement getDidYouKnowImage() {
        return didYouKnowImage;
    }

    public File savedScreenshot(){
        return new ImageIO.write(makeScreenshot.getImage(), "jpg", new File("target\\DidYouKnow.jpg"));
    }
}


