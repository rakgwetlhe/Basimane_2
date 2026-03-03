package Utils;

import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
    public AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);

    // Provide access to the underlying WebDriver for step definitions and services
    public WebDriver getDriver() {
        return this.driver;
    }
}
