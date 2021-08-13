package day_30_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNationalities {
	
	
	WebDriver driver;
	
	public AddNationalities(WebDriver driver1) {
		
		this.driver=driver1;
		PageFactory.initElements(driver1,this);
	}
	
	@FindBy(linkText="Admin")
	WebElement admin1;
	
	@FindBy(id="menu_admin_nationality")
	WebElement menuAdmin;
	
	@FindBy(id="btnAdd")
	WebElement addButton;
	
	@FindBy(id="nationality_name")
	WebElement nationality1;
	
	@FindBy(id="btnSave")
	WebElement saveButton;
	
	public void addNationalities() throws Exception{
		
		admin1.click();
		menuAdmin.click();
		addButton.click();
		nationality1.sendKeys("Indian1403");
		saveButton.click();
	}

}
