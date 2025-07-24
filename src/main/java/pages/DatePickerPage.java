package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public DatePickerPage(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='datePickerMonthYearInput']")
	WebElement dateField;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement yearDropdown;
	
	@FindBy(id="dateAndTimePickerInput")
	WebElement scrollElement;
	
	public void firstDateField(String month,String date,String year) {
		//SendKeys not working
//		dateField.sendKeys(month + "//"+date+"//"+year, Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scrollElement);
		js.executeScript("arguments[0].value='10/16/2000'",dateField);
		//Javascript worked.
	}
	
	public void selectMethod(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void firstDateField() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scrollElement);
		wait.until(ExpectedConditions.elementToBeClickable(dateField)).click();
		wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));
		selectMethod(monthDropdown,"January");
		wait.until(ExpectedConditions.elementToBeClickable(yearDropdown));
		selectMethod(yearDropdown,"2000");
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@role='option']"));
//		int maxCount = 7;
//		for(WebElement date:dates) {
//			if(date.getText().equals("1")) {
//				break;
//			}
//			else {
//				dates.remove(date);
//			}
//		}
		Iterator<WebElement> it = dates.iterator();
		while(it.hasNext()) {
			if(it.next().getText().equals("1")) {
				break;
			}
			else {
				it.remove();
			}
		}
		
		for(WebElement date:dates) {
			if(date.getText().equals("31")) {
				date.click();
			}
		}
		
		
	}
}
