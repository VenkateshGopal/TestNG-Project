package net.docprep.commonfunctions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class AfterSuiteTest extends CommonMethods {

	public static  WebDriver driver;
	
	@AfterSuite
	public static void afterSuite() throws Exception {
		System.out.println("After Suite");
		/*driver.close();
		driver.quit();*/
		/*if(driver.toString().contains("null")) {
			//log.info("Browser closed");
		}
		else {
			sel.Alerts();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainPage");
			if(driver.findElement(obj.Skip).isDisplayed()) {
				driver.findElement(obj.Skip).click();
			}
			Thread.sleep(5000);
			if(driver.findElement(obj.MyTrimsReg).isDisplayed()) {
				driver.findElement(obj.MyTrimsReg).click();
			}
			Thread.sleep(7200);
			try {
				if (driver.findElements(obj.LogOut).size()!=0) {
					if(driver.findElement(obj.LogOut).isEnabled()) {
						sel.clickelementSel(obj.LogOut, "Logout");
						Thread.sleep(4000);
					sel.Alerts();
				}
				}
			} catch (Exception e) {
				//Thread.sleep(7000);, test.addScreenCapture(sel.takeScreenshotSel(driver)));
				e.printStackTrace();
				throw new Exception(e);
			}
		}*/
	}
}
