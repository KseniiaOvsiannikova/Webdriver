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

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org";

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='mp-dyk']//img")
    private WebElement didYouKnowImage;

    public WikipediaPage openPage() {
        driver.get(WIKIPEDIA_URL);
        driver.manage().window().maximize();
        waitForPageLoad(driver);

        return this;
    }

    public boolean makeScreenshot(WebElement element) throws IOException {
        waitForPageLoad(driver);
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);

        return ImageIO.write(screenshot.getImage(), "jpg", new File("target\\DidYouKnow.jpg"));
    }

    public WebElement getDidYouKnowImage() {
        return didYouKnowImage;
    }
}

