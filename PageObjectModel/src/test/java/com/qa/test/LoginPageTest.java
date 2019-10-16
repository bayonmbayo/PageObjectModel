package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void anmeldenTest() throws InterruptedException {
		loginPage.anmelden();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
