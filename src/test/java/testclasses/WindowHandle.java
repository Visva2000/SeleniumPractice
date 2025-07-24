package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.WindoHandlePage;

public class WindowHandle extends BaseClass {
	@Test
	public void windowSwitchTest() {
		WindoHandlePage wp = new WindoHandlePage(driver,wait);
		wp.windowSwitch();
	}
}
