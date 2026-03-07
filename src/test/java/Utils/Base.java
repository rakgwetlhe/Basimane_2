package Utils;

import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    /** ThreadLocal ensures parallel-safe driver access. */
    private static final ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();

    /** Initialised page objects — created once the driver is ready. */
    private static LoginPage    loginPageInstance;
    private static RegisterPage registerPageInstance;
    private static AdminPage    adminPageInstance;

    /** Initialises the browser. */
    public static void initDriver(String browser, String url) {
        if (driverHolder.get() == null) {
            WebDriver driver = new BrowserFactory().startBrowser(browser, url);
            driverHolder.set(driver);
            loginPageInstance    = PageFactory.initElements(driver, LoginPage.class);
            registerPageInstance = PageFactory.initElements(driver, RegisterPage.class);
            adminPageInstance    = PageFactory.initElements(driver, AdminPage.class);
        }
    }

    /** Returns the shared driver for this thread. */
    public static WebDriver getDriver() {
        return driverHolder.get();
    }

    /** Quits the browser and clears the ThreadLocal. Call from your global @After hook. */
    public static void quitDriver() {
        WebDriver driver = driverHolder.get();
        if (driver != null) {
            driver.quit();
            driverHolder.remove();
        }
    }

    // ── Page object accessors ────────────────────────────────────────────────

    public LoginPage getLoginPage() {
        return loginPageInstance;
    }

    public RegisterPage getRegisterPage() {
        return registerPageInstance;
    }

    public AdminPage getAdminPage() {
        return adminPageInstance;
    }
}