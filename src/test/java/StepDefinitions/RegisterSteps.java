package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.RegisterPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterSteps {

    private final ScenarioContext scenarioContext;
    private final RegisterPage registerPage;

    public RegisterSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.registerPage    = new RegisterPage(Base.getDriver());
    }

    @Given("the user is on the login page for registration")
    public void the_user_is_on_the_login_page_for_registration() {
        // Page is already open from Hooks.setUp() — nothing needed here
    }

    @When("the user clicks on the sign up here button")
    public void the_user_clicks_on_the_sign_up_here_button() {
        registerPage.clickSignUpHereButton();
    }

    @And("the user enters first name {string}")
    public void the_user_enters_first_name(String firstName) {
        registerPage.enterFirstName(firstName);
    }

    @And("the user enters last name {string}")
    public void the_user_enters_last_name(String lastName) {
        registerPage.enterLastName(lastName);
    }

    /**
     * FIX: If the feature passes the placeholder string "<timestamp>", a unique
     * timestamped email is generated automatically. This prevents duplicate-user
     * failures when the same test is run more than once.
     */
    @And("the user enters a valid registration email {string}")
    public void the_user_enters_a_valid_registration_email(String email) {
        if (email.contains("<timestamp>")) {
            email = "user_" + System.currentTimeMillis() + "@test.com";
        }
        registerPage.enterRegistrationEmail(email);
        scenarioContext.setEmail(email); // store for later scenarios
    }

    @And("the user enters a valid passcode {string}")
    public void the_user_enters_a_valid_passcode(String passcode) {
        registerPage.enterPasscode(passcode);
        scenarioContext.setPassword(passcode); // store for later scenarios
    }

    @And("the user confirms the passcode {string}")
    public void the_user_confirms_the_passcode(String passcode) {
        registerPage.enterConfirmPasscode(passcode);
    }

    @And("the user selects a valid group {string}")
    public void the_user_selects_a_valid_group(String group) {
        registerPage.selectGroup(group);
    }

    @And("clicks the create account button")
    public void clicks_the_create_account_button() {
        registerPage.clickCreateAccountButton();
    }

    @Then("the user should see a registration success message")
    public void the_user_should_see_a_registration_success_message() {
        String actualValue   = registerPage.getSignUpSuccessMessage();
        String expectedValue = "Registration submitted successfully. Your account is pending admin approval.";
        Assert.assertEquals(actualValue, expectedValue,
                "Expected: " + expectedValue + ", but got: " + actualValue);
    }
}