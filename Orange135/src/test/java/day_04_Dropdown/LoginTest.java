package day_04_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver; //declaration of interface reference
	 
	          //Non-parameterized
     @Test
       public void loginTest() throws Exception {
	  
    	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
    	  driver=new ChromeDriver();
    	// driver.get("http:www.google.com");
    	  driver.manage().window().maximize();
    	  driver.get("https://opensource-demo.orangehrmlive.com/"); //launch browser
    	         //inspect elements
    	 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    	 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    	 driver.findElement(By.id("btnLogin")).click();
    	        
  }
  
  
}
