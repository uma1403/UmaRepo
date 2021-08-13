package day_10_Customized_Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class LoginPage_Customized_Report {
 

	static WebDriver driver;
	 String testName=this.getClass().getSimpleName();
	 Customized_Reporter R1;  //step2
	
	@Test
	public void TC01_Report_Test() throws Exception {
		
		driver = TestBrowser.openChromeBrowser();
		
		R1= new Customized_Reporter(driver,testName);	//step3
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass"); //step4
		//R1.TakeScreenShotAuto(driver);
		//R1.getScreenShotPath(driver);
	   
		findElement(By.id("txtUsername")).sendKeys("Admin");
		R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
		//R1.TakeScreenShotAuto(driver);
		//R1.getScreenShotPath(driver);

		findElement(By.id("txtPassword")).sendKeys("admin123");	
		R1.TakeScreenShotAuto(driver,"Password Entered","Pass");
		//R1.TakeScreenShotAuto(driver);
		//R1.getScreenShotPath(driver);
		
		findElement(By.name("Submit"));
		R1.TakeScreenShotAuto(driver,"Clicked on Signin","Fail");
		//R1.TakeScreenShotAuto(driver);
		//R1.getScreenShotPath(driver);
		findElement(By.name("Submit")).click();
		
		
		R1.TakeScreenShotAuto(driver,"Navigated to HomePage","Pass");
		//R1.TakeScreenShotAuto(driver);
		//R1.getScreenShotPath(driver);
		
		
		driver.close();
	
	}
	
	
	

	
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
			
		
	
	
	
}
