package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
            features = "src/test/resources/Features",
            glue = "StepDefinitions",
            plugin = {
                "pretty",
                "html:Reports/cucumber-reports.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
            monochrome = true,
            publish = true
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
}
