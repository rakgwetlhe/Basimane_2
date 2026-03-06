package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.RegisterPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterSteps extends Base {

    ScenarioContext context;
    RegisterPage registerPage;

    public RegisterSteps(ScenarioContext context){

        this.context = context;
        registerPage = new RegisterPage(getDriver());
    }

    @Given("the user is on the login page for registration")
    public void openLoginPage(){

        getDriver();
    }

    @When("the user clicks on the sign up here button")
    public void clickSignup(){

        registerPage.clickSignUp();
    }

    @And("the user enters first name {string}")
    public void firstName(String value){

        registerPage.enterFirstName(value);
    }

    @And("the user enters last name {string}")
    public void lastName(String value){

        registerPage.enterLastName(value);
    }

    @And("the user enters a valid registration email")
    public void email(){

        String email = "user"+System.currentTimeMillis()+"@gmail.com";

        context.setEmail(email);
        registerPage.enterEmail(email);
    }

    @And("the user enters a valid passcode {string}")
    public void password(String value){

        context.setPassword(value);
        registerPage.enterPassword(value);
    }

    @And("the user confirms the passcode {string}")
    public void confirmPassword(String value){

        registerPage.confirmPassword(value);
    }

    @And("the user selects a valid group {string}")
    public void group(String value){

        registerPage.selectGroup(value);
    }

    @And("clicks the create account button")
    public void submit(){

        registerPage.clickCreateAccount();
    }

    @Then("the user should see a registration success message")
    public void verifyMessage(){

        String message = registerPage.getSuccessAlert();

        Assert.assertEquals(
                message,
                "Registration submitted successfully. Your account is pending admin approval."
        );
    }
}