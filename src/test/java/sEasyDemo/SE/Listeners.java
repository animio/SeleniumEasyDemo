package sEasyDemo.SE;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {
	
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		test = extent.createTest(testMethodName);
		extentTest.set(test);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		
		extentTest.get().fail(result.getThrowable());
		
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), testMethodName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}


}
