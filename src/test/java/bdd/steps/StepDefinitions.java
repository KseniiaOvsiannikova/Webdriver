package bdd.steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.cucumber.CucumberToolsPage;
import pages.cucumber.CucumberHomePage;


public class StepDefinitions {

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        new CucumberHomePage(DriverManager.getDriver()).openPage();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection() {
        new CucumberHomePage(DriverManager.getDriver()).menuDropdownSection.click();
    }

    @When("the user clicks on the {string} item")
    public void clickOnItem() {
        new CucumberHomePage(DriverManager.getDriver()).dropdownItem.click();
    }

    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String actualPageTitle) {
        Assert.assertTrue(new CucumberToolsPage(DriverManager.getDriver()).isPageWithTitleDisplayed(), "Page with title" + actualPageTitle + "is not displayed");

    }
}
