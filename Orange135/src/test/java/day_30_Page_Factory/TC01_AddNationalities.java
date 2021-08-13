package day_30_Page_Factory;

import org.testng.annotations.Test;

import commonUtil.TestBrowser;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC01_AddNationalities {
  
	WebDriver driver;
	
  @BeforeTest
  public void openBrowser() throws Exception {
	  
	  driver=TestBrowser.openChromeBrowser();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  @Test
  public void tc01_addNationalities()  throws Exception{
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  Login_Page l1=new Login_Page(driver);
	  l1.login();
	  
	  AddNationalities t1=new AddNationalities(driver);
	  t1.addNationalities();
	  
	  HomePageLogout h1=new HomePageLogout(driver);
	  h1.logout();
  }

  @AfterTest
  public void tearDown() throws Exception {
	  Thread.sleep(2000);
	  
	  TestBrowser.closeBrowser();
  }

}
