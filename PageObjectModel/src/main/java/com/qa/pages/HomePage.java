package com.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//@FindBy(xpath = "//a[contains(text(),'Bestseller')]")
	//WebElement logo;
	By logo = By.xpath("//a[contains(text(),'Bestseller')]");
	
	public HomePage() {	}
	
	public HomePage clickOnLogoLink() {
		Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(logo)).click(driver.findElement(logo)).build().perform();	
		return new HomePage();
	}
}
