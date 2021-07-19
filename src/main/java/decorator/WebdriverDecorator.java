package decorator;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WebdriverDecorator implements WebDriver{

    protected WebDriver decoratedDriver;

    public WebdriverDecorator (WebDriver driver) {
        this.decoratedDriver = driver;
    }

    public void get(String url) {
        decoratedDriver.get(url);
    }

    public String getCurrentUrl() {
        return decoratedDriver.getCurrentUrl();
    }

    public String getTitle() {
        return decoratedDriver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return decoratedDriver.findElements(by);
    }

    public WebElement findElement(By by) {
        Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), decoratedDriver.getCurrentUrl()),
                true);
        return decoratedDriver.findElement(by);
    }

    public String getPageSource() {
        return decoratedDriver.getPageSource();
    }

    public void close() {
        decoratedDriver.close();
    }

    public void quit() {
        decoratedDriver.quit();
    }

    public Set<String> getWindowHandles() {
        return decoratedDriver.getWindowHandles();
    }

    public String getWindowHandle() {
        return decoratedDriver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return decoratedDriver.switchTo();
    }

    public Navigation navigate() {
        return decoratedDriver.navigate();
    }

    public Options manage() {
        return decoratedDriver.manage();
    }
}
