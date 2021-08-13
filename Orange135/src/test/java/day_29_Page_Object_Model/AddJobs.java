package day_29_Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddJobs {

	WebDriver driver;
	
	
	  public  AddJobs(WebDriver driver1) {
		  this.driver=driver1;
		}


	public void addJobs() throws Exception{
		
		findElement(By.linkText("Admin")).click();
		findElement(By.linkText("Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Developer");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Developing java applications  ");
		findElement(By.id("jobTitle_note")).sendKeys("Job Note");
		findElement(By.id("btnSave")).click();
	  }
	
	
	 public   WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
	
}
