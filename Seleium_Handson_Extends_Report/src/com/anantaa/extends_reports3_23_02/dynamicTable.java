package com.anantaa.extends_reports3_23_02;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicTable {
	public static void main (String[] args) throws ParseException  { 
		String max;
		float j=0;
		double m=0,r=0;
		WebDriver wd; 
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("http://money.rediff.com/gainers/bsc/daily/groupa?");
		//No. of Columns
		List <WebElement> col = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Total No of columns are : " +col.size());
		//No.of rows
		List <WebElement> rows = wd.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("Total No of rows are : " + rows.size());
		for (int i =1;i<rows.size();i++)
		{    
			max= wd.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
			NumberFormat f =NumberFormat.getNumberInstance(); 
			Number num = f.parse(max);
			max = num.toString(); //Float.parseFloat(max).toFixed(2);   //have to understand the code
			m = Double.parseDouble(max);
					
			if(m>r)
			 {    
				r=m;
			 }
		}
		System.out.println("Maximum current price is : "+ r);
		
		WebElement baseTable = wd.findElement(By.tagName("table"));
		
		//To fimd third row of table
		WebElement tableRow = wd.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
		//to get 1rd row's 3nd column data
		WebElement tableRowText = wd.findElement(By.xpath ("//table[@class='dataTable']/tbody/tr[1]/td[3]"));
		//table[@class="dataTable"]
		String rowtext = tableRow .getText();//tableRowText.getText();//ata vul ache
		String rowColumntext=tableRowText.getText();
		System.out.println("Third row of table : "+rowtext);
		System.out.println("First row 2nd column of table : "+rowColumntext);		
		
	}
}
