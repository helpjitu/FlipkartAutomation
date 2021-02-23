package com;

import base.Page;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.actions.SignInPage;
import utilities.Utilities;

import java.util.Hashtable;

public class SignInTest extends Page{
//	@BeforeMethod(dataProviderClass = Utilities.class,dataProvider = "dp")
//	public void start()
//	{
//		initConfiguration();
//	}
	@Test(dataProviderClass = Utilities.class,dataProvider = "dp")
	public void signInTest(Hashtable<String, String> data)
	{
		if(data.get("runmode").equalsIgnoreCase("N"))
		{
			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		else {
			initConfiguration();
			SignInPage signIn = new SignInPage();
			signIn.doLogin(data.get("username"), data.get("password"));
		}
	}
	
	@AfterMethod
	
	public void end()
	{
		tearDown();
	}
}
