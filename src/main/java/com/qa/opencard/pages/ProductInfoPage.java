package com.qa.opencard.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencard.utils.ElementUtil;

public class ProductInfoPage {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	private ElementUtil eleUtil;

	
	private By ProductHeaderName=By.xpath("//div[@id='content']//div/h1");
	private By ProductImages=By.cssSelector("ul.thumbnails img");
	private By ProductMetaData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By ProductPriceData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	@SuppressWarnings("unused")
	private By qty=By.id("input-quantity");
	@SuppressWarnings("unused")
	private By addToCart=By.id("button-cart");
	
	private Map<String, String> productInfoMap;
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	
	public String getproductHeader() {
		
		 
				String Text= eleUtil.doGetText(ProductHeaderName);
				System.out.println(Text);
				return Text;
	}
	
	public int getProductImages() {
		return eleUtil.waitForElementsToBeVisible(ProductImages, 10).size();
	}
	public Map<String, String> getProdcutInfo() {
		
		productInfoMap=new HashMap<String,String>();
		productInfoMap.put("Product Name ", getproductHeader());
		getProductMetaData();
		getProPriceData();
		return productInfoMap;
		
		
		
	}
	public void getProductMetaData() {
		List<WebElement> metaDataList= eleUtil.getElements(ProductMetaData);
		for(WebElement e: metaDataList ) {
			String text= e.getText();
		String meta[]=	text.split(":");
		String metaKey=meta[0].trim();
		String metaValue=meta[1].trim();
		productInfoMap.put(metaKey, metaValue);
		
			
		}
	}
	
	public void getProPriceData() {
		List<WebElement> metaPriceList= eleUtil.getElements(ProductPriceData);
	String Price=metaPriceList.get(0).getText().trim();
	String ExPrice=metaPriceList.get(1).getText().trim();
	
	productInfoMap.put("price", Price);
	productInfoMap.put("ExTaxPrice", ExPrice);
	
		}
	}

