package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class AdminPage {

    WebDriver driver;

    @FindBy(xpath="//div/div/button[3]")
    WebElement adminPanel;

    @FindBy(xpath="//button[contains(normalize-space(),'Approvals')]")
    WebElement approvals;

    @FindBy(xpath="//button[contains(text(),'Users')]")
    WebElement users;

    @FindBy(xpath="//input[@placeholder='Search products']")
    WebElement searchUser;

    @FindBy(xpath="//select[@id='userRole']")
    WebElement roleDropdown;

    @FindBy(xpath="//button[normalize-space()='🗑️']")
    WebElement deleteButton;

    @FindBy(xpath="//button[contains(text(),'Logout')]")
    WebElement logout;

    public AdminPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openAdminPanel(){

        adminPanel.click();
    }

    public void openApprovals(){

        approvals.click();
    }

    public void approveUser(String email){

        WebElement approve = driver.findElement(
                By.xpath("//tr[td[contains(text(),'"+email+"')]]//button[contains(text(),'Approve')]")
        );

        approve.click();
    }

    public void openUsers(){

        users.click();
    }

    public void searchUser(String email){

        searchUser.clear();
        searchUser.sendKeys(email);
    }

    public void promoteToAdmin(){

        roleDropdown.sendKeys("Admin");
    }

    public void deleteUser(){

        deleteButton.click();
    }

    public void logout(){

        logout.click();
    }
}