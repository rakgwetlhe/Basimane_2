package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.AdminPage;
import Services.AuthServices;
import Utils.Base;
import io.cucumber.java.en.*;

public class AdminSteps extends Base {

    ScenarioContext context;
    AdminPage adminPage;
    AuthServices auth;

    public AdminSteps(ScenarioContext context){

        this.context = context;
        adminPage = new AdminPage(getDriver());
        auth = new AuthServices(getDriver());
    }

    @When("the admin logs in")
    public void adminLogin(){

        auth.login("admin@gmail.com","@12345678");
    }

    @And("the admin navigates to the admin panel")
    public void openPanel(){

        adminPage.openAdminPanel();
    }

    @And("approves the newly registered user")
    public void approveUser(){

        adminPage.openApprovals();
        adminPage.approveUser(context.getEmail());
    }

    @And("promotes the approved user to admin")
    public void promoteUser(){

        adminPage.openUsers();
        adminPage.searchUser(context.getEmail());
        adminPage.promoteToAdmin();
    }

    @And("the admin logs out")
    public void logout(){

        adminPage.logout();
    }
}