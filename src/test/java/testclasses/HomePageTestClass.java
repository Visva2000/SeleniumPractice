package testclasses;

//import java.time.Duration;

//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;

public class HomePageTestClass extends BaseClass{

	@Test
	public void MyAccountTest() {
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	HomePage hp = new HomePage(driver,wait);
	hp.MyAccount();
	}
}
