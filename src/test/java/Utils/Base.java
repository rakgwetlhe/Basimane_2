package Utils;

import org.openqa.selenium.WebDriver;

public class Base {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            BrowserFactory browserFactory = new BrowserFactory();

            driver = browserFactory.startBrowser(
                    "https://ndosisimplifiedautomation.vercel.app/"
            );
        }

        return driver;
    }
}