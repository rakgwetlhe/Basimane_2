package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.RegisterPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterSteps {

    private final ScenarioContext scenarioContext;

    public RegisterSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        // DO NOT instantiate page objects here — driver is null at construction time.
    }

    @Given("the user is on the login page for registration")
    public void the_user_is_on_the_login_page_for_registration() {
        // Page is already open — driver navigated to base URL in Hooks.setUp()
    }

    @When("the user clicks on the sign up here button")
    public void the_user_clicks_on_the_sign_up_here_button() {
        Base.registerPage().clickSignUpHereButton();
    }

    @And("the user enters first name {string}")
    public void the_user_enters_first_name(String firstName) {
        Base.registerPage().enterFirstName(firstName);
    }

    @And("the user enters last name {string}")
    public void the_user_enters_last_name(String lastName) {
        Base.registerPage().enterLastName(lastName);
    }

    @And("the user enters a valid registration email {string}")
    public void the_user_enters_a_valid_registration_email(String email) {
        // Always generate a unique email — ignores whatever is in the Examples table
        // and replaces it with a timestamped value safe for repeat runs.
        String uniqueEmail = "user_" + System.currentTimeMillis() + "@test.com";
        Base.registerPage().enterRegistrationEmail(uniqueEmail);
        scenarioContext.setEmail(uniqueEmail);
    }

    @And("the user enters a valid passcode {string}")
    public void the_user_enters_a_valid_passcode(String passcode) {
        Base.registerPage().enterPasscode(passcode);
        scenarioContext.setPassword(passcode);
    }

    @And("the user confirms the passcode {string}")
    public void the_user_confirms_the_passcode(String passcode) {
        Base.registerPage().enterConfirmPasscode(passcode);
    }

    @And("the user selects a valid group {string}")
    public void the_user_selects_a_valid_group(String group) {
        Base.registerPage().selectGroup(group);
    }

    @And("clicks the create account button")
    public void clicks_the_create_account_button() {
        Base.registerPage().clickCreateAccountButton();
    }

    @Then("the user should see a registration success message")
    public void the_user_should_see_a_registration_success_message() {
        String actualValue   = Base.registerPage().getSignUpSuccessMessage();
        String expectedValue = "Registration submitted successfully. Your account is pending admin approval.";
        Assert.assertEquals(actualValue, expectedValue,
                "Expected: " + expectedValue + ", but got: " + actualValue);
    }
}