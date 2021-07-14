import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TutorialspointPage;

public class TutorialspointSearchResultsTest extends BaseTest {

    @Test
    public void searchResultsNumberIsGraterThanHundred() {

        logger.info("Test 'searchResultsNumberIsGraterThanHundred' started.");

        int expectedTutorialspointSearchResultsNumber = new TutorialspointPage(driver)
                .openPage()
                .searchForPhrase()
                .countTutorialspointSearchResults();

        logger.info(String.format("Search results number for requested text: %s", expectedTutorialspointSearchResultsNumber));
        Assert.assertTrue(expectedTutorialspointSearchResultsNumber > 100, "Search results number is lower than 100.");
    }
}
