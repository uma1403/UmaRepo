package day_05_TestNG_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class TC05_DataProvider_Lab4 {
	
	static WebDriver driver;
	
	@DataProvider(name="Orange")
	public static Object[][] test()throws Exception
	{
		Object[][] objArray=new Object[2][5];
		   objArray[0][0]="https://opensource-demo.orangehrmlive.com/\"";
		   objArray[0][1]="Admin";
		   objArray[0][2]="admin123";
		   objArray[0][3]="Selenium1221";
		   objArray[0][4]="Selenium Desc";
		
		   objArray[1][0]="https://opensource-demo.orangehrmlive.com/\"";
		   objArray[1][1]="Admin";
		   objArray[1][2]="admin123";
		   objArray[1][3]="Selenium2112";
		   objArray[1][4]="Selenium Desc";
		   
		return objArray;
	}
	
     @Test(dataProvider="Orange")
     public void test1(String TestUrl,String userName,String password,String skillName,String skillDesc) throws Exception {
    	 
    	 TC05_DataProvider_Lab4 obj=new TC05_DataProvider_Lab4();
    	 
    	 driver=TestBrowser.openChromeBrowser();
    	 obj.openOrangeHrm(TestUrl);
    	 obj.openLogin(userName, password);
    	 obj.addSkills(skillName, skillDesc);
    	 
     }
     
     public void openOrangeHrm(String url) throws Exception{
    	 driver.get(url);
     }
     
     public void openLogin(String uName,String pwd) throws Exception{
    	 findElement(By.id("txtUsername")).sendKeys(uName);
    	 findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(pwd);
    	 findElement(By.xpath("//*[@id='btnLogin']")).click();
    	 
     }
     
     public void  addSkills(String name,String desc) throws Exception{
    	
    	 findElement(By.linkText("Admin")).click();
    	 findElement(By.partialLinkText("Qualifi")).click();
    	 findElement(By.linkText("Skills")).click();
    	 findElement(By.id("btnAdd")).click();
    	 findElement(By.cssSelector("input#skill_name.block.default.editable.valid")).sendKeys(name);
    	 findElement(By.cssSelector("textarea#skill_description.editable")).sendKeys(desc);
    	 findElement(By.name("btnSave")).click();
     }
     
  // Draws a red border around the found element. Does not set it back anyhow.
		public  WebElement findElement(By by) throws Exception {
			
		    WebElement elem = driver.findElement(by);
		    	    
		    // draw a border around the found element
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		        
		  //  TH3.HTMLScreenShot("Screen Shot","Click Here","Pass", HtmlOutputFileName,driver);
		        
		    }
		    return elem;
		}												
}
