package day_29_Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNationalities {
	
	
	WebDriver driver;
	
	public AddNationalities(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	public void addNationalities() throws Exception{
		
		findElement(By.linkText("Admin")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("Indain1403");
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
