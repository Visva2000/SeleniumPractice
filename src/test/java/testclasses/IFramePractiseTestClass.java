package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.IFramePractisePage;

public class IFramePractiseTestClass extends BaseClass{
	
	@Test
	public void framesPractice() throws InterruptedException {
		
		IFramePractisePage ifp = new IFramePractisePage(driver, wait);
		ifp.FramesSwitch();
	}
	
}
