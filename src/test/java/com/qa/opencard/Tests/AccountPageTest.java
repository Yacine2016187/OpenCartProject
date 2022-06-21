package com.qa.opencard.Tests;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencard.utils.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void SetupLog() {
		accpage=loginpage.LoginToApp(prop.getProperty("UserN"), prop.getProperty("PassW"));
	}
	
	@Test (priority = 1)
	public void accPageTitleTest() {
	String AccTit=	accpage.GetAccountPageTitle();	
	System.out.println("Account page title is "+AccTit);
	//Assert.assertEquals(AccTit, Constants.AccountPage_Title);
	}
	@Test(priority = 2)
	public void AccPageHeader() {
	String Header=	accpage.getAccountPageHeaders();
	System.out.println("Account Page Is "+Header);
	Assert.assertEquals(Header, Constants.ACCOUNT_PAGE_HEADERS);
	}
	@Test(priority = 3)
	public void isLogoutExciteTest() {
		Assert.assertTrue(accpage.isLogoutLinkExcit());
		
	}
	@Test(priority = 4)
	public void AccountSection() {
		List <String>actAccList= accpage.getAccountSectionList();
		Assert.assertEquals(actAccList, Constants.getExpectedAccSecList());
	}
	@DataProvider
	public Object[][] ProductData() {
		return new Object[][] {
			{"MacBook"},
			{"Apple"},
			{"Samsung"},
		};
		
	}
	
	@Test(priority = 5, dataProvider = "ProductData")
	public void searchTest(String ProductName) {
		searchresult= accpage.doSerach(ProductName);
		Assert.assertTrue(searchresult.getproductListCount()>0);
		
	}
	
	@DataProvider
	public Object[][] productselectdata() {
		return new Object[][] {
			{"MacBook","MacBook Pro"},
			{"Apple","Apple Cinema 30\""},
			{"Samsung","Samsung SyncMaster 941BW"},
			{"iMac","iMac"}
		};
	}
	
	
	
	@Test(priority = 6,dataProvider ="productselectdata" )
	public void selectProductTest(String ProductName,String MainProductName) {
		searchresult=accpage.doSerach(ProductName);
		productinfo= searchresult.selectProduct(MainProductName);
		Assert.assertEquals(productinfo.getproductHeader(),MainProductName);
		
		
	}
	
}
