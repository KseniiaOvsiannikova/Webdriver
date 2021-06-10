package tests;

import org.testng.annotations.Test;
import pages.JqueryuiDroppablePage;
import pages.TutorialspointPage;
import pages.WikipediaPage;
import pages.google.GoogleHomePage;

public class NavigationTest extends BaseClass {

    @Test
    public void navigationAndVerifyTest() {

        logger.info("Test 'navigationAndVerifyTest' started.");

        String actualGoogleTitle = new GoogleHomePage(driver)
                .openPage()
                .getPageTitle();
        logger.info(String.format("Actual title of Google Page is %s", actualGoogleTitle));
        softAssert.assertEquals(actualGoogleTitle, "Google", "Title is unexpected.");

        String actualWikipediaTitle = new WikipediaPage(driver)
                .openPage()
                .getPageTitle();
        logger.info(String.format("Actual title of Wikipedia Page is %s", actualWikipediaTitle));
        softAssert.assertEquals(actualWikipediaTitle, "Wikipedia, the free encyclopedia", "Title is unexpected.");

        String actualTutorialspointTitle = new TutorialspointPage(driver)
                .openPage()
                .getPageTitle();
        logger.info(String.format("Actual title of Tutorialspoint Page is %s", actualTutorialspointTitle));
        softAssert.assertTrue(actualTutorialspointTitle.contains("Tutorialspoint"), "Tutorialspoint Page title does not contain the URL title text.");

        String actualJqueryTitle = new JqueryuiDroppablePage(driver)
                .openPage()
                .getPageTitle();
        logger.info(String.format("Actual title of Jquery Page is %s", actualJqueryTitle));
        softAssert.assertTrue(actualJqueryTitle.toLowerCase().contains("Jquery".toLowerCase()), "Jquery Page title does not contain the URL title text.");

        softAssert.assertAll();
    }
}
