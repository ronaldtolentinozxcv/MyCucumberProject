package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	//method is for reading the config.properties
	public static Properties getProperties() throws IOException{
		FileReader file=new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		return p;
		
	}
	
	//This method initializes and returns a Selenium WebDriver instance based on config.parameters. 
//	public static WebDriver initializeBrowser() throws IOException
//	{
//		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) // check the value of execution_env
//		{
//			DesiredCapabilities capabilities= new DesiredCapabilities();
//			
//			//for operating system
//			if(getProperties().getProperty("os").equalsIgnoreCase("windows"))
//			{
//				capabilities.setPlatform(Platform.WIN11);
//			}
//			else if(getProperties().getProperty("os").equalsIgnoreCase("mac")) 
//			{
//				capabilities.setPlatform(Platform.MAC);
//			}
//			else if(getProperties().getProperty("os").equalsIgnoreCase("linux")) 
//			{
//				capabilities.setPlatform(Platform.LINUX);
//			}
//			else 
//			{
//				System.out.print("No matching OS...");
//			}
//			
//			//for browser
//			switch (getProperties().getProperty("browser").toLowerCase()) {
//			case "chrome": capabilities.setBrowserName("chrome"); break;
//			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
//			case "firefox": capabilities.setBrowserName("Firefox"); break;
//			default: System.out.println("No matching browser...");
//			}
//			driver=new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), capabilities);					
//		}
//		else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
//		{
//			switch(getProperties().getProperty("browser").toLowerCase()) 
//			{
//			case "chrome": driver=new ChromeDriver(); break;
//			case "edge": driver=new EdgeDriver(); break;
//			case "firefox": driver=new FirefoxDriver(); break;
//			default: System.out.println("No matching browser"); driver=null;
//				
//			}
//		}
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		
//		return driver;
//	}
//	
//	//Returns the current WebDriver instance. Useful for accessing the driver in other classes without creating multiple instances.
//	public static WebDriver getDriver() {
//		return driver;
//	}
	
	
	//this method is for logs
	public static Logger getLogger()
	{
		logger=LogManager.getLogger(); //log4j
		return logger;		
	}
	
	//Method for generating random string
	public static String randomString()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public static String ramdomNumber()
	{
		String generateString=RandomStringUtils.randomNumeric(6);
		return generateString;
	}
	
	public static String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(6);
		return str+num;
	}
	
	public static String getCurrentURL()
	{
		return DriverFactory.getDriver().getCurrentUrl();
	}
	
	
	
	

}
