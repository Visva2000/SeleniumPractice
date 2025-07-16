package pages;

import org.testng.annotations.DataProvider;


public class DataProviderPage {

	@DataProvider(name="registerPageData")
	public Object[][] datas(){
		return new Object[][] {
			{"Visvanathan","S","tony.stark@gmail.com","123456789","admin123","admin123"}};
	}
	
	@DataProvider(name="ExcelDatas")
	public Object[][] excelData(){
		String filepath = "./testdata/RegisterData.xlsx";
		String sheetname="dataSheet";
		
		return utilities.ExcelDataReading.excelfileread(filepath,sheetname);
	}

}
