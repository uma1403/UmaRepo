package day_08_Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class TestExample3 {
	
	static WebDriver driver;
	
	@BeforeTest
	public void test1() throws Exception {
		driver=TestBrowser.openChromeBrowser();
		Reporter.log("passs---Before Test");
	}
		
     @Test
    public void test2() throws Exception {
    	 
    	  driver.get("https://opensource-demo.orangehrmlive.com/");
		  Reporter.log("Url open TestCase Passed");
		  
		  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		  Reporter.log("UserName TestCase Passed");  // Reporter is predefined class on TestNg to generate emailable report
		  
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		  Reporter.log("Password TestCase Passed");
		   
		  driver.findElement(By.id("btnLogin")).click();
		  Reporter.log("Login button TestCase Passed");
    	 
    }
     
     @AfterTest
     public void test3() throws Exception
     {
    	 TestBrowser.closeBrowser();
     }
}
