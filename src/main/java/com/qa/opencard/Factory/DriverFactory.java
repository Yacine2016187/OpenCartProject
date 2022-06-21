package com.qa.opencard.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;


public WebDriver init_driver(Properties prop) {
String 	BrowserName=prop.getProperty("Browsername");
	System.out.println("Application will be run with "+prop.getProperty("Browsername"));
	if(BrowserName.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
	}else if (BrowserName.equals("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}else {
		System.out.println("Please Enter The correct Browser ");
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	return driver;
	
	
}
public Properties init_prop() {
	 prop=new Properties();
	
	 
	 
	 FileInputStream file;
	try {
		file = new FileInputStream("C:\\Users\\Yacine\\eclipse-workspace\\OpenCart_HybridProject\\src\\test\\ressources\\config.properties");
		prop.load(file);
	} catch (FileNotFoundException e) {
	
	}
		catch (IOException e) {
		e.printStackTrace();
	}
	return prop;

}

public String getScreenshot() {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/ScreenShots/"+System.currentTimeMillis()+".png";
	File destination=new File(path);
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return path;
	
}

}