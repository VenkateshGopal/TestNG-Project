package net.docprep.commonfunctions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.apache.log4j.PropertyConfigurator;

public class TestNgMethods {
	
	public static String status = null;
	
	@BeforeSuite
	public static void beforeSuite() {
		//PropertyConfigurator.configure(System.getProperty("user.dir") + "\\PropertyFiles\\log4j.properties");
		System.out.println("Before Suite");
	}
	@AfterMethod
	public void executionStatus(ITestResult result){
		try {
			if(result.getStatus() == ITestResult.SUCCESS){
				System.out.println("passed **********");
				status = "PASS";
			}
			else if(result.getStatus() == ITestResult.FAILURE){
				System.out.println("Failed ***********");
				status = "FAIL";
			}
			/*else if(result.getStatus() == ITestResult.SKIP ){
				System.out.println("Skiped***********");
			}*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
