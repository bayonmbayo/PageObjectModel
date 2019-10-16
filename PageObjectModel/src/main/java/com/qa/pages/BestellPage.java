package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.base.TestBase;

public class BestellPage extends TestBase {
		
		//@FindBy(xpath = "//a[contains(text(),'Bestseller')]")
		//WebElement logo;
		By bestellHeader = By.xpath("//div[@id='zg_banner_text_wrapper']");
		By BestellLink = By.xpath("//a[contains(text(),'Bestseller')]");
		
		public BestellPage() {	
			driver.findElement(BestellLink).click();
		}
		
		public String validateHeader() {
			WebElement bestellH = driver.findElement(bestellHeader);
			return bestellH.getText();
		}
	
}
