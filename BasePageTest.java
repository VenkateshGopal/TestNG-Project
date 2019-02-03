package com.testng.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testng.base.ExtentTestManager;
import com.testng.base.TestBase;
import com.testng.pages.BasePage;

public class BasePageTest extends TestBase {
	
	

	public static String browsertype; 
	public static String appurl ;
	public static WebDriver driver;
	//browsertype= "IE"; //"Chrome"; //
	//appurl ="https://www.google.com";	
	
	/*@BeforeClass
	public static void setUp() throws InterruptedException {
		driver = getDriver();
		initializeTestBaseSetup ("IE", "https://www.google.com");
	}*/
	
	@Test
	public static void beforeMethod() throws Exception {
		Process p1 = Runtime.getRuntime().exec("Drivers\\ClearCache.bat");
		Process p2 = Runtime.getRuntime().exec("Drivers\\ClearCache1.bat");
		p1 = Runtime.getRuntime().exec("Drivers\\ClearCache.bat");
		p2 = Runtime.getRuntime().exec("Drivers\\ClearCache1.bat");
		p1 = Runtime.getRuntime().exec("Drivers\\ClearCache.bat");
		p2 = Runtime.getRuntime().exec("Drivers\\ClearCache1.bat");
		Thread.sleep(10000);
		System.out.println("Before Methods");
		setUp();
		//urlNavigation(con.environmentDetails());
	}
	
	//@Test
	public void basePageTest() {
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

	//@Test
	public void baseTest1() {
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 1");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 2");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 3");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 4");
	}

	//@Test
	public void baseTest2() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test2");
					System.out.println("Hey im in test2 test");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test2 1");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test2 2");
	}

	//@Test
	public void baseTest3() {
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test3 1");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test3 2");
	}

}