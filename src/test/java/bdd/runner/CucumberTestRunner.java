package bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber-reports/CucumberTests.json",
                "testng:target/cucumber-reports/CucumberTests.xml",
                "json:target/Cucumber.json",
                "html:target/cucumber-html-report"},
        strict = true,
        monochrome = true,
        glue = "bdd/steps",
        features = "classpath:features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
