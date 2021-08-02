package bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        strict = true,
        monochrome = true,
        tags = "@smoke",
        glue = "bdd",
        features = "classpath:features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
