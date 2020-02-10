
package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Neethu Sebastian NS00372561
 * This class contains methods and Objects for Login page of Orange HRM application
 *
 */
public class LoginPage {

WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver = driver;
}

@FindBy(id="txtUsername") WebElement txtbx_Username;
@FindBy(id="txtPassword") WebElement txtbx_Password;
@FindBy(name="Submit") WebElement btn_Submit;	

public void ApplicationLogin(String UN, String pw)
{
	txtbx_Username.sendKeys(UN);
	txtbx_Password.sendKeys(pw);
	btn_Submit.click();
}

}
