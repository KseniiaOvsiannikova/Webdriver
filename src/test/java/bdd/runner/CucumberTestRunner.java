package bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        strict = true,
        monochrome = true,
        glue = "bdd/steps",
        features = "classpath:features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
