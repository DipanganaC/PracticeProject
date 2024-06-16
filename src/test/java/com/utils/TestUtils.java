package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {


	public static String readPropertyFile(String env) {

		//C:\Users\User\Desktop\AT_Batch_June_2022\Java-Dipangana\practiceproject\Config
		File file = new File(System.getProperty("user.dir")+"/Config/"+env+".properties");
		Reader read = null;
		try {
			read = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(read);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = prop.getProperty("URL");

		return url;
	}

	public static String[][] readExcelFileForLoginTest(String excelname , String name) {

		XSSFWorkbook workbook;
		String[][] details = null;
		try {
			File file = new File(System.getProperty("user.dir")+"/Config/"+excelname+".xlsx");
			try {
				workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(name);
				int rownum = sheet.getLastRowNum();
				XSSFRow row = sheet.getRow(1);
				int cellCount = row.getLastCellNum();
				System.out.println(rownum);
				System.out.println(cellCount);
				details = new String[rownum][cellCount];
				
				for(int i=1;i<=rownum;i++ ) {
					for(int j =0;j<cellCount;j++) {
						
						XSSFRow row1 = sheet.getRow(i);
						details[i-1][j] = row1.getCell(j).getStringCellValue();
					}
				}
				for (int row2 = 0; row2 < details.length; row2++) {
			        for (int col = 0; col < details[row2].length; col++) {
			            System.out.println(details[row2][col]);
			        }
				}
				
			//	System.out.println(details.toString());
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;

	}
	
	public static String AddScreenshot(WebDriver driver , String testName) {
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"/screenshots/"+testName+".png");
		try {
			FileUtils.copyFile(screenshotFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return System.getProperty("user.dir")+"/screenshots/"+testName+".png";
		
		
	}
}
