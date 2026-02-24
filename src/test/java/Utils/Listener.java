package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static ExtentReports extent;

    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName());
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    public void onStart(ITestContext context) {
        extent = ExtendReportManager.generateExtentReport();
    }
}
