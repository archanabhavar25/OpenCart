package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")//My Account page heading
	WebElement txtmyaccount;
	
	public boolean isMyAccountPageExist()
	{
		try 
		{
			return(txtmyaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
