package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StackoverflowPage;

public class StackoverflowSearchResultsTest extends BaseClass {

    @Test
    public void searchResultsNumberIsGraterThanHundred() {

        logger.info("Test 'searchResultsNumberIsGraterThanHundred' started.");

        int expectedSearchResultsNumber = new StackoverflowPage(driver)
                .openPage()
                .searchForPhrase()
                .clickOnCaptcha()
                .countStackoverflowSearchResults();

        logger.info(String.format("Search results number for requested text: %s", expectedSearchResultsNumber));
        Assert.assertTrue(expectedSearchResultsNumber > 100, "Search results number is lower than 100.");
    }
}
