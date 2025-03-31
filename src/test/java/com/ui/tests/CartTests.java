package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ui.pages.CartPage;

public class CartTests extends TestBase {

	@Test(description = "Add items to cart and verify item,price,quantity,subtotal and total")
	public void ShopProductsAndVerifyDetails() {
		var shopPage = homepage.goToShopPage()
				.addItemsToCart("Stuffed Frog", 2)
				.addItemsToCart("Fluffy Bunny", 5)
				.addItemsToCart("Valentine Bear", 3);

		double shopPageProductPrice1 = shopPage.getPrice("Stuffed Frog");
		double shopPageProductPrice2 = shopPage.getPrice("Fluffy Bunny");
		double shopPageProductPrice3 = shopPage.getPrice("Valentine Bear");

		CartPage cartPage = shopPage.goToCartPage();
		assertEquals(shopPageProductPrice1, cartPage.getPrice("Stuffed Frog"));
		assertEquals(shopPageProductPrice2, cartPage.getPrice("Fluffy Bunny"));
		assertEquals(shopPageProductPrice3, cartPage.getPrice("Valentine Bear"));

		assertEquals(cartPage.getPrice("Stuffed Frog") * cartPage.getQuantity("Stuffed Frog"),
				cartPage.getSubTotal("Stuffed Frog"));
		assertEquals(cartPage.getPrice("Fluffy Bunny") * cartPage.getQuantity("Fluffy Bunny"),
				cartPage.getSubTotal("Fluffy Bunny"));
		assertEquals(cartPage.getPrice("Valentine Bear") * cartPage.getQuantity("Valentine Bear"),
				cartPage.getSubTotal("Valentine Bear"));

		var expectedTotalValue = cartPage.getSubTotal("Stuffed Frog") + cartPage.getSubTotal("Fluffy Bunny")
				+ cartPage.getSubTotal("Valentine Bear");
		assertEquals(cartPage.getTotalValue(), expectedTotalValue);

	}

}
