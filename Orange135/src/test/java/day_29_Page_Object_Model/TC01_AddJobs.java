package day_29_Page_Object_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class TC01_AddJobs {
	
	WebDriver driver=null; ;
	
	
   @BeforeTest
   public void openBrowser() throws Exception{
	  
	  driver=TestBrowser.openChromeBrowser();
	  
	 // String TestURL = "https://opensource-demo.orangehrmlive.com/";
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
   }
	
    @Test
    public void tc01_addJobsTest() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  LoginPage l1=new LoginPage(driver);
	  l1.login();
	  
	  AddJobs a1=new AddJobs(driver);
	  a1.addJobs();
	  
	  HomePageLogout h1=new HomePageLogout(driver);
	  h1.logOut();
    }
  
     
       //Closing Browser
    @AfterTest
    public void tearDown() throws Exception{
	  
	  TestBrowser.closeBrowser();
    }
  
}
