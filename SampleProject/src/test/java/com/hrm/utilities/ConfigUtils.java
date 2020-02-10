package com.hrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {
	
	Properties properties;
	
public ConfigUtils()
{
	File src = new File("./config/config.properties");

	try {	
		FileInputStream fis = new FileInputStream(src);
	properties =new Properties();
		properties.load(fis);
	} catch (Exception e) {
		
	System.out.println("Cannot load the config file --> "+ e.getMessage());	
	}
}

public String getDataFromConfig(String Key)
{
	return properties.getProperty(Key);
}

public String getBrowser()
{
	return properties.getProperty("browser");
}

public String getQaUrl()
{
	return properties.getProperty("qaurl");	
}


}
