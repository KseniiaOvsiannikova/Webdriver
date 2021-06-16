package tests.wikipedia;

import model.Link;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WikipediaPage;
import service.URLCreator;
import tests.BaseClass;

import java.io.File;
import java.io.IOException;

public class WikipediaImageTest extends BaseClass {

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
