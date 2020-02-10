/**
 * 
 */
package com.hrm.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author NS00372561
 *This class contains all the browser reusable methods
 */
public class BrowserUtils {

	
	public static WebDriver launchBrowser(WebDriver driver, String Browsername, String Url)
	{
		Browsername = Browsername.toUpperCase();
		
	switch(Browsername)
	{
	case "CHROME" :System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					driver = new ChromeDriver();
					break;
	case "IE"	 :System.setProperty("webdriver.chrome.driver", "./Drivers/IE.exe");
					driver = new ChromeDriver();
					break;
	case "FIREFOX" :System.setProperty("webdriver.chrome.driver", "./Drivers/FIREFOX.exe");
					driver = new ChromeDriver();
					break;
	case "EDGE" :System.setProperty("webdriver.chrome.driver", "./Drivers/Edge.exe");
					driver = new ChromeDriver();
					break;
	default:	System.out.println("This browser is not configured!!!!");
	}
		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(Url);
	
	return driver;
	}

	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
