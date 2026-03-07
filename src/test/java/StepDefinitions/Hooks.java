package StepDefinitions;

import Context.ScenarioContext;
import Utils.Base;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    /** Runs before every scenario — starts the browser and resets shared state. */
    @Before(order = 1)
    public void setUp() {
        Base.initDriver("chrome", "https://ndosisimplifiedautomation.vercel.app/");
        scenarioContext.reset();
    }

    /** Runs after every scenario — captures screenshot on failure, then quits the browser. */
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        WebDriver driver = Base.getDriver();
        if (driver != null && scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot — " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Could not capture screenshot: " + e.getMessage());
            }
        }
        Base.quitDriver();
    }

    // ── Tagged hooks for DB scenarios ─────────────────────────────────────────

    @Before("@db")
    public void beforeDbScenario() {
        System.out.println("Starting DB scenario setup...");
    }

    @After("@db")
    public void afterDbScenario() {
        System.out.println("Finished DB scenario...");
    }
}



