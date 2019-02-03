package com.testng.test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testng.base.TestBase;
import com.testng.pages.BasePage;
import com.testng.pages.CreateAccountPage;
import com.testng.pages.SignInPage;


public class CreateAccountTest extends TestBase {
	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;
	private CreateAccountPage createAccountPage;

	/*@BeforeClass
	public void setUp() {
		driver = getDriver();
		initializeTestBaseSetup ("IE", "https://www.google.com");
	}*/

	@Test
	public void verifyCreateAnAccountPage() {
		System.out.println("Create An Account page test...");
		//basePage = new BasePage(driver);
		/*signInPage = basePage.clickSignInBtn();
		createAccountPage = signInPage.clickonCreateAnAccount();
		Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
		Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");*/
	}

	@Test
	public void createAccountExample1() {
		System.out.println("Hey im in example1 test");
	}

	@Test
	public void createAccountExample2() {
		System.out.println("Hey im in Example2 test");
	}
}