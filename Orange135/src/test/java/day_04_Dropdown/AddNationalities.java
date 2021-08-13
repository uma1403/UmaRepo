package day_04_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddNationalities {
	WebDriver driver;
  @Test
  public void testNatinalities() throws Exception {
	  
 	  AddNationalities obj=new AddNationalities();
 	  obj.openBrowser();
 	  obj.login();
 	  obj.addNationalities();
 	  obj.addQualifications();  
  }
  
     //Non-Parameterized and calling methods from main test
   
     public void openBrowser() throws Exception{
	     System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	 	 driver=new ChromeDriver();
	 	// driver.get("http:www.google.com");
	 	 driver.manage().window().maximize();
	 	 driver.get("https://opensource-demo.orangehrmlive.com/"); //launch browser  
      }
     public void login() throws Exception{
         //inspect elements
     	 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
     	 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
     	 driver.findElement(By.id("btnLogin")).click();
     }
     
     public void addNationalities() throws Exception{
    	//add nationality
     	 driver.findElement(By.id("menu_admin_viewAdminModule")).click();
     	 driver.findElement(By.id("menu_admin_nationality")).click();
     	 driver.findElement(By.id("btnAdd")).click();
     	 driver.findElement(By.id("nationality_name")).sendKeys("indian1405");
     	 driver.findElement(By.id("btnSave")).click();
     }
     
     public void addQualifications() throws Exception{
    	 //add qualifications
     	 driver.findElement(By.id("menu_admin_viewAdminModule")).click();
     	 driver.findElement(By.id("menu_admin_Qualifications")).click();
     	 driver.findElement(By.id("menu_admin_viewSkills")).click();
     	 driver.findElement(By.id("btnAdd")).click();
     	 driver.findElement(By.id("skill_name")).sendKeys("Java1405");
     	 driver.findElement(By.id("skill_description")).sendKeys("Java Desc");
     	 driver.findElement(By.id("btnSave")).click();
     }
     
}
