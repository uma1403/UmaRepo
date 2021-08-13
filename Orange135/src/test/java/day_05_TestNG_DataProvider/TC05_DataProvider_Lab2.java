package day_05_TestNG_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class TC05_DataProvider_Lab2 {
	 static WebDriver driver;
	    
	  // String userName="Admin",password="admin123";
	 //  String testUrl="https://opensource-demo.orangehrmlive.com/";
	 //  String jobTitle="Selenium1405",jobDesc="Selenium desc",jobNote="Selenium is Testing tool";
	
	  //if u want to execute u r test with multiple input test data , we can use Data Provider
	    
	    @DataProvider(name="Orange")
	    public static Object[][] Test1() throws Exception {
	   	 
	    	Object[][] obArray= new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Testing12","Testing12 desc","Testing12 note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Testing13","Testing13 desc","Testing13 note" },
	         	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Testing14","Testing14 desc","Testing14 note" }
	        	};
	        	return obArray;
	  }
	 
      @Test(dataProvider = "Orange") //step2 u r test will be connected to dataProvider 
      public void test(String testUrl,String userName,String password,String jobTitleName,
    		                   String jobDescName,String jobNoteName) throws Exception
         {
    	  TC05_DataProvider_Lab2 obj=new TC05_DataProvider_Lab2();
    	  
    	     driver=TestBrowser.openChromeBrowser();
    	     obj.OpenOrangeHrm(testUrl);
    	     obj.openLogin(userName, password);
    	     obj.addJobTitle(jobTitleName, jobDescName, jobNoteName);
        }
       
      public void OpenOrangeHrm(String url) throws Exception{
	          driver.get(url);
          }
      
      public void openLogin(String uName,String pwd) throws Exception{
	       findElement(By.id("txtUsername")).sendKeys(uName);
	       findElement(By.id("txtPassword")).sendKeys(pwd);
	       findElement(By.id("btnLogin")).click();
         }
	      
       public void addJobTitle(String jobTitle,String jobDesc,String jobNote) throws Exception{
        	  findElement(By.id("menu_admin_viewAdminModule")).click();
               findElement(By.id("menu_admin_Job")).click();;
               findElement(By.id("menu_admin_viewJobTitleList")).click();
               findElement(By.id("btnAdd")).click();
              findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
             findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc);
            findElement(By.id("jobTitle_note")).sendKeys(jobNote);
            findElement(By.id("btnSave")).click();
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
