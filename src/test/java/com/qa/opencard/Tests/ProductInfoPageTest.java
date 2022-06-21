package com.qa.opencard.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencard.utils.Constants;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void SetupLog() {
		accpage=loginpage.LoginToApp(prop.getProperty("UserN"), prop.getProperty("PassW"));
	}
	@Test(priority = 1)
	public void productHeaderTest() {
		searchresult = accpage.doSerach("MacBook");
		productinfo = searchresult.selectProduct("MacBook Pro");
		Assert.assertEquals(productinfo.getproductHeader(), "MacBook Pro");
	}

	@Test(priority = 2)
	public void productImagesCountTest() {
		searchresult = accpage.doSerach("iMac");
		productinfo = searchresult.selectProduct("iMac");
		Assert.assertEquals(productinfo.getProductImages(), Constants.IMAC_IMAGE_COUNT);
	}
	
	@Test
	public void productinfoTest() {
		searchresult = accpage.doSerach("MacBook");
		productinfo = searchresult.selectProduct("MacBook Pro");
	Map<String,String>accproductinfo=	productinfo.getProdcutInfo();
	accproductinfo.forEach((k,v)->System.out.println(k+":"+v));
		
		
		
		
		

	}














}