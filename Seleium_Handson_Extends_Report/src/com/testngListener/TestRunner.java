package com.testngListener;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;
//To run Fail Cases only
public class TestRunner {

	@Test	
	public void failedTC() {		
		TestNG runner= new TestNG();
		List<String> list=new ArrayList<>();
		list.add(System.getProperty("User.dir"+"/test-output/testng-failed.xml"));
		runner.setTestSuites(list);
		runner.run();
	}	
}
