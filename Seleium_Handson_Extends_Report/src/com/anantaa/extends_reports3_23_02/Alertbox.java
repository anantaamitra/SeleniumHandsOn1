package com.anantaa.extends_reports3_23_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alertbox {
	@Test
	public void alertBox() {
		
		WebDriver driver;
		
		try {
			
			//String path = System.getProperty("user.dir");
			
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe");
			driver=new ChromeDriver();
//			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://demo.guru99.com/test/delete_customer.php");
			
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(3000);			
			
			String text = driver.switchTo().alert().getText(); //text validation
			System.out.println(text);
			
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
//			driver.switchTo().alert().dismiss(); //cancelling the alert
			Thread.sleep(2000);
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	
	}
}
