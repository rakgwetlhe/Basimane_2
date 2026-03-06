package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.LoginPage;
import Services.AuthServices;
import Utils.Base;
import Utils.DBConnection;
import Utils.UserRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps extends Base {

    private AuthServices authServices;
    private DBConnection dbConnection;
    private UserRepository userRepository;
    private ScenarioContext scenarioContext;
    private LoginPage loginPage;

    public  LoginSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
        this.dbConnection = dbConnection;
        this.scenarioContext = scenarioContext;
        this.loginPage = new LoginPage(getDriver());
    }
    @Before
    public void setUpAuthService() {
        // Initialize AuthServices with the shared driver from Base
        this.authServices = new AuthServices(getDriver());
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.clickLoginNav();
    }
    @When("the user enters a valid email {string} and password {string}")
    public void the_user_enters_a_valid_email_and_password(String ignoredEmail, String ignoredPassword) {
        String email = scenarioContext.getEmail();
        String password = scenarioContext.getPassword();
        authServices.login(email, password);
    }

    @When("the user logs in using stored credentials")
    public void the_user_logs_in_using_stored_credentials() {
        String email = scenarioContext.getEmail();
        String password = scenarioContext.getPassword();
        authServices.login(email, password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLogin();
    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String actualValue = loginPage.getLoginMessage();
        System.out.println("Actual Login Success Message: " + actualValue);
        String expectedValue = "Welcome back, ! \uD83D\uDC4B";
        Assert.assertEquals(actualValue, expectedValue, "Expected message: " + expectedValue + ", but got: " + actualValue);
    }
}
