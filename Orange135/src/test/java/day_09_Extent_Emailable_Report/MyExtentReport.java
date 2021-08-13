package day_09_Extent_Emailable_Report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MyExtentReport {
  
	WebDriver driver;
	 
	public static String TestScreenShotFolderName;
	String TestHtmlName="";
	String screenShotPath;
	public static String TestName="Test9";
	

	

	String HtmlOutputFileName = "";

	public  MyExtentReport() {
		
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
	
		 TestScreenShotFolderName=TestName+"_"+strDate;
		 TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+TestScreenShotFolderName+ ".html";
		
		 System.out.println("TestName is : "+TestName);
		 System.out.println("Path is : "+TestHtmlName);
	}
	
	public static  String capture(WebDriver driver) throws IOException
    {
				
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		
		
      //  TakesScreenshot ts = (TakesScreenshot)driver;
     //   File source = ts.getScreenshotAs(OutputType.FILE);
		 
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dest = "C:\\HTML Report\\test-output\\ExtentReportScreenShots\\"+TestScreenShotFolderName+"\\"+TestScreenShotFolderName+"_"+strDate+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
	
	

	public static  String capture(WebDriver driver,String TestScriptName) throws IOException
    {
		
			
		//String TestHtmlName1=TestName;
	
		
		// String TestHtmlName1="C:/HTML Report/test-output/ExtentReportScreenShots/"+TestName+".html";
		
		 System.out.println("Test Script Name is : "+TestScriptName);
		// System.out.println("Path is : "+TestHtmlName1);
		
				
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		
		
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
       // String dest = "C:\\HTML Report\\test-output\\ExtentReportScreenShots\\"+TestScreenShotFolderName+"\\"+TestScreenShotFolderName+"_"+strDate+".png";
        
        String dest = "C:\\HTML Report\\test-output\\ExtentReportScreenShots\\"+TestScriptName+ "\\"+strDate+".png";
        
        System.out.println("dest path  is : "+dest);
        
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
	
	
	
	
	
}
