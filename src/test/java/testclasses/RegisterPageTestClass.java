package testclasses;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import jdk.internal.org.jline.utils.Log;
import pages.DataProviderPage;
import pages.RegisterPage;

public class RegisterPageTestClass extends BaseClass{
	
	@Test(dataProvider="ExcelDatas",dataProviderClass=DataProviderPage.class,priority = 0)
	public void RegisterPageTest(String FirstName,String LastName,String email,String phone,String password, String ConfirmPassword) throws InterruptedException {
		
		RegisterPage rp = new RegisterPage(driver,wait);
		rp.PersonalDetails(FirstName,LastName,email,phone);
		rp.Password(password,ConfirmPassword);
		rp.PrivacyPolicy();
//		driver.close();;
	}
	@Test(priority = 1, retryAnalyzer = utilities.Retryanalyzer.class)
	public void TestFail() {
//		Assert asserts = new Assert();
		Assert.assertTrue(false,"Failed");
	}
	
	@Test(dependsOnMethods = "TestFail",priority = 2)
	public void TestSkip() {
		Log.info("Test Skipped");
	}
}
