package com.class03;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

//TC 1: HRMS Add Employee: 1.Open chrome browser
//2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//3.Login into the application
//4.Add 5 different Employees and create login credentials by providing: ●First Name●Last Name●Username●Password
//5.Provide Employee First and Last Name
//6.Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
//7.Close the browser.Specify group for this test case, add it into specific suite and execute from xml file.Test Case

public class HW extends CommonMethods{
	@BeforeMethod(groups= {"1stXMLTest"})
	public void urlAddEmp() throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	}
	@AfterMethod(groups= {"1stXMLTest"})
	public void teardown() {
		driver.quit();
	}
	@DataProvider
	public Object[][] empData(){
		
		Object[][] newEmp= {
				{"Hugo","Basay"},
				{"Ivan","Zamorano"},
				{"Cristian","Galvez"},
				{"Eduardo","Vargas"},
				{"Arturo","Vidal"}
		};
		return newEmp;
	}
	@Test(dataProvider = "empData", groups= {"1stXMLTest"})
	public void empAdd(String nombre, String apellido) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		driver.findElement(By.id("firstName")).sendKeys(nombre);
		driver.findElement(By.id("lastName")).sendKeys(apellido);
		driver.findElement(By.id("btnSave")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File quickPic = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(quickPic, new File("C:\\Users\\huaso\\eclipse-workspace\\TestNGBasic\\ScreenShotTestNG/HRMSTest/"+nombre+apellido+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
//		Thread.sleep(2000);
//		soft.assertAll();
		}
		
	}
}
	


