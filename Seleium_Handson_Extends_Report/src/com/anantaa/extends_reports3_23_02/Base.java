package com.anantaa.extends_reports3_23_02;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	
	public static WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void url(String url) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		/*
			driver = new EventFiringWebDriver(driver);		 
			handler = new EventHandler();
			driver.register(handler);
		*/
		driver.manage().window().maximize();  
		driver.get(url);
		driver.manage().deleteAllCookies();
	}
	
	/*@BeforeSuite
	public void setlogger() {
		Logger log= new Logger();
		
	}*/
	
	
	
	@BeforeSuite
	public void ExtendReportsetUp()
    {
        htmlReporter = new ExtentHtmlReporter("./test-output/demoReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);     
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Host Name", "Anantaa");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Anantaa");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("Extend Report Practise");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
	 @AfterMethod
	public void result(ITestResult  result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
            takeScreenSort(result);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			//test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case PASSED", ExtentColor.BLUE));
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));

		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test case SKIPED due to below issues:", ExtentColor.INDIGO));
            test.fail(result.getThrowable());
            takeScreenSort(result);
		}
	}
	
	
	public void takeScreenSort(ITestResult  result) throws IOException{
		if((result.getStatus()==ITestResult.FAILURE) || (result.getStatus()==ITestResult.SKIP )){
			TakesScreenshot screenSort=(TakesScreenshot)driver;
			File source=screenSort.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./test-output/ScreenSort/"+result.getName()+".png"));	
		}
		
	}
	
	@AfterSuite
	public void extentFlush()
	{
		extent.flush();	
	}
	
	
	

}
