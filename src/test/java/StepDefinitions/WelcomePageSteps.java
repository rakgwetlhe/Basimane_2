package StepDefinitions;

import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelcomePageSteps extends Base {

    @Given("User is on the Welcome Page")
    public void user_is_on_the_welcome_page() {
        welcomePage.clickNavLearnDropdown();
        welcomePage.clickLearningMaterialsOption();
    }

    @Then("User should be redirected to the Learning Material Page")
    public void user_should_be_redirected_to_the_learning_material_page() {
        String actualValue = welcomePage.verifyWelcomePageIsDisplayedId.getText();
        System.out.println("Actual value: " + actualValue);
    }
}