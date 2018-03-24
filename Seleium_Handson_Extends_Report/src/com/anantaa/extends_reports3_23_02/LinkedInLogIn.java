package com.anantaa.extends_reports3_23_02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedInLogIn extends Base{
	
	public static Properties pro=new Properties();;
	InputStream fis = LinkedInLogIn.class.getResourceAsStream("/config.properties");
	public String exResult;
	public String acResult;
	//WebDriver driver;
	public String actual;
	public String expected;
	
	
	@BeforeClass
	public void setUrl() throws IOException {
		pro.load(fis);
		String appUrl=pro.getProperty("linkedin");		
		url(appUrl);
	}
	

	@BeforeMethod
	public void setValue() {
		actual="false";
		expected="true";
	}
	
	/**
	 * Page title check
	 */
	@Test(priority=0)
	public void pageTitle()
	{
		test = extent.createTest("pageTitle");
		acResult=driver.getTitle();
		exResult="Login | LinkedIn";
		if(acResult.contains(exResult)) {
	    	actual="true";
	  }
		 Assert.assertEquals(actual, expected);		
	}
	
	/**
	 * Error message while both credential are blank
	 */	
	@Test(priority=1)
	public void errMsgBothBlank()
	{
		test = extent.createTest("errMsgBothBlank");
		driver.findElement(By.xpath("//a[@title=\"Sign in\"]")).click();
		driver.findElement(By.id("btn-primary")).click();
		acResult=driver.findElement(By.xpath("//div[@class=\"alert error\"]/p/strong")).getText();
		exResult="There were one or more errors in your submission. Please correct the marked fields below.";
		if(acResult.contains(exResult)) {
	    	actual="true";
	  }
		 Assert.assertEquals(actual, expected);			
	}
		
	/**
	 * Error message while password is blank
	 */	
	@Test(priority=2)
	public void errIdBlank()
	{
		test = extent.createTest("errIdBlank");
		driver.findElement(By.id("session_key-login")).sendKeys("anantaa.mitra@gmail.com");
		driver.findElement(By.id("btn-primary")).click();
		acResult=driver.findElement(By.xpath("//div[@class=\"alert error\"]/p/strong")).getText();
		exResult="There were one or more errors in your submission. Please correct the marked fields below.";
		if(acResult.contains(exResult)) {
	    	actual="true";
	  }
		 Assert.assertEquals(actual, expected);				
	}
	
	/**
	 * Error message while id is blank
	 */	
	/*fail test case*/
	@Test(priority=3)
	public void errPassBlank()
	{
		test = extent.createTest("errPassBlank");
		driver.findElement(By.xpath("//input[@id='session_password-login']")).sendKeys("54874dsa");
		driver.findElement(By.id("btn-primary")).click();
		acResult=driver.findElement(By.xpath("//div[@class=\"alert error\"]/p/strong")).getText();
		exResult="There were one or more errors in your submission.";
		if(acResult.contains(exResult)) {
	    	actual="true";
	  }
		 Assert.assertEquals(actual, expected);				
	}
	
	@AfterClass()
	public void tearDown()
	{
		driver.close();
	}
	
	

}
