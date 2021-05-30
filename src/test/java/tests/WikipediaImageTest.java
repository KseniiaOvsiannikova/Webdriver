package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.WikipediaPage;

import java.io.File;
import java.io.IOException;

public class WikipediaImageTest extends BaseClass {

    @Test
    public void screenshotExistsBySpecifiedPath() throws IOException {

        logger.info("Test 'screenshotExistsBySpecifiedPath' started.");

        boolean screenshot = new GoogleHomePage(driver)
                .openPage()
                .searchForText()
                .openFirstEnglishWikipediaLink()
                .makeScreenshot(new WikipediaPage(driver).getDidYouKnowImage());

        Assert.assertTrue(new File("target\\DidYouKnow.jpg")
                .exists(), "Screenshot not found by specified path.");
    }
}
