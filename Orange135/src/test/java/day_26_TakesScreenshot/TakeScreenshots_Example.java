package day_26_TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.utils.FileUtil;

public class TakeScreenshots_Example {
	
	WebDriver driver;
	String testName;
	String outputFolder,outputFolder1;
	 
	int stepCount;
	
	//Constructor
	
	public TakeScreenshots_Example(WebDriver driver1,String testName1) {
		
		    stepCount=0;
		
		//Get Current Date		
				Date date=new Date();
				SimpleDateFormat sfd=new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
				String strDate=sfd.format(date);
		
		 outputFolder1 ="C:\\HTML Report\\test-output\\TempScreenShots";
		 outputFolder = outputFolder1	+ "\\" + testName1 +"_"+  strDate;
		    
		this.driver=driver1;
		this.testName=testName1;
	}
	

	
	
	
	public void takeScreenshotAuto(WebDriver driver1,String textMsg,String passorfail) throws Exception {
		
		
		String passIcon="C:\\HTML Report\\Icons\\check_1.ico";
		String failIcon="C:\\HTML Report\\Icons\\close_1.png";
		
		Date date = new Date();
		SimpleDateFormat sfd=new SimpleDateFormat("dd_MMM_yyyy h_mm_ss_SSS a");
		String strDate=sfd.format(date);
		
		TakesScreenshot ts=(TakesScreenshot)driver1;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(outputFolder+"\\"+testName+"_"+strDate+".png");
		
		try {
			
		     FileUtils.copyFile(src, dest);
		
		}catch(Exception e) {}
		
		String screenshotPath=dest.getAbsolutePath();
		screenshotPath=screenshotPath.replace("\\","/");
		
		 String ScreenShot2= "<a href=" + screenshotPath + " target=\"popup\" "
		    		+ "onclick=\"window.open('"
		    		+ screenshotPath
		    		+ "','popup','width=600,height=600'); return false;\"> " + "ScreenShot" + "</a> ";
		 
		 
		 String PASS="<img src='file:///"
			 		+ passIcon
			 		+ "'    +     \"width=\"30\" + height=\"30\"></img>";
		 
		 String FAIL="<img src='file:///"
			 		+ failIcon
			 		+ "'    +     \"width=\"30\" + height=\"30\"></img>";
		 
		 
		 
		 String Textmsg1="<b><font color='black'>   "
		 		+ textMsg +
				 "</b> </font>";
		 
		 stepCount = stepCount+1;
		 
		 if(stepCount==1 && passorfail.equals("pass")) {
			 
			 String Textmsg2="<table> "
						
				+ "<tr > " 
				
				+ " <img   style=\"border:1px solid black;\"      src=\"C:\\HTML Report\\HtmlTemplates\\Logo.JPEG\">" 
				
				+"</tr>"
				+ "<tr   ><center><font color=\"red\"  size=\"15\" >" + testName +"</font></center></tr>" 
				+  "<tr bgcolor=\"#9370DB\"> <th width=\"100px\"> <center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Steps" + "</font></center>" + "<font color=\"white\"  size=\"4\" >" 
		 		+ "</font></center> </th> <th width=\"450px\" ><center>" + "<font color=\"white\"  size=\"4\" >" 
		 		+ "Details "
		 		+ "</font> </center></th> <th width=\"100px\" ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Status"
		 		+ "</font></center></th>  <th  width=\"250px\"  ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Screen Shots"
		 		+ "</font></center></th> <th width=\"250px\"  ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Date & Time"
		 		+ "</font></center></th> 	 </tr>       ";
			 
			 Reporter.log(Textmsg2);
		 }
		 
		 else {
			 if(passorfail.equals("pass"))
			 {
				 
				 String Textmsg3=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
					 		+ "Step" + "&nbsp;"+ stepCount 
					 		+ "</center> </th> <th width=\"450px\" ><center>"
					 		+ Textmsg1
					 		+ "</center></th> <th width=\"100px\" ><center>"
					 		+ PASS
					 		+ "</center></th>  <th  width=\"250px\"  ><center>"
					 		+ ScreenShot2
					 		+ "</center></th> <th width=\"250px\"  ><center>"
					 		+ strDate
					 		+ "</center></th> 	 </tr>      ";
				 Reporter.log(Textmsg3);
			 }
			 else {
				 String Textmsg4=" <tr bgcolor=\"#ddd\"> <th width=\"100px\"> <center>"
							+ "Step" + "&nbsp;"+ stepCount 
							+ "</center> </th> <th width=\"450px\" ><center>"
							+ Textmsg1
							+ "</center></th> <th width=\"100px\" ><center>"
							+ FAIL
							+ "</center></th>  <th  width=\"250px\"  ><center>"
							+ ScreenShot2
							+ "</center></th> <th width=\"250px\"  ><center>"
							+ strDate
							+ "</center></th> 	 </tr>      ";
				 Reporter.log(Textmsg4);
			 }
		 }
		 
	}

}
