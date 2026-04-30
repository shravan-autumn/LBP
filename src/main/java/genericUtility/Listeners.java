package genericUtility;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends BaseClass implements ITestListener { 

	ExtentReports extent = ExtentReport.getReportObject();
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>() ;//thread safe
	

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //unique thread id
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		// screenshot
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
