package day_19_Frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commonUtil.TestBrowser;

public class Frames_By_Index {
 
	static WebDriver driver;
	
	@Test
	public void test() throws Exception{
		
		driver=TestBrowser.openChromeBrowser();
		
		driver.get("https://www.guru99.com/handling-iframes-selenium.html");
		
		//List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		
		//System.out.println("number of frames in webpage is-----"+frames.size());
		
		//driver.switchTo().frame(frames.get(0));
		driver.switchTo().frame("108d84024c787e4");
		
		System.out.println("*********** we are switch to the iframe ******************");   
		
		findElement(By.xpath("//*[@id='108d84024c787e4']")).click();
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
