package ExcelUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelApiTest {


	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    public FileOutputStream fout=null;
	

	public static void main(String[] args) throws IOException {
		
		ExcelApiTest obj=new ExcelApiTest();
		
		obj.getData_From_Excel();
	}
	
	public void getData_From_Excel() throws IOException {
		
		fis=new FileInputStream("C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx");
		
		   //Extract Workbook from File
		 workbook= new XSSFWorkbook(fis);
		
		   //Extract sheet from workbook
		sheet=workbook.getSheet("Sheet1");
		
		//To read data from excel sheet first we have to know no.of Rows in sheet
		int num_Of_Rows=sheet.getLastRowNum()+1;
		System.out.println("Number Of Rows "+num_Of_Rows);
		
		//Get number of Columns in Sheet
	    row=sheet.getRow(0);
		int num_Of_Column=row.getLastCellNum();
		System.out.println("Number Of Columns   "+num_Of_Column);
		
		//Create HashMap to store data from Excel
		Map<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();
		
		XSSFRow row1;
		XSSFCell cell1;
		
		//Reading data from excel and put it in HashMap
		for(int i=1;i<num_Of_Rows;i++)
		{
			HashMap<String,String> hm=new HashMap<String,String>();
			
			for(int j=1;j<num_Of_Column;j++) {
				
				//To Get Value
				row=sheet.getRow(i); //Get Rows Data
				cell=row.getCell(j); //Get Each Cell Data
				
				//To Get Key
				 row1=sheet.getRow(0);   // Get Data Header
				 cell1=row1.getCell(j); 
				
				hm.put(cell1.getStringCellValue(), cell.getStringCellValue()); // Key   : Row[0]Column[1] : Header(Ex:TestCase)
				                                                               // Value : Row[1]Column[1] : CellData(Ex:TC01) loop continue
				
				//hm.forEach((k,v)->System.out.println("Key---> "+k+" value----> "+v));
				//System.out.println(hm);
			}
			
			row1=sheet.getRow(i);
			cell1=row1.getCell(0);
			
			data.put(cell1.getStringCellValue(), hm);
			
			System.out.println(data);
			
		}

	}
	
}
