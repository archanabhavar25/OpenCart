package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void verifyLogin()
	{
		logger.info("*****starting TC002_loginTest****");
		
		try
		{
		
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login Page
		LoginPage lgn = new LoginPage(driver);
		//lgn.setEmail(p.getProperty("email"));
		//lgn.setpassword(p.getProperty("password"));
		
		lgn.setEmail("archanabhavar25@gmail.com");
		lgn.setpassword("archana123");
		lgn.clickLogin();
		
		//My Account
		MyAccount acc = new MyAccount(driver);
		boolean targetPage = acc.isMyAccountPageExist();
				
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******Ending of Login Test******");
	}

}
