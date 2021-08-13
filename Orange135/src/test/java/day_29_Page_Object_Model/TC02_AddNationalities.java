package day_29_Page_Object_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class TC02_AddNationalities {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws Exception {
		
		driver=TestBrowser.openChromeBrowser();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	
    @Test
    public void tc02_addNationalities() throws Exception {
	  
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
      LoginPage l1=new LoginPage(driver);
	  l1.login();
	  
	  AddNationalities a1=new AddNationalities(driver);
	  a1.addNationalities();
	  
	  HomePageLogout h1=new HomePageLogout(driver);
	  h1.logOut();
	  
   }
    
    @AfterTest
    public void tearDown() throws Exception
    {
    	TestBrowser.closeBrowser();
    }
}
