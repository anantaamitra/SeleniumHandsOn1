package com.testngListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
	}

	@Override
	public void onStart(ITestContext result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("The details of Test Failed are"+result.getName()); // getName() - gets name of the Test Case
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println("The details of Test Skipped are"+result.getName()); 
	}

	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("The details of TestStart are"+result.getName()); 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("The details of TestSuccess are"+result.getName()); 
	}
	}


