package StepDefinitions;

import Context.ScenarioContext;
import Utils.Base;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    /** Runs before every scenario — starts the browser and clears shared state. */
    @Before(order = 1)
    public void setUp() {
        Base.initDriver("chrome", "https://ndosisimplifiedautomation.vercel.app/");
        scenarioContext.reset(); // FIX: prevents state leaking between scenarios
    }

    /** Runs after every scenario — quits the browser. */
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture a screenshot on failure and attach to the Cucumber report
            try {
                byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) Base.getDriver())
                        .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot on failure");
            } catch (Exception e) {
                System.err.println("Could not capture screenshot: " + e.getMessage());
            }
        }
        Base.quitDriver(); // FIX: browser was never closed before
    }

    // ── Tagged hooks for DB scenarios ────────────────────────────────────────

    @Before("@db")
    public void beforeDbScenario() {
        System.out.println("Starting DB scenario setup...");
    }

    @After("@db")
    public void afterDbScenario() {
        System.out.println("Finished DB scenario...");
    }
}



