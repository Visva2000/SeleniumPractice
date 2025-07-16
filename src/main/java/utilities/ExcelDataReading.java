package utilities; 

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReading {
	
	public static Object[][] excelfileread(String filePath,String sheetName){
		Object[][] data = null;
		
		try(FileInputStream file = new FileInputStream(filePath)){
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			data= new Object[rowCount-1][colCount];
			for(int i=1;i<rowCount;i++) {
				Row row = sheet.getRow(i);
				for(int j=0;j<colCount;j++) {
					data[i-1][j]=row.getCell(j).toString();
					
				}
			}
			workbook.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
