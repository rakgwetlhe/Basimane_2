package StepDefinitions;

import Context.ScenarioContext;
import Utils.Base;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks extends Base {

    private ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void beforeScenario(Scenario scenario) {

        System.out.println("=================================");
        System.out.println("Starting Scenario: " + scenario.getName());
        System.out.println("=================================");

        // Start WebDriver
        WebDriver driver = getDriver();

        // Reset context values
        scenarioContext.setEmail(null);
        scenarioContext.setPassword(null);
    }

    @After
    public void afterScenario(Scenario scenario) {

        System.out.println("Ending Scenario: " + scenario.getName());

        WebDriver driver = getDriver();

        if (driver != null) {
            driver.quit();
        }
    }
}



