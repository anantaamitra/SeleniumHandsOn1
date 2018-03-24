package com.anantaa.extends_reports3_23_02;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvanceDatePicker {
	public static void main(String[] args) throws ParseException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Chrome_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.redbus.in/");

	    driver.findElement(By.id("onward_cal")).click();
		
	    List<WebElement> dates = driver.findElements(By.xpath("//table[@id='rb-monthTable first last']/tbody/tr"));
	    
		int total_nodes = dates.size();

		for (int i = 0; i < total_nodes; i++) {
			
		String date = dates.get(i).getText();
		
		System.out.println(date);
			if (date.equalsIgnoreCase("31")) {
				dates.get(i).click();
				break;
			}
		}
		driver.quit();
	}
}
