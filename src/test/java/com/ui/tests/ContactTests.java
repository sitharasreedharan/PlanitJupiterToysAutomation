package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ui.pages.ContactPage;
import com.ui.pojo.Contact;

public class ContactTests extends TestBase {

	@Test(description = "Verifies error message in contactPage")

	public void validateErrorMessages() {
		ContactPage contactPage = homepage.goToContactPage().clickSubmitButton();
		assertEquals(contactPage.getForeNameError(), "Forename is required");
		assertEquals(contactPage.getEmailError(), "Email is required");
		assertEquals(contactPage.getMessageError(), "Message is required");
	}

	@Test(description = "Verifies error message in contactPage are gone")
	public void validateErrorMessagesDisappeared() {
		ContactPage contactPage = homepage.goToContactPage().clickSubmitButton().enterContactDetails("test", "surname",
				"test.surname@gmail.com", "123456", "heloo");
		assertEquals(contactPage.getForeNameError(), "");
		assertEquals(contactPage.getEmailError(), "");
		assertEquals(contactPage.getMessageError(), "");
	}

	@Test(description = "Verifies successfull message upon contact form submission", dataProviderClass = com.ui.dataProvider.ContactDataProvider.class, dataProvider = "ContactTestCSVDataProvider")
	public void validateContactFormSuccessMessage(Contact contact) {
		ContactPage contactPage = homepage.goToContactPage().enterContactDetails(contact.getForeName(),
				contact.getSurName(), contact.getEmail(), contact.getTelephone(), contact.getMessage())
				.clickSubmitButton();
		String expectedMsg = "Thanks " + contact.getForeName() + ", we appreciate your feedback.";
		assertEquals(contactPage.getSuccessMessage(), expectedMsg);
	}

	@Test(description = "Verifies successfull message upon contact form submission", invocationCount = 5) // alternate way.using invocationCount to run 5 times
	public void validateSuccessMessage() {
		ContactPage contactPage = homepage.goToContactPage()
				.enterContactDetails("sithara", "sithara", "test.surname@gmail.com", "123456", "heloo")
				.clickSubmitButton();
		String expectedMsg = "Thanks " + "sithara" + ", we appreciate your feedback.";
		assertEquals(contactPage.getSuccessMessage(), expectedMsg);
	}

}
