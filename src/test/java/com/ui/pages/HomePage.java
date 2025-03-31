package com.ui.pages;

import org.openqa.selenium.By;

import com.ui.pojo.Config;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {

	private static final By CONTACT_LINK_LOCATOR = By.xpath("//a[contains(text(),'Contact')]");
	private static final By SHOP_LINK_LOCATOR = By.xpath("//a[contains(text(),'Shop')]");

	public HomePage() {
		super(JSONUtility.readJSON().getBrowser(),JSONUtility.readJSON().isHeadless());
		Config config = JSONUtility.readJSON();
		goToWebsite(config.getUrl());
	}

	public ContactPage goToContactPage() {
		clickOn(CONTACT_LINK_LOCATOR);
		return new ContactPage(getDriver());
	}

	public ShopPage goToShopPage() {
		clickOn(SHOP_LINK_LOCATOR);
		return new ShopPage(getDriver());
	}

}
