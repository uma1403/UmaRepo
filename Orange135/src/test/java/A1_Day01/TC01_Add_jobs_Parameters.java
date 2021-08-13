package A1_Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Add_jobs_Parameters {
	
	WebDriver driver;
	
	//Step 2  - Global Variables
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String JobTitle="Sales1",JobDescr="Sales1 descr",JobNote="Sales1Note";
	
	// A same test can be executed multiple times for different sets of Input data is known as 
	// Data Driven Test or Data Provider
	
	
	    //step1
		 @DataProvider(name = "Orange1")
		  public static Object[][] Test1() throws Exception {
		 
		        return new Object[][] { 
		        	
		        { "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sale1","Sales1Desc","Sales1Note" },
		        { "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sale2","Sales2Desc","Sales2Note" },
		        { "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sale3","Sales3Desc","Sales3Note" }
		        
		      };
		  }
		 
		 
		 
		 @DataProvider(name = "Orange2")
		  public static Object[][] Test2() throws Exception {
			 
			 Object[][] data = new Object[2][6];

				// 1st row
				data[0][0] ="https://opensource-demo.orangehrmlive.com/";
				data[0][1] = "Admin";
				data[0][2] = "admin123";
				data[0][3] = "Sale7";
				data[0][4] = "Sale7 desc";
				data[0][5] = "Sale7 Note";

				// 2nd row
				data[1][0] ="https://opensource-demo.orangehrmlive.com/";
				data[1][1] = "Admin";
				data[1][2] = "admin123";
				data[1][3] = "Sale8";
				data[1][4] = "Sale8 descr";
				data[1][5] = "Sale8 Note";
	
				
				return data;
		       
		  }
		 
		 
	
  @Test(dataProvider="Orange2")//Step2
  public void AddJobs(String TestURL,String UserName,
		  String Password,String JobTitle,String JobDescr,String JobNote)throws Exception {  //Step3
	  

	  TC01_Add_jobs_Parameters T1= new TC01_Add_jobs_Parameters();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UserName,Password);
	  T1.AddJobs1(JobTitle,JobDescr,JobNote);
		
		
  }
  
  
  public void OpenChromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public void OpenOrangeHRM(String TestURL) throws Exception
  {
		//Open Orange HRM
		//driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.get(TestURL);
  }
  
  
  
  
  public void Login(String UserName,String Password) throws Exception
  {
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
  }
  
  
  
  
  public void AddJobs1(String JobTitle,String JobDesc,String JobNote) throws Exception
  {
		//AddJobs
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDesc);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
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
