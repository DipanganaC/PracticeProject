package com.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name = "Login")
	public String[][] loginProvider() {
		return com.utils.TestUtils.readExcelFileForLoginTest("Login", "Sheet1");	
	}

}
