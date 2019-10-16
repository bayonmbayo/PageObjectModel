package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	By anmeldenHomeLink = By.xpath("//a[@id='nav-link-accountList']");
	By anmeldenLink = By.xpath("//span[@class='nav-action-inner']");
	
	public LoginPage() throws InterruptedException {	
		driver.findElement(anmeldenHomeLink).click();
		Thread.sleep(2000);
		driver.findElement(anmeldenLink).click();
		Thread.sleep(2000);
	}
	
	public void anmelden() throws InterruptedException {
		WebElement elEmail= driver.findElement(By.xpath("//input[@id='ap_email']"));
		elEmail.sendKeys("bayon2010@hotmail.fr");
		WebElement elWeiter= driver.findElement(By.xpath("//input[@id='continue']"));
		elWeiter.click();
		Thread.sleep(5000);
		WebElement elPassword= driver.findElement(By.xpath("//input[@id='ap_password']"));
		elPassword.sendKeys("jmd563de");
		WebElement elSubmit = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		elSubmit.click();
		Thread.sleep(5000);
	}
}
