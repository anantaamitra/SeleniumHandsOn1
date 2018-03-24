package com.anantaa.extends_reports3_23_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import com.webdriverListener.EventHandler;

public class ProgramMain {
	
	
	

	@Test
	
	public void webdEvetListener() {
		
		
		WebDriver driver = new FirefoxDriver();
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		eventDriver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		WebElement element = eventDriver.findElement(By.id("target"));
		element.click();
		
		
		
	}
	
	
}
