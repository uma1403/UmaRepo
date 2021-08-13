package day_05_TestNG_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC05_DataProvider_Lab1 {
	
	    static WebDriver driver;
	    
	  // String userName="Admin",password="admin123";
	 //  String testUrl="https://opensource-demo.orangehrmlive.com/";
	 //  String jobTitle="Selenium1405",jobDesc="Selenium desc",jobNote="Selenium is Testing tool";
	
	  //if u want to execute u r test with multiple input test data , we can user Data Provider
	    
	    @DataProvider(name="Orange")
	    public static Object[][] test1() throws Exception {
	   	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java789","Java desc","Java note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java787","Java desc","Java note" },
	         	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java786","Java desc","Java note" }
	        	};
	  }
	 
       @Test(dataProvider = "Orange") //step2 u r test will be connected to dataProvider 
       public void test(String testUrl,String userName,String password,String jobTitleName,String JobDescName,String jobNoteName) throws Exception {
    	  
	      System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();
	       driver.manage().window().maximize();
        
	          driver.get(testUrl);
   
	       findElement(By.id("txtUsername")).sendKeys(userName);
 	      findElement(By.id("txtPassword")).sendKeys(password);
 	      findElement(By.id("btnLogin")).click();
    
           findElement(By.id("menu_admin_viewAdminModule")).click();
          findElement(By.id("menu_admin_Job")).click();;
         findElement(By.id("menu_admin_viewJobTitleList")).click();
         findElement(By.id("btnAdd")).click();
         findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitleName);
         findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescName);
         findElement(By.id("jobTitle_note")).sendKeys(jobNoteName);
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
