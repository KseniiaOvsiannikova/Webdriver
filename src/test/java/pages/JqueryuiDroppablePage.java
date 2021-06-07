package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JqueryuiDroppablePage extends AbstractPage {

    private static final String JQUERY_URL = "https://jqueryui.com/droppable/";

//    @FindBy(xpath = "//iframe[@class='demo-frame']")
//    private WebElement droppableFrame;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement dropHere;

    public JqueryuiDroppablePage(WebDriver driver) {
        super(driver);
    }

    public JqueryuiDroppablePage openPage() {
        driver.get(JQUERY_URL);
        driver.manage().window().maximize();
        waitForPageLoad(driver);

        return this;
    }

    public JqueryuiDroppablePage dragAndDropToTarget() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        waitForPageLoad(driver);
        new Actions(driver).dragAndDrop(draggableElement, dropHere).build().perform();

        return new JqueryuiDroppablePage(driver);
    }

    public Point getPositionInTheFrame() {
        waitForPageLoad(driver);

        return draggableElement.getLocation();
    }
    public Point getTargetPosition() {
        waitForElementIsPresent(dropHere);

        return dropHere.getLocation();
    }

    public String getActualTargetText() {
        waitForPageLoad(driver);

        return dropHere.getText();
    }

    public JqueryuiDroppablePage highlightTheDraggedElement() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", draggableElement);

        return this;
    }
}