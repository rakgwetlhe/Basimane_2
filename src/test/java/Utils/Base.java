package Utils;

import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    private static final ThreadLocal<WebDriver>    driverHolder       = new ThreadLocal<>();
    private static final ThreadLocal<LoginPage>    loginPageHolder    = new ThreadLocal<>();
    private static final ThreadLocal<RegisterPage> registerPageHolder = new ThreadLocal<>();
    private static final ThreadLocal<AdminPage>    adminPageHolder    = new ThreadLocal<>();

    /**
     * Starts the browser and creates all page objects.
     * Called from the global @Before hook.
     * Always creates a fresh driver — clears any stale session first.
     */
    public static void initDriver(String browser, String url) {
        // Always quit any existing driver first to prevent stale session reuse
        quitDriver();

        WebDriver driver = new BrowserFactory().startBrowser(browser, url);
        driverHolder.set(driver);
        loginPageHolder.set(new LoginPage(driver));
        registerPageHolder.set(new RegisterPage(driver));
        adminPageHolder.set(new AdminPage(driver));
    }

    /** Returns the shared WebDriver for this thread. */
    public static WebDriver getDriver() {
        return driverHolder.get();
    }

    /** Quits the browser and clears all ThreadLocals. Called from global @After hook. */
    public static void quitDriver() {
        WebDriver driver = driverHolder.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
                // Already closed — that's fine, just clear the references
            }
        }
        driverHolder.remove();
        loginPageHolder.remove();
        registerPageHolder.remove();
        adminPageHolder.remove();
    }

    // ── Page object accessors (call inside step methods, never in constructors) ──

    public static LoginPage loginPage() {
        return loginPageHolder.get();
    }

    public static RegisterPage registerPage() {
        return registerPageHolder.get();
    }

    public static AdminPage adminPage() {
        return adminPageHolder.get();
    }
}