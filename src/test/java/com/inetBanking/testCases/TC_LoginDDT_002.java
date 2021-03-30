package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	
	@Test (dataProvider="LoginData")
	public void loginDDT(String user, String password) throws InterruptedException
	{
		loginPage lp = new loginPage(driver);
		
		lp.setUsername(user);
		lp.setPassword(password);
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		
		if(isALertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") +"/src/test/java/com/inetBanking/testData/TestData.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colnum = XLUtils.getCellCount(path, "sheet1", 1);
		
		String loginData[][] = new String[rownum][colnum];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				loginData[i-1][j]= XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return loginData;
	}
	

}
