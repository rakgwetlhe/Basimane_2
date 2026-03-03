package StepDefinitions;

import Utils.DBConnection;
import io.cucumber.java.*;

public class Hooks {

    private DBConnection dbConnection;

    public Hooks(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    @Before("@db")
    public void beforeScenario() {
        System.out.println("Starting DB scenario setup...");
    }

    @After("@db")
    public void afterScenario() {
        System.out.println("Finished DB scenario...");
    }
}

