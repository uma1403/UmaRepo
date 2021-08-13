package day_09_Extent_Emailable_Report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonUtil.TestBrowser;

public class ExtentReports_JavaScriptExecutor {
  
	
WebDriver driver;
	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	 public static String TestScriptName = "Login Page script executor Testing";
	 public static String TestName;
	 
	 
	
	@Test
	public void Report3_Test() throws Exception {
		
		driver = TestBrowser.openChromeBrowser();
		
		// step3 start here - ExtendsHtmlReport starts
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = formatter.format(now);
		 
		 TestName=TestScriptName+"_"+strDate+".html";
		 TestScriptName=TestScriptName+"_"+strDate;
		  String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
		  
		 //String TestHtmlName=TestName;
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
		 
		 System.out.println("Html Report path is : "+TestHtmlName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
		//step3 ends here ExtendsHtmlReport ends
		 
		 
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	   
		
		WebElement userName=findElement(By.id("txtUsername"));
		js.executeScript("arguments[0].setAttribute('value','Admin')",userName);
		   //code to take screenshot using extent reports
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		

		WebElement password=findElement(By.id("txtPassword"));	
		js.executeScript("arguments[0].setAttribute('value','admin123')",password);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered Password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		
		WebElement loginButton =findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].click();", loginButton);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.fail("Login Page - Clicked on Login",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		WebElement adminModule =findElement(By.id("menu_admin_viewAdminModule"));
		js.executeScript("arguments[0].click();", adminModule);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on Admin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		WebElement adminMenu =findElement(By.id("menu_admin_Job"));
		js.executeScript("arguments[0].click();", adminMenu);
        screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on Job",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		WebElement viewJob =findElement(By.id("menu_admin_viewJobTitleList"));
		js.executeScript("arguments[0].click();", viewJob);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on JobTitle",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		WebElement addButton =findElement(By.id("btnAdd"));
		js.executeScript("arguments[0].click();", addButton);
        screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on AddButton",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
        
		
		WebElement jobTitle =findElement(By.id("jobTitle_jobTitle"));
		js.executeScript("arguments[0].setAttribute('value','Java1234')",jobTitle);
		 screenShotPath=MyExtentReport.capture(driver,TestScriptName);
		 logger.pass("Home Page- JibTitle entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		 
		 WebElement jobDesc =findElement(By.id("jobTitle_jobDescription"));
		 js.executeScript("arguments[0].setAttribute('value','Java Desc')",jobDesc);
         screenShotPath = MyExtentReport.capture(driver,TestScriptName);
 		logger.pass("Home Page - Job Desc Entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
         
 		WebElement jobNote =findElement(By.id("jobTitle_note"));
 		js.executeScript("arguments[0].setAttribute('value','Java note')",jobNote);
         screenShotPath = MyExtentReport.capture(driver,TestScriptName);
 		logger.pass("Home Page - Job note entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
         
 		WebElement saveButton =findElement(By.id("btnSave"));
 		js.executeScript("arguments[0].click();", saveButton);
         screenShotPath = MyExtentReport.capture(driver,TestScriptName);
 		logger.pass("Home Page - Clicked on Save",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	
	}
	
	
	


	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
			
		
	
	
	
}
