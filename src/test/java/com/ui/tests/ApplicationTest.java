package com.ui.tests;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utils.TestUtils;
import com.utils.UITestBase;

@Listeners({com.listeners.ExtentReporting.class})

public class ApplicationTest extends UITestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeTest 
	public void IntializationTest() {
	loginPage = new LoginPage("CHROME");
	wd = loginPage.getWd();
	}
	
	
	@Test (dataProvider = "Login", dataProviderClass = com.dataprovider.LoginDataProvider.class, priority =1, 
			retryAnalyzer = com.retry.RetryImplementation.class)
	public void loginTest(String username , String password) {
		homePage = (HomePage) loginPage.doLogin(username,password);
		String text = homePage.getTextFromTitle();
		Assert.assertEquals(text, "Accounts Overview");
	}
	
	/*
	 * @Test public void AccountOverviewTest() {
	 * 
	 * }
	 */
	
	@AfterTest
	public void driverQuit() {
		
		loginPage.quit();
	}
	
	
}

