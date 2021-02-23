package page.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;
import page.locators.SignInPageLocators;

public class SignInPage extends Page{
	public SignInPageLocators signInPage;
	public SignInPage() {
		this.signInPage=new SignInPageLocators();
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.signInPage);
		
	}
	
	
	public void doLogin(String username, String password)
	{
		LOGGER.info("Entering email: "+username);
		type(signInPage.emailMobile, username);
		LOGGER.info("Entering password: ");
		type(signInPage.password, password);
		LOGGER.info("Clicking on sign in button");
		clickElement(signInPage.signInButton);
	}
	public void doSignUp(String emailMobile)
	{
		LOGGER.info("Clicking on sign up button");
		clickElement(signInPage.signUpButton);
		LOGGER.info("Entering email: "+emailMobile);
		type(signInPage.emailMobile, emailMobile);
		LOGGER.info("Clicking on continue button");
		clickElement(signInPage.continueButton);

	}

}
