package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ContactPage extends BrowserUtility {

	private static final By FORENAME_LOCATOR = By.id("forename");
	private static final By SURNAME_LOCATOR = By.id("surname");
	private static final By EMAIL_LOCATOR = By.id("email");
	private static final By TELEPHONE_LOCATOR = By.id("telephone");
	private static final By MESSAGE_LOCATOR = By.id("message");
	private static final By SUBMIT_LOCATOR = By.xpath("//a[contains(.,'Submit')]");

	private static final By FORENAME_ERROR_LOCATOR = By.id("forename-err");
	private static final By EMAIL_ERROR_LOCATOR = By.id("email-err");
	private static final By MESSAGE_ERROR_LOCATOR = By.id("message-err");
	private static final By SUCCESSMESSAGE_LOCATOR = By.className("alert-success");
	

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public ContactPage clickSubmitButton() {
		waitForElement(SUBMIT_LOCATOR,"visible",3);
		clickOn(SUBMIT_LOCATOR);
		return this;
	}

	public String getForeNameError() {
		return getVisibleText(FORENAME_ERROR_LOCATOR);
	}

	public String getEmailError() {
		return getVisibleText(EMAIL_ERROR_LOCATOR);
	}

	public String getMessageError() {		
		return getVisibleText(MESSAGE_ERROR_LOCATOR);
	}
	public String getSuccessMessage() {	
		waitForElement(SUCCESSMESSAGE_LOCATOR,"visible",20);
		return getVisibleText(SUCCESSMESSAGE_LOCATOR);
	}

	public ContactPage enterContactDetails(String foreName, String surName, String email, String telephone,
			String message) {
		enterText(FORENAME_LOCATOR, foreName, 5);
		enterText(SURNAME_LOCATOR, surName);
		enterText(EMAIL_LOCATOR, email);
		enterText(TELEPHONE_LOCATOR, telephone);
		enterText(MESSAGE_LOCATOR, message);		
		return this;
	}
}
