package day_02_Locate_By_Name;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC02_Static_Parameterized {
	
	static WebDriver driver;   
	
	String userName="Admin",password="admin123";
	String testUrl="https://opensource-demo.orangehrmlive.com/";
	String jobTitle="Java1405",jobDesc="Java desc",jobNote="Java Note";
	
        @Test
        public void test() throws Exception{
        	
        	TC02_Static_Parameterized.openChromeBrowser();
	        TC02_Static_Parameterized.openOrangeHRM(testUrl);
	        TC02_Static_Parameterized.openLogin(userName, password);
	        TC02_Static_Parameterized.addJobTitle(jobTitle,jobDesc,jobNote);
         }
        
        public static void openChromeBrowser() throws Exception{
        	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
   	        driver=new ChromeDriver();
   	        driver.manage().window().maximize();
        }
        
        public static void openOrangeHRM(String url) throws Exception{
        	driver.get(url);
        }
        
        public static void openLogin(String uName,String pwd) throws Exception{
        	findElement(By.name("txtUsername")).sendKeys("Admin");
     	   findElement(By.name("txtPassword")).sendKeys("admin123");
     	   findElement(By.name("Submit")).click();
        	 
        }
        public static void addJobTitle(String jobTitleName,String JobDescName,String jobNoteName) throws Exception{
        	findElement(By.id("menu_admin_viewAdminModule")).click();
            findElement(By.id("menu_admin_Job")).click();;
            findElement(By.id("menu_admin_viewJobTitleList")).click();
            findElement(By.name("btnAdd")).click();
            findElement(By.name("jobTitle[jobTitle]")).sendKeys(jobTitleName);
            findElement(By.name("jobTitle[jobDescription]")).sendKeys(JobDescName);
            findElement(By.name("jobTitle[note]")).sendKeys(jobNoteName);
            findElement(By.name("btnSave")).click();
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
