package tests.jquery;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JqueryuiDroppablePage;
import tests.BaseTest;

public class JqueryDroppableTextChangeTest extends BaseTest {
    @Test
    public void verifyTextAfterDragAndDrop() {

        logger.info("Test 'verifyTextAfterDragAndDrop' started.");

        String actualTargetText = new JqueryuiDroppablePage(driver)
                .openPage()
                .dragAndDropToTarget()
                .highlightTheDraggedElement()
                .getActualTargetText();

        logger.info(String.format("Text in the target is: %s", actualTargetText));
        Assert.assertEquals(actualTargetText, "Dropped!", "Text in the target does not tell the dragging is successful.");
    }
}
