package tests;

import org.testng.annotations.Test;

public class NavigationTest extends BaseClass {

    @Test
    public void navigationAndVerifyTest() {

        logger.info("Test 'navigationAndVerifyTest' started.");

        driver.navigate().to("https://google.com");
        String actualGoogleTitle = driver.getTitle();
        boolean verifyGoogleTitle = actualGoogleTitle.equalsIgnoreCase("Google");
        softAssert.assertNotNull(verifyGoogleTitle);
        logger.info(String.format("Actual title of Google Page is %s", actualGoogleTitle));
        softAssert.assertEquals(actualGoogleTitle, "Google", "Title is unexpected.");

        driver.navigate().to("https://en.wikipedia.org");
        String actualWikipediaTitle = driver.getTitle();
        boolean verifyWikipediaTitle = actualWikipediaTitle.equalsIgnoreCase("Wikipedia");
        softAssert.assertNotNull(verifyWikipediaTitle);
        logger.info(String.format("Actual title of Wikipedia Page is %s", actualWikipediaTitle));
        softAssert.assertEquals(actualWikipediaTitle, "Wikipedia, the free encyclopedia", "Title is unexpected.");

        driver.navigate().to("https://www.tutorialspoint.com/");
        String actualTutorialspointTitle = driver.getTitle();
        Boolean verifyTutorianspointTitle = actualTutorialspointTitle.equalsIgnoreCase("Tutorialspoint");
        softAssert.assertNotNull(verifyTutorianspointTitle);
        logger.info(String.format("Actual title of Tutorialspoint Page is %s", actualTutorialspointTitle));
        softAssert.assertTrue(actualTutorialspointTitle.contains("Tutorialspoint"), "Tutorialspoint Page title does not contain the URL title text.");

        driver.navigate().to("https://jqueryui.com/droppable/");
        String actualJqueryTitle = driver.getTitle();
        Boolean verifyJqueryTitle = actualJqueryTitle.equalsIgnoreCase("Jquery");
        softAssert.assertNotNull(verifyJqueryTitle);
        logger.info(String.format("Actual title of Jquery Page is %s", actualJqueryTitle));
        softAssert.assertTrue(actualJqueryTitle.toLowerCase().contains("Jquery".toLowerCase()), "Jquery Page title does not contain the URL title text.");

        softAssert.assertAll();
    }
}
