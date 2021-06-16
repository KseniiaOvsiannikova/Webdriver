package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;

public class GoogleSearchResultsTest extends BaseTest {

    @Test
    public void searchResultsNumberIsPositive() {

        logger.info("Test 'searchResultsNumberIsPositive' started.");

        int expectedSearchResultsNumber = new GoogleHomePage(driver)
                .openPage()
                .searchForText()
                .countSearchResults();

        logger.info(String.format("Search results number for requested text: %s", expectedSearchResultsNumber));
        Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty.");
    }
}

