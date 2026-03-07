package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.AdminPage;
import Services.AuthServices;
import Utils.Base;
import Utils.DBConnection;
import Utils.UserRepository;
import io.cucumber.java.en.*;

public class PromotedUserSteps {

    private final DBConnection dbConnection;
    private final ScenarioContext scenarioContext;

    public PromotedUserSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
        this.dbConnection    = dbConnection;
        this.scenarioContext = scenarioContext;
    }

    @Given("a user has been promoted to Admin")
    public void a_user_has_been_promoted_to_Admin() {
        UserRepository promotedAdmin = dbConnection.getLatestPromotedAdminCredentials();
        if (promotedAdmin != null) {
            scenarioContext.setCurrentUser(promotedAdmin); // single clean call
            System.out.println("Loaded promoted admin from DB: " + promotedAdmin);
        } else {
            // Fall back to whatever was already stored in context from the
            // registration + promotion scenario that ran immediately before this one.
            System.out.println("No promoted admin found in DB — using credentials from ScenarioContext.");
        }
    }
}