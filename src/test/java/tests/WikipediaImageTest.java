package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.WikipediaPage;

import java.io.File;

public class WikipediaImageTest extends BaseClass {
    @Test
    public void screenshotExistsBySpecifiedPath() {
        WikipediaPage screenshot = new GoogleHomePage(driver)
                .openPage()
                .searchForText()
                .openFirstEnglishWikipediaLink()
                .makeScreenshot(new WikipediaPage(driver).getDidYouKnowImage())
                .savedScreenshot;

        Assert.assertTrue(new File("target\\DidYouKnow.jpg")
                .exists(), "Screenshot not found by specified path.");
    }
}
