package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.AdminPage;
import Services.AuthServices;
import Utils.Base;
import Utils.DBConnection;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AdminLoginSteps extends Base {

    private AuthServices authServices;
    private ScenarioContext scenarioContext;
    private AdminPage adminPage;

    public  AdminLoginSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
        //this.dbConnection = dbConnection;
        this.scenarioContext = scenarioContext;
        this.adminPage = new AdminPage(getDriver());
    }
    @Before
    public void setUpAuthService() {
        // Initialize AuthServices with the shared driver from Base
        this.authServices = new AuthServices(getDriver());
    }

    @Then("the user should be logged in successfully as admin")
    public void the_user_should_be_logged_in_successfully_as_admin() {
        adminPage.navAdminPanelButton();
    }
    @When("the user navigates to the admin panel")
    public void the_user_navigates_to_the_admin_panel() {
        adminPage.navAdminPanelButton();
    }
    @And("approves the newly registered user")
    public void approves_the_newly_registered_user() {
       adminPage.clickAdminApprovalsButton();
       adminPage.clickApproveUserButton();
    }
    @And("promotes the approved user to admin")
    public void promotes_the_approved_user_to_admin(String email) {
       adminPage.navUsersButton();
       adminPage.searchUserByEmail(email);
       adminPage.selectPromoteToAdminOption();
    }
    @Then("the user should see a confirmation message for approval and promotion")
    public void the_user_should_be_logged_in_successfully_as_admin2() {
        adminPage.changeUserToAdminAlert();
        adminPage.adminConfirmationAlert();
        adminPage.clickBackToWebsiteButton();
        adminPage.clickLogoutButton();
    }
    @Then("the user should see the admin dashboard")
    public void the_user_should_see_the_admin_dashboard() {
        // Simple verification/navigation to the admin dashboard
        adminPage.navAdminPanelButton();
    }
}