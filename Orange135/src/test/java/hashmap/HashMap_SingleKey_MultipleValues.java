package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ExcelUtil.ExcelApiTest4;

public class HashMap_SingleKey_MultipleValues {

	public static void main(String[] args) throws Exception {
		
		Map<String, HashMap <String, String>> dataTable = new HashMap<String, HashMap<String,String>>();
         
        ExcelApiTest4 eat = new ExcelApiTest4();
		
        dataTable=eat.getDataTable("C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx", "Sheet1");
        
        //Set<String> key=dataTable.keySet();
       // System.out.println(key);
        
        Iterator<String>  itr=dataTable.keySet().iterator();
             while(itr.hasNext()) {
            	 String key=itr.next();
            	 HashMap<String,String> values=dataTable.get(key);
            	 System.out.println("Key  (" +key+ ")  value  ("+values+")");
            	
             }
        
        
      //String testname=dataTable.get("TC01").get("TestName");     
        //System.out.println(testname);
        
        
	}

}

