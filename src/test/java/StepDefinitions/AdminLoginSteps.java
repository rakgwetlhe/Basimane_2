package StepDefinitions;

import Context.ScenarioContext;
import PageObjects.AdminPage;
import Services.AuthServices;
import Utils.Base;
import Utils.DBConnection;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminLoginSteps {

    private final ScenarioContext scenarioContext;

    public AdminLoginSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        // DO NOT instantiate page objects here — driver is null at construction time.
    }

    @Then("the user should be logged in successfully as admin")
    public void the_user_should_be_logged_in_successfully_as_admin() {
        new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(text(),'Welcome back')]")));
    }

    @When("the user navigates to the admin panel")
    public void the_user_navigates_to_the_admin_panel() {
        Base.adminPage().navAdminPanelButton();
    }

    @And("approves the newly registered user")
    public void approves_the_newly_registered_user() {
        Base.adminPage().clickAdminApprovalsButton();
        Base.adminPage().clickApproveUserButton();
    }

    @And("promotes the approved user to admin")
    public void promotes_the_approved_user_to_admin() {
        String email = scenarioContext.getEmail();
        Base.adminPage().navUsersButton();
        Base.adminPage().searchUserByEmail(email);
        Base.adminPage().selectPromoteToAdminOption();
    }

    @Then("the user should see a confirmation message for approval and promotion")
    public void the_user_should_see_a_confirmation_message_for_approval_and_promotion() {
        Base.adminPage().acceptPromoteToAdminAlert();
        Base.adminPage().acceptAdminConfirmationAlert();
        Base.adminPage().clickBackToWebsiteButton();
        Base.adminPage().clickLogoutButton();
    }

    @Then("the user should see the admin dashboard")
    public void the_user_should_see_the_admin_dashboard() {
        new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(text(),'Welcome back')]")));
    }

    @And("clicks users on the admin panel")
    public void clicks_users_on_the_admin_panel() {
        Base.adminPage().navUsersButton();
    }

    @And("deletes a user from the user list")
    public void deletes_a_user_from_the_user_list() {
        Base.adminPage().clickDeleteUserButton();
    }

    @Then("the user should see a confirmation message for deletion")
    public void the_user_should_see_a_confirmation_message_for_deletion() {
        Base.adminPage().acceptDeletionConfirmationAlert();
    }
}

