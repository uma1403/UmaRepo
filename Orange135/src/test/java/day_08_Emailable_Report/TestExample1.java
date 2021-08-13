package day_08_Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestExample1 {
	
	static WebDriver driver;
	  
  @Test
  public void test() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  
	        driver=new ChromeDriver();
	   
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Reporter.log("Url open TestCase Passed");
	  
	  findElement(By.id("txtUsername")).sendKeys("Admin");
	  Reporter.log("UserName TestCase Passed");  // Reporter is predefined class on TestNg to generate emailable report
	  
	   findElement(By.id("txtPassword")).sendKeys("admin123");
	   Reporter.log("Password TestCase Passed");
	   
	   findElement(By.id("btnLogin")).click();
	   Reporter.log("Login button TestCase Passed");
  }
  
  public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
}
