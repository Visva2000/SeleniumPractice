package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonClasses;
import utilities.Log;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class RegisterPage {
	
	WebDriverWait wait;
	WebDriver driver;
//	CommonClasses classes;
	
	public RegisterPage(WebDriver driver, WebDriverWait wait){
		this.driver= driver;
		 this.wait= wait;
		PageFactory.initElements(driver,this);
//		classes = new CommonClasses(driver, wait);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@placeholder='E-Mail']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Telephone']")
	WebElement Telephone;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@placeholder='Password Confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//label[text()='No']")
	WebElement subscribeNo;
	
	@FindBy(xpath="//label[text()='Yes']")
	WebElement subscribeYes;
	
	@FindBy(linkText = "Privacy Policy")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath="//h4[contains(text(),'Privacy Policy')]")
	WebElement PrivacyPolicy_h4;
	
	//button[text()='×']
	@FindBy(xpath="//button[text()='×']")
	WebElement closeBtn;
	
	public void PersonalDetails(String FirstName,String Lastname,String e_mail,String phone) {
		wait.until(ExpectedConditions.elementToBeClickable(Firstname)).sendKeys(FirstName);
		wait.until(ExpectedConditions.elementToBeClickable(LastName)).sendKeys(Lastname);
		wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(e_mail);
		wait.until(ExpectedConditions.elementToBeClickable(Telephone)).sendKeys(phone);
	}
	
	public void Password(String Password, String ConfirmPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys(ConfirmPassword);
	}
	
	public void Newsletter() {
		if(!subscribeYes.isSelected()){
			wait.until(ExpectedConditions.elementToBeClickable(subscribeYes)).click();
		}
		if(!subscribeNo.isSelected()) {
			wait.until(ExpectedConditions.elementToBeClickable(subscribeNo)).click();
		}
		
	}
	
	public void PrivacyPolicy() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(PrivacyPolicy)).click();
		wait.until(ExpectedConditions.visibilityOf(PrivacyPolicy_h4)); 

		Log.info(PrivacyPolicy_h4.getText());
		
		wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();;
	}
	///////////////////////////////////////////////////////////////////////////////////
	public void dropdowns(String str ){
		WebElement dropdown = driver.findElement(By.id(""));
		Select select = new Select(dropdown);
		if(select.isMultiple()) {
			select.selectByIndex(0);
			select.selectByValue(null);
			select.selectByVisibleText(str);
			select.deselectAll();
		}
		select.selectByVisibleText("");
				
	}
	
	public void alerts() {
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		alert.accept();
		
		alert.dismiss();
		alert.sendKeys(str);
		alert.accept();
	}
}
