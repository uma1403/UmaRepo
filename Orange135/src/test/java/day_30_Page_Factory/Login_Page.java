package day_30_Page_Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver driver;
	
	public  Login_Page(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1,this);
	}
	
	@FindBy(name="txtUsername")
    WebElement userName;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	
	   public void login() throws Exception{
		   
		   userName.sendKeys("Admin");
		   password.sendKeys("admin123");
		   loginButton.click();
		   
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
