package org.example.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/FeatureFile/QKartLogin.feature",
        glue = {"org.example.Test.Stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)


public class TestRunner extends AbstractTestNGCucumberTests {

}
