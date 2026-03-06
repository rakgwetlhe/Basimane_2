package Services;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class AuthServices {

    LoginPage loginPage;

    public AuthServices(WebDriver driver){

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String password){

        loginPage.clickLoginNav();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}