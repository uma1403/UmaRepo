package day_26_TakesScreenshot;

import org.testng.annotations.Test;

import commonUtil.TestBrowser;
import day_10_Customized_Emailable_Report.Customized_Reporter;
import day_10_Customized_Emailable_Report.Reporter1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginPage {
  
	WebDriver driver;
	TakeScreenshotsOfTest t1;
	
	String testName=this.getClass().getSimpleName();
	
	String userName="//input[@id='txtUsername']";   //Advanced xpath for UserName
	String password="//input[@id='txtPassword']";   //Advanced xpath for Password
	String loginButton="//input[@id='btnLogin']";   //Advanced xpath for Login Button
	
  @BeforeTest
  public void openBrowser() throws Exception {
	  
	  driver=TestBrowser.openChromeBrowser();
	  
  }

  
  @Test
  public void loginTest() throws Exception {
	  
	   t1=new TakeScreenshotsOfTest(driver,testName);
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  t1.takeScreenshotAuto(driver, "Open Orange HRM", "pass");
	   
	  findElement(By.xpath(userName)).sendKeys("Admin");
	  t1.takeScreenshotAuto(driver, "User Name Entered", "pass");
	  
	  findElement(By.xpath(password)).sendKeys("admin123");
	  t1.takeScreenshotAuto(driver, "Password Entered", "pass");
	 
	  findElement(By.xpath(loginButton));
	  t1.takeScreenshotAuto(driver, "Clicked on Login Button", "pass");
	  
	  findElement(By.xpath(loginButton)).click();
	  t1.takeScreenshotAuto(driver, "Navigated to HomePage", "pass");
  }
  
  //boarder highlighting code
 public   WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
  
  @AfterTest
  public void closeBrowser() throws Exception {
	  TestBrowser.closeBrowser();
  }

}
