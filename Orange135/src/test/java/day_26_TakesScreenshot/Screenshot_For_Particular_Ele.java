package day_26_TakesScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class Screenshot_For_Particular_Ele {
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
	  //t1.takeScreenshotAuto(driver, testName);
	  t1.takesScreenShot_Decrease_Screenshot_Size(driver, testName);
	   
	  WebElement userName1= findElement(By.xpath(userName));
	             userName1.sendKeys("Admin");
	  t1.takeScreenshot_For_Particular_Element(driver, testName, userName1);
	  
	  WebElement password1= findElement(By.xpath(password));
	             password1.sendKeys("admin123");
      t1.takeScreenshot_For_Particular_Element(driver, testName, password1);
	  
	 
	  
       WebElement button= findElement(By.xpath(loginButton));
       t1.takeScreenshot_For_Particular_Element(driver, testName, button);
	  
       button.click();
       t1.takesScreenShot_Decrease_Screenshot_Size(driver, testName);
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
