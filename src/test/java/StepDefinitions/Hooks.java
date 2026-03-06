package StepDefinitions;

import Utils.Base;
import Utils.DBConnection;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks extends Base {

    private DBConnection dbConnection;

    public Hooks(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Before
    public void beforeScenario(Scenario scenario) {

        System.out.println("=======================================");
        System.out.println("Starting Scenario: " + scenario.getName());
        System.out.println("=======================================");

        // Ensure driver starts
        WebDriver driver = getDriver();
    }

    @Before("@db")
    public void beforeDBScenario(Scenario scenario) {

        System.out.println("Starting DB scenario setup for: " + scenario.getName());

        // Example: Verify DB connection
        if (dbConnection == null) {
            throw new RuntimeException("Database connection is not initialized!");
        }
    }

    @After("@db")
    public void afterDBScenario(Scenario scenario) {

        System.out.println("Finished DB scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        WebDriver driver = getDriver();

        // Capture screenshot on failure
        if (scenario.isFailed()) {

            System.out.println("Scenario Failed: Taking screenshot...");

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        // Close browser after scenario
        if (driver != null) {
            driver.quit();
        }

        System.out.println("Finished Scenario: " + scenario.getName());
    }
}



