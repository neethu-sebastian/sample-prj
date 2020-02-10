/**
 * 
 */
package com.hrm.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.pages.LoginPage;
import com.hrm.pages.baseClass;

/**
 * @author NS00372561
 *Test case ID - TC_001
  Test title - Validate login for Valid Username and password
 */
public class LoginValidCredTest extends baseClass {



	@Test
public void logincheck()
{
	logger = report.createTest("Login To OHRM");
		//PageFactory.initElements(driver, LoginPage.class) will return an object of LoginPage.
	
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	logger.info("Staring the test");
	loginpage.ApplicationLogin(excel.getStringData("Login",0,1),excel.getStringData("Login",0,1));
	Assert.assertEquals(true, driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	logger.pass("Passed the Test");
}
	
	
}
