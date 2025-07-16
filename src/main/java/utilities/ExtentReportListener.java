package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
public class ExtentReportListener implements ITestListener{
	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
//	private static Map<String, Boolean> alreadyLogged = new HashMap<>();
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter("./reports/AutomationReport");
		spark.config().setReportName("SeleniumPractise Project Report");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("QA","Visva");
		
	}
	
//	public void onTestStart(ITestResult result) {
//		test= extent.createTest(result.getName());
//	}
	
	public void onTestSuccess(ITestResult result) {
		if (Boolean.TRUE.equals(result.getAttribute("isRetry"))) {
			return;
		}else {
			test= extent.createTest(result.getName());
			test.log(Status.PASS,"Test Passed: "+ result.getName());
		}
		
	}
	
	public void onTestFailure(ITestResult result) {
		if (Boolean.TRUE.equals(result.getAttribute("isRetry"))) { return;}
		else {
			test= extent.createTest(result.getName());
			test.log(Status.FAIL,"Test Failed: "+ result.getName());
			test.log(Status.FAIL, result.getThrowable());
			
			WebDriver driver = BaseClass.driver;
			String screenshotPath = ScreenshotUtility.captureScreenshot(driver,result.getName());
			
			try {
				test.addScreenCaptureFromPath(screenshotPath);
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		if (Boolean.TRUE.equals(result.getAttribute("isRetry"))) {
			return;
		}
		else {
			test= extent.createTest(result.getName());
			test.log(Status.SKIP," Test Skipped: "+result.getName());
		}
			
			
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	// Utility method to skip duplicate logs for retries
//    private boolean shouldSkipLogging(ITestResult result) {
//        if (result.getAttribute("retrying") != null) return true;
//
//        String testName = result.getMethod().getMethodName();
//        if (alreadyLogged.containsKey(testName)) return true;
//
//        alreadyLogged.put(testName, true);
//        return false;
//    }
}
