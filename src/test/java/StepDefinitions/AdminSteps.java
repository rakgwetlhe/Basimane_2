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
    private final AdminPage adminPage;
    private final AuthServices authServices;

    public AdminLoginSteps(DBConnection dbConnection, ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.adminPage       = new AdminPage(Base.getDriver());
        this.authServices    = new AuthServices(Base.getDriver());
    }

    /**
     * FIX: Was calling navAdminPanelButton() (navigation) inside a @Then (assertion) step.
     * Now verifies the welcome message that confirms a successful login.
     */
    @Then("the user should be logged in successfully as admin")
    public void the_user_should_be_logged_in_successfully_as_admin() {
        new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(text(),'Welcome back')]")));
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

    /**
     * FIX: Previously declared as promotes_the_approved_user_to_admin(String email)
     * but the Gherkin step has no parameter — Cucumber would throw a mismatch error.
     * Email is now read from ScenarioContext where it was stored during registration.
     */
    @And("promotes the approved user to admin")
    public void promotes_the_approved_user_to_admin() {
        String email = scenarioContext.getEmail();
        adminPage.navUsersButton();
        adminPage.searchUserByEmail(email);
        adminPage.selectPromoteToAdminOption();
    }

    @Then("the user should see a confirmation message for approval and promotion")
    public void the_user_should_see_a_confirmation_message_for_approval_and_promotion() {
        adminPage.acceptPromoteToAdminAlert();      // FIX: now accepts the alert
        adminPage.acceptAdminConfirmationAlert();   // FIX: now accepts the alert
        adminPage.clickBackToWebsiteButton();
        adminPage.clickLogoutButton();
    }

    @Then("the user should see the admin dashboard")
    public void the_user_should_see_the_admin_dashboard() {
        new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(text(),'Welcome back')]")));
    }

    /** FIX: This step existed in the feature but had no matching step definition. */
    @And("clicks users on the admin panel")
    public void clicks_users_on_the_admin_panel() {
        adminPage.navUsersButton();
    }

    /** FIX: This step existed in the feature but had no matching step definition. */
    @And("deletes a user from the user list")
    public void deletes_a_user_from_the_user_list() {
        adminPage.clickDeleteUserButton();
    }

    /** FIX: This step existed in the feature but had no matching step definition. */
    @Then("the user should see a confirmation message for deletion")
    public void the_user_should_see_a_confirmation_message_for_deletion() {
        adminPage.acceptDeletionConfirmationAlert();
    }
}