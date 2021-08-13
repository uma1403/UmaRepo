package day_08_Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class TestExample4 {
	
	static WebDriver driver;
	
	String browser1;
	
	@Parameters({"Browser"})
	@BeforeTest
	public  void test1(String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("chrome"))
		{ 
			driver=TestBrowser.openChromeBrowser();
			browser1=browser +" Browser ";
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{ 
			driver=TestBrowser.openFirefoxBrowser(); 
		    browser1=browser+" Browser "; 
		}
		Reporter.log("Pass: Before TestCase");
	}
		  
	
    @Test
    public void test2() {
    	
    	  driver.get("https://opensource-demo.orangehrmlive.com/");
		  Reporter.log("Url open in "+ browser1 + " TestCase Passed");
		  
		  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		  Reporter.log("UserName TestCase Passed");  // Reporter is predefined class on TestNg to generate emailable report
		  
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		  Reporter.log("Password TestCase Passed");
		   
		  driver.findElement(By.id("btnLogin")).click();
		  Reporter.log("Login button TestCase Passed");
    	
      }
    
    @AfterTest
    public void test3() throws Exception {
    	
    	TestBrowser.closeBrowser();
    }
    
}
