package testclasses;

import org.testng.annotations.Test;

import base.BaseClass;

public class AuthenticationPopus extends BaseClass {
	
	@Test
	public void setip() {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	
}
