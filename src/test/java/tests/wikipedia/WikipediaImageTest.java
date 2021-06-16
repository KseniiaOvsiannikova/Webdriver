package tests.wikipedia;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WikipediaPage;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;

public class WikipediaImageTest extends BaseTest {

    @Test
    public void screenshotExistsBySpecifiedPath() throws IOException {

        logger.info("Test 'screenshotExistsBySpecifiedPath' started.");

        //String WIKIPEDIA_URL = URLCreator.fromProperty();
        boolean screenshot = new WikipediaPage(driver)
                .openPage()
                .makeAndSaveScreenshot(new WikipediaPage(driver).getDidYouKnowImage());

        Assert.assertTrue(new File("target\\DidYouKnow.jpg")
                .exists(), "Screenshot not found by specified path.");
    }
}
