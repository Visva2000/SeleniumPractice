package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import utilities.BrokenLinkCheck;
import utilities.ConfigReader;

public class BrokenLinkTest extends BaseClass{

	@Test
	public void LinkCheckTest() {
		BrokenLinkCheck blc = new BrokenLinkCheck(driver,wait);
		blc.linkCheck(ConfigReader.getConfigData("brokenURL"));
	}
}
