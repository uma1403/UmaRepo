package A1_Day01;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getCurrentClassName {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		 
	      // WebDriver driver=new ChromeDriver();
	       //driver.manage().window().maximize();
          // driver.get("https://www.google.com/");
		 
		 getCurrentClassName obj=new getCurrentClassName();
		  obj.className();
	}
	
	public void className() {
		    System.out.println("class name with package name--------"+this.getClass().getName());
		    System.out.println("only class name---------"+this.getClass().getSimpleName());
			                 }

}


