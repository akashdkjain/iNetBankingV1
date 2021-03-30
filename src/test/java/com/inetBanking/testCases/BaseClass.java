package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetBanking.utilities.readConfig;

public class BaseClass{
	
	readConfig ReadConfig = new readConfig();
	public String baseURL = ReadConfig.getApplicationURL();
	public String UserName = ReadConfig.getUserName();
	public String Password = ReadConfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ReadConfig.getChromepath());
			driver = new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ReadConfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		
		else if(br.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ReadConfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown() {		
		driver.quit(); 
	}
	
	// Method to check if alert is present or not
		public boolean isALertPresent()
		{
			try 
			{
				driver.switchTo().alert();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
	
}
