package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtility;

public class HomePage extends BrowserUtility{
	
	public static final By textFromCoaster = By.xpath("(//h1[@class='title'])[1]");

	
	 public HomePage(WebDriver wd) { 
		 super(wd); // TODO Auto-generated constructor
	  }
	 
	
	public String getTextFromTitle() {
		
		String text = getText(textFromCoaster);
		
		return text;
	}

	
	

	
		// TODO Auto-generated constructor stub
}

	
	
	
	
	


