package day_10_Customized_Emailable_Report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Customized_Reporter {
	
	
	WebDriver driver;
	String testName;
	String outputFolder,outputFolder1;
	 
	int stepCount;
     
	
	       //Constructor
    public Customized_Reporter(WebDriver driver1,String testName1) {
		 
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
	
		public void TakeScreenShotAuto(WebDriver driver) throws Exception
		{
		
		 //Timestamp  append for .png file
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a"); 
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 //Takes screenshot
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		     
		 //Move image file to new destination
		 
		// String fileWithPath= "/C:/All_Selenium_Softwares/HTML Report/test-output/TempScreenShots/" +"\\"+TestName+"_"+strDate +".png";
		 String filePath= outputFolder +"\\"+testName+"_"+strDate +".png";
		 File DestFile=new File(filePath);

		      //Copy file at destination
		      try {
		              FileUtils.copyFile(SrcFile, DestFile);
		          } catch(Exception e ) {}
		              
		    
		    String ScreenShotPath = DestFile.getAbsolutePath();
			 ScreenShotPath = ScreenShotPath.replace("\\", "/");
			   
			// System.out.println("HTML Screen Shot Path : "+ScreenShotPath);
			
			 String str="<a href='file:///"
			 		+ ScreenShotPath
			 		+ "'>ScreenShot</a>";
		
			Reporter.log(str); 

		}
		
		public String getScreenShotPath(WebDriver driver) throws Exception
		{
			
		 //Timestamp  append for .png file
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a"); 
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 //Takes screenshot
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		     
		 //Move image file to new destination
		 String filePath= outputFolder +"\\"+testName+"_"+strDate +".png";
		 File DestFile=new File(filePath);

		      //Copy file at destination
		      try {
		              FileUtils.copyFile(SrcFile, DestFile);
		          } catch(Exception e ) {}
		              
		    
		     String ScreenShotPath = DestFile.getAbsolutePath();
			 ScreenShotPath = ScreenShotPath.replace("\\", "/");
			 
			// System.out.println("HTML Screen Shot Path : "+ScreenShotPath);
			
			 String str1="<a href='file:///"
			 		+ ScreenShotPath
			 		+ "'>ScreenShot</a>";
			 
			 String str2= "<a href=" + ScreenShotPath + " target=\"popup\" "
			    		+ "onclick=\"window.open('"
			    		+ ScreenShotPath
			    		+ "','popup','width=600,height=600'); return false;\"> " + "ScreenShot" + "</a> ";
		
			Reporter.log(str2); 
			
			//return str2;
			 return filePath;
		}
		
		public void TakeScreenShotAuto(WebDriver driver,String Textmsg,String PassorFail) throws Exception
		{
			
			  String PassIcon  ="C:\\HTML Report\\HtmlTemplates\\passed.PNG";
			  String FailIcon  ="C:\\HTML Report\\HtmlTemplates\\failed.PNG";

		
		 //Timestamp  append for .png file
		 SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MMM_yyyy h_mm_ss_SSS a"); 
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 System.out.println("strDate:"+strDate);
		 
		 //Takes screenshot
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		     
		 //Move image file to new destination
		 String fileWithPath= outputFolder +"\\"+testName+"_"+strDate +".png";
		 File DestFile=new File(fileWithPath);

		      //Copy file at destination
		      try {
		              FileUtils.copyFile(SrcFile, DestFile);
		          } catch(Exception e ) {}
		              
		    
		     String ScreenShotPath = DestFile.getAbsolutePath();
			 ScreenShotPath = ScreenShotPath.replace("\\", "/");
			 
			 //System.out.println("HTML Screen Shot Path : "+ScreenShotPath);
				 
				 String ScreenShot2= "<a href=" + ScreenShotPath + " target=\"popup\" "
				    		+ "onclick=\"window.open('"
				    		+ ScreenShotPath
				    		+ "','popup','width=600,height=600'); return false;\"> " + "ScreenShot" + "</a> ";
				 
				 
				 String PASS="<img src='file:///"
					 		+ PassIcon
					 		+ "'    +     \"width=\"30\" + height=\"30\"></img>";
				 
				 String FAIL="<img src='file:///"
					 		+ FailIcon
					 		+ "'    +     \"width=\"30\" + height=\"30\"></img>";
				 
				 
				 
				 String Textmsg1="<b><font color='black'>   "
				 		+ Textmsg +
						 "</b> </font>";
				 
				 stepCount = stepCount+1;
				 
				 String Textmsg3="<table> "
						
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
				 
			String Textmsg4=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
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
			

			
			String Textmsg5=" <tr bgcolor=\"#ddd\"> <th width=\"100px\"> <center>"
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
			
			
			
			
			
			
			String Textmsg6=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
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



		String Textmsg7=" <tr bgcolor=\"#ddd\"> <th width=\"100px\"> <center>"
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

			
			
			


		String Textmsg8="<table> "

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
				 
			String Textmsg9=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
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
				 
				 
				
				 if(PassorFail.equals("Pass"))
				 {
					 // Reporter.log(Str2); 
					 
					 if (stepCount==1)
					 {
							 Reporter.log(Textmsg3); 
							 Reporter.log(Textmsg4); 
					 }
					 else
					 {
						 
						 if(stepCount%2==0) 
						 {
							 
							 Reporter.log(Textmsg5); 
						 }
						 else
						 {
							 Reporter.log(Textmsg4); 
						 }
						 
						 
					 }
						 
				 }
				 else
				 {
				 //Reporter.log(Str3); 
					 if (stepCount==1)
					 {
							 Reporter.log(Textmsg8); 
							 Reporter.log(Textmsg9); 
					 }
					 else
					 {
						 
						 if(stepCount%2==0) 
						 {
							 
							 Reporter.log(Textmsg7); 
						 }
						 else
						 {
							 Reporter.log(Textmsg6); 
						 }
						 
						 
					 }
					 
					 
				 }
		
		}
	
}
