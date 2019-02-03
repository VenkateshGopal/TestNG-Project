package com.testng.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testng.base.ExtentTestManager;
import com.testng.base.TestBase;
import com.testng.pages.BasePage;
import com.testng.pages.SignInPage;

public class SignInPageTest extends TestBase {

	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;

	/*@BeforeClass
	public void setUp() {
		//Get driver
		driver = getDriver();
		initializeTestBaseSetup ("IE", "https://www.google.com");
	}*/
	/*@Test
	public static void beforeMethods() throws Exception {
		setUp();
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
		//setUp();
		//urlNavigation(con.environmentDetails());
	}
	
	@Test
	public static void CDAF_Penfabric_Collection_DA() throws InterruptedException, IOException {
		setUp();
		System.out.println("Sign In functionality details...");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
	}
	
	@Test
	public static void CDAF_Penfabric_Collection_DP() throws InterruptedException, IOException {
		setUp();
		System.out.println("Sign In functionality details...");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
	}
	
	@Test
	public static void CDAF_Penfabric_LC_PymtToUSUnderColl() throws InterruptedException, IOException {
		setUp();
		System.out.println("Sign In functionality details...");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
	}

	@Test
	public static void CDAF_Penfabric_LC_NLC() throws InterruptedException, IOException {
		setUp();
		System.out.println("Sign In functionality details...");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
	}
	public static void CDAF_Penfabric_OA_PymtToUSAfterColl() throws InterruptedException, IOException {
		setUp();
		System.out.println("Sign In functionality details...");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		System.out.println("Hey im in test3 test");
	}

	
}