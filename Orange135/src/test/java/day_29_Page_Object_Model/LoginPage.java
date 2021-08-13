package day_29_Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	 WebDriver driver;   
	
	 public  LoginPage(WebDriver driver1) {
		  this.driver=driver1;
		}
	 
	String userName="//input[@id='txtUsername']";   //Advanced xpath for UserName
	String password="//input[@id='txtPassword']";   //Advanced xpath for Password
	String loginButton="//input[@id='btnLogin']";   //Advanced xpath for Login Button
	
	
	     //login method
	  public void login() throws Exception{
		
		findElement(By.xpath(userName)).sendKeys("Admin"); 
		
		
		findElement(By.xpath(password)).sendKeys("admin123");
		findElement(By.xpath(loginButton)).click();
		
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
	
}
