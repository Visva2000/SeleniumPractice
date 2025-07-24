package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReading {

	public static Object[][] excelfileread(String filePath, String sheetName) {
		Object[][] data = null;

		try (FileInputStream file = new FileInputStream(filePath)) {
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row != null && row.getCell(0) != null &&
				    row.getCell(0).toString().equals("Visvanathan")) {

					data = new Object[1][colCount];  // only one matching row
					for (int j = 0; j < colCount; j++) {
						Cell cell = row.getCell(j);
						data[0][j] = (cell == null) ? "" : cell.toString();
					}
					break; // only one match
				}
			}

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}


}
