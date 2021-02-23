package page.actions;

import base.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import page.locators.SearchPageLocators;
import page.locators.SignInPageLocators;

public class SearchPage extends Page {

    public SearchPageLocators searchPage;
    public SearchPage()
    {
        this.searchPage=new SearchPageLocators();
        AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory, this.searchPage);
    }

    public  void searchProduct(String productName)
    {
        LOGGER.info("Typing product name");
        type(searchPage.searchField,productName);
        Actions actions=new Actions(driver);
        actions.click().sendKeys(Keys.ENTER).perform();

      //  clickElement(searchPage.searchProductButton);
    }
}
