package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.LoginPage;
import Services.AuthServices;
import Utils.Base;
import Utils.DBConnection;
import Utils.UserRepository;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

    private final ScenarioContext scenarioContext;
    private final DBConnection dbConnection;

    public LoginSteps(ScenarioContext scenarioContext, DBConnection dbConnection) {
        this.scenarioContext = scenarioContext;
        this.dbConnection    = dbConnection;
        // DO NOT instantiate page objects here — driver is null at construction time.
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Base.loginPage().clickNavLoginButton();
    }

    @When("the user logs in using stored credentials")
    public void the_user_logs_in_using_stored_credentials() {
        String email    = scenarioContext.getEmail();
        String password = scenarioContext.getPassword();

        if (email == null || password == null) {
            // Context is empty — this is the admin login scenario.
            // Load the existing admin account credentials from the database.
            UserRepository adminUser = dbConnection.getAdminCredentials();
            if (adminUser == null) {
                throw new IllegalStateException(
                        "No credentials in ScenarioContext and no admin user found in DB. " +
                                "Ensure an admin account exists in the database."
                );
            }
            email    = adminUser.getEmail();
            password = adminUser.getPassword();
            scenarioContext.setCurrentUser(adminUser);
        }

        new AuthServices().loginAs(email, password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        Base.loginPage().clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String actualValue   = Base.loginPage().getLoginSuccessMessage();
        String expectedValue = "Welcome back, ! \uD83D\uDC4B";
        Assert.assertEquals(actualValue, expectedValue,
                "Expected: " + expectedValue + ", but got: " + actualValue);
    }
}
