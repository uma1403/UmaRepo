package day_04_Dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddMyInfoEdit {
	static WebDriver driver;
  @Test
  public void myInfoEdit() throws Exception {
	  openChromebrowser();
      }
  public static void openChromebrowser() throws Exception{
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe"); //step1
	  driver=new ChromeDriver();   //step2
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
}
