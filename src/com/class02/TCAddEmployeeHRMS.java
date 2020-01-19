package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TCAddEmployeeHRMS extends CommonMethods{
//	Open chrome browser
//	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//	Login into the application
//	Click on Add Employee
//	Verify labels: Full Name, Employee Id, Photograph are displayed
//	Provide Employee First and Last Name
//	Verify Employee has been added successfully
//	Close the browser

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	@Test
	public void AddEmployee() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		boolean fName = driver.findElement(By.xpath("//label[text()='Full Name']")).isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(fName, "First Name is displayed");
		Thread.sleep(2000);
		boolean empID=driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
		softAssert.assertTrue(empID, "Employee ID is displayed");
		Thread.sleep(2000);
		boolean photo = driver.findElement(By.xpath("//label[text()='Photograph']")).isDisplayed();
		softAssert.assertTrue(photo, "Photograph displayed correctly");
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Tu");
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("Abuela");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		boolean newEmp = driver.findElement(By.id("profile-pic")).isDisplayed();
		//newEmp=false; this would fail it, just like the example in the slides
		softAssert.assertTrue(newEmp);
		softAssert.assertAll();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
