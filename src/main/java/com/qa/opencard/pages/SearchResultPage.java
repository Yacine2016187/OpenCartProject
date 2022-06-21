package com.qa.opencard.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencard.utils.Constants;
import com.qa.opencard.utils.ElementUtil;

public class SearchResultPage {
private WebDriver driver;
private ElementUtil eleUtil;





private By ProductResult=By.xpath("//div[@class='row']/div//h4/a");






public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}

public int getproductListCount() {
int productcount=	eleUtil.waitForElementsToBeVisible(ProductResult, 10).size();
System.out.println("the product count is "+productcount);
return productcount;

}
public ProductInfoPage selectProduct(String mainproduct) {
	List<WebElement>searchList= eleUtil.waitForElementsToBeVisible(ProductResult,Constants.DEFAULT_TIME_OUT);
	for(WebElement e: searchList) {
		String Text= e.getText();
		if(Text.equals(mainproduct)) {
			e.click();
			break;
		}
	}
	return new ProductInfoPage(driver);
}

	
}
