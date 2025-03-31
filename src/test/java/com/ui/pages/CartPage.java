package com.ui.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class CartPage extends BrowserUtility {
	
	private static final By CART_TABLE_LOCATOR = By.className("cart-items");
	private static final By TOTAL_LOCATOR = By.className("total");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	

	private Map<String, Double[]> getPriceAndSubtotalFromTable() {
	    Map<String, Double[]> itemDetails = new HashMap<>();   
	    List<WebElement> rows = getElement(CART_TABLE_LOCATOR).findElements(By.xpath(".//tbody/tr"));
	    
	    for (WebElement row : rows) {
	        // getting item name
	        String itemName = row.findElement(By.xpath(".//td[1]")).getText().trim();//
            // getting price
	        String priceText = row.findElement(By.xpath(".//td[2]")).getText().replace("$", "").trim();
	        double price = Double.parseDouble(priceText);
	        // getting quantity 
	        WebElement quantityElement = row.findElement(By.xpath(".//td[3]//input"));
	        int quantity = Integer.parseInt(quantityElement.getAttribute("value").trim());
	        // getting Subtotal 
	        String subtotalText = row.findElement(By.xpath(".//td[4]")).getText().replace("$", "").trim();
	        double actualSubtotal = Double.parseDouble(subtotalText);	        	       
	        itemDetails.put(itemName, new Double[]{price, (double) quantity, actualSubtotal});
	    }
	    
	    return itemDetails;
	}
	
	public double getPrice(String productName) {		
		 			    
		Double[] details = getPriceAndSubtotalFromTable().get(productName);
	    return (details != null) ? details[0] : -1; // Return -1 if the product is not found
	}

	public double getQuantity(String productName) {
		 Double[] details = getPriceAndSubtotalFromTable().get(productName); 		    
		 return (details != null) ? details[1] : -1;
	}
	
	public double getSubTotal(String productName) {
		 Double[] details = getPriceAndSubtotalFromTable().get(productName); 		    
		 return (details != null) ? details[2] : -1;
	}
	
	public double getTotalValue() {	    
	    WebElement totalElement = getElement(TOTAL_LOCATOR);  
	    String totalText = totalElement.getText().replace("Total:", "").trim();
	    return Double.parseDouble(totalText);
	}
	
	
    
}

	


