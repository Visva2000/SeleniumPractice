package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriverWait wait;
	WebDriver driver;
	
	public HomePage(WebDriver driver,WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement MyAccountDropDown;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement RegisterBtn;
	
	public void MyAccount() {
//		driver.get("https://tutorialsninja.com/demo/");
		wait.until(ExpectedConditions.elementToBeClickable(MyAccountDropDown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(RegisterBtn)).click();
		
	}

}
