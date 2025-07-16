package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.TablesPage;
public class TablesPageTestClass extends BaseClass{
	
	@Test
	public void TableTest() {
		
		TablesPage tp = new TablesPage(driver,wait);
		tp.tabledatas();
	}
}
