package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    public WebDriver startBrowser(String url) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}