package com.qa.opencard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencard.utils.Constants;
import com.qa.opencard.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elemutil;
	 
	private By registerLink = By.linkText("Register");
	private By Username=By.id("input-email");
	private	By Password=By.id("input-password");
	private By LoginBtn=By.xpath("//input[@value='Login']");
	
	private By ForGot=By.linkText("Forgotten Password");
	private	By Logo=By.xpath("//img[@class='img-responsive']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elemutil=new ElementUtil(driver);
	}
	
	public boolean Forgetten() {
	return	elemutil.doIsDisplayed(ForGot);
	}
	public boolean logodisplayed() {
		return elemutil.doIsDisplayed(Logo);
	}
	public String TitleLogin() {
		return elemutil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	
	public AccountsPage LoginToApp( String User ,String Pass) {
		System.out.println("Application will be lunched with "+User+ " " +"and "+Pass);
		elemutil.doSendKeys(Username, User);
		elemutil.doSendKeys(Password, Pass);
		elemutil.doClick(LoginBtn);
		return new AccountsPage(driver);
	}
	public RegistrationPage goToRegisterPage() {
		elemutil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
}
