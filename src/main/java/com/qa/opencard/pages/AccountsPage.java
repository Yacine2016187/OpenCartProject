package com.qa.opencard.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencard.utils.Constants;
import com.qa.opencard.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	
	
	private By header=By.cssSelector("div#logo a");
	private By AcountsSection=By.xpath("//div[@id='content']/h2");
	private By searchFile=By.name("search");
	private By searchBtn=By.cssSelector("div#search button");
	private By LogOutLink=By.linkText("Logout");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	
	public String GetAccountPageTitle() {
		return driver.getTitle();
				//eleUtil.doGetTitle(Constants.AccountPage_Title, Constants.DEFAULT_TIME_OUT);
	}
	 public String getAccountPageHeaders() {
		return eleUtil.doGetText(header);
	 }
	 public boolean isLogoutLinkExcit() {
        return eleUtil.doIsDisplayed(LogOutLink);
	 }
	
	public void logout() {
		if(isLogoutLinkExcit()) {
			eleUtil.doClick(LogOutLink);
		}
	}
	
	public List<String> getAccountSectionList() {
		List<WebElement> accSecList= eleUtil.waitForElementsToBeVisible(AcountsSection, Constants.DEFAULT_TIME_OUT);
		List<String> accSecValueList=new ArrayList<>();

for(WebElement e: accSecList) {
	String text =e.getText();
	accSecValueList.add(text);
}
return accSecValueList;
	}
	
	public boolean isSearchExcit() {
		return eleUtil.doIsDisplayed(searchFile);
	}
	
	public SearchResultPage doSerach(String ProductName) {
		System.out.println("searching the product of "+ProductName);
		eleUtil.doSendKeys(searchFile, ProductName);
		eleUtil.doClick(searchBtn);
		return new SearchResultPage(driver);
		
	}
	
	
	
	
	
}
