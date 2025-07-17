package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.TablesPage;
import utilities.ConfigReader;
import utilities.Log;
public class TablesPageTestClass extends BaseClass{
	
	@Test
	public void TableTest() {
		
		TablesPage tp = new TablesPage(driver,wait);
//		Log.info(ConfigReader.getConfigData("structure"));
		tp.alternateTableDatas(ConfigReader.getConfigData("tableValue"));
		
//		tp.alternateTableDatas("Clock Tower Hotel");
	}
}
