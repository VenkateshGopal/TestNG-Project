package com.testng.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testng.base.ExtentTestManager;
import com.testng.base.TestBase;

public class Asia extends TestBase {
	
	@Test
	public void CDAF_Penfabric_Collection_DA() {
		System.out.println("Home page test...");
	//	BasePage basePage = new BasePage(driver);
		//Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test2");
		System.out.println("Hey im in test2 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
	}
}
