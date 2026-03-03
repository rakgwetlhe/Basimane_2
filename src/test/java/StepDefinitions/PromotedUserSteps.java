package StepDefinitions;

import Context.ScenarioContext;
import Utils.DBConnection;
import io.cucumber.java.en.Given;

public class PromotedUserSteps {

    private final DBConnection dbConnection;
    private final ScenarioContext scenarioContext;

    public PromotedUserSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
        this.dbConnection = dbConnection;
        this.scenarioContext = scenarioContext;
    }

    @Given("a user has been promoted to Admin")
    public void a_user_has_been_promoted_to_Admin() {
        // Attempt to fetch the latest promoted admin's credentials from DB
        String[] creds = dbConnection.getLatestPromotedAdminCredentials();
        if (creds != null && creds.length == 2) {
            scenarioContext.setEmail(creds[0]);
            scenarioContext.setPassword(creds[1]);
        } else {
            // If DB did not return credentials, leave context as-is. Tests depending on this should ensure
            // the promoted user was created in the same scenario or that DB contains the expected user.
            System.out.println("No promoted admin found in DB to populate scenario context.");
        }
    }
}
