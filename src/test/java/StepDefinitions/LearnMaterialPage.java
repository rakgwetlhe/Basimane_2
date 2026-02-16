package StepDefinitions;

import PageObjects.LearnOptionPage;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class LearnMaterialPage {

    @Given("User is on the Learning Material Page")
    public void user_is_on_the_learning_material_page() {

    }
    @Then("User clicks the Web Automation Basic Form Options")
    public void user_clicks_the_web_automation_basic_form_options() {
        learnOptionPage.clickWebAutomationBasicFormOption();
    }
    @When("User should be redirected to the Selenium Practice Form")
    public void user_should_be_redirected_to_the_selenium_practice_form() {
        learnOptionPage.verifyWelcomeHeaderMessage();
    }
    @And("User fills out the practice form with valid data")
    public void user_fills_out_the_practice_form_with_valid_data() {
        learnOptionPage.enterFullName("Cucumber Cucumbers");
        learnOptionPage.enterEmail("cucumber@gmail.com");
        learnOptionPage.enterAge("30");
        learnOptionPage.selectGender("Female");
        learnOptionPage.selectCountry("United States");
        learnOptionPage.clickSkillsLevelCheckbox("Intermediate");
        learnOptionPage.skillsLevelCheckboxXpath.click("Java", "Python", "JavaScript");
        learnOptionPage.enterComments("This is a test comment for the practice form.");
        learnOptionPage.clickNewsletterSubscriptionCheckbox("");
        learnOptionPage.clickTermsAndConditionsCheckbox();

    }
    @And("User should see the captured form details summary")
    public void user_should_see_the_captured_form_details_summary() {
        learnOptionPage.clickViewFormData();
    }
    @And("User clicks the submit button")
    public void user_clicks_the_submit_button() {
        learnOptionPage.clickSubmitFormButton();
    }
    @Then("User should see a confirmation message")
    public void user_should_see_a_confirmation_message() {
        String actualValue = learnOptionPage.getFormSubmissionConfirmationMessage();
        System.out.println("Actual form submission confirmation message: " + actualValue);
        String expectedValue = "Form submitted successfully! \uD83C\uDF89";
        Assert.assertEquals(actualValue, expectedValue, "Expected message: " + expectedValue + ", but got: " + actualValue);
    }
}
