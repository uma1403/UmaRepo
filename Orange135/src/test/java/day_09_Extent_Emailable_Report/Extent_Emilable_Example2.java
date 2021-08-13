package day_09_Extent_Emailable_Report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonUtil.OR;
import commonUtil.TestBrowser;



public class Extent_Emilable_Example2 {
  
WebDriver driver;
	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	// public static String TestScriptName = "Login Page Testing";
	 public  String TestScriptName=this.getClass().getSimpleName(); //this is not work when we intialize variable with static keyword
	 public static String TestName;
	 
	 
	
	@Test
	public void Report3_Test() throws Exception {
		
		driver = TestBrowser.openChromeBrowser();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
	   
		WebElement userName=findElement(By.id("txtUsername"));
		js.executeScript("arguments[0].setAttribute('value','Admin')", userName);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		

		WebElement password=findElement(By.id("txtPassword"));	
		js.executeScript("arguments[0].setAttribute('value','admin123')",password);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered Password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		
		WebElement login=findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].click();",login);
		screenShotPath = MyExtentReport.capture(driver,TestScriptName);
		logger.fail("Login Page - Clicked on Login",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		//driver.findElement(By.id("menu_admin_viewAdminModule")).click();
				WebElement adminModule=findElement(By.id("menu_admin_viewAdminModule"));
				js.executeScript("arguments[0].click();",adminModule);
				screenShotPath = MyExtentReport.capture(driver,TestScriptName);
				logger.pass("Admin Page - Clicked on Admin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			//	js.executeScript("arguments[0].style.border='3px solid green'", adminModule);
				
				
				//findElement(By.id("menu_admin_nationality")).click();
				WebElement nationality=findElement(By.id("menu_admin_nationality"));
				js.executeScript("arguments[0].click();",nationality);
				screenShotPath = MyExtentReport.capture(driver,TestScriptName);
				logger.pass("Nationality Page - Clicked on Nationality",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				//js.executeScript("arguments[0].style.border='3px solid green'", nationality);
				
				
				//findElement(By.id("btnAdd")).click();
				WebElement addButton=findElement(By.id("btnAdd"));
				js.executeScript("arguments[0].click();", addButton);
				screenShotPath = MyExtentReport.capture(driver,TestScriptName);
				logger.pass("Add Button - Clicked on Add",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				//js.executeScript("arguments[0].style.border='3px solid green'", addButton);
				
				
				//findElement(By.id("nationality_name")).sendKeys("India01");
				WebElement nationalityName=findElement(By.id("nationality_name"));
				//js.executeScript("arguments[0].setAttribute('value','India1403')", nationalityName);
				js.executeScript("arguments[0].setAttribute('value','India 1403')",nationalityName);
				 screenShotPath = MyExtentReport.capture(driver,TestScriptName);
				logger.pass("Nationality Name - Entered on Nationality Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				//js.executeScript("arguments[0].style.border='3px solid green'", NationalityName);  
				
				
				//findElement(By.id("btnSave")).click();
				WebElement SaveButton=findElement(By.id("btnSave"));
				js.executeScript("arguments[0].click();", SaveButton);
				screenShotPath = MyExtentReport.capture(driver,TestScriptName);
				logger.pass("Save Button - Clicked on Save Button",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				//js.executeScript("arguments[0].style.border='3px solid green'", SaveButton);

		
		//Step4
		extent.flush();
		
		
		driver.close();
	
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
