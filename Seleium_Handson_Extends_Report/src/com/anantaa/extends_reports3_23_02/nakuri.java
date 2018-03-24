package com.anantaa.extends_reports3_23_02;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class nakuri {
	WebDriver driver;
	@Test
	public void setUrl() throws IOException {
		
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();  
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath(".//*[@id='login_Layer']")).click();
		driver.findElement(By.xpath(".//*[@id='lgnFrm']/div[8]/button")).click();
		driver.quit();
	}

}
