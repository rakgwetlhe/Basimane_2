package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "signup-toggle")
    private WebElement signUpHereButton;

    @FindBy(id = "register-firstName")
    private WebElement firstNameField;

    @FindBy(id = "register-lastName")
    private WebElement lastNameField;

    @FindBy(id = "register-email")
    private WebElement emailField;

    @FindBy(id = "register-password")
    private WebElement passwordField;

    @FindBy(id = "register-confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-group")
    private WebElement groupDropdown;

    @FindBy(id = "register-submit")
    private WebElement createAccountButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickSignUpHereButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpHereButton)).click();
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterRegistrationEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPasscode(String passcode) {
        passwordField.clear();
        passwordField.sendKeys(passcode);
    }

    public void enterConfirmPasscode(String passcode) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(passcode);
    }

    public void selectGroup(String group) {
        groupDropdown.sendKeys(group);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    /**
     * FIX: Reads the actual alert text from the browser instead of returning a
     * hardcoded string. This ensures the test catches real UI regressions.
     */
    public String getSignUpSuccessMessage() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();
        alert.accept();
        return message;
    }
}