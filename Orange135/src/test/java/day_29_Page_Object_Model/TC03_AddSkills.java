package day_29_Page_Object_Model;

import org.testng.annotations.Test;

import commonUtil.TestBrowser;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC03_AddSkills {
 
	WebDriver driver;
	
  @BeforeTest
  public void openBrowser() throws Exception {
	  
	  driver=TestBrowser.openChromeBrowser();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
 
  @Test
  public void tc03_addSkills() throws Exception {
	  
	  LoginPage l1=new LoginPage(driver);
	  l1.login();
	  
	  AddSkills a1=new AddSkills(driver);
	  a1.addSkills();
	  
	  HomePageLogout h1=new HomePageLogout(driver);
	  h1.logOut();
  }
  
  @AfterTest
  public void tearDown() throws Exception {
	  TestBrowser.closeBrowser();
  }

}
