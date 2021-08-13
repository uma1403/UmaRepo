package day_29_Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLogout {

	 WebDriver driver;
	 
	 
	 public HomePageLogout(WebDriver driver1) {
		 this.driver=driver1;
	 }
	 
	
	public void logOut() throws Exception {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait myWait=new WebDriverWait(driver,60);
		
		findElement(By.id("welcome")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();
		//findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);

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
