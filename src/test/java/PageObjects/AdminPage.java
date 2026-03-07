package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class AdminPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//span[normalize-space()='admin']")
    private WebElement adminButton;

    @FindBy(xpath = "//a[contains(text(),'Admin Panel')]")
    private WebElement adminPanelButton;

    @FindBy(xpath = "//button[contains(text(),'Approvals')]")
    private WebElement adminApprovalsButton;

    @FindBy(xpath = "//button[contains(text(),'✓ Approve')]")
    private WebElement approveUserButton;

    @FindBy(xpath = "//button[contains(text(),'Users')]")
    private WebElement adminUsersButton;

    @FindBy(xpath = "//input[@placeholder='Search products']")
    private WebElement searchUserField;

    @FindBy(xpath = "//select[@id='userRole']/option[text()='Admin']")
    private WebElement promoteToAdminOption;

    @FindBy(xpath = "//button[contains(text(),'← Back to Website')]")
    private WebElement backToWebsiteButton;

    @FindBy(xpath = "//button[@class='nav-dropdown-item']")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[normalize-space()='🗑️']")
    private WebElement deleteUserButton;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navAdminButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adminButton)).click();
    }
    public void navAdminPanelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adminPanelButton)).click();
    }

    public void clickAdminApprovalsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adminApprovalsButton)).click();
    }

    public void clickApproveUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(approveUserButton)).click();
    }

    public void navUsersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adminUsersButton)).click();
    }

    public void searchUserByEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(searchUserField));
        searchUserField.clear();
        searchUserField.sendKeys(email);
    }

    public void selectPromoteToAdminOption() {
        wait.until(ExpectedConditions.elementToBeClickable(promoteToAdminOption)).click();
    }

    public void acceptPromoteToAdminAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void acceptAdminConfirmationAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickBackToWebsiteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backToWebsiteButton)).click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickDeleteUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteUserButton)).click();
    }

    public void acceptDeletionConfirmationAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
