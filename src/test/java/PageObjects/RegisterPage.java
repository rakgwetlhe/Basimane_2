package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id="signup-toggle")
    WebElement signUpButton;

    @FindBy(id="register-firstName")
    WebElement firstName;

    @FindBy(id="register-lastName")
    WebElement lastName;

    @FindBy(id="register-email")
    WebElement email;

    @FindBy(id="register-password")
    WebElement password;

    @FindBy(id="register-confirmPassword")
    WebElement confirmPassword;

    @FindBy(id="register-group")
    WebElement group;

    @FindBy(id="register-submit")
    WebElement createAccount;

    public RegisterPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickSignUp(){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(signUpButton))
                .click();
    }

    public void enterFirstName(String value){

        firstName.sendKeys(value);
    }

    public void enterLastName(String value){

        lastName.sendKeys(value);
    }

    public void enterEmail(String value){

        email.sendKeys(value);
    }

    public void enterPassword(String value){

        password.sendKeys(value);
    }

    public void confirmPassword(String value){

        confirmPassword.sendKeys(value);
    }

    public void selectGroup(String value){

        group.sendKeys(value);
    }

    public void clickCreateAccount(){

        createAccount.click();
    }

    public String getSuccessAlert(){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent())
                .accept();

        return "Registration submitted successfully. Your account is pending admin approval.";
    }
}