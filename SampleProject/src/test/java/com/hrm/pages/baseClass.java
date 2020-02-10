/**
 * 
 */
package com.hrm.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hrm.utilities.BrowserUtils;
import com.hrm.utilities.ConfigUtils;
import com.hrm.utilities.DriverUtils;
import com.hrm.utilities.ExcelUtils;

/**
 * @author NS00372561
 * This class contains application util files
 */
public class baseClass {
	public WebDriver driver;
	public ExcelUtils excel;
	public ConfigUtils config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		excel = new ExcelUtils();
		config=new ConfigUtils(); 
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+DriverUtils.Current_TMS()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserUtils.launchBrowser(driver,config.getBrowser(),config.getQaUrl());
	}
	
	@AfterMethod
	public void teardownMathod(ITestResult result) throws IOException
	{
	 if(result.getStatus()==ITestResult.FAILURE)
	 {
		logger.fail("Test failed...", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.captureScreenshot(driver)).build());
	 }
	 else if (result.getStatus()==ITestResult.SUCCESS)
	 {
		 DriverUtils.captureScreenshot(driver);
		logger.pass("Test failed...", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.captureScreenshot(driver)).build());
	 
	 }
	 else
	 {
	 logger.skip("Test failed...", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.captureScreenshot(driver)).build()); 
	 }
	 report.flush();
	}
	
	@AfterClass
	public void teardown()
	{
		BrowserUtils.closeBrowser(driver);
	}
}
