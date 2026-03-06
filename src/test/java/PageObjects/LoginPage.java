package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='nav-user-section']")
    WebElement navLoginButton;

    @FindBy(id = "login-email")
    WebElement emailField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement loginButton;

    @FindBy(xpath = "//h2[contains(text(),'Welcome back')]")
    WebElement loginMessage;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginNav() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(navLoginButton)).click();
    }

    public void enterEmail(String email) {

        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {

        loginButton.click();
    }

    public String getLoginMessage() {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(loginMessage))
                .getText();
    }
}