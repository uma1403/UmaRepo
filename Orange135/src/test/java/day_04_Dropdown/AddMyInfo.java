package day_04_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddMyInfo {
	
	 WebDriver driver;
	 String userName="Admin";
	 String password="admin123";
	 String URL="https://opensource-demo.orangehrmlive.com/";
  @Test
  public void addInfoTest() throws Exception {
	  
	  AddMyInfo obj=new AddMyInfo();
	  obj.openChromeBrowser();
	  obj.openOrangeHrm(URL);
	  obj.openLogin(userName, password);
	  obj.openAddMyInfo();
	  }
  
    public void openChromeBrowser() throws Exception{
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
  	  driver=new ChromeDriver();
  	  driver.manage().window().maximize();
    }
    
    public void openOrangeHrm(String url) throws Exception{
    	//enter url
  	  driver.get(url);
    }
    
    public void openLogin(String uName,String pwd) throws Exception{
    	//enter credentials
  	  driver.findElement(By.id("txtUsername")).sendKeys(uName);
  	  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
  	  driver.findElement(By.id("btnLogin")).click();
    }
    
    public void openAddMyInfo() throws Exception{
    	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
    	driver.findElement(By.linkText("Contact Details")).click();
    	driver.findElement(By.id("btnSave")).click();
    	driver.findElement(By.id("contact_street1")).clear();
    	driver.findElement(By.id("contact_street1")).sendKeys("ABC");
    	driver.findElement(By.id("contact_street2")).clear();
    	driver.findElement(By.id("contact_street2")).sendKeys("PQR");
    	driver.findElement(By.id("contact_city")).clear();
    	driver.findElement(By.id("contact_city")).sendKeys("MNO");
    	driver.findElement(By.id("contact_province")).clear();
    	driver.findElement(By.id("contact_province")).sendKeys("HELLO");
    	driver.findElement(By.id("contact_emp_zipcode")).clear();
    	driver.findElement(By.id("contact_emp_zipcode")).sendKeys("456789");
    	
    	Select dropdown=new Select(driver.findElement(By.id("contact_country")));
    	//dropdown.deselectAll();
    	dropdown.selectByValue("IN");
    	
    	driver.findElement(By.id("contact_emp_hm_telephone")).clear();
    	driver.findElement(By.id("contact_emp_hm_telephone")).sendKeys("123456");
    	driver.findElement(By.id("contact_emp_mobile")).clear();
    	driver.findElement(By.id("contact_emp_mobile")).sendKeys("9876543212");
    	driver.findElement(By.id("contact_emp_work_telephone")).clear();
    	driver.findElement(By.id("contact_emp_work_telephone")).sendKeys("789456");
    	driver.findElement(By.id("contact_emp_work_email")).clear();
    	driver.findElement(By.id("contact_emp_work_email")).sendKeys("mno@gmail.com");
    	driver.findElement(By.id("contact_emp_oth_email")).clear();
    	driver.findElement(By.id("contact_emp_oth_email")).sendKeys("pqr@gmail.com");
    	driver.findElement(By.id("btnSave")).click();
    }
}
