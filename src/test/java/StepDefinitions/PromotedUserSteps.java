package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.AdminPage;
import Services.AuthServices;
import Utils.Base;
import io.cucumber.java.en.*;

public class PromotedUserSteps extends Base {

    ScenarioContext context;
    AuthServices auth;
    AdminPage adminPage;

    public PromotedUserSteps(ScenarioContext context){

        this.context = context;
        auth = new AuthServices(getDriver());
        adminPage = new AdminPage(getDriver());
    }

    @When("the promoted user logs in")
    public void loginPromotedUser(){

        auth.login(context.getEmail(), context.getPassword());
    }

    @Then("the user should see the admin dashboard")
    public void verifyDashboard(){

        adminPage.openAdminPanel();
    }

    @And("deletes a user from the user list")
    public void deleteUser(){

        adminPage.openUsers();
        adminPage.deleteUser();
    }
}