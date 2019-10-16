package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.util.TestUtil;

public class LoginPageTest1 {
	
	static WebDriver driver;
	String sheetName = "LoginData";
	By usernameLoc = By.name("txtUsername");
	By passwordLoc = By.name("txtPassword");
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeSuite
	public void begin() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\bayon\\eclipse-workspace\\PageObjectModel\\test-output\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("LoginPageTest1", "this is a test for functionalities of login page");
	}
	
	@BeforeMethod
	public void setUp() {
		test.log(Status.INFO, "Launching the Chrome browser");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		test.log(Status.INFO, "Deleting all cookies");
		driver.manage().window().maximize();
		test.log(Status.INFO, "Maximizing the window");
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com");
		test.log(Status.INFO, "Navigated to opensouce");
			
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getLoginData")
	public void loginTest(String username, String password) throws InterruptedException {
		driver.findElement(usernameLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(password);
		Thread.sleep(3000);
		test.log(Status.INFO, "Logintest passed");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
			
	}
	
	@AfterSuite
	public void finished() {
		test.log(Status.INFO, "Test completed");
		extent.flush();
	}
}
