package day_03_Locate_By_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class Login_Page {
	
      static  WebDriver driver;
	
	String Uname="Admin";
	String Pwd="admin123";
	String URL="https://opensource-demo.orangehrmlive.com/";
	
      @Test
      public void test() throws Exception {
    	  
    	 // driver=TestBrowser.openChromeBrowser();
    	  
    	  driver=TestBrowser.openFirefoxBrowser();
    	  
    	  Login_Page obj=new Login_Page();
    	  obj.openOrangeHRM(URL);
    	  obj.openLogin(Uname, Pwd);
       }
      
      public void openOrangeHRM(String url) throws Exception {
    	  driver.get(url);
      }
      public void openLogin(String userName,String password) throws Exception{
    	  findElement(By.cssSelector("#txtUsername")).sendKeys(userName);
     	  findElement(By.cssSelector("#txtPassword")).sendKeys(password);
     	  findElement(By.cssSelector("#btnLogin")).click();
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
