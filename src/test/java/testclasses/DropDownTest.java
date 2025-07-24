package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.DropDownPage;

public class DropDownTest extends BaseClass{
	@Test
	public void dropDownSelect() {
		DropDownPage dp = new DropDownPage(driver,wait);
		dp.DropDownSelect();
	}
}
