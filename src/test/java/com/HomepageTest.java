package com;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.Page;

public class HomepageTest extends Page{

	/*
	 * @Test public void home() throws InterruptedException {
	 * 
	 * initiateDriver(loadProp().getProperty("browser"));
	 * System.out.println("Opening Flipkart");
	 * 
	 * 
	 * 
	 * driver.get("https://flipkart.com"); // Thread.sleep(3000); // windowChild();
	 * SigninPage sp = new SigninPage(driver);
	 * sp.emailMoElement().sendKeys("9966671896");
	 * sp.passwordElement().sendKeys("Hello"); sp.signInButton().click();
	 * driver.quit(); }
	 */
	
	@BeforeTest
	public void startUrl() {
		initConfiguration();
	}
	
	@Test
	public void homePageTest()
	{
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		tearDown();
	}
	
}
