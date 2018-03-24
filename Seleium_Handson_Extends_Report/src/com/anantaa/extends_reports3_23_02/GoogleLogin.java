package com.anantaa.extends_reports3_23_02;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleLogin extends Base {
	
	public GoogleLogin() {
		super();
	}

	@BeforeTest
	/*public void setUrl(){
		String appUrl=(String) pro.get("google");
		url(appUrl);
	}*/
	
	@Test
	public void errMsgBothBlank()
	{
		driver.findElement(By.id(""));
		driver.findElement(By.id(""));
		driver.findElement(By.id("")).click();
	}
	

}
