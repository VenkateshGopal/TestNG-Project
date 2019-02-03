package com.testng.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import net.docprep.commonfunctions.CommonFunction;

public class TestBase {

	public static String browsertype;
	public static String appurl;
	public static WebDriver driver;

	public static String projDir = System.getProperty("user.dir");

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * browsertype= "IE"; //"Chrome"; // appurl ="https://www.google.com";
	 * initializeTestBaseSetup(browsertype, appurl ); tearDown(); }
	 */

	//@BeforeClass
	//@BeforeMethod
	@Test
	public static void setUp() throws InterruptedException, IOException {

		//CommonFunction.readConfig();
		browsertype = "IE"; // "Chrome"; //"IE"; //
		appurl = "https://www.google.com";
		driver = getDriver();
		initializeTestBaseSetup(browsertype, appurl);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(String browserType, String appURL) throws InterruptedException {

		switch (browsertype) {

		case "IE":
			driver = initIEDriver(appurl);
			break;
		case "Chrome":
			driver = initChromeDriver(appurl);
			break;
		case "FireFox":
			driver = initFireFoxDriver(appurl);
			break;
		default:
			System.out.println("browser : " + browsertype + "is invalid, Launching IE as browser of choice");
			driver = initIEDriver(appurl);
		}
	}

	@SuppressWarnings("deprecation")
	public static WebDriver initIEDriver(String appurl) throws InterruptedException {
		System.out.println("Launching IE Browser");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver", projDir + "/Drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver(capabilities);
		Thread.sleep(500);
		driver.manage().window().maximize();
		driver.navigate().to(appurl);
		
		return driver;
	}

	public static WebDriver initChromeDriver(String appurl) throws InterruptedException {
		System.out.println("Launching Chrome Browser");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", projDir + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		Thread.sleep(500);
		driver.manage().window().maximize();
		driver.navigate().to(appurl);
		return driver;
	}

	public static WebDriver initFireFoxDriver(String appurl) throws InterruptedException {
		System.out.println("Launching FireFox Browser");
		System.setProperty("webdriver.gecko.driver", projDir + "/Drivers/geckodriver.exe");
		File pathFFBinary = new File("C:\\Users\\vg86168\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxbinary = new FirefoxBinary(pathFFBinary);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxbinary));
		driver = new FirefoxDriver(options);
		Thread.sleep(500);
		driver.manage().window().maximize();
		driver.navigate().to(appurl);
		return driver;
	}

	// @Parameter({"browsertype", "appurl"})
	// @BeforeClass
	public static void initializeTestBaseSetup(String browserType, String appURL) {
		/*
		 * browsertype= "IE"; appurl ="https://www.google.com";
		 */
		try {
			setDriver(browsertype, appurl);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*//@AfterClass
	//@AfterMethod
	public static void tearDown() {
		//System.out.println("Close the Browser @@@@@@");
		driver.close();
		driver.quit();
		if (driver.toString().contains("null")) {
			// log.info("Browser closed");
			System.out.println("Browser closed");
		} else {
			System.out.println("Browser not closed");
		}

	}*/

}
