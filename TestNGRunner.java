package com.testng.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testng.base.TestBase;

public class TestNGRunner extends TestBase {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	public static String browsertype; 
	public static String appurl ;
	public static WebDriver driver;
	
	@BeforeClass
		public static void setUp() throws InterruptedException {
			
		System.out.println("Before Class");
			
			driver = getDriver();
			initializeTestBaseSetup (browsertype, appurl);
		}
	
	/*@Test
	public static void testmethod () {
		System.out.println("Test method print 1");
	}*/
	
	@AfterClass
	public static void tearDown() {
		System.out.println("After Class");
		System.out.println("Close the Browser @@@@@@");
		driver.close();
		driver.quit();
	}
}
