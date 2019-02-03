package com.testng.base;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;


public class TestListener implements ITestListener {

	
	public void onFinish(ITestContext context) {
		System.out.println(" ** TestSuite " + context.getName() + " ending *** ");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	public void onStart(ITestContext context) {
	System.out.println(" ** TestSuite " + context.getName() + " Started *** ");
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		
	}	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println(" *** Tests " + result.getMethod().getMethodName() + "  Skipped ***");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	
	public void onTestStart(ITestResult result) {
	System.out.println(" ** Running Test Method " + result.getMethod().getMethodName() + " ****" );
	ExtentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
	System.out.println(" *** Executed " + result.getMethod().getMethodName() + " test Successfully ***");
	ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println(" *** Tests Execution " + result.getMethod().getMethodName() + "  failed ***");
		ExtentTestManager.getTest().log(Status.FAIL, " Test Failed");
	}

}
