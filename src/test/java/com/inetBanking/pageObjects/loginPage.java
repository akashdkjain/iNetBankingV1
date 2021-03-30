package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
		WebDriver ldriver;
		
		public loginPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);					
		}
		
		@FindBy(name="uid")
		@CacheLookup
		WebElement txtUserName;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(name="btnLogin")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
		@CacheLookup
		WebElement logoutlink;

		public void setUsername(String userName)
		{
			txtUserName.sendKeys(userName);
		}

		public void setPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		
		public void clickLogin()
		{
			btnLogin.click();
		}
		
		public void clickLogout()
		{
			logoutlink.click();
		}
		
}