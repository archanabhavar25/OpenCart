package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccountbtn;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginbtn;
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickMyAccount()
	{
		myAccountbtn.click();
	}
	
	public void clickLogin()
	{
		loginbtn.click();	}
}
