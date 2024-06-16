package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.BrowserUtility;
import com.utils.TestUtils;

public class LoginPage extends BrowserUtility {
	
	private static final By loginUsername= By.xpath("//input[@name='username']");
	private static final By loginPassword= By.xpath("//input[@name='password']");
	private static final By submitBtn= By.xpath("//input[@type='submit']");
	
	
	
	public LoginPage(String browser) {
		super(browser);
		goToUrl(TestUtils.readPropertyFile("DEV"));
		maximizeWindow();
		
	}
	public HomePage doLogin(String username,String Password) {
		enterText(username,loginUsername);
		enterText(Password,loginPassword);
		elementClick(submitBtn);
		HomePage hm = new HomePage(getWd());
		return hm;
		
	}

}
