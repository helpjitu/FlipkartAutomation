package page.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;
import page.locators.HomePageLocators;

public class HomePage extends Page{
	public HomePageLocators homePageLocators;
	public HomePage()
	{
		this.homePageLocators=new HomePageLocators();
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.homePageLocators);
	}
	
	public HomePage clickOnSignIn()
	{
		LOGGER.info("Clicking on SignInButton");
		clickElement(homePageLocators.signInButton);
		return this;
	} 
}
