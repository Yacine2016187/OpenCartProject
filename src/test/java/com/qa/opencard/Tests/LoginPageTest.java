package com.qa.opencard.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencard.utils.Constants;



public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void LogoTest() {
	Boolean L=	loginpage.logodisplayed();
		Assert.assertTrue(L);
		System.out.println("Logo dispalyed succ");
	}
	@Test(priority = 2)
	public void GetTitle() {
		String AccTitle=loginpage.TitleLogin();
		Assert.assertEquals(AccTitle, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 3)
	public void testForgotPass() {
		Boolean forg=loginpage.Forgetten();
		Assert.assertTrue(forg);
		System.out.println("Link availble");
	}
	@Test(priority = 4)
	public void LoginToApplication() {
		accpage= loginpage.LoginToApp(prop.getProperty("UserN").trim(),prop.getProperty("PassW").trim());
		System.out.println(accpage.GetAccountPageTitle());
		System.out.println("Log to app succefulle");
	}

}
