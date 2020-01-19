package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
//	Create class that will have:
//		Before and After Class annotation
//		Before and After Method annotation
//		2 methods with Test annotation

	@BeforeClass
	public void first() {
		System.out.println("this is my Before Class");
	}
	@AfterClass
	public void next() {
		System.out.println("This is my After Class");
	}
	@BeforeMethod
	public void prepaid() {
		System.out.println("This is my Before Method");
	}
	@AfterMethod
	public void postpaid() {
		System.out.println("This is my After Method");
	}
	@Test
	public void test() {
		System.out.println("This is the first actual test");
	}
	@Test
	public void testTwo() {
		System.out.println("This is the second actual Test");
	}

}
