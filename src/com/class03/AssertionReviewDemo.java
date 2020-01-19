package com.class03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionReviewDemo {
	@Test
	public void testOne() {
		String actualTitle="HRM";
		String expectedTitle="HRMM";
		
//		if (actualTitle.equals(expectedTitle)) {
//			System.out.println("Test Pass");
//		}else {
//			System.err.println("Test failed");
//		}
		Assert.assertEquals(actualTitle, expectedTitle,"Actual title did not match");//the message only prints when the test fails, in this case it does
		
		
		
		System.out.println("Another Testcase");
	}
}
