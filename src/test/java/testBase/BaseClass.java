package testBase;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

public class BaseClass {
	
public WebDriver driver;
public Logger logger;
public Properties p;

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		FileReader file= new FileReader("./src//test//resources//configProperties");
		p= new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		//if execution_env=remote
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("No matching os");
				return;
			}
		
		
		//if execution_env=local
		
		switch(br)
		{
		case "chrome" : capabilities.setBrowserName("Chrome");break; 
		case "edge" :  capabilities.setBrowserName("edge"); break;
		case "firefox" : capabilities.setBrowserName("firefox"); break;
		//case "edge" :   driver= new EdgeDriver(); break;
		//case "firefox" : driver= new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name.....");return;
		}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
		}
		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get(p.getProperty("appURL"));
		//driver.get("https://tutorialsninja.com/demo/");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}

