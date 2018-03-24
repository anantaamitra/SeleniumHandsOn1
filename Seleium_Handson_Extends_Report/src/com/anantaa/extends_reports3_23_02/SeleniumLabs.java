package com.anantaa.extends_reports3_23_02;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class SeleniumLabs extends Base
{
	public static Properties pro=new Properties();;
	InputStream fis = FaceBookLogin.class.getResourceAsStream("/config.properties");
	public String exResult;
	public String acResult;
	//WebDriver driver;
	public String actual;
	public String expected;
	
	
	@BeforeClass
	public void setUrl() throws IOException {
		pro.load(fis);
		String appUrl=pro.getProperty("seleniumLab");		
		url(appUrl);
	}
	

	@BeforeMethod
	public void setValue() {
		actual="false";
		expected="true";
	}
	
	@Test
	public void dropdown()
	{
		List <WebElement> we = driver.findElements(By.xpath("//li[@id='menu-item-6081']/ul/li"));
		we.get(0).click();

	}

}
