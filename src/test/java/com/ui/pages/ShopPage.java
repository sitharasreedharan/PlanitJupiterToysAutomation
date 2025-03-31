package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class ShopPage extends BrowserUtility {
	
	private static final By CART_LINK_LOCATOR = By.xpath("//a[contains(text(),'Cart')]");
	
	public ShopPage(WebDriver driver) {
		super(driver);
	}

	public ShopPage addItemsToCart(String productName, int itemCount) { 
		WebElement productTitle = getElement(By.xpath("//h4[normalize-space(text())='" + productName + "']"));
	    WebElement buy = productTitle.findElement(By.xpath("ancestor::li//a[text()='Buy']"));	    
	    for(int i = 1; i <= itemCount; i++) { 
	        buy.click();
	    }
	   
	    return this;
	}
	
	public double getPrice(String productName) {
	  
	    WebElement productTitle = getElement(By.xpath("//h4[normalize-space(text())='" + productName + "']"));   
        WebElement priceElement = productTitle.findElement(By.xpath("ancestor::li//span[contains(@class,'product-price')]"));
        String priceText = priceElement.getText().replace("$", "").trim();
	    return Double.parseDouble(priceText);
	}
	
	public CartPage goToCartPage() {
		clickOn(CART_LINK_LOCATOR);
		return new CartPage(getDriver());
	}

}
