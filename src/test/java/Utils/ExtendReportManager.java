package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtendReportManager {

    private static String reportFilePath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

    private static ExtentReports extent;

    private static ExtentSparkReporter sparkReporter;

    public static ExtentReports generateExtentReport() {
            extent = new ExtentReports();
            sparkReporter = new ExtentSparkReporter(new File(reportFilePath));
            extent.attachReporter(sparkReporter);

            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setReportName("Automation Test Execution Report");

            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Execution Machine", System.getProperty("user.name"));
        return extent;
    }

}
