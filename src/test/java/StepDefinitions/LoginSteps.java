package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.LoginPage;
import Services.AuthServices;
import Utils.Base;
import Utils.DBConnection;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

        private final ScenarioContext scenarioContext;
        private final LoginPage loginPage;
        private final AuthServices authServices;

        public LoginSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
            this.scenarioContext = scenarioContext;
            this.loginPage       = new LoginPage(Base.getDriver());
            this.authServices    = new AuthServices(Base.getDriver());
        }

        @Given("the user is on the login page")
        public void the_user_is_on_the_login_page() {
            loginPage.clickNavLoginButton();
        }

        @When("the user logs in using stored credentials")
        public void the_user_logs_in_using_stored_credentials() {
            String email    = scenarioContext.getEmail();
            String password = scenarioContext.getPassword();
            authServices.loginAs(email, password);
        }

        @And("clicks the login button")
        public void clicks_the_login_button() {
            loginPage.clickLoginButton();
        }

        @Then("the user should be redirected to the dashboard")
        public void the_user_should_be_redirected_to_the_dashboard() {
            String actualValue   = loginPage.getLoginSuccessMessage();
            String expectedValue = "Welcome back, ! \uD83D\uDC4B";
            Assert.assertEquals(actualValue, expectedValue,
                    "Expected: " + expectedValue + ", but got: " + actualValue);
        }
    }
