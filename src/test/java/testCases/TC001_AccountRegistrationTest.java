package testCases;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	//WebDriver driver;
	@Test
	public void verify_account_registration() throws InterruptedException
	{
		
		logger.info("*******Starting TC001_AccountRegistrationTest*********");
		HomePage hp = new HomePage(driver);
		hp.clickRegister();
		logger.info("click on register button...");
		
		AccountRegistrationPage accregpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		accregpage.setUserName(randomeString().toUpperCase());
		
		accregpage.setEmail(randomeString()+"@gmail.com"); //randomly generated email
		//accregpage.setCountry("India");
		
		//String password = randomAlbhaNumberic();
		//accregpage.setPassword(password);
		
		accregpage.clicktchkbtn();
		logger.info("validating expected message...");
		
		Thread.sleep(5000);
		accregpage.buttonclick();
		/*
		String msg = accregpage.getsuccessMessage();
		Assert.assertEquals(msg, " Success: You passed!");
		}
		catch(Exception e)
		{
			logger.error("Test failed...");
			logger.debug("Debug logs");
			Assert.fail();
		}*/
		
	}
	
	public String randomeString()
	{
		String randomString = RandomStringUtils.randomAlphanumeric(10);
		//String generatedString = RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}
	public String randomeNumber()
	{
		String genratedNumber =RandomStringUtils.randomNumeric(10);
		return genratedNumber;
	}
	
	public String randomAlbhaNumberic()
	{
		String genratedString = RandomStringUtils.randomAlphabetic(3);
		String genratedNumber = RandomStringUtils.randomNumeric(3);
		return (genratedString+"@"+genratedNumber);
	}
}
