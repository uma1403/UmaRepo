package day_07_TestNG_DataProvider_Excel_Browser_Compatability;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;
import commonUtil.TestBrowser;

public class AddJobs_From_Excel_Input {
	
	static WebDriver driver;
	
	@DataProvider(name="AddJobs")
	public static Object[][] test() throws Exception{
		
		ExcelApiTest4 t1=new ExcelApiTest4();
		Object[][] objArray=t1.getTableArray("C://All_Selenium_Softwares//AddJObs.xlsx", "Sheet1");
		return objArray;
	}
	
	
   @Test(dataProvider="AddJobs")
   public void test1(String browser,String testUrl,String userName,String password,String jobTitle,String jobDesc,String jobNote) throws Exception {
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  { driver=TestBrowser.openChromeBrowser(); }
	  
	  if(browser.equalsIgnoreCase("firefox"))
	  { driver=TestBrowser.openFirefoxBrowser(); }
	  
	  AddJobs_From_Excel_Input obj=new AddJobs_From_Excel_Input();
	  
	     obj.openOrangeHrm(testUrl);
	     obj.openLogin(userName,password);
	     obj.addJobs(jobTitle,jobDesc,jobNote);
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
 
 
   public void addJobs(String jobTitle1, String jobDesc1, String jobNote1) throws Exception {
	
	   WebDriverWait myWait=new WebDriverWait(driver, 40);
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"))).click();
	             
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_admin_Job']"))).click();
	             
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_admin_viewJobTitleList']"))).click();
	              

	    	// findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b")).click();
       //  findElement(By.xpath("//*[@id='menu_admin_Job']")).click();
      //  findElement(By.xpath("//*[@id='menu_admin_viewJobTitleList']")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle1);
       findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc1);
       findElement(By.id("jobTitle_note")).sendKeys(jobNote1);
       findElement(By.id("btnSave")).click();
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
