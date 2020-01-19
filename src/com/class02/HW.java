package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods{
	
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod
	public void close() {		
		driver.quit();
	}
	@Test
	public void validationOfLogo() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isTrue = driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
		if(isTrue) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("Logo is not displayed");
		}
	}
	@Test
	public void validationOfMessage() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
		WebElement error = driver.findElement(By.id("spanMessage"));
		String expectedError = "Password cannot be empty";
		if (error.isDisplayed()) {
			System.out.println("error is displayed");
			if(error.getText().equals(expectedError)) {
				System.out.println("Error message is correct. Test PASS");
			}else {
				System.out.println("Error message is NOT correct. Test FAILED");
			}
		}else {
			System.out.println("Error is NOT displayed. Test case FAILED");
		}
	}
}
