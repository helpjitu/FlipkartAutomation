package com;

import base.Page;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.actions.SearchPage;
import page.actions.SignInPage;
import utilities.Utilities;

import java.awt.*;
import java.util.Hashtable;

public class SearchProductTest extends Page {
    @Test(dataProviderClass = Utilities.class,dataProvider = "dp")
    public void searchProductTest(Hashtable<String, String> data) throws InterruptedException {
        if(data.get("runmode").equalsIgnoreCase("N"))
        {
            throw new SkipException("Skipping the test as the Run mode is NO");
        }
        else {
            initConfiguration();
            SignInPage signInPage=new SignInPage();
            signInPage.doLogin(data.get("username"),data.get("password"));
            SearchPage searchPage=new SearchPage();
            searchPage.searchProduct(data.get("productName"));
            Thread.sleep(3000);
        }
    }
    @AfterMethod
    public void end()
    {
        tearDown();
    }
}
