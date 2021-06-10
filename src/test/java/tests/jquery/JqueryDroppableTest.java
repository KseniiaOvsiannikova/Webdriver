package tests.jquery;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JqueryuiDroppablePage;
import tests.BaseClass;

public class JqueryDroppableTest extends BaseClass {

    @Test
    public void dragAndDropElementToTarget() {

        logger.info("Test 'dragAndDropElementToTarget' started.");

        String attributeClassName = new JqueryuiDroppablePage(driver)
                .openPage()
                .dragAndDropToTarget()
                .highlightTheDraggedElement()
                .getAttributeHighlight();

        logger.info(String.format("Attribute of DropHere area is %s", attributeClassName));
        Assert.assertTrue(attributeClassName.contains("highlight"), "DropHere area is not highlighted so the element is not in the target position.");
    }
}
