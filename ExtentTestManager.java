package com.testng.base;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager   {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

public static synchronized ExtentTest getTest() {
	//System.out.println("Get  Test Executed ---");
	return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));	
	
	}

public static synchronized void endTest() {
	//System.out.println("End  Test Executed ---");
	extent.flush();
	}

public static synchronized ExtentTest startTest(String testName) {
	
	ExtentTest test = extent.createTest(testName);
	//System.out.println("Started Testing :" + test);
	
	extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
	return test;
	}

}
