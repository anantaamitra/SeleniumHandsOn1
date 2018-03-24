package com.testngListener;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

@Listeners(com.testngListener.TestNGListener.class)

public class TestNGTestCase {

	
	
	
	@Test
	
	
	public void linkedin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://linedin.com");
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}
	
	
}
