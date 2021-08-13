package day_09_Extent_Emailable_Report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class Extent_Emailable_Report {
	
	static WebDriver driver;
	       String fileName="OrangeHrm_LoginPage_Screeshot";
	
     @Test
     public void test() throws Exception {
    	
    	driver=TestBrowser.openChromeBrowser(); 
    	
    	driver.get("https://opensource-demo.orangehrmlive.com/");
    	takeScreenshot(fileName);    	
	      
    	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    	takeScreenshot(fileName);
    	
   	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
   	    takeScreenshot(fileName);
   	    
   	    driver.findElement(By.id("btnLogin")).click();
    	
    	
    	  	
     }
     
     public static void takeScreenshot(String fileName1) throws IOException {
    	 
    	//1.Take Screenshot and store it as a file format
     	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     	
     	//2.Now copy the ScreenShot to desired location using copyFile method:
     	FileUtils.copyFile(source,new File("C:\\All_Selenium_Softwares\\work space\\Orange135\\src\\test\\java\\"+fileName1+".png"));
    	  
     }
     
}


