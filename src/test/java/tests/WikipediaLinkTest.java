package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class WikipediaLinkTest extends BaseClass {

    @Test
    public void firstEnglishWikipediaLinkContains() {
        String contentOfFirstEnglishWikipediaLink = new GoogleHomePage(driver)
                .openPage()
                .searchForText()
                .openFirstEnglishWikipediaLink()
                .contentOfFirstEnglishWikipediaLink();

        logger.info(String.format("The link clicked is %s", contentOfFirstEnglishWikipediaLink));
        Assert.assertTrue(contentOfFirstEnglishWikipediaLink.contains("wikipedia"), "The link is clicked do not contains expected text.");
    }
}