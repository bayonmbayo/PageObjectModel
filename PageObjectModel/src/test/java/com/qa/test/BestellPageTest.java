package com.qa.test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


import com.qa.base.TestBase;
import com.qa.jira.ScriptMetaData;
import com.qa.pages.BestellPage;

public class BestellPageTest extends TestBase {
	
	BestellPage bestellpage;
	

	@BeforeMethod
	public void setUp() {
		initialization();
		bestellpage = new BestellPage();
	}
	
	@ScriptMetaData(ticketReady = true)
	@Test
	public void BestellHeaderTest() {
		String bestellH = bestellpage.validateHeader();
		assertEquals(bestellH, "Bestselle", "This is not the correct title");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
