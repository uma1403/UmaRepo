
package  hashmap;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonUtil.*;
import ExcelUtil.ExcelApi;
import ExcelUtil.ExcelApiTest4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import commonUtil.TestBrowser;



public class TC01_Add_Nationalities
{
	WebDriver driver;
	
	
	Map<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();

	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	 public static String TestScriptName;
	 public static String TestName;
	 
	
	
	
	@BeforeTest 
	public void  TestSetup()throws Exception {
		
//		driver = TestBrowser.openChromeBrowser();
//		String TestURL = "https://opensource-demo.orangehrmlive.com/";
//		driver.get(TestURL);
		
		ExcelApi eat = new ExcelApi();
		data=eat.getData_From_Excel("C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx", "Sheet1");
		
		TestScriptName=(data.get("TC01").get("TestName"));
		
				
		//Extent HTML Report Creation Starts
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 TestName=TestScriptName+"_"+strDate+".html";
		 TestScriptName=TestScriptName+"_"+strDate;
		 String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
		  
	
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
		 System.out.println("Html Report path is : "+TestHtmlName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
		//Extent HTML Report Creation Ends
	}
	
	
	@Test
	public void Test1_Nationality() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		
		/*System.out.println(Datatable.get("TC01").get("UserName"));
		System.out.println(Datatable.get("TC01").get("Password"));
		System.out.println(Datatable.get("TC01").get("Nationality"));*/
		
//		String UserName= data.get("TC01").get("UserName");
//		String Password= data.get("TC01").get("Password");
//		String Nationality= data.get("TC01").get("Nationality");
		
		Map.Entry<String,HashMap<String,String>> entry=(Entry<String, HashMap<String, String>>) data.entrySet();
		
		String UserName1=entry.getKey();
		System.out.println(UserName1);
		

//		findElement(By.id("txtUsername")).sendKeys(UserName);
//		findElement(By.id("txtPassword")).sendKeys(Password);
//		findElement(By.id("btnLogin")).click();
//		
//		findElement(By.id("menu_admin_viewAdminModule")).click();
//		findElement(By.id("menu_admin_nationality")).click();
//		findElement(By.id("btnAdd")).click();
//		findElement(By.id("nationality_name")).sendKeys(Nationality);
//		findElement(By.id("btnSave")).click();
		
	}
	
	public  WebElement findElement(By by) throws Exception 
	{
					
			 WebElement elem = driver.findElement(by);  
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
	}
	
	
	@AfterTest 
	public void  TestCloser()throws Exception {	
		driver.quit();
		extent.flush();
	}
	
	
	
	
	
	
}












