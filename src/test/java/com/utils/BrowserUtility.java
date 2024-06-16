package com.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
	WebDriver wd;
	WebDriverWait wait;
	
	public WebDriver getWd() {
		
		return wd;
	}
	
	public BrowserUtility(WebDriver wd) {
		this.wd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}
	
	
	public BrowserUtility(String browser) {
		
		if(browser == "CHROME") {
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		} else if( browser == "FIREFOX") {
			
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
			wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		}
	}
	
	public String getText(By xpath) {
	 String getText = wd.findElement((xpath)).getText();
	 getText = getText.trim();
	 return getText;
		
	}
	
	
	
	public void enterText(String text,By xpath) {
		wd.findElement(xpath).sendKeys(text);
	}
	
	public void elementClick(By xpath) {
		wd.findElement(xpath).click();
	}
	
	public void goToUrl(String url) {
		
		wd.get(url);
		
	}
	public void maximizeWindow() {
		wd.manage().window().maximize();
	}
	
	public void quit() {
		wd.quit();
	}
}
