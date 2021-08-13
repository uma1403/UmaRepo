package day_06_TestNG_DataProvider_Excel_Browser_Compatability;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;
import commonUtil.TestBrowser;

public class TC06_DataProvider_Excel {
  
	
	static WebDriver driver;
	
	
	@DataProvider(name = "Orange")
	public static Object[][] test() throws Exception {
		
		ExcelApiTest4 T1 = new ExcelApiTest4();
		Object[][] testObjArray = T1.getTableArray("C://All_Selenium_Softwares//TC01_Nationality1.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
  @Test(dataProvider="Orange")//Step2
  public void test(String TestURL1,String UserName1,String Password1,String Nationality1) throws Exception{
	  
	     TC06_DataProvider_Excel T1=new TC06_DataProvider_Excel();
	     
         driver=TestBrowser.openChromeBrowser();
	     T1.openOrangeHRM(TestURL1);     //step3
	     T1.openLogin(UserName1,Password1);   //step3
	     T1.addNationalities(Nationality1);  //step3
	     TestBrowser.closeBrowser();
	 
  }

	public void openOrangeHRM(String testURL1) throws Exception {
	  // TODO Auto-generated method stub
		driver.get(testURL1);
      }
	
	public void openLogin(String userName1, String password1) throws Exception {
		// TODO Auto-generated method stub
		findElement(By.id("txtUsername")).sendKeys(userName1);
		findElement(By.id("txtPassword")).sendKeys(password1);
		findElement(By.id("btnLogin")).click();
	}
	
	 public void addNationalities(String nationality1) throws Exception {
			// TODO Auto-generated method stub
		    findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_nationality")).click();
			findElement(By.id("btnAdd")).click();
			findElement(By.id("nationality_name")).sendKeys(nationality1);
			findElement(By.id("btnSave")).click();

		}

//  
//    public void openOrangeHRM(String TestURL) throws Exception{
//	  
//		driver.get(TestURL);
//    }
//  
// public void openLogin(String uName,String Pwd) throws Exception{
//	 
//		findElement(By.id("txtUsername")).sendKeys(uName);
//		findElement(By.id("txtPassword")).sendKeys(Pwd);
//		findElement(By.id("btnLogin")).click();
//		
// }
// 
// public void addNationalities(String NationalityText) throws Exception{
//	  
//		findElement(By.id("menu_admin_viewAdminModule")).click();
//		findElement(By.id("menu_admin_nationality")).click();
//		findElement(By.id("btnAdd")).click();
//		findElement(By.id("nationality_name")).sendKeys(NationalityText);
//		findElement(By.id("btnSave")).click();
//	 
// }
 
// public void CloseBrowser() throws Exception{
//	  
//	 driver.quit();
// }
  
  
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
