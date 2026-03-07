package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='nav-user-section']")
    private WebElement navLoginButton;

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[contains(text(),'Welcome back, ')]")
    private WebElement loginSuccessMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickNavLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(navLoginButton)).click();
    }

    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginSuccessMessage));
        return loginSuccessMessage.getText();
    }
}