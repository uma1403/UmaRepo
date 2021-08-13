package day_04_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestPram {
	WebDriver driver;
	
	String Uname="Admin";
	String Pwd="admin123";
	String URL="https://opensource-demo.orangehrmlive.com/";
	
  @Test
  public void loginParamaterized() throws Exception {
	  LoginTestPram obj=new LoginTestPram();
	  obj.openBrowser(URL);
	  obj.openLogin(Uname,Pwd);
	  
  }
  
     public void openBrowser(String url) throws Exception{
     System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe"); //step1
	  driver=new ChromeDriver();   //step2
	  driver.manage().window().maximize();
	  driver.get(url);
	   }
     public void openLogin(String userName,String password) throws Exception{
    	 driver.findElement(By.id("txtUsername")).sendKeys(userName);
   	  driver.findElement(By.id("txtPassword")).sendKeys(password);
   	  driver.findElement(By.id("btnLogin")).click();
     }
  
}
