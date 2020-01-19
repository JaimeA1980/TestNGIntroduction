package com.class03;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlwaysRun {
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("I am before suite");
	}
	
	@AfterSuite(alwaysRun = true)
	public void AfterSuite() {
		System.out.println("I am before suite");
	
		
	}
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("I am before class");
	}
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
	System.out.println("I am after class");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("I am after method");
	}
	
	@Test
	public void testMethod() {
		System.out.println("I am test");
	}
	@Test
	public void testMethod1() {
		System.out.println("I am test1");
	}
}
