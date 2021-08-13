package day_07_TestNG_DataProvider_Excel_Browser_Compatability;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;
import commonUtil.TestBrowser;

public class AddLocations_From_Excel_Input {
	
	static WebDriver driver;
	
	@DataProvider(name="AddLocation")
	public static Object[][] test() throws Exception{
		
		ExcelApiTest4 t1=new ExcelApiTest4();
		Object[][] objArray=t1.getTableArray("C://All_Selenium_Softwares//AddJObs.xlsx", "Sheet2");
		return objArray;
	}
	
   @Test(dataProvider="AddLocation")
   public void test1(String browser,String testUrl,String userName,String password,String location,String city,String country ) throws Exception {
	  
	  AddLocations_From_Excel_Input obj=new AddLocations_From_Excel_Input();
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  { driver=TestBrowser.openChromeBrowser();  }
	  
	  if(browser.equalsIgnoreCase("firefox"))
	  { driver=TestBrowser.openFirefoxBrowser();  }
	  
	  obj.openOrangeHrm(testUrl);
	  obj.openLogin(userName,password);
	  obj.addLocation(location, city, country);
    }
   
     public void openOrangeHrm(String testUrl1) {
		 driver.get(testUrl1);
	  }


	   public void openLogin(String userName1, String password1) throws Exception {
		   
		     findElement(By.id("txtUsername")).sendKeys(userName1);
	    	 findElement(By.id("txtPassword")).sendKeys(password1);
	    	 findElement(By.id("btnLogin")).click();
	   }
	   
	   public void addLocation(String location1,String city1,String country1) throws Exception{
		   
		   findElement(By.linkText("Admin")).click();
		   findElement(By.linkText("Organization")).click();
		   findElement(By.linkText("Locations")).click();
		   findElement(By.id("searchLocation_name")).sendKeys(location1);
		   findElement(By.id("searchLocation_city")).sendKeys(city1);
		   
		   Select dropdown=new Select(findElement(By.id("searchLocation_country")));
		   
		      dropdown.selectByVisibleText(country1);
		      
		  findElement(By.id("btnAdd")).click();
		   
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
