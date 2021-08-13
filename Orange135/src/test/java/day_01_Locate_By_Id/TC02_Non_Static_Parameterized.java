package day_01_Locate_By_Id;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC02_Non_Static_Parameterized {
	
	  static WebDriver driver;
	   String userName="Admin",password="admin123";
	   String testUrl="https://opensource-demo.orangehrmlive.com/";
	   String jobTitle="Selenium1405",jobDesc="Selenium desc",jobNote="Selenium is Testing tool";
	   
       @Test
       public void test() throws Exception{
    	   TC02_Non_Static_Parameterized obj=new TC02_Non_Static_Parameterized();
    	   obj.openBrowser();
    	   obj.openOrangeHRM(testUrl);
    	   obj.openLogin(userName, password);
    	   obj.addJobTitle(jobTitle,jobDesc,jobNote);
             }
       
       public void openBrowser() throws Exception{
    	   System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
    	     driver=new ChromeDriver();
    	     driver.manage().window().maximize();
             }
       
       public void openOrangeHRM(String url) throws Exception{
    	      driver.get(url);
       }
       
       public void openLogin(String uname,String pwd) throws Exception{
    	 findElement(By.id("txtUsername")).sendKeys(uname);
      	 findElement(By.id("txtPassword")).sendKeys(pwd);
      	 findElement(By.id("btnLogin")).click();
       }
       
       public  void addJobTitle(String jobTitleName,String JobDescName,String jobNoteName) throws Exception{
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
