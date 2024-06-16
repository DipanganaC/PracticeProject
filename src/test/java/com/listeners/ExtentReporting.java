package com.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.BrowserUtility;
import com.utils.TestUtils;
import com.utils.UITestBase;

public class ExtentReporting extends UITestBase  implements ITestListener {
	
	

	ExtentTest test ;
	ExtentReports report;
	ExtentSparkReporter sparkReport;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		
		test =  report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "starttest" +result.getMethod().getMethodName());
		test.log(Status.INFO, "priority" +result.getMethod().getPriority());
		test.log(Status.INFO, "starttest" +result.getMethod().getDescription());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.INFO, "OnSuccess" +result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(TestUtils.AddScreenshot(wd,result.getMethod().getMethodName()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		test.log(Status.INFO, "OnFailure" +result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(TestUtils.AddScreenshot(wd,result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+"/report.html");
		report = new ExtentReports();
		report.attachReporter(sparkReport);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		report.flush();
	}

}
