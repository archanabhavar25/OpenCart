package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtusername;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='allowMarketingEmails']")
	WebElement chk;
	
	@FindBy(xpath="//button[@id='otp-login-btn']")
	WebElement btnclick;
	
	//@FindBy(xpath="//input[@id='input-firstname']")
	//WebElement txtFirstName;
	
	//@FindBy(xpath="//input[@id='input-lastname']")
	//WebElement txtLastName;
	
	
	
	//@FindBy(xpath="//select[@id='input-country']")
	//WebElement selCountry;
	
	//@FindBy(xpath="//input[@id='input-password']")
	//WebElement txtPassWord;
	
	
	
	@FindBy(xpath="//span[@id='my-error-id']")
	WebElement msgSuccess;
	
	public void setUserName(String user)
	{
		txtusername.sendKeys(user);
	}
	/*
	public void setFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
	}*/
	/*
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}*/
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	/*
	public void setCountry(String country)
	{
		selCountry.sendKeys(country);
	}*/
	/*
	public void setPassword(String pwd)
	{
		txtPassWord.sendKeys(pwd);
	}*/
	
	public void clicktchkbtn()
	{
		chk.click();
	}
	public void buttonclick()
	{
		btnclick.click();
	}
	
	public String getsuccessMessage()
	{
		try
		{
			return (msgSuccess.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}

}
