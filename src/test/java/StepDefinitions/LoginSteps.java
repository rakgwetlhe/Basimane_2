package StepDefinitions;

import Utils.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps extends Base {

    @Given("User on the login page")
    public void user_on_the_login_page() {
        loginPage.clickNavLoginButton();
    }
    @When("User enters a valid username {}")
    public void user_enters_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }
    @And("User enters a valid password {}")
    public void user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }
    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        String actualValue = loginPage.getLoginSuccessMessage();
        System.out.println("Actual login success message: " + actualValue);
        String expectedValue = "Welcome back, Cucumber! \uD83D\uDC4B";
        Assert.assertEquals(actualValue, expectedValue, "Expected message: " + expectedValue + ", but got: " + actualValue);
    }
}
