package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;
	
	public readConfig()
	{
		
		File src = new File("./Configurations/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is" +e.getMessage() );
			
		}
	} 
	
	public String getApplicationURL() 
		{
		String url = pro.getProperty("baseURL");
		return url;
		} 

	public String getUserName() 
		{
		String userName = pro.getProperty("UserName");
		return userName;
		} 
	
	public String getPassword() 
		{
		String password = pro.getProperty("password");
		return password;
		} 

	public String getChromepath() 
		{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
		} 

	public String getIEpath() 
		{
		String IEpath = pro.getProperty("iepath");
		return IEpath;
		} 
	
	public String getFirefoxpath() 
		{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
		} 
}
