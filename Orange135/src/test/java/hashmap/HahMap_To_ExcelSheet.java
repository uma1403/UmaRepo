package hashmap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HahMap_To_ExcelSheet {

	public static void main(String[] args) throws IOException {
   
		XSSFWorkbook workbook=new XSSFWorkbook(); //STEP : 1
		
		XSSFSheet sheet=workbook.createSheet("Student Info"); //STEP : 2
		
		Map<String,String> data=new HashMap<String,String>(); //STEP : 3
		
		data.put("101", "Tom");
		data.put("102", "Peter");
		data.put("103", "Robert");
		data.put("104", "John");
		data.put("105", "Lisa");
		
		int rownum=0;
		
		//Enhanced for loop: fetch data from HashMap    STEP : 4
		
		for(Map.Entry<String,String> entry:data.entrySet()) { //entry variable contains both key and value
			
			//create New Row      //STEP : 5
			XSSFRow row=sheet.createRow(rownum++);
			
			//create New Cell              STEP : 6
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
			
		}
		
		// Add Workbook to File System            STEP : 7
		
		FileOutputStream fos=new FileOutputStream("C:\\HTML Report\\OrangeHRM6\\Student.xlsx");
        
		workbook.write(fos);
		fos.close();
		System.out.println("Excel Written Successfully");
	}

}
