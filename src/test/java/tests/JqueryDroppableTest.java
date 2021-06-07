package tests;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JqueryuiDroppablePage;

public class JqueryDroppableTest extends BaseClass {
    private Point targetPosition;

    @Test
    public void dragAndDropElementToTarget() {

        logger.info("Test 'dragAndDropElementToTarget' started.");

        Point actualPositionInTheFrame = new JqueryuiDroppablePage(driver)
                .openPage()
                .dragAndDropToTarget()
                .highlightTheDraggedElement()
                .getPositionInTheFrame();

        logger.info(String.format("Position of the element: %s", actualPositionInTheFrame));
        Assert.assertEquals(actualPositionInTheFrame, targetPosition, "Element is not in the target position.");
    }
}
