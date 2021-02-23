package com;

import base.Page;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.actions.SignInPage;
import utilities.Utilities;

import java.util.Hashtable;

public class SignUpTest extends Page {
  @Test(dataProviderClass = Utilities.class,dataProvider = "dp")
    public void signUpTest(Hashtable<String,String> data) throws InterruptedException {

        if(data.get("runmode").equalsIgnoreCase("N"))
        {
            throw new SkipException("Sign Up Skipped as the runmode is No");
        }
        else {
            initConfiguration();
            SignInPage signUp = new SignInPage();
            signUp.doSignUp(data.get("username"));
            Thread.sleep(5000);
        }

    }
    @AfterMethod
    public void end()
    {
        tearDown();
    }
}
