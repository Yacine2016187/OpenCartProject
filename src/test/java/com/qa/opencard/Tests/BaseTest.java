package com.qa.opencard.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.opencard.Factory.DriverFactory;
import com.qa.opencard.pages.AccountsPage;
import com.qa.opencard.pages.LoginPage;
import com.qa.opencard.pages.ProductInfoPage;
import com.qa.opencard.pages.RegistrationPage;

import com.qa.opencard.pages.SearchResultPage;

public class BaseTest {

	 DriverFactory df;
	 LoginPage loginpage;
	 WebDriver driver;
	 Properties prop;
	 AccountsPage accpage;
	 SearchResultPage searchresult;
	 ProductInfoPage productinfo;
	 RegistrationPage registernew;
	@BeforeTest
	public void Setup() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginpage=new LoginPage(driver);
	}
	
//	@AfterTest
//	public void TearDown(){
//driver.close();
//}
}
