package bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cucumber.CucumberDocsPage;
import pages.cucumber.CucumberHomePage;

public class MenuSteps {

    private CucumberHomePage cucumberHomePage = new CucumberHomePage();
    private CucumberDocsPage cucumberDocsPage = new CucumberDocsPage();

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
    }

    @When("the user clicks on the {string} item")
    public void clickOnItem(String item) {
    }

    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
    }
}
