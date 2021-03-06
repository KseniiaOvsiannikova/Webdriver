package bdd.steps;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.cucumber.CucumberToolsPage;
import pages.cucumber.CucumberHomePage;
import ru.yandex.qatools.allure.annotations.Step;

public class StepDefinitions {

    @After
    public void closeBrowser() {
        DriverManager.closeDriver();
    }

    @Step("Given: The user opens Cucumber website")
    @Given("The user opens Cucumber website")
    public void openCucumberWebsite() {
        new CucumberHomePage(DriverManager.getDriver()).openPage();
    }

    @Step("When: The user clicks on the concrete section")
    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        new CucumberHomePage(DriverManager.getDriver()).menuDropdownSection.click();
    }

    @Step("When: The user clicks on the concrete item")
    @When("the user clicks on the {string} item")
    public void clickOnItem(String item) {
        new CucumberHomePage(DriverManager.getDriver()).dropdownItem.click();
    }

    @Step("Then: Page with proper title is displayed")
    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String actualPageTitle) {
        Assert.assertTrue(new CucumberToolsPage(DriverManager.getDriver()).isPageWithTitleDisplayed(), "Page with title" + actualPageTitle + "is not displayed");

    }
}
