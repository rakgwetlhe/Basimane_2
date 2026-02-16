package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='nav-dropdown-trigger' and text()='Learn']")
    WebElement navLearnDropdownXpath;
    @FindBy(xpath = "//div[@class='nav-dropdown-item' and text()='Learning Materials']")
    WebElement learningMaterialsOptionXpath;
    @FindBy(id = "practice-tabs") // == Optional id for user (practice-header) ==
    WebElement verifyWelcomePageIsDisplayedId;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }


}
