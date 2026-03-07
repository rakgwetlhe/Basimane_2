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
        // Pass the email stored during the promotion scenario so DBConnection
        // can look up the full credentials without needing a role column.
        String promotedEmail = scenarioContext.getEmail();
        UserRepository promotedAdmin = dbConnection.getLatestPromotedAdminCredentials(promotedEmail);

        if (promotedAdmin != null) {
            scenarioContext.setCurrentUser(promotedAdmin);
            System.out.println("[PromotedUserSteps] Loaded promoted admin: " + promotedAdmin);
        } else {
            throw new IllegalStateException(
                    "Could not load promoted admin credentials for email: " + promotedEmail +
                            ". Ensure the user was registered and promoted in the previous scenario."
            );
        }
    }
}