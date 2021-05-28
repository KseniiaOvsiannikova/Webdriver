package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class SearchResultsTest extends BaseClass {

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

