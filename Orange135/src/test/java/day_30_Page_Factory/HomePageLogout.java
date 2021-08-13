package day_30_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLogout {
	
	WebDriver driver;
	
	public HomePageLogout(WebDriver driver1) {
		
		this.driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy(id="welcome")
	WebElement welcome1;
	
	@FindBy(linkText="Logout")
	WebElement logout1;
	
	public void logout() throws Exception{
		
		welcome1.click();
		logout1.click();
	}
	

}
