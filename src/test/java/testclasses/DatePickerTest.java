package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.DatePickerPage;

public class DatePickerTest extends BaseClass {

	@Test
	public void DatePicker() {
		DatePickerPage dp = new DatePickerPage(driver,wait);
//		dp.firstDateField("10","16","2000");
		dp.firstDateField();
	}
}
