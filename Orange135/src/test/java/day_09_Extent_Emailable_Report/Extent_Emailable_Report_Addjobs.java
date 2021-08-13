package day_09_Extent_Emailable_Report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonUtil.OR;
import commonUtil.TestBrowser;

public class Extent_Emailable_Report_Addjobs {
 
	
WebDriver driver;
	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	 public static String TestScriptName = "Login Page Testing";
	 public static String TestName;
	 
	 
	
	@Test
	public void Report3_Test() throws Exception {
		
		driver = TestBrowser.openChromeBrowser();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		 
		 
		 
	
		
		//screenShotPath = ExtentReport.capture(driver,TestScriptName);
		//logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		
		 
		
		 
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	   
		findElement(By.id("txtUsername")).sendKeys("Admin");
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		

		findElement(By.id("txtPassword")).sendKeys("admin123");	
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered Password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		
		findElement(By.id("btnLogin")).click();
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.fail("Login Page - Clicked on Login",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on Admin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
        findElement(By.id("menu_admin_Job")).click();
        screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on Job",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on JobTitle",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
        findElement(By.id("btnAdd")).click();
        screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - Clicked on AddButton",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
        
		
		 findElement(By.id("jobTitle_jobTitle")).sendKeys("Java 1403");
		 screenShotPath=MyExtentReport.capture(driver,TestScriptName);
		 logger.pass("Home Page- JibTitle entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		 
         findElement(By.id("jobTitle_jobDescription")).sendKeys("Java desc");
         screenShotPath = MyExtentReport.capture(driver,TestScriptName);
 		logger.pass("Home Page - Job Desc Entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
         
         findElement(By.id("jobTitle_note")).sendKeys("Java note");
         screenShotPath = MyExtentReport.capture(driver,TestScriptName);
 		logger.pass("Home Page - Job note entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
         
         findElement(By.id("btnSave")).click();
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
