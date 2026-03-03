package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    @FindBy (xpath = "//div[@class='nav-dropdown-item']")
    WebElement adminPanelButtonXpath;
    @FindBy (xpath = "//button[contains(text(),'Approvals')]")
    WebElement adminApprovalsButtonXpath;
    @FindBy (xpath = "//button[contains(text(),'✓ Approve')]")
    WebElement approveUserButtonXpath;
    @FindBy (xpath = "//button[contains(text(),'Users')]")
    WebElement adminUsersButtonXpath;
    @FindBy (xpath = "//input[@placeholder='Search products']")
    WebElement searchUserFieldXpath;
    @FindBy (xpath = "//select[@id='userRole']/option[text()='Admin']")
    WebElement promoteToAdminOptionXpath;
    @FindBy (xpath = "//button[contains(text(),'← Back to Website')]")
    WebElement backToWebsiteButtonXpath;
    @FindBy (xpath = "//button[@class='nav-dropdown-item']")
    WebElement logoutButtonXpath;

    WebDriver driver;
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navAdminPanelButton() {
        adminPanelButtonXpath.click();
    }
    public void clickAdminApprovalsButton() {
        adminApprovalsButtonXpath.click();
    }
    public void clickApproveUserButton() {
        approveUserButtonXpath.click();
    }
    public void navUsersButton() {
        adminUsersButtonXpath.click();
    }
    public void searchUserByEmail(String email) {
        searchUserFieldXpath.clear();
        searchUserFieldXpath.sendKeys(email);
    }
    public void selectPromoteToAdminOption() {
        promoteToAdminOptionXpath.click();
    }
    public void changeUserToAdminAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void adminConfirmationAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void clickBackToWebsiteButton() {
        backToWebsiteButtonXpath.click();
    }
    public void clickLogoutButton() {
        logoutButtonXpath.click();
    }
}
