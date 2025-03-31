package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;

public class TestBase {
	protected HomePage homepage;

	@BeforeMethod(description = "loading homepage of Jupiter Toys application")
	public void setUp() {
		homepage = new HomePage();
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {

		homepage.quit();
	}

}
