package commonUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.bytebuddy.asm.Advice.Return;

public class TestBrowser {
	
	public static String chromedriverPath ="C:\\chromedriver_win32\\chromedriver.exe";
	public static String firefoxdriverPath="C:\\geckodriver-v0.29.1-win64\\geckodriver.exe";
	
	static WebDriver driver1;
                 // @Test
            public static WebDriver openChromeBrowser() throws Exception{
            	
            	// WebDriver driver1 ; 
	 			 	
 			 	 //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
 			 	System.setProperty("webdriver.chrome.driver",chromedriverPath);
 			 	driver1 =new ChromeDriver();
 			 	driver1.manage().window().maximize() ;	
 			 	
			    return driver1;
            }
            
            public static WebDriver openFirefoxBrowser() throws Exception{
            	//WebDriver driver1 ;
            	System.setProperty("webdriver.gecko.driver",firefoxdriverPath);
            	driver1=new FirefoxDriver();
            	driver1.manage().window().maximize();
            	
            	return driver1;
            }
            
           
			public static void  closeBrowser() throws Exception{
           	    driver1.quit();
           	   
            }
}
