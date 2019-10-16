package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;


public class HomePageTest extends TestBase {
	
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		
	}
	
	@Test
	public void clickOnLogoLinkTest() {
		homePage.clickOnLogoLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}