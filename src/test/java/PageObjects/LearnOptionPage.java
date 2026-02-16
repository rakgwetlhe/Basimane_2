package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearnOptionPage {

    WebDriver driver;

    @FindBy(id = "tab-btn-password")
    WebElement webAutomationBasicFormTabId;
    @FindBy(id = "page-title")
    WebElement welcomeHeaderId; // == Selenium Practice Form ==
    @FindBy(id = "name")
    WebElement fullNameFieldId;
    @FindBy(id = "email")
    WebElement emailFieldId;
    @FindBy(id = "age")
    WebElement ageFieldId;
    @FindBy(id = "gender")
    WebElement genderDropdownId;
    @FindBy(id = "country")
    WebElement countryDropdownId;
    @FindBy(id = "experience")
    WebElement yearsOfExperienceDropdownId;
    @FindBy(xpath = "//*[@id=\"practice-form\"]/div[2]/label")
    WebElement skillsLevelCheckboxXpath;
    @FindBy(id = "comments")
    WebElement commentsFieldId;
    @FindBy(id = "newsletter")
    WebElement newsletterSubscriptionCheckboxId;
    @FindBy(id = "terms")
    WebElement termsAndConditionsCheckboxId;
    @FindBy(id = "form-data")
    WebElement viewFormDataId; // == Captured Form Details Summary ==
    @FindBy(id = "submit-btn")
    WebElement submitFormButtonId;

    public LearnOptionPage(WebDriver driver) {
            this.driver = driver;
        }
}
