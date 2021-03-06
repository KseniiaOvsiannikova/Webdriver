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

import static service.URLCreator.fromPropertyWIKIPEDIA_URL;

public class WikipediaPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='mp-dyk']//img")
    private WebElement didYouKnowImage;

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public WikipediaPage openPage() {
        driver.get(fromPropertyWIKIPEDIA_URL());
        waitForPageLoad(driver);

        return this;
    }

    public boolean makeAndSaveScreenshot(WebElement element) throws IOException {
        waitForPageLoad(driver);
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);

        return ImageIO.write(screenshot.getImage(), "jpg", new File("target\\DidYouKnow.jpg"));
    }

    public WebElement getDidYouKnowImage() {
        return didYouKnowImage;
    }
}

