package commonMethodPackage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_Common_Functions {
	
	public static void evidenceFileCreater(String filename, String requestBody, String responseBody) throws IOException {
		
		File newfile = new File("C:\\Users\\bhava\\Desktop\\Classes\\" +filename+ ".txt");     //File is a class
		System.out.println("A new text file created to record request and response of the API :" +newfile.getName());  //always return name
		
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("request Body :" +requestBody+"\n\n");  //   "\n" means enter to write responseBody
		datawrite.write("response Body :" +responseBody); 
		datawrite.close();
		
		System.out.println("Request Body and response Body are saved in : " +newfile.getName());
		
	}
	
	public static ArrayList<String> readDataExcel(String sheetname, String testcasename) throws IOException{
		
		ArrayList<String> arrayData = new ArrayList<String>(); 
		
		//Step 1: Create the object of file input stream
		FileInputStream fis = new FileInputStream("C:\\Users\\bhava\\Desktop\\Classes\\Data.xlsx");
		
		//Step 2: Access the excel file
		XSSFWorkbook workBook = new XSSFWorkbook(fis);     
		
		//Step 3: Access the sheet name
		int countOfSheet = workBook.getNumberOfSheets();    //to access the file
		
		for (int i = 0; i<countOfSheet; i++) {
			String fileSheetName = workBook.getSheetName(i);
			if (fileSheetName.equalsIgnoreCase(sheetname)) {
				
				//Step 4: Access the row from where the data is supposed to be fetch
				XSSFSheet sheet = workBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				//Row r = rows.next();
				while(rows.hasNext()) { 
					//rows read till rows are available, condition true rows exit and scope of rows and keep o returning true
				
				Row r1 = rows.next();
				if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
				 {
						Iterator<Cell> cellValues = r1.cellIterator(); 
						while(cellValues.hasNext()) {
							String testData = cellValues.next().getStringCellValue();
							arrayData.add(testData);
						}
					}
					
				
				}
			}
		}
		
		workBook.close();
		return arrayData;
		
		
	}
	

}
