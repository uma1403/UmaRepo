package day_02_Locate_By_Name;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC02_Static_Non_Parameterized {
	static WebDriver driver;
	
       @Test
       public void test() throws Exception {
    	   TC02_Static_Non_Parameterized.openBrowser();
    	   TC02_Static_Non_Parameterized.openOrangeHRM();
    	   TC02_Static_Non_Parameterized.openLogin();
    	   TC02_Static_Non_Parameterized.addJobTitle();
       }
  
       public static void openBrowser() throws Exception{
	       System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	       driver=new ChromeDriver();
	       driver.manage().window().maximize();
        }
  
     public static void openOrangeHRM() throws Exception{
	      driver.get("https://opensource-demo.orangehrmlive.com/");
      }
  
       public static void openLogin() throws Exception{
    	   findElement(By.name("txtUsername")).sendKeys("Admin");
    	   findElement(By.name("txtPassword")).sendKeys("admin123");
    	   findElement(By.name("Submit")).click();
      }

       public static void addJobTitle() throws Exception{
    	   findElement(By.id("menu_admin_viewAdminModule")).click();
           findElement(By.id("menu_admin_Job")).click();;
           findElement(By.id("menu_admin_viewJobTitleList")).click();
           findElement(By.name("btnAdd")).click();
           findElement(By.name("jobTitle[jobTitle]")).sendKeys("Java1406");
           findElement(By.name("jobTitle[jobDescription]")).sendKeys("Java desc");
           findElement(By.name("jobTitle[note]")).sendKeys("Java Note");
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
