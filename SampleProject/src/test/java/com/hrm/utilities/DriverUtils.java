package com.hrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverUtils {

public static String captureScreenshot(WebDriver driver)	
{
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String Screenshotpath = "./Screenshots/"+Current_TMS()+".jpg";
	try {
		FileHandler.copy(src, new File(Screenshotpath));
	} catch (IOException e) {
		System.out.println("unable to capture screenshot --> " + e.getMessage());
	}
	return Screenshotpath;
}

public static String Current_TMS()
{
DateFormat customformat = new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
Date currentdate = new Date();
return customformat.format(currentdate);
}
		
}
