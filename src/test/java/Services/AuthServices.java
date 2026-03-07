package Services;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class AuthServices {

    private final LoginPage loginPage;

    public AuthServices(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void loginAs(String email, String password) {
        loginPage.clickNavLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}