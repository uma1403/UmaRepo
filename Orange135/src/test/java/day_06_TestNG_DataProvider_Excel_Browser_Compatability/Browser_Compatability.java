package day_06_TestNG_DataProvider_Excel_Browser_Compatability;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;
import commonUtil.TestBrowser;

public class Browser_Compatability {
	
	static WebDriver driver;
	
	@DataProvider(name="Orange")
	public static Object[][] test() throws Exception{
		
		ExcelApiTest4 t1=new ExcelApiTest4();
		
		 Object[][] objArray=t1.getTableArray("C://All_Selenium_Softwares//TC01_Nationality1.xlsx","Sheet1");
		 System.out.println(objArray.length);
		 return objArray;
		}
	
    @Test(dataProvider="Orange")
     public void test1(String browser,String testUrl,String userName,String password,String nationality) throws Exception {
    	
    	Browser_Compatability obj=new Browser_Compatability();
    	
    	if(browser.equalsIgnoreCase("chrome"))
    	{	driver=TestBrowser.openChromeBrowser();  }
    	
    	if(browser.equalsIgnoreCase("firefox"))
    	{ driver=TestBrowser.openFirefoxBrowser();  }
    	
    	obj.openOrangeHrm(testUrl);
    	obj.openLogin(userName,password);
    	obj.addNationalities(nationality);
    	TestBrowser.closeBrowser();
     }
    
	public void openOrangeHrm(String testUrl1) {
		
		driver.get(testUrl1);
	}
	
	public void openLogin(String userName1, String password1) throws Exception {
		
		findElement(By.id("txtUsername")).sendKeys(userName1);
		findElement(By.id("txtPassword")).sendKeys(password1);
		findElement(By.id("btnLogin")).click();
	}
	
	public void addNationalities(String nationality1) throws Exception {
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(nationality1);
		findElement(By.id("btnSave")).click();
	}
	

	  public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}

}
