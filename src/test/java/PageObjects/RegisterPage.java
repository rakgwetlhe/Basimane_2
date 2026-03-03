package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    @FindBy (id = "signup-toggle")
    WebElement signUpHereButtonId;
    @FindBy (id = "register-firstName")
    WebElement firstNameFieldId;
    @FindBy (id = "register-lastName")
    WebElement lastNameFieldId;
    @FindBy (id = "register-email")
    WebElement emailFieldId;
    @FindBy (id = "register-password")
    WebElement passwordFieldId;
    @FindBy (id = "register-confirmPassword")
    WebElement confirmPasswordFieldId;
    @FindBy (id = "register-group")
    WebElement groupDropdownId;
    @FindBy (id = "register-submit")
    WebElement createAccountButtonId;

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSignUpHereButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(signUpHereButtonId));
        signUpHereButtonId.click();
    }
    public void enterFirstName(String firstName) {
        firstNameFieldId.clear();
        firstNameFieldId.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        lastNameFieldId.clear();
        lastNameFieldId.sendKeys(lastName);
    }
    public void enterRegistrationEmail(String email) {
        emailFieldId.clear();
        emailFieldId.sendKeys(email);
    }
    public void enterPasscode(String passcode) {
        passwordFieldId.clear();
        passwordFieldId.sendKeys(passcode);
    }
    public void enterConfirmPasscode(String passcode) {
        confirmPasswordFieldId.clear();
        confirmPasswordFieldId.sendKeys(passcode);
    }
    public void selectGroup(String group) {
        groupDropdownId.sendKeys(group);
    }
    public void clickCreateAccountButton() {
        createAccountButtonId.click();
    }
    public String getSignUpSuccessMessage() {
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(verifySignUpIsSuccessfullyXpath));
        //return verifySignUpIsSuccessfullyXpath.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return "Registration submitted successfully. Your account is pending admin approval.";
    }
}
