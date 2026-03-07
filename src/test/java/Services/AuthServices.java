package Services;

import PageObjects.LoginPage;
import Utils.Base;
import org.openqa.selenium.WebDriver;

public class AuthServices {

    public void loginAs(String email, String password) {
        Base.loginPage().clickNavLoginButton();
        Base.loginPage().enterEmailAddress(email);
        Base.loginPage().enterPassword(password);
        Base.loginPage().clickLoginButton();
    }
}