package net.docprep.commonfunctions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class AfterSuiteTestold {
	public static WebDriver driver;
	
	@AfterSuite
	public static void afterSuite() throws Exception {
		System.out.println("After suite");
		System.out.println("Close the Browser @@@@@@");
		/*driver.close();
		driver.quit();*/
		if (driver.toString().contains("null")) {
			// log.info("Browser closed");
			System.out.println("Browser closed");
		} else {
			System.out.println("Browser not closed");
		}

	}

}
