package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;

public class TC001_LoginSuccess extends BaseClass {

	@Test
	public void loginTest() 
	{
		driver.get(baseURL);
		
		loginPage LoginPage = new loginPage(driver);
		logger.info("Login page launched");
		
		LoginPage.setUsername(UserName);
		LoginPage.setPassword(Password);
		logger.info("Credentials entered");
		
		LoginPage.clickLogin();
		logger.info("Login button clicked");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Home Page Title Verified");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Home Page Title Verificition failed");
		}
		
		
	}

}
